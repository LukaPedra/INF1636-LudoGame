package view;
import javax.swing.*;
import java.awt.*;
public class GameScene extends JFrame{
	public final int xScreen = 850;
    public final int yScreen = 628;

    private TabulerioPanel boardBuilder;
    private Menu gameMenu;

    public GameScene() {
        this.gameMenu = new Menu();
        this.boardBuilder = new TabulerioPanel();


        setTitle("Ludo, O Jogo");
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
        contentPane.add(new TabulerioPanel());
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