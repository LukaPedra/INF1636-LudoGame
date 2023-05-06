package Model;

public class Casa {
	TipoCasa tipo; // Casa comum = 0; Casa de saída = 1; Abrigo = 2
	Cor corAssociada; //Se for uma casa especial uma cor pode ser associada a ela
	RenderColor renderColor = RenderColor.branco; //Pinta a casa com essa variável (por padrão é branca)
	
	
	public Casa(TipoCasa t) { // Construtor para Casa Comum e Abrigos
		tipo = t;
	}
	//Associa a casa a uma cor
	public Casa(TipoCasa t, Cor c) {
		tipo = t;
		setCorAssociada(c);
	}
	public void setCorAssociada(Cor c){
		corAssociada = c;
	}
	public void setRenderColor(RenderColor color){
		renderColor = color;
	}

	//Métodos para pegar as variaveis da classe
	public TipoCasa getTipo(){
		return tipo;
	}
	public Cor getCorAssociada(){
		return corAssociada;
	}
	public RenderColor getRenderColor(){
		return renderColor;
	}
}
