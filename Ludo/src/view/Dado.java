package view;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dado {
    public static Image getDieImage(int dieValue) {
    	Image image;
        Dado dado = new Dado();
        
        if (dieValue < 1 || dieValue > 6) {
            throw new IllegalArgumentException("Invalid die value. Must be between 1 and 6.");
        }
        try {
			image = ImageIO.read(dado.getClass().getClassLoader().getResourceAsStream("Imagens/Dado"+dieValue+".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
			return null;
		}

        return image;
    }
}
