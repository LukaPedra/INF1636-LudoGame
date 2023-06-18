package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.ModelFacade;

public class Menu {
	private File file;
	private JPanel menuPanel;
	private Image fotoDado;
	private File lastFile;
	private int dadoValue = 1;
	private Color CorAtual = Color.GREEN;
	private String numDadoTeste[] = {"Random","1","2","3","4","5","6"};
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

		menuPanel.add(escolhaNumPopUp());
		menuPanel.add(novoJogoButton());
		menuPanel.add(carregarJogoButton());
		menuPanel.add(salvarJogoButton());
		menuPanel.add(dadoButton());
		menuPanel.add(textLabel("Á jogar"));
	}
	public JComboBox escolhaNumPopUp(){
		JComboBox cb = new JComboBox(numDadoTeste);
		cb.setBounds(70, 520, 120, 20);
		cb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				String numDado = (String)cb.getSelectedItem();
				model.setValorDado(numDado);
			}
		});
		return cb;
	}
	public JButton dadoButton() {
		JButton dadoButton = new JButton("Dado");
        dadoButton.setBounds(25, 450, 200, 50);

		dadoButton.addActionListener(e -> {
			if(model.getcanRollAgain()){
				model.roll();
				fotoDado = Dado.getDieImage(model.getResultado());
				System.out.println("Dado" + model.getResultado());
				CorAtual = model.getCor();
				model.setcanRollAgain(false);
			}
			
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
			fotoDado = Dado.getDieImage(dadoValue);
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
					int[][] aux = readMatrixFromFile(lastFile);
					printMatrix(aux);
					model.setPosicaoPecas(aux);
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

				int[][] aux = model.getPosicaoPecas();
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showSaveDialog(null); //save game
				if (result == JFileChooser.APPROVE_OPTION) {
					file = fileChooser.getSelectedFile();
					try{
						FileWriter escrita = new FileWriter(file);
						for(int i = 0; i<4; i++){
                			for(int j = 0; j<4; j++){
                    			escrita.write(String.valueOf(aux[i][j])+" ");
                    			
               				}
                			escrita.write("\n");
           				}
						escrita.close();

					} catch(IOException e1){

					}
				}
			}
		});
		return button;
	}
	public static int[][] readMatrixFromFile(File file) {
        int[][] matrix = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int rowCount = 0;
            while ((line = br.readLine()) != null) {
                String[] numbers = line.trim().split("\\s+");
                if (matrix == null) {
                    matrix = new int[numbers.length][];
                }

                matrix[rowCount] = new int[numbers.length];
                for (int i = 0; i < numbers.length; i++) {
                    matrix[rowCount][i] = Integer.parseInt(numbers[i]);
                }

                rowCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matrix;
    }
	public static void printMatrix(int[][] matrix) {
        if (matrix != null) {
            for (int[] row : matrix) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
	public JPanel getMenuPanel() {
		return menuPanel;
	}

}
