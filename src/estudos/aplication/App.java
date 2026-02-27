package estudos.aplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import estudos.entities.Produto;
import estudos.enums.TipoProduto;

public class App {

    public static void main(String[] args) {

        List<Produto> produtos = new ArrayList<>();
    
        produtos.add(new Produto("Melão", TipoProduto.COMIDA, 2));
        produtos.add(new Produto("Celular", TipoProduto.ELETRONICO, 2000));
        produtos.add(new Produto("Casaco", TipoProduto.VESTUARIO, 300));

        produtos.sort(new Comparador()); // Passando o comparador como argumento 

        Comparator <Produto> ComparadorLambda = (produto1, produto2) -> {
            return produto1.getNome().toUpperCase().compareTo(produto2.getNome().toUpperCase());
        };

        produtos.sort(ComparadorLambda); // Passando o comparador da expressão lambda como argumento 

        produtos.sort((produto1, produto2) -> produto1.getNome().toUpperCase().compareTo(produto2.getNome().toUpperCase())); // Posso passar assim também

        for(Produto produto : produtos){
            System.out.println(produto.getNome());
        }

    }
}