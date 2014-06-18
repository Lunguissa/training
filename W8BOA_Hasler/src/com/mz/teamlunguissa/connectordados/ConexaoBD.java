package com.mz.teamlunguissa.connectordados;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mz.teamlunguissa.bean.Funcionario;
import com.mz.teamlunguissa.bean.Horario;
import com.mz.teamlunguissa.bean.Material;

public class ConexaoBD {
	private static Connection conexao;
	private static int totalDeVotos;
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String LOCALHOST = "jdbc:mysql://localhost/";
	private static final String BASEDEDADOS = "gym";
	private static final String USER = "root";
	private static final String SENHA = "choo";

	/**
	 * Abri conexao para a base de dados
	 */
	private static void conectar() {
		try {
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(LOCALHOST + BASEDEDADOS,
					USER, SENHA);
		} catch (SQLException e) {
			System.out.println("Erro na aplicacao, falta de ficheiros");
		} catch (ClassNotFoundException e) {
			System.out.println("Erro na aplicacao, falta de ficheiros");
		}

	}

	/**
	 * Disconecta a base de dados
	 */
	private static void disconectar() {
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * addicona uma novo funcionario
	 * 
	 * @param nova
	 *            a entidade a ser adicionada
	 */
	public static void gravarFuncionario(Funcionario funcionario) {
		conectar();
		String insertTableSQL = "insert into funcionario (Nome, Apelido, NumCell, dataNascimento,Sexo,Exeperiencia) value (?,?,?,?,?,?)";
		try {
			PreparedStatement preparar = (PreparedStatement) conexao
					.prepareStatement(insertTableSQL);
			preparar.setString(1, funcionario.getNome());
			preparar.setString(2, funcionario.getApelido());
			preparar.setInt(3, funcionario.getNumero());
			preparar.setDate(4, (Date) funcionario.getDataNascimento());
			preparar.setString(5, funcionario.getSexo());
			preparar.setString(6, funcionario.getExperiencia());
			preparar.executeUpdate();
			System.out.println("Funcionario addicionado");
			disconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * actualiza um funcionario
	 * 
	 * @param funcionario
	 */
	public static void actualizarFuncionario(Funcionario funcionario) {
		conectar();
		String insertTableSQL = "update  funcionario set Nome=?, Apelido=?, NumCell=?, dataNascimento=?,Sexo=?,Exeperiencia=? where id=?";
		try {
			PreparedStatement preparar = (PreparedStatement) conexao
					.prepareStatement(insertTableSQL);
			preparar.setString(1, funcionario.getNome());
			preparar.setString(2, funcionario.getApelido());
			preparar.setInt(3, funcionario.getNumero());
			preparar.setDate(4, (Date) funcionario.getDataNascimento());
			preparar.setString(5, funcionario.getSexo());
			preparar.setString(6, funcionario.getExperiencia());
			preparar.setInt(7, funcionario.getId());
			preparar.executeUpdate();
			System.out.println("Funcionario addicionado");
			disconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Funcionario> lerFuncionario(String filtro) {
		conectar();

		String query = "";

		if (!filtro.equals("")) {
			query = "SELECT * from funcionario";
		} else if (filtro.equals("sexo")) {
			query = "SELECT * from funcionario where sexo='" + filtro + "'";
		} else {
			query = "SELECT * from funcionario where sexo='" + filtro + "'";
		}

		ArrayList<Funcionario> dados = new ArrayList<Funcionario>();
		try {
			Statement frase = (Statement) conexao.createStatement();
			ResultSet rs = frase.executeQuery(query);

			while (rs.next()) {
				dados.add(new Funcionario(rs.getString("nome"), rs
						.getString("apelido"), rs.getInt("NumCell"), rs
						.getDate("dataNascimento"), rs.getString("sexo"), rs
						.getString("experiencia"), rs.getInt("id")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconectar();
		return dados;
	}

	public void removeFuncionario(int id) {
		conectar();
		PreparedStatement stmt;
		try {
			stmt = conexao
					.prepareStatement("delete from funcionario where id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		disconectar();
	}

	/**
	 * Addiciona um novo material
	 * 
	 * @param material
	 */
	public static void gravarMaterial(Material material) {
		conectar();
		String insertTableSQL = "insert into material (Nome,descricacao,categoria,qualidade,id) value (?,?,?,?,?)";
		try {
			PreparedStatement preparar = (PreparedStatement) conexao
					.prepareStatement(insertTableSQL);
			preparar.setString(1, material.getNome());
			preparar.setString(2, material.getDescricao());
			preparar.setString(3, material.getCategoria());
			preparar.setInt(4, material.getQuantidade());
			preparar.setInt(5, material.getId());
			preparar.executeUpdate();
			System.out.println("Material addicionado");
			disconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Addiciona um novo material
	 * 
	 * @param material
	 */
	public static void actualizarMaterial(Material material) {
		conectar();
		String insertTableSQL = "update material set nome=?, descricacao=?, categoria=?,qualidade=?  where id=?";
		try {
			PreparedStatement preparar = (PreparedStatement) conexao
					.prepareStatement(insertTableSQL);
			preparar.setString(1, material.getNome());
			preparar.setString(2, material.getDescricao());
			preparar.setString(3, material.getCategoria());
			preparar.setInt(4, material.getQuantidade());
			preparar.setInt(5, material.getId());
			preparar.executeUpdate();
			System.out.println("Material actualizado");
			disconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<Material> lerMaterial() {
		conectar();

		String query = "";

		query = "SELECT * from material";

		ArrayList<Material> dados = new ArrayList<Material>();
		try {
			Statement frase = (Statement) conexao.createStatement();
			ResultSet rs = frase.executeQuery(query);

			while (rs.next()) {
				dados.add(new Material(rs.getString("nome"), rs
						.getString("descricao"), rs.getString("categoria"), rs
						.getInt("quantidade"), rs.getInt("id")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconectar();
		return dados;
	}

	public void removeMaterial(int id) {
		conectar();
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement("delete from material where id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		disconectar();
	}

	/**
	 * Addiciona um novo horario
	 * 
	 * @param horario
	 */
	public static void gravarHorario(Horario horario) {
		conectar();
		String insertTableSQL = "insert into horario (titulo,dataEntrada,dataSaida,id) value (?,?,?,?)";
		try {
			PreparedStatement preparar = (PreparedStatement) conexao
					.prepareStatement(insertTableSQL);
			preparar.setString(1, horario.getTitulo());
			preparar.setDate(2, (Date) horario.getHoraEntrada());
			preparar.setDate(3, (Date) horario.getHoraSaida());
			preparar.setInt(4, horario.getId());
			preparar.executeUpdate();
			System.out.println("Horario addicionado");
			disconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Addiciona um novo horario
	 * 
	 * @param horario
	 */
	public static void actualizarHorario(Horario horario) {
		conectar();
		String insertTableSQL = "update horario set titulo=?,dataEntrada=?,dataSaida=? where id=?";
		try {
			PreparedStatement preparar = (PreparedStatement) conexao
					.prepareStatement(insertTableSQL);
			preparar.setString(1, horario.getTitulo());
			preparar.setDate(2, (Date) horario.getHoraEntrada());
			preparar.setDate(3, (Date) horario.getHoraSaida());
			preparar.setInt(4, horario.getId());
			preparar.executeUpdate();
			System.out.println("Horario addicionado");
			disconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<Horario> lerHorario() {
		conectar();

		String query = "";

		query = "SELECT * from horario";

		ArrayList<Horario> dados = new ArrayList<Horario>();
		try {
			Statement frase = (Statement) conexao.createStatement();
			ResultSet rs = frase.executeQuery(query);

			while (rs.next()) {
				dados.add(new Horario(rs.getDate("dataEntrada"), rs
						.getDate("DataSaida"), rs.getString("titulo"), rs
						.getInt("id")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconectar();
		return dados;
	}

	public static void removeHorarios(int id) {
		conectar();
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement("delete from horario where id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		disconectar();
	}

}
