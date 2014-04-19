package beans;

public class MesaDeVoto {

	private String provincia, distrito, localidade;
	private int numeroDeVotos;
	
	public MesaDeVoto(String provincia, String distrito, String localidadeby, int numeroDeVoto) {
		super();
		this.provincia = provincia;
		this.distrito = distrito;
		this.localidade = localidade;
		this.numeroDeVotos=numeroDeVoto;
	}
	
	public MesaDeVoto(){}
	
	public int getNumeroDeVotos() {
		return this.numeroDeVotos;
	}


	public void setNumeroDeVotos(int numeroDeVoto) {
		this.numeroDeVotos = numeroDeVoto;
	}


	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getLocalidade() {
		return this.localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	
	public String toString(){
		return "Provincia: \t"+provincia+"\n"+
		"Distrito: \t"+ distrito+"\n"+
		"Localidade: \t"+ localidade;		
	}

	
	
	
	
	

	
	

}
