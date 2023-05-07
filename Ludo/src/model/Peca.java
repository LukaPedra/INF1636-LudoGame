package model;

class Peca {
	private final Jogador jogador;
	private int position = -1; //-1 é posição inicial
	private Tabuleiro tabuleiro;
	private Tabuleiro tabuleiroFinal;
	private boolean retaFinal;
	private boolean chegou;
	//Não precisa da cor pois ele já está referenciando o jogador que possui um por já

	public Peca(Jogador jogador){
		this.jogador = jogador;
		this.tabuleiro = Jogador.getTabuleiro();
		this.tabuleiroFinal = jogador.getTabuleiroFinal();
		this.retaFinal = false;
		this.chegou = false;
	}
	public boolean podeMover(int nCasas){
		//Se passar de 52 ele inicia do início do vetor
		int destinationIndex = (position + nCasas) % 52;
		//Vai iterando e checka
		if (!(position == -1)) {
			while (position != destinationIndex){
				Casa casa = tabuleiro.getTabuleiro().get(position);
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
			if (tabuleiro.getTabuleiro().get(destinationIndex).podeParar(this)){
				return true;
			}
		}
		else if (nCasas == 5) {
			Casa casaInicial = tabuleiro.getTabuleiro().get(tabuleiro.getCasaInicial(jogador.getCor()));
			return casaInicial.podeParar(this);
			
		}
		return false;
	}
	public void moverPeca(int nCasas){
		int destinationIndex;
		if (!retaFinal){
			if (podeMover(nCasas)){
				tabuleiro.getTabuleiro().get(position).saiuCasa(null);

				destinationIndex = (position + nCasas) % 52;
				while (position != destinationIndex){
					position = (position + 1) % 52;
					nCasas--;
	
					Casa casa = tabuleiro.getTabuleiro().get(position);
					
					if (casa.isCasaFinal(jogador) && casa.podeParar(this)){
						this.retaFinal = true;
						break;
					}
				}
	
				tabuleiro.getTabuleiro().get(position).parouCasa(this);
			}
		}

		else{
			tabuleiro.getTabuleiro().get(position).saiuCasa(null);
			position = 0;
			destinationIndex = (position + nCasas);

			if (nCasas <= 5 - position){
				while (position != destinationIndex){
					position = position + 1;
					nCasas--;
					
					if (position == 5){
						chegou = true;
						break;
					}
				}

				tabuleiroFinal.getTabuleiro().get(position).parouCasa(this);
			}
		}
	}

	public void setPosition(int posicao){
		position = posicao;
	}
	//função que retorna quantas casas faltam para chegar no final
	public int casaFaltando() {
		int casaQueComeca;
		if (getCor() == Cor.azul) {
			casaQueComeca = 2;
		}
		else if (getCor() == Cor.vermelho) {
			casaQueComeca = 15;
		}
		else if (getCor() == Cor.verde) {
			casaQueComeca = 28;
		}
		else {
			casaQueComeca = 41;
		}
		int casasPercorridas = (position - casaQueComeca);
		if (casasPercorridas < 0) {
			casasPercorridas = 52 - casaQueComeca + position;
		}
		int casasFaltando = 52 - casasPercorridas - 2;
		
		return casasFaltando;
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
