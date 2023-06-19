package model;
import java.awt.Color;

import controller.TabuleiroObservador;
import view.ViewFacade;
public class ModelFacade{
	private static ModelFacade facade = null;
	private Game game;
	private ViewFacade viewFacade;
	
	private ModelFacade() {
		ModelFacade.facade = this;
		this.game = new Game();
		viewFacade = ViewFacade.getFacade();
	}

	public static ModelFacade getFacade() {
		if (facade == null) {
			facade = new ModelFacade();
		}
		return facade;
	}

	public void createGame(){
	 	this.game = new Game();
		game.addObserver(viewFacade.getTabuleiroObservador());
		viewFacade.redraw();
	}

	public void roll(){
		game.roll();
		
	}
	public void play(){
		game.play();
	}

	public void setResultado(String n){
		game.setResultado(n);
	}

	public int getResultado(){
		return this.game.getResultado();
	}
	public Color getCor(){
		return game.getCurrentColor();
	}
	
	public void addObserver(TabuleiroObservador observer) {
		game.addObserver(observer);
	}

	public void setPosicaoPecas(int[][] pos){
		game.setPosicaoPecas(pos);
	}
	
	public int[][] getPosicaoPecas(){
		return game.getPosicaoPecas();
    }
	public void setIdxPecaMover(int idx){
		game.setIdxPecaMover(idx);
	}
	public int getIdxFromMouse(int idx){
		return game.getIdxFromMouse(idx);
	}
	public boolean getcanRollAgain(){
		return game.getcanRollAgain();
	}
	public boolean getHasPlayed(){
		return game.getHasPlayed();
	}
	public void setcanRollAgain(boolean b){
		game.setcanRollAgain(b);
	}
	

}
