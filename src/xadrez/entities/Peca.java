package xadrez.entities;

import xadrez.enums.Cores;

public abstract class Peca {
    
    private Cores cor;
    private int linha_atual;
    private int coluna_atual;

    public Peca(Cores cor, int linha_atual, int coluna_atual){
        this.cor = cor;
        this.linha_atual = linha_atual;
        this.coluna_atual = coluna_atual;
    }
}
