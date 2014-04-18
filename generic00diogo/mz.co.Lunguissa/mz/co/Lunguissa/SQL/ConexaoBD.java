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
	
	public static Vector<Mesa> provincias;
	public static Vector <String> nomes =new Vector<String>();
	
	/**
	 * 
	 * Metodo que ira retornar um vector contendo os elementos pesquisados na Base de dados 
	 */
	public static Vector<Mesa> consultaBD(){
	mesas=new Vector();
	Thread n= new Thread();
    for (int i=0; i<3000;i++)
    {	if(i==1000){
		try {
			n.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	System.out.println("Conectando a Base de dados :::20%");
	}
    	
    }
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
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("insert into mesavoto (Provincia,Distrito,Localidade,Voto) values (?,?,?,?)");
			    Thread n= new Thread();
			    for (int i=0; i<5000;i++)
			    {	if(i==1000){
		    		try {
						n.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	System.out.println("Processando o Voto :::20%");
		    	}
			    if(i==2000){
		    		try {
						n.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	System.out.println("Processando  o Voto ::::::::50%");
		    	}
			    	if(i==4000){
			    		try {
							n.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	System.out.println("Processando o Voto :::::::::::::::80%");
			    	}
			    	if(i==5000){
			    		try {
							n.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	System.out.println("Processando o Voto :::::::::::::::90%");
			    	}
			    }
			 // preenche os valores
				stmt.setString(1,voto.getProvincia());
				stmt.setString(2,voto.getDistrito());
				stmt.setString(3,voto.getLocalidade());
				stmt.setInt(4,voto.getVotos());
				// executa
				stmt.execute();
				stmt.close();
				System.out.println("Voto efectuado com Sucesso!!");
				System.out.println("O seu Voto faz a diferenca!!");
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
	/**
	 * 
	 * Metodo que ira gravar provincias num ficheiro apartir do array temporario provincias
	 */
	public  static void GravarProvincias(Vector provincia) throws IOException
	{
		File binaryFile=null;
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try{
		 binaryFile=new File("provincia.dat");
		 fos=new FileOutputStream(binaryFile);
		 oos=new ObjectOutputStream(fos);
		oos.writeObject(provincia);
		} catch(IOException ex){
			ex.printStackTrace();
		} finally{
			try{ fos.close();
			oos.close();
		}catch(IOException ex){
			ex.printStackTrace();}
		}
	}
	/**
	 * 
	 * Metodo que ira buscar informacao num ficheiro e armazenar num array temporario
	 */
	public static void  LerProvicias() throws ClassNotFoundException, IOException
	{		FileInputStream fis=null;
		ObjectInputStream ois=null;
			File binaryFile=new File("provincia.dat");
			 fis= new FileInputStream(binaryFile);
			ois=new ObjectInputStream(fis);
			
			provincias = (Vector<Mesa>) ois.readObject();
			fis.close();
			ois.close();
	}
	
	public static void actualizarBD(Mesa voto)
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost/eleicoes","root", "benfica");
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("UPDATE mesavoto SET Voto = ? WHERE id = ?");
			   
			 // preenche os valores
				stmt.setInt(1,voto.getVotos());
				stmt.setInt(2,voto.getId());
				
				// executa
				stmt.execute();
				stmt.close();
				System.out.println("Voto efectuado com Sucesso!!");
				System.out.println("O seu Voto faz a diferenca!!");
				con.close();
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Falha na Conexao a Base de dados SQL");
		} 
		catch (SQLException e) 
		{	System.out.println(e.getMessage());
			System.out.println("Falha no servidor");
		}
	}
	
	public static Vector preencheNomes()
	{
		
		nomes.add("Cabo Delgado");
		nomes.add("Gaza");
		nomes.add("Inhambane");
		nomes.add("Manica");
		nomes.add("Maputo Cidade");
		nomes.add("Maputo");
		nomes.add("Niassa");
		nomes.add("Sofala");
		nomes.add("Tete");
		nomes.add("Zambezia");
		
		
		
		return nomes;
	}
}
