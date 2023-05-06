package Model;

public class Casa {
	TipoCasa tipo; // Casa comum = 0; Casa de saída = 1; Abrigo = 2
	Cor cor; //Se for uma casa especial uma cor pode ser associada a ela
	
	public Casa(){
		tipo = TipoCasa.comum;
	}
	
	//Associa a casa a uma cor
	public Casa(TipoCasa t, Cor c) {
		this.tipo = t;
		this.cor = c;
	}

	public void setTipo(TipoCasa t){
		this.tipo = t;
	}
	public void setCor(Cor c){
		this.cor = c;
	}
	
	//Métodos para pegar as variaveis da classe
	public TipoCasa getTipo(){
		return tipo;
	}
	public Cor getCor(){
		return cor;
	}
}
