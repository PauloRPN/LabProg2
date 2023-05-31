package lab2_PAULORICARDO;

/**
 * Classe responsável pelo encapsulamento do acompanhamento de descanso do aluno,
 *que deve descansar 26 horas ou mais (de lazer) por semana para se considerar descansado. 
 *  
 * @author paulo.ricardo.pereira.nascimento
 *
 */
public class Descanso {
	private int horasDescanso;
	private int numSemanas;
	private String emoji = new String("");
	private String statusAnterior = new String("");
	private String emojiAnterior = new String("");
	private int horasSemanas;
	private String status = new String("cansado");
	
	public void defineHorasDescanso(int valor) {
		horasDescanso = valor;
	}
	
	public void defineNumeroSemanas(int valor) {
		numSemanas = valor;
	}
	
	
	/**
	 * Calcula a quantidade de horas de descanso do aluno por semana e retorna como status
	 * "descansado" para 26 horas ou mais de lazer, e "cansado" para menos de 26 horas. 
	 * Além disso, pode retornar um emoji de sentimento caso tenha sido definido pelo aluno.
	 * 
	 * @return o estado do aluno
	 */
	public String getStatusGeral() {
		if (numSemanas != 0) {
			horasSemanas = horasDescanso / numSemanas;
		}
		
		if (horasSemanas >= 26) {
			status = "descansado";
		} else {
			status = "cansado";
		}
		
		if (!status.equals(statusAnterior) && emoji.equals(emojiAnterior)) {
			statusAnterior = status;
			return status;
		}
		
		emojiAnterior = emoji;
		statusAnterior = status;
		return status + " - " + emoji;
	}
	
	public void definirEmoji(String valor) {
		emoji = valor;
	}
}