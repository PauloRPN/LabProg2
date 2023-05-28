package elemento;

public class Texto extends Elemento{
	public Texto(int prioridade, String valor) {
		super(prioridade, valor);
	}

	@Override
	public String toStringCompleto() {
		return getValor();
	}

	@Override
	public String toStringResumido() {
		return getValor();
	}
}
