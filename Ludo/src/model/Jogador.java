package model;

import java.util.Vector;

class Jogador {
    private Cor cor;
    private int posIni;
    private Casa casaIni;
    private Vector<Peca> pecas = new Vector<Peca>();
    private Peca lastPeca;
    private int seis;
    
    
    public Jogador(Tabuleiro t, Cor c) {
        this.cor = c;
        this.posIni = t.getPosicaoSaida(c);
        this.casaIni = t.getCasaSaida(c);
        this.pecas = inicializaPecas(t);
        this.lastPeca = this.getPeca(0);
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

    public boolean podeJogar(Tabuleiro t, int nCasas){
        /* Se tirar 6 no dado */
        if (nCasas == 6){ 
            this.seis += 1;

            /* Se já tirou 6 3 vezes */
            if (this.seis == 3){
                t.getCasa(lastPeca.getPosition()).saiuCasa(lastPeca); // Mudar para voltar para casa inicial
                lastPeca.backToStart();

                this.seis = 0;

                return false;
            }
        }

        /* Se não puder jogar com nenhuma peça */
        if (pecasDisponiveis(t, nCasas).size() == 0){
            this.seis = 0;

            return false;
        }

		return true;
	}

    public void moverPeca(Tabuleiro t, int i, int nCasas){
        Peca currentP = this.getPeca(i);
        currentP.moverPeca(t, nCasas);
        this.lastPeca = currentP;
    }

    public Vector<Peca> pecasDisponiveis(Tabuleiro t, int nCasas){
        Vector<Peca> pecasDisponiveis = new Vector<Peca>();
        
        for (Peca peca : pecas){
            if (peca.podeMover(t, nCasas)){
                pecasDisponiveis.add(peca);
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
    public int[] getPosicoes(){
        int[] posicoes = new int[4];
        for (int i = 0; i < 4; i++){
            posicoes[i] = pecas.get(i).getPosition();
        }
        return posicoes;
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

    public int getPosInicial(){
        return posIni;
    }
    
    public void setLastPeca(Peca p){
        this.lastPeca = p;
    }

    public Peca getLastPeca(){
        return lastPeca;
    }

    public boolean isWinner(){
        for (Peca peca : pecas){
            if (!peca.isWinner()){
                return false;
            }
        }
        return true;
    }

    
}


