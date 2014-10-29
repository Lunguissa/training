package com.mz.teamlunguissa.controlador;

import java.util.ArrayList;
import java.util.Date;

import org.zkoss.zhtml.Button;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Timebox;

import com.mz.teamlunguissa.bean.Horario;
import com.mz.teamlunguissa.connectordados.ConexaoBD;
//Teste
public class ControlaHorario extends SelectorComposer<Component> {
	@Wire
	Button bt_registro;

	@Wire
	Button bt_editar;

	@Wire
	Button bt_remover;

	@Wire
	Button bt_listar;

	@Wire
	Textbox lbTitulo;

	@Wire
	Timebox tbEntrada;

	@Wire
	Timebox tbSaida;

	@Wire("#horario")
	Listbox horario;
	
	ArrayList<Horario> tabela=ConexaoBD.lerHorario();
	
	@Listen("onClick = #bt_registro")
	public void teste() {
		Date dataEntrada = new Date();
		System.out.println(tbEntrada.getText());
		String[] tempo = tbEntrada.getText().split(":");

		int hora = Integer.parseInt(tempo[0]);

		if (tempo[1].substring(3, 5).trim().equalsIgnoreCase("pm")) {
			hora += 12;
			if (hora == 24) {
				hora = 0;
			}
		}

		tempo = tbSaida.getText().split(":");

		hora = Integer.parseInt(tempo[0]);
		dataEntrada.setHours(hora);
		dataEntrada.setMonth(Integer.parseInt(tempo[1].substring(0,2)));
		
		Date dataSaida=new Date();
		
		if (tempo[1].substring(3, 5).trim().equalsIgnoreCase("pm")) {
			hora += 12;
			if (hora == 24) {
				hora = 0;
			}
		}
	
		dataSaida.setHours(hora);
		dataSaida.setMinutes(Integer.parseInt(tempo[1].substring(0,2)));
		int diferencaHoras=dataSaida.getHours()-dataEntrada.getHours();
		int diferencaMinutos=dataSaida.getMinutes()-dataEntrada.getMinutes();
		
		if (diferencaMinutos<0)
		{
			diferencaMinutos=60-diferencaMinutos;
			diferencaHoras++;
		}
		
		if (diferencaHoras<=1 && diferencaHoras>3) 
		{
			Messagebox.show("Deve ter no minimo 1 hora e no maximo 3");
			return;
		}

		Horario horario=new Horario(dataEntrada, dataSaida, lbTitulo.getText(), 1);
		tabela.add(horario);
		ConexaoBD.gravarHorario(horario);
	} 
	

	@Listen("onClick = #bt_remover")	
	public void remover()
	{
		String t=horario.getSelectedItem().toString();
		
		
		for (int i = 0; i < tabela.size(); i++) {
			if (t.equalsIgnoreCase(tabela.get(i).getTitulo())) {

				ConexaoBD.removeHorarios(tabela.get(i).getId());
				tabela.remove(i);
				break;
			}
		}
	}
	
	@Listen("onClick = #bt_listar")	
	public void listar()
	{

		horario.setModel(new ListModelList<>(tabela));
	}
	
	
	
	
}
