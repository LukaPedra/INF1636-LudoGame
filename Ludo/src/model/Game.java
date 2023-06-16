package model;

import java.util.Scanner;

public class Game{
	private Tabuleiro tabuleiro;
	private Dado dado;
	private Jogador jogadores[];
	private Jogador jVerde;
	private Jogador jAmarelo;
	private Jogador jAzul;
	private Jogador jVermelho;

	private Jogador currentP;
	private int turn;

	private boolean win;
	private Jogador winner;
	

	public Game(){
		this.tabuleiro = new Tabuleiro();
		this.dado = new Dado();
		this.jogadores = new Jogador[4];

		jVerde = new Jogador(tabuleiro, Cor.VERDE);
		jAmarelo = new Jogador(tabuleiro, Cor.AMARELO);
		jAzul = new Jogador(tabuleiro, Cor.AZUL);
		jVermelho = new Jogador(tabuleiro, Cor.VERMELHO);

		jogadores[0] = jVerde;
		jogadores[1] = jAmarelo;
		jogadores[2] = jAzul;
		jogadores[3] = jVermelho;

		turn = 0;

		win = false;
	}

	public void roll(){
		this.dado.rolar();
	}

	public boolean move() {

		if (currentP.podeJogar(tabuleiro, dado.getResultado())){
			System.out.println("move peça");
			currentP.moverPeca(tabuleiro, 0,dado.getResultado());

			if (dado.getResultado() == 6){
				currentP.addSeis();
			}
			
			else{
				currentP.setSeis(0);
				turn = (turn + 1) % 4;
			}

			return true;
		}

		System.out.println("nao move peça");

		currentP.setSeis(0);
		turn = (turn + 1) % 4;

		return false;
	}

	public void play(){
		
		System.out.println(dado.getResultado());

		currentP = jogadores[turn];
		System.out.println(currentP.getCor());

		if (move()){
			if (currentP.isWinner()){
					winner = currentP;
					win = true;
			}
		}
	}

	public static void main(String[] args) {
		final Game game = new Game();


		do{	
			game.roll();
			game.play();

			try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} while (!currentP.isWinner());
	}
}