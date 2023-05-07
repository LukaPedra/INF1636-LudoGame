package model;

class Casa {
	private TipoCasa tipo; 
	private Cor cor; //Se for uma casa especial uma cor pode ser associada a ela
	
	public Casa() {
		tipo = TipoCasa.comum;
	}
	
	//Associa a casa a uma cor
	public Casa(TipoCasa tipo, Cor cor) {
		this.tipo = tipo;
		this.cor = cor;
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
}
