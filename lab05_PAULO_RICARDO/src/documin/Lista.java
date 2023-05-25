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
		
		for (int i = 0; i < lista.length-1; i++) {
			toString += charLista + " " + lista[i] + "\n";		
		}
		
		toString += lista[-1];
		
		return toString;
	}

	@Override
	public String toStringResumido() {
		String toString = new String();
		
		for (int i = 0; i < lista.length-1; i++) {
			toString += lista[i] + ", ";
		}
		
		toString += lista[-1];
		
		return toString;
	}
}
