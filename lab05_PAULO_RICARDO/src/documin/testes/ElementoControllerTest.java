package documin.testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.controladores.DocumentoController;
import documin.controladores.ElementoController;

class ElementoControllerTest {
	private DocumentoController documentoController;
	private ElementoController elementoController;

	@BeforeEach
	public void setUp() {
		this.documentoController  = new DocumentoController();
		this.elementoController  = new ElementoController(documentoController);
		documentoController.criaDocumento("Meu doc", 1);
		documentoController.criaDocumento("Artigo", 2);
	}
	
	@Test
	void testCriarTexto() {
		int posicao = elementoController.criarTexto("Meu doc", 1, "Exemplo de texto");
		assertEquals(0, posicao);
	}
	
	@Test
	void testCriarElementoDocumentoInexistente() {
		try {
			elementoController.criarTexto("doc2", 1, "Exemplo de texto");
		} catch (NoSuchElementException e) {
			assertEquals("O DOCUMENTO NÃO EXISTE!", e.getMessage());
		}
	}
	
	@Test
	void testCriarElementoDocumentoCheio() {
		testCriarTexto();
		
		try {
			testCriarTexto();
		} catch (IndexOutOfBoundsException e) {
			assertEquals("O DOCUMENTO ATINGIU SEU LIMITE!", e.getMessage());
		}
	}
	
	@Test
	void testCriarElementoPrioridadeInvalida() {
		try {
			elementoController.criarTexto("Meu doc", 6, "Exemplo de texto");
		} catch (IllegalArgumentException e) {
			assertEquals("PRIORIDADE INVÁLIDA!", e.getMessage());
		}
	}
	
	@Test
	void testCriarTituloSemLink() {
		int posicao = elementoController.criarTitulo("Meu doc", 1, "Elementos simples", 3, false);
		assertEquals(0, posicao);
	}
	
	@Test
	void testCriarTituloLinkavel() {
		int posicao = elementoController.criarTitulo("Meu doc", 1, "Documentos Texto", 1, true);
		assertEquals(0, posicao);
	}
	
	@Test
	void testCriarTituloNivelInvalido() {
		try {
			elementoController.criarTitulo("Meu doc", 3, "Documentos Texto", 6, true);
		} catch (IllegalArgumentException e) {
			assertEquals("NÍVEL INVÁLIDO!", e.getMessage());
		}
	}
	
	@Test
	void testCriarLista() {
		int posicao = elementoController.criarLista("Meu doc", 1, "Exemplo | de uma lista | de 3 termos", "|", "-");
		assertEquals(0, posicao);
	}
	
	@Test
	void testCriarTermosOrdemAlfabetica() {
		int posicao = elementoController.criarTermos("Meu doc", 4, "Teste / termos / Aleatórios", "/", "Alfabética");
		assertEquals(0, posicao);
	}
	
	@Test
	void testCriarTermosSemOrdem() {
		int posicao = elementoController.criarTermos("Meu doc", 4, "Teste / termos / Aleatórios", "/", "nenhuma");
		assertEquals(0, posicao);
	}
	
	@Test
	void testCriarTermosOrdemTamanho() {
		int posicao = elementoController.criarTermos("Meu doc", 4, "Teste / termos / Aleatórios", "/", "tamanho");
		assertEquals(0, posicao);
	}
	
	@Test
	void testCriarTermosOrdemInvalida() {
		try {
			elementoController.criarTermos("Meu doc", 4, "Teste / termos / Aleatórios", "/", "numérica");
		} catch (IllegalArgumentException e) {
			assertEquals("ORDEM INVÁLIDA!", e.getMessage());
		}
	}
	
	@Test
	void testPegarRepresentacaoCompletaTexto() {
		testCriarTexto();
		String toString = elementoController.pegarRepresentacaoCompleta("Meu doc", 0);
		assertEquals("Exemplo de texto", toString);
	}
	
	@Test
	void testPegarRepresentacaoResumidaTexto() {
		testCriarTexto();
		String toString = elementoController.pegarRepresentacaoResumida("Meu doc", 0);
		assertEquals("Exemplo de texto", toString);
	}
	
	@Test
	void testPegarRepresentacaoCompletaTituloSemLink() {
		testCriarTituloSemLink();
		String toString = elementoController.pegarRepresentacaoCompleta("Meu doc", 0);
		assertEquals("3. Elementos simples", toString);
	}
	
	@Test
	void testPegarRepresentacaoResumidaTituloSemLink() {
		testCriarTituloSemLink();
		String toString = elementoController.pegarRepresentacaoResumida("Meu doc", 0);
		assertEquals("3. Elementos simples", toString);
	}
	
	@Test
	void testPegarRepresentacaoCompletaTituloLinkavel() {
		testCriarTituloLinkavel();
		String toString = elementoController.pegarRepresentacaoCompleta("Meu doc", 0);
		assertEquals("1. Documentos Texto -- 1-DOCUMENTOSTEXTO", toString);
	}
	
	@Test
	void testPegarRepresentacaoResumidaTituloLinkavel() {
		testCriarTituloLinkavel();
		String toString = elementoController.pegarRepresentacaoResumida("Meu doc", 0);
		assertEquals("1. Documentos Texto", toString);
	}
	
