package Model;

import java.util.Random;

public class Dado {
	Random random = new Random();
    int resultado;
	
	public int getLado() {
		Random random = new Random();
        int resultado = random.nextInt(6) + 1;
		System.out.println(resultado);
		return resultado;
	}
}
