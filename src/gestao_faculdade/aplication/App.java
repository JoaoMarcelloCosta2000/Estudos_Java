package gestao_faculdade.aplication;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import gestao_faculdade.entities.Aluno;
import gestao_faculdade.entities.Disciplina;
import gestao_faculdade.entities.Professor;
import gestao_faculdade.entities.Turma;

public class App {
    
    private static HashMap<Integer, Disciplina> disciplinas = new HashMap<>(); // Map de todas as disciplinas cadastradas
    private static HashSet<Professor> professores = new HashSet<>(); // Set de todos os professores cadastrados
    private static HashSet<Aluno> alunos = new HashSet<>(); // Set de todos os alunos cadastrados
    private static HashMap<Integer, Turma> turmas = new HashMap<>(); // Map de todas as turmas cadastradas

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        Integer respostaContinuacao = 0;

        while (respostaContinuacao == 0) {
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
            System.out.println();
            
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
                
                case 5:
                    cadastraTurma(sc);
                    break;

                default:
                    System.out.println("Opção inválida! Digite uma opção válida!");
            }

            System.out.println();
            System.out.print("Deseja retornar ao menu de ações? [1] Não | [0] Sim: ");
            respostaContinuacao = sc.nextInt();
            sc.nextLine();
            System.out.println();

