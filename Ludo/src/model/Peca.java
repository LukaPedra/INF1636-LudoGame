package model;

class Peca {
	private int position; //-1 é posição inicial
	private Cor cor;
	private boolean winner;

	public Peca(Jogador j){
		this.position = -1;
		this.cor = j.getCor();
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
		

		if (position < 100){
			Casa casa;
			
			if (position == -1){
				position = t.getPosicaoSaida(this.getCor());
				casa = t.getCasa(position);
			}

			else {
				t.getCasa(position).saiuCasa(this);

				casa = t.getCasa(position); //casa atual

				while (nCasas > 0){
					if (casa.isCasaFinal(this.cor)){ /* Se for casa final e ainda tiver coisa pra andar*/
						position = 100 + nCasas - 1;
						nCasas = 0;
					}

					else{
						position = (position + 1) % 52; // soma um na posição da peça
						casa = t.getCasa(position); // próxima casa
						nCasas--; // diminui 1 da quantidade de casa para andar
					}
				}	
			}

			if (position < 100){ /* Se não estiver na reta final, para na casa anterior a ela */
				casa.parouCasa(this);
			}
		}

		if(position >= 100){
			
			destinationIndex = (position + nCasas);

			if (destinationIndex == 105){
				position += nCasas;
				this.winner = true;
			}
		}
	}
	public void PararCasaEspecifica(int posicao, Tabuleiro t){ //usado para carregar peças para posição de um arquivo
		setPosition(posicao);
		if (posicao>-1 && posicao < 100){
			t.getCasa(posicao).parouCasa(this);
		}
	}
	//função que retorna quantas casas faltam para chegar no final
	public int casasFaltando(int posIni) { // Melhorar para não precisar receber o tabuleiro
		int casasFaltando;

		int casasPercorridas = (position - posIni);
		if (position == -1){
			return 59;
		}
		else if (position < 100){
			if (casasPercorridas < 0) {
				casasPercorridas = 52 - posIni + position;
			}
			casasFaltando = 52 - casasPercorridas + 6;
		}

		else{
			casasFaltando = 6 - position;
		}
		
		return casasFaltando;
	}
	
	public void backToStart(Casa c){
		c.saiuCasa(this);
		position = -1;
	}

	public boolean isWinner(){
		return this.winner;
	}
}
