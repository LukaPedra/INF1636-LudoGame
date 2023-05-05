package Model;

public class Casa {
	TipoCasa tipo; // Casa comum = 0; Casa de saída = 1; Abrigo = 2
	char cor;
	
	public Casa(TipoCasa t) { // Construtor para Casa Comum e Abrigos
		tipo = t;
	}
	public Casa(TipoCasa t, char c) {
		tipo = t;
		cor = c;
	}
	
}
