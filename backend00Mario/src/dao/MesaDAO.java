package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import beans.MesaDeVoto;

public class MesaDAO {
	
	private AnnotationConfiguration config;
	private SessionFactory factory;
	private MesaDeVoto mesaDeVoto;
	
	public MesaDAO(){
		this.config= new AnnotationConfiguration();
		this.config.addAnnotatedClass(MesaDeVoto.class);
		this.config.configure("hibernate.cfg.xml");
		this.factory=this.config.buildSessionFactory();
	}
	
	public void guardarMesa(MesaDeVoto mesa){
		Session session= this.factory.getCurrentSession();
		
		session.beginTransaction();
		session.save(mesa);
		session.beginTransaction().commit();
	}	
	
	public List<MesaDeVoto> listarMesas(){
		Session session=this.factory.getCurrentSession();
		session.beginTransaction();
		
		List listaMesas=session.createQuery("from MESA_DE_VOTO").list();
		session.beginTransaction().commit();
		
		return listaMesas;
		
		
	}

}
