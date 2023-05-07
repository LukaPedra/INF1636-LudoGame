package model;

public class Game{
    int value;
    String color;

	public static void main(String[] args) {
		Peca peca = new Peca(new Jogador(Cor.amarelo));
		peca.setPosicao(0);
		System.out.println(peca.casaFaltando());
		
	}
}