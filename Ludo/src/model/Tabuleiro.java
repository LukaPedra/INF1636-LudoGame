package model;

import java.util.Vector;

class Tabuleiro {
	private Vector<Casa> tabuleiro;
	
	//Tem que usar esse método ao criar uma instancia de tabuleiro para adaptar o vetor do trajeto
	public Tabuleiro() {
		int size = 52;
		int parte = size/4;
		tabuleiro = new Vector<Casa>(size);
		
		for (int i = 0; i < size; i++) {
			Casa casa = new Casa();

			if (i % parte == 0) { // Casa de Saída
				casa.setTipo(TipoCasa.saida);
				switch (i){
					case 0:
						casa.setCor(Cor.VERDE);
						break;
					case 13:
						casa.setCor(Cor.AMARELO);
						break;
					case 26:
						casa.setCor(Cor.AZUL);
						break;
					case 39:
						casa.setCor(Cor.VERMELHO);
						break;
				}
			}

			else if (i % parte == 9) { // Abrigo
				casa.setTipo(TipoCasa.abrigo);
			} 

			else if (i % parte == 11) { // Casa Final
				casa.setTipo(TipoCasa.casafinal);
				switch (i){
					case 11:
						casa.setCor(Cor.AMARELO);
						break;
					case 24:
						casa.setCor(Cor.AZUL);
						break;
					case 37:
						casa.setCor(Cor.VERMELHO);
						break;
					case 50:
						casa.setCor(Cor.VERDE);
						break;
				}
			}
			
			tabuleiro.add(casa);
		}
	}
	
	public Vector<Casa> getTabuleiro(){
		return tabuleiro;
	}
	
	public int getPosicaoSaida(Cor c) {
		if (c == Cor.VERDE) {
			return 0;
		}
		else if (c == Cor.AMARELO) {
			return 13;
		} 
		else if (c == Cor.AZUL) {
			return 26;
		}
		else { //Caso Vermelho
			return 39;
		}
	}

	public Casa getCasaSaida(Cor c) {
		return this.getCasa(this.getPosicaoSaida(c));
	}

	public Casa getCasa(int i) {
		return this.tabuleiro.get(i);
	}
}
