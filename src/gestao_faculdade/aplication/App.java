package gestao_faculdade.aplication;

import java.util.HashMap;
import java.util.Scanner;

import gestao_faculdade.entities.Aluno;
import gestao_faculdade.entities.Disciplina;
import gestao_faculdade.entities.Professor;

public class App {
    
    private static HashMap<Integer, Disciplina> disciplinas = new HashMap<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        System.out.println("Olá, bem vindo ao cadastro de pessoas!");
        System.err.println();
        System.out.println("Cadastrar aluno [1]");
        System.out.println("Cadastrar professor [2]");
        System.out.println("Cadastrar disciplina [3]");
        System.out.println("Cadastrar pré-requisitos de disciplinas [4]");
        System.out.println("Cadastrar turma [5]");
        System.out.println("Matricular aluno [6]");
        System.out.println("Lanças notas [7]");
        System.out.println("Registrar frequência [8]");
        System.out.println("Exibir boletim de aluno [9]");
        System.out.println("Exibir ranking da turma [10]");
        System.out.println("Gerar relatório CSV [11]");
        System.out.println("Ler relatório CSV [12]");
        System.out.println("Estatístiscas gerais [13]");
        System.out.println("Sair [14]");
        System.err.println();
        System.out.print("Selecione a função desejada! ");
        Integer respostaMenu = sc.nextInt();
        sc.nextLine();
        
        switch (respostaMenu) {
            case 1:
                cadastraAluno(sc);
                break;

            case 2:
                cadastraProfessor(sc);
                break;    
            
            case 3:
                cadastraDisciplina(sc);
                break;

            case 4:
                cadastraRequisitosDisciplina(sc);
                break;

            default:
                break;
        }
    }
    
    public static void cadastraAluno(Scanner sc) {

        System.out.print("Digite o seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite o seu ID: ");
        Integer id = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite o seu e-mail: ");
        String email = sc.nextLine();

        System.out.print("Digite o número da sua matrícula: ");
        Integer Matricula = sc.nextInt();
        sc.nextLine();

        System.out.print("Deseja recomeçar o cadastro? [1] Não | [0] Sim: ");
        Integer resposta = sc.nextInt();
        sc.nextLine();

        if(resposta == 1){
            Aluno aluno = new Aluno(id, nome, email, Matricula);
        }
        else{
            cadastraAluno(sc);
        }

        System.out.print("Aluno cadastrado com sucesso! ");
    }

    public static void cadastraProfessor(Scanner sc) {

        System.out.print("Digite o seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite o seu ID: ");
        Integer id = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite o seu e-mail: ");
        String email = sc.nextLine();

        System.out.print("Digite o valor do seu salário base: ");
        Integer valorSalario = sc.nextInt();
        sc.nextLine();

        System.out.print("Deseja recomeçar o cadastro? [1] Não | [0] Sim: ");
        Integer resposta = sc.nextInt();
        sc.nextLine();

        if(resposta == 1){
            Professor professor = new Professor(id, nome, email, valorSalario);
        }
        else{
            cadastraProfessor(sc);
        }

        System.out.print("Professor cadastrado com sucesso! ");
    }

    public static Disciplina cadastraDisciplina(Scanner sc) {

        System.out.print("Digite o nome da disciplina: ");
        String nome = sc.nextLine();

        System.out.print("Digite o código da disciplina: ");
        Integer codigo = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite a carga horária: ");
        Integer cargaHoraria = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite os créditos: ");
        Integer creditos = sc.nextInt();
        sc.nextLine();

        System.out.print("Deseja recomeçar o cadastro? [1] Não | [0] Sim: ");
        Integer resposta = sc.nextInt();
        sc.nextLine();

        if(resposta == 1){
            Disciplina disciplina = new Disciplina(codigo, nome, cargaHoraria, creditos);
            disciplinas.put(codigo, disciplina);
            System.out.print("Disciplina cadastrada com sucesso! ");
            return disciplina;
        }
        else{
            return cadastraDisciplina(sc);
        }
    }

    public static void cadastraRequisitosDisciplina (Scanner sc) {

        System.out.print("Digite o código da disciplina que possui requisitos: ");
        Integer codigo = sc.nextInt();
        sc.nextLine();

        Disciplina disciplina = disciplinas.get(codigo);

        System.out.print("Quantos pré-requisitos? ");
        Integer quantidade = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < quantidade; i++) {

            System.out.print("Digite o código do pré-requisito: ");
            Integer codigoPreRequisito = sc.nextInt();
            sc.nextLine();

            Disciplina preRequisito = disciplinas.get(codigoPreRequisito);

            if (preRequisito == null) {

                System.out.println("Disciplina não encontrada.");
                System.out.print("Deseja cadastrar agora? [1] Sim | [0] Não: ");
                int opcao = sc.nextInt();
                sc.nextLine();

                if (opcao == 1) {
                    preRequisito = cadastraDisciplina(sc);
                    disciplinas.put(preRequisito.getCodigo(), preRequisito);

                    disciplina.adicionarPreRequisito(preRequisito);
                    System.out.println("Pré-requisito (nova disciplina) adicionado à disciplina antiga!");
                }
            }

            if (preRequisito != null) {
                disciplina.adicionarPreRequisito(preRequisito);
                System.out.println("Pré-requisito adicionado!");
            }
        }
    }
}


    










