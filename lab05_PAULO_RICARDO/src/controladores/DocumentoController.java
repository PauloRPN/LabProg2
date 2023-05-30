package controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import Repository.DocumentoRepository;
import documento.Documento;

public class DocumentoController {
	private DocumentoRepository documentoRepository;
	
	public DocumentoController(DocumentoRepository documentoRepository) {
		this.documentoRepository = documentoRepository;
	}
	
	public boolean criaDocumento(String tituloDoc) {
		if (tituloDoc.isBlank() || tituloDoc.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO INVÁLIDO!");
		} else if (documentoRepository.containsKey(tituloDoc)) {
			return false;
		}
		
		documentoRepository.put(tituloDoc, new Documento(tituloDoc));
		return true;
	}
	
	public boolean criaDocumento(String tituloDoc, int tamanhoMaximo) {
		if (tituloDoc.isBlank() || tituloDoc.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO INVÁLIDO!");
		} else if (tamanhoMaximo <= 0) {
			throw new IllegalArgumentException("TAMANHO INVÁLIDO!");
		} else if (documentoRepository.containsKey(tituloDoc)) {
			return false;
		}
		
		documentoRepository.put(tituloDoc, new Documento(tituloDoc, tamanhoMaximo));
		return true;
	}
	
	public void removerDocumento(String tituloDoc) {
		verificaNoSuchElementException(tituloDoc);
		documentoRepository.remove(tituloDoc);
	}
	
	public int contarElementos(String tituloDoc) {
		verificaNoSuchElementException(tituloDoc);
		return documentoRepository.get(tituloDoc).getQtdeElementos();
	}
	
	public String[] exibirDocumento(String tituloDoc) {
		verificaNoSuchElementException(tituloDoc);
		return documentoRepository.get(tituloDoc).DocumentoToString();
	}
	
	
	// Metódos que verificam exceções
	
	private void verificaNoSuchElementException(String tituloDoc) {
		if (!documentoRepository.containsKey(tituloDoc)) {
			throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE!");
		}
	}
	
}
