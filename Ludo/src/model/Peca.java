package model;

class Peca {
	private int position; //-1 é posição inicial
	private Cor cor;
	private boolean retaFinal;
	private boolean chegou;

	public Peca(Jogador j){
		this.position = -1;
		this.cor = j.getCor();
		this.retaFinal = false;
		this.chegou = false;
	}
	public boolean podeMover(Tabuleiro t, int nCasas){
		int startPoint = this.getPosition(); 				/* Posição onde a peça inicia a tentativa de movimentação */
		int destinationIndex;								/* Posição onde a peça quer chegar */
		Casa casa = t.getCasa(startPoint);					/* Casa onde a peça está */

		/* Está na casa final */
		if (this.chegou){
			return false;
		}
		
		/* Está na casa inicial e indo para casa de partida */
		if (startPoint == -1){
			if (nCasas != 5){ 
				return false;
				
			}
			casa = t.getCasaSaida(this.getCor());
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
		Casa casa = t.getCasa(position);

		if ((!this.retaFinal)){
			
			if (position == -1){
				position = t.getPosicaoSaida(this.getCor());
				casa = t.getCasa(position);
				return;
			}

			else {
				t.getCasa(position).saiuCasa(this);
				destinationIndex = (position + nCasas) % 52;

				while (position != destinationIndex){
					position = (position + 1) % 52;
					nCasas--;
	
					casa = t.getCasa(position);
					
					if ((casa.isCasaFinal(this.getCor())) && (nCasas > 0)){ 
						this.retaFinal = true;
						position = 0;
						break;
					}
				}

				if (!this.retaFinal){
					casa.parouCasa(this);
				}
			}
		}

		if(this.retaFinal){
			
			destinationIndex = (position + nCasas);

			if (nCasas <= 5 - position){
				while (position != destinationIndex){
					position = position + 1;
					nCasas--;
					
					if (position == 5){
						this.chegou = true;
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

	public boolean isWinner(){
		return this.chegou;
	}
}
