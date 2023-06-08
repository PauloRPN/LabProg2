package documin.testes.elemento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.elemento.Titulo;

class TituloTest {
	private Titulo tituloSemLink;
	private Titulo tituloLinkavel;
	
	@BeforeEach
	public void setUp() {
		this.tituloSemLink = new Titulo(1, "Elementos simples", 3, false);
		this.tituloLinkavel = new Titulo(2, "Documentos Texto", 1, true);
	}
	
	@Test
	void testToStringCompletoSemLink() {
		assertEquals("3. Elementos simples", tituloSemLink.toStringCompleto());
	}
	
	@Test
	void testToStringResumidoSemLink() {
		assertEquals("3. Elementos simples", tituloSemLink.toStringResumido());
	}
	
	@Test
	void testToStringCompletoLinkavel() {
		assertEquals("1. Documentos Texto -- 1-DOCUMENTOSTEXTO", tituloLinkavel.toStringCompleto());
	}
	
	@Test
	void testToStringResumidoLinkavel() {
		assertEquals("1. Documentos Texto", tituloLinkavel.toStringResumido());
	}

}
