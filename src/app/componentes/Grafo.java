package app.componentes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Grafo {
	private int cantVertices; // Número de vértices
    private List<List<Arista>> vecinos; // Lista de adyacencia para representar el grafo

    public Grafo(int cantVertices) {
        this.cantVertices = cantVertices;
        vecinos = new ArrayList<>(cantVertices);
        for (int i = 0; i < cantVertices; ++i)
            vecinos.add(new ArrayList<>());
    }
    
    public Grafo(int cantVertices, List<List<Arista>> vecinos) {
        this.cantVertices = cantVertices;
        this.vecinos = vecinos;//revisar copia de memoria
    }

    public void agregarArista(int origen, int destino, int peso) {
    	if(origen == destino) {
    		throw new IllegalArgumentException("origen y destino son iguales");
    	}
    	
        vecinos.get(origen).add(new Arista(origen, destino, peso));
        vecinos.get(destino).add(new Arista(destino, origen, peso));
    }

    public int getCantVertices() {
    	return this.cantVertices;
    }

	public List<List<Arista>> getVecinos() {
		return vecinos;
	}


	@Override
	public boolean equals(Object obj) {

		if(obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Grafo other = (Grafo) obj;
		
		if(other.getCantVertices() != this.getCantVertices()) {
			return false;
		}
		
		if ( this.getVecinos().size() != other.getVecinos().size()) {
            return false;
        }
		
		for (int i = 0; i < this.getVecinos().size(); i++) {
            List<Arista> listaA = this.getVecinos().get(i);
            List<Arista> listaB = other.getVecinos().get(i);

            // Utiliza el método equals de las listas para compararlas
            if (!Objects.equals(listaA, listaB)) {
                return false;
            }
        }
		
		return true;
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Grafo con ").append(cantVertices).append(" vértices:\n");
	    for (int i = 0; i < vecinos.size(); i++) {
	        sb.append("Vértice ").append(i).append(":\n");
	        List<Arista> vecino = vecinos.get(i);
	        for (Arista arista : vecino) {
	            sb.append("  -> ").append(arista).append("\n");
	        }
	    }
	    return sb.toString();
	}
	
}
