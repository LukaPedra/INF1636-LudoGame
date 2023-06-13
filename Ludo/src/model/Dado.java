package model;

import java.util.Random;

class Dado {
	private Random random = new Random();
    private int resultado;
	
	public int rolar() {
		this.resultado = random.nextInt(6) + 1;
		return this.resultado;
	}
	
	public void setResultado(int n) {
		this.resultado = n;
	}

	public int getResultado() {
		return this.resultado;
	}
}
