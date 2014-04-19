package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import beans.Conexao;

public class ConexaoDAO {
	
	    private String driver = "com.mysql.jdbc.Driver";
	    private String url = "jdbc:mysql://localhost/mesas_de_voto";
	    private String usuario = "mario";
	    private String senha = "lunguissa";
	    
	    Conexao con = new Conexao(driver, url, usuario, senha);
	    
	    public Connection conexao;
	    public Statement statement;
	    public ResultSet resultSet;
	    
	    public boolean conectar(){
	        
	        boolean resultado = true;
	        try{
	            Class.forName(driver);            
	            conexao = DriverManager.getConnection(url, usuario, senha);
	           System.out.println("Connected to Database");
	            // JOptionPane.showMessageDialog(null, "Conectado");
	        }catch(ClassNotFoundException Driver){
	            JOptionPane.showMessageDialog(null, "Driver nao encontrado");
	            resultado = false;
	        }catch(SQLException Fonte){
	            JOptionPane.showMessageDialog(null, "Erro na conexao ");
	            resultado = false;
	        }
	        
	        return resultado;
	    }
	    
	    public void desconectar(){
	        boolean resultado = true;
	        try{
	            conexao.close();
	            System.out.println("Connection Closed");
	        }catch(SQLException errosql){
	            JOptionPane.showMessageDialog(null, "Erro ao fechar conexao");
	            resultado = false;
	        }        
	    }
	    
	    public void executarSQL(String query){
	        try{
	            statement = conexao.createStatement();
	            resultSet = statement.executeQuery(query);
	        }catch(SQLException sql){
	            JOptionPane.showMessageDialog(null, "Erro na Query de Execucao");
	        }
	    }
	    
	    public void criarStatement(){
	        try {
	            this.statement = conexao.createStatement();
	        } catch (SQLException ex) {
	            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }       
	    }
	    
}

