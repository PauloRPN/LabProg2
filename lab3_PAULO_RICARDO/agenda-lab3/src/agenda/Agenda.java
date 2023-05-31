package agenda;

import java.lang.IllegalArgumentException;
/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 *
 * @author paulo.ricardo.pereira.nascimento
 *
 */
public class Agenda {

	private static final int TAMANHO_AGENDA = 100;

	private Contato[] contatos;
	private Contato[] favoritos;
	
	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[10];
	}
	
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}
	
	/**
	 * Acessa a lista de favoritos mantida.
	 * @return O array de contatos favoritados.
	 */
	public Contato[] getFavoritos() {
		return this.favoritos.clone();
	}
	
	
	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 * @throws IllegalArgumentException para posições inexistentes na lista de contatos.
	 */
	public String getContato(int posicao) throws IllegalArgumentException {
		if (contatos[posicao-1] == null) {
			throw new IllegalArgumentException("CONTATO INEXISTENTE");
		}
		
		return contatos[posicao-1].toString();
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior.
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 * @throws IllegalArgumentException para posições inválidas, contatos considerados inválidos e para
	 *contatos já cadastrados.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) throws IllegalArgumentException {
		if (posicao < 1 || posicao > TAMANHO_AGENDA) {
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}

		if (nome.isBlank() || telefone.isBlank()
				|| nome == null || telefone == null) {
			throw new IllegalArgumentException("CONTATO INVÁLIDO");
		}
		
		for (Contato contato : getContatos()) {
			if (contato != null && contato.equals(nome, sobrenome)){
				throw new IllegalArgumentException("CONTATO JÁ CADASTRADO");
			}
		}

		contatos[posicao-1] = new Contato(nome, sobrenome, telefone);
	}
	
	
	/**
	 * Adiciona um contato em uma posição da lista de favoritos. Uma adição em uma posição que já existe sobrescreve a anterior.
	 * @param posicao Posição na qual deseja posicionar o contato na lista de favoritos
	 * @param posicaoContato Posição do contato na lista de contatos 
	 * @throws IllegalArgumentException para posições inválidas, tentativa de favoritar contatos
	 *inexistentes e tentativa de favoritar contatos já favoritados.
	 */
	public void adicionaFavorito(int posicao, int posicaoContato) throws IllegalArgumentException {
		if (posicao < 1 || posicao > favoritos.length) {
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		
		if (contatos[posicaoContato-1] == null) {
			throw new IllegalArgumentException("CONTATO INEXISTENTE");
		}
		
		if (contatos[posicaoContato-1].getFavoritado()){
			throw new IllegalArgumentException("CONTATO JÁ FAVORITADO");
		}
		
		favoritos[posicao-1] = contatos[posicaoContato-1];
		contatos[posicaoContato-1].setFavorito(true);
	}
	
	
	/**
	 * Remove um contato de uma posição da lista de favoritos.
	 * 
	 * @param posicao Posição da lista de favoritos da qual deseja-se remover o cantato.
	 * @throws IllegalArgumentException para posições inválidas e para a tentativa de remover
	 *um contato de uma posição não ocupada.
	 */
	public void removeFavorito(int posicao) throws IllegalArgumentException {
		if (posicao < 1 || posicao > favoritos.length) {
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		} else if (favoritos[posicao-1] == null) {
			throw new IllegalArgumentException("POSIÇÃO INEXISTENTE NA LISTA DE FAVORITOS");
		}
		
		favoritos[posicao-1].setFavorito(false);
		favoritos[posicao-1] = null;
	}

}