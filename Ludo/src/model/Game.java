package model;

public class Game{
    int value;
    String color;

	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro();
		Dado dado = new Dado();

		System.out.println(tabuleiro.getCasa(2));

		// Jogador jAzul = new Jogador(tabuleiro, Cor.azul);
		// Jogador jVermelho = new Jogador(Cor.vermelho);
		// Jogador jVerde = new Jogador(Cor.verde);
		// Jogador jAmarelo = new Jogador(Cor.amarelo);
	}
}