package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mrBet.Campeonato;
import mrBet.Time;

class CampeonatoTest {
	Campeonato campeonato;
	
	@BeforeEach
	void setUp() {
		campeonato = new Campeonato("Copa", 20);
	}
	
	@Test
	void testaGetQtdeTimesInclusos() {
		campeonato.incluirTime(new Time("250_PB", "América", "Gaivota"));
		campeonato.incluirTime(new Time("252_PB", "América de Timbaúba", "Camaleão"));
		
		assertEquals(2, campeonato.getQtdeTimesInclusos());
	}
	
	@Test
	void testaGetTimeNaoIncluso() {
		try {
			campeonato.getTimeIncluso("001B");
			fail("Deveria lançar exceção!");
		} catch (NoSuchElementException nsee) {
			assertEquals("O TIME NÃO ESTÁ NO CAMPEONATO!", nsee.getMessage());
		}
	}
	
	@Test
	void testaSeCampeonatoEstaCheio() {
		Campeonato racha = new Campeonato("Racha", 2);
		racha.incluirTime(new Time("250_PB", "América", "Gaivota"));
		racha.incluirTime(new Time("252_PB", "América de Timbaúba", "Camaleão"));
		
		assert racha.isFull();
	}
	
	@Test
	void testaContemTime() {
		campeonato.incluirTime(new Time("250_PB", "América", "Gaivota"));
		assert campeonato.contemTime("250_PB");
		assert !campeonato.contemTime("001A");
	}
	
	@Test
	void testaEquals() {
		Campeonato campeonato2 = new Campeonato("Copa", 40);
		assert campeonato.equals(campeonato2);
		
		Campeonato campeonato3 = new Campeonato("Libertadores", 40);
		assert !campeonato2.equals(campeonato3);
	}
	
	@Test
	void testaToString() {
		assertEquals("* Copa - 0/20", campeonato.toString());
	}

}
