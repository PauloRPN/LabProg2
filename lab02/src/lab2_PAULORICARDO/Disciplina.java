package lab2_PAULORICARDO;
import java.util.Arrays;

/**
 * Classe responsável pelo encapsulamento do cálculo e controle da média, 
 * e status de aprovação de uma disciplina.
 * 
 * @author paulo.ricardo.pereira.nascimento
 *
 */
public class Disciplina {
	private String disciplina = new String();
	private int horasEstudo, denominador;
	private double[] notas;
	private double media;
	private int[] pesos;
	
	/**
	 * Constrói um objeto do tipo Disciplina definindo, de acordo com o parâmetro,
	 *para qual disciplina será calculada a média aritmética padrão (4 notas). 
	 * 
	 * @param nomeDisciplina disciplina definida para controle
	 */
	public Disciplina(String nomeDisciplina) {
		disciplina = nomeDisciplina;
		notas = new double[4];
	}
	
	/**
	 * Constrói um objeto do tipo Disciplina definindo, de acordo com o parâmetro,
	 *para qual disciplina será calculada a média aritmética, que não segue o padrão
	 *de 4 notas. 
	 * 
	 * @param nomeDisciplina disciplina definida para controle
	 * @param numeroDeNotas número de notas necessário para a média da disciplina 
	 */
	public Disciplina(String nomeDisciplina, int numeroDeNotas) {
		disciplina = nomeDisciplina;
		notas = new double[numeroDeNotas];
	}
	
	
	/**
	 * Constrói um objeto do tipo Disciplina definindo, de acordo com o parâmetro,
	 *para qual disciplina será calculada a média ponderada, com número de notas
	 *a ser definido. 
	 * 
	 * @param nomeDisciplina disciplina definida para controle
	 * @param numeroDeNotas número de notas necessário para a média da disciplina
	 * @param pesosDasNotas pesos para cada nota que vai difinir a média da disciplina 
	 */
	public Disciplina(String nomeDisciplina, int numeroDeNotas, int[] pesosDasNotas) {
		disciplina = nomeDisciplina;
		notas = new double[numeroDeNotas];
		pesos = pesosDasNotas;
	}
	
	public void cadastraHoras(int horas) {
		horasEstudo = horas;
	}
	
	/**
	 * Recebe e armazena as notas da disciplina de acordo com o parâmetro referente;
	 *isto é, nota 1 recebe um valor, nota 2 recebe outro valor e assim sucessivamente.
	 * 
	 * @param nota número entre 1 e 4 referente a nota (1: nota 1, 2: nota 2, 3: nota 3, 4: nota 4)
	 * @param valorNota valor da nota referenciada no parâmetro anterior
	 */
	public void cadastraNota(int nota, double valorNota) {
		notas[nota-1] = valorNota;
	}
	
	
	/**
	 * Calcula a média (aritmética ou ponderada) da disciplina e retorna seu status
	 *(maior ou igual, ou menor que 7.0).
	 * 
	 * @return true para média maior ou igual a 7.0, e false para média inferior a 7.0.  
	 */
	public boolean aprovado() {
		media = 0;
		
		if (pesos == null) {
			for (double nota : notas) {
				media += nota;
			}

			media /= notas.length;
			
		} else {
			for (int i = 0; i < notas.length; i++) {
				media += notas[i] * pesos[i];
				denominador += pesos[i];
			}
		
			media /= denominador;
		}
		
		if (media >= 7) {
			return true;
		} return false;
	}
	
	
	/**
	 * Retorna a String de representação do controle da disciplina com as informações:
	 * horas de estudo registrada para a disciplina, média e a lista de notas. 
	 * 
	 * @return a disciplina, horas de estudo, média e lista de notas
	 */
	public String toString() {
		return disciplina + " " + horasEstudo + " " + String.format("%.1f", media) + " " + Arrays.toString(notas);
	}
}