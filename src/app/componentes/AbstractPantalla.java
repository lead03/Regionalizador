package app.componentes;

import java.awt.Dimension;

import javax.swing.JFrame;

public abstract class AbstractPantalla extends JFrame{
	private static int CORRECCION_BANNER = 30;
	
	private int[] dimencion;
	
	public AbstractPantalla() {
		initialize();
	}
	
	protected void initialize() {
		Dimension screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		
		dimencion = new int[2] ;
		dimencion[0] =  screen.height - CORRECCION_BANNER;		
		dimencion[1] =  screen.height - CORRECCION_BANNER;
		
		getContentPane().setLayout(null);
		
		setBounds(0, 0, getAncho(), getAlto());
	}
	
	public int getAncho() {
		return dimencion[0];
	}
	
	public int getAlto() {
		return dimencion[1];
	}
	
}
