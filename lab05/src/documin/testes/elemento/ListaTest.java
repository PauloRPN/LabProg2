package documin.testes.elemento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.elemento.Lista;

class ListaTest {
	private Lista lista;
	
	@BeforeEach
	public void setUp() {
		this.lista = new Lista(1, "Exemplo | de uma lista | de 3 termos", "|", "-");
	}
	
	@Test
	void testToStringCompleto() {
		String toString = lista.toStringCompleto();
		assertEquals("- Exemplo"
				+ "\n- de uma lista"
				+ "\n- de 3 termos", toString);
	}
	
	@Test
	void testToStringResumido() {
		String toString = lista.toStringResumido();
		assertEquals("Exemplo | de uma lista | de 3 termos", toString);
	}

}
