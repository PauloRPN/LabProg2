package Testes;

import hugsAndSmiles.DogHost;
import hugsAndSmiles.Dog;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DogHostTest {
	DogHost dh1;
	
	@BeforeEach
	void setUp() {
		dh1 = new DogHost("Olívia", 3, 500);
		dh1.adicionaCachorro("Julie", "André", 100);
		dh1.adicionaCachorro("Toto", "Maty", 100);
	}

	@Test
	void testConsultaValorHospedagemTeseA() {
		Dog d1 = new Dog("Julie", "André", 100);
		Double valor = dh1.consultaValorTotalHospedagem(d1, 3);
		
		assertEquals(120.0, valor);
	}
	
	@Test
	void testConsultaValorHospedagemTeseB() {
		Double valor = dh1.consultaValorTotalHospedagem(dh1.getDog(2), 0);
		
		assertEquals(0.0, valor);
	}
	
	@Test
	void testConsultaValorHospedagemTeseC() {
		Dog d1 = new Dog("Neca", "André", 100);
		
		try {
			dh1.consultaValorTotalHospedagem(d1, 3);
			fail("DEVERIA LANÇAR EXCEÇÃO");
		} catch (IllegalArgumentException iae) {
			assertEquals("CÃO NÃO HOSPEDADO NO DOGHOST", iae.getMessage());
		}
	}
	
	@Test
	void testConsultaCaixaDiarioHospedagem() {
		Double valor = dh1.consultaCaixaDiarioHospedagem();
		assertEquals(80.0, valor);
	}
	
	@Test
	void testListaDogs() {
		dh1.adicionaCachorro("Soneca", "Ana", 100);
		
		assertEquals("Olívia:"
				+ "\nDog [nome=Julie, tutor=André]"
				+ "\nDog [nome=Toto, tutor=Maty]"
				+ "\nDog [nome=Soneca, tutor=Ana]", dh1.listaDogs());
	}
	
	@Test
	void testAdicionaCachorroAcimaLimiteQtdeRacao() {
		try {
			dh1.adicionaCachorro("Soneca", "Ana", 200, "Alérgico");
			fail("DEVERIA LANÇAR EXCEÇÃO");
		} catch (IllegalArgumentException iae) {
			assertEquals("O ESTOQUE DE RAÇÃO NÃO COMPORTA O CÃO", iae.getMessage());
		}
	}
	
	@Test
	void testAdicionaCachorroAcimaLimiteQtdeCaes() {
		dh1.adicionaCachorro("Bile", "Marcos", 100);
		
		try {
			dh1.adicionaCachorro("Spyke", "Paulo", 100);
			fail("DEVERIA LANÇAR EXCEÇÃO");
		} catch (IllegalArgumentException iae) {
			assertEquals("VAGAS ESGOTADAS", iae.getMessage());
		}
	}

}
