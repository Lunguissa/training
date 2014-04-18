package mz.co.Lunguissa.entity;

public class MesaDeVoto {
	private String prov;
	private String dis;
	private String local;
	private int nrVotos = 0;
	
	public String getProv() {
		return prov;
	}
	public void setProv(String prov) {
		this.prov = prov;
	}
	public String getDis() {
		return dis;
	}
	public void setDis(String dis) {
		this.dis = dis;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public int getNrVotos() {
		return nrVotos;
	}
	public void setNrVotos(int nrVotos) {
		this.nrVotos = nrVotos;
	}
	public MesaDeVoto(String prov, String dis, String local, int nrVotos) {
		super();
		this.prov = prov;
		this.dis = dis;
		this.local = local;
		this.nrVotos = nrVotos;
	}
}
