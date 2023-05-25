package documin;

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
		} else if (ordem.equals("tamanho")) {
			this.ordem = Ordem.TAMANHO;
		}
	}
	
	@Override
	public String toStringCompleto() {
		String toString = "Total termos: " + termos.length
				+ "\n- ";
		
		if (ordem == Ordem.ALFABÉTICA) {
			
		}
			
		return toStringResumido();
	}

	@Override
	public String toStringResumido() {
		return getValor();
	}

}
