package elemento;

public class Titulo extends Elemento{
	int nivel;
	boolean linkavel;
	
	public Titulo(int prioridade, String valor, int nivel, boolean linkavel) {
		super(prioridade, valor);
		this.nivel = nivel;
		this.linkavel = linkavel;
	}

	@Override
	public String toStringCompleto() {
		if (linkavel) {
			return toStringResumido() + " -- " + getLink();
		}
		
		return toStringResumido();
	}

	private String getLink() {
		return nivel + "-" + getValor().replace(" ", "").toUpperCase();
	}
	
	@Override
	public String toStringResumido() {
		return nivel + ". " + getValor();
	}
}
