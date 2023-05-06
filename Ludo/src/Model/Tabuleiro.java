package Model;

import java.util.Vector;

public class Tabuleiro {
	Vector<Casa> tabuleiro;
	
	//Tem que usar esse método ao criar uma instancia de tabuleiro para adaptar o vetor do trajeto
	public void MainTrajeto(){
		tabuleiro = new Vector<Casa>(52);
	}
	public Vector<Casa> getArrayCasas(){
		return tabuleiro;
	}

	//Como as retas finais também são "Tabuleiros" crio um vetor de 5 espaços
	//e pinto ela com a cor dada no parâmetro
	public void RetaFinal(RenderColor c){
		int size = 5;
		tabuleiro = new Vector<Casa>(size);
		System.out.println(tabuleiro.size());
		for (int i = 0; i < size; i++) {
			Casa casa = new Casa(TipoCasa.retaFinal);
			casa.setRenderColor(c);
			tabuleiro.add(casa);
        }
		// for (Casa casa : tabuleiro){
		// 	casa.setRenderColor(c);
		// 	tabuleiro.add(casa);
		// }
	}

	
}
