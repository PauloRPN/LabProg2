package documin.elemento;

import java.util.Map;

/**
 * Classe abstrata do conceito de Elemento. Elemento tem, essencialmente, uma prioridade e dados como valor.
 * 
 * @author paulo.ricardo.pereira.nascimento
 */
public abstract class Elemento {
	private int prioridade;
	private String valor;
	
	/**
	 * Cria um elemento.
	 * 
	 * @param prioridade Valor inteiro entre 1-5 (inclusive) que indica a prioridade do elemento.
	 * @param valor Dados do elemento.
	 */
	public Elemento(int prioridade, String valor) {
		this.prioridade = prioridade;
		this.valor = valor;
	}
	
	/**
	 * Recupera o valor do elemento.
	 * 
	 * @return Dados do elemento.
	 */
	public String getValor() {
		return valor;
	}
	
	/**
	 * Recupera a prioridade do elemento.
	 * 
	 * @return Prioridade do elemento.
	 */
	public int getPrioridade() {
		return this.prioridade;
	}
	
	/**
	 * Assinatura de uma representação completa de um elemento.
	 * 
	 * @return Representação completa do elemento.
	 */
	public abstract String toStringCompleto();
	
	/**
	 * Assinatura de uma representação resumida de um elemento.
	 * 
	 * @return Representação resumida do elemento.
	 */
	public abstract String toStringResumido();
}
