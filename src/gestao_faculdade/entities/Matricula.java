package gestao_faculdade.entities;

import gestao_faculdade.enums.StatusMatricula;
import java.util.Objects;

public class Matricula {

    private final Aluno aluno;
    private final Turma turma;

    private Float nota1;
    private Float nota2;

    private int totalAulas;
    private int totalPresencas;

    private Float mediaDisciplina;
    private StatusMatricula status;

    public Matricula(Aluno aluno, Turma turma) {
        this.aluno = aluno;
        this.turma = turma;
        this.status = StatusMatricula.CURSANDO;

        aluno.adicionarMatricula(this);
        turma.adicionarMatricula(this);
         
    }

    /* ===================== Controle de presença ===================== */

    public void registrarPresenca(boolean presente) {
        totalAulas++;
        if (presente) {
            totalPresencas++;
        }
    }

    public float getPercentualFrequencia() {
        if (totalAulas == 0) return 0f;
        return (totalPresencas * 100f) / totalAulas;
    }

    /* ===================== Controle de notas ===================== */

    public void lançarNota1(Float nota1) {
        this.nota1 = nota1;
        atualizarMediaEStatusSePossivel();
    }

    public void lançarNota2(Float nota2) {
        this.nota2 = nota2;
        atualizarMediaEStatusSePossivel();
    }

    public void atualizarMediaEStatusSePossivel() {
        if (nota1 != null && nota2 != null) {
            this.mediaDisciplina = (nota1 + nota2) / 2;
            atualizarStatus();
        }
    }

    /* ===================== Controle de status ===================== */

    private void atualizarStatus() {

        if (mediaDisciplina == null) return;

        if (getPercentualFrequencia() < 70) {
            this.status = StatusMatricula.REPROVADO_FREQUENCIA;
            return;
        } 
        else if (mediaDisciplina >= 6.0) {
            this.status = StatusMatricula.APROVADO;
        } 
        else {
            this.status = StatusMatricula.REPROVADO_NOTA;
        }
    }

    /* ===================== Getters ===================== */

    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public Float getNota1() {
        return nota1;
    }

    public Float getNota2() {
        return nota2;
    }

    public Float getMediaDisciplina() {
        return mediaDisciplina;
    }

    public StatusMatricula getStatus() {
        return status;
    }

    /* ===================== Equals e Hashcode ===================== */

    @Override
    public int hashCode() {
        return Objects.hash(aluno, turma);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Matricula)) return false;
        Matricula other = (Matricula) obj;
        return Objects.equals(aluno, other.aluno)
                && Objects.equals(turma, other.turma);
    }
}