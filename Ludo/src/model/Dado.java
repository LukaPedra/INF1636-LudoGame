package model;

import java.util.Random;

class Dado {
	private Random random = new Random();
    private int resultado;
	private String ResultadoManual = "Random";
	
	public void rolar() {
		if (this.ResultadoManual.equals("Random")){
			this.resultado = random.nextInt(6) + 1;
		}
		else{
			this.resultado = Integer.parseInt(this.ResultadoManual);
		}
	}
	
	public void setResultado(String n) {
		this.ResultadoManual = n;
	}

	public int getResultado() {
		return this.resultado;
	}
}
