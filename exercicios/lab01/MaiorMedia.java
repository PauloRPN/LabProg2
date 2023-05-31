/**
 * Laboratório de Programa 2 - Lab 01
 *
 * @author Paulo Ricardo - 122110535
 */

import java.util.Scanner;

public class MaiorMedia {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] numeros = sc.nextLine().split(" ");
		int somatorio = 0, qtd = 0, cont = 0;

		for (String i : numeros) {
			int num = Integer.parseInt(i);
			somatorio += num;
			qtd++;
		}

		double media = somatorio / qtd;

		for (String i : numeros) {
			int num = Integer.parseInt(i);

			if (num > media) {
				System.out.print(i + " ");
			}
		}

	}
}
