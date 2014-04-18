package mz.co.Lunguissa.Funcionalidades;

import java.util.Scanner;
import java.util.Vector;

import mz.co.Lunguissa.Classes.Mesa;
import mz.co.Lunguissa.Classes.Provincia;
import mz.co.Lunguissa.SQL.ConexaoBD;

public class Metodos {
	
	/**
	 * Declaracao de Variaveis
	 */
	public static int opcao;
	public static Scanner input =new Scanner(System.in);
	public static String back="";
	public static String provincia,distrito,localidade;
	public static int voto;
	
	public static void InserirMesas()
	{
		Vector nomes =ConexaoBD.preencheNomes();
		boolean passa=false;
		
		System.out.println("------------------------------");
		System.out.println("Inserir dados de Uma Nova Mesa: ");
		System.out.print("Insira a Provincia: ");
		provincia=input.next();
		if(!nomes.contains(provincia))
		{
			System.out.println("Essa Provincia "+provincia+" nao Existe,Sera que conhece as provincias de Mocambique??");
			cicloMenu();
			
		}
		
		else{
		System.out.print("Insira o distrito da provincia de "+provincia+" :" );
		distrito=input.next();
		System.out.print("Insira a localidade do distrito de "+distrito+" :" );
		localidade=input.next();
		System.out.print("Insira a quantidade de votos da mesa: ");
		voto=input.nextInt();
		}
		Mesa novo =new Mesa(provincia, distrito, localidade, voto);
		Vector <Mesa> aux =ConexaoBD.consultaBD();
		boolean apanhou = false;
		for (int i = 0; i < aux.size(); i++) {
			if(aux.get(i).getProvincia().equalsIgnoreCase(novo.getProvincia()) && aux.get(i).getDistrito().equalsIgnoreCase(novo.getDistrito()) && aux.get(i).getLocalidade().equalsIgnoreCase(novo.getLocalidade()))
			{
				System.out.println("Mesa Ja existente na base de dados");
				apanhou=true;
				break;
			}
			
		}
		if(apanhou==false){
		ConexaoBD.inserirBD(novo);
		ConexaoBD.provincias=ConexaoBD.consultaBD();
		voltar();
		cicloMenu();
		}
		else if(apanhou==true)
		{voltar();
		cicloMenu();
		}
		
		
	}
	
	public static void cicloMenu()
	{
	
		menuPrincipal();
		opcao=input.nextInt();
		switch(opcao)
		{
		case 1: 
			InserirMesas();
			break;
		case 2: 
			menuProvincia();
			switch(opcao)
			{
			case 1: selectProvincias();
				break;
			case 2:
			cicloMenu();
				break;
			}
	break;
	
		case 3:
				TotalDeVotos();
			break;
			
	case 4:
		/**
		 * Acerca da Tarefa
		 */
	System.out.println("-------------------------------------------------------------------------------------------");
	System.out.println("--------Este e um aplicativo desenvolvido em Java que simula um Sistema de Votacao---------");
	System.out.println("---em algumas Provincias de Mocambique apartir dos seus respectivos distritos e Localidades");
	System.out.println("--fazendo o uso do Gestor de base de dados MySql e ficheiros-------------------------------");
	System.out.println("-------------------------------Desenvolvido por Diogo Amaral-------------------------------");
	System.out.println("----------------------------------------2014 TM--------------------------------------------");
	do{
		voltar();
	}
	while(!back.equalsIgnoreCase("s"));
	cicloMenu();
	break;
	case 5:
			System.exit(0);
	break;
		}
	
	}
	/**
	 *Metodo voltar ao menu
	 */
	public static void voltar()
	{
		System.out.print("Voltar clique(s): ");
		back=input.next();

	}
	/**
	 * Metodo do Menu Principal
	 */
	public static void  menuPrincipal()
	{
		System.out.println("--------------------------------------");
		System.out.println("---------------VOTO-------------------");
		System.out.println("1:Inserir uma Mesa de votos");
		System.out.println("2:Votar apartir de uma Mesas de Voto");
		System.out.println("3:Visualizar total de Votos");
		System.out.println("4:Acerca da Aplicaco");
		System.out.println("5:Sair");
	}
	/**
	 * Menu de selecao de  Provincia
	 */
	public static void menuProvincia(){
		System.out.println("--------------------------------------");
		System.out.println("1:Selecionar Provincia");
		System.out.println("2:Voltar");
		System.out.print("-Escolha uma opcao : ");
		opcao=input.nextInt();
	}
	/**
	 * Menu de selecao de distrito
	 */
	public static void selectedProvincia(String provincia){
		System.out.println("--------------------------------------");
		System.out.println("1:Selecionar um Distrito da provincia de "+ provincia);
		System.out.println("2:Voltar");
		System.out.print("-Escolha uma opcao : ");
		opcao=input.nextInt();
		switch(opcao)
		{
		case 1:
				selectDistrito(provincia);
			break;
		case 2:
				cicloMenu();
			break;
		}
	}
	/**
	 * Metodo de listagem e selecao de provincias
	 */
	public static void selectProvincias()
	{
		
		
		System.out.println("--------------------------------------");
		int aux;
		Vector<Mesa> provincias=new Vector<Mesa>();
		Vector<String> Sprovincias= new Vector<String>();
		for(int i=0; i<ConexaoBD.provincias.size();i++)	
		{	
			
				if(!Sprovincias.contains(ConexaoBD.provincias.get(i).getProvincia()))
				{
					provincias.add(ConexaoBD.provincias.get(i));
					Sprovincias.add(ConexaoBD.provincias.get(i).getProvincia());
					
				}
				else{
		
					continue;
					
			        }
		
		}
		for(int i=0;i<provincias.size();i++)
		{
			aux=i+1;
			System.out.println(aux+"-"+provincias.get(i).getProvincia());
		}
		System.out.print("-Escolha uma opcao : ");
		opcao=input.nextInt();
		provincia=provincias.get(opcao-1).getProvincia();
		
		selectedProvincia(provincia);
		
		
		}
	/**
	 * Menu de Selecao de Distritos
	 */
	public static void menuDistritos()
	{
		System.out.println("--------------------------------------");
		System.out.println("1:Selecionar Distrito");
		System.out.println("2:Voltar");
	}
	
