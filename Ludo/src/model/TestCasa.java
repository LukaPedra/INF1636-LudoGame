package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCasa {
	Jogador jogadorVerde = new Jogador(Cor.verde);
	Jogador jogadorAzul = new Jogador(Cor.azul);
	
	@Test
	public void casoPodeParar() {
		Casa casa = new Casa();
		Peca peca1 = new Peca(jogadorVerde);
		Peca peca2 = new Peca(jogadorAzul);

		assertTrue(casa.podeParar(peca1));
		
		casa.parouCasa(peca1);
		
		assertTrue(casa.podeParar(peca2));
		assertTrue(casa.podeParar(peca1));

		
		Peca peca11 = new Peca(jogadorVerde);
		
		casa.parouCasa(peca11);
		
		assertFalse(casa.podeParar(peca2));
		casa.saiuCasa(peca2);
		
		casa.setTipo(TipoCasa.partida);
		
		Casa casaPartida = new Casa(TipoCasa.partida, Cor.verde);
		casaPartida.parouCasa(peca1);
		
		assertFalse(casa.podeParar(peca11));
		
		Casa casaAbrigoCasa = new Casa();
		casaAbrigoCasa.setTipo(TipoCasa.abrigo);
		
		casaAbrigoCasa.parouCasa(peca1);
		casaAbrigoCasa.parouCasa(peca2);
		assertEquals(2, casaAbrigoCasa.getNumPecas());
		
		//Casa casaComerCasa 
		
		
	}
	
	@Test
	public void TesteBarreira() {
		Casa casa = new Casa();
		Peca peca1 = new Peca(jogadorVerde);
		Peca peca11 = new Peca(jogadorVerde);
		
		casa.parouCasa(peca1);
		casa.parouCasa(peca11);
		assertTrue(casa.isBarreira());
	}
	
	@Test
	public void TesteCasaFinal() {
		Casa casaFinal = new Casa(TipoCasa.casafinal, Cor.verde);
		assertTrue(casaFinal.isCasaFinal(jogadorVerde));
	}
	@Test
	public void TesteConstrutor() {
		Casa casa = new Casa();
		assertTrue(casa.getTipo() == TipoCasa.comum);
		
		Casa casaAbrigo = new Casa();
		casaAbrigo.setTipo(TipoCasa.abrigo);
		
	}
	@Test
	public void TesteSaida() {
		Casa casa = new Casa();
		Peca peca1 = new Peca(jogadorVerde);
		Peca peca11 = new Peca(jogadorVerde);
		
		casa.parouCasa(peca1);
		casa.saiuCasa(peca1);
		assertEquals(0, casa.getNumPecas());
		
		casa.parouCasa(peca1);
		casa.parouCasa(peca11);
		casa.saiuCasa(peca1);
		assertEquals(1, casa.getNumPecas());
		
		//Caso de se 
	}
	

}
