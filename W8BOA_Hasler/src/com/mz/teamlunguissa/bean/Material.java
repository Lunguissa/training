package com.mz.teamlunguissa.bean;

public class Material 
{
	private String nome;
	private String descricao;
	private String categoria;
	private int quantidade;
	private int id;
	public Material(String nome, String descricao, String categoria,
			int quantidade, int id) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
		this.quantidade = quantidade;
		this.id=id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getId()
	{
		return id;
	}
	
}
