package app.componentes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Grafo {
	private int cantVertices;
	private List<List<Arista>> vecinos;

	public Grafo(int cantVertices) {
		validarVertices(cantVertices);
		this.cantVertices = cantVertices;
		vecinos = new ArrayList<>(cantVertices);
		for (int i = 0; i < cantVertices; ++i)
			vecinos.add(new ArrayList<>());
	}

	private void validarVertices(int cantVertices) {
		if (cantVertices < 1) {
			throw new IllegalArgumentException("La cantidad de vértices es incorrecta para un grafo");
		}
	}

	public Grafo(int cantVertices, List<List<Arista>> vecinos) {
		this.cantVertices = cantVertices;
		this.vecinos = vecinos;
	}

	public void agregarArista(int origen, int destino, int peso) {
		validarAristas(origen, destino, peso);
		vecinos.get(origen).add(new Arista(origen, destino, peso));
		vecinos.get(destino).add(new Arista(destino, origen, peso));
	}

	private void validarAristas(int origen, int destino, int peso) {
		if (origen < 0 || destino < 0 || peso < 1) {
			throw new IllegalArgumentException("Los índices o peso indicados no son válidos. " + "Origen: " + origen
					+ ", destino: " + destino + ", peso: " + peso);
		}
		if (origen == destino) {
			throw new IllegalArgumentException("origen y destino son iguales");
		}
	}

	public int getCantVertices() {
		return this.cantVertices;
	}

	public List<List<Arista>> getVecinos() {
		return vecinos;
	}
	
	/**
	 * Este metodo servirá para visualizar datos sobre el grafo, 
	 * tales como los vértices y las aristas. 
	 */
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
