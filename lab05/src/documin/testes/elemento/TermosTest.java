package documin.testes.elemento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import documin.elemento.Termos;

class TermosTest {
	private Termos termos;
	
	void criaTermosSemOrdem() {
		this.termos = new Termos(4, "Teste / termos / Aleatórios", "/", "nenhuma");
	}
	
	void criaTermosOrdemAlfabetica() {
		this.termos = new Termos(4, "Teste / termos / Aleatórios", "/", "alfabética");
	}
	
	void criaTermosOrdemTamanho() {
		this.termos = new Termos(4, "Teste / termos / Aleatórios", "/", "tamanho");
	}
	
	@Test
	void testCriaTermosOrdemInvalida() {
		try {
			this.termos = new Termos(4, "Teste / termos / Aleatórios", "/", "numérica");
			fail("Deveria lançar exceção");
		} catch (IllegalArgumentException e) {
			assertEquals("ORDEM INVÁLIDA!", e.getMessage());
		}
	}
	
	@Test
	void testToStringCompletoTermosSemOrdem() {
		criaTermosSemOrdem();
		String toString = termos.toStringCompleto();
		assertEquals("Total termos: 3\n- Teste, termos, Aleatórios", toString);
	}
	
	@Test
	void testToStringResumidoTermosSemOrdem() {
		criaTermosSemOrdem();
		String toString = termos.toStringResumido();
		assertEquals("Teste / termos / Aleatórios", toString);
	}
	
	@Test
	void testToStringCompletoTermosOrdemAlfabetica() {
		criaTermosOrdemAlfabetica();
		String toString = termos.toStringCompleto();
		assertEquals("Total termos: 3\n- Aleatórios, termos, Teste", toString);
	}
	
	@Test
	void testtoStringResumidoTermosOrdemAlfabetca() {
		criaTermosOrdemAlfabetica();
		String toString = termos.toStringResumido();
		assertEquals("Aleatórios / termos / Teste", toString);
	}
	
	@Test
	void testToStringCompletoTermosOrdemTamanho() {
		criaTermosOrdemTamanho();
		String toString = termos.toStringCompleto();
		assertEquals("Total termos: 3\n" + "- Aleatórios, termos, Teste", toString);
	}
	
	@Test
	void testToStringResumidoTermosOrdemTamanho() {
		criaTermosOrdemTamanho();
		String toString = termos.toStringResumido();
		assertEquals("Aleatórios / termos / Teste", toString);
	}
	
}
