package model;

class Peca {
	private final Jogador jogador;
	private int position = -1; //-1 é posição inicial
	private Tabuleiro tabuleiro;
	//Não precisa da cor pois ele já está referenciando o jogador que possui um por já

	public Peca(Jogador jogador){
		this.jogador = jogador;
		this.tabuleiro = this.jogador.getTabuleiro();

	}
	public boolean podeMover(int nCasas){
		//Se passar de 52 ele inicia do início do vetor
		int destinationIndex = (position + nCasas) % 52;
		//Vai iterando e checka
		while (position != destinationIndex){
			Casa casa = tabuleiro.getArrayCasas().get(position);
			position = (position + 1) % 52;
			//Se no caminho tiver uma barreira ele não pode passar
			if (casa.isBarreira()){
				return false;
			}
			else if (casa.isCasaFinal(jogador) && casa.podeParar(this)){
				//Na movimentação tem que limitar o número de casas para não passar do final
				return true;
			}
		}
		//Se n tiver nada no caminho ele faz uma última checagem na casa final
		if (tabuleiro.getArrayCasas().get(destinationIndex).podeParar(this)){
			return true;
		}
		return false;
	}
	public void moverPeca(int nCasas){
		if (podeMover(nCasas)){
			int destinationIndex = (position + nCasas) % 52;
			while (position != destinationIndex){
				Casa casa = tabuleiro.getArrayCasas().get(position);
				position = (position + 1) % 52;
				if (casa.isCasaFinal(jogador) && casa.podeParar(this)){
					casa.parouCasa(this);
					break;
				}
			}
			tabuleiro.getArrayCasas().get(destinationIndex).parouCasa(this);
			position = destinationIndex;
		}
	}
	public void setPosicao(int posicao){
		position = posicao;
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
