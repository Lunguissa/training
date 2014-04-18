package mz.co.Lunguissa.function;

import mz.co.Lunguissa.*;
import mz.co.Lunguissa.entity.MesaDeVoto;

import java.util.Scanner;
public class Main {
	
	private static	Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String prov,dis, local;
		int nrVotos=0;
		System.out.println("Provincia:");
		prov=in.next();
				
		System.out.println("distrito:");
		dis=in.next();
		System.out.println("localidade:");
		local=in.next();
		System.out.println("numero de votos");
		nrVotos=in.nextInt();
		
		MesaDeVoto mesa = new MesaDeVoto(prov,dis,local,nrVotos);
		
		try {
			Connector.connection();
			Connector.write(mesa);
			Connector.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
