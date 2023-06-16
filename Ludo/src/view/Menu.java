package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import model.ModelFacade;

public class Menu {
	private File file;
	private JPanel menuPanel;
	private Image fotoDado;
	private File lastFile;
	private int dadoValue = 1;
	private Color CorAtual = Color.BLUE;

	private ModelFacade model = ModelFacade.getFacade();
	

	public Menu() {
		createMenuPanel();
	}

	private void createMenuPanel() {
		menuPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setColor(CorAtual);
                g2d.fillRect(60,310,120,120);
                g2d.setColor(Color.GRAY);
                g2d.fillRect(70,320,100,100);
                
                
                g.drawImage(fotoDado, 70, 320, null);

			}
		};

		menuPanel.setPreferredSize(new Dimension(250, 630));
        menuPanel.setBackground(Color.GRAY);
        menuPanel.setLayout(null);


		menuPanel.add(novoJogoButton());
		menuPanel.add(carregarJogoButton());
		menuPanel.add(salvarJogoButton());
		menuPanel.add(dadoButton());
		menuPanel.add(textLabel("Á jogar"));
	}
	public JButton dadoButton() {
		JButton dadoButton = new JButton("Dado");
        dadoButton.setBounds(25, 450, 200, 50);

		dadoButton.addActionListener(e -> {
			model.roll();
			fotoDado = DadoImage.getDiceImage(model.getResultado());
			System.out.println("Dado" + model.getResultado());
		});
		return dadoButton;
	}
	public JLabel textLabel(String text) {
		JLabel textLabel = new JLabel(text);
		textLabel.setBounds(55, 220, 200, 50);
		return textLabel;
	}

	public JButton novoJogoButton(){
		JButton button = new JButton("Novo Jogo");
        button.setBounds(25, 20, 200, 50);
		button.addActionListener(e -> {
			fotoDado = DadoImage.getDiceImage(dadoValue);
			System.out.println("New Game pressed!");
		});
		return button;
	}
	
	public JButton carregarJogoButton(){
		JButton button = new JButton("Carregar Jogo");
		button.setBounds(25, 90, 200, 50);
		button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    lastFile = fileChooser.getSelectedFile();
                }
            }
        });
		return button;
	}
	public JButton salvarJogoButton(){
		JButton button = new JButton("Salvar Jogo");
		button.setBounds(25, 160, 200, 50);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					file = fileChooser.getSelectedFile();
				}
			}
		});
		return button;
	}
	public JPanel getMenuPanel() {
		return menuPanel;
	}

}
