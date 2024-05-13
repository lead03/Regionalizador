package app;

import java.util.ArrayList;

import app.componentes.Grafo;
//ESTA CLASE ES SOLO PARA MOSTRAR COMO SERIA EL FLUJO DEL PROGRAMA
public class Principal {

	public static void main(String[] args) {
		// Genero como que atrapo las entradas
		int vertices = 6;
		ArrayList<int[]> aristasConPeso = new ArrayList<>();
		int[] arista1 = {0, 1, 3};
		int[] arista2 = {0, 2, 4};
		int[] arista3 = {4, 5, 3};
		int[] arista4 = {3, 5, 8};
		int[] arista5 = {0, 5, 6};
		int[] arista6 = {0, 4, 6};
		int aristasAEliminar = 1;
		aristasConPeso.add(arista1);
		aristasConPeso.add(arista2);
		aristasConPeso.add(arista3);
		aristasConPeso.add(arista4);
		aristasConPeso.add(arista5);
		aristasConPeso.add(arista6);
		//fin generar
		
		//Esta será la lógica una vez que atrapemos lo que introduzca el usuario:
		Programa programa = new Programa();
		
		//Construimos el grafo
		programa.construirGrafo(vertices);
		programa.imprimirMatrizAdyacencia();
		System.out.println("______________");
		
		//Agregamos todas las aristas a nuestra matriz de adyacencia con peso
		programa.agregarTodasLasAristas(aristasConPeso);
		programa.imprimirMatrizAdyacencia();
		System.out.println("______________");
		
		//Generamos el arbol generador mínimo
		//TODO metodo generarArbolMinimo() no anda, rehacer
		programa.generarArbolMinimo();
		programa.imprimirMatrizAdyacencia();
		System.out.println("______________");
		
		//Eliminamos la cantidad de aristas de mayor peso que queremos
		programa.eliminarAristasMayorPeso(aristasAEliminar);
		System.out.println("______________");
		
		//Finalmente encontramoslos distintos grafos conexos.
		programa.encontrarGrafosConexos();
		
	}

}
