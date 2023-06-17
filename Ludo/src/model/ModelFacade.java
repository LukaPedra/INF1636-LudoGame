package model;
import java.awt.Color;

import controller.TabuleiroObservador;
public class ModelFacade{
	private static ModelFacade facade = null;
	private Game game;
	
	private ModelFacade() {
		ModelFacade.facade = this;
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
	public void play(){
		game.play();
	}

	public void setResultado(int n){
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
	public int[][] posicaoPecas(){
		return game.getEveryPosition();
    }
	public void setPosPecaMover(int pos){
		game.setPosPecaMover(pos);
	}
	
	public int getPecaFromMouse(int n){
		return game.getPecaFromMouse(n);
	}
}
