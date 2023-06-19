package model;
import java.awt.Color;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JOptionPane;

import controller.TabuleiroObservado;
class Game extends TabuleiroObservado {
	private Tabuleiro tabuleiro;
	private Dado dado;
	private Jogador jogadores[];
	private Jogador jVerde;
	private Jogador jAmarelo;
	private Jogador jAzul;
	private Jogador jVermelho;

	private boolean hasPlayed;
	private boolean canRollAgain;
	private int turn;
	private Jogador currentP;
	private int idxPecaMover;	

	public Game(){
		this.tabuleiro = new Tabuleiro();
		this.dado = new Dado();
		this.jogadores = new Jogador[4];
		this.canRollAgain = true;
		this.hasPlayed = false;

		jVerde = new Jogador(tabuleiro, Cor.VERDE);
		jAmarelo = new Jogador(tabuleiro, Cor.AMARELO);
		jAzul = new Jogador(tabuleiro, Cor.AZUL);
		jVermelho = new Jogador(tabuleiro, Cor.VERMELHO);

		jogadores[0] = jVerde;
		jogadores[1] = jAmarelo;
		jogadores[2] = jAzul;
		jogadores[3] = jVermelho;

		turn = 0;
		currentP = jogadores[turn];

		notifyObservers();
	}

	public void roll(){
		this.currentP = jogadores[turn];
		this.dado.rolar();
		this.canRollAgain = false;
		this.hasPlayed = false;
		checkMove();
		notifyObservers();
	}
	
	public void setResultado(String n){
		this.dado.setResultado(n);
	}
	
	public int getResultado(){
		return this.dado.getResultado();
	}

	public void checkMove(){

		if (!currentP.podeJogar(tabuleiro, this.getResultado())){
			System.out.println("nao pode mover");

			currentP.setSeis(0);
			turn = (turn + 1) % 4;

			hasPlayed = true;
			canRollAgain = true;
		}
	}

	public void move() {
		currentP.moverPeca(tabuleiro, idxPecaMover, this.getResultado());

		if (this.getResultado() == 6){
			currentP.addSeis();
		}
		
		else{
			currentP.setSeis(0);
			turn = (turn + 1) % 4;
		}
	}

	public void play(){
		move();

		if (currentP.isWinner()){
			System.out.println(currentP.getCor() + " ganhou");
			getResumo();

		}

		hasPlayed = true;
		notifyObservers();
	
	}
	
	public void setPosicaoPecas(int[][] v){
		for(int i = 0; i < 4; i++){
			jogadores[i].PararCasaEspecifica(v[i], tabuleiro);
		}
		notifyObservers();
	}

	public int[][] getPosicaoPecas(){
		int p[][] = new int[4][4];
		for(int i = 0; i < 4; i++){
			
			p[i] = jogadores[i].getPosicoes();
		}

		return p;
	}
	
	public void setIdxPecaMover(int idx){
		this.idxPecaMover = idx;
	}

	public int getIdxFromMouse(int n){ // Se olhar pra posicao de cada peca disponivel e uma delas fizer parte, retorna a peca
		if(hasPlayed == true){
			return -100;
		}
		else if (n >= -1 && n <= 105){
			System.out.println(currentP.getPecasDisponiveis().size());
			for (int i = 0; i < currentP.getPecasDisponiveis().size(); i++){
				Peca pc = currentP.getPecaDisponivel(i);
				if (pc.getPosition() == n){
					return i;
				}
			}
		}
		return -100;
	}
	public void getResumo(){
		Jogador[] copia = jogadores;
		Arrays.sort(copia, Comparator.comparingInt(Jogador::somaEspacosAteFinal));
		String[][] lines = new String[4][2];
		
		lines[0] = new String[]{copia[0].getJogadorName(), Integer.toString(copia[0].somaEspacosAteFinal())};
		lines[1] = new String[]{copia[1].getJogadorName(), Integer.toString(copia[1].somaEspacosAteFinal())};
		lines[2] = new String[]{copia[2].getJogadorName(), Integer.toString(copia[2].somaEspacosAteFinal())};
		lines[3] = new String[]{copia[3].getJogadorName(), Integer.toString(copia[3].somaEspacosAteFinal())};
		
		String vencedor = lines[0][0]+ " venceu!";
		String segundo = lines[1][0] + " tem " + lines[1][1] + " casas faltando";
		String terceiro = lines[2][0] + " tem " + lines[2][1] + " casas faltando";
		String quarto = lines[3][0] + " tem " + lines[3][1] + " casas faltando";
		
		String message = vencedor + "\n" + segundo + "\n" + terceiro + "\n" + quarto;
		int option = JOptionPane.showOptionDialog(
                null,
                message,
                "Popup Box",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[]{"OK"},
                "OK");

        if (option == JOptionPane.OK_OPTION) {
            // Execute your function here
            
        }
	}
	public Color getCurrentColor(){ 
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

	public boolean getHasPlayed(){
		return this.hasPlayed;
	}

	public boolean getcanRollAgain(){
		return this.canRollAgain;
	}

	public void setcanRollAgain(boolean b){
		this.canRollAgain = b;
	}
}