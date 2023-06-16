package model;

public class ModelFacade {
	private static ModelFacade instance;
	private Tabuleiro game;

	
	private ModelFacade() {
		instance = this;
	}
	
	public static ModelFacade getInstance() {
		if(instance == null) {
			instance = new ModelFacade();
		}
		return instance;
	}
	/*public void register(TabuleiroObservador observer) {
		game.addObserver(observer);
	}*/
	public Tabuleiro getGame() {
		return this.game;
	}
}
