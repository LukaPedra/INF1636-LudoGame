package model;

class Peca {
	private final Jogador jogador;
	private int position = -1; //-1 é posição inicial
	//Não precisa da cor pois ele já está referenciando o jogador que possui um por já

	public Peca(Jogador jogador){
		this.jogador = jogador;

	}
	public Cor getCor(){
		return jogador.getCor();
	}
	public void backToStart(){
		position = -1;
	}
	public Jogador getJogador() {
		return jogador;
	}

}
