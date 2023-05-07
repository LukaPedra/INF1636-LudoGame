package model;

import java.util.Random;

class Dado {
	private Random random = new Random();
    private int resultado;
	private int seisSeguidos = 0;
	
	public int rolar() {
        int resultado = random.nextInt(6) + 1;
		return resultado;
	}

	public int getResultado() {
		return resultado;
	}
}
