package com.teste.model;

import java.util.ArrayList;

public class Actividade {
	int numero;
	String activivdade,discricao;
	ArrayList<User>participantes;
	public Actividade(int numero, String activivdade, String discricao,
			ArrayList<User> participantes) {
		super();
		this.numero = numero;
		this.activivdade = activivdade;
		this.discricao = discricao;
		this.participantes = participantes;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getActivivdade() {
		return activivdade;
	}
	public void setActivivdade(String activivdade) {
		this.activivdade = activivdade;
	}
	public String getDiscricao() {
		return discricao;
	}
	public void setDiscricao(String discricao) {
		this.discricao = discricao;
	}

	
	
	public ArrayList<User> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(ArrayList<User> participantes) {
		this.participantes = participantes;
	}
	@Override
	public String toString() {
		return "Actividade [numero=" + numero + ", activivdade=" + activivdade
				+ ", discricao=" + discricao + ", participantes="
				+ participantes + "]";
	}
	
	

}
