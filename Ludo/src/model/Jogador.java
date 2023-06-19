package model;

import java.util.Vector;

import view.ViewFacade;

class Jogador {
    private Cor cor;
    private Vector<Peca> pecas;
    private Vector<Peca> pecasDisponiveis;
    private Peca lastPeca;
    private int posIni;
    // private Casa casaIni;
    private int seis;
    
    
    public Jogador(Tabuleiro t, Cor c) {
        this.cor = c;
        this.pecas = inicializaPecas(t);
        this.pecasDisponiveis = new Vector<Peca>();
        this.lastPeca = pecas.get(0);
        this.posIni = t.getPosicaoSaida(c);
        // this.casaIni = t.getCasaSaida(c);
        this.seis = 0;
    }

    private Vector<Peca> inicializaPecas(Tabuleiro t){ // TALVEZ MUDAR ISSO PARA O TABULEIRO E RETORNAR PARA O CONSTRUTOR DO JOGADOR, QUE RECEBERIA UM VETOR DE PEÇAS COMO PARAMETRO
        int size = 4;
        Vector<Peca> pcs = new Vector<Peca>();
        Peca pc;
        for (int i = 0; i < size; i++) {
            pc = new Peca(this);
            pcs.add(pc);
        }

        pcs.get(0).moverPeca(t, 5); 
        


        return pcs;
    }

    public boolean podeJogar(Tabuleiro t, int nCasas){
        this.pecasDisponiveis = pecasDisponiveis(t, nCasas);

        /* Se já tirou 6 3 vezes */
        if (nCasas == 6){
            
            if (this.seis == 2){
                this.lastPeca.backToStart(t.getCasa(lastPeca.getPosition()));

                return false;
            }
        }
            
        // System.out.println("qtd pecas disponiveis: "+this.pecasDisponiveis.size());
        /* Se não puder jogar com nenhuma peça */
        if (this.pecasDisponiveis.size() == 0){

            return false;
        }
        
		return true;
	}

    public void moverPeca(Tabuleiro t, int i, int nCasas){
        Peca currentPeca = this.getPecaDisponivel(i);
        currentPeca.moverPeca(t, nCasas);
        this.lastPeca = currentPeca;
    }

    public Vector<Peca> pecasDisponiveis(Tabuleiro t, int nCasas){
        Vector<Peca> pcsDisp = new Vector<Peca>();
        for (Peca peca : this.pecas){
            if (peca.podeMover(t, nCasas)){
                pcsDisp.add(peca);
            }
        }

        return pcsDisp;
    }

    public Vector<Peca> getPecasDisponiveis(){
        return this.pecasDisponiveis;
    }

    public Peca getPecaDisponivel(int i){
        return this.pecasDisponiveis.get(i);
    }

    public Peca getPeca(int i){
        return this.pecas.get(i);
    }

    public Vector<Peca> getPecas(){
        return this.pecas;
    }

    public void setLastPeca(Peca p){
        this.lastPeca = p;
    }

    public Peca getLastPeca(){
        return this.lastPeca;
    }

    public Cor getCor() {
        return this.cor;
    }

    public int getPosInicial(){
        return this.posIni;
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
            if (!peca.isWinner()){
                return false;
            }
        }
        return true;
    } 

    public int somaEspacosAteFinal(){
        int soma = 0;
        int i = 0;
        for (Peca peca : pecas){
            soma += peca.casasFaltando(posIni);
        }
        return soma;
    }

    public void PararCasaEspecifica(int[] v, Tabuleiro t){
        for (int i = 0; i < 4; i++){
            pecas.get(i).PararCasaEspecifica(v[i],t);
        }
    }
    
    public int[] getPosicoes(){
        int posicoes[] = new int[4];
        for (int i = 0; i < 4; i++){
            posicoes[i] = pecas.get(i).getPosition();
        }
        return posicoes;
    }
    public String getJogadorName(){
        return this.cor.name();
    }
    
}


