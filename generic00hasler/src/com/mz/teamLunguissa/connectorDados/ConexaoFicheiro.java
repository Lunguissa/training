package com.mz.teamLunguissa.connectorDados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ConexaoFicheiro
{
	private static FileInputStream ficheiro=null;
	private static Scanner leitor=null;
	
	
	/**
	 * Abri caminho para ler ficheiros
	 * @param caminho Nome do ficheiro localizado na pasta ficheiros
	 */
	private static void carregarFicheiros(String caminho)
	{
		try
		{
			ficheiro= new FileInputStream("src/com/mz/teamLunguissa/ficheiros/"+caminho);
			leitor= new Scanner(ficheiro);
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("Erro da aplicacao, falta de ficheiros");
		}
	}
	
	/**
	 * Fecha a conexao de ficheiros
	 */
	
	private static void fecharFicheiros()
	{
		try
		{
			ficheiro.close();
			leitor.close();
		}
		catch (IOException e) 
		{
			System.out.println("Erro da aplicacao, falta de ficheiros");
		}
	}
	
	/**
	 * Faz a recolha de dados do ficheiro aberto
	 * @param caminho Nome do ficheiro localizado na pasta ficheiros
	 * @return retorna uma arrayList com dados dos ficheiros
	 */
	public static ArrayList<String> carregarListar(String caminho)
	{
		carregarFicheiros(caminho);
		ArrayList<String> dados= new ArrayList<String>();
		while(leitor.hasNextLine())
		{
			dados.add(leitor.nextLine());
		}	
		fecharFicheiros();
		return dados;
	}
}
