package com.mz.teamlunguissa.bean;

import java.util.Date;

public class Funcionario
{
	private int id;
	private String nome;
	private String apelido;
	private int numero;
	private Date dataNascimento;
	private String sexo;
	private String experiencia;
	
	
	public Funcionario(String nome, String apelido, int numero,
			Date dataNascimento, String sexo, String experiencia, int id) {

		this.nome = nome;
		this.apelido = apelido;
		this.numero = numero;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.experiencia = experiencia;
		this.id=id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public int getId() 
	{
		return id;
	}
	
	
	
}
