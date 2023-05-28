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
	
	public int criarTexto(String tituloDoc, int prioridade, String valor) {
		verificaNoSuchElementException(tituloDoc);
		verificaArrayOutofBoundsException(tituloDoc);
		
		return documentos.get(tituloDoc).criarTexto(prioridade, valor);
	}

	public int criarTitulo(String tituloDoc, int prioridade, String valor, int nivel, boolean linkavel) {
		verificaNoSuchElementException(tituloDoc);
		verificaArrayOutofBoundsException(tituloDoc);
		
		return documentos.get(tituloDoc).criarTitulo(prioridade, valor, nivel, linkavel);
	}

	public int criarLista(String tituloDoc, int prioridade, String valor, String separador, String charLista) {
		verificaNoSuchElementException(tituloDoc);
		verificaArrayOutofBoundsException(tituloDoc);
		
		return documentos.get(tituloDoc).criarLista(prioridade, valor, separador, charLista);
	}

	public int criarTermos(String tituloDoc, int prioridade, String valor, String separador, String ordem) {
		verificaNoSuchElementException(tituloDoc);
		verificaArrayOutofBoundsException(tituloDoc);
		
		return documentos.get(tituloDoc).criarTermos(prioridade, valor, separador, ordem);
	}
	
	public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		verificaNoSuchElementException(tituloDoc);
		verificaArrayIndexOutOfBoundsException(tituloDoc, elementoPosicao);
		
		return documentos.get(tituloDoc).pegarRepresetacaoCompleta(elementoPosicao);
	}
	
	public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
		verificaNoSuchElementException(tituloDoc);
		verificaArrayOutofBoundsException(tituloDoc);
		
		return documentos.get(tituloDoc).pegarRepresetacaoResumida(elementoPosicao);
	}
	
	public void moverParaCima(String tituloDoc, int elementoPosicao) {
		verificaNoSuchElementException(tituloDoc);
		verificaArrayIndexOutOfBoundsException(tituloDoc, elementoPosicao);
		
		documentos.get(tituloDoc).moverParaCima(tituloDoc, elementoPosicao);
	}

	public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
		verificaNoSuchElementException(tituloDoc);
		verificaArrayIndexOutOfBoundsException(tituloDoc, elementoPosicao);
		
		documentos.get(tituloDoc).moverParaBaixo(tituloDoc, elementoPosicao);
	} 
	
	
	// Metódos que verificam exceções
	
	private void verificaNoSuchElementException(String tituloDoc) {
		if (!documentos.containsKey(tituloDoc)) {
			throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE!");
		}
	}
	
	private void verificaArrayOutofBoundsException(String tituloDoc) {
		if (documentos.get(tituloDoc).getTamanhoMaximo() != 0
				&& documentos.get(tituloDoc).getQtdeElementos() == documentos.get(tituloDoc).getTamanhoMaximo()) {
			throw new ArrayIndexOutOfBoundsException("O DOCUMENTO ATINGIU SEU LIMITE!");
		}
	}
	
	private void verificaArrayIndexOutOfBoundsException(String tituloDoc, int elementoPosicao) {
		if (elementoPosicao > documentos.get(tituloDoc).getQtdeElementos()
				|| elementoPosicao < 0) {
			throw new ArrayIndexOutOfBoundsException("POSIÇÃO INVÁLIDA OU INEXISTENTE NO DOCUMENTO!");
		}
	}
	
}
