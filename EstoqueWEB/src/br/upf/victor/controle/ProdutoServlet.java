package br.upf.victor.controle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upf.victor.beans.Produto;
import br.upf.victor.dao.GenericDao;
import br.upf.victor.beans.Empresa;

/**
 * Servlet implementation class ProdutoServlet
 */
@WebServlet("/Admin/Produto/ProdutoServlet")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Produto> produtos = new ArrayList<>();
		List<Empresa> empresas = new ArrayList<>();
		
		GenericDao<Produto> dao = new GenericDao<>(Produto.class);
		GenericDao<Empresa> daoEmpresa = new GenericDao<>(Empresa.class);
		
		// 1 - Descobrir qual a operação e executar
				String oper = request.getParameter("oper");
				oper = oper == null ? "listar" : oper;
				String abrir = "";
				switch (oper){
					case "listar": 
						// fazer operação
						produtos = dao.getInstanciasList();
						abrir="ListProduto.jsp"; 
					    break;
					case "novo":
						// fazer operação
						empresas = daoEmpresa.getInstanciasList("nome");
						request.setAttribute("empresas", empresas);
						abrir="FormProduto.jsp";
						break;
					case "gravar":{
						// fazer operacão
						try{
					    Produto p = new Produto( 
					    		request.getParameter("id").trim().isEmpty() ? null : Integer.parseInt(request.getParameter("id")), 
					    		request.getParameter("nome"), 
					    		Integer.parseInt(request.getParameter("quantidade")),
					    		Integer.parseInt(request.getParameter("preco")),
					    		new Empresa(Integer.parseInt(request.getParameter("empresa"))));
						 
					    		
					    		
						if (p.getNome().length()<=0){
							request.setAttribute("erro", "O nome é obrigatório!");
							abrir="FormProduto.jsp";
							request.setAttribute("produto", p);
						}
						else
							try {
								dao.merge(p);
								produtos = dao.getInstanciasList();
								abrir="ListProduto.jsp";
							} catch (Exception e) {
								e.printStackTrace();
								abrir="FormProduto.jsp";
								request.setAttribute("produto", p);
								request.setAttribute("erro", e.getMessage());
							}
						break;
						}catch(Exception e) {  
						    e.printStackTrace();  //imprimi a stack trace
						} 
			    	}case "excluir": {
						try {
							dao.remove(Integer.parseInt(request.getParameter("id")));
						} catch (Exception e) {
							request.setAttribute("erro", e.getMessage());
						}
						produtos = dao.getInstanciasList();
						abrir="ListProduto.jsp";
						break;
					} case "alterar":
						try {
							Produto r = dao.getInstancia(Integer.parseInt(request.getParameter("id")));
							request.setAttribute("produto", r); // colocar na requisição para o JSP usar
							empresas = daoEmpresa.getInstanciasList("nome");
							request.setAttribute("empresas", empresas);
							abrir="FormProduto.jsp";
						} catch (Exception e) {
							request.setAttribute("erro", e.getMessage());
							produtos = dao.getInstanciasList();
							abrir="ListProduto.jsp";
						}
						
						break;
						
				}
		        request.getSession().setAttribute("produtos", produtos);
				
				// 2 - Encaminhar para JPS dar resposta
				//response.sendRedirect(abrir);
				request.getRequestDispatcher(abrir).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
