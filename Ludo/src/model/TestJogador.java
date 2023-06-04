package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJogador {
	Tabuleiro tabuleiro = new Tabuleiro();
	Jogador jogadorAzul = new Jogador(tabuleiro, Cor.azul);
	Jogador jogadorAmarelo = new Jogador(tabuleiro, Cor.amarelo);

	
	@Test
	public void TestaInicializa() {
		assertTrue(jogadorAzul.getPeca(0).getPosition() == 2);
		
		boolean isAtPosition = true;
		for (int i = 0; i < jogadorAzul.getPecas().size(); i++) {
			if (i == 0) {
				break;
			}
			if (jogadorAzul.getPeca(i).getPosition() == -1) {
				isAtPosition = false;
			}
		}
		assertTrue(isAtPosition);
		jogadorAzul.moverPeca(tabuleiro,1,2);
		jogadorAzul.moverPeca(tabuleiro,1, 5);
		jogadorAzul.moverPeca(tabuleiro,1, 2);

		System.out.println(jogadorAzul.getPeca(1).getPosition());
		Peca pecaAzulPeca = jogadorAzul.getPeca(0);
		assertTrue(pecaAzulPeca.podeMover(tabuleiro,8));
		jogadorAmarelo.moverPeca(tabuleiro,1, 18);
		
		assertFalse(jogadorAmarelo.getPeca(0).podeMover(tabuleiro, 18));
		//assertEquals(11, jogadorAzul.getPeca(0).getPosition());
		
		
	}
}