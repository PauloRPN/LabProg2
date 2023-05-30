package mrBet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * Classe que representa o MrBet.
 * 
 * @author paulo.ricardo.pereira.nascimento
 *
 */
public class MrBetSistema {
	private HashMap<String, Time> times; 
	private HashMap<String, Campeonato> campeonatos;
	private ArrayList<Aposta> apostas;
	private Historico historico;
	
	/**
	 * Constrói o sistema MrBet.
	 */
	public MrBetSistema() {
		times = new HashMap<>();
		campeonatos = new HashMap<>();
		apostas = new ArrayList<>();
		historico = new Historico();
	}
	
	/**
	 * Realiza a inclusão de um time no MrBet.
	 * 
	 * @param idTime Identificação do time.
	 * @param nome Nome do time.
	 * @param mascote Mascote do time.
	 * @return Retorna uma mensagem de confirmação de inclusão do time caso seja incluído.
	 * @throws IllegalArgumentException Lança exceção para a tentativa de inclusão de times já inclusos.
	 */
	public String incluirTime(String idTime, String nome, String mascote) {
		if (times.containsKey(idTime)) {
			throw new IllegalArgumentException("O TIME JÁ EXISTE!"); 
		}
		
		times.put(idTime, new Time(idTime, nome, mascote));
		
		return "INCLUSÃO REALIZADA!";
	}
	
	/**
	 * Recupera as informações de um time incluso no MrBet.
	 * 
	 * @param idTime Identificação do time.
	 * @return Retorna as informações do time.
	 * @throws NoSuchElementException Lança exceção para a tentativa de recuperação de um time não incluso no MrBet.
	 */
	public String recuperarTime(String idTime) {
		if (!times.containsKey(idTime)) {
			throw new NoSuchElementException("O TIME NÃO EXISTE!"); 
		}
		
		return times.get(idTime).toString();
	}
	
	/**
	 * Adiciona um campeonato ao sistema.
	 * 
	 * @param nomeCampeonato Nome que identifica o campeonato.
	 * @param qtdeTimes Quantidade de times que podem participar do campeonato.
	 * @return Retorna uma mensagem de confirmação de adição do time caso seja adicionado.
	 * @throws IllegalArgumentException Lança exceção para a tentitiva de adição de campeonato já existente no MrBet.
	 */
	public String adicionarCampeonato(String nomeCampeonato, int qtdeTimes) {
		if (campeonatos.containsKey(nomeCampeonato)) {
			throw new IllegalArgumentException("O CAMPEONATO JÁ EXISTE!");
		}
		
		campeonatos.put(nomeCampeonato, new Campeonato(nomeCampeonato, qtdeTimes));
		return "CAMPEONATO ADICIONADO!";
	}
	
	/**
	 * Adiciona um time registrado no MrBet a um campeonato também registrado.
	 * 
	 * @param idTime Identificação do time.
	 * @param nomeCampeonato Nome que identifica o campeonato.
	 * @return Retorna uma mensagem de confirmação de inclusão do time ao campeonato caso seja incluído.
	 * @throws NoSuchElementException Lança exceção para times ou campeonatos não registrados no MrBet.
	 * @throws IllegalArgumentException Lança exceção para campeonatos sem vagas.
	 */
	public String incluirTimeCampeonato(String idTime, String nomeCampeonato) {
		if (!times.containsKey(idTime)) {
			throw new NoSuchElementException("O TIME NÃO EXISTE!");
		} else if (!campeonatos.containsKey(nomeCampeonato)) {
			throw new NoSuchElementException("O CAMPEONATO NÃO EXISTE!");
		} else if (campeonatos.get(nomeCampeonato).isFull()) {
			throw new IllegalArgumentException("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!");
		}
		
		campeonatos.get(nomeCampeonato).incluirTime(times.get(idTime));
		times.get(idTime).guardarCampeonato(campeonatos.get(nomeCampeonato));
		
		return "TIME INCLUÍDO NO CAMPEONATO!";
	}
	
	/**
	 * Verifica se um time registrado no MrBet está num determinado campeonato também registrado.
	 * 
	 * @param idTime Identificação do time.
	 * @param nomeCampeonato Nome que identifica o campeonato.
	 * @return Retorna uma mensagem de confirmação para time incluso no camponato ou de negação caso não esteja.
	 * @throws NoSuchElementException Lança exceção para times ou campeonatos não registrados no MrBet.
	 */
	public String verificarInclusaoTimeEmCampeonato(String idTime, String nomeCampeonato) {
		if (!times.containsKey(idTime)) {
			throw new NoSuchElementException("O TIME NÃO EXISTE!");
		} else if (!campeonatos.containsKey(nomeCampeonato)) {
			throw new NoSuchElementException("O CAMPEONATO NÃO EXISTE!");
		}
		
		if (campeonatos.get(nomeCampeonato).contemTime(idTime)) {
			return "O TIME ESTÁ NO CAMPEONATO!";
		}
		
		return "O TIME NÃO ESTÁ NO CAMPEONATO!";
	}
	
