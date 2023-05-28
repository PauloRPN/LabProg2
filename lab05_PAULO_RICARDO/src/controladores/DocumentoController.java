package controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import documento.Documento;

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
		
		documentos.put(tituloDoc, new Documento(tituloDoc));
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
		
		documentos.put(tituloDoc, new Documento(tituloDoc, tamanhoMaximo));
		return true;
	}
	
	public void removerDocumento(String tituloDoc) {
		verificaNoSuchElementException(tituloDoc);
		documentos.remove(tituloDoc);
	}
	
	public int contarElementos(String tituloDoc) {
		verificaNoSuchElementException(tituloDoc);
		return documentos.get(tituloDoc).getQtdeElementos();
	}
	
	public String[] exibirDocumento(String tituloDoc) {
		verificaNoSuchElementException(tituloDoc);
		return documentos.get(tituloDoc).DocumentoToString();
	}
	
	protected Documento getDocumento(String tituloDoc) {
		verificaNoSuchElementException(tituloDoc);
		return documentos.get(tituloDoc);
	}
	
	
	// Metódos que verificam exceções
	
	private void verificaNoSuchElementException(String tituloDoc) {
		if (!documentos.containsKey(tituloDoc)) {
			throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE!");
		}
	}
	
}
