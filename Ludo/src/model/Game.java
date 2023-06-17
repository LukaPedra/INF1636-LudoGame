package model;
import java.awt.Color;

import controller.TabuleiroObservado;
class Game extends TabuleiroObservado {
	private Tabuleiro tabuleiro;
	private Dado dado;
	private Jogador jogadores[];
	private Jogador jVerde;
	private Jogador jAmarelo;
	private Jogador jAzul;
	private Jogador jVermelho;

	private Jogador currentP = jVerde;
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

	public void setResultado(int n){
		this.dado.setResultado(n);
	}

	public int getResultado(){
		return this.dado.getResultado();
	}

	public boolean move() {

		if (currentP.podeJogar(tabuleiro, this.getResultado())){
			System.out.println("move peça");
			currentP.moverPeca(tabuleiro, 0,this.getResultado());

			if (this.getResultado() == 6){
				currentP.addSeis();
			}
			
			else{
				currentP.setSeis(0);
				turn = (turn + 1) % 4;
			}
			
			notifyObservers();
			return true;
		}

		System.out.println("nao move peça");

		currentP.setSeis(0);
		turn = (turn + 1) % 4;

		return false;
	}

	public void play(){
		currentP = jogadores[turn];
		System.out.println(currentP.getCor());
		System.out.println("dado: " + this.getResultado());
		System.out.println("Posicao peça 0 antes de mover: " + currentP.getLastPeca().getPosition());
		System.out.println("Tirou 6: " + currentP.getSeis());


		if (move()){
			if (currentP.isWinner()){
					winner = currentP;
					win = true;
					System.out.println(currentP.getCor() + " ganhou");
			}
		}
		System.out.println("Posicao peça 0 depois de mover: " + currentP.getLastPeca().getPosition() + "\n");

	}

	public int[][] getEveryPosition(){
		int p[][] = new int[4][4];
		for(int i = 0; i < 4; i++){
			
			p[i] = jogadores[i].getPosicoes();
		}

		return p;
	}
	
	public Peca getPecaFromMouse(int n){ // Se olhar pra posicao de cada peca disponivel e uma delas fizer parte, retorna a peca
		if (n >= -1 && n <= 105){
			for (int i = 0; i < currentP.getPecasDisponiveis().size(); i++){
				Peca pc = currentP.getPecaDisponivel(i);
				if (pc.getPosition() == n){
					return pc;
				}
			}
		}

		return null;
	}

	public Color getCurrentColor(){ // Não seria mais fácil só retornar a cor?
		switch(currentP.getCor()){
			case VERDE:
				return Color.GREEN;
			case AMARELO:
				return Color.YELLOW;
			case AZUL:
				return Color.BLUE;
			case VERMELHO:
				return Color.RED;
		}
		return Color.WHITE;//Caso erro

	}

	public boolean getWin(){
		return this.win;
	}
	
	public static void main(String[] args) {
		final Game game = new Game();

		do{	
			game.roll();
			game.play();

			try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} while (!game.getWin());
	}
}