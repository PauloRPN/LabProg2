package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mrBet.Aposta;
import mrBet.Campeonato;
import mrBet.Time;

class ApostaTest {
	Aposta aposta;
	
	@BeforeEach
	void setUp() {
		aposta = new Aposta(new Time("10A", "Lotus", "Beija-flor"), new Campeonato("Esperancense", 2), 1, 50.0);
	}

	@Test
	void testaToString() {
		assertEquals("[10A] Lotus / Beija-flor" + "\nEsperancense" + "\n1/2" + "\nR$ 50.0", aposta.toString());
	}
}
