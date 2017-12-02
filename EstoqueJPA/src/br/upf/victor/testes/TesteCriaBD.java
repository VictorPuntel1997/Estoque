package br.upf.victor.testes;

import br.upf.victor.jpa.JPAFactory;

public class TesteCriaBD {

	public static void main(String[] args) {
		JPAFactory.getEntityManager();
		System.exit(0);

	}

}
