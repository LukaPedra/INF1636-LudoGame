package model;

class Peca {
	private int position; //-1 é posição inicial
	private Cor cor;
	private boolean retaFinal;
	private boolean chegou;

	public Peca(Jogador j){
		this.position = -1;
		cor = j.getCor();
		this.retaFinal = false;
		this.chegou = false;
	}
	public boolean podeMover(Jogador j, Tabuleiro t, int nCasas){
		// Posição atual da peça
		int startPoint = this.getPosition();
		//Se passar de 52 ele inicia do início do vetor
		int destinationIndex = (startPoint + nCasas) % 52;

		/* Chegou na casa final */
		if (chegou){
			return false;
		}
		
		/* Está na casa inicial e indo para casa de saída */
		if ((startPoint == -1) && (nCasas == 5)) { 
			Casa casaInicial = t.getTabuleiro().get(t.getCasaInicial(j.getCor()));
			return casaInicial.podeParar(this);
		}

		/* Vai iterando e olhando casa por casa */
		else if (startPoint != -1) {
			while (startPoint != destinationIndex){

				startPoint = (startPoint + 1) % 52;
				Casa casa = t.getTabuleiro().get(startPoint);

				//Se no caminho tiver uma barreira ele não pode passar
				if (casa.isBarreira()){
					return false;
				}
				else if (casa.isCasaFinal(j)){
					//Na movimentação tem que limitar o número de casas para não passar do final
					return casa.podeParar(this);
				}
			}
			//Se não tiver nada no caminho ele faz uma última checagem na casa final
			if (t.getTabuleiro().get(destinationIndex).podeParar(this)){
				return true;
			}
		}
		
		return false;
	}
	
	public void moverPeca(Jogador j, Tabuleiro t, int nCasas){

		int destinationIndex;
		if (!retaFinal){
			
			if (podeMover(j, t, nCasas)){
				if (position == -1){
					position = t.getCasaInicial(j.getCor());
					
				}
				else {
					t.getTabuleiro().get(position).saiuCasa(this);
					destinationIndex = (position + nCasas) % 52;
					while (position != destinationIndex){
						position = (position + 1) % 52;
						nCasas--;
		
						Casa casa = t.getTabuleiro().get(position);
						
						if ((casa.isCasaFinal(j)) && (nCasas > 0)){ 
							this.retaFinal = true;
							position = 100;
							break;
						}
					}
				}

				Casa casa = t.getTabuleiro().get(position);
				casa.parouCasa(this);
			}
		}

		if(retaFinal){
			if (position == 100){
				t.getTabuleiro().get(position).saiuCasa(this);
				position = 0;
			}
			
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
			}
		}
	}

	public void setPosition(int posicao){
		position = posicao;
	}

	public int getPosition(){
		return position;
	}

	public Cor getCor(){
		return cor;
	}

	//função que retorna quantas casas faltam para chegar no final
	public int casaFaltando() {
		int casaQueComeca;
		if (this.getCor() == Cor.azul) {
			casaQueComeca = 2;
		}
		else if (this.getCor() == Cor.vermelho) {
			casaQueComeca = 15;
		}
		else if (this.getCor() == Cor.verde) {
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
	
	public void backToStart(){
		position = -1;
	}
}
