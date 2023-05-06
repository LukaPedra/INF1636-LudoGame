package Model;

import java.util.Vector;

public class Tabuleiro {
	Vector<Casa> tabuleiro;
	
	//Tem que usar esse método ao criar uma instancia de tabuleiro para adaptar o vetor do trajeto
	public Tabuleiro(){
		int size = 52;
		int parte = size/4;
		tabuleiro = new Vector<Casa>(size);
		
		for (int i = 0; i < size; i++){
			Casa casa = new Casa();
			if (i % (parte) == 0){
				casa.setTipo(TipoCasa.retaFinal);
				switch (i / parte){
					case 0:
						casa .setCor(Cor.azul);
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
			}
			else if (i % parte == 5){

			}
			tabuleiro.add(casa);
		}
	}
	public Vector<Casa> getArrayCasas(){
		return tabuleiro;
	}
	
	//Como as retas finais também são "Tabuleiros" crio um vetor de 5 espaços
	//e pinto ela com a cor dada no parâmetro
	public void RetaFinal(Cor c){
		int size = 5;
		tabuleiro = new Vector<Casa>(size);
		System.out.println(tabuleiro.size());
		for (int i = 0; i < size; i++) {
			Casa casa = new Casa(TipoCasa.retaFinal, c);
			tabuleiro.add(casa);
        }
		
	}

	
}
