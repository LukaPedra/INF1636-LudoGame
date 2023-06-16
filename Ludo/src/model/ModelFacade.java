package model;

public class ModelFacade {
	private static ModelFacade facade = null;
	private Game game;
	
	private ModelFacade() {
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

	public void playGame(){
		game.play();
	}
	
	/*public void register(TabuleiroObservador observer) {
		game.addObserver(observer);
	}*/

}
