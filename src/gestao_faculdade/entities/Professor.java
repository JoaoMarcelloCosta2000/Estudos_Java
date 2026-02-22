package gestao_faculdade.entities;

import java.util.HashSet;

public class Professor extends Pessoa {
    
    private Integer salarioBase;
    private HashSet <Turma> turmasMinistradas;

    public Professor(Integer id, String nome, String email, Integer salarioBase) {
        super(id, nome, email);
        this.salarioBase = salarioBase;
    }

    
    
}
