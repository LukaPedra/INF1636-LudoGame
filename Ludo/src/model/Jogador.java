package model;

import java.util.Vector;

class Jogador {
    private final Cor cor;
    private Vector<Peca> pecas;
    private static Tabuleiro tabuleiro;
    public Jogador(Cor cor) {
        this.cor = cor;
        InicializaPeca();

    }
    private void InicializaPeca(){
        int size = 4;
        Peca peca;
        for (int i = 0; i < size; i++) {
            peca = new Peca(this);
            pecas.add(peca);
        }
    }
    public void moverPeca(int i, int nCasas){
        pecas.get(i).moverPeca(nCasas);
    }
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
    public Cor getCor() {
        return cor;
    }

}
