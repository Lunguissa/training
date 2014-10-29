package com.mz.teamlunguissa.bean;

import java.util.Date;

public class Horario
{
	private int id; 
	private Date horaEntrada;
	private Date horaSaida;
	private String titulo;
	public Horario(Date horaEntrada, Date horaSaida, String titulo,int id) {
		super();
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.titulo = titulo;
		this.id=id;
	}
	public Date getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public Date getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getId()
	{
		return id;
	}

}
