package model;

import java.util.Vector;

class Jogador {
    private final Cor cor;
    private Vector<Peca> pecas = new Vector<Peca>();
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
        //Inicializa a primeira posicao da peca na casa inicial da cor
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
    public Cor getCor() {
        return cor;
    }

}
