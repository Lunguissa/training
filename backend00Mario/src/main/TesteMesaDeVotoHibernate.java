package main;

import java.util.List;

import beans.MesaDeVoto;
import dao.MesaDAO;

public class TesteMesaDeVotoHibernate {

	public static void main(String[] args) {

		//AnnotationConfiguration config=new AnnotationConfiguration();
		//config.addAnnotatedClass(beans.MesaDeVoto.class);
		//config.configure("hibernate.cfg.xml");
		
		//new SchemaExport(config).create(true, true);
	
	//	SessionFactory factory =config.buildSessionFactory();
		//Session session = factory.getCurrentSession();
		
	//	session.beginTransaction();
		
		MesaDeVoto mesa= new MesaDeVoto();
		
		mesa.setDistrito("Monampua");
		mesa.setLocalidade("XINARIO");
		mesa.setProvincia("Nampula");
		mesa.setNumeroDeVotos(412213);
		
	//	session.save(mesa);
	//  session.beginTransaction().commit();
		
		MesaDAO mesaDAO= new MesaDAO();
		
		//mesaDAO.guardarMesa(mesa);
		
		List<MesaDeVoto> mesas=  mesaDAO.listarMesas();
		
		for(MesaDeVoto listar: mesas)
		{
			System.out.println(listar.toString()+"=============================\n");
		}
		
	}

}
