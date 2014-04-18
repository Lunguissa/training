package mz.co.Lunguissa.Funcionalidades;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import mz.co.Lunguissa.Classes.Mesa;
import mz.co.Lunguissa.Classes.Provincia;
import mz.co.Lunguissa.SQL.ConexaoBD;

/**
 * 
 * @author Diogo Amaral
 *
 */

public class Menu {
	public static void main(String [] args)
	{	/**
		 *Chamada do mentodo para preencher o array de Provincias;
		 */
		
			ConexaoBD.provincias=ConexaoBD.consultaBD();
		
		/**
		 * Chamada o metodo que invoca o Menu Principal
		 */
			System.out.println("");
			System.out.println("");
	    	System.out.println("************     * *            *      *************    ");
	    	System.out.println("*                *   *          *      *                ");
	    	System.out.println("*                *     *        *      *                ");
	    	System.out.println("*                *       *      *      *                ");
	    	System.out.println("*                *        *     *      *************    ");
	    	System.out.println("*                *          *   *      *                ");
	    	System.out.println("*                *            * *      *                ");
	    	System.out.println("************     *              *      *************    ");
	    	
	    	/**
	    	 * Metodo que invoca o Menu Principal
	    	 */
		    Metodos.cicloMenu(); 
	}
}
