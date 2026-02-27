package estudos.entities;

import estudos.enums.TipoProduto;

public class Produto {
    
    private String nome;
    private TipoProduto tipo;

    private Integer preco;

    public Produto (String nome, TipoProduto tipo, Integer preco){
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }

    public String getNome(){
        return this.nome;
    }

    public TipoProduto tipo(){
        return this.tipo;
    }

    public Integer getPreco(){
        return this.preco;
    }

}
