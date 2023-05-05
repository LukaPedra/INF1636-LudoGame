package Model;

import java.lang.Math;

public class Dado {
	int min = 1;
	int max = 6;
	int lado;
	
	public void getLado() {
		lado = (int)Math.random() * (max-min+1) + min;
	}
}
