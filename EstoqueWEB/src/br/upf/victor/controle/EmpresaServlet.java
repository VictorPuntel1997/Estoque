package br.upf.victor.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.upf.victor.beans.Empresa;
import br.upf.victor.dao.GenericDao;

/**
 * Servlet implementation class EmpresaServlet
 */
@WebServlet("/Admin/Empresa/EmpresaServlet")
public class EmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpresaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Empresa> empresas = new ArrayList<>();
		GenericDao<Empresa> dao = new GenericDao<>(Empresa.class);
		
		// 1 - Descobrir qual a operação e executar
				String oper = request.getParameter("oper");
				oper = oper == null ? "listar" : oper;
				String abrir = "";
				switch (oper){
					case "listar": 
						// fazer operação
						empresas = dao.getInstanciasList();
						abrir="ListEmpresa.jsp"; 
					    break;
					case "novo":
						// fazer operação
						abrir="FormEmpresa.jsp";
						break;
					case "gravar":{
						// fazer operacão
					    Empresa r = new Empresa( 
					    		request.getParameter("id").trim().isEmpty() ? null : Integer.parseInt(request.getParameter("id")), 
					    		request.getParameter("nome"), 
					    		request.getParameter("endereco"),
					    		request.getParameter("telefone"),
					    		request.getParameter("cnpj"));
						if (r.getNome().length()<=0){
							request.setAttribute("erro", "O nome é obrigatório!");
							abrir="FormEmpresa.jsp";
							request.setAttribute("empresa", r);
						}
						else
							try {
								dao.merge(r);
								empresas = dao.getInstanciasList();
								abrir="ListEmpresa.jsp";
							} catch (Exception e) {
								abrir="FormEmpresa.jsp";
								request.setAttribute("empresa", e);
								request.setAttribute("erro", e.getMessage());
							}
						break;
			    	}case "excluir": {
						try {
							dao.remove(Integer.parseInt(request.getParameter("id")));
						} catch (Exception e) {
							request.setAttribute("erro", e.getMessage());
						}
						empresas = dao.getInstanciasList();
						abrir="ListEmpresa.jsp";
						break;
					} case "alterar":
						try {
							Empresa r = dao.getInstancia(Integer.parseInt(request.getParameter("id")));
							request.setAttribute("empresa", r); // colocar na requisição para o JSP usar
							abrir="FormEmpresa.jsp";
						} catch (Exception e) {
							request.setAttribute("erro", e.getMessage());
							empresas = dao.getInstanciasList();
							abrir="ListEmpresa.jsp";
						}
						
						break;
						
				}
		        request.getSession().setAttribute("empresas", empresas);
				
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
