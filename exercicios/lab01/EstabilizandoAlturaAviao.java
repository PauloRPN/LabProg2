/**
 * Laboratório de Programação 2
 *
 * @author Paulo Ricardo - 122110535
 */

import java.util.Scanner;

public class EstabilizandoAlturaAviao {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int newHeight, newAprox;
		int ideal = sc.nextInt(); // ideal height
		int current = sc.nextInt(); // current height
		int lastAprox = Math.abs(ideal - current);

		while (true) {
			newHeight = sc.nextInt();
			newAprox = Math.abs(ideal - newHeight);

			if (newHeight == ideal) {
				System.out.println("OK");
				break;
			}
			
			if (newAprox < lastAprox) {
				System.out.println("ADEQUADO");
			} else {
				System.out.println("PERIGO");
				current = 0;
			}

			current = newHeight;
			lastAprox = Math.abs(ideal - current);
		}

	}
}
