package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mrBet.Historico;
import mrBet.Time;
import mrBet.Campeonato;

class HistoricoTest {
	Historico historico;
	HashMap<String, Time> times;
	Time time1;
	Time time2;
	Time time3;
	
	@BeforeEach
	void setUp() {
		historico = new Historico();
		times = new HashMap<>();
		time1 = new Time("250_PB", "Nacional de Patos", "Canário");
		time2 = new Time("252_PB", "Sport Lagoa Seca", "Carneiro");
		time3 = new Time("002_RJ", "Clube de Regatas do Flamengo", "Urubu");
		
		times.put("250_PB", time1);
		times.put("252_PB", time2);
		times.put("002_RJ", time3);
		
		time1.guardarCampeonato(new Campeonato("Esperancense", 2));
		time2.guardarCampeonato(new Campeonato("Esperancense", 2));
		
		time2.aumentarPopularidade();
	}

	@Test
	void testaRecuperarTimesMaiorParticipacao() {
		time1.guardarCampeonato(new Campeonato("Brasileirão série A 2023", 4));
		
		assert historico.recuperarTimesMaiorParticipacao(times).contains(time1);
		assert !historico.recuperarTimesMaiorParticipacao(times).contains(time2);
		assert !historico.recuperarTimesMaiorParticipacao(times).contains(time3);
	}
	
	@Test
	void testaRecuperarTimesSemCampeonatos() {
		assert !historico.recuperarTimesSemCampeonatos(times).contains(time1);
		assert !historico.recuperarTimesSemCampeonatos(times).contains(time2);
		assert historico.recuperarTimesSemCampeonatos(times).contains(time3);
	}
	
	@Test
	void testaRecuperarTimesPopulares() {
		assert !historico.recuperarTimesPopulares(times).contains(time1);
		assert historico.recuperarTimesPopulares(times).contains(time2);
		assert !historico.recuperarTimesPopulares(times).contains(time3);
	}
}
