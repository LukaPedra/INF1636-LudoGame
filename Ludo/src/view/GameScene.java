package view;
import javax.swing.*;
import java.awt.*;
import controller.MouseListener;
import controller.TabuleiroObservador;
public class GameScene extends JFrame implements TabuleiroObservador{
	public final int xScreen = 867;
    public final int yScreen = 656;
    private TabulerioPanel tabulerioPanel;
    private TabuleiroObservador observer;
    private Menu gameMenu;

    public GameScene(){
        this.observer = this;
        gerarPainelTabuleiro();
    }
    public void gerarPainelTabuleiro() {
        this.gameMenu = new Menu();
        this.tabulerioPanel = new TabulerioPanel();
        tabulerioPanel.addMouseListener(new MouseListener());
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
        contentPane.add(tabulerioPanel);
        contentPane.add(menuPanel, BorderLayout.EAST);

        setVisible(true);
        
    }

    public void redraw(){
        repaint();
    }
    public TabuleiroObservador getObserver(){
        return this.observer;
    }
    @Override
    public void notify() {
        // TODO Auto-generated method stub
        this.redraw();
    }
    

    public static void main(String[] args) {
        GameScene frame = new GameScene();
        while(true){
            frame.redraw();
        }
    }
    
}