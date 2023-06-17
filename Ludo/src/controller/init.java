package controller;
import model.ModelFacade;
import view.ViewFacade;
public class init {
	public static void main(String[] args){
		ModelFacade modelFacade = ModelFacade.getFacade();
		ViewFacade viewFacade = ViewFacade.getFacade();

		modelFacade.addObserver(viewFacade.getTabuleiroObservador());

	}
}
