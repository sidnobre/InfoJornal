package br.ufc.quixada.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NoticiaDAOTest {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		
		
		manager.getTransaction().commit();
	}
}
