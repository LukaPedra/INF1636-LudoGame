package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJogador {
	Tabuleiro tabuleiro = new Tabuleiro();
	Jogador jogadorAzul = new Jogador(Cor.azul, tabuleiro);
	Jogador jogadorAmarelo = new Jogador(Cor.amarelo, tabuleiro);

	
	@Test
	public void TestaInicializa() {
		Jogador.setTabuleiro(tabuleiro);
		assertTrue(jogadorAzul.getPecas().get(0).getPosition() == 2);
		
		boolean isAtPosition = true;
		for (int i = 0; i < jogadorAzul.getPecas().size(); i++) {
			if (i == 0) {
				break;
			}
			if (jogadorAzul.getPecas().get(i).getPosition() == -1) {
				isAtPosition = false;
			}
		}
		assertTrue(isAtPosition);
		jogadorAzul.moverPeca(0, 2);
		jogadorAzul.moverPeca(1, 5);
		jogadorAzul.moverPeca(1, 2);

		System.out.println(jogadorAzul.getPeca(1).getPosition());
		Peca pecaAzulPeca = jogadorAzul.getPeca(0);
		assertTrue(pecaAzulPeca.podeMover(8));
		jogadorAmarelo.moverPeca(0, 18);
		
		assertFalse(jogadorAmarelo.getPeca(0).podeMover(18));
		//assertEquals(11, jogadorAzul.getPeca(0).getPosition());
		
		
	}
}
