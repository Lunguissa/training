package com.mz.teamLunguissa.inicio;

import java.util.ArrayList;
import java.util.Scanner;

import com.mz.teamLunguissa.connectorDados.ConexaoBD;
import com.mz.teamLunguissa.connectorDados.ConexaoFicheiro;
import com.mz.teamLunguissa.model.MesaVoto;

public class Start 
{
	public static void main(String[] args) 
	{
		System.out.println("\t\t Bemvindo \n");
		menuPrincipal();
	}
	/**
	 * Menu com as opcoes iniciais
	 */
	public static void menuPrincipal()
	{
		ArrayList<String> mesas=ConexaoBD.imprimirMesas();
		
		if(mesas.size()!=0)
			System.out.println("\nMesas:");
		
		for (int i = 0; i < mesas.size(); i++)
		{
			System.out.println((1+i)+" --> "+mesas.get(i));
		}
		int continuar=mesas.size();
		System.out.println("\nOpcoes:");
		System.out.println(continuar+1+" --> Introduzir uma mesa");
		System.out.println(continuar+2+" --> Ver votos totais");	
		System.out.println(continuar+3+" --> Sair");
		Scanner teclado= new Scanner(System.in);
		System.out.println("\nEscolher uma opcao:");
		int resposta=0;
		
		try 
		{
			resposta=teclado.nextInt()-1;
			System.out.println();
		}
		catch (Exception e)
		{
			System.out.println("Opcao Invalida");
			menuPrincipal();
			return;
		}
		
		if (resposta>-1 && resposta<continuar)
		{
			entrarMesa(mesas.get(resposta));
		}
		else if(resposta==continuar)
		{
			 novaMesa(mesas);
		}
		else if(resposta==continuar+1)
		{
			ConexaoBD.lerMesas("", true);
			menuPrincipal();
		}
		else if(resposta==continuar+2)
		{
			System.out.println("Ate breve");
			return;
		}
		else
		{
			System.out.println("Opcao Invalida");
			menuPrincipal();
			return;
		}
	}
	
	/**
	 * Menu com opcoes para uma mesa especifica
	 * @param mesa mesa a ser usada
	 */
	public static void entrarMesa(String mesa)
	{
		System.out.println("\nBemvindo a mesa: "+mesa);
		System.out.println("1 --> Votar");
		System.out.println("2 --> Ver Votos da Mesa");
		System.out.println("3 --> Terminar");
		System.out.println("Escolha uma opcao: ");
		
		Scanner teclado= new Scanner(System.in);
		int respostas=0;
		try
		{
			respostas=teclado.nextInt();	
			System.out.println();
		}
		catch(Exception e)
		{
			System.out.println("Opcao invalida");
			entrarMesa(mesa);
			return;
		}

		switch (respostas) 
		{
		case 1:
			ConexaoBD.votar(mesa);
			
			break;

		case 2:
			ConexaoBD.lerMesas(mesa,true);
			break;
			
		case 3:
			System.out.println("Ate Breve");
			return;

		default:
			System.out.println("Opcao invalida");
			entrarMesa(mesa);
			return;
		}
		entrarMesa(mesa);
	}
			
	/**
	 * Adiciona uma nova mesa a base de dados
	 * @param mesas mesa que ja existem
	 */
	private static void novaMesa(ArrayList<String> mesas)
	{
		Scanner teclado= new Scanner(System.in);
		String nomeMesa="";
		while(true)
		{
			System.out.println("\nNome da Mesa: ");
			nomeMesa=teclado.nextLine();
			if (!mesas.contains(nomeMesa))
		  	break;
		}
		System.out.println();
		
		String caminho="Provincias";
		ArrayList local= ConexaoFicheiro.carregarListar(caminho);
		String provincia=listaLocais(local,caminho,"Provincias");
		local.clear();
		
		caminho=provincia+" Distrito";
		local= ConexaoFicheiro.carregarListar(caminho);
		String distrito=listaLocais(local,caminho,"Distrito");
		local.clear();
		
		caminho=provincia+" Localidade";
		local= ConexaoFicheiro.carregarListar(caminho);
		String localidade=listaLocais(local,caminho,"Localidades");
		local.clear();
		
		MesaVoto nova=new MesaVoto(provincia, distrito, localidade, nomeMesa);
		ConexaoBD.gravarMesa(nova);
		menuPrincipal();
		
	}
	
	/**
	 * Escolhe o local para ser adicionado na mesaVoto
	 * 
	 * @param dados lista dos locais
	 * @param caminho nome do ficheiro na pasta ficheiros
	 * @param tipo Local( Provincia, Distrido, Localidade)
	 * @return retorna o local selecionado
	 */
	private static String listaLocais(ArrayList<String> dados,String caminho, String tipo)
	{
		
		System.out.println(tipo);
		for (int i = 0; i < dados.size(); i++)
		{
			System.out.println((i+1)+" -->"+dados.get(i));
		}
		
		Scanner teclado= new Scanner(System.in);
		int resposta=0;
		try 
		{
			 resposta=teclado.nextInt()-1;
		} 
		catch (Exception e) 
		{
		}
		
		if (resposta>-1 && resposta<dados.size())
		{
			return dados.get(resposta);
		}

		System.out.println("Opcao Invalida");
		return listaLocais(dados,caminho,tipo);

		
	}
}
