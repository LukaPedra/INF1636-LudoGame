package view;

public class ViewFacade {
	private static ViewFacade instance;
	private GameScene gameScene;
	//private TabuleiroView tabuleiroView;
	
	private ViewFacade() {
		instance = this;
	}
	
	public void createView(){
		gameScene = new GameScene();
	}

	public void redraw(){
		gameScene.redraw();
	}
	public static ViewFacade getInstance() {
		if(instance == null) {
			instance = new ViewFacade();
		}
		return instance;
	}

	/* 
	public void register(TabuleiroView tabuleiroView) {
		this.tabuleiroView = tabuleiroView;
	}
	public TabuleiroView getTabuleiroView() {
		return this.tabuleiroView;
	}*/
}
