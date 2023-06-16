package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.TabuleiroObservador;

public class Tabuleiro extends JPanel implements TabuleiroObservador{
     private Pecas pecas = new Pecas();
     private TabuleiroObservador observer;
     private ViewFacade facade = ViewFacade.getFacade();
     @Override
     public void paintComponent(Graphics g) {
          Graphics2D g2d = (Graphics2D) g;
          int j = 360;
          super.paintComponent(g);

          
          
          g2d.setColor(Color.GREEN);
          g2d.fillRect(240, 260, 120, 120);
          
          g2d.setColor(Color.BLACK);
          for(int i = 0; i<6; i++) {
               g2d.drawRect(j, 260, 40, 40);
               if(i==4){
                    g2d.fillRect(j, 260, 40, 40);
               }
               j = j+40;
          }
          j=360;
          for(int i = 0; i<6; i++) {
               if(i<=4){
                    g2d.setColor(Color.YELLOW);
                    g2d.fillRect(j, 300, 40, 40);
                    g2d.setColor(Color.BLACK);
               }
               g2d.drawRect(j, 300, 40, 40);
               j = j+40;
          }
          j=360;
          for(int i = 0; i<6; i++) {
               if(i==4){
                    g2d.setColor(Color.YELLOW);
                    g2d.fillRect(j, 340, 40, 40);
                    g2d.setColor(Color.BLACK);
               }
               g2d.drawRect(j, 340, 40, 40);
               j = j+40;
          }
          j=200;
          for(int i = 0; i<6; i++) {
               g2d.drawRect(j, 260, 40, 40);
               if(i==4){
                    g2d.setColor(Color.RED);
                    g2d.fillRect(j, 260, 40, 40);
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(j, 260, 40, 40);
               }
               j = j-40;
          }
          j=200;
          for(int i = 0; i<6; i++) {
               
               if(i<=4){
                    g2d.setColor(Color.RED);
                    g2d.fillRect(j, 300, 40, 40);
                    g2d.setColor(Color.BLACK);
               }
               g2d.drawRect(j, 300, 40, 40);
               j = j-40;
          }
          j=200;
          g2d.setColor(Color.BLACK);
          for(int i = 0; i<6; i++) {
               g2d.drawRect(j, 340, 40, 40);
               if(i==4){
                    g2d.fillRect(j, 340, 40, 40);
               }
               j = j-40;
          }
          j=380;
          g2d.setColor(Color.BLACK);
          for(int i = 0; i<6; i++) {
               g2d.drawRect(320, j, 40, 40);
               if(i==4){
                    g2d.fillRect(320, j, 40, 40);
               }
               j = j+40;
          }
          j=380;
          for(int i = 0; i<6; i++) {
               if(i<=4){
                    g2d.setColor(Color.BLUE);
                    g2d.fillRect(280, j, 40, 40);
                    g2d.setColor(Color.BLACK);
               }
               g2d.drawRect(280, j, 40, 40);
               j = j+40;
          }
          j=380;
          for(int i = 0; i<6; i++) {
               g2d.drawRect(240, j, 40, 40);
               if(i==4){
                    g2d.setColor(Color.BLUE);
                    g2d.fillRect(240, j, 40, 40);
                    g2d.setColor(Color.BLACK);
               }
               
               j = j+40;
          }
          j=220;
          g2d.setColor(Color.BLACK);
          for(int i = 0; i<6; i++) {
               g2d.drawRect(240, j, 40, 40);
               if(i==4){
                    g2d.fillRect(240, j, 40, 40);
               }
               j = j-40;
          }
          j=220;
          for(int i = 0; i<6; i++) {
               
               if(i<=4){
                    g2d.setColor(Color.GREEN);
                    g2d.fillRect(280, j, 40, 40);
                    g2d.setColor(Color.BLACK);
               }
               g2d.drawRect(280, j, 40, 40);
               j = j-40;
          }
          j=220;
          for(int i = 0; i<6; i++) {
               g2d.drawRect(320, j, 40, 40);
               if(i==4){
                    g2d.setColor(Color.GREEN);
                    g2d.fillRect(320, j, 40, 40);
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(320, j, 40, 40);
               }
               j = j-40;
          }
          g2d.setColor(Color.BLUE);
          g2d.fillRect(0, 380, 240, 240);
          g2d.setColor(Color.BLACK);
          g2d.drawRect(0, 380, 240, 240);
          g2d.setColor(Color.RED);
          g2d.fillRect(0, 20, 240, 240);
          g2d.setColor(Color.BLACK);
          g2d.drawRect(0, 20, 240, 240);
          g2d.setColor(Color.GREEN);
          g2d.fillRect(360, 20, 240, 240);
          g2d.setColor(Color.BLACK);
          g2d.drawRect(360, 20, 240, 240);
          g2d.setColor(Color.YELLOW);
          g2d.fillRect(360, 380, 240, 240);
          g2d.setColor(Color.BLACK);
          g2d.drawRect(360, 380, 240, 240);
          g2d.drawRect(0, 20, 600, 600);
          // 
          g2d.setColor(Color.GREEN);
          g2d.fillRect(40, 60, 160, 160);
          g2d.setColor(Color.RED);
          g2d.fillRect(50, 70, 140, 140);
          //
          g2d.setColor(Color.RED);
          g2d.fillRect(40, 420, 160, 160);
          g2d.setColor(Color.BLUE);
          g2d.fillRect(50, 430, 140, 140);
          //
          g2d.setColor(Color.BLUE);
          g2d.fillRect(400, 420, 160, 160);
          g2d.setColor(Color.YELLOW);
          g2d.fillRect(410, 430, 140, 140);
          //
          g2d.setColor(Color.YELLOW);
          g2d.fillRect(400, 60, 160, 160);
          g2d.setColor(Color.GREEN);
          g2d.fillRect(410, 70, 140, 140);
          //
          
          g2d.setColor(Color.WHITE);
          
          // Desenha um círculo preenchido
          g2d.fillOval(60, 80, 40, 40);
          g2d.fillOval(140, 80, 40, 40);
          g2d.fillOval(60, 160, 40, 40);
          g2d.fillOval(140, 160, 40, 40);
          //
          g2d.fillOval(60, 440, 40, 40);
          g2d.fillOval(140, 440, 40, 40);
          g2d.fillOval(60, 520, 40, 40);
          g2d.fillOval(140, 520, 40, 40);
          //
          g2d.fillOval(420, 440, 40, 40);
          g2d.fillOval(500, 440, 40, 40);
          g2d.fillOval(420, 520, 40, 40);
          g2d.fillOval(500, 520, 40, 40);
          //
          g2d.fillOval(420, 80, 40, 40);
          g2d.fillOval(500, 80, 40, 40);
          g2d.fillOval(420, 160, 40, 40);
          g2d.fillOval(500, 160, 40, 40);
          //
          g2d.setColor(Color.BLACK);
          //
          g2d.drawOval(60, 80, 40, 40);
          g2d.drawOval(140, 80, 40, 40);
          g2d.drawOval(60, 160, 40, 40);
          g2d.drawOval(140, 160, 40, 40);
          //
          g2d.drawOval(60, 440, 40, 40);
          g2d.drawOval(140, 440, 40, 40);
          g2d.drawOval(60, 520, 40, 40);
          g2d.drawOval(140, 520, 40, 40);
          //
          g2d.drawOval(420, 440, 40, 40);
          g2d.drawOval(500, 440, 40, 40);
          g2d.drawOval(420, 520, 40, 40);
          g2d.drawOval(500, 520, 40, 40);
          //
          g2d.drawOval(420, 80, 40, 40);
          g2d.drawOval(500, 80, 40, 40);
          g2d.drawOval(420, 160, 40, 40);
          g2d.drawOval(500, 160, 40, 40);
          //
          int[] xPoints = {300, 360, 360}; // coordenadas X dos vértices
          int[] yPoints = {320, 260, 380}; // coordenadas Y dos vértices
          
          // 
          g2d.setColor(Color.YELLOW);
          g2d.fillPolygon(xPoints, yPoints, 3);
          g2d.setColor(Color.BLACK);
          g2d.drawPolygon(xPoints, yPoints, 3);
          
          int[] xPoints1 = {300, 240, 240}; // coordenadas X dos vértices
          int[] yPoints1 = {320, 260, 380}; // coordenadas Y dos vértices
          g2d.setColor(Color.RED);
          g2d.fillPolygon(xPoints1, yPoints1, 3);
          g2d.setColor(Color.BLACK);
          g2d.drawPolygon(xPoints1, yPoints1, 3);
          //
          int[] xPoints2 = {300, 360, 240}; // coordenadas X dos vértices
          int[] yPoints2 = {320, 380, 380}; // coordenadas Y dos vértices
          g2d.setColor(Color.BLUE);
          g2d.fillPolygon(xPoints2, yPoints2, 3);
          g2d.setColor(Color.BLACK);
          g2d.drawPolygon(xPoints2, yPoints2, 3);
          pecas.draw(g2d);
          
     }
     public TabuleiroObservador getTabuleiroObservador(){
          return observer;
     }
     @Override
     public void update() {
          System.out.println("update!");
          // TODO Auto-generated method stub
          //this.redraw();
          facade.redraw();
     }
     
     
     public static void main(String[] args) {
          JFrame frame = new JFrame("Exemplo Desenho");
          frame.setResizable(false);
          
          Tabuleiro tabuleiro = new Tabuleiro();
          tabuleiro.setBounds(10, 10, 1200, 700);
          frame.add(new Tabuleiro());
          frame.setSize(1200, 700);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setVisible(true);
     }
}
