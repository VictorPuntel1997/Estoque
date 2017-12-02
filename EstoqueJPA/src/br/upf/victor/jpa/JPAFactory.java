package br.upf.victor.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAFactory {

private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("EstoqueJPA");
	
	public static EntityManager getEntityManager(){
		return factory.createEntityManager();
	}

}
