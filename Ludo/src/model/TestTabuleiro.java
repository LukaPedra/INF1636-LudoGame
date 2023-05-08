package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTabuleiro {

	@Test
	void testTabuleiro() {
		Tabuleiro tabuleiro = new Tabuleiro();
		assertTrue(tabuleiro.getTabuleiro().get(0).getCor() == Cor.azul);
		assertTrue(tabuleiro.getTabuleiro().get(0).getTipo() == TipoCasa.casafinal);
		assertTrue(tabuleiro.getTabuleiro().get(13).getCor() == Cor.vermelho);
		assertTrue(tabuleiro.getTabuleiro().get(13).getTipo() == TipoCasa.casafinal);
		assertTrue(tabuleiro.getTabuleiro().get(26).getCor() == Cor.verde);
		assertTrue(tabuleiro.getTabuleiro().get(26).getTipo() == TipoCasa.casafinal);
		assertTrue(tabuleiro.getTabuleiro().get(39).getCor() == Cor.amarelo);
		assertTrue(tabuleiro.getTabuleiro().get(39).getTipo() == TipoCasa.casafinal);
		
		
		assertTrue(tabuleiro.getTabuleiro().get(2).getCor() == Cor.azul);
		assertTrue(tabuleiro.getTabuleiro().get(2).getTipo() == TipoCasa.partida);
		assertTrue(tabuleiro.getTabuleiro().get(15).getCor() == Cor.vermelho);
		assertTrue(tabuleiro.getTabuleiro().get(15).getTipo() == TipoCasa.partida);
		assertTrue(tabuleiro.getTabuleiro().get(28).getCor() == Cor.verde);
		assertTrue(tabuleiro.getTabuleiro().get(28).getTipo() == TipoCasa.partida);
		assertTrue(tabuleiro.getTabuleiro().get(41).getCor() == Cor.amarelo);
		assertTrue(tabuleiro.getTabuleiro().get(41).getTipo() == TipoCasa.partida);
		
		
		assertTrue(tabuleiro.getTabuleiro().get(11).getTipo() == TipoCasa.abrigo);
		assertTrue(tabuleiro.getTabuleiro().get(24).getTipo() == TipoCasa.abrigo);
		assertTrue(tabuleiro.getTabuleiro().get(37).getTipo() == TipoCasa.abrigo);
		assertTrue(tabuleiro.getTabuleiro().get(50).getTipo() == TipoCasa.abrigo);
		
		Tabuleiro tabuleiroRetaFinalTabuleiro = new Tabuleiro(Cor.amarelo);
		for (Casa casa : tabuleiroRetaFinalTabuleiro.getTabuleiro()) {
			assertTrue(casa.getCor() == Cor.amarelo);
		}
		
		assertEquals(52, tabuleiro.getTabuleiro().size());
		assertEquals(6, tabuleiroRetaFinalTabuleiro.getTabuleiro().size());

		

	}

}
