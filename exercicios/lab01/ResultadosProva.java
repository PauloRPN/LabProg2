/**
 * Laboratório de Programação 2 - Lab 01
 *
 * @author Paulo Ricardo - 122110535
 */

import java.util.Scanner;

public class ResultadosProva {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada;
		int maior = 0;
	        int menor = 1000;
		int media = 0, cont = 0;
		int nota = 0;
	        int acima = 0, abaixo = 0;

		while (true) {
			entrada = sc.nextLine().split(" ");
			
			if (entrada[0].equals("-")) {
				break;
			}
			
			nota = Integer.parseInt(entrada[1]);
			media += nota;
			cont++;
	
			// Maior e menor notas
			if (nota > maior) {
				maior = nota;
			}
			if (nota < menor) {
				menor = nota;
			}
		
			// Acima ou abaixo de 700
			if (nota < 700) {
				abaixo++;
			} else {
				acima++;
			}	
		}
		
		media /= cont;

		System.out.println("maior: " + maior);
		System.out.println("menor: " + menor);
		System.out.println("media: " + media);
		System.out.println("acima: " + acima);
		System.out.println("abaixo: " + abaixo);
		
	}
}
