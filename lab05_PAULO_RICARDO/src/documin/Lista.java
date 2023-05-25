package documin;

public class Lista extends Elemento{
	private String charLista;
	private String[] lista;
	
	public Lista(int prioridade, String valor, String separador, String charLista) {
		super(prioridade, valor);
		this.charLista = charLista;
		this.lista = getValor().split(separador);
	}

	@Override
	public String toStringCompleto() {
		String toString = new String();
		
		for (String valor : lista) {
			toString += charLista + " " + valor;
			if (!valor.equals(lista[lista.length-1])) {
				toString += "\n";
			}
		}
		
		return toString;
	}

	@Override
	public String toStringResumido() {
		String toString = new String();
		
		for (String valor : lista) {
			toString += valor;
			if (!valor.equals(lista[lista.length-1])) {
				toString += ", ";
			}
		}
		
		return toString;
	}
}
