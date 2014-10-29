import java.sql.SQLException;
import java.util.ArrayList;

import beans.MesaDeVoto;
import dao.MesaDAO;


public class testes {
	
	public static void main (String [] args) throws SQLException{
		
		MesaDeVoto m1=new MesaDeVoto("Gaza","Mandjacaze","Xidenguela",3232);
		MesaDeVoto m2=new MesaDeVoto("xaskdlajs","basddç","asdaskçlk",10002);
		ArrayList<MesaDeVoto> mesa=new ArrayList<>();
		
		MesaDAO m=new MesaDAO();
		//m.consultarMesaDeVoto(3);
		//m.inserirMesaVotoBD(m2);
		
		//Funcional
		//System.out.println(m.consultarMesaDeVoto(2).toString());
		
		mesa=(ArrayList<MesaDeVoto>) m.obterMesasDeVoto();
		
		for(MesaDeVoto mesinha: mesa)
		{
			System.out.println(mesinha.toString());
			System.out.println("================================");
		}
	
	}

}
