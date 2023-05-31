/**
 * Laboratório de Programação 2
 *
 * @author Paulo Ricardo - 122110535
 */

import java.util.Scanner;

public class MaioresGastos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] gastos = sc.nextLine().split(" ");
		int maior1 = 0;
	        int maior2 = 0;
		int num;

		for (int i = 0; i < (gastos.length); i++) {
			num = Integer.parseInt(gastos[i]);

			if (num > maior1) {
				maior2 = maior1;
				maior1 = num;
			} else if (num > maior2) {
				maior2 = num;
			}
		}

		System.out.println(maior1 + maior2);
	
	}
}
