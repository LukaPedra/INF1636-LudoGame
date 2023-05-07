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

			if (i % parte == 0) { // IF da RETA FINAL
				casa.setTipo(TipoCasa.retaFinal);
				switch (i){
					case 0:
						casa.setCor(Cor.azul);
						break;
					case 13:
						casa.setCor(Cor.vermelho);
						break;
					case 26:
						casa.setCor(Cor.verde);
						break;
					case 39:
						casa.setCor(Cor.amarelo);
						break;
				}
			} else if (i % parte == 11) { // IF do ABRIGO
				casa.setTipo(TipoCasa.abrigo);
			} else if (i % parte == 2) { // IF da PARTIDA
				casa.setTipo(TipoCasa.partida);
				switch (i){
					case 2:
						casa.setCor(Cor.azul);
						break;
					case 15:
						casa.setCor(Cor.vermelho);
						break;
					case 28:
						casa.setCor(Cor.verde);
						break;
					case 41:
						casa.setCor(Cor.amarelo);
						break;
				}
			}

			tabuleiro.add(casa);
		}
	}

	public Vector<Casa> getArrayCasas(){
		return tabuleiro;
	}
	
	//Como as retas finais também são "Tabuleiros" crio um vetor de 5 espaços
	//e pinto ela com a cor dada no parâmetro
	public void RetaFinal(Cor c) {
		int size = 5;
		tabuleiro = new Vector<Casa>(size);
		System.out.println(tabuleiro.size());
		for (int i = 0; i < size; i++) {
			Casa casa = new Casa(TipoCasa.retaFinal, c);
			tabuleiro.add(casa);
        }
	}
	public int getCasaInicial(Cor c) {
		if (c == Cor.azul) {
			return 2;
		} else if (c == Cor.vermelho) {
			return 15;
		} else if (c == Cor.verde) {
			return 28;
		} else { //Caso amarelo
			return 41;
		}
	}
	/* 
	public void quadradoInicial(Cor c) {
		int size = 4;
		tabuleiro = new Vector<Casa>(size);
		System.out.println(tabuleiro.size());
		for (int i = 0; i < size; i++) {
			Casa casa = new Casa(TipoCasa.inicial, c);
			tabuleiro.add(casa);
        }
	}*/
}
