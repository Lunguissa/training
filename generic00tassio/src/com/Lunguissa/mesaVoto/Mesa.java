package com.Lunguissa.mesaVoto;

import java.sql.SQLException;
import java.util.Scanner;

import com.Lunguissa.conectaBD.ContatoDAO;

public class Mesa  
{
	private int p_id;
	private int d_id;
	private String localidade;
	private long votos;
	private String provincia;
	private String distrito;
	private ContatoDAO cnt;
	
	
	public Mesa() {
	
	}
	/**
	 * @return the p_id
	 */
	public int getp_id() {
		return p_id;
	}
	/**
	 * @param p_id the p_id to set
	 */
	public void setp_id(int p_id) {
		this.p_id = p_id;
	}
	/**
	 * @return the d_id
	 */
	public int getd_id() {
		return d_id;
	}
	/**
	 * @param d_id the d_id to set
	 */
	public void setd_id(int d_id) {
		this.d_id = d_id;
	}
	/**
	 * @return the localidade
	 */
	public String getLocalidade() {
		return localidade;
	}
	/**
	 * @param localidade the localidade to set
	 */
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	/**
	 * @return the votos
	 */
	public long getVotos() {
		return votos;
	}
	/**
	 * @param votos the votos to set
	 */
	public void setVotos(long votos) {
		this.votos = votos;
	}
	
	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}
	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	/**
	 * @return the distrito
	 */
	public String getDistrito() {
		return distrito;
	}
	/**
	 * @param distrito the distrito to set
	 */
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	public  void criaMesa(Scanner n) throws SQLException {
		
		cnt.lerPronvincias();
		System.out.println("Provincia: ");
		this.setp_id(n.nextInt());
		cnt.lerDistritos();
		System.out.println("Distrito: ");
		this.setd_id(n.nextInt());
		System.out.println("Localidade: ");
		this.setLocalidade(n.next());
		System.out.println("Votos: ");
		this.setVotos(n.nextLong());
		
		
	}
	
	
	
}
