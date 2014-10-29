package beans;

public class Conexao {
	
	private String driver, url, usuario, senha;
	
	public Conexao(String driver, String url, String usuario, String senha) {
		super();
		this.driver = driver;
		this.url = url;
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	


}
