package documin;

import java.util.Map;

public abstract class Elemento {
	private int prioridade;
	private String valor;
	
	public Elemento(int prioridade, String valor) {
		this.prioridade = prioridade;
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
	
	public int getPrioridade() {
		return this.prioridade;
	}
	
	public abstract String toStringCompleto();
	
	public abstract String toStringResumido();
}
