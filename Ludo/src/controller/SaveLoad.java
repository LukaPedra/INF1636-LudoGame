package controller;
import java.io.*;
import java.util.*;

public class SaveLoad {
    public void Save(int[][] vec){
        try{
            FileWriter file = new FileWriter("saveLudo.txt");
            BufferedWriter escrita = new BufferedWriter(file);
            for(int i = 0; i<4; i++){
                for(int j = 0; j<4; j++){
                    escrita.write(String.valueOf(vec[i][j])+" ");
                    escrita.flush();
                }
                escrita.newLine();
            }
            escrita.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public int[][] load(){
        int[][] vet = new int[4][4];
        try{
        
        File arq = new File("saveLudo.txt");
        Scanner carregar = new Scanner(arq);
            String linha;
            for(int i = 0;i<4;i++){
                for(int j = 0;j<4;j++){
                    if(carregar.hasNext()){
                        linha = carregar.next();
                        vet[i][j] = Integer.parseInt(linha);
                        //System.out.println(linha);
                    }
                }
            }
            carregar.close();
            
          
            

        } catch(IOException e){

            e.printStackTrace();
        }
        return vet;
    }
}

/*     public static void main(String[] args){
        
        int [][]vet= new int[4][4];
       // vet=load();
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.println(vet[i][j]);
            }
        }
    }
}*/
