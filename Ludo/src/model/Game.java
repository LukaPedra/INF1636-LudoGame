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

	private int i = 0;
	Jogador currentP;

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
	}

	public int rollDie(){
		return this.dado.rolar();
	}

	public void turn() {
		
    	do{	
			Scanner scanner = new Scanner(System.in);
			scanner.nextLine();

			int resultado = dado.rolar();
			System.out.println(resultado);

			currentP = jogadores[i];
			System.out.println(currentP.getCor());

			if (currentP.podeJogar(tabuleiro, resultado) ){

				currentP.moverPeca(tabuleiro,0,resultado);
			}

			if (resultado != 6){
				i = (i+1)%4;
			}


			// try {
			// 	Thread.sleep(1000);
			// } catch (InterruptedException e) {
			// 	// TODO Auto-generated catch block
			// 	e.printStackTrace();
			// }

			scanner.close();

			
				//FUI COMER, JA VOLTO, ELE TA MUDANDO QUANDO APARECEM 3 VEZES O RESULTADO 6 (N NECESSARIAMENTE SEGUIDOS)

			// CODIGO

			
    	}while (!currentP.isWinner());
	}
}