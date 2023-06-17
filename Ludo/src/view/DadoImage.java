package view;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class DadoImage {
    public static Image getDiceImage(int dieValue) {
    	Image image;
        DadoImage dado = new DadoImage();
        if (dieValue < 1 || dieValue > 6) {
            throw new IllegalArgumentException("Invalid die value. Must be between 1 and 6.");
        }
        try {
			image = ImageIO.read(dado.getClass().getClassLoader().getResourceAsStream("Imagens/Dado"+dieValue+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

        //String imagePath = "/Users/lukapedra/Documents/GitHub/INF1636-LudoGame/Ludo/Imagens/Dado" + dieValue + ".png"; // Construct the file path based on die value
        return image;
    }
}
