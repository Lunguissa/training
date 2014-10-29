package mz.co.lunguissa.menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import mz.co.lunguissa.objectos.Mesa;
import mz.com.lunguissa.baseDados.ContatoDAO;
/**
 * 
 * @author RuiFernandes
 *
 */
public class Menu {
	
	/**
	 * Todas as Variaveis usadas
	 */

	private static Scanner scan= new Scanner(System.in);
	private static int i;
	private static int  j;
	private Mesa Mesa= new Mesa();
	private String provincia;
	private String distrito;
	private int votoFrel=0;
	private int votoMDM=0;
	private int votoREN=0;
	private int votos;
	private int VOTO=1;
	private String partido;
	ContatoDAO dao;
	
	/**
	 * metodo que demostra as pronvincias
	 * @throws SQLException 
	 */
	public  void Provincia() throws SQLException{
		
		System.out.println("Em que Provincia estas para votar");
		System.out.println("1-Maputo");
		System.out.println("2-Cabo Delgado");
		System.out.println("3-Gaza");
		System.out.println("4-Inhambane");
		System.out.println("5-Manica");
		System.out.println("6-Nampula");
		System.out.println("7-Niassa");
		System.out.println("8-Sofala");
		System.out.println("9-Tete");
		System.out.println("10-Zambezia");
		
		
		i= scan.nextInt();
		switch (i) {
		
		case 1: provincia=("Maputo");
				Mesa.setProvincia(provincia);
				Distrito(provincia);
		case 2: provincia=("Cabo Delgado");
		Mesa.setProvincia(provincia);
				Distrito(provincia);
		case 3: provincia="Gaza";
		Mesa.setProvincia(provincia);
				Distrito(provincia);
		case 4: provincia="Inhambane";
		Mesa.setProvincia(provincia);
				Distrito(provincia);
		case 5: provincia="Manica";
		Mesa.setProvincia(provincia);
				Distrito(provincia);
		case 6:provincia="Nampula";
		Mesa.setProvincia(provincia);
		Distrito(provincia);
		
		case 7: provincia="Niassa";
		Mesa.setProvincia(provincia);
		Distrito(provincia);
		
		case 8: provincia="Sofala";
		Mesa.setProvincia(provincia);
		Distrito(provincia);
		
		case 9:provincia="Tete";
		Mesa.setProvincia(provincia);
		Distrito(provincia);
		
		case 10:provincia="Zambezia";
		Mesa.setProvincia(provincia);
		Distrito(provincia);
			
			break;

		default: Provincia();
			break;
		}
		
		

	
	}
	
