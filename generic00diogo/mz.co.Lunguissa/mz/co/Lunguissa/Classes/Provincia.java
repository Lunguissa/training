package mz.co.Lunguissa.Classes;

import java.io.Serializable;

public class Provincia implements Serializable {

	private String nome ,distrito,localidade;

	public Provincia(String nome, String distrito, String localidade) {
		super();
		this.nome = nome;
		this.distrito = distrito;
		this.localidade = localidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	
}
