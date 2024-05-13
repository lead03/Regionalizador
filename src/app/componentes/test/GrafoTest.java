package app.componentes.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import app.componentes.Grafo;

class GrafoTest {
	private Grafo grafo;
	
	private Grafo declararGrafoDisconexo15Vertices() {
		Grafo grafo = new Grafo(5);
		int[][] matriz = {	
				{0, 3, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0}, 
				{0, 5, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{2, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 4}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0, 4, 0, 3, 5, 0, 0, 0, 0}, 
				{0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 4, 0, 4, 0, 0, 0, 0, 0, 0}
				};
		grafo.setMatrizIncidencia(matriz);
		return grafo;
	}

	@Test
	public void verificarAristaExistente() {
		Grafo grafo = declararGrafoDisconexo15Vertices();
		assertTrue(grafo.existeArista(1, 2));
		assertTrue(grafo.existeArista(0, 4));
		assertTrue(grafo.existeArista(1, 0));
		assertTrue(grafo.existeArista(2, 1));
		assertFalse(grafo.existeArista(0, 3));
		assertFalse(grafo.existeArista(14, 4));
	}

}
