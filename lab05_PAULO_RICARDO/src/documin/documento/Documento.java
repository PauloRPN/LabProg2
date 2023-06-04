package documin.documento;

import java.util.ArrayList;

import documin.elemento.Atalho;
import documin.elemento.Elemento;
import documin.elemento.Lista;
import documin.elemento.Termos;
import documin.elemento.Texto;
import documin.elemento.Titulo;

/**
 * Classe de encapsulamento do conceito de Documento. Um documento tem um título que o identifica
 * e pode ter um tamanho máximo que delimita sua quantidade de elementos ou pode ter tamanho ilimitado.
 * 
 * @author paulo.ricardo.pereira.nascimento
 */
public class Documento {
	private String tituloDoc;
	private int tamanhoMaximo;
	private ArrayList<Elemento> elementos;
	private boolean isAtalho;
	
	/**
	 * Cria um documento sem tamanho delimitador.
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 */
	public Documento(String tituloDoc) {
		this.tituloDoc = tituloDoc;
		this.elementos = new ArrayList<>();
	}
	
	/**
	 * Cria um documento com tamanho máximo.
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 * @param tamanhoMaximo Quantidade máxima de elementos que o documento pode ter.
	 */
	public Documento(String tituloDoc, int tamanhoMaximo) {
		this.tituloDoc = tituloDoc;
		this.tamanhoMaximo = tamanhoMaximo;
		this.elementos = new ArrayList<>();
	}
	
	/**
	 * Recupera o título do documento.
	 * 
	 * @return Título do documento.
	 */
	public String getTituloDoc() {
		return tituloDoc;
	}
	
	/**
	 * Recupera a quantidade de elementos do documento.
	 * 
	 * @return Quantidade de elementos.
	 */
	public int getQtdeElementos() {
		return elementos.size();
	}
	
	/**
	 * Recupera um clone da lista de elementos do documentos.
	 * 
	 * @return Lista de elementos do documento.
	 */
	public ArrayList<Elemento> getElementos() {
		return (ArrayList<Elemento>) elementos.clone();
	}
	
	/**
	 * Recupera a quantidade máxima de elementos do documento.
	 * 
	 * @return Tamanho máximo do documento.
	 */
	public int getTamanhoMaximo() {
		return tamanhoMaximo;
	}
	
	/**
	 * Recupera um array de Strings da representação resumida de cada elemento de um documento.
	 * 
	 * @return Array de Strings das representações resumidas do documento. 
	 */
	public String[] exibeDocumento() {
		ArrayList<String> toString = new ArrayList<>();
		
		for (Elemento elem : elementos) {
			if (elem != null) {
				toString.add(elem.toStringResumido());
			}
		}

		return toString.toArray(new String[toString.size()]);
	}
	
	/**
	 * Cria um elemento Texto no documento.
	 * 
	 * @param prioridade Valor inteiro entre 1-5 (inclusive) que indica a prioridade do elemento.
	 * @param valor Dados do elemento.
	 * @return A posição do elemento no documento.
	 */
	public int criarTexto(int prioridade, String valor) {
		Elemento elem = new Texto(prioridade, valor);
		elementos.add(elem);
		
		return elementos.indexOf(elem);
	}
	
	/**
	 * Cria um elemento Título no documento.
	 * 
	 * @param prioridade Valor inteiro entre 1-5 (inclusive) que indica a prioridade do elemento.
	 * @param valor Dados do elemento.
	 * @param nivel Nível Valor inteiro entre 1-5 (inclusive).
	 * @param linkavel Condição booleana para o Titulo possuir link.
	 * @return A posição do elemento no documento.
	 */
	public int criarTitulo(int prioridade, String valor, int nivel, boolean linkavel) {
		Elemento elem = new Titulo(prioridade, valor, nivel, linkavel);
		elementos.add(elem);
		
		return elementos.indexOf(elem);
	}

