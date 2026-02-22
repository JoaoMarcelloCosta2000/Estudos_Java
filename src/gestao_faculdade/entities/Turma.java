package gestao_faculdade.entities;

import java.util.HashMap;
import java.util.HashSet;

public class Turma {
    
    private Integer codigo;
    private String disciplina;
    private String professor;
    private HashMap <Aluno,Matricula> mapa;
    private Integer limiteDeVagas;

}
