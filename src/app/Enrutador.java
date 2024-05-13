package app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import app.componentes.ViewCargaMapa;

public class Enrutador{

	private static Enrutador instancia;
	private static List<JFrame> pantallas;

	private Enrutador() {
		pantallas = new ArrayList<>();
	}

	public static Enrutador getInstancia() {
		return instancia == null ? new Enrutador() : instancia;
	}

	public void start() {
		ViewCargaMapa menuInicio = new ViewCargaMapa();
		menuInicio.setVisible(true);
		pantallas.add(menuInicio);
	}

	public static void finishWindows(JFrame cerrar, JFrame abrir, boolean dejarAbierto) {
		if (dejarAbierto) {
			pantallas.add(cerrar);
		} else {
			for (JFrame pantalla : pantallas) {
				pantalla.setVisible(false);
				pantalla.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			}
			cerrar.setVisible(false);
			cerrar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		}
		abrir.setVisible(true);
	}
}
