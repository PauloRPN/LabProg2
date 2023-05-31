package Testes;

import agenda.Agenda;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AgendaTest {
	Agenda agenda;
	
	@BeforeEach
	void setUp() {
		agenda = new Agenda();
	}
	
	@Test
	void testCadastraContatoPosicaoVazia() {	
		agenda.cadastraContato(1, "Paulo", "Ricardo", "(83) 1234-5678");
		assertEquals("Paulo Ricardo\n(83) 1234-5678", agenda.getContato(1));
	}
	
	@Test
	void testCadastraContatoPosicaoExistente() {
		agenda.cadastraContato(1, "Paulo", "Ricardo", "(83) 1234-5678");

		agenda.cadastraContato(1, "Cláudio", "Ramon", "(83) 9876-5432");
		
		assertEquals("Cláudio Ramon\n(83) 9876-5432", agenda.getContato(1));
	}
	
	@Test
	void testCadastraContatoNomeSobrenomeJaCadastrados() {
		agenda.cadastraContato(1, "Paulo", "Ricardo", "(83) 1234-5678");
		
		try {
			agenda.cadastraContato(2, "Paulo", "Ricardo", "(83) 1234-5678");
			fail("Deve lançar exceção");
		} catch (IllegalArgumentException iae) {
			assertEquals("CONTATO JÁ CADASTRADO", iae.getMessage());
		}
	}
	
	@Test
	void testCadastraContatoLimite() {
		agenda.cadastraContato(100, "Contato", "Limite", "9999-9999");
		assertEquals("Contato Limite\n9999-9999", agenda.getContato(100));
	}
	
	@Test
	void testCadastraContatoAcimaLimite() {
		try {
			agenda.cadastraContato(101, "Pedro", "Jr", "0000-0000");
			fail("Deve lançar exceção");
		} catch (IllegalArgumentException iae) {
			assertEquals("POSIÇÃO INVÁLIDA", iae.getMessage());
		}
	}
	
	@Test
	void testCadastraContatoAbaixoLimite() {
		try {
			agenda.cadastraContato(0, "Fábio", "Lins", "0000-0000");
			fail("Deve lançar exceção");
		} catch (IllegalArgumentException iae) {
			assertEquals("POSIÇÃO INVÁLIDA", iae.getMessage());
		}
	}
	
	@Test
	void testCadastraContatoTelefoneVazio() {
		try {
			agenda.cadastraContato(5, "João", "Pedro", "");
			fail("Deve lançar exceção");
		} catch (IllegalArgumentException iae) {
			assertEquals("CONTATO INVÁLIDO", iae.getMessage());
		}
	}
	
	@Test
	void testCadastraContatoNomeVazio() {
		try {
			agenda.cadastraContato(2, "", "Jr", "0000-0000");
			fail("Deve lançar exceção");
		} catch (IllegalArgumentException iae) {
			assertEquals("CONTATO INVÁLIDO", iae.getMessage());
		}
	}
	
	@Test
	void testCadastraContatoSobrenomeVazio() {	
		agenda.cadastraContato(1, "Paulo", "", "(83) 1234-5678");
		assertEquals("Paulo\n(83) 1234-5678", agenda.getContato(1));
	}
	
	@Test
	void testGetContatoInexistente() {
		try {
			agenda.getContato(1);
			fail("Deve lançar exceção");
		} catch (IllegalArgumentException iae) {
			assertEquals("CONTATO INEXISTENTE", iae.getMessage());
		}
	}
	
	@Test
	void testAdicionaFavorito() {
		agenda.cadastraContato(20, "Fábio", "Lins", "0000-0000");
		agenda.adicionaFavorito(1, 20);
		
		assertEquals("Fábio", agenda.getFavoritos()[0].getNome());
		assertEquals("Lins", agenda.getFavoritos()[0].getSobrenome());
	}
	
	@Test
	void testAdicionaFavoritoPosicaoExistente() {
		agenda.cadastraContato(20, "Fábio", "Lins", "0000-0000");
		agenda.adicionaFavorito(1, 20);
		
		agenda.cadastraContato(50, "Pedro", "Jr", "0000-0000");
		agenda.adicionaFavorito(1, 50);
		
		assertEquals("Pedro", agenda.getFavoritos()[0].getNome());
		assertEquals("Jr", agenda.getFavoritos()[0].getSobrenome());
	}
	
	@Test
	void testAdicionaFavoritoJaFavoritado() {
		agenda.cadastraContato(20, "Fábio", "Lins", "0000-0000");
		agenda.adicionaFavorito(1, 20);
		
		try {
			agenda.adicionaFavorito(2, 20);
			fail("Deve lançar exceção");
		} catch (IllegalArgumentException iae) {
			assertEquals("CONTATO JÁ FAVORITADO", iae.getMessage());
		}
	}
	
	@Test
	void testAdicionaFavoritoContatoInexistente() {
		try {
			agenda.adicionaFavorito(1, 1);
			fail("Deve lançar exceção");
		} catch (IllegalArgumentException iae) {
			assertEquals("CONTATO INEXISTENTE", iae.getMessage());
		}
	}
	
	@Test
	void testAdicionaFavoritoLimite() {
		agenda.cadastraContato(1, "Paulo", "Ricardo", "(83) 1234-5678");
		agenda.adicionaFavorito(10, 1);
		
		assertEquals("Paulo", agenda.getFavoritos()[9].getNome());
		assertEquals("Ricardo", agenda.getFavoritos()[9].getSobrenome());
	}
	
	@Test
	void testAdicionaFavoritoContatoAcimaLimite() {
		agenda.cadastraContato(1, "Paulo", "Ricardo", "(83) 1234-5678");
		
		try {
			agenda.adicionaFavorito(11, 1);
			fail("Deve lançar exceção");
		} catch (IllegalArgumentException iae) {
			assertEquals("POSIÇÃO INVÁLIDA", iae.getMessage());
		}
	}
	
	@Test
	void testAdicionaFavoritoContatoAbaixoLimite() {
		agenda.cadastraContato(1, "Paulo", "Ricardo", "(83) 1234-5678");
		
		try {
			agenda.adicionaFavorito(0, 1);
			fail("Deve lançar exceção");
		} catch (IllegalArgumentException iae) {
			assertEquals("POSIÇÃO INVÁLIDA", iae.getMessage());
		}
	}
	
	@Test
	void testGetContatoFavoritado() {
		agenda.cadastraContato(1, "Paulo", "Ricardo", "(83) 1234-5678");
		agenda.adicionaFavorito(1, 1);
		
		assertEquals("❤️ Paulo Ricardo\n(83) 1234-5678", agenda.getContato(1));
	}
	
	@Test
	void testRemoveFavorito() {
		agenda.cadastraContato(1, "Paulo", "Ricardo", "(83) 1234-5678");
		agenda.adicionaFavorito(1, 1);
		
		agenda.removeFavorito(1);
		
		assertEquals(null, agenda.getFavoritos()[0]);
	}
	
	@Test
	void testGetContatoDesfavoritado() {
		agenda.cadastraContato(1, "Paulo", "Ricardo", "(83) 1234-5678");
		agenda.adicionaFavorito(1, 1);
		agenda.removeFavorito(1);
		
		assertNotEquals("❤️ Paulo Ricardo\n(83) 1234-5678", agenda.getContato(1));
	}
	
	void testRemoveFavoritoNaoFavoritado() {
		try {
			agenda.removeFavorito(1);
			fail("Deve lançar exceção");
		} catch (IllegalArgumentException iae) {
			assertEquals("POSIÇÃO INEXISTENTE NA LISTA DE FAVORITOS", iae.getMessage());
		}
	}

}
