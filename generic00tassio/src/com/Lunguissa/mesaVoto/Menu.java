package com.Lunguissa.mesaVoto;

import java.sql.SQLException;
import java.util.Scanner;

import com.Lunguissa.conectaBD.ContatoDAO;

public class Menu 
{
	private static Scanner input;

	public static void menu() throws SQLException
	{
		ContatoDAO cnt=new ContatoDAO();
		input = new Scanner(System.in);
		System.out.println("Escolha uma opcao: ");
		System.out.println("1.adicionar mesa ");
		System.out.println("2.listar mesas ");
		System.out.println("0.sair ");
		int num=input.nextInt();
		switch (num) {
		case 1:
				Mesa mesa= new Mesa();
				cnt.lerPronvincias();
				System.out.println("Provincia: ");
				mesa.setp_id(input.nextInt());
				cnt.lerDistritos();
				System.out.println("Distrito: ");
				mesa.setd_id(input.nextInt());
				System.out.println("Localidade: ");
				mesa.setLocalidade(input.next());
				System.out.println("Votos: ");
				mesa.setVotos(input.nextLong());
				cnt.adiciona(mesa);
				System.out.println("Gravado");
				Menu.menu();
			
			break;
		case 2:
				
				cnt.ler();
				Menu.menu();
		case 0:
				break;
		default:
			break;
		}
		
		
	}
}
