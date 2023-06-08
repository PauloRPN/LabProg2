package lab2_PAULORICARDO;
import java.util.Arrays;

public class CoisaBonus {
	public static void main(String[] args) {
		controlarDisciplina();
		System.out.println("-----");
		registrarResumos();
		System.out.println("-----");
		registrarDescanso();
	    System.out.println("-----");
	}
	
	private static void controlarDisciplina() {
	      Disciplina math = new Disciplina("MATEMATICA", 2, new int[]{6, 4});
	      math.cadastraHoras(4);
	      math.cadastraNota(1, 5.0);
	      math.cadastraNota(2, 6.0);
	      System.out.println(math.aprovado());
	      System.out.println(math.toString());
	      
	      Disciplina portugues = new Disciplina("PORTUGUES", 3);
	      portugues.cadastraHoras(5);
	      portugues.cadastraNota(1, 8.5);
	      portugues.cadastraNota(2, 9.0);
	      portugues.cadastraNota(3, 10.0);
	      System.out.println(portugues.aprovado());
	      System.out.println(portugues.toString());
	}
	
	private static void registrarResumos() {
		RegistroResumos meusResumos = new RegistroResumos(100);
	     
	    meusResumos.adiciona("Classes", "Classes definem um tipo e a base de código para criação de objetos.");
	    meusResumos.adiciona("Tipo", "Identifica a semântica (operações e significados) de um conjunto de dados.");
	    meusResumos.adiciona("Array", "Um array é uma estrutura de dados usada para armazenar dados do mesmo tipo.");
	    
	    System.out.println(Arrays.toString(meusResumos.busca("um")));

	}
	
	public static void registrarDescanso() {
	      Descanso descanso = new Descanso();
	      System.out.println(descanso.getStatusGeral());
	      descanso.definirEmoji("*_*");
	      System.out.println(descanso.getStatusGeral());
	      descanso.defineHorasDescanso(30);
	      descanso.defineNumeroSemanas(1);
	      descanso.definirEmoji(":(");
	      System.out.println(descanso.getStatusGeral());
	      descanso.defineHorasDescanso(26);
	      descanso.defineNumeroSemanas(1);
	      System.out.println(descanso.getStatusGeral());
	      descanso.defineHorasDescanso(26);
	      descanso.defineNumeroSemanas(2);
	      System.out.println(descanso.getStatusGeral());
	      descanso.defineHorasDescanso(26);
	      descanso.defineNumeroSemanas(1);
	      System.out.println(descanso.getStatusGeral());
	  }

}
