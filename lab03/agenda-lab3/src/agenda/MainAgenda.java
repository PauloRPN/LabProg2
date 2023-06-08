package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.print(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" +
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(R)emover Favorito\n" + 
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			listaFavoritos(agenda);
			break;
		case "A":
			adicionaFavorito(agenda, scanner);
			break;
		case "R":
			removeFavorito(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}

	/**
	 * Adiciona um contato à lista de favoritos.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 * @param scanner Scanner para capturar qual contato deseja-se favoritar e em qual posição da lista de favoritos.
	 */
	private static void adicionaFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int posicaoContato = scanner.nextInt();
		System.out.print("\nPosicao> ");
		int posicao = scanner.nextInt();
		
		try {
			agenda.adicionaFavorito(posicao, posicaoContato);
			System.out.println("CONTATO FAVORITADO NA POSIÇÃO " + posicao + "!");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	/**
	 * Remove um contato da lista de favoritos.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 * @param scanner Scanner para captura qual posição deseja-se remover da lista de favoritos.
	 */
	private static void removeFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosicao> ");
		int posicao = scanner.nextInt();
		
		try {
			agenda.removeFavorito(posicao);
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
	/**
	 * Imprime lista de favoritos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaFavoritos(Agenda agenda) {
		Contato[] favoritos = agenda.getFavoritos();
		for (int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null) {
				System.out.println(formataContato(i, favoritos[i]));
			}
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i, contatos[i]));
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("Qual contato> ");
		int posicao = scanner.nextInt();
		
		try {
			String contato = agenda.getContato(posicao);
			System.out.println(contato);
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}

	/**
	 * Formata um contato para impressão na interface. 
	 * 
	 * @param posicao A posição do contato (que é exibida)/
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, Contato contato) {
		if (contato.getSobrenome() == null || contato.getSobrenome().isBlank()) {
			return (posicao + 1) + " - " + contato.getNome();
		}
		
		return (posicao + 1) + " - " + contato.getNome() + " " + contato.getSobrenome();
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		System.out.print("\nNome> ");
		String nome = scanner.next();
		System.out.print("\nSobrenome> ");
		String sobrenome = scanner.next();
		System.out.print("\nTelefone> ");
		String telefone = scanner.next();

		try {
			agenda.cadastraContato(posicao, nome, sobrenome, telefone);
			System.out.println("CADASTRO REALIZADO");
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("Fechando agenda...");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
