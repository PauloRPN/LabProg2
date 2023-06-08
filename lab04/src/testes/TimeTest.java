package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mrBet.Campeonato;
import mrBet.Time;

class TimeTest {
	Time time;
	
	@BeforeEach
	void setUp() {
		time = new Time("10A", "Lotus", "Beija-flor");
	}
	
	@Test
	void testaGuardarCampeonato() {
		time.guardarCampeonato(new Campeonato("Esperancense", 2));
		assertEquals(1, time.getQtdeCampeonatos());
	}
	
	@Test
	void testaToString() {
		assertEquals("[10A] Lotus / Beija-flor", time.toString());
	}
	
	@Test
	void testaEquals() {
		assert time.equals(new Time("10A", "Whales", "Baleia"));
	}
}
