package model;

class Peca {
	private final Jogador jogador;
	//Não precisa da cor pois ele já está referenciando o jogador que possui um por já
	
	public Peca(Jogador jogador){
		this.jogador = jogador;

	}

	public Jogador getJogador() {
		return jogador;
	}

}
