package gestao_faculdade.entities;

import java.util.HashSet;
import java.util.Set;

public class Turma {
    
    private Integer codigo;
    private Disciplina disciplina;
    private Professor professor;
    private Set<Matricula> matriculas = new HashSet<>();
    private Integer limiteDeVagas;

    public Turma(Integer codigo, Disciplina disciplina, Professor professor, Integer limiteDeVagas) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.limiteDeVagas = limiteDeVagas;
    }

    public boolean alunoJaMatriculado(Aluno aluno) {
        return matriculas.stream()
                .anyMatch(m -> m.getAluno().equals(aluno));
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Integer getLimiteDeVagas() {
        return limiteDeVagas;
    }

    public Set<Matricula> getMatriculas() {
        return matriculas;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void adicionarMatricula(Matricula matricula) {
        if (matriculas.size() >= limiteDeVagas) {
            throw new IllegalStateException("Turma lotada!");
        }

        if (alunoJaMatriculado(matricula.getAluno())) {
            throw new IllegalStateException("Aluno já matriculado nesta turma!");
        }

        matriculas.add(matricula);
    }

    public Professor getProfessor() {
        return professor;
    }

}
