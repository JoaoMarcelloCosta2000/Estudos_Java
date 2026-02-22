package gestao_faculdade.entities;

import java.util.Objects;

import gestao_faculdade.enums.StatusMatricula;

public class Matricula {
    
    private Aluno aluno;
    private Turma turma;
    private Float nota1;
    private Float nota2;
    private Integer frequencia;
    private StatusMatricula status;

    public Matricula(Aluno aluno, Turma turma, StatusMatricula status) {
        this.aluno = aluno;
        this.turma = turma;
        this.status = status;

        aluno.adicionarMatricula(this);
        turma.adicionarMatricula(this);
    }

    public Aluno getAluno() {
        return aluno;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
        result = prime * result + ((turma == null) ? 0 : turma.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Matricula other = (Matricula) obj;
        if (aluno == null) {
            if (other.aluno != null)
                return false;
        } else if (!aluno.equals(other.aluno))
            return false;
        if (turma == null) {
            if (other.turma != null)
                return false;
        } else if (!turma.equals(other.turma))
            return false;
        return true;
    }

}
