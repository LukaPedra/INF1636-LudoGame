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
		if ((pecasDentro.size() <= 1)){
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
		else if ((pecasDentro.peek().getCor() == peca.getCor())){
			pecasDentro.add(peca);
		}
		//Nesse caso há uma peça inimiga habitando a casa
		else {
			if (tipo == TipoCasa.abrigo){
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
		for (Peca peca : pecasDentro){
			if (!(peca.getCor() == primeiraPeca.getCor())){
				return false;
			}
		}
		return true;
	}
	public boolean isCasaFinal(Jogador jogador){
		if (tipo == TipoCasa.casafinal && (cor == jogador.getCor())){
			return true;
		}
		else {
			return false;
		}
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
