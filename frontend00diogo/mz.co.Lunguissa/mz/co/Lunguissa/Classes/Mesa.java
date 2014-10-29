package mz.co.Lunguissa.Classes;

public class Mesa {
	
	/** 
	 * Declaracao de Variaveis 
	 */
	
	
	private String provincia;
	private String distrito;
	private String localidade;
	private int votos,id;
	
	
	/**
	 * Metodo Construtor da Classe Mesa
	 * @param id - Identificador unico da Mesa de Voto
	 * @param provicia - Localizacao Provincial da Mesa de Voto
	 * @param distrito - Localizacao Distrital da Mesa de Voto
	 * @param localidade - Localizacao da Mesa de Voto
	 * @param votos - Numero total de Votos da Mesa de Voto
	 */
	
	public Mesa(int id,String provincia, String distrito, String localidade, int votos) {
		super();
		this.id=id;
		this.provincia = provincia;
		this.distrito = distrito;
		this.localidade = localidade;
		this.votos = votos;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provicia) {
		this.provincia = provicia;
	}

	@Override
	public String toString() {
		return "Mesa de Voto : "+" Provincia: "+getProvincia()+" Localidade: "+getLocalidade()+" Distrito: "+getDistrito()+" Votos: "+getVotos();
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
