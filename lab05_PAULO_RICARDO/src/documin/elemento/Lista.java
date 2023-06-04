package documin.elemento;

import java.util.Arrays;

/**
 * Subtipo de Elemento. Além dos atributos de Elemento, Lista tem um caractere que caracteriza
 * a listagem e um separador que é passado nos dados.
 * 
 * @author paulo.ricardo.pereira.nascimento
 */
public class Lista extends Elemento {
	private String charLista;
	private String separador;
	private String[] lista;
	
	/**
	 * Cria uma Lista.
	 * 
	 * @param prioridade Valor inteiro entre 1-5 (inclusive) que indica a prioridade do elemento.
	 * @param valor Dados do elemento.
	 * @param separador Separador passado entre os dados do elemento.
	 * @param charLista Caractere característico da lista.
	 * @return A posição do elemento no documento.
	 */
	public Lista(int prioridade, String valor, String separador, String charLista) {
		super(prioridade, valor);
		this.charLista = charLista;
		this.separador = separador;
		this.lista = valor.split("\\" + separador);
	}
	
	private String formataToString() {
		for (int i = 0; i < lista.length; i++) {
			lista[i] = lista[i].strip();
		}
		
		return Arrays.toString(lista).replace("[", "").replace("]", "");
	}
	
	/**
	 * Representação completa de Lista.
	 * 
	 * @return Representação completa da Lista.
	 */
	@Override
	public String toStringCompleto() {
		return charLista + " " + formataToString().replace(",", "\n" + charLista);
	}
	
	/**
	 * Representação resumida de Lista.
	 * 
	 * @return Representação resumida da Lista.
	 */
	@Override
	public String toStringResumido() {
		return getValor();
	}
	
}
