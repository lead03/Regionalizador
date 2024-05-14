package app.componentes.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Queue;

import app.Programa;
import app.componentes.Arista;

class GrafoTest {
	
	

	@Test
	public void agm() {
		
		Programa pro = new Programa();
		Queue<Arista> agm = pro.agm(GrafoDummy.builGrafoConexo());
		Queue<Arista> agmEsperado = GrafoDummy.builAgmEsperado();
		
		print(agm);
		assertTrue(equalList(agm, agmEsperado));
	}

	private void print(Queue<Arista> agm) {
		for(Arista arista: agm) {
			System.out.println("Arista: "+arista.getOrigen()+" >> " +arista.getDestino() + ", Peso: "+ arista.getPeso());
		}
	}
	
	private boolean equalList(Queue<Arista> a, Queue<Arista> b) {
		return a.equals(b);
	}
}
