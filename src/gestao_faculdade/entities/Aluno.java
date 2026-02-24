package gestao_faculdade.entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Aluno extends Pessoa {

    private final Integer registro;
    private final Set<Matricula> matriculas = new HashSet<>();

    private Double mediaGeral;
    
    private Integer totalCreditos;

    public Aluno(Integer id, String nome, String email, Integer registro) {
        super(id, nome, email);
        this.registro = registro;
    }

    /* ===================== Cálculos acadêmicos ===================== */

    public Double calcularMediaGeral() {

        if (matriculas.isEmpty()) return 0.0;

        double soma = 0.0;

        for (Matricula matricula : matriculas) {
            if (matricula.getMediaDisciplina() != null) {
                soma += matricula.getMediaDisciplina();
            }
        }

        this.mediaGeral = soma / matriculas.size();
        return mediaGeral;
    }

    public Integer calcularTotalCreditos() {

        if (matriculas.isEmpty()) return 0;

        int soma = 0;

        for (Matricula matricula : matriculas) {
            soma += matricula.getTurma().getDisciplina().getCreditos();
        }

        this.totalCreditos = soma;
        return totalCreditos;
    }

    /* ===================== Controle de Matrículas ===================== */

    public void adicionarMatricula(Matricula matricula) {
        matriculas.add(matricula);
    }

    public boolean possuiMatriculaNaTurma(Turma turma) {

        for (Matricula matricula : matriculas) {
            if (matricula.getTurma().equals(turma)) {
                return true;
            }
        }

        return false;
    }

    /* ===================== Getters ===================== */

    public Integer getRegistro() {
        return registro;
    }

    public Double getMediaGeral() {
        return mediaGeral;
    }

    public Integer getTotalCreditos() {
        return totalCreditos;
    }

    public Set<Matricula> getMatriculas() {
        return Collections.unmodifiableSet(matriculas);
    }

    /* ===================== Equals e HashCode ===================== */

    @Override
    public int hashCode() {
        return registro.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Aluno)) return false;
        Aluno other = (Aluno) obj;
        return registro.equals(other.registro);
    }
}