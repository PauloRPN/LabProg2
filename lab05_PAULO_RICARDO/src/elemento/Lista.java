package elemento;

public class Lista extends Elemento{
	private String charLista;
	private String separador;
	private String[] lista;
	
	public Lista(int prioridade, String valor, String separador, String charLista) {
		super(prioridade, valor);
		this.charLista = charLista;
		this.separador = separador;
		this.lista = getValor().split(separador);
	}

	@Override
	public String toStringCompleto() {
		return charLista + " " + lista.toString().replace(separador, "\n" + charLista);
	}

	@Override
	public String toStringResumido() {
		return getValor();
	}
}
