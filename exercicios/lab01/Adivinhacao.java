/** 
 * Laboratório de Programação 2
 *
 * @author Paulo Ricardo - 122110535
 */

import java.util.Scanner;

public class Adivinhacao {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int tentativa;

		while (true) {
			tentativa = sc.nextInt();

			if (tentativa < num) {
				System.out.println("MENOR");
			} else if (tentativa > num) {
				System.out.println("MAIOR");
			} else {
				System.out.println("ACERTOU");
				break;
			}
		}

	}
}
