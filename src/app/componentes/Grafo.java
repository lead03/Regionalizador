package app.componentes;

import java.util.HashSet;
import java.util.Set;

public class Grafo {
	private boolean[][]A;
	
	public Grafo(int vertices) {
		A = new boolean[vertices][vertices];
	}
	
	public void insertarArista(int i, int j) {
		A[i][j] = true;
		A[j][i] = true;
	}
	
	public boolean existeArista (int vertice1, int vertice2) {
		return A[vertice1][vertice2];
	}
	
	private int tamano()
	{
		return A.length;
	}

	
	public Set<Integer> obtenerVecinos (int indiceArista){
		Set<Integer> ret = new HashSet<Integer>();
		for(int j = 0; j < this.tamano(); ++j) if( indiceArista != j )
		{
			if( this.existeArista(indiceArista,j) )
				ret.add(j);
		}	
		return ret;
	}
}
