package app.componentes.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import app.componentes.Grafo;

class GrafoTest {
	
	@Test
	void testCrearGrafo() {
	    Grafo grafo = new Grafo(5);
	    assertEquals(5, grafo.getCantVertices());
	    assertEquals(5, grafo.getVecinos().size());
	}
	
	@Test
	public void testGrafoVerticesIncorrectos() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Grafo(-5);
	    });
	}
	
	@Test
	public void testAgregadoAristasPesoInvalido() {
		Grafo grafo = new Grafo(5);
		assertThrows(IllegalArgumentException.class, () -> {
	        grafo.agregarArista(0, 0, -3);
	    });
	}
	
	@Test
	public void testAgregadoAristasOrigenInvalido() {
		Grafo grafo = new Grafo(5);
		assertThrows(IllegalArgumentException.class, () -> {
	        grafo.agregarArista(-1, 0, 2);
	    });
	}
	
	@Test
	public void testAgregadoAristasDestinoInvalido() {
		Grafo grafo = new Grafo(5);
		assertThrows(IllegalArgumentException.class, () -> {
	        grafo.agregarArista(2, -1, 2);
	    });
	}
	
	@Test
	public void testAgregadoAristasMismoOrigenDestino() {
		Grafo grafo = new Grafo(5);
		assertThrows(IllegalArgumentException.class, () -> {
	        grafo.agregarArista(2, 2, 2);
	    });
	}
	
	@Test
	public void testAgregadoAristasMayorQueVertices() {
		Grafo grafo = new Grafo(5);
		assertThrows(IllegalArgumentException.class, () -> {
	        grafo.agregarArista(5, 2, 2);
	    });
	}

	
}
