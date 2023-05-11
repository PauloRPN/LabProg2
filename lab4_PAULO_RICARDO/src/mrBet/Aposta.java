package mrBet;

/**
 * Classe de encapsulamento do conceito de aposta em MrBet. Aposta tem um time, um campeonato do qual o time
 * faz parte, a colocação apostada no time e um valor.
 * 
 * @author paulo.ricardo.pereira.nascimento
 *
 */
public class Aposta {
	private Time time;
	private Campeonato campeonato;
	private int colocacaoTime;
	private double valorAposta;
	
	/**
	 * Constrói uma aposta.
	 * 
	 * @param time Time no qual deseja-se apostar.
	 * @param campeonato Campeonato no qual a aposta no time será feita.
	 * @param colocacaoTime Colocação na qual deseja-se apostar que o time ficará no campeonato. 
	 * @param valorAposta Valor da aposta.
	 */
	public Aposta(Time time, Campeonato campeonato, int colocacaoTime, double valorAposta) {
		this.time = time;
		this.campeonato = campeonato;
		this.colocacaoTime = colocacaoTime;
		this.valorAposta = valorAposta;
	}
	
	/**
	 * Recupera o time da aposta.
	 * 
	 * @return Retorna o time da aposta.
	 */
	public Time getTime() {
		return time;
	}
	
	/**
	 * Recupera o campeonato da aposta.
	 * 
	 * @return Retorna o campeonato da aposta.
	 */
	public Campeonato getCampeonato() {
		return campeonato;
	}

	/**
	 * Recupera a colocação do time na aposta.
	 * 
	 * @return Retorna a colocação do time na aposta.
	 */
	public int getColocacaoTime() {
		return colocacaoTime;
	}
	
	/**
	 * Recupera o valor da aposta.
	 * 
	 * @return Retorna o valor da aposta.
	 */
	public double getValorAposta() {
		return valorAposta;
	}

	/**
	 * Representação textual da aposta. A representação textual de aposta segue o seguinte padrão:
	 * "[Representação textual do time]
	 * [Nome do campeonato]
	 * [Colocação da aposta]/[quantidade de colocações possíveis do campeonato]
	 * R$ [valor da aposta]"
	 * 
	 * @return Retorna a representação textual da aposta.
	 */
	public String toString() {
		return getTime().toString()
				+ "\n" + getCampeonato().getNome()
				+ "\n" + getColocacaoTime() + "/" + getCampeonato().getQtdeTimes()
				+ "\nR$ " + getValorAposta();
	}
}
