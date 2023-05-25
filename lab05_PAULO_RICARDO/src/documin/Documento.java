package documin;

import java.util.ArrayList;

public class Documento {
	private String tituloDoc = new String();
	private int tamanhoMaximo;
	private ArrayList<Elemento> elementos = new ArrayList<>();
	
	public Documento(String tituloDoc) {
		this.tituloDoc = tituloDoc;
	}
	
	public Documento(String tituloDoc, int tamanhoMaximo) {
		this.tituloDoc = tituloDoc;
		this.tamanhoMaximo = tamanhoMaximo;
	}
	
	public int getQtdeElementos() {
		return elementos.size();
	}
	
	public String[] toString() {
		ArrayList<String> toString = new ArrayList<>();
		
		for (Elemento elem : elementos) {
			if (elem != null) {
				toString.add(elem.toString());
			}
		}
		
		return (String[]) toString.toArray();
	}
}
