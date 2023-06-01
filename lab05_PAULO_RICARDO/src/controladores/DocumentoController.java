package controladores;

import java.util.HashMap;
import java.util.Map;

import documento.Documento;
import validator.DocuminValidator;

public class DocumentoController {
	private Map<String, Documento> documentos;
	
	public DocumentoController() {
		this.documentos = new HashMap<>();
	}
	
	public boolean criaDocumento(String tituloDoc) {
		DocuminValidator.validaTitulo(tituloDoc);
		
		if (documentos.containsKey(tituloDoc)) return false;
		
		documentos.put(tituloDoc, new Documento(tituloDoc));
		return true;
	}
	
	public boolean criaDocumento(String tituloDoc, int tamanhoMaximo) {
		DocuminValidator.validaTitulo(tituloDoc);
		DocuminValidator.validaTamanhoMaximo(tamanhoMaximo);
		
		if (documentos.containsKey(tituloDoc)) return false;
		
		documentos.put(tituloDoc, new Documento(tituloDoc, tamanhoMaximo));
		return true;
	}
	
	public void removerDocumento(String tituloDoc) {
		DocuminValidator.validaExistencia(tituloDoc, documentos);
		documentos.remove(tituloDoc);
	}
	
	public int contarElementos(String tituloDoc) {
		DocuminValidator.validaExistencia(tituloDoc, documentos);
		return documentos.get(tituloDoc).getQtdeElementos();
	}
	
	public String[] exibirDocumento(String tituloDoc) {
		DocuminValidator.validaExistencia(tituloDoc, documentos);
		return documentos.get(tituloDoc).DocumentoToString();
	}
	
	public Documento getDocumento(String tituloDoc) {
		DocuminValidator.validaExistencia(tituloDoc, documentos);
		return documentos.get(tituloDoc);
	}
	
	
}
