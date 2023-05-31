package lab2_PAULORICARDO;

/**
 * EClasse responsável pelo encapsulamento de registro do tempo online dedicado a uma
 * disciplina remota.
 * 
 * @author paulo.ricardo.pereira.nascimento
 *
 */
public class RegistroTempoOnline {
	private String disciplina = new String();
	private int tempoOnline;
	private int metaTempoOnline;
	
	/**
	 * Constrói um registro de tempo online com meta de tempo padrão de 120 horas para
	 * determinada disciplina.
	 * 
	 * @param nomeDisciplina nome da disciplina remota a receber meta de tempo padrão.
	 */
	public RegistroTempoOnline(String nomeDisciplina) {
		disciplina = nomeDisciplina;
		metaTempoOnline = 120;
	}
	
	/**
	 * Constrói um registro de tempo online com meta de tempo para estudos online definida pelo aluno.
	 * 
	 * @param nomeDisciplina nome da disciplina remota que terá tempo online registrado.
	 * @param tempoOnlineEsperado quantidade de horas definida pelo aluno como tempo
	 * esperado parar estudos online.
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		disciplina = nomeDisciplina;
		metaTempoOnline = tempoOnlineEsperado;
	}
	
	public void adicionaTempoOnline(int tempo) {
		tempoOnline += tempo;
	}
	
	/**
	 * Retorna o valor booleano true se o tempo dedicado a estudos online atinja a meta definida
	 * previamente. Caso contrário, retorna o valor booleano false.
	 * 
	 * @return status de verificação de conclusão da meta.
	 */
	public boolean atingiuMetaTempoOnline() {
		if (tempoOnline >= metaTempoOnline) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna a String da disciplina com o total de tempo online de estudos atual em comparação ao
	 * tempo meta definido. A representação segue o formato "disciplina tempoAtual/tempoMeta".
	 * 
	 * @return a String de representação da disciplina, seu tempo de estudos atingido e seu tempo meta. 
	 */
	public String toString() {
		return disciplina + " " + tempoOnline + "/" + metaTempoOnline;
	}
}
