package com.teste.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.teste.model.Actividade;
import com.teste.model.User;

public class Menu {
	;
	Scanner s = new Scanner(System.in);
	ArrayList<Actividade> act;
	ArrayList<User>user;
	public void Principal(ArrayList<Actividade> act,ArrayList<User>users) {
user=users;
		System.out.println("@@@@@@@@@@@ Bem Vindo A Lunguissa@@@@@@@@@@  ");
		System.out.println("n\n\"");
		System.out.println("1. Listar actividades dentro da lunguissa \n");
		System.out.println("2. adicionar Tarefas na lunguissa \n");
		System.out.println("3. Usuarios \n");
		
		switch (s.nextInt()) {
		case 1:
			listaTarefas(act);
		case 2:adicionarTarefa(act, users);
		case 3:users(act, users);
			break;

		default:
			Principal(act,users);
			break;
		}
		// for (Actividade actividade : act) {
		// System.out.println(actividade);
		//
		// }
		//

	}

	public void login(ArrayList<Actividade> act, ArrayList<User> user2) {
		System.out.println("username:");
		String user = s.nextLine();
		
		for (User users : user2) {
			if(users.getUsername().equalsIgnoreCase(user)){
			if (users.getUsername().equalsIgnoreCase(user)) {
				System.out.println("passoword:");
				String pass = s.nextLine();
				if (pass.equals(users.getPassword())) {
					Principal(act,user2);
				} else {
					login(act,user2);
				}
			}
		}login(act, user2);
		}

	}

	public void trarefaDist(int i, ArrayList<Actividade> tarefa) {

		for (Actividade actividade : tarefa) {
			System.out.println("Nome:\n"+actividade.getActivivdade()+"\n");
			System.out.println("Descricao:\n" + actividade.getDiscricao()+"\n");
		}
		System.out.println("pressione 1 para voltar a tela de actividades ");
		switch (s.nextInt()) {
		case 1:
			listaTarefas(tarefa);

			break;

		default:
			listaTarefas(tarefa);
			break;
		}

	}

	public void listaTarefas(ArrayList<Actividade> tarefa) {
		for (Actividade actividade : tarefa) {
			System.out.println("numero: " + actividade.getNumero() + "\n Nome: "
					+ actividade.getActivivdade()+"\n" + "\n Participantes: ");
			for (User participante : actividade.getParticipantes()) {
				System.out.println("      "+participante.getUsername());
			}
			System.out.println("\n");
		}

		System.out.println(" pressione 1 para Menu principal ");
		System.out.println(" pressione 2 para remover actividade ");
		System.out.println(" pressione 3 para discrever actividade ");
		System.out.println(" pressione 4 para adicionar participantes a uma actividade ");
		switch (s.nextInt()) {
		case 1:
			Principal(tarefa,user);
		case 2:
			removerActividade(tarefa);
		case 3:
			System.out.println("numero da actividade a discrever");
			trarefaDist(s.nextInt(), tarefa);
		case 4: participanteAdd(tarefa, user);	
			break;

		default:
			listaTarefas(tarefa);
			break;
		}
	}

	public void removerActividade(ArrayList<Actividade> tarefa) {

		System.out.println("Indique a posicao :exemplo : 1 - para apagar actividade 1 ou precione 0 para voltar ");
		int k=s.nextInt();
		if (k<=tarefa.size()) {
			if (k==0) {
				listaTarefas(tarefa);
			}else{
			tarefa.remove(k - 1);
			listaTarefas(tarefa);}
			
		}else{System.out.println();}
		

	}
	public void adicionarTarefa(ArrayList<Actividade> tarefa,ArrayList<User>users){
		
		System.out.println("Qual e o nome da actividade ?");
		String nome= s.next();
		System.out.println(" A actividade tem o nome: "+nome);
		System.out.println("Qual e a discricao do projecto ");
		String discricao=s.next();
		System.out.println("O discrissao do projecto e: "+discricao);
		System.out.println("Quem sao os participantes?");
		int u=0;
		for (User user : users) {
			 u=u+1;
			System.out.println(u+". "+user.getUsername());
		}
		
		ArrayList<User> participantes =new ArrayList<User>();
		participantes.add(users.get(s.nextInt()-1));
		System.out.println("Deseja adicionar mais um participante? ");
		System.err.println(" \n y/n");
		
		switch (s.nextLine()) {
		case "y":System.out.println("Quem mais desejas adicionar?");participantes.add(users.get(s.nextInt()-1)); 
		case "n": tarefa.add(new Actividade(tarefa.size(),nome,discricao,participantes));	
			break;

		default:
			break;
		}
		
		
	}
	public void users(ArrayList<Actividade>act,ArrayList<User>users){
		 System.out.println("Quer saber sobre actividades que qual lunguissero participa?");
		 int u=0;
			for (User user : users) {
				 u=u+1;
				System.out.println(u+". "+user.getUsername());
			}
		 int j= s.nextInt()-1;
			for (Actividade participa : act) {
				if(participa.getParticipantes().contains(users.get(j))){
					participa.toString();
				}else{System.out.println("ele nao participa nesta tarefa");}
			}
	}
	public void participanteAdd(ArrayList<Actividade>tarefa,ArrayList<User>users){
		System.out.println("Que participante queres adicionar em uma actividade?");
		int u=0;
		for (User user : users) {
			 u=u+1;
			System.out.println(u+". "+user.getUsername());
		}
		int usuario=s.nextInt();
		System.out.println("em que actividade queres merter: "+users.get(usuario-1).getUsername());
		tarefa.get(s.nextInt()-1).getParticipantes().add(users.get(usuario-1));
		listaTarefas(tarefa);
	}

}
