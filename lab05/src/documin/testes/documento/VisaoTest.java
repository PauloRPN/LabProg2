package documin.testes.documento;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.documento.*;

class VisaoTest {
	private Visao visao;
	
	@BeforeEach
	public void setUp() {
		Documento doc = new Documento("doc");
		doc.criarTexto(2, "Exemplo de texto");
		doc.criarTitulo(1, "Documentos Texto", 3, true);
		doc.criarTermos(4, "Teste / termos / Aleatórios", "/", "Alfabética");
		
		this.visao = new Visao(doc);
	}
	
	@Test
	void testVisaoCompleta() {
		String toString = Arrays.toString(visao.visaoCompleta());
		assertEquals("[Exemplo de texto, 3. Documentos Texto -- 3-DOCUMENTOSTEXTO, Total termos: 3\n- Aleatórios, termos, Teste]", toString);
	}
	
	@Test
	void testVisaoResumida() {
		String toString = Arrays.toString(visao.visaoResumida());
		assertEquals("[Exemplo de texto, 3. Documentos Texto, Aleatórios / termos / Teste]", toString);
	}
	
	@Test
	void testVisaoPrioritaria() {
		String toString = Arrays.toString(visao.visaoPrioritaria(2));
		assertEquals("[Exemplo de texto, Aleatórios / termos / Teste]", toString);
	}
	
	@Test
	void testVisaoTitulo() {
		assertEquals("[3. Documentos Texto]", Arrays.toString(visao.visaoTitulo()));
	} 
	
}
