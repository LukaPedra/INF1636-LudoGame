package view;
import javax.swing.*;
import java.awt.*;
import controller.MouseListener;
public class GameScene extends JFrame{
	public final int xScreen = 867;
    public final int yScreen = 656;
    private TabulerioPanel tabulerioPanel;
    private Menu gameMenu;

    public GameScene() {
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

    public static void main(String[] args) {
        GameScene frame = new GameScene();
        while(true){
            frame.redraw();
        }
    }
}