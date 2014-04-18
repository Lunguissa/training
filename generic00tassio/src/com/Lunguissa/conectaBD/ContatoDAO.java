package com.Lunguissa.conectaBD;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.Lunguissa.mesaVoto.Mesa;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ContatoDAO
{
	private Connection con;
	
	public ContatoDAO() throws SQLException{
		this.con=(Connection) BdConecta.geConnection();
	}
	
	public void adiciona(Mesa mesa) throws SQLException{
		java.sql.PreparedStatement stmt=this.con.prepareStatement("insert into mesavoto (p_id,d_id,localidade,votos) values(?,?,?,?)");
		
		
		stmt.setLong(1, mesa.getp_id());
		stmt.setLong(2, mesa.getd_id());
		stmt.setString(3, mesa.getLocalidade());
		stmt.setLong(4, mesa.getVotos());
		
		stmt.execute();
		stmt.close();
	
	}
	
	public void ler() throws SQLException{
		Statement selectStmt=(Statement) this.con.createStatement();
		
		 ResultSet rs = ((java.sql.Statement) selectStmt).executeQuery("select provincias.provincia,distritos.distritos,mesavoto.localidade,"
					+ "mesavoto.votos from provincias inner join mesavoto on provincias.id=mesavoto.p_id inner join distritos on distritos.id=mesavoto.d_id;");
         while(rs.next())
         {
             System.out.print(rs.getString(1)+" ");    
             System.out.print(rs.getString(2)+" ");    
             System.out.print(rs.getString(3)+" ");    
             System.out.println(rs.getString(4));    
         }
		try {
			selectStmt.close();
			con.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
	
	}
	
	public void lerPronvincias() throws SQLException{
		
		Statement selectStmt=(Statement) this.con.createStatement();
		
		 ResultSet rs = ((java.sql.Statement) selectStmt).executeQuery("select id,provincia from provincias;");
         while(rs.next())
         {
             System.out.print(rs.getString(1)+" ");    
             System.out.println(rs.getString(2));    
                 
         }
		try {
			selectStmt.close();
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	
	}
	
	public void lerDistritos() throws SQLException{
		Statement selectStmt=(Statement) this.con.createStatement();
		
		 ResultSet rs = ((java.sql.Statement) selectStmt).executeQuery("select id,distritos from distritos;");
         while(rs.next())
         {
             System.out.print(rs.getString(1)+" ");    
             System.out.println(rs.getString(2));    
                 
         }
		try {
			selectStmt.close();
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	
	}
	
	
	
	
	
	
}
