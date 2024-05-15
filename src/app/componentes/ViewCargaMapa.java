package app.componentes;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.Enrutador;
import app.Programa;
import app.componentes.test.GrafoDummy;

public class ViewCargaMapa extends AbstractPantalla{
	private List<Limitrofe> limitrofes;
	
	public ViewCargaMapa() {
		super();
	}

	@Override
	protected void initialize() {
		super.initialize();
        getContentPane().setLayout(null);

		JLabel lTitulo = new JLabel();
		lTitulo.setBounds(0, 0, getWidth(), 100);
		lTitulo.setText("Regionalizador");
		lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lTitulo.setFont(new Font("Arial", Font.PLAIN, 30));
		this.getContentPane().add(lTitulo);
	
		this.limitrofes = new ArrayList<Limitrofe>();
		limitrofes.add(new Limitrofe(Provincia.JUJUY, Provincia.SALTA));
		limitrofes.add(new Limitrofe(Provincia.SALTA, Provincia.CATAMARCA));
		limitrofes.add(new Limitrofe(Provincia.SALTA, Provincia.SANTIAGO_DEL_ESTERO));
		limitrofes.add(new Limitrofe(Provincia.SALTA, Provincia.TUCUMAN));
		limitrofes.add(new Limitrofe(Provincia.SALTA, Provincia.CHACO));
		limitrofes.add(new Limitrofe(Provincia.CATAMARCA, Provincia.LA_RIOJA));
		limitrofes.add(new Limitrofe(Provincia.SALTA, Provincia.FORMOSA));
		limitrofes.add(new Limitrofe(Provincia.CATAMARCA, Provincia.CORDOBA));
		limitrofes.add(new Limitrofe(Provincia.CATAMARCA, Provincia.TUCUMAN));
		limitrofes.add(new Limitrofe(Provincia.TUCUMAN, Provincia.SANTIAGO_DEL_ESTERO));
		limitrofes.add(new Limitrofe(Provincia.CATAMARCA, Provincia.SANTIAGO_DEL_ESTERO));
		limitrofes.add(new Limitrofe(Provincia.SANTIAGO_DEL_ESTERO, Provincia.CORDOBA));
		limitrofes.add(new Limitrofe(Provincia.SANTIAGO_DEL_ESTERO, Provincia.SANTA_FE));
		limitrofes.add(new Limitrofe(Provincia.CHACO, Provincia.FORMOSA));
		limitrofes.add(new Limitrofe(Provincia.SANTIAGO_DEL_ESTERO, Provincia.CHACO));
		limitrofes.add(new Limitrofe(Provincia.CHACO, Provincia.SANTA_FE));
		limitrofes.add(new Limitrofe(Provincia.CORRIENTES, Provincia.MISIONES));
		limitrofes.add(new Limitrofe(Provincia.CHACO, Provincia.CORRIENTES));
		limitrofes.add(new Limitrofe(Provincia.CORRIENTES, Provincia.SANTA_FE));
		limitrofes.add(new Limitrofe(Provincia.CORRIENTES, Provincia.ENTRE_RIOS));
		limitrofes.add(new Limitrofe(Provincia.SANTA_FE, Provincia.CORDOBA));
		limitrofes.add(new Limitrofe(Provincia.SANTA_FE, Provincia.ENTRE_RIOS));
		
		int x = 0;
		int y = 0;
		for(Limitrofe limitrofe :limitrofes) {
			JLabel label = limitrofe.getLabelArista();
			label.setBounds(10 + (310 * y), 100 +(50*x) , 250, 35);
			getContentPane().add(label);
			
			JTextField textPeso = limitrofe.getTfPeso();
			textPeso.setBounds(260 + (310 * y), 100 + (50*x) , 50, 35);
			getContentPane().add(textPeso);
			if(100 +(50*x) >= (this.getHeight()/4) * 2) {
				y ++;
				x = 0;
			}else {
				x++;
			}
		}
		
		
		JButton btnCalcularAgm = new JButton("camcular agm");
		btnCalcularAgm.setBounds(10, 100 + ((getHeight()/4) * 2), this.getWidth()/2, 50);
		btnCalcularAgm.addActionListener(e -> {
			procesar();
        });
		this.getContentPane().add(btnCalcularAgm);
		
	}
	

	private void procesar() {
		Grafo grafo= new Grafo(23);
		for(Limitrofe limitrofe :limitrofes) {
			
			JTextField textPeso = limitrofe.getTfPeso();
			grafo.agregarArista(limitrofe.getOrigen().getValor(), limitrofe.getDestino().getValor(), Integer.valueOf(textPeso.getText()));

			
		}
		
		Programa programa = new Programa();
		programa.run(3, grafo);
		cambiarPantalla(GrafoDummy.builAgmEsperado());
	}

	private void cambiarPantalla(Queue<Arista> amg) {
		Enrutador enrutador= Enrutador.getInstancia();
		enrutador.finishWindows(this, new ViewMapaArgentina(amg), false);
	}
	
	
	public class Limitrofe {
		private JLabel jlArista;
		private ViewPeso tfPeso;
		private Provincia origen;
		private Provincia destino;
		
		public  Limitrofe(Provincia origen, Provincia destino) {
			this.destino = destino;
			this.origen = origen;
			
			jlArista = new JLabel(origen + " <--> " + destino);
			//Font("Arial", Font.PLAIN, 15)
			tfPeso = new ViewPeso();
			//Font("Arial", Font.PLAIN, 15)
		}

		public JLabel getLabelArista() {
			return jlArista;
		}

		public void setJlArista(JLabel jlArista) {
			this.jlArista = jlArista;
		}

		public JTextField getTfPeso() {
			return tfPeso;
		}

		public void setTfPeso(ViewPeso tfPeso) {
			this.tfPeso = tfPeso;
		}

		public Provincia getOrigen() {
			return origen;
		}

		public void setOrigen(Provincia origen) {
			this.origen = origen;
		}

		public Provincia getDestino() {
			return destino;
		}

		public void setDestino(Provincia destino) {
			this.destino = destino;
		}
		
		
		
		
	}
}
