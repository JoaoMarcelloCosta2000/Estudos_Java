package estudos.aplication;

import java.util.Comparator;

import estudos.entities.Produto;

public class Comparador implements Comparator <Produto> {

    @Override
    public int compare(Produto produto1, Produto produto2) { // retorna 1 se p1 > p2; 0 se p1 = p2; -1 se p1 < p2
        return produto1.getNome().toUpperCase().compareTo(produto2.getNome().toUpperCase()); // Comparação por nome independente das letras
    }
    
}
