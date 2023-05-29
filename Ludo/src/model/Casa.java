package model;
import java.util.LinkedList;
import java.util.Queue;

class Casa {
	private TipoCasa tipo; 
	private Cor cor; //Se for uma casa especial uma cor pode ser associada a ela
	private Queue<Peca> pecasDentro = new LinkedList<>();
	
	public Casa() {
		tipo = TipoCasa.comum;
	}
	
	//Associa a casa a uma cor
	public Casa(TipoCasa tipo, Cor cor) {
		this.tipo = tipo;
		this.cor = cor;
	}
	public boolean podeParar(Peca peca){
		if (pecasDentro.size() <= 1){
			//Se a casa estiver vazia ou tiver outra peça
			if (pecasDentro.size() == 1 && pecasDentro.peek().getCor() == peca.getCor() && tipo == TipoCasa.partida){
				//Não pode parar na casa de partida se já tiver uma peça da mesma cor lá
				return false;
			}
			return true;
		}
		return false;
	}
	public void parouCasa(Peca peca){
		//Vou assumir que a peça pode parar na casa (rodei o método podeParar antes)

		//Vê o primeiro elemento da fila para ver se é da mesma cor
		if (pecasDentro.size() == 0){
			pecasDentro.add(peca);
		}
		//Adiciona uma peça da mesma cor a uma casa
		else if (pecasDentro.peek().getCor() == peca.getCor()){
			pecasDentro.add(peca);
		}
		//Nesse caso há uma peça inimiga habitando a casa
		else {
			Peca pecaInimiga = pecasDentro.peek();
			if (tipo == TipoCasa.abrigo || (tipo == TipoCasa.partida && pecaInimiga.getCor() == cor)){
				//Não comeu a peça e está na casa com o inimigo
				pecasDentro.add(peca);
			}
			else {
				//Comeu a Peça

				pecasDentro.remove().backToStart();
				pecasDentro.add(peca);
			}
		}
	}
	
	public boolean isBarreira(){
		Peca primeiraPeca = pecasDentro.peek();
		if (pecasDentro.size() == 2){
			for (Peca peca : pecasDentro){
				if (peca.getCor() == primeiraPeca.getCor()){
					return true;
				}
			}
		}
		return false;
	}
	/* Fazer esse método para usar */
	public boolean isCasaPartida(Cor c){
		if ((tipo == TipoCasa.partida) && (cor == c)){
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isCasaFinal(Cor c){
		if ((tipo == TipoCasa.casafinal) && (cor == c)){
			return true;
		}
		else {
			return false;
		}
	}
	public int getNumPecas(){
		return pecasDentro.size();
	}
	public void saiuCasa(Peca peca){
		pecasDentro.remove();
	}
	public void setTipo(TipoCasa tipo) {
		this.tipo = tipo;
	}
	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	//Métodos para pegar as variaveis da classe
	public TipoCasa getTipo() {
		return tipo;
	}
	public Cor getCor() {
		return cor;
	}
	public void printlnCasa(){
		System.out.println(tipo + "  " + cor);
	}
}
