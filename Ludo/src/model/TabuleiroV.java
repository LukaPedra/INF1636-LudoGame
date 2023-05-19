package model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TabuleiroV extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
    	int j = 600;
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.GREEN);
        g2d.fillRect(540, 290, 60, 60);
        
        g2d.setColor(Color.BLACK);
        for(int i = 0; i<6; i++) {
             g2d.drawRect(j, 290, 20, 20);
             if(i==4){
            	 g2d.fillRect(j+1, 291, 19, 19);
             }
             j = j+20;
        }
        j=600;
        for(int i = 0; i<6; i++) {
            g2d.drawRect(j, 310, 20, 20);
            if(i<=4){
            g2d.setColor(Color.YELLOW);
           	g2d.fillRect(j+1, 311, 19, 19);
           	g2d.setColor(Color.BLACK);
            }
            j = j+20;
       }
        j=600;
        for(int i = 0; i<6; i++) {
            g2d.drawRect(j, 330, 20, 20);
            if(i==4){
             g2d.setColor(Color.YELLOW);
           	 g2d.fillRect(j+1, 331, 19, 19);
           	 g2d.setColor(Color.BLACK);
            }
            j = j+20;
       }
        j=520;
        for(int i = 0; i<6; i++) {
            g2d.drawRect(j, 290, 20, 20);
            if(i==4){
             g2d.setColor(Color.RED);
           	 g2d.fillRect(j+1, 291, 19, 19);
           	 g2d.setColor(Color.BLACK);
            }
            j = j-20;
       }
        j=520;
        for(int i = 0; i<6; i++) {
            g2d.drawRect(j, 310, 20, 20);
            if(i<=4){
            g2d.setColor(Color.RED);
           	g2d.fillRect(j+1, 311, 19, 19);
           	g2d.setColor(Color.BLACK);
            }
            j = j-20;
       }
        j=520;
        g2d.setColor(Color.BLACK);
        for(int i = 0; i<6; i++) {
             g2d.drawRect(j, 330, 20, 20);
             if(i==4){
            	 g2d.fillRect(j+1, 331, 19, 19);
             }
             j = j-20;
        }
        j=350;
        g2d.setColor(Color.BLACK);
        for(int i = 0; i<6; i++) {
             g2d.drawRect(580, j, 20, 20);
             if(i==4){
            	 g2d.fillRect(581, j+1, 19, 19);
             }
             j = j+20;
        }
        j=350;
        for(int i = 0; i<6; i++) {
            g2d.drawRect(560, j, 20, 20);
            if(i<=4){
            g2d.setColor(Color.BLUE);
           	g2d.fillRect(561, j+1, 19, 19);
           	g2d.setColor(Color.BLACK);
            }
            j = j+20;
       }
        j=350;
        for(int i = 0; i<6; i++) {
            g2d.drawRect(540, j, 20, 20);
            if(i==4){
             g2d.setColor(Color.BLUE);
           	 g2d.fillRect(541, j+1, 19, 19);
           	 g2d.setColor(Color.BLACK);
            }
            j = j+20;
       }
        j=270;
        g2d.setColor(Color.BLACK);
        for(int i = 0; i<6; i++) {
             g2d.drawRect(540, j, 20, 20);
             if(i==4){
            	 g2d.fillRect(541, j+1, 19, 19);
             }
             j = j-20;
        }
        j=270;
        for(int i = 0; i<6; i++) {
            g2d.drawRect(560, j, 20, 20);
            if(i<=4){
            g2d.setColor(Color.GREEN);
           	g2d.fillRect(561, j+1, 19, 19);
           	g2d.setColor(Color.BLACK);
            }
            j = j-20;
       }
        j=270;
        for(int i = 0; i<6; i++) {
            g2d.drawRect(580, j, 20, 20);
            if(i==4){
             g2d.setColor(Color.GREEN);
           	 g2d.fillRect(581, j+1, 19, 19);
           	 g2d.setColor(Color.BLACK);
            }
            j = j-20;
       }
        g2d.setColor(Color.BLUE);
        g2d.fillRect(420, 351, 120, 120);
        g2d.setColor(Color.RED);
        g2d.fillRect(420, 170, 120, 120);
        g2d.setColor(Color.GREEN);
        g2d.fillRect(601, 170, 120, 120);
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(601, 351, 120, 120);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(420, 170, 300, 300);
        //
        g2d.setColor(Color.GREEN);
        g2d.fillRect(440, 190, 80, 80);
        g2d.setColor(Color.RED);
        g2d.fillRect(445, 195, 70, 70);
        //180
        g2d.setColor(Color.RED);
        g2d.fillRect(440, 371, 80, 80);
        g2d.setColor(Color.BLUE);
        g2d.fillRect(445, 376, 70, 70);
        //
        g2d.setColor(Color.BLUE);
        g2d.fillRect(620, 371, 80, 80);
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(625, 376, 70, 70);
        //
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(620, 190, 80, 80);
        g2d.setColor(Color.GREEN);
        g2d.fillRect(625, 195, 70, 70);
        //
        
        g2d.setColor(Color.WHITE);
        
        //
        g2d.fillOval(450, 200, 20, 20);
        g2d.fillOval(490, 200, 20, 20);
        g2d.fillOval(450, 240, 20, 20);
        g2d.fillOval(490, 240, 20, 20);
        //
        g2d.fillOval(450, 381, 20, 20);
        g2d.fillOval(490, 381, 20, 20);
        g2d.fillOval(450, 421, 20, 20);
        g2d.fillOval(490, 421, 20, 20);
        //
        g2d.fillOval(630, 381, 20, 20);
        g2d.fillOval(670, 381, 20, 20);
        g2d.fillOval(630, 421, 20, 20);
        g2d.fillOval(670, 421, 20, 20);
        //
        g2d.fillOval(630, 200, 20, 20);
        g2d.fillOval(670, 200, 20, 20);
        g2d.fillOval(630, 240, 20, 20);
        g2d.fillOval(670, 240, 20, 20);
        //
        g2d.setColor(Color.BLACK);
        //
        g2d.drawOval(450, 200, 20, 20);
        g2d.drawOval(490, 200, 20, 20);
        g2d.drawOval(450, 240, 20, 20);
        g2d.drawOval(490, 240, 20, 20);
        //
        g2d.drawOval(450, 381, 20, 20);
        g2d.drawOval(490, 381, 20, 20);
        g2d.drawOval(450, 421, 20, 20);
        g2d.drawOval(490, 421, 20, 20);
        //
        g2d.drawOval(630, 381, 20, 20);
        g2d.drawOval(670, 381, 20, 20);
        g2d.drawOval(630, 421, 20, 20);
        g2d.drawOval(670, 421, 20, 20);
        //
        g2d.drawOval(630, 200, 20, 20);
        g2d.drawOval(670, 200, 20, 20);
        g2d.drawOval(630, 240, 20, 20);
        g2d.drawOval(670, 240, 20, 20);
        //
        int[] xPoints = {570, 600, 600}; // coordenadas X dos vértices
        int[] yPoints = {320, 290, 351}; // coordenadas Y dos vértices
        g2d.setColor(Color.YELLOW);
        g2d.fillPolygon(xPoints, yPoints, 3);
        //
        int[] xPoints1 = {570, 540, 540}; // coordenadas X dos vértices
        int[] yPoints1 = {320, 290, 350}; // coordenadas Y dos vértices
        g2d.setColor(Color.RED);
        g2d.fillPolygon(xPoints1, yPoints1, 3);
        //
        int[] xPoints2 = {570, 600, 540}; // coordenadas X dos vértices
        int[] yPoints2 = {320, 350, 350}; // coordenadas Y dos vértices
        g2d.setColor(Color.BLUE);
        g2d.fillPolygon(xPoints2, yPoints2, 3);
        
    }
    

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo Desenho");
        frame.add(new TabuleiroV());
        frame.setSize(1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
