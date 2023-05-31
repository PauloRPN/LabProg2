/**
 * Laboratório de Programação 2 - Lab 01
 *
 * @author Paulo Ricardo - 122110535
 */

import java.util.Scanner;

public class Wally {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] lista;
		boolean flag;
		int tam;

		while (true) {
			lista = sc.nextLine().split(" ");
			flag = false;
			
			if (lista[0].equals("wally")) {
				break;	
			} else {
				for (int i = (lista.length - 1); i >= 0; i--) {
					tam = lista[i].length();
                        		if (tam == 5) {
						System.out.println(lista[i]);
						flag = true;
						break;
					}
				}
			}

			if (!flag) {
				System.out.println("?");
			}	
		}
	}
}
