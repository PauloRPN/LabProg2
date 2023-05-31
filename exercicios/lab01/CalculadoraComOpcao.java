/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Paulo Ricardo - 122110535
 */

import java.util.Scanner;

public class CalculadoraComOpcao {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String op = sc.next();
                float resultado;

		if(!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/")) {
            System.out.println("ENTRADA INVALIDA");
            System.exit(0);
        }

                float num1 = sc.nextFloat();
		float num2 = sc.nextFloat();

		if(op.equals("+")) {
                        resultado = num1 + num2;
                        System.out.println("RESULTADO: " + resultado);
                } else if(op.equals("-")) {
                        resultado = num1 - num2;
                        System.out.println("RESULTADO: " + resultado);
                } else if(op.equals("*")) {
                        resultado = num1 * num2;
                        System.out.println("RESULTADO: " + resultado);
                } else {
                        if(num2 == 0) {
                                System.out.println("ERRO");
                                System.exit(0);
			}
                        resultado = num1 / num2;
                        System.out.println("RESULTADO: " + resultado);
                }
        }
}


