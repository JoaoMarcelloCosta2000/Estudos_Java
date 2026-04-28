package xadrez.entities;

import xadrez.enums.Cores;

public class Torre extends Peca{
    
    public Torre(Cores cor, int linha_atual, int coluna_atual){
        super(cor, linha_atual, coluna_atual);
    }
}
