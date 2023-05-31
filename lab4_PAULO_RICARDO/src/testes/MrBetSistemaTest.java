package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mrBet.MrBetSistema;

class MrBetSistemaTest {
	MrBetSistema MrBet;
	
	@BeforeEach
	void setUp() {
		MrBet = new MrBetSistema();
		
		MrBet.incluirTime("250_PB", "Nacional de Patos", "Canário");
		MrBet.incluirTime("252_PB", "Sport Lagoa Seca", "Carneiro");
		MrBet.incluirTime("002_RJ", "Clube de Regatas do Flamengo", "Urubu");
		MrBet.incluirTime("105_PB", "Sociedade Recreativa de Monteiro (SOCREMO)", "Gavião");
	}

	@Test
	void testaCadastrarCampeonato() {
		String retorno = MrBet.adicionarCampeonato("Brasileirão série A 2023", 4);
		assertEquals("CAMPEONATO ADICIONADO!", retorno);
	}
	
	@Test
	void testaCadastrarCampeonatoExistente() {
		MrBet.adicionarCampeonato("Brasileirão série A 2023", 4);
		
		try {
			MrBet.adicionarCampeonato("Brasileirão série A 2023", 2);
		} catch (IllegalArgumentException iae) {
			assertEquals("O CAMPEONATO JÁ EXISTE!", iae.getMessage());
		}
	}
	
	@Test
	void testaIncluirTimeCampeonato() {
		MrBet.adicionarCampeonato("Brasileirão série A 2023", 4);
		
		String retorno1 = MrBet.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023");
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", retorno1);
		
		String retorno2 = MrBet.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023");
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", retorno2);
	}
	
	@Test
	void testaIncluirTimeJaInclusoEmCampeonato() {
		MrBet.adicionarCampeonato("Brasileirão série A 2023", 4);
		MrBet.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023");
		MrBet.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023");
		
		String retorno1 = MrBet.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023");
		assertEquals("TIME INCLUÍDO NO CAMPEONATO!", retorno1);
		
		int retorno2 = MrBet.getCampeonatos().get("Brasileirão série A 2023").getQtdeTimesInclusos();
		assertEquals(2, retorno2);
	}
	
	@Test
	void testaIncluirTimeNaoCadastradoEmCampeonato() {
		MrBet.adicionarCampeonato("Brasileirão série A 2023", 4);
		
		try {
			MrBet.incluirTimeCampeonato("005_PB", "Brasileirão série A 2023");
			fail("Deveria lançar exceção!");
		} catch (Exception e) {
			assertEquals("O TIME NÃO EXISTE!", e.getMessage());
		}
	}
	
	@Test
	void testaIncluirTimeEmCampeonatoNaoCadastrado() {
		try {
			MrBet.incluirTimeCampeonato("250_PB", "Campeonato Paraibano");
			fail("Deveria lançar exceção!");
		} catch (Exception e) {
			assertEquals("O CAMPEONATO NÃO EXISTE!", e.getMessage());
		}
	}
	
	@Test
	void testaIncluirTimeCampeonatoCheio() {
		MrBet.adicionarCampeonato("Brasileirão série A 2023", 2);
		MrBet.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023");
		MrBet.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023");
		
		try {
			MrBet.incluirTimeCampeonato("002_RJ", "Brasileirão série A 2023");
		} catch (Exception e) {
			assertEquals("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!", e.getMessage());
		}
	}
	
	@Test
	void testaVerificarInclusaoTimeEmCampeonato() {
		MrBet.adicionarCampeonato("Copa do Nordeste 2023", 2);
		MrBet.incluirTimeCampeonato("250_PB", "Copa do Nordeste 2023");
		
		String retorno1 = MrBet.verificarInclusaoTimeEmCampeonato("250_PB", "Copa do Nordeste 2023");
		assertEquals("O TIME ESTÁ NO CAMPEONATO!", retorno1);
		
		String retorno2 = MrBet.verificarInclusaoTimeEmCampeonato("252_PB", "Copa do Nordeste 2023");
		assertEquals("O TIME NÃO ESTÁ NO CAMPEONATO!", retorno2);
	}
	
