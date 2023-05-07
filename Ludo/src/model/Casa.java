package model;
import java.util.LinkedList;
import java.util.Vector;
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
	public boolean podeMover(Peca peca){
		if (pecasDentro.size() <= 1){
			return true;
		}
		return false;
	}
	//Incompleto!!!
	public void parouCasa(Peca peca){
		//Vê o primeiro elemento da fila para ver se é da mesma cor
		if (pecasDentro.size() == 0){
			pecasDentro.add(peca);
		}
		else if ((pecasDentro.peek().getCor() == peca.getCor())){
			pecasDentro.add(peca);
		}
		//Nesse caso há uma peça inimiga habitando a casa
		else {
			pecasDentro.remove().backToStart();
			pecasDentro.add(peca);
		}
		//return false;
		pecasDentro.add(peca);
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
