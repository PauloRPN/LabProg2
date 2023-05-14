package mrBet;

import java.util.HashSet;
import java.util.Objects;

/**
 * Classe de encapsulamento do conceito de Time. Essencialmente, um time tem um código identificador,
 * um nome e um mascote.
 * 
 * @author paulo.ricardo.pereira.nascimento
 *
 */
public class Time {
	private String id;
	private String nome;
	private String mascote;
	private HashSet<Campeonato> campeonatos;
	private int qtdeCampeonatos;
	private int popularidade;
	
	/**
	 * Constrói um time.
	 * 
	 * @param id Código que identifica o time.
	 * @param nome Nome do time.
	 * @param mascote Mascote do time.
	 */
	public Time(String id, String nome, String mascote) {
		this.id = id;
		this.nome = nome;
		this.mascote = mascote;
		campeonatos = new HashSet<>();
	}
	
	/**
	 * Recupera o código identificador do time.
	 * 
	 * @return Retorna o código identificador do time.
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Recupera o nome do time.
	 * 
	 * @return Retorna o nome do time.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Recupera o mascote do time.
	 * 
	 * @return Retorna o mascote do time.
	 */
	public String getMascote() {
		return mascote;
	}
	
	/**
	 * Guarda os campeonatos dos quais o time faz parte.
	 * 
	 * @param campeonato Campeonato do qual o time faz parte.
	 */
	public void guardarCampeonato(Campeonato campeonato) {
		campeonatos.add(campeonato);
		qtdeCampeonatos++;
	}
	
	/**
	 * Recupera a quantidade de campeonatos do qual o time faz parte.
	 * 
	 * @return Retorna a quantidade de campeonatos do qual o time faz parte.
	 */
	public int getQtdeCampeonatos() {
		return qtdeCampeonatos;
	}
	
	/**
	 * Recupera os campeonatos dos quais o time faz parte.
	 * 
	 * @return Retorna o conjunto de campeonatos dos quais o time faz parte.
	 */
	public HashSet<Campeonato> getCampeonatos() {
		return (HashSet<Campeonato>) campeonatos.clone();
	}
	
	/**
	 * Representação textual do time. A representação textual de time segue o seguinte padrão:
	 * "[[código identificador]] [nome] / [mascote]".
	 * 
	 * @return Retorna a representação textual do time.
	 */
	@Override
	public String toString() {
		return "[" + getId() + "] " + getNome() + " / " + getMascote();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(id, other.id);
	}
	
	/**
	 * Aumenta a popularidade do time quando ele recebe uma aposta de primeiro lugar em algum campeonato do qual faz parte.
	 */
	public void aumentarPopularidade() {
		popularidade++;
	}
	
	/**
	 * Recupera a quantidade de vezes que o time recebeu uma aposta de primeiro lugar.
	 * 
	 * @return A popularidade do time.
	 */
	public int getPopularidade() {
		return popularidade;
	}
}