	@Test
	void testaVerificarInclusaoTimeInexistenteEmCampeonato() {
		MrBet.adicionarCampeonato("Copa do Nordeste 2023", 2);
		
		try {
			MrBet.verificarInclusaoTimeEmCampeonato("005_PB", "Copa do Nordeste 2023");
			fail("Deveria lançar exceção!");
		} catch (Exception e) {
			assertEquals("O TIME NÃO EXISTE!", e.getMessage());
		}
	}
	
	@Test
	void testaVerificarInclusaoTimeEmCampeonatoInexistente() {
		try {
			MrBet.verificarInclusaoTimeEmCampeonato("250_PB", "Copa do Nordeste 2023");
			fail("Deveria lançar exceção!");
		} catch (Exception e) {
			assertEquals("O CAMPEONATO NÃO EXISTE!", e.getMessage());
		}
	}
	
	@Test
	void testaGetCampeonatosDeTimeInexistente() {
		try {
			MrBet.getCompeonatosTime("006_SP");
			fail("Deveria lançar exceção!");
		} catch (NoSuchElementException nsee) {
			assertEquals("O TIME NÃO EXISTE!", nsee.getMessage());
		}
	}
	
	@Test
	void testaGetCampeonatosDeTimeSemCampeonato() {
		try {
			MrBet.getCompeonatosTime("105_PB");
			fail("Deveria lançar exceção!");
		} catch (IllegalArgumentException iae) {
			assertEquals("O TIME NÃO ESTÁ EM NENHUM CAMPEONATO!", iae.getMessage());
		}
	}
	
	@Test
	void testaApostar() {
		MrBet.adicionarCampeonato("Copa do Nordeste 2023", 2);
		MrBet.incluirTimeCampeonato("250_PB", "Copa do Nordeste 2023");
		
		String retorno = MrBet.apostar("250_PB", "Copa do Nordeste 2023", 1, 150.0);
		assertEquals("APOSTA REGISTRADA!", retorno);
	}
	
	@Test
	void testaApostarEmTimeInexistente() {
		MrBet.adicionarCampeonato("Copa do Nordeste 2023", 2);
		
		try {
			MrBet.apostar("005_PB", "Copa do Nordeste 2023", 1, 150.0);
			fail("Deveria lançar exceção!");
		} catch (NoSuchElementException nsee) {
			assertEquals("O TIME NÃO EXISTE!", nsee.getMessage());
		}
	}
	
	@Test
	void testaApostarComCampeonatoInexistente() {
		try {
			MrBet.apostar("250_PB", "Copa do Nordeste 2023", 1, 150.0);
			fail("Deveria lançar exceção!");
		} catch (NoSuchElementException nsee) {
			assertEquals("O CAMPEONATO NÃO EXISTE!", nsee.getMessage());
		}
	}
	
	@Test
	void testaApostarTimeNaoInclusoEmCampeonato() {
		MrBet.adicionarCampeonato("Copa do Nordeste 2023", 2);
		
		try {
			MrBet.apostar("002_RJ", "Copa do Nordeste 2023", 1, 150.0);
			fail("Deveria lançar exceção!");
		} catch (IllegalArgumentException iae) {
			assertEquals("O TIME NÃO ESTÁ NO CAMPEONATO!", iae.getMessage());
		}
	}
	
	@Test
	void testaApostarColocaoInvalida() {
		MrBet.adicionarCampeonato("Copa do Nordeste 2023", 2);
		MrBet.incluirTimeCampeonato("250_PB", "Copa do Nordeste 2023");
		
		try {
			MrBet.apostar("250_PB", "Copa do Nordeste 2023", 3, 150.0);
			fail("Deveria lançar exceção!");
		} catch (IllegalArgumentException iae) {
			assertEquals("APOSTA NÃO REGISTRADA!", iae.getMessage());
		}
	}
}
