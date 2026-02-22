package gestao_faculdade.entities;

import java.util.HashMap;

public class Professor extends Pessoa {
    
    private Integer salarioBase;
    private HashMap <Integer,Turma> turmasMinistradas = new HashMap<>();

    public Professor(Integer id, String nome, String email, Integer salarioBase) {
        super(id, nome, email);
        this.salarioBase = salarioBase;
    }

    public HashMap<Integer, Turma> getTurmasMinistradas() {
        return turmasMinistradas;
    }

    public void insereTurma (Integer codigoTurma, Turma turma){
        this.turmasMinistradas.put(codigoTurma, turma);
    }
    
}
