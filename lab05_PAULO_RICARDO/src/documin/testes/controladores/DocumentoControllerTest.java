package documin.testes.controladores;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.controladores.DocumentoController;
import documin.controladores.ElementoController;

class DocumentoControllerTest {
	private DocumentoController documentoController;
	private ElementoController elementoController;
	
	@BeforeEach
	public void setUp() {
		this.documentoController  = new DocumentoController();
		this.elementoController  = new ElementoController(documentoController);
	}
	
	@Test
	void testCriaDocumento() {
		assert documentoController.criaDocumento("doc");
	}
	
	@Test
	void testCriaDocumentoLimitado() {
		assert documentoController.criaDocumento("doc2", 1);
	}
	
	@Test
	void testCriaDocumentoExistente() {
		testCriaDocumento();
		assert !documentoController.criaDocumento("doc");
	}
	
	@Test
	void testCriaDocumentoTituloVazio() {
		try {
			documentoController.criaDocumento("", 1);
			fail("Deveria lançar exceção!");
		} catch (IllegalArgumentException e) {
			assertEquals("TÍTULO INVÁLIDO!", e.getMessage());
		}
	}
	
	@Test
	void testCriaDocumentoTituloEmBranco() {
		try {
			documentoController.criaDocumento("  ", 1);
			fail("Deveria lançar exceção!");
		} catch (IllegalArgumentException e) {
			assertEquals("TÍTULO INVÁLIDO!", e.getMessage());
		}
	}
	
	@Test
	void testCriaDocumentoTamanhoInvalido() {
		try {
			documentoController.criaDocumento("doc", 0);
			fail("Deveria lançar exceção!");
		} catch (IllegalArgumentException e) {
			assertEquals("TAMANHO INVÁLIDO!", e.getMessage());
		}
	}
	
	@Test
	void testRemoverDocumento() {
		testCriaDocumento();
		documentoController.removerDocumento("doc");
		assert documentoController.criaDocumento("doc");
	}
	
	@Test
	void testExibirDocumento() {
		testCriaDocumento();
		elementoController.criarLista("doc", 1, "Exemplo | de uma lista | de 3 termos", "|", "-");
		String[] retorno = documentoController.exibirDocumento("doc");
		
		assertEquals("[Exemplo | de uma lista | de 3 termos]", Arrays.toString(retorno));
	}
	
	@Test
	void testExibirDocumentoSemElementos() {
		testCriaDocumento();
		String[] retorno = documentoController.exibirDocumento("doc");
		assertEquals("[]", Arrays.toString(retorno));
	}
	
	@Test
	void testCriarVisaoCompleta() {
		testCriaDocumento();
		elementoController.criarLista("doc", 1, "Exemplo | de uma lista | de 3 termos", "|", "-");
		int posicao = documentoController.criarVisaoCompleta("doc");
		assertEquals(0, posicao);
	}
	
	@Test
	void testCriarVisaoResumida() {
		testCriarVisaoCompleta();
		int posicao = documentoController.criarVisaoResumida("doc");
		assertEquals(1, posicao);
	}
	
	@Test
	void testCriarVisaoPrioritaria() {
		testCriarVisaoResumida();
		elementoController.criarTermos("doc", 5, "Exemplo / de termos", "/", "nenhuma");
		int posicao = documentoController.criarVisaoPrioritaria("doc", 4);
		assertEquals(2, posicao);
	}
	
	@Test
	void testCriarVisaoTitulo() {
		testCriarVisaoPrioritaria();
		elementoController.criarTitulo("doc", 3, "Exemplo de título", 3, false);
		int posicao = documentoController.criarVisaoTitulo("doc");
		assertEquals(3, posicao);
	}
	
	@Test
	void testExibirVisaoCompleta() {
		testCriarVisaoTitulo();
		String[] visao = documentoController.exibirVisao(0);
		assertEquals("[- Exemplo"
				+ "\n- de uma lista"
				+ "\n- de 3 termos]", Arrays.toString(visao));
	}
	
	@Test
	void testExibirVisaoResumida() {
		testCriarVisaoTitulo();
		String[] visao = documentoController.exibirVisao(1);
		assertEquals("[Exemplo | de uma lista | de 3 termos]", Arrays.toString(visao));
	}
	
	@Test
	void testExibirVisaoPrioritaria() {
		testCriarVisaoTitulo();
		String[] visao = documentoController.exibirVisao(2);
		assertEquals("[Exemplo / de termos]", Arrays.toString(visao));
	}
	
	@Test
	void testExibirVisaoTitulo() {
		testCriarVisaoTitulo();
		String[] visao = documentoController.exibirVisao(3);
		assertEquals("[3. Exemplo de título]", Arrays.toString(visao));
	}
	
	@Test
	void testExibirVisaoInexistente() {
		testCriarVisaoTitulo();
		
		try {
			documentoController.exibirVisao(4);
			fail("Deveria lançar exceção!");
		} catch (IndexOutOfBoundsException e) {
			assertEquals("ID DE VISÃO INVÁLIDO!", e.getMessage());
		}
	}
	
	@Test
	void testExibirVisaoVazia() {
		testCriaDocumento();
		documentoController.criarVisaoCompleta("doc");
		String[] visao = documentoController.exibirVisao(0);
		assertEquals("[]", Arrays.toString(visao)); // o documento não tem elementos para criar a visão completa
	}
}