	/**
	 * Cria um elemento Lista no documento.
	 * 
	 * @param prioridade Valor inteiro entre 1-5 (inclusive) que indica a prioridade do elemento.
	 * @param valor Dados do elemento.
	 * @param separador Separador passado entre os dados do elemento.
	 * @param charLista Caractere característico da lista.
	 * @return A posição do elemento no documento.
	 */
	public int criarLista(int prioridade, String valor, String separador, String charLista) {
		Elemento elem = new Lista(prioridade, valor, separador, charLista);
		elementos.add(elem);
		
		return elementos.indexOf(elem);
	}

	/**
	 * Cria um elemento Termos no documento.
	 * 
	 * @param prioridade Valor inteiro entre 1-5 (inclusive) que indica a prioridade do elemento.
	 * @param valor Dados do elemento.
	 * @param separador Separador passado entre os dados do elemento.
	 * @param ordem Ordem que deseja-se apresentar os termos em suas representações (NENHUMA, ALFABETICA OU TAMANHO).
	 * @return A posição do elemento no documento.
	 */
	public int criarTermos(int prioridade, String valor, String separador, String ordem) {
		Elemento elem = new Termos(prioridade, valor, separador, ordem);
		elementos.add(elem);
		
		return elementos.indexOf(elem);
	}
	
	/**
	 * Recupera a representação completa de um elemento do documento.
	 * 
	 * @param elementoPosicao Posição do elemento.
	 * @return Representação completa do elemento.
	 */
	public String pegarRepresetacaoCompleta(int elementoPosicao) {
		return elementos.get(elementoPosicao).toStringCompleto();
	}

	/**
	 * Recupera a representação resumida de um elemento do documento.
	 * 
	 * @param elementoPosicao Posição do elemento.
	 * @return Representação resumida do elemento.
	 */
	public String pegarRepresetacaoResumida(int elementoPosicao) {
		return elementos.get(elementoPosicao).toStringResumido();
	}

	/**
	 * Move um elemento do documento para a posição logo acima.
	 * 
	 * @param elementoPosicao Posição do elemento.
	 */
	public void moverParaCima(int elementoPosicao) {
		if (elementoPosicao > 0) {
			Elemento elemento = elementos.get(elementoPosicao);
	        int index = elementos.indexOf(elemento);

			elementos.remove(elementoPosicao);
			elementos.add(index - 1, elemento);
		}
	}

	/**
	 * Move um elemento de um documento para a posição logo abaixo.
	 * 
	 * @param elementoPosicao Posição do elemento.
	 */
	public void moverParaBaixo(int elementoPosicao) {
		if (elementoPosicao < getQtdeElementos()-1) {
			Elemento elemento = elementos.get(elementoPosicao);
	        int index = elementos.indexOf(elemento);

			elementos.remove(elementoPosicao);
			elementos.add(index + 1, elemento);
		}
	}
	
	/**
	 * Cria um elemento Atalho no documento.
	 * 
	 * @param documento Documento referenciado.
	 * @return Posição do elemento no documento.
	 */
	public int criarAtalho(Documento documento) {
		Elemento elem = new Atalho(documento, documento.getMediaPrioridade());
		elementos.add(elem);
		isAtalho = true;
		
		return elementos.indexOf(elem);
	}

	/**
	 * Calcula a média das prioridade de um documento. Este método é útil para a criação de Atalaho.
	 * 
	 * @return Média das prioridade de um documento.
	 */
	private int getMediaPrioridade() {
		int media = 0;
		
		for (Elemento elem : elementos) {
			media += elem.getPrioridade();
		}
		
		if (elementos.size() == 0) {
			return 0;
		}
		
		return media / elementos.size();
	}
	
	/**
	 * Verifica se um documento já foi referenciado em um Atalho. Este método é útil para a criação de Atalaho.
	 * 
	 * @return True caso o documento seja Atalho; false, caso contrário.
	 */
	public boolean isAtalho() {
		return isAtalho;
	}
	
	/**
	 * Verifica se um documento possui atalhos. Este método é útil para a criação de Atalaho.
	 * 
	 * @return True caso o documento possua atalhos; false, caso contrário.
	 */
	public boolean temAtalho() {
		for (Elemento elem : elementos) {
			if (elem instanceof Atalho) return true;
		}
		
		return false;
	}
	
}
