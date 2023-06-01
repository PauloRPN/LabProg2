package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controladores.DocumentoController;
import controladores.ElementoController;

class ElementoControllerTest {
	private DocumentoController documentoController = new DocumentoController();
	private ElementoController elementoController = new ElementoController(documentoController);

	
	@Test
	void test() {
		documentoController.criaDocumento("sla");
		documentoController.criaDocumento("sla1", 3);
		elementoController.criarAtalho("sla", "sla1");
		
		try {
			elementoController.criarAtalho("sla1", "sla");
		} catch (IllegalStateException ise) {
			assertEquals("O ATALHO NÃO PODE SER CRIADO!", ise.getMessage());
		} 
	}

}
