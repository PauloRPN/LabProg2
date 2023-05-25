package documin;

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
			return nivel + ". " + getValor() + " -- " + getLink();
		}
		
		return toStringResumido();
	}

	private String getLink() {
		String link = getValor() + "-";
		
		for (String palavra : getValor().split("")) {
			for (char letra : palavra.toCharArray()) {
				link += letra; 
			}
		}
		
		return link.toUpperCase();
	}
	
	@Override
	public String toStringResumido() {
		return nivel + ". " + getValor();
	}
}
