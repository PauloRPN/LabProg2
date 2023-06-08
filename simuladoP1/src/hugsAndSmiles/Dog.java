package hugsAndSmiles;

import java.util.Objects;

public class Dog {
	private String nome;
	private String tutor;
	private int qtdeRacao;
	private String tipoRestricao;
	private double valorDiariaIndividual;
	
	public Dog() {}
	
	public Dog(String nome, String tutor, int qtdeRacao) {
		this.nome = nome;
		this.tutor = tutor;
		this.qtdeRacao = qtdeRacao;
		this.valorDiariaIndividual = qtdeRacao * 0.4;
	}

	public Dog(String nome, String tutor, int qtdeRacao, String tipoRestricao) {
		this.nome = nome;
		this.tutor = tutor;
		this.qtdeRacao = qtdeRacao * 2;
		this.tipoRestricao = tipoRestricao;
		this.valorDiariaIndividual = this.qtdeRacao * 0.4;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getTutor() {
		return tutor;
	}
	
	public double getValorDiariaIndividual() {
		return valorDiariaIndividual; 
	}
	
	public boolean temRestricao() {
		if (tipoRestricao != null) {
			return true;
		}
		
		return false;
	}
	
	public String getTipoRestricao() {
		return tipoRestricao;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome, tutor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(tutor, other.tutor);
	}

	@Override
	public String toString() {
		return "Dog [nome=" + nome + ", tutor=" + tutor + "]";
	}
	
}
