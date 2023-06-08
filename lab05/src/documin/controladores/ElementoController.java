package documin.controladores;

import java.util.NoSuchElementException;

import documin.documento.Documento;
import documin.validator.DocuminValidator;

/**
 * Classe responsável pela criação e manipulação dos elementos Texto, Título, Lista e Termos.
 * 
 * @author paulo.ricardo.pereira.nascimento
 *
 */
public class ElementoController {
	private DocumentoController documentoController;
	
	/**
	 * Cria um ElementoController;
	 * 
	 * @param documentoController controlador dos documentos nos quais os elementos podem ser criados e manipulados.
	 */
	public ElementoController(DocumentoController documentoController) {
		this.documentoController = documentoController;
	}
	
	/**
	 * Recupera um documento.
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 * @return O documento desejado.
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 */
	private Documento documento(String tituloDoc) {
		return documentoController.getDocumento(tituloDoc);
	}
	
	/**
	 * Conta a quantidade de elementos que um documento contém.
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 * @return Quantidade de elementos do documento.
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 */
	public int contarElementos(String tituloDoc) {
		return documento(tituloDoc).getQtdeElementos();
	}
	
	/**
	 * Cria um elemento do tipo Texto.
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 * @param prioridade Valor inteiro entre 1-5 (inclusive) que indica a prioridade do elemento.
	 * @param valor Dados do elemento.
	 * @return A posição do elemento no documento.
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 * @throws IndexOutOfBoundsException Lança exceção quando o tamanho máximo do documento foi atingido.
	 * @throws IllegalArgumentException Lança exceção para prioridade menor que 1 ou maior que 5.
	 */
	public int criarTexto(String tituloDoc, int prioridade, String valor) {
		DocuminValidator.validaLimiteArray(documento(tituloDoc).getTamanhoMaximo(),
				contarElementos(tituloDoc));
		DocuminValidator.validaPrioridade(prioridade);
		return documento(tituloDoc).criarTexto(prioridade, valor);
	}
	
	/**
	 * Cria um elemento do tipo Título.
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 * @param prioridade Valor inteiro entre 1-5 (inclusive) que indica a prioridade do elemento.
	 * @param valor Dados do elemento.
	 * @param nivel Nível Valor inteiro entre 1-5 (inclusive).
	 * @param linkavel Condição booleana para o Titulo possuir link.
	 * @return A posição do elemento no documento.
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 * @throws IndexOutOfBoundsException Lança exceção quando o tamanho máximo do documento foi atingido.
	 * @throws IllegalArgumentException Lança exceção para prioridade menor que 1 ou maior que 5.
	 * @throws IllegalArgumentException Lança exceção para nível menor que 1 ou maior que 5.
	 */
	public int criarTitulo(String tituloDoc, int prioridade, String valor, int nivel, boolean linkavel) {
		DocuminValidator.validaLimiteArray(documento(tituloDoc).getTamanhoMaximo(),
				contarElementos(tituloDoc));
		DocuminValidator.validaPrioridade(prioridade);
		DocuminValidator.validaNivel(nivel);
		return documento(tituloDoc).criarTitulo(prioridade, valor, nivel, linkavel);
	}
	
	/**
	 * Cria um elemento do tipo Lista.
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 * @param prioridade Valor inteiro entre 1-5 (inclusive) que indica a prioridade do elemento.
	 * @param valor Dados do elemento.
	 * @param separador Separador passado entre os dados do elemento.
	 * @param charLista Caractere característico da lista.
	 * @return A posição do elemento no documento.
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 * @throws IndexOutOfBoundsException Lança exceção quando o tamanho máximo do documento foi atingido.
	 * @throws IllegalArgumentException Lança exceção para prioridade menor que 1 ou maior que 5.
	 */
	public int criarLista(String tituloDoc, int prioridade, String valor, String separador, String charLista) {
		DocuminValidator.validaLimiteArray(documento(tituloDoc).getTamanhoMaximo(),
				contarElementos(tituloDoc));
		DocuminValidator.validaPrioridade(prioridade);
		return documento(tituloDoc).criarLista(prioridade, valor, separador, charLista);
	}
	
