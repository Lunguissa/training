package mz.co.lunguissa.object;

import java.util.Calendar;

public class Funcionario {

	private String nome, apelido, exp;
	private char sexo;
	private long celNumber;
	private Calendar dataNascimento;
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public long getCelNumber() {
		return celNumber;
	}
	public void setCelNumber(long celNumber) {
		this.celNumber = celNumber;
	}
	public String getNome() {
		return nome;
	}
	public char getSexo() {
		return sexo;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	} 
	
	
}
