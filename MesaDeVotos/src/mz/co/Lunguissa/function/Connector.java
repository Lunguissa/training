package mz.co.Lunguissa.function;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import mz.co.Lunguissa.entity.MesaDeVoto;


public class Connector {
  private static Connection connect = null;
  private static Statement statement = null;


  public static void connection() throws Exception{
	  try{
		  System.out.println("loading driver..");
		  Class.forName("com.mysql.jdbc.Driver");
		  System.out.println("getting connection..");
		  connect =(Connection) DriverManager.getConnection("jdbc:mysql://localhost/votacao","sqluser", "sqluserpw");
	  }
	  
	  catch(Exception e){
		  e.printStackTrace();
	  }
	  
	  finally{
		  System.out.println("connected..");
		 
	  }
	  
  }
  
  public static void write(MesaDeVoto mesa){
	  try{
		  
		  	PreparedStatement stmnt = connect.
		  			prepareStatement("insert into votacao.mesa (PROVINCIA,DISTRICTO,LOCALIDADE,NRVOTOS) values (?,?,?,?)");
		  	stmnt.setString(1, mesa.getProv());
		  	stmnt.setString(2, mesa.getDis());
		  	stmnt.setString(3, mesa.getLocal());
		  	stmnt.setInt(4, mesa.getNrVotos());
		  	System.out.println("preparing..");
		  	stmnt.execute();
		  	System.out.println("executing..");
		  	
	  }
	  catch(SQLException e){
		  System.out.println("sql exception..");
	  }
	  finally{
		  System.out.println("adicionado..");
	  }
  }
  
  public static void close(){
	  try{
	  connect.close();
//	  statement.close();
	  
	  System.out.println("closing..");
	  }
	  
	  catch(SQLException e){
		  System.out.println("erro 1..");
		  
	  }
  }
	  
//  public static void main(String arg[]){
//	  try {
//		connection();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		System.out.println("erro");
//		e.printStackTrace();
//	}
//  }
//  
}
















