package app;

import app.componentes.Grafo;

public class Programa {

	private Grafo grafo;
	private Grafo grafoArbolGeneradorMinimo;

	public void construirGrafo(int cantidadVertices) {
		this.grafo = new Grafo(cantidadVertices);
	}

	public void agregarArista(int vertice1, int vertice2, int peso) {
		this.grafo.insertarArista(vertice1, vertice2, peso);
	}

	public void generarArbolMinimo() {
		this.grafoArbolGeneradorMinimo.generarArbolMinimo(grafo);
	}
	
	public void eliminarAristasMayorPeso(int cantidadAEliminar) {
		this.grafoArbolGeneradorMinimo.eliminarMayoresAristas(cantidadAEliminar);
	}
}