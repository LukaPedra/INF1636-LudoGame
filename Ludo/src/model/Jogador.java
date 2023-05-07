package model;

import java.util.Vector;

class Jogador {
    private final Cor cor;
    private Vector<Peca> pecas;

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

    public Cor getCor() {
        return cor;
    }

}
