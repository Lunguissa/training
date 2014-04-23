package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.MesaDeVoto;

public class MesaHibernate {

	Session session= HibernateUtil.getSessionFactory().openSession();
	Transaction transaction=null;
	
	public void saveMesaDeVoto(MesaDeVoto mesa){
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction= null;
		
		try{
			transaction= session.beginTransaction();
			session.save(mesa);
			transaction.commit();
		}catch (HibernateException e){
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	@SuppressWarnings("unchecked")
	public List<MesaDeVoto> listarMesas()
	{
		Session session= HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=null;
		List<MesaDeVoto> listaDeMesas= new ArrayList<>();
		try{
			transaction=session.beginTransaction();
			listaDeMesas=session.createQuery("from mesa_de_voto").list();
		
			transaction.commit();
		}
		catch(HibernateException e) 
		{
			transaction.rollback();
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
		return listaDeMesas;
	}
	private void actualizarMesa(int id,String provincia, String localidade, String distrito)
	{
		Session session= HibernateUtil.getSessionFactory().openSession();
		Transaction transaction= null;
		try{
			transaction = session.beginTransaction();
			MesaDeVoto mesa= (MesaDeVoto) session.get(MesaDeVoto.class,id);
			mesa.setProvincia(provincia);
			mesa.setDistrito(distrito);
			mesa.setLocalidade(localidade);
			transaction.commit();
		}
		catch(HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
	}
		
		private void actualizarMesa(int id)
		{
			Session session= HibernateUtil.getSessionFactory().openSession();
			Transaction transaction= null;
			try
			{
				transaction= session.beginTransaction();
				MesaDeVoto mesa= (MesaDeVoto) session.get(MesaDeVoto.class, id);
				session.delete(mesa);
				transaction.commit();
			}
			catch(HibernateException e)
			{
				transaction.rollback();
				e.printStackTrace();
			}
			finally
			{
				session.close();
			}		
		}
	}

