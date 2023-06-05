package model;


public class Game{
    int value;
    String color;

	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro();
		Dado dado = new Dado();
		int i = 0;
		
		
		 Jogador jAzul = new Jogador(tabuleiro, Cor.azul);
		 Jogador jVermelho = new Jogador(tabuleiro, Cor.vermelho);
		 Jogador jVerde = new Jogador(tabuleiro, Cor.verde);
		 Jogador jAmarelo = new Jogador(tabuleiro, Cor.amarelo);
		 Jogador jogadores [] = new Jogador[4];
		 
		Jogador currentP;
		jogadores[0] = jAzul;
		jogadores[1] = jVermelho;
		jogadores[2] = jVerde;
		jogadores[3] = jAmarelo;
		  
    	do{	
			int resultado = dado.rolar();
			System.out.println(resultado);
			currentP = jogadores[i];
			System.out.println(currentP.getCor());
			if (currentP.podeJogar(tabuleiro, resultado) ){

				currentP.moverPeca(tabuleiro,0,resultado);
			}
			else{
				i = (i+1)%4;
			}




			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
				//FUI COMER, JA VOLTO, ELE TA MUDANDO QUANDO APARECEM 3 VEZES O RESULTADO 6 (N NECESSARIAMENTE SEGUIDOS)

			// CODIGO

			
    	}while (!currentP.isWinner());
	}
}