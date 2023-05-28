package documin;

import controladores.DocumentoController;
import controladores.ElementoController;

public class Facade {
	private DocumentoController documentoController;
	private ElementoController elementoController;
	
	public Facade() {
		this.documentoController = new DocumentoController();
		this.elementoController = new ElementoController(documentoController);
	}
	
	public boolean criarDocumento(String tituloDoc) {
		return this.documentoController.criaDocumento(tituloDoc);
	}
	
	public boolean criarDocumento(String tituloDoc, int tamanhoMaximo) {
		return this.documentoController.criaDocumento(tituloDoc, tamanhoMaximo);
	}
	
	public void removerDocumento(String tituloDoc) {
		this.documentoController.removerDocumento(tituloDoc);
	}
	
	public int contarElementos(String tituloDoc) {
		return this.documentoController.contarElementos(tituloDoc);
	}
	
	public String[] exibirDocumento(String tituloDoc) {
		return this.documentoController.exibirDocumento(tituloDoc);
	}
	
	public int criarTexto(String tituloDoc, int prioridade, String valor) {
		return this.elementoController.criarTexto(tituloDoc, prioridade, valor);
	}
	
	public int criarTitulo(String tituloDoc, int prioridade, String valor, int nivel, boolean linkavel) {
		return this.elementoController.criarTitulo(tituloDoc, prioridade, valor, nivel, linkavel);
	}
	
	public int criarLista(String tituloDoc, int prioridade, String valor, String separador, String charLista) {
		return this.elementoController.criarLista(tituloDoc, prioridade, valor, separador, charLista);
	}
	
	public int criarTermos(String tituloDoc, int prioridade, String valor, String separador, String ordem) {
		return this.elementoController.criarTermos(tituloDoc, prioridade, valor, separador, ordem);
	}
	
	public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		return this.elementoController.pegarRepresentacaoCompleta(tituloDoc, elementoPosicao);
	}
	
	public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
		return this.elementoController.pegarRepresentacaoResumida(tituloDoc, elementoPosicao);
	}
	
	public void moverParaCima(String tituloDoc, int elementoPosicao) {
		this.elementoController.moverParaCima(tituloDoc, elementoPosicao);
	}
	
	public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
		this.elementoController.moverParaBaixo(tituloDoc, elementoPosicao);
	}
	
	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
		return this.elementoController.criarAtalho(tituloDoc, tituloDocReferenciado);
	}
	
	public int criarVisaoCompleta(String tituloDoc) {
		return 1;
	}
	
	public int criarVisaoResumida(String tituloDoc) {
		return 1;
	}
	
	public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
		return 1;
	}
	
	public int criarVisaoTitulo(String tituloDoc) {
		return 1;
	}
	
	public int exibirVisao(int visaoId) {
		return 1;
	}

}
