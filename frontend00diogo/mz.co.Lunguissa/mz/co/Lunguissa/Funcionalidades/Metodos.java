package mz.co.Lunguissa.Funcionalidades;

import mz.co.Lunguissa.Classes.Mesa;
import mz.co.Lunguissa.SQL.ConexaoBD;

public class Metodos {

	
	
	
	public static boolean VerificarDados(Mesa mesa)
	{
		
		for(int i=0;i<ConexaoBD.provincias.size();i++)
		{
			if(mesa.getProvincia().equalsIgnoreCase(ConexaoBD.provincias.get(i).getNome())&& mesa.getDistrito().equalsIgnoreCase(ConexaoBD.provincias.get(i).getDistrito())&& mesa.getLocalidade().equalsIgnoreCase(ConexaoBD.provincias.get(i).getLocalidade()) )
			{
				return true;
			}
		}
		
		return false;
	}
}
