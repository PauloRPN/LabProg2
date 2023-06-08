package documin.testes.elemento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.elemento.Texto;

class TextoTest {
	private Texto texto;
	
	@BeforeEach
	public void setUp() {
		this.texto = new Texto(1, "Exemplo de texto");
	}
	
	@Test
	void testToStringCompleto() {
		assertEquals("Exemplo de texto", texto.toStringCompleto());
	}
	
	@Test
	void testToStringResumido() {
		assertEquals("Exemplo de texto", texto.toStringResumido());
	}

}
