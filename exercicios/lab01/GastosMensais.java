/** 
 * Laboratório de Programação 2
 *
 * @author Paulo Ricardo - 122110535
 */

import java.util.Scanner;

public class GastosMensais {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] meses = sc.nextLine().split(" ");
		String[] gastos = sc.nextLine().split(" ");
		String consulta = sc.next();
		
		for (int i = 0; i < meses.length; i++) {
			if (consulta.equals(meses[i])) {
				System.out.println(gastos[i]);
				break;
			}
		}
		
	}
}
