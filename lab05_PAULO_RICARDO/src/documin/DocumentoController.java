package documin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class DocumentoController {
	Map<String, Documento> documentos;
	
	public DocumentoController() {
		documentos = new HashMap<>();
	}
	
	public boolean criaDocumento(String tituloDoc) {
		if (tituloDoc.isBlank() || tituloDoc.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO INVÁLIDO!");
		} else if (documentos.containsKey(tituloDoc)) {
			return false;
		}
		
		return true;
	}
	
	public boolean criaDocumento(String tituloDoc, int tamanhoMaximo) {
		if (tituloDoc.isBlank() || tituloDoc.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO INVÁLIDO!");
		} else if (tamanhoMaximo <= 0) {
			throw new IllegalArgumentException("TAMANHO INVÁLIDO!");
		} else if (documentos.containsKey(tituloDoc)) {
			return false;
		}
		
		Documento doc = new Documento(tituloDoc, tamanhoMaximo);
		return true;
	}
	
	public void removerDocumento(String tituloDoc) {
		if (!documentos.containsKey(tituloDoc)) {
			throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE!");
		}
		
		documentos.remove(tituloDoc);
	}
	
	public int contarElementos(String tituloDoc) {
		if (!documentos.containsKey(tituloDoc)) {
			throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE!");
		}
		
		return documentos.get(tituloDoc).getQtdeElementos();
	}
	
	public String[] exibirDocumento(String tituloDoc) {
		if (!documentos.containsKey(tituloDoc)) {
			throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE!");
		}
		
		return documentos.get(tituloDoc).toString();
	}
	
	
}
