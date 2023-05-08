package model;

import java.util.Vector;

class Jogador {
    private final Cor cor;
    private static Tabuleiro tabuleiro;
    private Tabuleiro tabuleiroFinal;
    private Vector<Peca> pecas = new Vector<Peca>();
    
    
    public Jogador(Cor cor, Tabuleiro tabuleiro) {
        this.cor = cor;
        Jogador.tabuleiro = tabuleiro;
        InicializaPeca();
    }
    public Jogador(Cor cor) {
        this.cor = cor;
        InicializaPeca();
    }

    private void InicializaPeca(){ // Colocar as peças no vetor de peças do jogador
        int size = 4;
        Peca peca;
        for (int i = 0; i < size; i++) {
            peca = new Peca(this);
            pecas.add(peca);
        }
        
        pecas.get(0).setPosition(tabuleiro.getCasaInicial(cor));
        tabuleiro.getTabuleiro().get(tabuleiro.getCasaInicial(cor)).parouCasa(pecas.get(0));
        
       
    }


    public void moverPeca(int i, int nCasas){
        pecas.get(i).moverPeca(nCasas);
    }

    public Vector<Peca> pecasDisponiveis(int nCasas){
        Vector<Peca> pecasDisponiveis = new Vector<Peca>();
        for (Peca peca : pecas){
            if (peca.podeMover(nCasas)){
                pecasDisponiveis.add(peca);
            }
        }
        return pecasDisponiveis;
    }

    public int somaEspacosAteFinal(int i){
        int soma = 0;
        for (Peca peca : pecas){
            soma =+ peca.casaFaltando();
        }
        return soma;
    }
    
    public Peca getPeca(int i){
        return pecas.get(i);
    }

    public static void setTabuleiro(Tabuleiro tabuleiro){
        Jogador.tabuleiro = tabuleiro;
    }
    public void setTabuleiroFinal(Tabuleiro tabuleiroFinal){
        this.tabuleiroFinal = tabuleiroFinal;
    }
    public Cor getCor() {
        return cor;
    }
    public Vector<Peca> getPecas(){
        return pecas;
    }
    public static Tabuleiro getTabuleiro(){
        return Jogador.tabuleiro;
    }
    public Tabuleiro getTabuleiroFinal(){
        return this.tabuleiroFinal;
    }
}


