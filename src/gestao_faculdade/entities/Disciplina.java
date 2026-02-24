package gestao_faculdade.entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Disciplina implements Comparable<Disciplina> {


    private Integer codigo;
    private Integer cargaHoraria;
    private Integer creditos;

    private String nome;
    
    private Set<Disciplina> preRequisitos = new HashSet<>();

    public Disciplina(Integer codigo, String nome, Integer cargaHoraria, Integer creditos) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.creditos = creditos;
    }

    // ================== Getters ==================

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public Set<Disciplina> getPreRequisitos() {
        return Collections.unmodifiableSet(preRequisitos);
    }

    // ================== Regras de negócio ==================

    public void adicionarPreRequisito(Disciplina disciplina) {
        if (disciplina == null) {
            throw new IllegalArgumentException("Pré-requisito inválido");
        }
        preRequisitos.add(disciplina);
    }

    public boolean possuiPreRequisito(Disciplina disciplina) {
        return preRequisitos.contains(disciplina);
    }

    // ================== Equals e hashcode ==================

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Disciplina))
            return false;
        Disciplina other = (Disciplina) obj;
        return Objects.equals(codigo, other.codigo);
    }

    // ================== COMPARABLE ==================
    
    @Override
    public int compareTo(Disciplina outra) {
        return this.codigo.compareTo(outra.codigo);
    }
}
