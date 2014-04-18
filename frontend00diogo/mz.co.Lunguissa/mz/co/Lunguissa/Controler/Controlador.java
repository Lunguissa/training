package mz.co.Lunguissa.Controler;

import mz.co.Lunguissa.Classes.Mesa;
import mz.co.Lunguissa.Funcionalidades.Metodos;
import mz.co.Lunguissa.SQL.ConexaoBD;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

public class Controlador  extends SelectorComposer<Component>{

	
	
	@Wire("#txtProvincia")
	public Textbox txtProvincia;
	@Wire("#txtDistrito")
	public Textbox txtDistrito;
	@Wire("#txtLocalidade")
	public Textbox txtLocalidade;
	@Wire("#txtVotos")
	public Textbox txtVotos;
	@Wire("#btnSalvar")
	public Button btnSalvar;
	
	
	
	@Listen("onClick=#btnSalvar")
	public void btnSalvar()
	{
		
		String provincia=txtProvincia.getText();
		String distrito =txtDistrito.getText();
		String localidade =txtLocalidade.getText();
		int voto=Integer.parseInt(txtVotos.getText());
		
		Mesa obj =new Mesa(0,provincia, distrito, localidade, voto);
		Messagebox.show(obj.toString(), "Informacao da Mesa", Messagebox.OK, Messagebox.INFORMATION);
	
		txtProvincia.setText(null);
		txtDistrito.setText(null);
		txtLocalidade.setText(null);
		txtVotos.setText(null);
	}
}
