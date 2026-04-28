package xadrez.entities;

import xadrez.enums.Cores;

public class Peao extends Peca {
    
    private int contador_movimentos = 0;

    public Peao(Cores cor, int linha_atual, int coluna_atual, int contador_movimentos){
        super(cor, linha_atual, coluna_atual);
        this.contador_movimentos = contador_movimentos;
    }
}
