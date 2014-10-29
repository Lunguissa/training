package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.teste.model.Producto;

public class Testpro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("hibernatetest");
		EntityManager em= factory.createEntityManager();
		
		Producto p= new Producto();
		p.setNome("bola");
		p.setPreco(40.11);
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

}
