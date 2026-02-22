package gestao_faculdade.entities;

import java.util.HashSet;

public class Disciplina implements Comparable <Disciplina> {
    
    private Integer codigo;
    private String nome;
    private Integer cargaHoraria;
    private Integer creditos;
    private HashSet<Disciplina> preRequisitos = new HashSet<>();

    public Disciplina(Integer codigo, String nome, Integer cargaHoraria, Integer creditos) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.creditos = creditos;
    }

    public void setPreRequisitos(HashSet<Disciplina> preRequisitos) {
        this.preRequisitos = preRequisitos;
    }

    public void adicionarPreRequisito(Disciplina disciplina) {
        this.preRequisitos.add(disciplina);
    }

    public Integer getCodigo (){
        return codigo;
    }

    @Override
    public int compareTo(Disciplina outra) {
        return this.codigo.compareTo(outra.codigo);
    }
}
