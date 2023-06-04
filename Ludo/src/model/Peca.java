package model;

class Peca {
	private int position; //-1 é posição inicial
	private Cor cor;
	private int posInicial;
	private boolean retaFinal;
	private boolean winner;

	public Peca(Jogador j){
		this.position = -1;
		this.cor = j.getCor();
		this.posInicial = j.getPosInicial();
		this.retaFinal = false;
		this.winner = false;
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

	public boolean podeMover(Tabuleiro t, int nCasas){
		int startPoint = this.position; 				/* Posição onde a peça inicia a tentativa de movimentação */
		int destinationIndex;								/* Posição onde a peça quer chegar */
		Casa casa = t.getCasaSaida(this.cor);				/* Casa onde a peça está */

		/* Está na casa final */
		if (this.winner){
			return false;
		}
		
		/* Está na casa inicial e indo para casa de partida */
		if (startPoint == -1){
			if (nCasas != 5){ 
				return false;
			}
		}

		/* Vai iterando e olhando casa por casa */
		else{
			destinationIndex = (startPoint + nCasas) % 52;

			while (startPoint != destinationIndex){

				startPoint = (startPoint + 1) % 52;
				casa = t.getCasa(startPoint);	/* Sempre olha para a casa seguinte */

				if (casa.isBarreira()){			/* Se for barreira retorna falso dizendo que existe uma barreira naquele caminho e por isso a peça não pode ser movida */
					return false;
				}
				else if (casa.isCasaFinal(this.getCor())){	/* Se for casa final quebra o while antes da hora para não rodar mais vezes sem necessidade */
					break;
				}
			}
		}

		/* Faz uma verificação se é possível parar na casa */	
		return casa.podeParar(this);
	}
	
	public void moverPeca(Tabuleiro t, int nCasas){
		int destinationIndex;
		

		if (!this.retaFinal){
			Casa casa;
			
			if (position == -1){
				position = t.getPosicaoSaida(this.getCor());
				casa = t.getCasa(position);
				return;
			}

			else {
				t.getCasa(position).saiuCasa(this);
				destinationIndex = (position + nCasas) % 52;

				casa = t.getCasa(position); //casa atual

				while (position != destinationIndex){
					
					
					if (casa.isCasaFinal(this.cor)){ /* Se for casa final e ainda tiver coisa pra andar*/
						this.retaFinal = true;
						position = nCasas;

						break;
					}

					position = (position + 1) % 52; // soma um na posição da peça
					casa = t.getCasa(position); // próxima casa
					nCasas--; // diminui 1 da quantidade de casa para andar
				}	
			}

			if (!this.retaFinal){ /* Se não estiver na reta final, para na casa anterior a ela */
				casa.parouCasa(this);
			}
		}

		if(this.retaFinal){
			
			destinationIndex = (position + nCasas);

			if (destinationIndex == 6){
				this.winner = true;
			}
		}
	}

	//função que retorna quantas casas faltam para chegar no final
	public int casasFaltando() { // Melhorar para não precisar receber o tabuleiro
		int casasFaltando;

		int casasPercorridas = (position - this.posInicial);

		if (!this.retaFinal){
			if (casasPercorridas < 0) {
				casasPercorridas = 52 - this.posInicial + position;
			}
			casasFaltando = 52 - casasPercorridas - 2 + 6;
		}

		else{
			casasFaltando = 6 - position;
		}
		
		return casasFaltando;
	}
	
	public void backToStart(){
		position = -1;
	}

	public boolean isWinner(){
		return this.winner;
	}
}
