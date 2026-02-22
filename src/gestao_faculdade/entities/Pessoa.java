package gestao_faculdade.entities;

public abstract class Pessoa {
    
    protected Integer id;
    protected String nome;
    protected String email;
    
    public Pessoa(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

}
