package app.componentes;

import java.util.HashMap;

import org.openstreetmap.gui.jmapviewer.Coordinate;

public class Mapa {
	
	HashMap<Provincia,Coordinate> provincias;
	private static Mapa instancia;

	private Mapa() {
		super();
		provincias = new HashMap<Provincia, Coordinate>();
		provincias.put(Provincia.BUENOS_AIRES, new Coordinate(-36.456636011596196, -60.29296875)); //bsas
		provincias.put(Provincia.ENTRE_RIOS, new Coordinate(-32.026706293336126, -59.4140625)); //entre rios
		provincias.put(Provincia.SANTA_FE, new Coordinate(-30.221101852485987, -61.1279296875)); //santa fe
		provincias.put(Provincia.CORRIENTES, new Coordinate(-28.84467368077178, -57.7001953125)); //corrientes
		provincias.put(Provincia.MISIONES, new Coordinate(-26.78484736105119, -54.404296875)); //misiones
		provincias.put(Provincia.CHACO, new Coordinate(-26.23430203240673, -60.7763671875)); //chaco
		provincias.put(Provincia.FORMOSA, new Coordinate(-24.726874870506958, -60.029296875)); //formosa
		provincias.put(Provincia.SALTA, new Coordinate(-25.125392611512016, -65.23681640625)); //salta
		provincias.put(Provincia.JUJUY, new Coordinate(-22.998851594142913, -65.9619140625)); //jujuy
		provincias.put(Provincia.TUCUMAN, new Coordinate(-26.902476886279807, -65.32470703125)); //tucuman
		provincias.put(Provincia.CATAMARCA, new Coordinate(-27.410785702577023, -67.34619140625)); //catamarca
		provincias.put(Provincia.SANTIAGO_DEL_ESTERO, new Coordinate(-28.09136628140693, -63.65478515625)); //stgo estero
		provincias.put(Provincia.LA_RIOJA, new Coordinate(-29.458731185355315, -67.17041015625)); //la rioja
		provincias.put(Provincia.CORDOBA, new Coordinate(-31.84023266790935, -64.00634765625)); //cordoba
		provincias.put(Provincia.SAN_JUAN, new Coordinate(-31.37239910488051, -68.5986328125)); //san juan
		provincias.put(Provincia.SAN_LUIS, new Coordinate(-33.28461996888768,-66.33544921875)); //san luis
		provincias.put(Provincia.MENDOZA, new Coordinate(-33.87041555094183,-68.5107421875)); //mendoza
		provincias.put(Provincia.LA_PAMPA, new Coordinate(-37.24782120155428,-65.98388671875)); //la pampa
		provincias.put(Provincia.NEUQUEN, new Coordinate(-38.06539235133247,-70.0927734375)); //neuquen
		provincias.put(Provincia.RIO_NEGRO, new Coordinate(-39.90973623453718,-67.236328125)); //rio negro
		provincias.put(Provincia.CHUBUT, new Coordinate(-43.739352079154706,-68.642578125)); //chubut
		provincias.put(Provincia.SANTA_CRUZ, new Coordinate(-48.60385760823253,-70.0927734375)); //sta cruz
		provincias.put(Provincia.TIERRA_DEL_FUEGO, new Coordinate(-54.29088164657004,-67.6318359375)); //tierra fgo
	}

	public Coordinate get(int clave) {
		return provincias.get(clave);
	}
	
	public static Mapa getInstancia() {
		return instancia == null? new Mapa(): instancia;
	}
	
}