	/**
	 * Cria um elemento do tipo Termos.
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 * @param prioridade Valor inteiro entre 1-5 (inclusive) que indica a prioridade do elemento.
	 * @param valor Dados do elemento.
	 * @param separador Separador passado entre os dados do elemento.
	 * @param ordem Ordem que deseja-se apresentar os termos em suas representações (NENHUMA, ALFABETICA OU TAMANHO).
	 * @return A posição do elemento no documento.
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 * @throws IndexOutOfBoundsException Lança exceção quando o tamanho máximo do documento foi atingido.
	 * @throws IllegalArgumentException Lança exceção para prioridade menor que 1 ou maior que 5.
	 */
	public int criarTermos(String tituloDoc, int prioridade, String valor, String separador, String ordem) {
		DocuminValidator.validaLimiteArray(documento(tituloDoc).getTamanhoMaximo(),
				contarElementos(tituloDoc));
		DocuminValidator.validaPrioridade(prioridade);
		return documento(tituloDoc).criarTermos(prioridade, valor, separador, ordem);
	}
	
	/**
	 * Recupera a representação completa de um elemento de um documento.
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 * @param elementoPosicao Posição do elemento.
	 * @return Representação completa do elemento.
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 * @throws IndexOutOfBoundsException Lança exceção para posição menor que 0 ou maior que a quantidade de elementos de documento.
	 */
	public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		DocuminValidator.validaPosicao(elementoPosicao, contarElementos(tituloDoc));
		return documento(tituloDoc).pegarRepresentacaoCompleta(elementoPosicao);
	}
	
	/**
	 * Recupera a representação resumida de um elemento de um documento.
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 * @param elementoPosicao Posição do elemento.
	 * @return Representação resumida do elemento.
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 * @throws IndexOutOfBoundsException Lança exceção para posição menor que 0 ou maior que a quantidade de elementos de documento.
	 */
	public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
		DocuminValidator.validaPosicao(elementoPosicao, contarElementos(tituloDoc));
		return documento(tituloDoc).pegarRepresentacaoResumida(elementoPosicao);
	}
	
	/**
	 * Move um elemento de um documento para a posição logo acima.
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 * @param elementoPosicao Posição do elemento.
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 * @throws IndexOutOfBoundsException Lança exceção para posição menor que 0 ou maior que a quantidade de elementos de documento.
	 */
	public void moverParaCima(String tituloDoc, int elementoPosicao) {
		DocuminValidator.validaPosicao(elementoPosicao, contarElementos(tituloDoc));
		documento(tituloDoc).moverParaCima(elementoPosicao);
	}
	
	/**
	 * Move um elemento de um documento para a posição logo abaixo.
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 * @param elementoPosicao Posição do elemento.
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 * @throws IndexOutOfBoundsException Lança exceção para posição menor que 0 ou maior que a quantidade de elementos de documento.
	 */
	public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
		DocuminValidator.validaPosicao(elementoPosicao, contarElementos(tituloDoc));
		documento(tituloDoc).moverParaBaixo(elementoPosicao);
	} 
	
	/**
	 * Cria um elemento do tipo Atalho.
	 * 
	 * @param tituloDoc Título que identifica o documento a receber Atalho.
	 * @param tituloDocReferenciado Título que identifica o documento a ser referenciado.
	 * @return A posição do elemento no documento.
	 * @throws NoSuchElementException Lança exceção caso algum dos documentos não exista.
	 * @throws IndexOutOfBoundsException Lança exceção quando o tamanho máximo do documento a receber Atalho for atingido.
	 * @throws IllegalStateException Lanção exceção se o documento a receber Atalho também é um Atalho ou se o documento
	 * referenciado possuir Atalhos.
	 */
	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
		DocuminValidator.validaLimiteArray(documento(tituloDoc).getTamanhoMaximo(),
				contarElementos(tituloDoc));	
		DocuminValidator.validaAtalho(documento(tituloDoc).isAtalho(), 
				documento(tituloDocReferenciado).temAtalho());
		return documento(tituloDoc).criarAtalho(documento(tituloDocReferenciado));
	}

}
