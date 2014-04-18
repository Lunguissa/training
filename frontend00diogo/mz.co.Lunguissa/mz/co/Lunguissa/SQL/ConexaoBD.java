package mz.co.Lunguissa.SQL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

import mz.co.Lunguissa.Classes.Mesa;
import mz.co.Lunguissa.Classes.Provincia;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * 
 * @author Diogo Amaral
 *
 */

public class ConexaoBD
{	
	/**
	 * Declaracao de Vectores que irao aramazenar informacao temporaria
	 */
	public static Vector mesas;
	
	public static Vector<Provincia> provincias = new Vector<Provincia>();
	public static Vector <String> nomes =new Vector<String>();
	
	/**
	 * 
	 * Metodo que ira retornar um vector contendo os elementos pesquisados na Base de dados 
	 */
	public static Vector consultaBD(){
	mesas=new Vector();
	Connection conn = null;
	String teste = "SELECT * FROM mesavoto";
	try {
	Class.forName("com.mysql.jdbc.Driver");
	conn =
	(Connection) DriverManager.getConnection("jdbc:mysql://localhost/eleicoes","root", "benfica");
	System.out.println("Conectado:::::::::::::::::::::::100%");
	Statement stm = (Statement) conn.createStatement();
	ResultSet rs = (ResultSet) stm.executeQuery(teste);
	while (rs.next()) {
		
	int id=rs.getInt("id");	
	String provincia = rs.getString("Provincia");
	String distrito= rs.getString("Distrito");
	String localidade = rs.getString("Localidade");
	int voto = rs.getInt("Voto");
	
	mesas.add(new Mesa(id,provincia, distrito, localidade, voto));
	}
	
	} catch(ClassNotFoundException e) {
	System.out.println("excessão Classe não encontrada");
	e.printStackTrace();
	} catch(SQLException e) {
	System.out.println("SQL Exception... Erro na consulta:");
	e.printStackTrace();
	} finally {
	try {
	conn.close();
	} catch(SQLException erro) {
	System.out.println("Erro no fechamento");
	erro.printStackTrace();
	}
	}
	
	return mesas;
	
		}
	/**
	 * 
	 * Metodo responsavel pela insercao de Um voto em uma Mesa de Votaocao na Base de dados 
	 */
	public static void inserirBD(Mesa voto)
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost/eleicoes","root", "benfica");
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("insert into mesavoto (Provincia,Distrito,Localidade,voto) values (?,?,?,?)");
			 // preenche os valores
				stmt.setString(1,voto.getProvincia());
				stmt.setString(2,voto.getDistrito());
				stmt.setString(3,voto.getLocalidade());
				stmt.setInt(4,voto.getVotos());
				// executa
				stmt.execute();
				stmt.close();
				con.close();
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Falha na Conexao a Base de dados SQL");
		} 
		catch (SQLException e) 
		{
			System.out.println("Falha no servidor");
		}
	}

}
