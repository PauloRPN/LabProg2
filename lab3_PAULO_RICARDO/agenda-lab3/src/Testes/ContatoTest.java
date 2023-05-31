package Testes;

import agenda.Contato;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContatoTest {
	private Contato contato;
	
	@BeforeEach
	void setUp() {
		contato = new Contato("Paulo", "Ricardo", "9999-0000");
	}

	@Test
	void testEquals() {
		assert contato.equals("paulo", "Ricardo");
	}

	@Test
	void testToString() {
		assertEquals("Paulo Ricardo\n9999-0000", contato.toString());
	}
	
	@Test
	void testToStringContatoFavoritado() {
		contato.setFavorito(true);
		
		assertEquals("❤️ Paulo Ricardo\n9999-0000", contato.toString());
	}
}
