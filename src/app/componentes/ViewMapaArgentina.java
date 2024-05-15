package app.componentes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Queue;

import javax.swing.JPanel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;

public class ViewMapaArgentina extends AbstractPantalla {

    private JPanel panelControles;
    private JMapViewer _mapa;
    private Queue<Arista> regiones;
    private Mapa argentina = Mapa.getInstancia();
    public ViewMapaArgentina(Queue<Arista> reg) {
        super();
        regiones = reg;
        render();
    }

    @Override
    protected void initialize() {
        super.initialize();

        panelControles = new JPanel();
        panelControles.setLayout(new FlowLayout());
        getContentPane().add(panelControles, BorderLayout.SOUTH);

        _mapa = new JMapViewer();
        _mapa.setDisplayPosition(new Coordinate(-34.521, -58.7008), 15);
        getContentPane().add(_mapa, BorderLayout.CENTER);
    
    }

    private void dibujarRegiones() {
    	
    	for (Arista ar: regiones) {
    		_mapa.addMapPolygon(new ViewArista(argentina.get(ar.getOrigen()),argentina.get(ar.getDestino())));
    	}
    }
    
    private void dibujarMarkerPRovincias() {
    	for(Provincia provincia : Provincia.values()){
    		_mapa.addMapMarker(new MapMarkerDot(argentina.get(provincia.getValor())));
    		_mapa.addMapMarker(new MapMarkerDot(argentina.get(provincia.getValor())));
    	}
    	
    }
    private void render( ) {
    	dibujarMarkerPRovincias();
    	dibujarRegiones();
    }
    
}
