package app.componentes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;

public class ViewArista extends MapPolygonImpl {
	
    public ViewArista(Coordinate coordenada1, Coordinate coordenada2) {
        super(getCoordenadasPoligono(coordenada1, coordenada2));
        setBackColor(new Color(255, 0, 0, 100)); // Color de fondo
        setColor(Color.RED); // Color del borde
    }

    private static List<Coordinate> getCoordenadasPoligono(Coordinate coordenada1, Coordinate coordenada2) {
        List<Coordinate> coordenadasPoligono = new ArrayList<>();
        coordenadasPoligono.add(coordenada1);
        coordenadasPoligono.add(coordenada2);
        coordenadasPoligono.add(coordenada2);
        return coordenadasPoligono;
    }
    
}


