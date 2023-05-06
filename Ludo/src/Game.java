import Model.Casa;
import Model.Dado;
import Model.RenderColor;
import Model.Tabuleiro;

public class Game{
    int value;
    String color;

	public static void main(String[] args) {
		//Testando métodos
		Tabuleiro a = new Tabuleiro();
		a.RetaFinal(RenderColor.amarelo);
		for (Casa casa : a.getArrayCasas()){
			System.out.println(casa.getRenderColor());
		}
		//System.out.println(a.getLado());
	}
}