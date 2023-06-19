package view;

import controller.TabuleiroObservador;

public class ViewFacade {
	private static ViewFacade facade = null;
	private GameScene gameScene;
	//private TabuleiroView tabuleiroView;
	
	private ViewFacade() {
		facade = this;

		this.gameScene = new GameScene();
	}
	
	public static ViewFacade getFacade() {
		if(facade == null) {
			facade = new ViewFacade();
		}
		return facade;
	}

	public void createScene(){
		gameScene = new GameScene();
	}

	public void redraw(){
		gameScene.redraw();
	}
	public TabuleiroObservador getTabuleiroObservador() {
		return gameScene.getTabuleiro().getTabuleiroObservador();
	}
}
