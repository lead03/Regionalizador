package app;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import app.componentes.Arista;
import app.componentes.Grafo;

public class ServicioRegionalizador {
	
	public Queue<Arista> calcularRegiones(int regiones, Grafo grafo) {
		Queue<Arista> agm = agm(grafo);
		
		for(int x= 1; x <= regiones; x++) {
			agm.poll();
		}
		
		
		return agm;
	}
	
	public PriorityQueue<Arista> agm(Grafo grafo) {
		boolean[] visitado = new boolean[grafo.getCantVertices()];
		PriorityQueue<Arista> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(a -> a.getPeso()));
		PriorityQueue<Arista> arbolGenerador = new PriorityQueue<>(Comparator.comparingInt(Arista::getPeso).reversed());
		
		visitado[0] = true;
		for (Arista arista : grafo.getVecinos().get(0)) {
			colaPrioridad.add(arista);
		}
		
		while (!colaPrioridad.isEmpty()) {
			Arista aristaActual = colaPrioridad.poll();
			int nodoActual = aristaActual.getDestino();
			
			if (visitado[nodoActual]) continue;
			
			visitado[nodoActual] = true;
			arbolGenerador.add(aristaActual);
			for (Arista vecino : grafo.getVecinos().get(nodoActual)) {
				if (!visitado[vecino.getDestino()]) {
					colaPrioridad.add(vecino);
				}
			}
		}
		
		 
		return arbolGenerador;
	}
	
	private void print(List<List<Arista>> vecinos) {
		
		for(List<Arista> vertices : vecinos) {
			for(Arista arista: vertices) {
				
				System.out.println("Arista: "+arista.getOrigen()+" >> " +arista.getDestino() + ", Peso: "+ arista.getPeso());
			}
		}
	}
}