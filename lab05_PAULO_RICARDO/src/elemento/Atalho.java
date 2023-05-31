package elemento;

import documento.Documento;

public class Atalho extends Elemento{
	private Documento documento;
	
	public Atalho(Documento documento, int prioridade) {
		super(prioridade, documento.getTituloDoc());
		this.documento = documento;
	}
	
	@Override
	public String toStringCompleto() {
		String toString = new String();
		
		for (Elemento elem : documento.getElementos()) {
			if (elem.getPrioridade() >= 4) {
				toString += elem.toStringCompleto() + "\n";
			}
		}
		
		return toString;
	}

	@Override
	public String toStringResumido() {
		String toString = new String();
		
		for (Elemento elem : documento.getElementos()) {
			if (elem.getPrioridade() >= 4) {
				toString += elem.toStringResumido() + "\n";
			}
		}
		
		return toString;
	}
	
}
