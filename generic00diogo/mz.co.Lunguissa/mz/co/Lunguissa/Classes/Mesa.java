package mz.co.Lunguissa.Classes;

public class Mesa {
	
	/** 
	 * Declaracao de Variaveis 
	 */
	
	
	private String provincia;
	private String distrito;
	private String localidade;
	private int votos;
	
	
	/**
	 * Metodo Construtor da Classe Mesa
	 * @param id - Identificador unico da Mesa de Voto
	 * @param provicia - Localizacao Provincial da Mesa de Voto
	 * @param distrito - Localizacao Distrital da Mesa de Voto
	 * @param localidade - Localizacao da Mesa de Voto
	 * @param votos - Numero total de Votos da Mesa de Voto
	 */
	
	public Mesa(String provincia, String distrito, String localidade, int votos) {
		super();
		this.provincia = provincia;
		this.distrito = distrito;
		this.localidade = localidade;
		this.votos = votos;
	}



	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provicia) {
		this.provincia = provicia;
	}

	@Override
	public String toString() {
		return "Mesa [provincia=" + provincia + ", distrito=" + distrito
				+ ", localidade=" + localidade + ", votos=" + votos;
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

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}
	
	
	
	
	

}
