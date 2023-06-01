package documento;

import java.util.ArrayList;

import elemento.Atalho;
import elemento.Elemento;
import elemento.Lista;
import elemento.Termos;
import elemento.Texto;
import elemento.Titulo;

public class Documento {
	private String tituloDoc;
	private int tamanhoMaximo;
	private ArrayList<Elemento> elementos = new ArrayList<>();
	private boolean isAtalho;
	
	public Documento(String tituloDoc) {
		this.tituloDoc = tituloDoc;
	}
	
	public Documento(String tituloDoc, int tamanhoMaximo) {
		this.tituloDoc = tituloDoc;
		this.tamanhoMaximo = tamanhoMaximo;
	}
	
	public String getTituloDoc() {
		return tituloDoc;
	}
	
	public int getQtdeElementos() {
		return elementos.size();
	}
	
	public ArrayList<Elemento> getElementos() {
		return (ArrayList<Elemento>) elementos.clone();
	}
	
	public int getTamanhoMaximo() {
		return tamanhoMaximo;
	}
	
	public String[] DocumentoToString() {
		ArrayList<String> toString = new ArrayList<>();
		
		for (Elemento elem : elementos) {
			if (elem != null) {
				toString.add(elem.toString());
			}
		}
		
		return toString.toArray(new String[toString.size()]);
	}
	
	public int criarTexto(int prioridade, String valor) {
		Elemento elem = new Texto(prioridade, valor);
		elementos.add(elem);
		
		return elementos.indexOf(elem);
	}

	public int criarTitulo(int prioridade, String valor, int nivel, boolean linkavel) {
		Elemento elem = new Titulo(prioridade, valor, nivel, linkavel);
		elementos.add(elem);
		
		return elementos.indexOf(elem);
	}

	public int criarLista(int prioridade, String valor, String separador, String charLista) {
		Elemento elem = new Lista(prioridade, valor, separador, charLista);
		elementos.add(elem);
		
		return elementos.indexOf(elem);
	}

	public int criarTermos(int prioridade, String valor, String separador, String ordem) {
		Elemento elem = new Termos(prioridade, valor, separador, ordem);
		elementos.add(elem);
		
		return elementos.indexOf(elem);
	}
	
	public String pegarRepresetacaoCompleta(int elementoPosicao) {
		return elementos.get(elementoPosicao).toStringCompleto();
	}

	public String pegarRepresetacaoResumida(int elementoPosicao) {
		return elementos.get(elementoPosicao).toStringResumido();
	}

	public void moverParaCima(String tituloDoc2, int elementoPosicao) {
		if (elementoPosicao > 0) {
			Elemento elemento = elementos.get(elementoPosicao);
	        int index = elementos.indexOf(elemento);

			elementos.remove(elementoPosicao);
			elementos.add(index + 1, elemento);
		}
	}

	public void moverParaBaixo(String tituloDoc2, int elementoPosicao) {
		if (elementoPosicao < getQtdeElementos()) {
			Elemento elemento = elementos.get(elementoPosicao);
	        int index = elementos.indexOf(elemento);

			elementos.remove(elementoPosicao);
			elementos.add(index + 1, elemento);
		}
	}
	
	public int criarAtalho(Documento documento) {
		Elemento elem = new Atalho(documento, documento.getMediaPrioridade());
		elementos.add(elem);
		isAtalho = true;
		
		return elementos.indexOf(elem);
	}

	private int getMediaPrioridade() {
		int media = 0;
		
		for (Elemento elem : elementos) {
			media += elem.getPrioridade();
		}
		
		if (elementos.size() == 0) {
			return 0;
		}
		
		return media / elementos.size();
	}
	
	public boolean isAtalho() {
		return isAtalho;
	}
	
	public boolean temAtalho() {
		for (Elemento elem : elementos) {
			if (elem instanceof Atalho) return true;
		}
		
		return false;
	}
	
}
