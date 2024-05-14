package app;

import java.awt.EventQueue;

public class Regionalizador {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regionalizador regionalizador = new Regionalizador();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Regionalizador () {
		Enrutador enrutador= Enrutador.getInstancia();
		enrutador.start();
	}
}