	@Test
	void testPegarRepresentacaoCompletaLista() {
		testCriarLista();
		String toString = elementoController.pegarRepresentacaoCompleta("Meu doc", 0);
		assertEquals("- Exemplo"
				+ "\n- de uma lista"
				+ "\n- de 3 termos", toString);
	}
	
	@Test
	void testPegarRepresentacaoResumidaLista() {
		testCriarLista();
		String toString = elementoController.pegarRepresentacaoResumida("Meu doc", 0);
		assertEquals("Exemplo | de uma lista | de 3 termos", toString);
	}
	
	@Test
	void testPegarRepresentacaoCompletaTermosOrdemAlfabetca() {
		testCriarTermosOrdemAlfabetica();
		String toString = elementoController.pegarRepresentacaoCompleta("Meu doc", 0);
		assertEquals("Total termos: 3\n" + "- Aleatórios, termos, Teste", toString);
	}
	
	@Test
	void testPegarRepresentacaoResumidaTermosOrdemAlfabetca() {
		testCriarTermosOrdemAlfabetica();
		String toString = elementoController.pegarRepresentacaoResumida("Meu doc", 0);
		assertEquals("Aleatórios / termos / Teste", toString);
	}
	
	@Test
	void testPegarRepresentacaoCompletaTermosSemOrdem() {
		testCriarTermosSemOrdem();
		String toString = elementoController.pegarRepresentacaoCompleta("Meu doc", 0);
		assertEquals("Total termos: 3\n" + "- Teste, termos, Aleatórios", toString);
	}
	
	@Test
	void testPegarRepresentacaoResumidaTermosSemOrdem() {
		testCriarTermosSemOrdem();
		String toString = elementoController.pegarRepresentacaoResumida("Meu doc", 0);
		assertEquals("Teste / termos / Aleatórios", toString);
	}
	
	@Test
	void testPegarRepresentacaoCompletaTermosOrdemTamanho() {
		testCriarTermosOrdemTamanho();
		String toString = elementoController.pegarRepresentacaoCompleta("Meu doc", 0);
		assertEquals("Total termos: 3\n" + "- Aleatórios, termos, Teste", toString);
	}
	
	@Test
	void testPegarRepresentacaoResumidaTermosOrdemTamanho() {
		testCriarTermosOrdemTamanho();
		String toString = elementoController.pegarRepresentacaoResumida("Meu doc", 0);
		assertEquals("Aleatórios / termos / Teste", toString);
	}
	
	@Test
	void testMoverElementoParaCima() {
		int posicao1 = elementoController.criarTexto("Artigo", 1, "Exemplo de texto");
		assertEquals(0, posicao1);
		int posicao2 = elementoController.criarTexto("Artigo", 1, "Exemplo movido para cima");
		assertEquals(1, posicao2);
		
		elementoController.moverParaCima("Artigo", 1);
		
		String toString1 = elementoController.pegarRepresentacaoResumida("Artigo", 0);
		assertEquals("Exemplo movido para cima", toString1);
		String toString2 = elementoController.pegarRepresentacaoResumida("Artigo", 1);
		assertEquals("Exemplo de texto", toString2);
	}
	
	@Test
	void testMoverElementoParaBaixo() {
		int posicao1 = elementoController.criarTexto("Artigo", 1, "Exemplo movido para baixo");
		assertEquals(0, posicao1);
		int posicao2 = elementoController.criarTexto("Artigo", 1, "Exemplo de texto");
		assertEquals(1, posicao2);
		
		elementoController.moverParaBaixo("Artigo", 0);
		
		String toString1 = elementoController.pegarRepresentacaoResumida("Artigo", 0);
		assertEquals("Exemplo de texto", toString1);
		String toString2 = elementoController.pegarRepresentacaoResumida("Artigo", 1);
		assertEquals("Exemplo movido para baixo", toString2);
	}
	
	@Test
	void testMoverPrimeiroElementoParaCima() {
		elementoController.criarTexto("Artigo", 1, "Exemplo de texto");
		elementoController.criarTexto("Artigo", 1, "Exemplo movido para cima");
		
		elementoController.moverParaCima("Artigo", 0);
		
		String toString1 = elementoController.pegarRepresentacaoResumida("Artigo", 0);
		assertEquals("Exemplo de texto", toString1);
	}
	
	@Test
	void testMoverUltimoElementoParaBaixo() {
		elementoController.criarTexto("Artigo", 1, "Exemplo movido para baixo");
		elementoController.criarTexto("Artigo", 1, "Exemplo de texto");
		
		elementoController.moverParaBaixo("Artigo", 1);
		
		String toString = elementoController.pegarRepresentacaoResumida("Artigo", 1);
		assertEquals("Exemplo de texto", toString);
	}
	
	@Test
	void testCriarAtalho() {
		int posicao = elementoController.criarAtalho("Meu doc", "Artigo");
		assertEquals(0, posicao);
	}
	
	@Test
	void testCriarAtalhoInválido() {
		testCriarAtalho();
		
		// Tenta criar um Atalho em um documento referenciado por outro documento anteriormente.
		try {
			elementoController.criarAtalho("Artigo", "Meu doc");
		} catch (IllegalStateException e) {
			assertEquals("O ATALHO NÃO PODE SER CRIADO!", e.getMessage());
		} 
	}

}
