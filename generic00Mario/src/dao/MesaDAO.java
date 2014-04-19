package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import beans.MesaDeVoto;

public class MesaDAO {
	
	private ConexaoDAO conexao= new ConexaoDAO();
	
	public void inserirMesaVotoBD(MesaDeVoto mesa) throws SQLException
	{
		this.conexao.conectar();
		this.conexao.criarStatement();
		
		//query de insercao de dados na tabela mesa_de_voto
		String query="insert into mesa_de_voto (provincia,distrito,localidade, numeroDeVotos) values ("
		+"'"+ mesa.getProvincia() +"', '"+mesa.getDistrito()+"', '"+ mesa.getLocalidade()+"', "+ mesa.getNumeroDeVotos() +")";
		
		this.conexao.statement.executeUpdate(query);
		System.out.println("Dados da Mesa Inseridos com sucesso na base de dados");
		
		this.conexao.desconectar();
	}
	
	
	public List<MesaDeVoto> obterMesasDeVoto() throws SQLException
	{
		List<MesaDeVoto> listaMesaDeVoto=new ArrayList<>();
		this.conexao.conectar();
		
		String query="select provincia, distrito, localidade, numeroDeVotos from mesa_de_voto";
		
		this.conexao.executarSQL(query);
		
		
		while(this.conexao.resultSet.next())
		{
			MesaDeVoto mesa=new MesaDeVoto();
			mesa.setProvincia(this.conexao.resultSet.getString("provincia"));
			mesa.setDistrito(this.conexao.resultSet.getString("distrito"));
			mesa.setLocalidade(this.conexao.resultSet.getString("localidade"));
			mesa.setNumeroDeVotos(this.conexao.resultSet.getInt("numeroDeVotos"));
			
			listaMesaDeVoto.add(mesa);	
		}
		this.conexao.desconectar();
		return listaMesaDeVoto;
		
	}
	
	//Nota este metodo a primeira não faz muito 
	public MesaDeVoto consultarMesaDeVoto(int id) throws SQLException
	{
		this.conexao.conectar();
		String query="select provincia, distrito, localidade, numeroDeVotos from mesa_de_voto where idMesa="+id;
		MesaDeVoto mesa=new MesaDeVoto();
		
		this.conexao.executarSQL(query);
		
		
		while(this.conexao.resultSet.next())
		{
			mesa.setProvincia(this.conexao.resultSet.getString("provincia"));
			mesa.setDistrito(this.conexao.resultSet.getString("distrito"));
			mesa.setLocalidade(this.conexao.resultSet.getString("localidade"));
			mesa.setNumeroDeVotos(this.conexao.resultSet.getInt("numeroDeVotos"));
		}
		this.conexao.desconectar();
		return mesa;
	}

}
