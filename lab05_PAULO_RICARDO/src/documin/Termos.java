package documin;

import java.util.Arrays;
import java.util.Comparator;
import java.lang.StringBuilder;

public class Termos extends Elemento{
	private String[] termos;
	private String separador;
	private Ordem ordem;
	
	public Termos(int prioridade, String valor, String separador, String ordem) {
		super(prioridade, valor);
		this.separador = separador;
		this.termos = getValor().split(separador);
		recebeOrdem(ordem);
	}
	
	private void recebeOrdem(String ordem) {
		ordem.toLowerCase();
		
		if (ordem.equals("nenhuma")) {
			this.ordem = Ordem.NENHUMA;
		} else if (ordem.equals("alfabética")) {
			this.ordem = Ordem.ALFABÉTICA;
			Arrays.sort(termos, (s1, s2) -> s1.compareToIgnoreCase(s2));
		} else if (ordem.equals("tamanho")) {
			this.ordem = Ordem.TAMANHO;
			Arrays.sort(termos, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
		}
	}
	
	private String formataToString() {
		return termos.toString().replace("[", "").replace("]", "");
	}
	
	@Override
	public String toStringCompleto() {
		return "Total termos: " + termos.length
				+ "\n- " + formataToString();
	}

	@Override
	public String toStringResumido() {
		return formataToString().replace(",", " " + separador);
	}

}
