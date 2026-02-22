package gestao_faculdade.entities;

import gestao_faculdade.enums.StatusMatricula;

public class Matricula {
    
    private Aluno aluno;
    private Turma turma;
    private Float nota1;
    private Float nota2;
    private Integer frequencia;
    private StatusMatricula status;

    public Matricula(Aluno Aluno, Turma turma, Float nota1, Float nota2, Integer frequencia, StatusMatricula status) {
        this.aluno = aluno;
        this.turma = turma;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.frequencia = frequencia;
        this.status = status;
    }

    public Float calcularMedia (nota1, nota2){
        return (nota1 + nota2) / 2;
    }

}
