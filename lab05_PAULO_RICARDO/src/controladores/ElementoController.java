package controladores;

import Repository.DocumentoRepository;
import documento.Documento;
import elemento.Atalho;

public class ElementoController {
	private DocumentoRepository documentoRepository;
	
	public ElementoController(DocumentoRepository documentoRepository) {
		this.documentoRepository = documentoRepository;
	}
	
	private Documento documento(String tituloDoc) {
		return documentoRepository.get(tituloDoc);
	}
	
	public int criarTexto(String tituloDoc, int prioridade, String valor) {
		Documento documento = documento(tituloDoc);
		verificaArrayOutofBoundsException(tituloDoc);
		verificaIllegalArgumentException(prioridade, 1);
		return documento.criarTexto(prioridade, valor);
	}

	public int criarTitulo(String tituloDoc, int prioridade, String valor, int nivel, boolean linkavel) {
		Documento documento = documento(tituloDoc);
		verificaArrayOutofBoundsException(tituloDoc);
		verificaIllegalArgumentException(prioridade, nivel);
		return documento.criarTitulo(prioridade, valor, nivel, linkavel);
	}

	public int criarLista(String tituloDoc, int prioridade, String valor, String separador, String charLista) {
		Documento documento = documento(tituloDoc);
		verificaArrayOutofBoundsException(tituloDoc);
		verificaIllegalArgumentException(prioridade, 1);
		return documento.criarLista(prioridade, valor, separador, charLista);
	}

	public int criarTermos(String tituloDoc, int prioridade, String valor, String separador, String ordem) {
		Documento documento = documento(tituloDoc);
		verificaArrayOutofBoundsException(tituloDoc);
		verificaIllegalArgumentException(prioridade, 1);
		return documento.criarTermos(prioridade, valor, separador, ordem);
	}
	
	public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		Documento documento = documento(tituloDoc);
		verificaArrayIndexOutOfBoundsException(tituloDoc, elementoPosicao);
		return documento.pegarRepresetacaoCompleta(elementoPosicao);
	}
	
	public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
		Documento documento = documento(tituloDoc);
		verificaArrayOutofBoundsException(tituloDoc);
		return documento.pegarRepresetacaoResumida(elementoPosicao);
	}
	
	public void moverParaCima(String tituloDoc, int elementoPosicao) {
		Documento documento = documento(tituloDoc);
		verificaArrayIndexOutOfBoundsException(tituloDoc, elementoPosicao);
		documento.moverParaCima(tituloDoc, elementoPosicao);
	}

	public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
		Documento documento = documento(tituloDoc);
		verificaArrayIndexOutOfBoundsException(tituloDoc, elementoPosicao);
		documento.moverParaBaixo(tituloDoc, elementoPosicao);
	} 
	
	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
		Documento documento = documento(tituloDoc);
		verificaArrayOutofBoundsException(tituloDoc);
		verificaArrayOutofBoundsException(tituloDocReferenciado);
		
		return documento.criarAtalho(documento(tituloDocReferenciado));
	}
	
	
	// Métodos que verificam exceções
	
	private void verificaArrayOutofBoundsException(String tituloDoc) {
		if (documento(tituloDoc).getTamanhoMaximo() != 0
				&& documento(tituloDoc).getQtdeElementos() == documento(tituloDoc).getTamanhoMaximo()) {
			throw new ArrayIndexOutOfBoundsException("O DOCUMENTO ATINGIU SEU LIMITE!");
		}
	}
	
	private void verificaIllegalArgumentException(int prioridade, int nivel) {
		if (prioridade < 1 || prioridade > 5) {
			throw new IllegalArgumentException("PRIORIDADE INVÁLIDA!");
		} else if (prioridade < 1 || prioridade > 5) {
			throw new IllegalArgumentException("NÍVEL INVÁLIDO!");
		} 
	}
	
	private void verificaArrayIndexOutOfBoundsException(String tituloDoc, int elementoPosicao) {
		if (elementoPosicao > documento(tituloDoc).getQtdeElementos()
				|| elementoPosicao < 0) {
			throw new ArrayIndexOutOfBoundsException("POSIÇÃO INVÁLIDA OU INEXISTENTE NO DOCUMENTO!");
		}
	}

}
