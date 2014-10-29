package mz.co.lunguissa.objectos;

import java.util.Scanner;

public class Mesa {
private  String provincia;
private  String distrito;



private  int VOTO;
public int getVOTO() {
	return VOTO;
}


public void setVOTO(int vOTO) {
	VOTO = vOTO;
}


private String PartidoFrelimo;

private String PartidoRenamo;
private String partido;
private String PartidoMdm;


public String getPartidoFrelimo() {
	return PartidoFrelimo;
}


public void setPartidoFrelimo(String partidoFrelimo) {
	PartidoFrelimo = partidoFrelimo;
}


public String getPartidoMdm() {
	return PartidoMdm;
}


public void setPartidoMdm(String partidoMdm) {
	PartidoMdm = partidoMdm;
}


public String getPartidoRenamo() {
	return PartidoRenamo;
}


public void setPartidoRenamo(String partidoRenamo) {
	PartidoRenamo = partidoRenamo;
}





public  String getDistrito() {
	return distrito;
}


public  void setDistrito(String distrito) {
	this.distrito = distrito;
}
public String getProvincia() {
	return provincia;
}


public String getPartido() {
	return partido;
}


public void setPartido(String partido) {
	this.partido = partido;
}


public void setProvincia(String provincias) {
	provincias = provincia;
}


}
