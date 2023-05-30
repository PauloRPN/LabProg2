package Repository;

import java.util.HashMap;
import java.util.Map;

import documento.Documento;

public class DocumentoRepository {
	private Map<String, Documento> documentos;
	
	public DocumentoRepository() {
		documentos = new HashMap<>();
	}

	public boolean containsKey(String tituloDoc) {
		return documentos.containsKey(tituloDoc);
	}

	public void put(String tituloDoc, Documento documento) {
		documentos.put(tituloDoc, documento);		
	}

	public void remove(String tituloDoc) {
		documentos.remove(tituloDoc);
	}

	public Documento get(String tituloDoc) {
		return documentos.get(tituloDoc);
	}
	
}
