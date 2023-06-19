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

	private boolean canRollAgain;
	private int turn;
	private Jogador currentP;
	private int idxPecaMover;

	private boolean win;
	private Jogador winner;
	

	public Game(){
		this.tabuleiro = new Tabuleiro();
		this.dado = new Dado();
		this.jogadores = new Jogador[4];
		this.canRollAgain = true;

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

		win = false;

		notifyObservers();
	}

	public void roll(){
		currentP = jogadores[turn];
		this.dado.rolar();
		checkMove();
		notifyObservers();
	}
	
	public void setResultado(int n){
		this.dado.setResultado(n);
	}
	
	public int getResultado(){
		return this.dado.getResultado();
	}

	public boolean checkMove(){

		if (currentP.podeJogar(tabuleiro, this.getResultado())){
			System.out.println("pode mover");
			
			return true;
		}

		System.out.println("nao pode mover");

		currentP.setSeis(0);
		turn = (turn + 1) % 4;

		return false;
	}

	public void move() {
		System.out.println("index da peca escolhida: " + idxPecaMover);

		System.out.println("move peça");
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
		//openWinnerPopUp();
		System.out.println(currentP.getCor());
		System.out.println("dado: " + this.getResultado());
		// System.out.println("Pecas disponives: " + currentP.getPecasDisponiveis());
		// System.out.println("Posicao peça 0 antes de mover: " + currentP.getLastPeca().getPosition());
		// System.out.println("Tirou 6: " + currentP.getSeis());

		move();
		
		if (currentP.isWinner()){
				winner = currentP;
				win = true;
				System.out.println(currentP.getCor() + " ganhou");

				
		}

		notifyObservers();
	
	
		// System.out.println("Posicao peça depois de mover: " + posPecaMover + "\n");

	}
	public void openWinnerPopUp(){
		Jogador[] copia = jogadores;
		Arrays.sort(copia, Comparator.comparingInt(Jogador::somaEspacosAteFinal));
		
		
		String line1 = copia[0].getJogadorName() + " ganhou!";
		String line2 = copia[1].getJogadorName() + " ficou em segundo lugar faltando: " + copia[1].somaEspacosAteFinal() + " casas";
		String line3 = copia[2].getJogadorName() + " ficou em terceiro lugar faltando: " + copia[2].somaEspacosAteFinal() + " casas";
		String line4 = copia[3].getJogadorName() + " ficou em quarto lugar faltando: " + copia[3].somaEspacosAteFinal() + " casas";
        

        String message = line1 + "\n" + line2 + "\n" + line3 + "\n" + line4;

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
			int[][] aux = new int[4][4];
			int var = 0;
			for(int i=0;i<4;i++){
				aux[i][0]=var;
				var+=13;
				for(int j=1;j<4;j++){
					aux[i][j]=-1;
				}
			}
            // Execute your function here
            setPosicaoPecas(aux);
			notifyObservers();
        }
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
		if (n >= -1 && n <= 105){
			System.out.println(currentP.getPecasDisponiveis().size());
			for (int i = 0; i < currentP.getPecasDisponiveis().size(); i++){
				Peca pc = currentP.getPecaDisponivel(i);
				if (pc.getPosition() == n){
					// play();
					return i;
				}
			}
		}
		return -100;
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
	public Dado getDado(){
		return this.dado;
	}
	public boolean getcanRollAgain(){
		return this.canRollAgain;
	}
	public void setcanRollAgain(boolean b){
		this.canRollAgain = b;
	}
	public boolean getWin(){
		return this.win;
	}
}