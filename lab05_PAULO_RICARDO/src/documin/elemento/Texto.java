package documin.elemento;

/**
 * Texto é o subtítulo mais básico de Elemento. 
 * 
 * @author paulo.ricardo.pereira.nascimento
 */
public class Texto extends Elemento {
	
	/**
	 * Cria um Texto.
	 * 
	 * @param prioridade Valor inteiro entre 1-5 (inclusive) que indica a prioridade do elemento.
	 * @param valor Dados do elemento.
	 */
	public Texto(int prioridade, String valor) {
		super(prioridade, valor);
	}
	
	/**
	 * Representação completa de Texto.
	 * 
	 * @return Dados do elemento da forma que foram passados.
	 */
	@Override
	public String toStringCompleto() {
		return getValor();
	}
	
	/**
	 * Representação resumida de Texto.
	 * 
	 * @return Dados do elemento da forma que foram passados.
	 */
	@Override
	public String toStringResumido() {
		return getValor();
	}
}
