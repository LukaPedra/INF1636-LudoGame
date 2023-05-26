package view;

import java.awt.Image;
import javax.swing.ImageIcon;

public class DadoImage {
    public static Image getDiceImage(int dieValue) {
        if (dieValue < 1 || dieValue > 6) {
            throw new IllegalArgumentException("Invalid die value. Must be between 1 and 6.");
        }
        //String imagePath = "/Users/lukapedra/Documents/GitHub/INF1636-LudoGame/Ludo/Imagens/Dado" + dieValue + ".png"; // Construct the file path based on die value
        String imagePath = System.getProperty("user.dir")+"/Imagens/Dado" + dieValue + ".png"; // Construct the file path based on die value
        System.out.println(imagePath);
        try {
            // Read the image file into an Image
            Image image = new ImageIcon(imagePath).getImage();
            return image;
        } catch (Exception e) {
            // Handle any exceptions that occur during the image reading process
            e.printStackTrace();
            return null;
        }
    }
}
