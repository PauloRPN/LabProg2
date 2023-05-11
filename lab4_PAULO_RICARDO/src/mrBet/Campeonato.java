package mrBet;

import java.util.HashMap;
import java.util.Objects;

/**
 * Classe de encapsulamento do conceito de Campeonato. Um campeonato tem um nome que o identifica e uma
 * quantidade de times que podem fazer parte dele.
 * 
 * @author paulo.ricardo.pereira.nascimento
 *
 */
public class Campeonato {
	private String nome;
	private int qtdeTimes;
	private HashMap<String, Time> times;
	private int qtdeTimesInclusos;
	
	/**
	 * Constrói um campeonato.
	 * 
	 * @param nome Nome que identifica o campeonato.
	 * @param qtdeTimes Quantidade de times que podem participar do campeonato.
	 */
	public Campeonato(String nome, int qtdeTimes) {
		this.nome = nome;
		this.qtdeTimes = qtdeTimes;
		qtdeTimesInclusos++;
		times = new HashMap<>();
	}
	
	/**
	 * Recupera o nome do campeonato.
	 * 
	 * @return Retorna o nome do campeonato.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Recupera a quantidade de times que podem participar do campeonato.
	 * 
	 * @return Retorna a quantidade de times que podem participar do campeonato.
	 */
	public int getQtdeTimes() {
		return qtdeTimes;
	}
	
	/**
	 * Recupera a quantidade de times inclusos até o momento no campeonato.
	 * 
	 * @return Retorna a quantidade de times inclusos até o momento no campeonato.
	 */
	public int getQtdeTimesInclusos() {
		return qtdeTimesInclusos;
	}
	
	/**
	 * Recupera um time do campeonato.
	 * 
	 * @param idTime Identificação do time.
	 * @return Retorna o time.
	 */
	public Time getTimeIncluso(String idTime) {
		return times.get(idTime);
	}
	
	/**
	 * Inclui um time ao campeonato.
	 * 
	 * @param time Time a ser incluso no campeonato.
	 */
	public void incluirTime(Time time) {
		times.put(time.getId(), time);
	}
	
	/**
	 * Verifica se o campeonato atingiu seu limite de times.
	 * 
	 * @return Retorna true caso o campeonato esteja cheio. Caso contrário, false.
	 */
	public boolean isFull() {
		if (qtdeTimes == qtdeTimesInclusos) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Verifica se um time está incluso no campeonato.
	 * 
	 * @param idTime Identificação do time.
	 * @return Retorna true caso o time estja no campeonato. Caso contrário, false.
	 */
	public boolean contemTime(String idTime) {
		return times.containsKey(idTime);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campeonato other = (Campeonato) obj;
		return Objects.equals(nome, other.nome);
	}
	
	/**
	 * Representação textual do campeonato. A representação textual de campeonato segue o seguinte padrão
	 * "* [nome do campeonato] - [quantidade de times inclusos]/[quantidade de times que podem ser inclusos]".
	 * 
	 * @return Retorna a representação textual do campeonato.
	 */
	@Override
	public String toString() {
		return "* " + getNome() + " - " + getQtdeTimesInclusos() + "/" + getQtdeTimes();
	}
	
	
}
