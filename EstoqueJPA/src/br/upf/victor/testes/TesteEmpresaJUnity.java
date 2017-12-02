package br.upf.victor.testes;



import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.upf.victor.beans.Empresa;
import br.upf.victor.jpa.JPAFactory;
import junit.framework.Assert;

public class TesteEmpresaJUnity {

	String tEmpresaNome = "Empresa1";

	@Test
	public void incluir() {
		Empresa a = new Empresa(null,"Empresa1","Rua Teste1","21086666","99054540");
		EntityManager em  = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
		
		Assert.assertEquals(tEmpresaNome, a.getNome());
	}
	
	
}
