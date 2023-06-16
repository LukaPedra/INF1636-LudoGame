package model;

import java.util.Vector;

class Jogador {
    private Cor cor;
    private int posIni;
    private Casa casaIni;
    private Vector<Peca> pecas = new Vector<Peca>();
    private Vector<Peca> pecasDisp;
    private Peca lastPeca;
    private int seis;
    
    
    public Jogador(Tabuleiro t, Cor c) {
        this.cor = c;
        this.posIni = t.getPosicaoSaida(c);
        this.casaIni = t.getCasaSaida(c);
        this.pecas = inicializaPecas();
        this.pecasDisp = new Vector<Peca>();
        this.lastPeca = this.getPeca(0);
        this.seis = 0;
    }

    private Vector<Peca> inicializaPecas(){ // Colocar as peças no vetor de peças do jogador
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
        this.pecasDisponiveis(t, nCasas);

        /* Se já tirou 6 3 vezes */
        if (this.seis == 2){
            this.seis = 0;

            this.lastPeca.backToStart(t.getCasa(lastPeca.getPosition()));

            return false;
        }

        /* Se não puder jogar com nenhuma peça */
        
        if (this.pecasDisp.size() == 0){
            this.seis = 0;

            return false;
        }
        
		return true;
	}

    public void moverPeca(Tabuleiro t, int i, int nCasas){
        Peca currentPeca = this.getPecaDisponivel(i);
        currentPeca.moverPeca(t, nCasas);
        this.lastPeca = currentPeca;
    }

    public void pecasDisponiveis(Tabuleiro t, int nCasas){
        for (Peca peca : this.pecas){
            if (peca.podeMover(t, nCasas)){
                this.pecasDisp.add(peca);
            }
        }
    }

    public Vector<Peca> getPecasDisponiveis(){
        return this.pecasDisp;
    }

    public Peca getPecaDisponivel(int i){
        return this.pecasDisp.get(i);
    }

    public Peca getPeca(int i){
        return pecas.get(i);
    }

    public Vector<Peca> getPecas(){
        return pecas;
    }

    public void setLastPeca(Peca p){
        this.lastPeca = p;
    }

    public Peca getLastPeca(){
        return lastPeca;
    }

    public Cor getCor() {
        return cor;
    }

    public int getPosInicial(){
        return posIni;
    }

    public int somaEspacosAteFinal(int i){
        int soma = 0;
        for (Peca peca : pecas){
            soma =+ peca.casasFaltando();
        }
        return soma;
    }
    
    public int getNumPecasSpawn(){
        int num = 0;
        for (Peca peca : pecas){
            if (peca.getPosition() == -1){
                num++;
            }
        }
        return num;
    }
    public int[] getPosicoes(){
        int[] posicoes = new int[4];
        for (int i = 0; i < 4; i++){
            posicoes[i] = pecas.get(i).getPosition();
        }
        return posicoes;
    }

    public void addSeis(){
        seis += 1;
    }

    public void setSeis(int n){
        seis = n;
    }

    public int getSeis(){
        return this.seis;
    }

    public boolean isWinner(){
        for (Peca peca : pecas){
            if (!peca.getWinner()){
                return false;
            }
        }
        return true;
    }  
}


