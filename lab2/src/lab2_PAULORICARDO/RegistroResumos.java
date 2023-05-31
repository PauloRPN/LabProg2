package lab2_PAULORICARDO;
import java.util.ArrayList;

/**
 * Classe responsável pelo encapsulamento de uma quantidade determinada
 *de registros de estudos realizados ao longo do período. Novos resumos
 *substituiem antigos ao serem adicionados após a quantidade pré-determinada
 *ser atingida. 
 * 
 * @author paulo.ricardo.pereira.nascimento
 *
 */
public class RegistroResumos {
	private String[][] resumos;
	private int i, numResumos, cont;
	private String[] retornaResumos;
	private String retornaTemas;
	private ArrayList<String> listaBusca = new ArrayList<String>();
	
	/**
	 * Constrói um objeto do tipo RegistroResumos com um inteiro como parâmetro
	 *que define a quantidade de resumos que possivelmente serão registrados.
	 * 
	 * @param NumeroDeResumos número de resumos que possivelmente serão registrados
	 */
	public RegistroResumos(int NumeroDeResumos) {
		numResumos = NumeroDeResumos;
		resumos = new String[numResumos][2];
	}
	
	
	/**
	 * Registra resumos e seus temas no sistema de registros.
	 * 
	 * @param tema tema do resumo a ser registrado
	 * @param resumo resumo a ser registrado
	 */
	public void adiciona(String tema, String resumo) {
		if (i < numResumos) {
			resumos[i][0] = tema;
			resumos[i][1] = resumo;
			cont++;
		} else {
			resumos[0][0] = tema;
			resumos[0][1] = resumo;
			i = 0;
		}
		
		i++;	
	}
	
	
	/**
	 * Retorna resumos e seus devidos temas registrados no sistema.
	 * O retorno segue o formato "tema: resumo".
	 * 
	 * @return temas e resumos
	 */
	public String[] pegaResumos() {
		retornaResumos = new String[cont];
		
		for(int j = 0; j < cont; j++) {
			retornaResumos[j] = resumos[j][0] + ": " + resumos[j][1];
		}
		
		return retornaResumos;
	}
	
	
	/**
	 * Retorna a quantidade de resumos registrados e seus devidos temas.
	 * 
	 * @return a quantidade de resumos e temas
	 */
	public String imprimeResumos() {
		for(int j = 0; j < cont; j++) {
			if(j >= 1) {
				retornaTemas += " | " + resumos[j][0];
			} else if(j == 0) {
				retornaTemas = resumos[0][0];
			}
		}
		
		return "- " + cont + " resumo(s) cadastrado(s)\n" + "- " + retornaTemas;
	}
	
	
	/**
	 * Retorna a quantidade de resumos de estudos já registrados.
	 * 
	 * @return quantidade de resumos
	 */
	public int conta() {
		return cont;
	}
	
	
	/**
	 * Retorna true ou false para a pesquisa por temas de resumos registrados.
	 * 
	 * @param tema tema a ser buscado nos resumos registrados
	 * @return true para a existência do tema, false para a não-existência
	 */
	public boolean temResumo(String tema) {
		for(int j = 0; j < cont; j++) {
			if(resumos[j][0].equals(tema)) {
				return true;
			}
		}
	
		return false;
	}
	
	
	/**
	 * Realiza a busca de uma palavra nos resumos registrados e retorna
	 *os temas cujo resumo contém a palavra. Os temas são retornados em 
	 *ordem alfabética.
	 * 
	 * @param chaveDeBusca palavra a ser buscada nos resumos registrados
	 * @return um array de temas ordenados alfabeticamente
	 */
	public String[] busca(String chaveDeBusca) {
		for (int j = 0; j < cont; j++) {
			for (String palavra : resumos[j][1].split(" ")) {
				if (palavra.toLowerCase().equals(chaveDeBusca.toLowerCase())) {
					listaBusca.add(resumos[j][0]);
				}
			}
		}
		
		OrdemAlfabetica ordem = new OrdemAlfabetica();
		return ordem.ordenaArray(listaBusca);
	}
}
