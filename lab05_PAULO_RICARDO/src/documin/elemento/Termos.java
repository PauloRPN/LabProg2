package documin.elemento;

import java.util.Arrays;
import java.util.Comparator;
import java.lang.StringBuilder;

/**
 * Subtipo de Elemento. Além dos atributos de Elemento, Termos tem um separador e uma ordem para sua representação.
 * 
 * @author paulo.ricardo.pereira.nascimento
 */
public class Termos extends Elemento {
	private String[] termos;
	private String separador;
	private Ordem ordem;
	
	/**
	 * Cria Termos.
	 * 
	 * @param prioridade Valor inteiro entre 1-5 (inclusive) que indica a prioridade do elemento.
	 * @param valor Dados do elemento.
	 * @param separador Separador passado entre os dados do elemento.
	 * @param ordem Ordem que deseja-se apresentar os termos em suas representações (NENHUMA, ALFABETICA OU TAMANHO).
	 */
	public Termos(int prioridade, String valor, String separador, String ordem) {
		super(prioridade, valor);
		this.separador = separador;
		this.termos = getValor().split("\\" + separador);
		recebeOrdem(ordem);
	}
	
	/**
	 * Recebe a ordem para a representação dos termos como String e mapeia para enum.
	 * 
	 * @param ordem Ordem para a representação dos termos.
	 */
	private void recebeOrdem(String ordem) {
		if (ordem.toLowerCase().equals("nenhuma")) {
			this.ordem = Ordem.NENHUMA;
		} else if (ordem.toLowerCase().equals("alfabética")) {
			this.ordem = Ordem.ALFABÉTICA;
			Arrays.sort(termos, (s1, s2) -> s1.compareToIgnoreCase(s2));
		} else if (ordem.toLowerCase().equals("tamanho")) {
			this.ordem = Ordem.TAMANHO;
			Arrays.sort(termos, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
		} else {
			throw new IllegalArgumentException("ORDEM INVÁLIDA!");
		}
	}
	
	/**
	 * Formata a representação dos termos.
	 * 
	 * @return Representação formata dos termos.
	 */
	private String formataToString() {
		for (int i = 0; i < termos.length; i++) {
			termos[i] = termos[i].strip();
		}
		
		return Arrays.toString(termos).replace("[", "").replace("]", "");
	}
	
	/**
	 * Representação completa de Termos.
	 * 
	 * @return Representação completa de Termos.
	 */
	@Override
	public String toStringCompleto() {
		return "Total termos: " + termos.length
				+ "\n- " + formataToString();
	}

	/**
	 * Representação resumida de Termos.
	 * 
	 * @return Representação resumida de Termos.
	 */
	@Override
	public String toStringResumido() {
		return formataToString().replace(",", " " + separador);
	}
	
}
