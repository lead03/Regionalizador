package app.componentes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Grafo {
	private int[][] matrizAdyacencia;
	private int numVertices;

	public Grafo(int numVertices) {
		this.numVertices = numVertices;
		this.matrizAdyacencia = new int[numVertices][numVertices];
	}

	public void setMatrizIncidencia(int[][] matriz) {
		this.matrizAdyacencia = matriz;
	}

	private int[][] accederMatrizIncidencia(Grafo grafo) {
		return grafo.matrizAdyacencia;
	}

	public void agregarArista(int i, int j, int peso) {
		matrizAdyacencia[i][j] = peso;
		matrizAdyacencia[j][i] = peso;
	}

	public void eliminarArista(int i, int j) {
		matrizAdyacencia[i][j] = 0;
		matrizAdyacencia[j][i] = 0;
	}

	public boolean existeArista(int vertice1, int vertice2) {
		return matrizAdyacencia[vertice1][vertice2] > 0;
	}

	public int obtenerTamano() {
		return matrizAdyacencia.length;
	}

	public int getArista(int verticeOrigen, int verticeDestino) {
		return matrizAdyacencia[verticeOrigen][verticeDestino];
	}

	public Set<Integer> obtenerVecinos(int indiceArista) {
		Set<Integer> ret = new HashSet<Integer>();
		for (int j = 0; j < this.obtenerTamano(); ++j)
			if (indiceArista != j) {
				if (this.existeArista(indiceArista, j))
					ret.add(j);
			}
		return ret;
	}

	//TODO no lo pude hacer andar bien a este algoritmo :/
	public void generarArbolMinimo(Grafo grafoOriginal) {
		throw new UnsupportedOperationException("FALTA IMPLEMENTAR CORRECTAMENTE");
	}

	public void eliminarMayoresAristas(int cantidadAEliminar) {
		for (int i = 0; i < cantidadAEliminar; i++) {
			int[] aristaAEliminar = obtenerAristaDeMayorPeso(this.matrizAdyacencia);
			eliminarArista(aristaAEliminar[0], aristaAEliminar[1]);
		}
	}

	private static int[] obtenerAristaDeMayorPeso(int[][] matrizSimetricaSinLoops) {
		int maximo = 0;
		int[] posicionMaximo = new int[2];
		for (int i = 1; i < matrizSimetricaSinLoops.length; i++) {
			for (int j = i; j < matrizSimetricaSinLoops[i].length; j++) {
				if (matrizSimetricaSinLoops[i][j] > maximo) {
					maximo = matrizSimetricaSinLoops[i][j];
					posicionMaximo[0] = i;
					posicionMaximo[1] = j;
				}
			}
		}
		return posicionMaximo;
	}

	public List<List<Integer>> encontrarGrafosConexos() {
		int[][] matriz = accederMatrizIncidencia(this);
		int n = matriz.length;
		boolean[] visitado = new boolean[n];
		List<List<Integer>> grafosConexos = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (!visitado[i]) {
				List<Integer> verticesConexos = new ArrayList<>();
				bfs(i, matriz, visitado, verticesConexos);
				grafosConexos.add(verticesConexos);
			}
		}

		return grafosConexos;
	}

	public static void bfs(int verticeInicial, int[][] matriz, boolean[] visitado, List<Integer> verticesConexos) {
		Queue<Integer> cola = new LinkedList<>();
		cola.offer(verticeInicial);
		visitado[verticeInicial] = true;

		while (!cola.isEmpty()) {
			int vertice = cola.poll();
			verticesConexos.add(vertice);

			for (int i = 0; i < matriz[vertice].length; i++) {
				if (matriz[vertice][i] != 0 && !visitado[i]) {
					cola.offer(i);
					visitado[i] = true;
				}
			}
		}
	}

	public void imprimirMatrizAdyacencia() {
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				System.out.print(matrizAdyacencia[i][j] + " ");
			}
			System.out.println();
		}
	}
}
