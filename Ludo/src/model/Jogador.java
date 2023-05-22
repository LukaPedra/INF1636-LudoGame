package model;

import java.util.Vector;

class Jogador {
    private final Cor cor;
    private Vector<Peca> pecas = new Vector<Peca>();
    private Peca lastPeca;
    private int seis;
    
    
    public Jogador(Tabuleiro t, Cor cor) {
        this.cor = cor;
        InicializaPeca(t);
        seis = 0;
    }

    private void InicializaPeca(Tabuleiro t){ // Colocar as peças no vetor de peças do jogador
        int size = 4;
        Peca peca;
        for (int i = 0; i < size; i++) {
            peca = new Peca(this);
            pecas.add(peca);
        }
        
        pecas.get(0).setPosition(t.getCasaInicial(cor));
        t.getTabuleiro().get(t.getCasaInicial(cor)).parouCasa(pecas.get(0));
    }

    public boolean podeJogar(){
		if (seis == 3){
			seis = 0;
			return false;
		}
		return true;
	}

    public void moverPeca(Tabuleiro t, int i, int nCasas){
        Peca currentP = this.getPeca(i);
        currentP.moverPeca(this, t, nCasas);
        this.setLastPeca(currentP);
        
    }

    public Vector<Peca> pecasDisponiveis(Tabuleiro t, int nCasas){
        Vector<Peca> pecasDisponiveis = new Vector<Peca>();
        for (Peca peca : pecas){
            if (peca.podeMover(this, t, nCasas)){
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

    public void addSeis(){
        this.seis += 1;
    }

    public Peca getPeca(int i){
        return pecas.get(i);
    }

    public Vector<Peca> getPecas(){
        return pecas;
    }  

    public Cor getCor() {
        return cor;
    }

    public void setLastPeca(Peca p){
        this.lastPeca = p;
    }

    public Peca getLastPeca(Peca p){
        return lastPeca;
    }
}


