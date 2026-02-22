package gestao_faculdade.entities;

import java.util.HashMap;

public class Turma {
    
    private Integer codigo;
    private Disciplina disciplina;
    private Professor professor;
    private HashMap <Aluno,Matricula> alunos = new HashMap<>();
    private Integer limiteDeVagas;

    public Turma(Integer codigo, Disciplina disciplina, Professor professor, Integer limiteDeVagas) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.limiteDeVagas = limiteDeVagas;
    }



    public void adicionarAluno(Aluno aluno, Matricula matricula) {
        alunos.put(aluno, matricula);
    }

}
