package documin.validator;

import java.util.Map;
import java.util.NoSuchElementException;

import documin.documento.Documento;

public class DocuminValidator {
	
	/**
	 * Valida um título passado para a criação de um documento.
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 * @throws IllegalArgumentException Lança exceção para título vazio ou composto apenas de espaços.
	 */
	public static void validaTitulo(String tituloDoc) throws IllegalArgumentException {
		if (tituloDoc.isBlank() || tituloDoc.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO INVÁLIDO!");
		}
	}
	
	/**
	 * Valida o tamanho máximo passado para a crianção de um documento.
	 * 
	 * @param tamanhoMaximo Tamanho que delimita a quantidade de elementos que um documento pode ter.
	 * @throws IllegalArgumentException Lança exceção para tamanho menor ou igual a zero.
	 */
	public static void validaTamanhoMaximo(int tamanhoMaximo) throws IllegalArgumentException {
		if (tamanhoMaximo <= 0) {
			throw new IllegalArgumentException("TAMANHO INVÁLIDO!");
		}
	}
	
	/**
	 * Valida a existência de um documento.
	 * 
	 * @param containKey Condição de existência do documento, true ou false.
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 */
	public static void validaExistencia(boolean containKey) throws NoSuchElementException {
		if (!containKey) {
			throw new NoSuchElementException("O DOCUMENTO NÃO EXISTE!");
		}
	}
	
	/**
	 * Valida o limite de um documento.
	 * 
	 * @param tamanhoMaximoDoc Tamanho que delimita a quantidade de elementos que um documento pode ter.
	 * @param qtdeElementosDoc Quantidade de elementos que o documento possui.
	 * @throws IndexOutOfBoundsException Lança exceção quando o tamanho máximo do documento foi atingido.
	 */
	public static void validaLimiteArray(int tamanhoMaximoDoc, int qtdeElementosDoc) throws IndexOutOfBoundsException {
		if (tamanhoMaximoDoc != 0 && qtdeElementosDoc == tamanhoMaximoDoc) {
			throw new IndexOutOfBoundsException("O DOCUMENTO ATINGIU SEU LIMITE!");
		}
	}
	
	/**
	 * Valida a prioridade passada para a criação de um elemento.
	 * 
	 * @param prioridade Valor inteiro entre 1-5 (inclusive) que indica a prioridade do elemento.
	 * @throws IllegalArgumentException Lança exceção para prioridade menor que 1 ou maior que 5.
	 */
	public static void validaPrioridade(int prioridade) throws IllegalArgumentException {
		if (prioridade < 1 || prioridade > 5) {
			throw new IllegalArgumentException("PRIORIDADE INVÁLIDA!");
		}
	}
	
	/**
	 * Valida o nível passado para a criação de um elemento do tipo Título.
	 * 
	 * @param nivel Nível passado para a criação do Título.
	 * @throws IllegalArgumentException Lança exceção para nível menor que 1 ou maior que 5.
	 */
	public static void validaNivel(int nivel) throws IllegalArgumentException {
		if (nivel < 1 || nivel > 5) {
			throw new IllegalArgumentException("NÍVEL INVÁLIDO!");
		} 
	}
	
	/**
	 * Valida a posição de um elemento para sua manipulação no documento.
	 * 
	 * @param elementoPosicao Posição do elemento no documento.
	 * @param docQtdeElementos Quantidade de elementos do documento.
	 * @throws IndexOutOfBoundsException Lança exceção para posição menor que 0 ou maior que a quantidade de elementos de documento.
	 */
	public static void validaPosicao(int elementoPosicao, int docQtdeElementos) throws IndexOutOfBoundsException {
		if (elementoPosicao >= docQtdeElementos
				|| elementoPosicao < 0) {
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA OU INEXISTENTE NO DOCUMENTO!");
		}
	}
	
	/**
	 * Valida a criação de um elemento do tipo Atalho.
	 * 
	 * @param doc1_IsAtalho Condição booleana se o documento a receber um atalho é um Atalho ou não.
	 * @param doc2_temAtalho Condição booleana se o documento a sendo referenciado tem Atalhos ou não.
	 * @throws IllegalStateException Lanção exceção se o documento a receber Atalho também é um Atalho ou se o documento
	 * referenciado possuir Atalhos.
	 */
	public static void validaAtalho(boolean doc1_IsAtalho, boolean doc2_temAtalho) throws IllegalStateException {
		if (doc1_IsAtalho || doc2_temAtalho) {
			throw new IllegalStateException("O ATALHO NÃO PODE SER CRIADO!");
		}
	}

	/**
	 * Valisa o ID passado para acessar uma Visão de documento.
	 * 
	 * @param visaoId Posição da Visão. 
	 * @param visaoSize Tamanho do objeto que armazena as visões no sistema.
	 * @throws IndexOutOfBoundsException Lança exceção se o ID for menor que 0 ou maior que a quantidade de visões no sistema.
	 */
	public static void validaVisaoId(int visaoId, int visaoSize) throws IndexOutOfBoundsException {
		if (visaoSize != 0 && (visaoId < 0 || visaoId > visaoSize-1)) {
			throw new IndexOutOfBoundsException("ID DE VISÃO INVÁLIDO!");
		}
	}
	
}
