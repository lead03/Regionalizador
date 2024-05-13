package app.componentes;

import java.util.HashSet;
import java.util.Set;

public class Grafo {
	private int[][] matrizAdyacenciaConPesos;

	public Grafo(int vertices) {
		matrizAdyacenciaConPesos = new int[vertices][vertices];
	}

	public void insertarArista(int i, int j, int peso) {
		matrizAdyacenciaConPesos[i][j] = peso;
		matrizAdyacenciaConPesos[j][i] = peso;
	}

	public void eliminarArista(int i, int j) {
		matrizAdyacenciaConPesos[i][j] = 0;
		matrizAdyacenciaConPesos[j][i] = 0;
	}

	public boolean existeArista(int vertice1, int vertice2) {
		return matrizAdyacenciaConPesos[vertice1][vertice2] > 0;
	}

	private int obtenerTamano() {
		return matrizAdyacenciaConPesos.length;
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

	public void generarArbolMinimo(Grafo grafoEntrada) {
		throw new UnsupportedOperationException("Crear algoritmo de prim que haga el arbol minimo generador");
	}

	public void eliminarMayoresAristas(int cantidadAEliminar) {
		for (int i = 0; i < cantidadAEliminar; i++) {
			int[] aristaAEliminar = obtenerAristaDeMayorPeso(this.matrizAdyacenciaConPesos);
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
}
