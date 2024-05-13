package app;

import java.util.ArrayList;
import java.util.List;

import app.componentes.Grafo;

public class Programa {

	private Grafo grafo;
	private Grafo grafoArbolGeneradorMinimo;

	public void construirGrafo(int cantidadVertices) {
		this.grafo = new Grafo(cantidadVertices);
	}
	
	public void agregarTodasLasAristas(ArrayList<int[]> coleccionAristas) {
		for (int[] arista : coleccionAristas) {
			this.agregarArista(arista[0], arista[1], arista[2]);
		}
	}

	public void agregarArista(int vertice1, int vertice2, int peso) {
		this.grafo.agregarArista(vertice1, vertice2, peso);
		this.grafo.agregarArista(vertice2, vertice1, peso);
	}

	public void generarArbolMinimo() {
		grafoArbolGeneradorMinimo = new Grafo(this.grafo.obtenerTamano());
        grafoArbolGeneradorMinimo.generarArbolMinimo(this.grafo);
    }
	
	public void eliminarAristasMayorPeso(int cantidadAEliminar) {
		this.grafoArbolGeneradorMinimo.eliminarMayoresAristas(cantidadAEliminar);
	}
	
	public void encontrarGrafosConexos() {
		List<List<Integer>> lista = this.grafoArbolGeneradorMinimo.encontrarGrafosConexos();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Grafo Conexo " + (i + 1) + ": " + lista.get(i));
        }
	}
	
	public void imprimirMatrizAdyacencia() {
		grafo.imprimirMatrizAdyacencia();
	}
}