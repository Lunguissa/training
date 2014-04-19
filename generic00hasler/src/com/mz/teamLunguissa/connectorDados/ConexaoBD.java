package com.mz.teamLunguissa.connectorDados;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.mz.teamLunguissa.model.MesaVoto;

public class ConexaoBD
{
	private static Connection conexao;
	private static int totalDeVotos;
	
	/**
	 * Abri conexao para a base de dados
	 */
	private static void conectar()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conexao=DriverManager.getConnection("jdbc:mysql://localhost/eleicoes","root","choo");
		} 
		catch (SQLException e)
		{
			System.out.println("Erro na aplicacao, falta de ficheiros");
		} 
		catch (ClassNotFoundException e)
		{
			System.out.println("Erro na aplicacao, falta de ficheiros");
		}
			
	}
	
	/**
	 * Disconecta a base de dados
	 */
	private static void disconectar()
	{
		try 
		{
			conexao.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * addicona uma nova entidade a base de dados
	 * @param nova a entidade a ser adicionada
	 */
	public static void gravarMesa(MesaVoto nova)
	{
		conectar();
		String insertTableSQL = "insert into mesaVoto (Provincia, Distrito, Localidade, MesaVoto,NumeroVoto) value (?,?,?,?,?)";
		try {
			PreparedStatement prepararMesa = (PreparedStatement) conexao.prepareStatement(insertTableSQL);
			prepararMesa.setString(1, nova.getProvincia());
			prepararMesa.setString(2, nova.getDistrito());
			prepararMesa.setString(3, nova.getLocalidade());
			prepararMesa.setString(4, nova.getNomeMesa());
			prepararMesa.setInt(5, 0);
			prepararMesa .executeUpdate();
			System.out.println("Mesa adicionada");
			disconectar();
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
		
	}
	
	/**
	 * mostra dados de uma mesa e calcula o numero de votos
	 * @param mesa caso quiser vizualizar apenas resultados de uma mesa
	 * @param imprimir true se quiser ver os resultados dos votos , false se nao quiser vizualizar os resultados de votos
	 */
	public static void lerMesas(String mesa,boolean imprimir)
	{
		conectar();
		String query = "SELECT MesaVoto,NumeroVoto from mesaVoto";
		if (!mesa.equals("")) 
		{
			query = query+" where MesaVoto='"+mesa+"'";
		}
		int totalVotos=0;
		try 
		{
			Statement frase =(Statement) conexao.createStatement();
			ResultSet rs = frase.executeQuery(query);
			if (imprimir)
			System.out.println("------------------------------------------------");
			while (rs.next()) 
			{
				String mesaVoto = rs.getString("MesaVoto");
				int voto = rs.getInt("NumeroVoto");
				if (imprimir)
				System.out.println(mesaVoto+" teve : "+voto+" votos");
				totalVotos+=voto;
			}
			totalDeVotos=totalVotos;
			
			if (imprimir)
				System.out.println("------------------------------------------------");
			if (imprimir && mesa.equals(""))
			{

				System.out.println("Numero total de Votos: "+totalVotos);
				System.out.println("------------------------------------------------");
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	
		disconectar();
	}
	
	/**
	 * Busca na base de dados nome de todas mesas
	 * @return retorna um ArrayList com os nomes das mesas
	 */
	public static ArrayList<String> imprimirMesas()
	{
		conectar();
		String query = "SELECT MesaVoto,NumeroVoto from mesaVoto";
		ArrayList <String> dados= new ArrayList<String>();
		try 
		{
			Statement frase =(Statement) conexao.createStatement();
			ResultSet rs = frase.executeQuery(query);

			while (rs.next()) 
			{
				dados.add(rs.getString("MesaVoto"));
			}

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	
		disconectar();
		return dados;
	}
	
	
	/**
	 * Adiciona um voto na base de dados
	 * @param mesa mesa que vai ser adicionada um voto
	 * */
	public static void votar(String mesa)
	{
		conectar();
		String updateTableSQL = "update mesaVoto set NumeroVoto = ? WHERE mesaVoto = ?";

		try 
		{
			PreparedStatement preparedStatement = (PreparedStatement) conexao.prepareStatement(updateTableSQL);

			preparedStatement.setInt(1, totalDeVotos+1);
			preparedStatement.setString(2, mesa);
			
			preparedStatement .executeUpdate();
			System.out.println("Votou");
			disconectar();
			System.out.println("\nVotou\n");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
