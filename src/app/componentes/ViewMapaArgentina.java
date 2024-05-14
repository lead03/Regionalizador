package app.componentes;

import javax.swing.*;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import java.awt.*;
import java.util.Queue;

public class ViewMapaArgentina extends AbstractPantalla {

    private JPanel panelControles;
    private JMapViewer _mapa;
    private Queue<Arista> regiones;

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
    	Mapa argentina = Mapa.getInstancia();
    	for (Arista ar: regiones) {
    		_mapa.addMapPolygon(new ViewArista(argentina.get(ar.getOrigen()),argentina.get(ar.getDestino())));
    	}
    }
    
    private void render( ) {
    	dibujarRegiones();
    }
    
}
