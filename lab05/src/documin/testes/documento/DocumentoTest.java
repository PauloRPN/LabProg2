package documin.testes.documento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.documento.Documento;

class DocumentoTest {
	private Documento documento;
	private Documento doc2;
	
	@BeforeEach
	public void setUp() {
		this.documento = new Documento("doc");
		this.doc2  = new Documento("doc2");
	}
	
	@Test
	void testCriarTexto() {
		int posicao = documento.criarTexto(2, "Exemplo de texto");
		assertEquals(0, posicao);
	}
	
	@Test
	void testCriarTituloSemLink() {
		int posicao = documento.criarTitulo(1, "Elementos simples", 3, false);
		assertEquals(0, posicao);
	}
	
	@Test
	void testCriarTituloLinkavel() {
		int posicao = documento.criarTitulo(1, "Elementos simples", 3, true);
		assertEquals(0, posicao);
	}
	
	@Test
	void testCriarLista() {
		int posicao = documento.criarLista(1, "Exemplo | de uma lista | de 3 termos", "|", "-");
		assertEquals(0, posicao);
	}
	
	@Test
	void testCriarTermosOrdemAlfabetica() {
		int posicao = documento.criarTermos(4, "Teste / termos / Aleatórios", "/", "Alfabética");
		assertEquals(0, posicao);
	}
	
	@Test
	void testCriarTermosSemOrdem() {
		int posicao = documento.criarTermos(4, "Teste / termos / Aleatórios", "/", "nenhuma");
		assertEquals(0, posicao);
	}
	
	@Test
	void testCriarTermosOrdemTamanho() {
		int posicao = documento.criarTermos(4, "Teste / termos / Aleatórios", "/", "tamanho");
		assertEquals(0, posicao);
	}
	
	@Test
	void testRepresentacaoCompleta() {
		testCriarLista();
		String toString = documento.pegarRepresentacaoCompleta(0);
		assertEquals("- Exemplo"
				+ "\n- de uma lista"
				+ "\n- de 3 termos", toString);
	}
	
	@Test
	void testRepresentacaoResumida() {
		testCriarTituloLinkavel();
		String toString = documento.pegarRepresentacaoResumida(0);
		assertEquals("3. Elementos simples", toString);
	}
	
	@Test
	void testMoverElementoParaCima() {
		int posicao1 = documento.criarTexto(1, "Exemplo de texto");
		int posicao2 = documento.criarTexto(1, "Exemplo movido para cima");
		
		documento.moverParaCima(1);
		
		String toString1 = documento.pegarRepresentacaoResumida(0);
		assertEquals("Exemplo movido para cima", toString1);
		String toString2 = documento.pegarRepresentacaoResumida(1);
		assertEquals("Exemplo de texto", toString2);
	}
	
	@Test
	void testMoverElementoParaBaixo() {
		int posicao1 = documento.criarTexto(1, "Exemplo movido para baixo");
		int posicao2 = documento.criarTexto(1, "Exemplo de texto");
		
		documento.moverParaBaixo(0);
		
		String toString1 = documento.pegarRepresentacaoResumida(0);
		assertEquals("Exemplo de texto", toString1);
		String toString2 = documento.pegarRepresentacaoResumida(1);
		assertEquals("Exemplo movido para baixo", toString2);
	}
	
	@Test
	void testCriarAtalho() {
		int posicao = doc2.criarAtalho(documento);
		assertEquals(0, posicao);
	}
	
	@Test
	void testGetMediaPrioridade() {
		documento.criarTexto(1, "Exemplo de texto");
		documento.criarTexto(4, "Exemplo movido para cima");
		
		int media = documento.getMediaPrioridade();
		assertEquals(2, media);
	}
	
	@Test
	void testIsAtalho() {
		testCriarAtalho();
		assert documento.isAtalho();
		assert !doc2.isAtalho();
	}
	
	@Test
	void testTemAtalho() {
		testCriarAtalho();
		assert !documento.temAtalho();
		assert doc2.temAtalho();
	}
	
}
