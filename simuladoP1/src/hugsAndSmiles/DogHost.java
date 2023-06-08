package hugsAndSmiles;

import java.lang.IllegalArgumentException;

public class DogHost {
	private String anfitriao;
	private int qtdeMaximaRacao;
	private int qtdeMaximaCaes;
	private Dog[] caes;
	private int qtdeDiariaRacaoConsumida;
	private int qtdeCaesHospedados;
	private double caixaDiarioHospedagem;
	
	public DogHost(String anfitriao, int qtdeMaximaCaes, int qtdeMaximaRacao) {
		this.anfitriao = anfitriao;
		this.qtdeMaximaCaes = qtdeMaximaCaes;
		this.qtdeMaximaRacao = qtdeMaximaRacao;
		this.caes = new Dog[qtdeMaximaCaes];
	}

	public boolean adicionaCachorro(String nome, String tutor, int qtdeRacao) throws IllegalArgumentException {
		if (qtdeDiariaRacaoConsumida + qtdeRacao > qtdeMaximaRacao) {
			throw new IllegalArgumentException("O ESTOQUE DE RAÇÃO NÃO COMPORTA O CÃO");
		} else if (qtdeCaesHospedados + 1 > qtdeMaximaCaes) {
			throw new IllegalArgumentException("VAGAS ESGOTADAS");
		}
		
		caes[qtdeCaesHospedados] = new Dog(nome, tutor, qtdeRacao);
		
		qtdeDiariaRacaoConsumida += qtdeRacao;
		caixaDiarioHospedagem += caes[qtdeCaesHospedados].getValorDiariaIndividual();
		qtdeCaesHospedados++;
		
		return true;
	}
	
	public boolean adicionaCachorro(String nome, String tutor, int qtdeRacao, String tipoRestricao) {
		if (qtdeDiariaRacaoConsumida + (qtdeRacao * 2) > qtdeMaximaRacao) {
			throw new IllegalArgumentException("O ESTOQUE DE RAÇÃO NÃO COMPORTA O CÃO");
		} else if (qtdeCaesHospedados + 1 > qtdeMaximaCaes) {
			throw new IllegalArgumentException("VAGAS ESGOTADAS");
		}
		
		caes[qtdeCaesHospedados] = new Dog(nome, tutor, qtdeRacao, tipoRestricao);
		
		qtdeDiariaRacaoConsumida += qtdeRacao * 2;
		caixaDiarioHospedagem += caes[qtdeCaesHospedados].getValorDiariaIndividual();
		qtdeCaesHospedados++;
		
		return true;
	}
	
	public String listaDogs() {
		String lista = new String();

		for (Dog cao : caes) {
			if (cao != null) {
				lista += "\n" + cao.toString();
			}
		}
		
		return anfitriao + ":" + lista;
	}
	
	public double consultaValorTotalHospedagem(Dog toto, int dias) throws IllegalArgumentException {
		for (Dog cao : caes) {
			if (cao != null && cao.equals(toto)) {
				return cao.getValorDiariaIndividual() * dias;
			} 
		}
		
		throw new IllegalArgumentException("CÃO NÃO HOSPEDADO NO DOGHOST");
	}
	
	public int consultaQtdeRacaoDiariaConsumida() {
		return qtdeDiariaRacaoConsumida;
	}
	
	public double consultaCaixaDiarioHospedagem() {
		return caixaDiarioHospedagem;
	}
	
	public int consultaQtdeCaesHospedados() {
		return qtdeCaesHospedados;
	}
	
	public int getQtdeMaximaCaes() {
		return qtdeMaximaCaes;
	}
	
	public int getQtdeMaximaRacao() {
		return qtdeMaximaRacao;
	}

	public Dog getDog(int numDog) {
		return caes[numDog-1];
	}
	
}