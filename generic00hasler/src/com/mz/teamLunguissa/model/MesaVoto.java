package com.mz.teamLunguissa.model;

import java.io.Serializable;

public class MesaVoto implements Serializable
{
	private String provincia;
	private String distrito;
	private String localidade;
	private String nomeMesa;
	
	public MesaVoto(String provincia, String distrito, String localidade,String nomeMesa)
	{
		this.provincia = provincia;
		this.distrito = distrito;
		this.localidade = localidade;
		this.nomeMesa=nomeMesa;
	}

	public String getProvincia() 
	{
		return provincia;
	}

	public void setProvincia(String provincia) 
	{
		this.provincia = provincia;
	}

	public String getDistrito()
	{
		return distrito;
	}

	public void setDistrito(String distrito) 
	{
		this.distrito = distrito;
	}

	public String getLocalidade()
	{
		return localidade;
	}

	public void setLocalidade(String localidade) 
	{
		this.localidade = localidade;
	}

	public String getNomeMesa() 
	{
		return nomeMesa;
	}

	public void setNomeMesa(String nomeMesa) 
	{
		this.nomeMesa = nomeMesa;
	}

	
	
}
