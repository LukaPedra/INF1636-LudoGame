package model;
import java.util.LinkedList;

class Casa {
	private TipoCasa tipo; 
	private Cor cor; //Se for uma casa especial uma cor pode ser associada a ela
	private LinkedList<Peca> pecasDentro = new LinkedList<>();
	
	public Casa() {
		this.tipo = TipoCasa.COMUM;
	}
	public Casa(TipoCasa t, Cor c) {	//Para usar no teste
		this.tipo = t;
		this.cor = c;
	}

	public void setTipo(TipoCasa t) {
		this.tipo = t;
	}
	public TipoCasa getTipo() {
		return tipo;
	}

	public void setCor(Cor c) {
		this.cor = c;
	}
	public Cor getCor() {
		return cor;
	}

	public boolean podeParar(Peca peca){
		if (pecasDentro.size() <= 1){
			//Se a casa estiver vazia ou tiver outra peça
			if (pecasDentro.size() == 1 && pecasDentro.peek().getCor() == peca.getCor() && tipo == TipoCasa.SAIDA){
				//Não pode parar na casa de partida se já tiver uma peça da mesma cor lá
				return false;
			}
			return true;
		}
		return false;
	}

	public void parouCasa(Peca peca){
		//Vou assumir que a peça pode parar na casa (rodei o método podeMover e podeParar (Dentro do podeMover))

		//Vê o primeiro elemento da fila para ver se é da mesma cor
		if (pecasDentro.size() == 0){
			pecasDentro.add(peca);
		}

		//Adiciona uma peça da mesma cor a uma casa
		else{
			/* Casa comum: Duas peças iguais podem ocupar */
			if (pecasDentro.peek().getCor() == peca.getCor()){ 
				pecasDentro.add(peca);
			}

			else {
				Peca pecaInimiga = pecasDentro.peek();

				/* Casa de abrigo: Duas peças distintas podem ocupar */
				if (tipo == TipoCasa.ABRIGO){ 
					pecasDentro.add(peca);
				}

				/* Casa de saída: Duas peças distintas podem ocupar desde que uma delas seja da cor da casa*/
				else if(tipo == TipoCasa.SAIDA && cor == pecaInimiga.getCor()){
					//Não comeu a peça e está na casa com o inimigo
					pecasDentro.add(peca);
				}
				
				else {
					// this.saiuCasa(pecaInimiga);
					pecaInimiga.backToStart(this);
					pecasDentro.add(peca);
				}
			}
		}	
	}

	public void saiuCasa(Peca peca){
		pecasDentro.remove(peca);
	}
	
	/* Verifica se casa é barreira */
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

	/* Verifica se é casa de saída da cor */
	public boolean isCasaSaida(Cor c){
		if ((tipo == TipoCasa.SAIDA) && (cor == c)){
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isCasaFinal(Cor c){
		if ((tipo == TipoCasa.CASAFINAL) && (cor == c)){
			return true;
		}
		else {
			return false;
		}
	}

	public Peca getPeca(Cor c){
		for (int i = 0; i < pecasDentro.size(); i++){
			Peca pc = pecasDentro.get(i);
			if (pc.getCor() == c){
				return pc;
			}
		}

		return null;
	
			
	}

/* Métodos usados para teste */		
	public int getNumPecas(){
		return pecasDentro.size();
	}
	
	public void printlnCasa(){
		System.out.println(tipo + "  " + cor);
	}
}