	/**
	 * Menu de Selecao de Localidades
	 */
	public static void selectedDistrito(String distrito){
		
		System.out.println("--------------------------------------");
		System.out.println("1:Selecionar uma Localidade do distrito de "+ distrito);
		System.out.println("2:Voltar");
		System.out.print("-Escolha uma opcao : ");
		opcao=input.nextInt();
		
		switch(opcao)
		{
		case 1:
				selectLocalidade(distrito);
			break;
		case 2:
				cicloMenu();
			break;
		}
		
	}
	/**
	 * Metodo de Listagem e selecao de Localidades
	 */
	public static void selectLocalidade(String Distrito)
	{	System.out.println("--------------------------------------");
		int aux;
		Vector<Mesa> locaclidades=new Vector<Mesa>();
		Vector<String> Slocalidades=new Vector<String>();
		for(int i=0; i<ConexaoBD.provincias.size();i++)	
		{	
			
			if(ConexaoBD.provincias.get(i).getProvincia().equalsIgnoreCase(provincia) && ConexaoBD.provincias.get(i).getDistrito().equalsIgnoreCase(Distrito)){	
				if(!Slocalidades.contains(ConexaoBD.provincias.get(i).getLocalidade()))
				{
					locaclidades.add(ConexaoBD.provincias.get(i));
					Slocalidades.add(ConexaoBD.provincias.get(i).getLocalidade());
					
					
				}
				else{
		
					continue;
			}
		}
		}
		for(int i=0;i<locaclidades.size();i++)
		{
			aux=i+1;
			System.out.println(aux+"-"+locaclidades.get(i).getLocalidade());
		}
		System.out.print("-Escolha uma opcao : ");
		opcao=input.nextInt();
		localidade=locaclidades.get(opcao-1).getLocalidade();
		votar();
		
		do{
			voltar();
		}
		while(!back.equalsIgnoreCase("s"));
		cicloMenu();
	}
	/**
	 * Metodo de listagem e selecao de distritos
	 */
	public static void selectDistrito(String provincia)
	{
		System.out.println("--------------------------------------");
		int aux;
		
		Vector<Mesa> distritos=new Vector<Mesa>();
		
		Vector<String> Sdistritos=new Vector<String>();
		
		for(int z=0; z<ConexaoBD.provincias.size();z++)
		{	
			if(ConexaoBD.provincias.get(z).getProvincia().equalsIgnoreCase(provincia)){
				
				if(!Sdistritos.contains(ConexaoBD.provincias.get(z).getDistrito()))
				{
					distritos.add(ConexaoBD.provincias.get(z));
					Sdistritos.add(ConexaoBD.provincias.get(z).getDistrito());
					
				}
				else{
					continue;
				}
			}
		}
		
		for(int i=0;i<distritos.size();i++)
		{
			aux=i+1;
			System.out.println((aux)+"-"+distritos.get(i).getDistrito());
		}
		System.out.print("-Escolha uma opcao : ");
		opcao=input.nextInt();
		distrito=distritos.get(opcao-1).getDistrito();
		selectedDistrito(distrito);
		
	}
	/**
	 * Metodo de Confirmacao de votos
	 */
	public static void votar()
	{
		Mesa votos = new Mesa(provincia, distrito, localidade, voto);
		ConexaoBD.inserirBD(votos);
		ConexaoBD.provincias=ConexaoBD.consultaBD();
	}
	
