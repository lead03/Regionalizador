package app.componentes.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import app.componentes.Arista;
import app.componentes.Grafo;

public class GrafoTestConfig {
	
	private static int A = 0;
	private static int B = 1;
	private static int C = 2;
	private static int D = 3;
	private static int F = 4;
	private static int G = 5;
	private static int H = 6;
	private static int I = 7;
	private static int E = 8;
	
	
	public static Queue<Arista> builAgmEsperado() {
		Queue<Arista> agm = new PriorityQueue<>(Comparator.comparingInt(Arista::getPeso).reversed());
		
		agm.add(new Arista(A, B, 4));
		agm.add(new Arista(A, H, 8));
		agm.add(new Arista(H, G, 1));
		agm.add(new Arista(G, F, 3));
		agm.add(new Arista(F, C, 4));
		agm.add(new Arista(C, I, 3));
		agm.add(new Arista(C, D, 6));
		agm.add(new Arista(D, E, 9));
		
		return agm;
	}
	public static Grafo builGrafoConexo() {
		Grafo grafo = new Grafo(9);

		grafo.agregarArista(A, B, 4);
		grafo.agregarArista(A, H, 8);
		grafo.agregarArista(B, C, 8);
		grafo.agregarArista(B, H, 12);
		grafo.agregarArista(H, I, 6);
		grafo.agregarArista(G, F, 3);
		grafo.agregarArista(H, G, 1);
		grafo.agregarArista(C, I, 3);
		grafo.agregarArista(C, F, 4);
		grafo.agregarArista(C, D, 6);
		grafo.agregarArista(I, G, 5);
		grafo.agregarArista(D, F, 13);
		grafo.agregarArista(D, E, 9);
		grafo.agregarArista(F, E, 10);
		
		return grafo;
	}

}
