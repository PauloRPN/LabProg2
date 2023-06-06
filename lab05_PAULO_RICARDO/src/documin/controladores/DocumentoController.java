package documin.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import documin.documento.Documento;
import documin.validator.DocuminValidator;
import documin.visao.*;

/**
 * Classe responsável pela crianção e manipulação de documentos.
 * 
 * @author paulo.ricardo.pereira.nascimento
 */
public class DocumentoController {
	private Map<String, Documento> documentos;
	private List<String []> visoes;  
	
	/**
	 * Cria um controlador de documentos.
	 */
	public DocumentoController() {
		this.documentos = new HashMap<>();
		this.visoes = new ArrayList<>();
	}
	
	/**
	 * Cria um documento sem definir um tamanho máximo.
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 * @return True se o documento for criado e false se ele já existir.
	 * @throws IllegalArgumentException Lança exceção para título vazio ou composto apenas de espaços. 
	 */
	public boolean criaDocumento(String tituloDoc) {
		DocuminValidator.validaTitulo(tituloDoc);
		
		if (documentos.containsKey(tituloDoc)) return false;
		
		documentos.put(tituloDoc, new Documento(tituloDoc));
		return true;
	}
	
	/**
	 * Cria um documento com tamanho máximo. 
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 * @param tamanhoMaximo Quantidade máximo de elementos que o documento pode ter.
	 * @return True se o documento for criado e false se ele já existir.
	 * @throws IllegalArgumentException Lança exceção para título vazio ou composto apenas de espaços.
	 * @throws IllegalArgumentException Lança exceção para tamanho menor ou igual a zero.
	 */
	public boolean criaDocumento(String tituloDoc, int tamanhoMaximo) {
		DocuminValidator.validaTitulo(tituloDoc);
		DocuminValidator.validaTamanhoMaximo(tamanhoMaximo);
		
		if (documentos.containsKey(tituloDoc)) return false;
		
		documentos.put(tituloDoc, new Documento(tituloDoc, tamanhoMaximo));
		return true;
	}
	
	/**
	 * Remove um documento do sistema.
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 */
	public void removerDocumento(String tituloDoc) {
		DocuminValidator.validaExistencia(documentos.containsKey(tituloDoc));
		documentos.remove(tituloDoc);
	}
	
	/**
	 * Recupera um array de Strings da representação resumida de cada elemento de um documento.
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 * @return Array de Strings das representações resumidas do documento. 
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 */
	public String[] exibirDocumento(String tituloDoc) {
		DocuminValidator.validaExistencia(documentos.containsKey(tituloDoc));
		return documentos.get(tituloDoc).exibeDocumento();
	}
	
	/**
	 * Recupera um documento.
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 * @return Documento desejado.
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 */
	protected Documento getDocumento(String tituloDoc) {
		DocuminValidator.validaExistencia(documentos.containsKey(tituloDoc));
		return documentos.get(tituloDoc);
	}
	
	/**
	 * Cria um objeto Visao a partir de um documento. Este método é útil para a redução
	 * e otimização de outros métodos ligados à criação de visões.
	 * 
	 * @param tituloDoc Titulo que identifica o documento.
	 * @return A Visao criada.
	 */
	private Visao Visao(String tituloDoc) {
		Visao visao = new Visao(documentos.get(tituloDoc));
		return visao;
	}
	
	/**
	 * Cria uma visão completa de um documento.
	 * 
	 * @param tituloDoc Título que idenfitica o documento.
	 * @return A posição da visão no obejto que armazena visões.
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 */
	public int criarVisaoCompleta(String tituloDoc) {
		DocuminValidator.validaExistencia(documentos.containsKey(tituloDoc));
		String[] visao = Visao(tituloDoc).visaoCompleta();
		visoes.add(visao);
		
		return visoes.indexOf(visao);
	}
	
	/**
	 * Cria uma visão resumida de um documento.
	 * 
	 * @param tituloDoc Título que idenfitica o documento.
	 * @return A posição da visão no obejto que armazena visões.
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 */
	public int criarVisaoResumida(String tituloDoc) {
		DocuminValidator.validaExistencia(documentos.containsKey(tituloDoc));
		String[] visao = Visao(tituloDoc).visaoResumida();
		visoes.add(visao);
		
		return visoes.indexOf(visao);
	}
	
	/**
	 * Cria uam visão prioritária de um documento.
	 * 
	 * @param tituloDoc Título que identifica o documento.
	 * @param prioridade Prioridade base para a criação da visão.
	 * @return A posição da visão o objeto que armazena visões.
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 * @throws IllegalArgumentException Lança exceção para prioridade menor que 1 ou maior que 5.
	 */
	public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
		DocuminValidator.validaExistencia(documentos.containsKey(tituloDoc));
		DocuminValidator.validaPrioridade(prioridade);
		String[] visao = Visao(tituloDoc).visaoPrioritaria(prioridade);
		visoes.add(visao);
		
		return visoes.indexOf(visao);
	}
	
	/**
	 * Cria uma visão dos elementos do tipo Título contido em um documento.
	 * 
	 * @param tituloDoc Título que idenfitica o documento.
	 * @return A posição da visão no obejto que armazena visões.
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 */
	public int criarVisaoTitulo(String tituloDoc) {
		DocuminValidator.validaExistencia(documentos.containsKey(tituloDoc));
		String[] visao = Visao(tituloDoc).visaoTitulo();
		visoes.add(visao);
		
		return visoes.indexOf(visao);
	}
	
	/**
	 * Exibe uma visão desejada.
	 * 
	 * @param visaoId Posição da visão.
	 * @return Array de Strings da visão desejada.
	 * @throws NoSuchElementException Lança exceção caso o documento não exista.
	 * @throws IndexOutOfBoundsException Lança exceção se o ID for menor que 0 ou maior que a quantidade de visões no sistema.
	 */
	public String[] exibirVisao(int visaoId) {
		DocuminValidator.validaVisaoId(visaoId, visoes.size());
		return visoes.get(visaoId);
	}

}
