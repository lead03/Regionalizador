package app.componentes;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.Enrutador;
import app.ServicioRegionalizador;


public class ViewCargaMapa extends AbstractPantalla{
	private List<Limitrofe> limitrofes;
	ViewPeso tbCantRegiones;
	JLabel lmsError;
	
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
		limitrofes.add(new Limitrofe(Provincia.SANTA_FE, Provincia.BUENOS_AIRES));
		limitrofes.add(new Limitrofe(Provincia.BUENOS_AIRES, Provincia.ENTRE_RIOS));
		limitrofes.add(new Limitrofe(Provincia.BUENOS_AIRES, Provincia.LA_PAMPA));
		limitrofes.add(new Limitrofe(Provincia.BUENOS_AIRES, Provincia.CORDOBA));
		limitrofes.add(new Limitrofe(Provincia.BUENOS_AIRES, Provincia.RIO_NEGRO));
		limitrofes.add(new Limitrofe(Provincia.CORDOBA, Provincia.LA_RIOJA));
		limitrofes.add(new Limitrofe(Provincia.CORDOBA, Provincia.SAN_LUIS));
		limitrofes.add(new Limitrofe(Provincia.CORDOBA, Provincia.LA_PAMPA));
		limitrofes.add(new Limitrofe(Provincia.LA_RIOJA, Provincia.SAN_JUAN));
		limitrofes.add(new Limitrofe(Provincia.LA_RIOJA, Provincia.SAN_LUIS));
		limitrofes.add(new Limitrofe(Provincia.SAN_JUAN, Provincia.SAN_LUIS));
		limitrofes.add(new Limitrofe(Provincia.SAN_JUAN, Provincia.MENDOZA));
		limitrofes.add(new Limitrofe(Provincia.SAN_LUIS, Provincia.LA_PAMPA));
		limitrofes.add(new Limitrofe(Provincia.SAN_LUIS, Provincia.MENDOZA));
		limitrofes.add(new Limitrofe(Provincia.MENDOZA, Provincia.NEUQUEN));
		limitrofes.add(new Limitrofe(Provincia.LA_PAMPA, Provincia.RIO_NEGRO));
		limitrofes.add(new Limitrofe(Provincia.NEUQUEN, Provincia.RIO_NEGRO));
		limitrofes.add(new Limitrofe(Provincia.RIO_NEGRO, Provincia.CHUBUT));
		limitrofes.add(new Limitrofe(Provincia.CHUBUT, Provincia.SANTA_CRUZ));
		limitrofes.add(new Limitrofe(Provincia.SANTA_CRUZ, Provincia.TIERRA_DEL_FUEGO));
		
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
		
		this.lmsError = new JLabel("defuals");
		lmsError.setBounds(10, 150 + ((getHeight()/4) * 2), 250, 50);
		lmsError.setFont(new Font("Arial", Font.PLAIN, 15));
		lmsError.setForeground(Color.RED);
		getContentPane().add(lmsError);
		
		//cant regiones
		JLabel lCantRegiones = new JLabel("cantidad de regiones");
		lCantRegiones.setBounds(10, 100 + ((getHeight()/4) * 2), 250, 50);
		lCantRegiones.setFont(new Font("Arial", Font.PLAIN, 15));
		getContentPane().add(lCantRegiones);
		
		
		tbCantRegiones = new ViewPeso();
		tbCantRegiones.setBounds(250, 100 + ((getHeight()/4) * 2), 50, 50);
		getContentPane().add(tbCantRegiones);
		
		JButton btnCalcularAgm = new JButton("camcular agm");
		btnCalcularAgm.setBounds(10, 100 + ((getHeight()/4) * 3), this.getWidth()/2, 50);
		btnCalcularAgm.addActionListener(e -> {
			try {
				validar();
				procesar();
			}catch (Exception ex) {
				lmsError.setText(ex.getMessage());
			}
        });
		this.getContentPane().add(btnCalcularAgm);
		
	}
	
	private void validar() throws Exception {
		if(Integer.parseInt(tbCantRegiones.getText()) >= Provincia.CANT_PROVINCIAS) {
			throw new Exception("error: el peso debe ser menor a "+ Provincia.CANT_PROVINCIAS);
		}
	}
	private void procesar() throws Exception {
		Grafo grafo= new Grafo(23);
		for(Limitrofe limitrofe :limitrofes) {
			int peso;
			try{
				peso = Integer.valueOf(limitrofe.getTfPeso().getText());
			}catch (Exception e) {
				throw new Exception("debe completar todos los campos");
			}
			grafo.agregarArista(limitrofe.getOrigen().getValor(), limitrofe.getDestino().getValor(), peso);
		}
		
		ServicioRegionalizador service = new ServicioRegionalizador();
		cambiarPantalla(service.calcularRegiones(Integer.parseInt(tbCantRegiones.getText()), grafo));
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
			tfPeso = new ViewPeso();
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
