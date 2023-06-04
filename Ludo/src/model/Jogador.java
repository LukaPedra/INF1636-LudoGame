package model;

import java.util.Vector;

class Jogador {
    private Cor cor;
    private int posIni;
    private Casa casaIni;
    private Vector<Peca> pecas = new Vector<Peca>();
    private Peca lastPeca;
    private boolean playing;
    private int seis;
    
    
    public Jogador(Tabuleiro t, Cor c) {
        this.cor = c;
        this.posIni = t.getPosicaoSaida(c);
        this.casaIni = t.getCasaSaida(c);
        this.pecas = inicializaPecas(t);
        this.playing = false;
        this.seis = 0;
    }

    private Vector<Peca> inicializaPecas(Tabuleiro t){ // Colocar as peças no vetor de peças do jogador
        int size = 4;
        Vector<Peca> pcs = new Vector<Peca>();
        Peca pc;
        for (int i = 0; i < size; i++) {
            pc = new Peca(this);
            pcs.add(pc);
        }
        
        pcs.get(0).setPosition(this.posIni);
        this.casaIni.parouCasa(pcs.get(0));

        return pcs;
    }

    public boolean podeJogar(Tabuleiro t){
		if (seis == 3){
			seis = 0;
            t.getCasa(lastPeca.getPosition()).saiuCasa(lastPeca);
			return false;
		}
		return true;
	}

    public void moverPeca(Tabuleiro t, int i, int nCasas){
        Peca currentP = this.getPeca(i);
        currentP.moverPeca(t, nCasas);
        this.setLastPeca(currentP);
        
    }

    public Vector<Peca> pecasDisponiveis(Tabuleiro t, int nCasas){
        Vector<Peca> pecasDisponiveis = new Vector<Peca>();
        
        if (podeJogar(t)){
            for (Peca peca : pecas){
                if (peca.podeMover(t, nCasas)){
                    pecasDisponiveis.add(peca);
                }
            }
        }
        
        return pecasDisponiveis;
    }

    public int somaEspacosAteFinal(int i){
        int soma = 0;
        for (Peca peca : pecas){
            soma =+ peca.casasFaltando();
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

    public int getPosIni(){
        return posIni;
    }

    public void setLastPeca(Peca p){
        this.lastPeca = p;
    }

    public Peca getLastPeca(){
        return lastPeca;
    }

    public void setPlaying(){
        this.playing = true;
    }
    
    public boolean getPlaying(){
        return playing;
    }
}


