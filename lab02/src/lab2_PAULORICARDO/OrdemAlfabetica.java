package lab2_PAULORICARDO;
import java.util.ArrayList;

/**
 * Classe responsável pelo encapsulamento da ordenação alfabética de um array.
 * 
 * @author paulo.ricardo.pereira.nascimento
 *
 */
public class OrdemAlfabetica {
	String[] entrada;
	String temp = new String();
	
	
	/**
	 * O método ordenaArray() recebe como parâmetro um ArrayList<String> para
	 *ser reorganizado e retornado em ordem alfabética.
	 *	O retorno do método é um String[].
	 *
	 * @param array
	 * @return
	 */
	public String[] ordenaArray(ArrayList<String> arrayList) {
		entrada = arrayList.toArray(new String[arrayList.size()]);

		for (int i = 0; i < entrada.length; i++) {
			for (int j = i + 1; j < entrada.length; j++) {
				if (entrada[i].compareTo(entrada[j]) > 0) {
					temp = entrada[i];
	                   entrada[i] = entrada[j];
	                   entrada[j] = temp;
	            }
			}
		}
		
		return entrada;
	}
}
