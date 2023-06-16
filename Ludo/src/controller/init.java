package controller;
import model.ModelFacade;
import view.ViewFacade;
public class init {
	public static void main(String[] args){
		ModelFacade.getFacade();
		ViewFacade.getFacade();

		ModelFacade.addObserver(ViewFacade.getGameScene());

	}
}
