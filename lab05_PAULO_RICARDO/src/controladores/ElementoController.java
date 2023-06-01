package controladores;

import documento.Documento;
import validator.DocuminValidator;

public class ElementoController {
	private DocumentoController documentoController;
	
	public ElementoController(DocumentoController documentoController) {
		this.documentoController = documentoController;
	}
	
	private Documento documento(String tituloDoc) {
		return documentoController.getDocumento(tituloDoc);
	}
	
	public int criarTexto(String tituloDoc, int prioridade, String valor) {
		DocuminValidator.validaLimiteArray(documento(tituloDoc));
		DocuminValidator.validaPrioridade(prioridade);
		return documento(tituloDoc).criarTexto(prioridade, valor);
	}

	public int criarTitulo(String tituloDoc, int prioridade, String valor, int nivel, boolean linkavel) {
		DocuminValidator.validaLimiteArray(documento(tituloDoc));
		DocuminValidator.validaPrioridade(prioridade);
		return documento(tituloDoc).criarTitulo(prioridade, valor, nivel, linkavel);
	}

	public int criarLista(String tituloDoc, int prioridade, String valor, String separador, String charLista) {
		DocuminValidator.validaLimiteArray(documento(tituloDoc));
		DocuminValidator.validaPrioridade(prioridade);
		return documento(tituloDoc).criarLista(prioridade, valor, separador, charLista);
	}

	public int criarTermos(String tituloDoc, int prioridade, String valor, String separador, String ordem) {
		DocuminValidator.validaLimiteArray(documento(tituloDoc));
		DocuminValidator.validaPrioridade(prioridade);
		return documento(tituloDoc).criarTermos(prioridade, valor, separador, ordem);
	}
	
	public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		DocuminValidator.validaPosicao(elementoPosicao, documento(tituloDoc));
		return documento(tituloDoc).pegarRepresetacaoCompleta(elementoPosicao);
	}
	
	public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
		DocuminValidator.validaPosicao(elementoPosicao, documento(tituloDoc));
		return documento(tituloDoc).pegarRepresetacaoResumida(elementoPosicao);
	}
	
	public void moverParaCima(String tituloDoc, int elementoPosicao) {
		DocuminValidator.validaPosicao(elementoPosicao, documento(tituloDoc));
		documento(tituloDoc).moverParaCima(elementoPosicao);
	}

	public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
		DocuminValidator.validaPosicao(elementoPosicao, documento(tituloDoc));
		documento(tituloDoc).moverParaBaixo(elementoPosicao);
	} 
	
	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
		DocuminValidator.validaLimiteArray(documento(tituloDoc));
		DocuminValidator.validaLimiteArray(documento(tituloDocReferenciado));
		DocuminValidator.validaAtalho(documento(tituloDoc), documento(tituloDocReferenciado));
		
		return documento(tituloDoc).criarAtalho(documento(tituloDocReferenciado));
	}

}
