package view;
import javax.swing.*;
import java.awt.*;
import controller.MouseListener;
import controller.TabuleiroObservador;
public class GameScene extends JFrame{// implements TabuleiroObservador{
	public final int xScreen = 867;
    public final int yScreen = 656;
    private Tabuleiro tabuleiro;
    //private TabuleiroObservador observer;
    private Menu gameMenu;

    public GameScene(){
        //this.observer = this;
        gerarPainel();
    }
    public void gerarPainel() {
        this.gameMenu = new Menu();
        this.tabuleiro = new Tabuleiro();
        tabuleiro.addMouseListener(new MouseListener());
        //tabulerioPanel.setPreferredSize(new Dimension(600, 600));

        setTitle("Ludo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(xScreen, yScreen);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        //JPanel boardPanel = boardBuilder.getBoardPanel();
        JPanel menuPanel = gameMenu.getMenuPanel();
        contentPane.add(tabuleiro);
        contentPane.add(menuPanel, BorderLayout.EAST);
    
        setVisible(true);
        
    }

    public void redraw(){
        repaint();
    }

    

    public Tabuleiro getTabuleiro(){
        return this.tabuleiro;
    }

    
    

    // public static void main(String[] args) {
    //     GameScene frame = new GameScene();
    //     while(true){
    //         frame.redraw();
    //     }
    // }
    
}