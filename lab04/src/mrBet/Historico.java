package mrBet;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe de histórico de algumas informações que precisam ser recuperadas pelo MrBet.
 * As informações recuparadas pelo histórico são: times com maior participação em campeonatos, times sem participações em campeonatos
 * e times populares em apostas.
 * 
 * @author paulo.ricardo.pereira.nascimento
 *
 */
public class Historico {
	
	/**
	 * Constrói um histórico.
	 */
	public Historico() {}
	
	/**
	 * Recupera o histórico de times com maior participação em campeonatos. Se mais de um time tem a maior quantidade de participações em campeonatos,
	 * todos eles são recuperados.
	 * 
	 * @param times Mapa de times dos quais deseja-se recuparar aqueles com a maior participação em campeonatos.
	 * @return Retorna um ArrayList dos times com maior participação em campeonatos.
	 */
	public ArrayList<Time> recuperarTimesMaiorParticipacao(HashMap<String, Time> times) {
		ArrayList<Time> TimesMaiorParticipacao = new ArrayList<>();
		TimesMaiorParticipacao.add(new Time("", "", ""));
		
		for (Time time : times.values()) {
			if (time.getQtdeCampeonatos() == TimesMaiorParticipacao.get(0).getQtdeCampeonatos()) {
				TimesMaiorParticipacao.add(time);
			} else if (time.getQtdeCampeonatos() > TimesMaiorParticipacao.get(0).getQtdeCampeonatos()) {
				TimesMaiorParticipacao.removeAll(TimesMaiorParticipacao);
				TimesMaiorParticipacao.add(time);				
			}
		}
		
		return (ArrayList<Time>) TimesMaiorParticipacao.clone();
	}
	
	/**
	 * Recupera o histórico de times sem participação em campeonatos. Se mais de um time não tem participação em campeonatos, todos eles são recuperados.
	 * 
	 * @param times Mapa de times dos quais deseja-se recuperar aqueles sem participação em campeonatos.
	 * @return Retorna um ArrayList dos times sem participação em campeonatos.
	 */
	public ArrayList<Time> recuperarTimesSemCampeonatos(HashMap<String, Time> times) {
		ArrayList<Time> timesSemCampeonatos = new ArrayList<>();
		
		for (Time time : times.values()) {
			if (time.getQtdeCampeonatos() == 0) {
				timesSemCampeonatos.add(time);
			}
		}
		
		return (ArrayList<Time>) timesSemCampeonatos.clone();
	}
	
	/**
	 * Recupera o histórico de times populares em apostas. O critério de popularidade é ter apostas de primeiro lugar em campeonatos.
	 * 
	 * @param times Mapa de times dos quais deseja-se recuperar os populares.
	 * @return Retorna um ArrayList dos times populares em apostas.
	 */
	public ArrayList<Time> recuperarTimesPopulares(HashMap<String, Time> times) {
		ArrayList<Time> timesPopulares = new ArrayList<>();
		
		for (Time time : times.values()) {
			if (time.getPopularidade() >= 1) {
				timesPopulares.add(time);
			}
		}
		
		return (ArrayList<Time>) timesPopulares.clone();
	}
}