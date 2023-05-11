package mrBet;

import java.util.Scanner;

/**
 * Interface com menus texto para manipular um sistema de apostas.
 * 
 * @author paulo.ricardo.pereira.nascimento
 *
 */
public class MainMrBet {
	public static void main(String[] args) {
		MrBetSistema MrBet = new MrBetSistema();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			String[] escolha = menu(scanner);
			comando(escolha, MrBet, scanner);
		}
	}
	
	
	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return Um array com a ou as escolhas do usuário caso o submenu seja acessado.
	 */
	private static String[] menu(Scanner scanner) {
		String[] opcoes = new String[2];
		
		System.out.print(
				"(M) Minha inclusão de times\n"
				+ "(R) Recuperar time\n"
				+ "(.) Adicionar campeonato\n"
				+ "(B) Bora incluir time em campeonato e Verificar se time está em campeonato\n"
				+ "(E) Exibir campeonatos que o time participa\n"
				+ "(T) Tentar a sorte e status\n"
				+ "(H) Histórico\n"
				+ "(!) Já pode fechar o programa!\n"
				+ "\nOpção> ");
		
		opcoes[0] = scanner.next().toUpperCase();
		
		if (opcoes[0].equals("B")) {
			System.out.print(
					"\n(I) Inlcuir time em campeonato"
					+ "\n(V) Verificar se time está em campeoanato\n"
					+ "\nOpção> ");
			opcoes[1] = scanner.next().toUpperCase();
		} else if (opcoes[0].equals("T")) {
			System.out.print("\n(A) Apostar"
					+ "\n(S) Status das Apostas\n"
					+ "\nOpção> ");
			opcoes[1] = scanner.next().toUpperCase();
		}
		
		return opcoes;
	}
	
	/**
	 * Interpreta a(s) opção(ões) escolhida(s) por quem está usando o sistema.
	 * 
	 * @param opcoes A(s) opção(ões) escolhida(s).
	 * @param MrBet O sistema do MrBet sendo manipulado.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input nos métodos acessados.
	 */
	private static void comando(String[] opcoes, MrBetSistema MrBet, Scanner scanner) {
		switch (opcoes[0]) {
		case "M":
			incluirTime(MrBet, scanner);
			break;
		case "R":
			recuperarTime(MrBet, scanner);
			break;
		case ".":
			adicionarCampeonato(MrBet, scanner);
			break;
		case "B":
			if (opcoes[1].equals("I")) {
				incluirTimeCampeonato(MrBet, scanner);
			} else if (opcoes[1].equals("V")) {
				verificarInclusaoTime(MrBet, scanner);
			} else {
				System.out.println("Opção inválida!\n");
			}
			break;
		case "E":
			exibirCampeonatosTime(MrBet, scanner);
			break;
		case "T":
			if (opcoes[1].equals("A")) {
				fazerAposta(MrBet, scanner);
			} else if (opcoes[1].equals("S")) {
				statusAposta(MrBet);
			} else {
				System.out.println("Opção inválida!\n");
			}
			break;
		case "H":
			exibirHistorico(MrBet);
			break;
		case "!":
			sair();
			break;
		default:
			System.out.println("Opção inválida!\n");
		}
	}
	
	/**
	 * Registra um time no MrBet.
	 * 
	 * @param MrBet O sistema MrBet sendo manipulado.
	 * @param scanner Scanner para capturar as informações de registro do time.
	 */
	private static void incluirTime(MrBetSistema MrBet, Scanner scanner) {
		System.out.print("\nCódigo: ");
		String idTime = scanner.next();
		System.out.print("Nome: ");
		String nome = scanner.next();
		System.out.print("Mascote: ");
		String mascote = scanner.next();
		
		try {
			System.out.println("\n" + MrBet.incluirTime(idTime, nome, mascote) + "\n");
		} catch (IllegalArgumentException iae) {
			System.out.println("\n" + iae.getMessage() + "\n");
		}
	}
	
	/**
	 * Exibe a representação textual de um time.
	 * 
	 * @param MrBet O sistema MrBet sendo manipulado.
	 * @param scanner Scanner para capturar o id do time.
	 */
	private static void recuperarTime(MrBetSistema MrBet, Scanner scanner) {
		System.out.print("\nCódigo: ");
		String idTime = scanner.next();
		
		try {
			System.out.println("\n" + MrBet.recuperarTime(idTime) + "\n");
		} catch (IllegalArgumentException iae) {
			System.out.println("\n" + iae.getMessage() + "\n");
		}
	}
	
	/**
	 * Registra um campeonato no MrBet.
	 * 
	 * @param MrBet O sistema MrBet sendo manipulado.
	 * @param scanner Scanner para capturar as informações de registro do campeonato.
	 */
	public static void adicionarCampeonato(MrBetSistema MrBet, Scanner scanner) {
		System.out.print("\nCampeonato: ");
		String nome = scanner.next();
		System.out.print("Participantes: ");
		int qtdeTimes = scanner.nextInt();
		
		try {
			System.out.println("\n" + MrBet.adicionarCampeonato(nome, qtdeTimes) + "\n");
		} catch (IllegalArgumentException iae) {
			System.out.println("\n" + iae.getMessage() + "\n");
		}
	}
	
	/**
	 * Adiciona um time registrado no MrBet a um campeonato também registrado.
	 * 
	 * @param MrBet O sistema MrBet sendo manipulado.
	 * @param scanner Scanner para capturar o id do time e o nome do campeonato.
	 */
	private static void incluirTimeCampeonato(MrBetSistema MrBet, Scanner scanner) {
		System.out.print("\nCódigo: ");
		String idTime = scanner.next();
		System.out.print("Campeonato: ");
		String nomeCampeonato = scanner.next();
		
		try {
			System.out.println("\n" + MrBet.incluirTimeCampeonato(idTime, nomeCampeonato) + "\n");
		} catch (IllegalArgumentException iae) {
			System.out.println("\n" + iae.getMessage() + "\n");
		}
	}
	
	/**
	 * Verifica se um time registrado no MrBet está num determinado campeonato.
	 * 
	 * @param MrBet O sistema MrBet sendo manipulado.
	 * @param scanner Scanner para capturar o id do time e o nome do campeonato.
	 */
	private static void verificarInclusaoTime(MrBetSistema MrBet, Scanner scanner) {
		System.out.print("\nCódigo: ");
		String idTime = scanner.next();
		System.out.print("Campeonato: ");
		String nomeCampeonato = scanner.next();
		
		try {
			System.out.println("\n" + MrBet.verificarInclusaoTime(idTime, nomeCampeonato) + "\n");
		} catch (IllegalArgumentException iae) {
			System.out.println("\n" + iae.getMessage() + "\n");
		}
	}
	
	/**
	 * Exibe uma listagem dos campeonatos que um time participa. 
	 * 
	 * @param MrBet O sistema MrBet sendo manipulado.
	 * @param scanner Scanner para capturar o id do time.
	 */
	private static void exibirCampeonatosTime(MrBetSistema MrBet, Scanner scanner) {
		System.out.print("\nTime: ");
		String idTime = scanner.next();
		
		try {
			MrBet.getCompeonatosTime(idTime);
			
			System.out.println("\nCampeonatos do " + MrBet.getTimes().get(idTime).getNome() + ":");
			for (Campeonato campeonato : MrBet.getCompeonatosTime(idTime)) {
				System.out.println(campeonato.toString());
			}
			
			System.out.println();
		} catch (IllegalArgumentException iae) {
			System.out.println("\n" + iae.getMessage() + "\n");
		}
	}
	
	/**
	 * Exibe o menu para apostar em um time em algum campeonato do qual ele faz parte.
	 * 
	 * @param MrBet O sistema MrBet sendo manipulado.
	 * @param scanner Scanner para capturar as informações de realização da aposta.
	 */
	private static void fazerAposta(MrBetSistema MrBet, Scanner scanner) {
		System.out.print("\nCódigo: ");
		String idTime = scanner.next();
		System.out.print("Campeonato: ");
		String nomeCampeonato = scanner.next();
		System.out.print("Colocação: ");
		int colocao = scanner.nextInt();
		System.out.print("Valor da aposta: ");
		double valorAposta = scanner.nextDouble();
		
		try {
			System.out.println("\n" + MrBet.apostar(idTime, nomeCampeonato, colocao, valorAposta) + "\n");
		} catch (IllegalArgumentException iae) {
			System.out.println("\n" + iae.getMessage() + "\n");
		}
	}
	
	/**
	 * Exibe as apostas feitas pelo usuário.
	 * 
	 * @param MrBet O sistema MrBet sendo manipulado.
	 */
	private static void statusAposta(MrBetSistema MrBet) {
		System.out.println("\nApostas:");
		for (int i = 0; i < MrBet.getApostas().size(); i++) {
			System.out.println("\n" + (i+1) + ". " + MrBet.getApostas().get(i).toString());
		}
		
		System.out.println();
	}
	
	/**
	 * Exibe o histórico do sistema. O histórico lista os times mais frequentes em campeonatos,
	 * times que ainda não participaram de nenhum campeonato e times populares em apostas.
	 * O critério de popularidade é ter apostas de primeiro lugar em campeonatos.
	 */
	private static void exibirHistorico(MrBetSistema MrBet) {
		System.out.println("\nParticipação mais frequente em campeonatos:");
		for (Time time : MrBet.recuperarTimesMaiorParticipacao()) {
			if (time != null) {
				System.out.println(time.toString());
			}
		}
		
		System.out.println("\nAinda não participou de campeonato:");
		for (Time time : MrBet.recuperarTimesSemCampeonatos()) {
			if (time != null) {
				System.out.println(time.toString());
			}
		}
		
		System.out.println("\nPopularidade em apostas:");
		for (Time time : MrBet.recuperarTimesPopulares()) {
			if (time != null) {
				System.out.println(time.getNome() + " / " + time.getPopularidade());
			}
		}
		
		System.out.println();
	}
	
	/**
	 * Sai do MrBet.
	 */
	private static void sair() {
		System.out.println("\nFechando MrBet...");
		System.exit(0);
	}
}
