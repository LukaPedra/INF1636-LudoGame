package model;

public class Game{
    int value;
    String color;

	public static void main(String[] args) {
		//Testando métodos
		Tabuleiro a = new Tabuleiro();
		//System.out.println(a.getLado());
		for (Casa casa : a.getArrayCasas()){
			casa.printlnCasa();
		}
		
	}
}