package controller;
import model.ModelFacade;
import view.ViewFacade;
public class StartGame {
	public static void main(String[] args){
		ModelFacade model = new ModelFacade();
		ViewFacade view = new ViewFacade(); 

		model.addObserver(view.getGameScene());

	}
}
