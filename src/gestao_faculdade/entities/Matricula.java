package gestao_faculdade.entities;

import gestao_faculdade.enums.StatusMatricula;

public class Matricula {
    
    private Aluno aluno;
    private Turma turma;
    private Float nota1;
    private Float nota2;
    private Integer totalAulas = 0;
    private Integer totalPresencas = 0;
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

    public void registrarPresenca(boolean presente){
        totalAulas++;

        if(presente){
                totalPresencas++;
            }
    }

    public float getPercentualFrequencia(){
        if(totalAulas == 0) return 0f;

        return (totalPresencas * 100f) / totalAulas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
        result = prime * result + ((turma == null) ? 0 : turma.hashCode());
        return result;
    }

    public void setNota1(Float nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(Float nota2) {
        this.nota2 = nota2;
    }

    public Turma getTurma() {
        return turma;
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