	/**
	 * metodo para os distritos Distrito
	 * @param provincia
	 * @throws SQLException 
	 */
	public  void Distrito(String provincia) throws SQLException{
		
		switch (provincia) {
		
		/**
		 * Todos os distritos se seguem
		 */
		case "Maputo":
			System.out.println("1-Magude");
			System.out.println("2-Manhiça");
			System.out.println("3-Marracuene");
			System.out.println("4-Matutuíne");
			System.out.println("5-Moamba");
			System.out.println("6-Namaacha");
			System.out.println("7-Maputo");
			System.out.println("8-Boane");
		
	//	nota que o nao puz o scanner em uma variavel
		switch (scan.nextInt()) {
		case 1: distrito=("Magude");voto();
		case 2: distrito=("Manhiça");voto();
		case 3: distrito=("Marracuene");voto();
		case 4: distrito=("Matutuíne");voto();
		case 5: distrito=("Moamba");voto();
		case 6: distrito=("Namaacha");voto();
		case 7: distrito=("Maputo");voto();
			break;

		default:
			break;
		}
		
		

			
		case "Cabo Delgado":
			
		System.out.println("1-Balama");
		System.out.println("2-Chiúre");
		System.out.println("3-Ibo");
		System.out.println("4-Macomia");
		System.out.println("5-Mecúfi");
		System.out.println("6-Meluco");
		System.out.println("7-Mocímboa da Praia");
		System.out.println("8-Montepuez");
		System.out.println("9-Mueda");
		System.out.println("10-Muidumbe");
		System.out.println("11-Namuno");
		System.out.println("12-Nangade");
		System.out.println("13-Palma");
		System.out.println("14-Pemba-Metuge");
		System.out.println("15-Quissanga");
		System.out.println("16-Ancuabe");
		
		switch (scan.nextInt()) {
		case 1: distrito=("Balama");voto();
		case 2: distrito=("Chiúre");voto();
		case 3: distrito=("Ibo");voto();
		case 4: distrito=("Macomia");voto();
		case 5: distrito=("Mecúfi");voto();
		case 6: distrito=("Meluco");voto();
		case 7: distrito=("Mocímboa da Praia");voto();
		case 8: distrito=("Montepuez");voto();
		case 9: distrito=("Manhiça");voto();
		case 10: distrito=("Muidumbe");voto();
		case 11:distrito=("Namuno");voto();
		case 12: distrito=("Nangade");voto();
		case 13: distrito=("Palma");voto();
		case 14: distrito=("Pemba-Metuge");voto();
		case 15: distrito=("Quissanga");voto();
		case 16: distrito=("Ancuabe");voto();
			break;

		default:
			break;
		}
			
			
			
			
			
			
			
			
		case "Gaza":
					System.out.println("1-Bilene Macia");
					System.out.println("2-Chibuto");
					System.out.println("3-Chicualacuala");
					System.out.println("4-Chigubo");
					System.out.println("5-Chókwè");
					System.out.println("6-Guijá");
					System.out.println("7-Mabalane");
					System.out.println("8-Manjacaze");
					System.out.println("8-Massangena");
					System.out.println("9-Massingir");
					System.out.println("10-Xai-Xai");
					
					switch (scan.nextInt()) {
					case 1: distrito=("Balama");voto();
					case 2: distrito=("Chiúre");voto();
					case 3: distrito=("Ibo");voto();
					case 4: distrito=("Macomia");voto();
					case 5: distrito=("Mecúfi");voto();
					case 6: distrito=("Meluco");voto();
					case 7: distrito=("Mocímboa da Praia");voto();
					case 8: distrito=("Montepuez");voto();
					case 9: distrito=("Manhiça");voto();
					case 10: distrito=("Muidumbe");voto();
					break;

					default:
						break;
					}
					
					
			
			
			
			
			
			
			
			
			
			
		case "Inhambane":System.out.println("Funhalouro");
				System.out.println("1-Govuro");
				System.out.println("2-Homoine");
				System.out.println("3-Inharrime");
				System.out.println("4-Inhassoro");
				System.out.println("5-Jangamo");
				System.out.println("6-Mabote");
				System.out.println("7-Massinga");
				System.out.println("8-Morrumbene");
				System.out.println("9-Panda");
				System.out.println("10-Vilanculos");
				System.out.println("11-Zavala");
			
				switch (scan.nextInt()) {
				case 1:distrito=("Govuro");voto();
				case 2: distrito=("Homoine");voto();
				case 3: distrito=("Inharrime");voto();
				case 4: distrito=("Inhassoro");voto();
				case 5: distrito=("Jangamo");voto();
				case 6: distrito=("Mabote");voto();
				case 7: distrito=("Massinga");voto();
				case 8: distrito=("Morrumbene");voto();
				case 9: distrito=("Panda");voto();
				case 10: distrito=("Vilanculos");voto();
				case 11: distrito=("Zavala");voto();
				
					
					break;

				default:
					break;
				}
		
		
		
		
		
		
		
		
		
		
			
		case "Manica":
			System.out.println("1-Gondola");
			System.out.println("2-Guro");
			System.out.println("3-Machaze");
			System.out.println("4-Macossa");
			System.out.println("5-Manica");
			System.out.println("6-Mossurize");
			System.out.println("7-Sussundenga");
			System.out.println("8-Tambara");
			System.out.println("9-Báruè");
			
			switch (scan.nextInt()) {
			case 1:distrito=("Gondola");voto();
			case 2:distrito=("Guro");voto();
			case 3:distrito=("Machaze");voto();
			case 4:distrito=("Machaze");voto();
			case 5:distrito=("Macossa");voto();
			case 6:distrito=("Mossurize");voto();
			case 7:distrito=("Sussundenga");voto();
			case 8:distrito=("Tambara");voto();
			case 9:distrito=("Báruè");voto();
			
				
				break;

			default:
				break;
			}
			
			
			
			
			
			
			
			
		case "Nampula":
			System.out.println("1-Angoche");
			System.out.println("2-Eráti");
			System.out.println("3-Lalaua");
			System.out.println("4-Malema");
			System.out.println("5-Meconta");
			System.out.println("6-Mecubúri");
			System.out.println("7-Memba");
			System.out.println("8-Mogincual");
			System.out.println("9-Mogovolas");
			System.out.println("10-Moma");
			System.out.println("11-Monapo");
			System.out.println("12-Mossuril");
			System.out.println("13-Muecate");
			System.out.println("14-Murrupula");
			System.out.println("15-Nacala-a-Velha");
			System.out.println("16-Nacarôa");
			System.out.println("17-Nampula");
			System.out.println("18-Ribáuè");
		
			switch (scan.nextInt()) {
			case 1:distrito=("Angoche");voto();
			case 2:distrito=("Eráti");voto();
			case 3:distrito=("Lalaua");voto();
			case 4:distrito=("Malema");voto();
			case 5:distrito=("Meconta");voto();
			case 6:distrito=("Mecubúri");voto();
			case 7:distrito=("Memba");voto();
			case 8:distrito=("Mogincual");voto();
			case 9:distrito=("Mogovolas");voto();
			case 10:distrito=("Moma");voto();
			case 11:distrito=("Monapo");voto();
			case 12:distrito=("Mossuril");voto();
			case 13:distrito=("Muecate");voto();
			case 14:distrito=("Murrupula");voto();
			case 15:distrito=("Nacala-a-Velha");voto();
			case 16:distrito=("Nacarôa");voto();
			case 17:distrito=("Nampula");voto();
			case 18:distrito=("Ribáuè");voto();
				
				break;

			default:
				break;
			}
			
			
			
			
			
			

		case "Niassa":
			System.out.println("1-Cuamba");
			System.out.println("2-Lago");
			System.out.println("3-Lichinga");
			System.out.println("4-Majune");
			System.out.println("5-Mandimba");
			System.out.println("6-Marrupa");
			System.out.println("7-Maúa");
			System.out.println("8-Mavagoago");
			System.out.println("9-Mecanhelas");
			System.out.println("10-Mecula");
			System.out.println("11-Metarica");
			System.out.println("12-Muembe");
			System.out.println("13-N'gauma");
			System.out.println("14-Nipepe");
			System.out.println("15-Sanga");
			
			switch (scan.nextInt()) {
			case 1: distrito=("Cuamba");voto();
			case 2: distrito=("Lago");voto();
			case 3: distrito=("Lichinga");voto();
			case 4: distrito=("Majune");voto();
			case 5: distrito=("Mandimba");voto();
			case 6: distrito=("Marrupa");voto();
			case 7: distrito=("Maúa");voto();
			case 8: distrito=("Mavagoago");voto();
			case 9: distrito=("Mecanhelas");voto();
			case 10: distrito=("Mecula");voto();
			case 11: distrito=("Metarica");voto();
			case 12: distrito=("Muembe");voto();
			case 13: distrito=("N'gauma");voto();
			case 14: distrito=("Nipepe");voto();
			case 15: distrito=("Sanga");voto();
			
				
				break;

			default:
				break;
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		case "Sofala":System.out.println("Buzi");
		System.out.println("1-Caia");
		System.out.println("2-Chemba");
		System.out.println("3-Cheringoma");
		System.out.println("4-Chibabava");
		System.out.println("5-Dondo");
		System.out.println("6-Gorongosa");
		System.out.println("7-Marromeu");
		System.out.println("8-Machanga");
		System.out.println("9-Maringué");
		System.out.println("10-Muanza");
		System.out.println("11-Nhamatanda");
		
			

		switch (scan.nextInt()) {
		case 1: distrito=("Caia");voto();
		case 2: distrito=("Chemba");voto();
		case 3: distrito=("Cheringoma");voto();
		case 4: distrito=("Chibabava");voto();
		case 5: distrito=("Dondo");voto();
		case 6: distrito=("Gorongosa");voto();
		case 7: distrito=("Marromeu");voto();
		case 8: distrito=("Machanga");voto();
		case 9: distrito=("Maringué");voto();
		case 10: distrito=("Muanza");voto();
		case 11: distrito=("Nhamatanda");voto();
		
		
			
			break;

		default:
			break;
		}
		
			
			
			
			
			
			
			
			
			
			
			
		case "Tete":
			System.out.println("Angónia");
		
			System.out.println("1-Cahora-Bassa");
			System.out.println("2-Changara");
			System.out.println("3-Chifunde");
			System.out.println("4-Chiuta");
			System.out.println("5-Macanga");
			System.out.println("6-Magoé");
			System.out.println("7-Marávia");
			System.out.println("8-Moatize");
			System.out.println("9-Mutarara");
			System.out.println("10-Tsangano");
			System.out.println("11-Zumbo");
			
			
			

			switch (scan.nextInt()) {
			case 1: distrito=("Cahora-Bassa");voto();
			case 2: distrito=("Changara");voto();
			case 3: distrito=("Chifunde");voto();
			case 4: distrito=("Chiuta");voto();
			case 5: distrito=("Macanga");voto();
			case 6: distrito=("Magoé");voto();
			case 7: distrito=("Marávia");voto();
			case 8: distrito=("Moatize");voto();
			case 9: distrito=("Mutarara");voto();
			case 10: distrito=("Tsangano");voto();
			case 11: distrito=("Zumbo");voto();
			
			
				
				break;

			default:
				break;
			}
			
			
			
			
			
			
			
			
			
			
		case "Zambezia":
			System.out.println("1-Alto Molocue");
			System.out.println("2-Chinde");
			System.out.println("3-Gilé");
			System.out.println("4-Gurué");
			System.out.println("5-Ile");
			System.out.println("6-Inhassunge");
			System.out.println("7-Lugela");
			System.out.println("8-Maganja da Costa");
			System.out.println("9-Milange");
			System.out.println("10-Mocuba");
			System.out.println("11-Mopeia");
			System.out.println("12-Morrumbala");
			System.out.println("13-Namacurra");
			System.out.println("14-Namarroi");
			System.out.println("15-Nicoadala");
			System.out.println("16-Pebane");
			
			
			

			switch (scan.nextInt()) {
			case 1: distrito=("Alto Molocue");voto();
			case 2: distrito=("Chinde");voto();
			case 3: distrito=("Gilé");voto();
			case 4: distrito=("Gurué");voto();
			case 5: distrito=("Ile");voto();
			case 6: distrito=("Inhassunge");voto();
			case 7: distrito=("Lugela");voto();
			case 8:distrito=("Maganja da Costa");voto();
			case 9: distrito=("Milange");voto();
			case 10: distrito=("Mocuba");voto();
			case 11: distrito=("Mopeia");voto();
			case 12: distrito=("Morrumbala");voto();
			case 13: distrito=("Namacurra");voto();
			case 14: distrito=("Namarroi");voto();
			case 15: distrito=("Nicoadala");voto();
			case 16: distrito=("Pebane");voto();
				
				break;

			default:
				break;
			}
			
			

		
			break;

		default: Provincia();
			break;
		}
		
		
		
	}
	
	/**
	 * Metodo que faz gere os votos
	 */
	public void voto()throws SQLException{
		dao=new ContatoDAO();
		System.out.println("Em que partido tu votas");
		System.out.println("1-Frelimo ");
		System.out.println("2-Renamo");
		System.out.println("3-MDM");
		System.out.println("0-voltar ao inicio");
		
		switch (scan.nextInt()) {
		
		case 1:partido="Frelimo";votoFrel++;voto();
		case 2:partido="Renamo";votoREN++;voto();
		case 3:partido="MDM";votoMDM++;voto();
		case 0: votos=votoFrel+votoMDM+votoREN;save();inicial(); //provincia=null;distrito=null;	
			break;

		default:voto();
			break;
		}
		
	}
	
	/**
	 * Metodo que faz a tela incial
	 * @throws SQLException 
	 */
	
public void inicial() throws SQLException{
	System.out.println("Bem vindo ao aplicativo votar do Rui");
	System.out.println("1-Votar");
	System.out.println("2-Contar Votos");
	switch (scan.nextInt()) {
	case 1: Provincia();
	case 2:	votosContados();
		
		break;

	default:inicial();
		break;
	}
}
/**
 * Tela que mostra os votos ontados
 * @throws SQLException 
 */
public void votosContados() throws SQLException{
	dao=new ContatoDAO();
	List<Mesa> Mesas=dao.getLista();
	System.out.println("frelimo tem : "+votoFrel);
	System.out.println("MDM tem     : "+votoMDM);
	System.out.println("Renamo tem  : "+votoREN);
	System.out.println("Total Voto  : "+votos);
	
	System.out.println(" pression o ou 1 para ir a tela inicial");
	switch (scan.nextInt()) {
	case 1: inicial();
		
		break;

	default: inicial();
		break;
	}
}

public void save() throws SQLException{
	
	
	Mesa.setDistrito(distrito);
	Mesa.setVOTO(votos);
	dao= new ContatoDAO();
	dao.adicionar(Mesa);
	
	
}

}
