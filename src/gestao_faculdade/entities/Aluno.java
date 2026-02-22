package gestao_faculdade.entities;

import java.util.HashMap;

public class Aluno extends Pessoa {
    
    private Integer matricula;
    private HashMap <Disciplina, Matricula> disciplinaMatricula = new HashMap<>();
    private Float mediaGeral;
    private Integer totalCreditos;

    public Aluno(Integer id, String nome, String email, Integer matricula) {
        super(id, nome, email);
        this.matricula = matricula;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
        Aluno other = (Aluno) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }

    
}
