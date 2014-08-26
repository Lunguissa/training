package com.mz.teamlunguissa.controlador;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Textbox;

public class ControladorFuncionario extends SelectorComposer<Component> 
{
	
	@Wire("#lbFuncionarioNome")
	Textbox lbFuncionarioNome;
	@Wire("#registro")
	Grid registro;

	@Listen("onClick = #regF")
	public void registar() {
		registro.setVisible(true);
	}

	@Listen("onClick = #editF")
	public void editar() 
	{

		registro.setVisible(true);
	}

}
