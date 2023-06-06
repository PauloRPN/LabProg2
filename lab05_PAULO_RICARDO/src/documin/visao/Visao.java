package documin.visao;

import documin.documento.Documento;
import documin.elemento.Elemento;
import documin.elemento.Titulo;

import java.util.ArrayList;

/**
 * Visão de um documento. Existem 4 tipos de visão: completa, resumida, prioritária e título.
 * 
 * @author paulo.ricardo.pereira.nascimento
 */
public class Visao {
	private Documento documento;
	
	/**
	 * Cria uma visão.
	 * 
	 * @param documento Documento do qual deseja-se criar uma visão.
	 */
	public Visao(Documento documento) {
		this.documento = documento;
	}
	
	/**
	 * Cria uma visão com as representações completas de todos os elementos do documento.
	 * 
	 * @return Representação completa do documento em forma array de Strings.
	 */
	public String[] visaoCompleta() {
		ArrayList<String> toString = new ArrayList<>();
		
		for (Elemento elem : documento.getElementos()) {
			if (elem != null) {
				toString.add(elem.toStringCompleto());
			}
		}
		
		return toString.toArray(new String[toString.size()]);
	}
	
	/**
	 * Cria uma visão com as representações resumidas de todos os elementos do documento.
	 * 
	 * @return Representação resumida do documento em forma array de Strings.
	 */
	public String[] visaoResumida() {
		ArrayList<String> toString = new ArrayList<>();
		
		for (Elemento elem : documento.getElementos()) {
			if (elem != null) {
				toString.add(elem.toStringResumido());
			}
		}
		
		return toString.toArray(new String[toString.size()]);
	}
	
	/**
	 * Cria uma visão com as representações resumidas de todos os elementos do documento com prioridadades maiores ou iguais à desejada.
	 * 
	 * @return Representação prioritária do documento em forma array de Strings.
	 */
	public String[] visaoPrioritaria(int prioridade) {
		ArrayList<String> toString = new ArrayList<>();
		
		for (Elemento elem : documento.getElementos()) {
			if (elem != null && elem.getPrioridade() >= prioridade) {
				toString.add(elem.toStringResumido());
			}
		}
		
		return toString.toArray(new String[toString.size()]);
	}
	
	/**
	 * Cria uma visão com as representações resumidas de todos os elementos do tipo Título do documento.
	 * 
	 * @return Representação dos Títulos do documento em forma array de Strings.
	 */
	public String[] visaoTitulo() {
		ArrayList<String> toString = new ArrayList<>();
		
		for (Elemento elem : documento.getElementos()) {
			if (elem != null && elem instanceof Titulo) {
				toString.add(elem.toStringResumido());
			}
		}
		
		return toString.toArray(new String[toString.size()]);
	}

}
