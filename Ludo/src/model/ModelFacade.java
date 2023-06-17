package model;
import controller.TabuleiroObservador;
public class ModelFacade {
	private static ModelFacade facade = null;
	private Game game;
	
	private ModelFacade() {
		this.facade = this;
		this.game = new Game();
	}

	public static ModelFacade getFacade() {
		if (facade == null) {
			facade = new ModelFacade();
		}
		return facade;
	}

	// public void createGame(){
	// 	this.game = new Game();
	// }

	public void roll(){
		game.roll();
	}

	public void setResultado(int n){
		game.setResultado(n);
	}

	public int getResultado(){
		return this.game.getResultado();
	}

	public void playGame(){
		game.play();
	}
	public void addObserver(TabuleiroObservador observer) {
		game.addObserver(observer);
	}
	public int[][] posicaoPecas(){
		return game.getEveryPosition();
    }

	/*public void register(TabuleiroObservador observer) {
		game.addObserver(observer);
	}*/
}
