package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MESA_DE_VOTO")
public class MesaDeVoto {
	
	private int idMesa, numeroDeVotos;
	private String provincia, distrito, localidade;
	
	/*public MesaDeVoto(int idMesa, int numeroDeVotos, String provincia,
			String distrito, String localidade) {
		super();
		this.idMesa = idMesa;
		this.numeroDeVotos = numeroDeVotos;
		this.provincia = provincia;
		this.distrito = distrito;
		this.localidade = localidade;
	}*/
	
	public MesaDeVoto(String provincia, String  Distrito, String localidade, int numeroDeVotos){
		this.provincia=provincia;
		this.distrito=distrito;
		this.localidade=localidade;
		this.numeroDeVotos=numeroDeVotos;
		
	}
	public MesaDeVoto() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name="idMesa")
	public int getIdMesa() {
		return idMesa;
	}
	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}
	
	@Column(name="numeroDeVotos")
	public int getNumeroDeVotos() {
		return numeroDeVotos;
	}
	public void setNumeroDeVotos(int numeroDeVotos) {
		this.numeroDeVotos = numeroDeVotos;
	}
	
	@Column(name="provincia")
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	@Column(name="distrito")
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	@Column(name="localidade")
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	 
	
	

}
