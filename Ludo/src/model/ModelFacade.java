package model;

public class ModelFacade {
	private static ModelFacade facade;
	private Game game;
	
	private ModelFacade() {
		ModelFacade.facade = this;
	}

	public static ModelFacade getFacade() {
		if (facade == null) {
			facade = new ModelFacade();
		}
		return facade;
	}

	public void createGame(){
		this.game = new Game();
	}

	public void roll(){
		game.roll();
	}

	public void turn(){
		game.turn();
		// jogadores[turno].moverPeca();
	}
	
	/*public void register(TabuleiroObservador observer) {
		game.addObserver(observer);
	}*/
	public Game getGame() {
		return this.game;
	}
}
