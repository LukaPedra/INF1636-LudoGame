package view;
import model.ModelFacade;
import java.awt.*;


public class Pecas {
	private ModelFacade modelFacade = ModelFacade.getFacade();
	final int tabuleiro_tam = 600;
	final int casaSize = 40;
	int tam = 20;

	public void draw(Graphics2D g2d) {
		
		int[][] posicaoPecas = modelFacade.posicaoPecas();

		for (int i = 0; i < 4; i++){
			System.out.println(posicaoPecas[i][0] + " " + posicaoPecas[i][1] + " " + posicaoPecas[i][2] + " " + posicaoPecas[i][3] + "\n");
			switch (i) {
				case 0:
					drawPecas(g2d, posicaoPecas[i], Color.GREEN);
					break;
				case 1:
					drawPecas(g2d, posicaoPecas[i], Color.YELLOW);
					break;
				case 2:
					drawPecas(g2d, posicaoPecas[i], Color.BLUE);
					break;
				case 3:
					drawPecas(g2d, posicaoPecas[i], Color.RED);
					break;
			}
		}	
	}
	
	private void drawPecas(Graphics2D g2d, int[] pos, Color cor){
		int qtdPosInicial = 0;
		for (int i = 0; i < 4; i++){
			if (pos[i] == -1){
                qtdPosInicial++;
            }
			
			Point coords = this.getCoordinates(pos[i], cor, qtdPosInicial);

			g2d.setColor(cor);
			g2d.fillOval(coords.x, coords.y, tam, tam);
			g2d.setColor(Color.BLACK);
			g2d.drawOval(coords.x, coords.y, tam, tam);

		}
		
    }

	private Point getCoordinates(int pos, Color cor, int qtdPosInicial){
        Point coords = new Point();
		if (pos == -1) {
			if (cor == Color.GREEN){
				if (qtdPosInicial > 0){
					coords.x = 430;
					coords.y = 90;
					if(qtdPosInicial > 1){
						coords.x = 510;
						coords.y = 90;
					}
					if(qtdPosInicial > 2){
						System.out.println("Entrou aqui");
						coords.x = 430;
						coords.y = 170;
					}
					if(qtdPosInicial > 3){
						coords.x = 510;
						coords.y = 170;
					}
				}
				
			}
			else if (cor == Color.YELLOW){
				if (qtdPosInicial > 0){
					coords.x = 430;
					coords.y = 450;
					if(qtdPosInicial > 1){
						coords.x = 510;
						coords.y = 450;
					}
					if(qtdPosInicial > 2){
						coords.x = 430;
						coords.y = 530;
					}
					if(qtdPosInicial > 3){
						coords.x = 510;
						coords.y = 530;
					}
				}
			}
			else if (cor == Color.BLUE){
				if (qtdPosInicial > 0){
					coords.x = 70;
					coords.y = 450;
					if(qtdPosInicial > 1){
						coords.x = 150;
						coords.y = 450;
					}
					if(qtdPosInicial > 2){
						coords.x = 70;
						coords.y = 530;
					}
					if(qtdPosInicial > 3){
						coords.x = 150;
						coords.y = 530;
					}
				}
			}
			else if (cor == Color.RED){
				if (qtdPosInicial > 0){
					coords.x = 70;
					coords.y = 90;
					if(qtdPosInicial > 1){
						coords.x = 150;
						coords.y = 90;
					}
					if(qtdPosInicial > 2){
						coords.x = 70;
						coords.y = 170;
					}
					if(qtdPosInicial > 3){
						coords.x = 150;
						coords.y = 170;
					}
				}
			}
			return coords;
		}
        else if (pos >= 0 && pos <= 4){
            coords.x = casaSize * 8;
            coords.y = casaSize + casaSize * pos;
        } else if (pos >= 5 && pos <= 10){
            coords.x = casaSize * 9 + casaSize * (pos - 5);
            coords.y = casaSize * 6;
        } else if (pos == 11){
            coords.x = casaSize * 14;
            coords.y = casaSize * 7;
        } else if (pos >= 12 && pos <= 17){
            coords.x = casaSize * 9 - casaSize * (pos - 17);
            coords.y = casaSize * 8;
        } else if (pos >= 18 && pos <= 23){
            coords.x = casaSize * 8;
            coords.y = casaSize * 9 + casaSize * (pos - 18);
        } else if (pos == 24){
            coords.x = casaSize * 7;
            coords.y = casaSize * 14;
        } else if (pos >= 25 && pos <= 30){
            coords.x = casaSize * 6;
            coords.y = casaSize * 9 - casaSize * (pos - 30);
        } else if (pos >= 31 && pos <= 36){
            coords.x = casaSize * 5 - casaSize * (pos - 31);
            coords.y = casaSize * 8;
        } else if (pos == 37){
            coords.x = 0;
            coords.y = casaSize * 7;
        } else if (pos >= 38 && pos <= 43){
            coords.x = 0 + casaSize * (pos - 38);
            coords.y = casaSize * 6;
        } else if (pos >= 44 && pos <= 49){
            coords.x = casaSize * 6;
            coords.y = casaSize * 5 - casaSize * (pos - 44);
        } else if (pos >= 50 && pos <= 51){
            coords.x = casaSize * 6 + casaSize * (pos - 49);
            coords.y = 0;
        } else if (pos >= 100 && pos <= 105) {
            coords.x = casaSize * 7;
            coords.y = casaSize + casaSize * (pos - 100);
        } else if (pos >= 200 && pos <= 205) {
            coords.x = casaSize * 8 - casaSize * (pos - 205);
            coords.y = casaSize * 7;
        } else if (pos >= 400 && pos <= 405) {
            coords.x = casaSize + casaSize * (pos - 400);
            coords.y = casaSize * 7;
        } else if (pos >= 300 && pos <= 305) {
            coords.x = casaSize * 7;
            coords.y = casaSize * 8 - casaSize * (pos - 305);
        }
		coords.y += 30; 
		coords.x += 10;
        return coords;
    }
}