	/**
	 * Recupera os campeonatos que um time faz parte.
	 * 
	 * @param idTime Identificação do time.
	 * @return Retorna um mapa dos campeonatos que o time faz parte.
	 * @throws NoSuchElementException Lança exceção para times não registrados no MrBet.
	 * @throws IllegalArgumentException Lança exceção para times sem campeonatos.
	 */
	public HashSet<Campeonato> getCompeonatosTime(String idTime) {
		if (!times.containsKey(idTime)) {
			throw new NoSuchElementException("O TIME NÃO EXISTE!");
		} else if (times.get(idTime).getQtdeCampeonatos() == 0) {
			throw new IllegalArgumentException("O TIME NÃO ESTÁ EM NENHUM CAMPEONATO!");
		}
		
		return times.get(idTime).getCampeonatos();
	}
	
	/**
	 * Recupera os times registrados no MrBet.
	 * 
	 * @return Retorna um mapa dos times registrados no MrBet.
	 */
	public HashMap<String, Time> getTimes() {
		return (HashMap<String, Time>) times.clone();
	}
	
	/**
	 * Recupera os campeonatos registrados no MrBet.
	 * 
	 * @return Retorna um mapa dos campeonatos registrados no MrBet.
	 */
	public HashMap<String, Campeonato> getCampeonatos() {
		return (HashMap<String, Campeonato>) campeonatos.clone();
	}
	
	/**
	 * Realiza aposta em um time em algum campeonato do qual ele faz parte.
	 * 
	 * @param idTime Identificação do time.
	 * @param nomeCampeonato Nome que identifica o campeonato.
	 * @param colocacao Colocação na qual deseja-se apostar que o time ficará no campeonato. 
	 * @param valorAposta Valor da aposta.
	 * @return Returna uma mensagem de confirmação caso a aposta seja realizada com sucesso.
	 * @throws NoSuchElementException Lança exceção para times ou campeonatos não registrados no MrBet.
	 * @throws IllegalArgumentException Lança exceção para times não inclusos no campeonato desejado ou 
	 * para a tentativa de aposta em colocação maior que a quantidade de colocações possíveis do campeonato.
	 */
	public String apostar(String idTime, String nomeCampeonato, int colocacao, double valorAposta) {
		if (!times.containsKey(idTime)) {
			throw new NoSuchElementException("O TIME NÃO EXISTE!");
		} else if (!campeonatos.containsKey(nomeCampeonato)) {
			throw new NoSuchElementException("O CAMPEONATO NÃO EXISTE!");
		} else if (!campeonatos.get(nomeCampeonato).contemTime(idTime)) {
			throw new IllegalArgumentException("O TIME NÃO ESTÁ NO CAMPEONATO!");
		} else if (colocacao > campeonatos.size()) {
			throw new IllegalArgumentException("APOSTA NÃO REGISTRADA!");
		}
		
		apostas.add(new Aposta(times.get(idTime), campeonatos.get(nomeCampeonato), colocacao, valorAposta));
		
		if (colocacao == 1) {
			times.get(idTime).aumentarPopularidade();
		}
		
		return "APOSTA REGISTRADA!";
	}
	
	/**
	 * Recupera as apostas do MrBet.
	 * 
	 * @return Retorna um ArrayList das apostas do MrBet.
	 */
	public ArrayList<Aposta> getApostas() {
		return (ArrayList<Aposta>) apostas.clone();
	}
	
	/**
	 * Recupera o histórico de times com maior participação em campeonatos.
	 * 
	 * @return Retorna um ArrayList dos times com maior participação em campeonatos.
	 */
	public ArrayList<Time> getTimesMaiorParticipacao() {
		return historico.recuperarTimesMaiorParticipacao(times);
	}
	
	/**
	 * Recupera o histórico de times sem participação em campeonatos.
	 * 
	 * @return Retorna um ArrayList dos times sem participação em campeonatos.
	 */
	public ArrayList<Time> getTimesSemCampeonatos() {
		return historico.recuperarTimesSemCampeonatos(times);
	}
	
	/**
	 * Recupera o histórico de times populares em apostas.
	 * 
	 * @return Retorna um ArrayList dos times populares em apostas.
	 */
	public ArrayList<Time> getTimesPopulares() {
		return historico.recuperarTimesPopulares(times);
	}
}
