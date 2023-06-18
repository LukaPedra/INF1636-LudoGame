package model;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;



public class TestCasa {
	Tabuleiro tabuleiro = new Tabuleiro();
	Jogador jogadorVerde = new Jogador(tabuleiro, Cor.VERDE);
	Jogador jogadorAzul = new Jogador(tabuleiro,Cor.AZUL);
	
	@Test
	public void casoPodeParar() {
		Casa casa = new Casa();
		Peca peca1 = new Peca(jogadorVerde);
		Peca peca2 = new Peca(jogadorAzul);

		assertTrue(casa.podeParar(peca1));
		
		casa.parouCasa(peca1);
		
		assertTrue(casa.podeParar(peca2));
		assertTrue(casa.podeParar(peca1));

		
		Peca peca11 = new Peca(jogadorVerde);
		
		casa.parouCasa(peca11);
		
		assertFalse(casa.podeParar(peca2));
		casa.saiuCasa(peca2);
		
		casa.setTipo(TipoCasa.SAIDA);
		
		Casa casaPartida = new Casa(TipoCasa.SAIDA, Cor.VERDE);
		casaPartida.parouCasa(peca1);
		
		assertFalse(casa.podeParar(peca11));
		
		Casa casaAbrigoCasa = new Casa();
		casaAbrigoCasa.setTipo(TipoCasa.ABRIGO);
		
		casaAbrigoCasa.parouCasa(peca1);
		casaAbrigoCasa.parouCasa(peca2);
		assertEquals(2, casaAbrigoCasa.getNumPecas());
		
		Casa casaComer = new Casa();
		casaComer.parouCasa(peca1);
		casaComer.parouCasa(peca2);
		assertEquals(1, casaComer.getNumPecas());
		
		
	}
	
	@Test
	public void TesteBarreira() {
		Casa casa = new Casa();
		Peca peca1 = new Peca(jogadorVerde);
		Peca peca11 = new Peca(jogadorVerde);
		
		casa.parouCasa(peca1);
		casa.parouCasa(peca11);
		assertTrue(casa.isBarreira());
	}
	
	@Test
	public void TesteCasaFinal() {
		Casa casaFinal = new Casa(TipoCasa.CASAFINAL, Cor.VERDE);
		assertTrue(casaFinal.isCasaFinal(jogadorVerde.getCor()));
	}
	@Test
	public void TesteConstrutor() {
		Casa casa = new Casa();
		assertTrue(casa.getTipo() == TipoCasa.COMUM);
		
		Casa casaAbrigo = new Casa();
		casaAbrigo.setTipo(TipoCasa.ABRIGO);
		
	}
	@Test
	public void TesteSaida() {
		Casa casa = new Casa();
		Peca peca1 = new Peca(jogadorVerde);
		Peca peca11 = new Peca(jogadorVerde);
		
		casa.parouCasa(peca1);
		casa.saiuCasa(peca1);
		assertEquals(0, casa.getNumPecas());
		
		casa.parouCasa(peca1);
		casa.parouCasa(peca11);
		casa.saiuCasa(peca1);
		assertEquals(1, casa.getNumPecas());
		
		//Caso de se 
	}
	@Test
	public void testearquivo(){
		
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

}
