package gestao_faculdade.entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Turma {

    private Integer codigo;
    private Integer limiteDeVagas;

    private Disciplina disciplina;

    private Professor professor;
    
    private Set<Matricula> matriculas = new HashSet<>();

    public Turma(Integer codigo, Disciplina disciplina, Professor professor, Integer limiteDeVagas) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.limiteDeVagas = limiteDeVagas;
    }

    // ================== Getters ==================

    public Integer getCodigo() {
        return codigo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Integer getLimiteDeVagas() {
        return limiteDeVagas;
    }

    public Set<Matricula> getMatriculas() {
        return Collections.unmodifiableSet(matriculas);
    }

    // ================== Regras de negócio ==================

    public boolean alunoJaMatriculado(Aluno aluno) {

        for (Matricula matricula : matriculas) {
            if (matricula.getAluno().equals(aluno)) {
                return true;
            }
        }

        return false;
    }

    public void adicionarMatricula(Matricula matricula) {

        if (matricula == null) {
            throw new IllegalArgumentException("Matrícula inválida");
        }

        if (matriculas.size() >= limiteDeVagas) {
            throw new IllegalStateException("Turma lotada!");
        }

        if (alunoJaMatriculado(matricula.getAluno())) {
            throw new IllegalStateException("Aluno já matriculado nesta turma!");
        }

        matriculas.add(matricula);
    }

    // ================== Equal hashcode ==================
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Turma)) return false;

        Turma other = (Turma) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}