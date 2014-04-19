package mz.com.lunguissa.baseDados;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mz.co.lunguissa.objectos.Mesa;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class ContatoDAO {
	// a conex ã o com o banco de dado
	private Connection connection;
	
	
	public ContatoDAO()throws SQLException{
		this.connection=ConnectionFactory.getCOnnection();
		
	}
	public void adicionar(Mesa mesa)throws SQLException{
		
		{
			PreparedStatement stmt= (PreparedStatement) this.connection.prepareStatement("insert into mesavotos (Provincia,Distrito,Votos) values (?,?,?)");
		stmt.setString(1, mesa.getProvincia());
		stmt.setString(2, mesa.getDistrito());
		stmt.setInt(3, mesa.getVOTO());
		
		stmt.execute();
		stmt.close();
		}
		
	}
	
	public void altera(Mesa mesa) throws SQLException{
		// String sql1 = "UPDATE tarefa SET progresso=?,estado=? WHERE id=?";
		//PreparedStatement stmt= (PreparedStatement) connection.prepareStatement("UPDATE mesa2 set  VotosFrelimo=?, VotosMdm=?, VotosRenamo=?,TotalVotos=? WHERE idmesa2=?");
		
		//String sql= "UPDATE mesa2 SET  VotosFrelimo=?, VotosMdm=?, VotosRenamo=?,TotalVotos=? WHERE idmesa2=?";
		String sql="Update mesa2 set VotosFrelimo=?,VotosMdm=?,VotosRenamo=?,TotalVotos=? where idmesa2=?";
        try {
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
           
		
		stmt.setString(1, mesa.getPartidoFrelimo());
		stmt.setString(2, mesa.getPartidoMdm());
		stmt.setString(3, mesa.getPartidoRenamo());
		stmt.setString(4, mesa.getPartido());
		stmt.setInt(5, 1);
		
		   try {
               stmt.execute();
               stmt.close();
     
           }  
           catch (Exception ex){
        	   ex.printStackTrace();  
           }
       }
       catch (Exception ex){
           ex.printStackTrace();
       }
   }
	public List<Mesa> getLista() throws SQLException{
		PreparedStatement stmt= (PreparedStatement) this.connection.prepareStatement("select * from mesa2");
		ResultSet rs= (ResultSet) stmt.executeQuery();
		List <Mesa> Mesas= new ArrayList<Mesa>();
		while (rs.next()) {
			Mesa mesa= new Mesa();
			mesa.setPartidoFrelimo(rs.getString("VotosFrelimo"));
			mesa.setPartidoFrelimo(rs.getString("VotosMdm"));
			mesa.setPartidoFrelimo(rs.getString("VotosRenamo"));
			mesa.setPartidoFrelimo(rs.getString("TotalVotos"));
			Mesas.add(mesa);
			
		}
		
		rs.close();
		stmt.close();
		return Mesas;}

}
