package gestao_faculdade.entities;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Professor extends Pessoa {

    private Integer salarioBase;
    private Double salarioFinal;
    private Map<Integer, Turma> turmasMinistradas = new HashMap<>();

    public Professor(Integer id, String nome, String email, Integer salarioBase) {
        super(id, nome, email);
        this.salarioBase = salarioBase;
    }

    // ================== Getters ==================

    public Integer getSalarioBase() {
        return salarioBase;
    }

    public Double getSalarioFinal() {
        return salarioFinal;
    }

    public Map<Integer, Turma> getTurmasMinistradas() {
        return Collections.unmodifiableMap(turmasMinistradas);
    }

    // ================== Regras de negócio ==================

    public void inserirTurma(Integer codigoTurma, Turma turma) {

        if (codigoTurma == null || turma == null) {
            throw new IllegalArgumentException("Turma inválida");
        }

        turmasMinistradas.put(codigoTurma, turma);
    }

    public Double calcularSalario() {

        int totalAlunos = 0;

        for (Turma turma : turmasMinistradas.values()) {
            totalAlunos += turma.getMatriculas().size();
        }

        salarioFinal = salarioBase + (totalAlunos * 0.30);

        return salarioFinal;
    }
}