            if (respostaContinuacao == 1) {
                break;
            }
        }

        System.out.println("Obrigado por utilizar o nosso sistema! Até logo.");
    }
    
    public static void cadastraAluno(Scanner sc) {

        System.out.print("Bem vindo ao cadastro de alunos!");
        System.out.println();

        System.out.print("Digite o nome do aluno a ser cadastrado: ");
        String nome = sc.nextLine();

        System.out.print("Digite o ID do aluno a ser cadastrado: ");
        Integer id = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite o e-mail do aluno a ser cadastrado: ");
        String email = sc.nextLine();

        System.out.print("Digite o número da matrícula do aluno a ser cadastrado: ");
        Integer matricula = sc.nextInt();
        sc.nextLine();
        System.out.println();

        System.out.println("Dados do aluno cadastrado:");
        System.out.println("Nome: " + nome);
        System.out.println("ID: " + id);
        System.out.println("E-mail: " + email);
        System.out.println("Matrícula: " + matricula);
        System.out.println();

        System.out.print("Deseja recomeçar o cadastro? [1] Não | [0] Sim: ");
        Integer resposta = sc.nextInt();
        sc.nextLine();
        System.out.println();

        if(resposta == 1){
            Aluno aluno = new Aluno(id, nome, email, matricula);
            alunos.add(aluno);
        }
        else{
            cadastraAluno(sc);
        }
        
        System.out.print("Aluno cadastrado com sucesso! ");
    }

    public static void cadastraProfessor(Scanner sc) {

        System.out.print("Bem vindo ao cadastro de professores!");
        System.out.println();

        System.out.print("Digite o nome do professor a ser cadastrado: ");
        String nome = sc.nextLine();

        System.out.print("Digite o ID do professor a ser cadastrado: ");
        Integer id = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite o e-mail do professor a ser cadastrado: ");
        String email = sc.nextLine();

        System.out.print("Digite o valor do salário base do professor a ser cadastrado: ");
        Integer valorSalario = sc.nextInt();
        sc.nextLine();
        System.out.println();

        System.out.println("Dados do professor cadastrado:");
        System.out.println("Nome: " + nome);
        System.out.println("ID: " + id);
        System.out.println("E-mail: " + email);
        System.out.println("Salário: " + valorSalario);
        System.out.println();

        System.out.print("Deseja recomeçar o cadastro? [1] Não | [0] Sim: ");
        Integer resposta = sc.nextInt();
        sc.nextLine();
        System.out.println();

        if(resposta == 1){
            Professor professor = new Professor(id, nome, email, valorSalario);
            professores.add(professor);
        }
        else{
            cadastraProfessor(sc);
        }

        System.out.print("Professor cadastrado com sucesso! ");
    }

    public static Disciplina cadastraDisciplina(Scanner sc) {

        System.out.print("Bem vindo ao cadastro de disciplinas!");
        System.out.println();

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
        System.out.println();

        System.out.println("Dados da disciplina cadastrada:");
        System.out.println("Nome: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Carga horária: " + cargaHoraria);
        System.out.println("Créditos: " + creditos);
        System.out.println();

        System.out.print("Deseja recomeçar o cadastro? [1] Não | [0] Sim: ");
        Integer resposta = sc.nextInt();
        sc.nextLine();
        System.out.println();

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

        System.out.print("Bem vindo ao cadastro de requisitos de disciplinas!");
        System.out.println();

        System.out.print("Digite o código da disciplina que possui requisitos: ");
        Integer codigo = sc.nextInt();
        sc.nextLine();
        System.out.println();

        Disciplina disciplina = disciplinas.get(codigo);

        if (disciplina == null) {

                System.out.println("Disciplina não encontrada.");
                System.out.print("Deseja cadastrar agora? [1] Sim | [0] Não: ");
                int opcao = sc.nextInt();
                sc.nextLine();
                System.out.println();

                if (opcao == 1) {
                    disciplina = cadastraDisciplina(sc);
                    disciplinas.put(disciplina.getCodigo(), disciplina);
                }
                else {
                    System.out.println("Operação cancelada.");
                    return; 
                }
            }

        System.out.print("Quantos pré-requisitos? ");
        Integer quantidade = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < quantidade; i++) {

            System.out.print("Digite o código do pré-requisito: ");
            Integer codigoPreRequisito = sc.nextInt();
            sc.nextLine();
            System.out.println();

            Disciplina preRequisito = disciplinas.get(codigoPreRequisito);

            if (preRequisito == null) {

                System.out.println("Disciplina não encontrada.");
                System.out.print("Deseja cadastrar agora? [1] Sim | [0] Não: ");
                int opcao = sc.nextInt();
                sc.nextLine();
                System.out.println();

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

    public static void cadastraTurma (Scanner sc){

        System.out.print("Bem vindo ao cadastro de turmas!");
        System.out.println();

        System.out.print("Digite o código da turma a ser cadastrada: ");
        Integer codigo = sc.nextInt();
        sc.nextLine();

        Disciplina disciplinaSelecionada = null;

        while (true) {
            System.out.print("Digite o código da disciplina associada a essa turma: ");
            Integer codigoDisciplina = sc.nextInt();
            sc.nextLine();

            disciplinaSelecionada = disciplinas.get(codigoDisciplina);

            if (disciplinaSelecionada != null) {
                System.out.println("Disciplina " + disciplinaSelecionada.getNome() + " associada com sucesso!");
                break;
            } else {
                System.out.println("Código de disciplina não encontrado. Insira um código válido!");
            }
        }

        Professor professorEncontrado = null;

        while (true) {
            System.out.print("Digite o nome do professor responsável pela disciplina: ");
            String nomeDigitado = sc.nextLine();

            for (Professor professor : professores) {
                if (professor.getNome().equalsIgnoreCase(nomeDigitado)) {
                    professorEncontrado = professor;
                    break;
                }
            }

            if (professorEncontrado != null) {
                System.out.println("Professor " + nomeDigitado + " associado com sucesso!");
                break;
            } else {
                System.out.println("Nome do professor não encontrado. Digite um nome válido!");
            }
        }

        System.out.print("Digite o número de vagas da turma a ser cadastrada: ");
        Integer limiteDeVagas = sc.nextInt();
        sc.nextLine();
        System.out.println();

        System.out.println("Dados da turma cadastrada:");
        System.out.println("Código da turma: " + codigo);
        System.out.println("Disciplina associada: " + disciplinaSelecionada.getNome());
        System.out.println("Professor: " + professorEncontrado.getNome());
        System.out.println("Número de vagas totais: " + limiteDeVagas);
        System.out.println();

        System.out.print("Deseja recomeçar o cadastro? [1] Não | [0] Sim: ");
        Integer resposta = sc.nextInt();
        sc.nextLine();
        System.out.println();

        if(resposta == 1){
            Turma turma = new Turma(codigo, disciplinaSelecionada, professorEncontrado, limiteDeVagas);
            turmas.put(codigo, turma);
        }
        else{
            cadastraTurma(sc);
        }
        
        System.out.print("Turma cadastrada com sucesso! ");
    }
}



    










