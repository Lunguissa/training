package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import beans.MesaDeVoto;
import dao.MesaDAO;
public class Menu_Principal {
	
	private static String provincia="";
	private static String localidade="";
	private static String distrito="";
	private static int numeroVotos=0;
	private static MesaDAO mesa=new MesaDAO();
	private static MesaDeVoto mesaVoto;
	
	private static ArrayList<MesaDeVoto> listaDeMesas=new ArrayList<>();
	
	public static void main(String args[]) throws SQLException
	{
		System.out.println("==================USING HIBERNATE==============");
		System.out.println("==================MENUPRINCIPAL==============");
		System.out.println("=====Sistema de Inserção de informação=====");
		System.out.println("=========Sobre Mesas de Votos==========");
		System.out.println("\n \n \n \n ");
		
		System.out.println("=====Escolha a opção desejada=====");
		System.out.println("1: Inserir informação das Mesas");
		System.out.println("2: Visualização De Mesas de Voto");
		System.out.println("3: Sair");
		int escolha=0;
		do
		{
			System.out.println("Escolha uma opção");
			Scanner entrada= new Scanner(System.in);
			escolha=entrada.nextInt();
		
		
			switch(escolha)
			{
				case 1: provincia=getProvincias();
						distrito=getDistrito();
						localidade= getLocalidade();
						numeroVotos= getNumeroVotos();
				
						// Criacao de objectos e insersao na base de Dados
						mesaVoto=new MesaDeVoto(provincia,distrito,localidade,numeroVotos);
						mesa.guardarMesa(mesaVoto);return;
				
				case 2: System.out.println("Espere a próxima release");
						//System.out.println("Brincadeira, ca esta a lista desejada");
						/*listaDeMesas= (ArrayList<MesaDeVoto>) mesa.obterMesasDeVoto();
						
						for(MesaDeVoto mesaTemp: listaDeMesas)
						{
						 System.out.println(mesaTemp.toString());
						 System.out.println("===================================");
						}
							*/return;
				case 3: break;
				
				default:System.out.println("Insira uma escolha Valida");
			
			}
		}
		while(escolha!=3);
			
	}
	private static String getProvincias(){
		System.out.println("===========Escolha a provincia========");
		System.out.println("1: Niassa");
		System.out.println("2: Cabo Delgado");
		System.out.println("3: Nampula");
		System.out.println("4: Zambézia");
		System.out.println("5: Tete");
		System.out.println("6: Manica");
		System.out.println("7: Sofala");
		System.out.println("8: Inhambane");
		System.out.println("9: Gaza");
		System.out.println("10: Maputo");
		
		Scanner entrada= new Scanner(System.in);
		int escolha=entrada.nextInt();
		provincia="";
		
		switch (escolha)
		{
		case 1: provincia="Niassa";
		case 2: provincia="Cabo Delgado";
		case 3: provincia="Nampula";
		case 4: provincia="Zambézia";
		case 5: provincia="Tete";
		case 6: provincia="Manica";
		case 7: provincia="Sofala";
		case 8: provincia="Inhambane";
		case 9: provincia="Gaza";
		case 10:provincia="Maputo"; break;
		default: System.out.println("========Valor Invalido=====\n INTRODUZA UM VALOR VÁLIDO");
		}
		return provincia;
		
	}
	
	public static String getDistrito(){
		distrito="";
		System.out.println("========INTRODUZA O NOME DO DISTRITO");
		System.out.println(": ");
		
		Scanner entrada=new Scanner(System.in);
		distrito=entrada.nextLine();
		
		return distrito;
	}
	
	public static String getLocalidade(){
		localidade="";
		System.out.println("=========INTRODUZA O NOME DA LOCALIDADE=======");
		System.out.println(": ");
		
		Scanner entrada=new Scanner(System.in);
		localidade=entrada.nextLine();
		
		return localidade;
	}
	
	public static int getNumeroVotos(){
		numeroVotos=0;
		System.out.println("==========INTRODUZA O NUMERO DE VOTOS========");
		System.out.println(": ");
		
		Scanner entrada=new Scanner(System.in);
		numeroVotos=entrada.nextInt();
		
		return numeroVotos;
	}

}
