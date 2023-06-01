package elemento;

public class Lista extends Elemento{
	private String charLista;
	private String separador;
	
	public Lista(int prioridade, String valor, String separador, String charLista) {
		super(prioridade, valor);
		this.charLista = charLista;
		this.separador = separador;
	}
	
	@Override
	public String toStringCompleto() {
		return charLista + " " + toStringResumido().replace(separador, "\n" + charLista);
	}

	@Override
	public String toStringResumido() {
		return getValor();
	}
	
}