	/**
	 * Metodo de calculo de votos
	 */
	public static void TotalDeVotos()
	{
		
		Vector <Mesa> votos =ConexaoBD.consultaBD();
		int totalMaputo=0;
		int totalCabo=0;
		int totalInh=0;
		int totalNamp=0;
		int totalGaza=0;
		int totalNiassa=0;
		int totalSofala=0;
		int totalTete=0;
		int totalZam=0;
		int totalMapuC=0;
		int totalManica=0;
		int total=0;
		
		for(int i=0;i<votos.size();i++)
		{
			
			if(votos.get(i).getProvincia().equalsIgnoreCase("Maputo"))
			{
				totalMaputo=totalMaputo+votos.get(i).getVotos();
			}
			if(votos.get(i).getProvincia().equalsIgnoreCase("Cabo Delgado"))
			{
				totalCabo=totalCabo+votos.get(i).getVotos();
			}
			if(votos.get(i).getProvincia().equalsIgnoreCase("Inhambane"))
			{
				totalInh=totalInh+votos.get(i).getVotos();
			}
			if(votos.get(i).getProvincia().equalsIgnoreCase("Nampula"))
			{
				totalNamp=totalNamp+votos.get(i).getVotos();
			}
			if(votos.get(i).getProvincia().equalsIgnoreCase("Maputo Cidade"))
			{
				totalMapuC=totalMapuC+votos.get(i).getVotos();
			}
			if(votos.get(i).getProvincia().equalsIgnoreCase("Tete"))
			{
				totalTete=totalTete+votos.get(i).getVotos();
			}
			if(votos.get(i).getProvincia().equalsIgnoreCase("Sofala"))
			{
				totalSofala=totalSofala+votos.get(i).getVotos();
			}
			if(votos.get(i).getProvincia().equalsIgnoreCase("Zambezia"))
			{
				totalZam=totalZam+votos.get(i).getVotos();
			}
			if(votos.get(i).getProvincia().equalsIgnoreCase("Manica"))
			{
				totalManica=totalManica+votos.get(i).getVotos();
			}
			if(votos.get(i).getProvincia().equalsIgnoreCase("Gaza"))
			{
				totalGaza=totalGaza+votos.get(i).getVotos();
			}
			if(votos.get(i).getProvincia().equalsIgnoreCase("Niassa"))
			{
				totalNiassa=totalNiassa+votos.get(i).getVotos();
			}
		}
		
		total=totalCabo+totalGaza+totalInh+totalManica+totalMapuC+totalMaputo+totalNamp+totalNiassa+totalSofala+totalTete+totalZam;
		
		System.out.println("----------------------------------------");
		System.out.println("Total de Votos Por Provincia: ");
		System.out.println(" Em Maputo :"+totalMaputo);
		System.out.println(" Em Cabo Delgado :"+totalCabo);
		System.out.println(" Em Inhambane :"+totalInh);
		System.out.println(" Em Gaza :"+totalGaza);
		System.out.println(" Em Zambezia :"+totalZam);
		System.out.println(" Em Tete :"+totalTete);
		System.out.println(" Em Maputo Cidade :"+totalMapuC);
		System.out.println(" Em Sofala :"+totalSofala);
		System.out.println(" Em Nampula :"+totalNamp);
		System.out.println(" Em Niassa :"+totalNiassa);
		System.out.println(" Em Manica :"+totalManica);
		System.out.println("Total de Votos em todo o Pais : "+total);
		voltar();
		cicloMenu();
	}
}
