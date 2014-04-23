package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import beans.MesaDeVoto;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
	static {
		try { 
			sessionFactory=new AnnotationConfiguration().configure("hibernate.cfg.xml").addPackage("beans").addAnnotatedClass(MesaDeVoto.class).buildSessionFactory(); 
		}catch(Throwable ex){
			System.err.println("Falha na Criacao da sessao inicial" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
