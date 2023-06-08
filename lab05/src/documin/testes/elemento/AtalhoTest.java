package documin.testes.elemento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.documento.Documento;
import documin.elemento.Atalho;

class AtalhoTest {
	private Atalho atalho;
	
	@BeforeEach
	public void setUp() {
		Documento documento = new Documento("doc");
		documento.criarTermos(4, "Teste / termos / Aleatórios", "/", "nenhuma");
		documento.criarTitulo(5, "Documentos Texto", 1, true);
		this.atalho = new Atalho(documento);
	}
	
	@Test
	void testToStringCompletoAtalho() {
		String toString = atalho.toStringCompleto();
		assertEquals("Total termos: 3\n- Teste, termos, Aleatórios"
				+ "\n1. Documentos Texto -- 1-DOCUMENTOSTEXTO", toString);
	}
	
	@Test
	void testToStringResumidoAtalho() {
		String toString = atalho.toStringResumido();
		assertEquals("Teste / termos / Aleatórios"
				+ "\n1. Documentos Texto", toString);
	}
}
