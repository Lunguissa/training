package mz.com.lunguissa.baseDados;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {
	

	public static Connection getCOnnection() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
			return (Connection) DriverManager.getConnection("jdbc:mysql://localhost/votos","root","Fernandes");
	
	}

}
