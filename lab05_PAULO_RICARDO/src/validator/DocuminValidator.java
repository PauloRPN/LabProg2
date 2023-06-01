package validator;

import java.util.Map;
import java.util.NoSuchElementException;

import documento.Documento;

public class DocuminValidator {
	public static void validaTitulo(String tituloDoc) {
		if (tituloDoc.isBlank() || tituloDoc.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO INVÁLIDO!");
		}
	}
	
	public static void validaTamanhoMaximo(int tamanhoMaximo) {
		if (tamanhoMaximo <= 0) {
			throw new IllegalArgumentException("TAMANHO INVÁLIDO!");
		}
	}
	
	public static void validaExistencia(String tituloDoc, Map<String, Documento> documentos) {
		if (!documentos.containsKey(tituloDoc)) {
			throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE!");
		}
	}
	
	public static void validaLimiteArray(Documento documento) {
		if (documento.getTamanhoMaximo() != 0
				&& documento.getQtdeElementos() == documento.getTamanhoMaximo()) {
			throw new ArrayIndexOutOfBoundsException("O DOCUMENTO ATINGIU SEU LIMITE!");
		}
	}
	
	public static void validaPrioridade(int prioridade) {
		if (prioridade < 1 || prioridade > 5) {
			throw new IllegalArgumentException("PRIORIDADE INVÁLIDA!");
		}
	}
	
	public static void validaNivel(int nivel) {
		if (nivel < 1 || nivel > 5) {
			throw new IllegalArgumentException("NÍVEL INVÁLIDO!");
		} 
	}
	
	public static void validaPosicao(int elementoPosicao, Documento documento) {
		if (elementoPosicao > documento.getQtdeElementos()
				|| elementoPosicao < 0) {
			throw new ArrayIndexOutOfBoundsException("POSIÇÃO INVÁLIDA OU INEXISTENTE NO DOCUMENTO!");
		}
	}
	
	public static void validaAtalho(Documento doc1, Documento doc2) {
		if (doc1.isAtalho() || doc2.temAtalho()) {
			throw new IllegalStateException("O ATALHO NÃO PODE SER CRIADO!");
		}
	}
	
}
