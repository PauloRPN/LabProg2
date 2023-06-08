package documin.elemento;

/**
 * Subtípo de Elemento. Além dos atributos do supertipo, Título tem um nível e uma condição de ser linkável ou não.
 * 
 * @author paulo.ricardo.pereira.nascimento
 */
public class Titulo extends Elemento {
	private int nivel;
	private boolean linkavel;
	
	/**
	 * Cria um Titulo.
	 * 
	 * @param prioridade Valor inteiro entre 1-5 (inclusive) que indica a prioridade do elemento.
	 * @param valor Dados do elemento.
	 * @param nivel Nível Valor inteiro entre 1-5 (inclusive).
	 * @param linkavel Condição booleana para o Titulo possuir link.
	 */
	public Titulo(int prioridade, String valor, int nivel, boolean linkavel) {
		super(prioridade, valor);
		this.nivel = nivel;
		this.linkavel = linkavel;
	}
	
	/**
	 * Representação completa de Título, que pode ter ou não um link de acordo com seus atributos.
	 * 
	 * @return
	 */
	@Override
	public String toStringCompleto() {
		if (linkavel) {
			return toStringResumido() + " -- " + getLink();
		}
		
		return toStringResumido();
	}
	
	/**
	 * Formata o link de um título linkável.
	 * 
	 * @return Link do título.
	 */
	private String getLink() {
		return nivel + "-" + getValor().replace(" ", "").toUpperCase();
	}
	
	/**
	 * Representação resumida de Título.
	 * 
	 * @return Representação resumida de Título.
	 */
	@Override
	public String toStringResumido() {
		return nivel + ". " + getValor();
	}
}
