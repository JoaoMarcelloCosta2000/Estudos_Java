package gestao_faculdade.aplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import gestao_faculdade.entities.Aluno;
import gestao_faculdade.entities.Disciplina;
import gestao_faculdade.entities.Matricula;
import gestao_faculdade.entities.Professor;
import gestao_faculdade.entities.Turma;
import gestao_faculdade.enums.StatusMatricula;

public class App {
    
    private static HashMap<Integer, Disciplina> disciplinas = new HashMap<>(); // Map de todas as disciplinas cadastradas
    private static HashMap<Integer, Professor> professores = new HashMap<>(); // Map de todos os professores cadastrados
    private static HashMap<Integer, Aluno> alunos = new HashMap<>(); // Map de todos os alunos cadastrados
    private static HashMap<Integer, Turma> turmas = new HashMap<>(); // Map de todas as turmas cadastradas

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        Integer respostaContinuacao = 0;

        while (respostaContinuacao == 0) {
            System.out.println("=================================================");
            System.out.println("   BEM VINDO AO SISTEMA DE GESTÃO DA FACULDADE"   );
            System.out.println("=================================================");
            System.out.println();
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
            System.out.println("Estatístiscas gerais [12]");
            System.out.println("Sair [13]");
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

                case 6:
                    matriculaAluno(sc);
                    break;

                case 7:
                    lancaNota(sc);
                    break;    

                case 8:
                    registrarFrequencia(sc);
                    break;

                case 9:
                    exibirBoletimAluno(sc);
                    break;

                case 10:
                    exibirRankingTurma(sc);
                    break;

                case 11:
                    geraRelatorio(sc);
                    break;    

                case 12:
                    mostrarEstatisticas();
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

        while(true){
            System.out.println("===================================");
            System.out.println("   SISTEMA DE CADASTRO DE ALUNOS"   );
            System.out.println("===================================");
            System.out.println();

            System.out.print("Digite o nome do aluno a ser cadastrado: ");
            String nome = sc.nextLine();

            System.out.print("Digite o ID do aluno a ser cadastrado: ");
            Integer id = sc.nextInt();
            sc.nextLine();

            System.out.print("Digite o e-mail do aluno a ser cadastrado: ");
            String email = sc.nextLine();

            System.out.print("Digite o número do registro do aluno a ser cadastrado: ");
            Integer registro = sc.nextInt();
            sc.nextLine();
            System.out.println();

            System.out.println("===== DADOS DO ALUNO CADASTRADO =====");
            System.out.println("Nome: " + nome);
            System.out.println("ID: " + id);
            System.out.println("E-mail: " + email);
            System.out.println("Registro: " + registro);
            System.out.println();

            System.out.print("Deseja recomeçar o cadastro? [1] Não | [0] Sim: ");
            Integer resposta = sc.nextInt();
            sc.nextLine();
            System.out.println();

            if(resposta == 1){
                Aluno aluno = new Aluno(id, nome, email, registro);
                alunos.put(registro, aluno);
                System.out.print("Aluno " + nome + " cadastrado com sucesso! ");
                break;
            }              
        }
    }

    public static void cadastraProfessor(Scanner sc) {

        while(true){

            System.out.println("========================================");
            System.out.println("   SISTEMA DE CADASTRO DE PROFESSORES"   );
            System.out.println("========================================");
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

            System.out.println("===== DADOS DO PROFESSOR CADASTRADO =====");
            System.out.println("Nome: " +nome);
            System.out.println("ID: " +id);
            System.out.println("E-mail: " +email);
            System.out.println("Salário: " +valorSalario);
            System.out.println();

            System.out.print("Deseja recomeçar o cadastro? [1] Não | [0] Sim: ");
            Integer resposta = sc.nextInt();
            sc.nextLine();
            System.out.println();

            if(resposta == 1){
                Professor professor = new Professor(id, nome, email, valorSalario);
                professores.put(id, professor);
                System.out.print("Professor " + nome + " cadastrado com sucesso! ");
                break;
            }
        }
    }

    public static Disciplina cadastraDisciplina(Scanner sc) {

        while(true){
            System.out.println("========================================");
            System.out.println("   SISTEMA DE CADASTRO DE DISCIPLINAS"   );
            System.out.println("========================================");
            System.out.println();

            System.out.print("Digite o nome da disciplina: ");
            String nome = sc.nextLine();

            System.out.print("Digite o código da disciplina: ");
            Integer codigo = sc.nextInt();
            sc.nextLine();

            System.out.print("Digite a carga horária: ");
            Integer cargaHoraria = sc.nextInt();
            sc.nextLine();

            System.out.print("Digite os créditos oferecidos pela disciplina: ");
            Integer creditos = sc.nextInt();
            sc.nextLine();
            System.out.println();

            System.out.println("===== DADOS DA DISCIPLINA CADASTRADA =====");
            System.out.println("Nome: " +nome);
            System.out.println("Código: " +codigo);
            System.out.println("Carga horária: " +cargaHoraria);
            System.out.println("Créditos: " +creditos);
            System.out.println();

            System.out.print("Deseja recomeçar o cadastro? [1] Não | [0] Sim: ");
            Integer resposta = sc.nextInt();
            sc.nextLine();
            System.out.println();

            if(resposta == 1){
                Disciplina disciplina = new Disciplina(codigo, nome, cargaHoraria, creditos);
                disciplinas.put(codigo, disciplina);
                System.out.print("Disciplina cadastrada com sucesso!");
                return disciplina;
            }
        }
    }

    public static void cadastraRequisitosDisciplina(Scanner sc) {

        System.out.println("======================================================");
        System.out.println("   SISTEMA DE CADASTRO DE REQUISITOS DE DISCIPLINAS"   );
        System.out.println("======================================================");
        System.out.println();

        System.out.print("Digite o código da disciplina que possui requisitos: ");
        Integer codigo = sc.nextInt();
        sc.nextLine();
        System.out.println();

        Disciplina disciplina = disciplinas.get(codigo);

        if(disciplina == null) {

                System.out.println("Disciplina não encontrada.");
                System.out.print("Deseja cadastrar agora? [1] Sim | [0] Não: ");
                int opcao = sc.nextInt();
                sc.nextLine();
                System.out.println();

                if(opcao == 1) {
                    disciplina = cadastraDisciplina(sc);
                    disciplinas.put(disciplina.getCodigo(), disciplina);
                }
                else{
                    System.out.println("Operação cancelada.");
                    return; 
                }
            }

        System.out.print("Quantos pré-requisitos? ");
        Integer quantidade = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < quantidade; i++) {

            System.out.print("Digite o código do pré-requisito: ");
            Integer codigoPreRequisito = sc.nextInt();
            sc.nextLine();
            System.out.println();

            Disciplina preRequisito = disciplinas.get(codigoPreRequisito);

            if(preRequisito == null) {

                System.out.println("Disciplina não encontrada.");
                System.out.print("Deseja cadastrar agora? [1] Sim | [0] Não: ");
                int opcao = sc.nextInt();
                sc.nextLine();
                System.out.println();

                if(opcao == 1) {
                    preRequisito = cadastraDisciplina(sc);
                    disciplinas.put(preRequisito.getCodigo(), preRequisito);

                    disciplina.adicionarPreRequisito(preRequisito);
                    System.out.println("Pré-requisito adicionado à disciplina antiga!");
                }
            }

            if(preRequisito != null) {
                disciplina.adicionarPreRequisito(preRequisito);
                System.out.println("Pré-requisito adicionado!");
            }
        }
    }

    public static void cadastraTurma(Scanner sc){

        while(true){
            System.out.println("=================================================");
            System.out.println("   SISTEMA DE CADASTRO DE REQUISITOS DE TURMAS"   );
            System.out.println("=================================================");
            System.out.println();

            System.out.print("Digite o código da turma a ser cadastrada: ");
            Integer codigo = sc.nextInt();
            sc.nextLine();

            Disciplina disciplinaSelecionada = null;

            while(disciplinaSelecionada == null) {
                System.out.print("Digite o código da disciplina associada a essa turma: ");
                Integer codigoDisciplina = sc.nextInt();
                sc.nextLine();

                disciplinaSelecionada = disciplinas.get(codigoDisciplina);

                if(disciplinaSelecionada == null) {
                    System.out.println("Código de disciplina não encontrado. Insira um código válido!");       
                }
            }    

            Professor professorEncontrado = null;

            while(professorEncontrado == null) {
                System.out.print("Digite o ID do professor responsável pela disciplina: ");
                Integer codigoDigitado = sc.nextInt();
                sc.nextLine();

                professorEncontrado = professores.get(codigoDigitado);

                if(professorEncontrado == null) {
                    System.out.println("Código de professor não encontrado. Digite um código válido!");
                }
            }

            System.out.print("Digite o número de vagas da turma a ser cadastrada: ");
            Integer limiteDeVagas = sc.nextInt();
            sc.nextLine();
            System.out.println();

            System.out.println("===== DADOS DA TURMA CADASTRADA =====");
            System.out.println("Código da turma: " +codigo);
            System.out.println("Disciplina associada: " +disciplinaSelecionada.getNome());
            System.out.println("Professor: " +professorEncontrado.getNome());
            System.out.println("Número de vagas totais: " +limiteDeVagas);
            System.out.println();

            System.out.print("Deseja recomeçar o cadastro? [1] Não | [0] Sim: ");
            Integer resposta = sc.nextInt();
            sc.nextLine();
            System.out.println();

            if(resposta == 1){
                Turma turma = new Turma(codigo, disciplinaSelecionada, professorEncontrado, limiteDeVagas);
                turmas.put(codigo, turma);
                professorEncontrado.inserirTurma(codigo, turma);
                System.out.print("Turma cadastrada com sucesso!");
                break;
            }
        }
    }
    
    public static void matriculaAluno(Scanner sc){

        while (true){
            System.out.println("================================================");
            System.out.println("   SISTEMA DE CADASTRO DE MATRÍCULA DE ALUNOS"   );
            System.out.println("================================================");
            System.out.println();

            Aluno alunoEncontrado = null;

            while (alunoEncontrado == null) {
                System.out.print("Digite o registro do aluno desejado: ");
                Integer registro = sc.nextInt();
                sc.nextLine();

                alunoEncontrado = alunos.get(registro);

                if (alunoEncontrado == null) {
                    System.out.println("Registro não encontrada! Digite um registro válida.");
                }
            }

            Turma turmaEncontrada = null;

            while (turmaEncontrada == null) {
                System.out.print("Digite o código da turma: ");
                Integer codigoTurma = sc.nextInt();
                sc.nextLine();

                turmaEncontrada = turmas.get(codigoTurma);

                if (turmaEncontrada == null) {
                    System.out.println("Turma não encontrada! Digite um código válido.");
                }
            }

            for(Matricula matricula : alunoEncontrado.getMatriculas()){
                if(matricula.getTurma().getCodigo().equals(turmaEncontrada.getCodigo())){
                    System.out.println("O aluno selecionado já está matriculado nessa turma!");
                    return;
                }
            }

            System.out.println();
            System.out.println("===== DADOS DA MATRÍCULA CADASTRADA =====");
            System.out.println("Nome: " +alunoEncontrado.getNome());
            System.out.println("Código da turma: " +turmaEncontrada.getCodigo());
            System.out.println();

            System.out.print("Deseja recomeçar o cadastro? [1] Não | [0] Sim: ");
            Integer resposta = sc.nextInt();
            sc.nextLine();
            System.out.println();

            if(resposta == 1){
                new Matricula(alunoEncontrado, turmaEncontrada);
                System.out.print("Registro do aluno " + alunoEncontrado.getNome() + " na turma de código " + turmaEncontrada.getCodigo() + " realizada com sucesso! ");
                break;
            }    
        }
    }

    public static void lancaNota(Scanner sc){

        while(true){
            System.out.println("=================================================");
            System.out.println("   BEM VINDO AO SISTEMA DE LANÇAMENTO DE NOTAS"   );
            System.out.println("=================================================");

            System.out.print("Informe o ID do professor: ");
            Integer idProfessor = sc.nextInt();
            sc.nextLine();

            Professor professor = professores.get(idProfessor);

            if(professor == null){
                System.out.println("Professor não encontrado!");
                return;
            }

            System.out.print("Digite o registro do aluno: ");
            Integer numeroRegistro = sc.nextInt();
            sc.nextLine();

            Aluno aluno = alunos.get(numeroRegistro);

            if(aluno == null){
                System.out.println("Aluno não encontrado!");
                return;
            }

            System.out.print("Digite o código da turma: ");
            Integer codigoTurma = sc.nextInt();
            sc.nextLine();

            Turma turma = professor.getTurmasMinistradas().get(codigoTurma);

            if(turma == null){
                System.out.println("Você não ministra essa turma, lançamentos de notas não autorizado!");
                return;
            }

            Matricula matriculaEncontrada = null;

            for(Matricula matricula : aluno.getMatriculas()){
                if(matricula.getTurma().getCodigo().equals(codigoTurma)){ 
                    matriculaEncontrada = matricula;
                    break;
                }
            }

            if(matriculaEncontrada == null){
                System.out.println("O aluno não está nessa turma!");
                return;
            }

            System.out.println("Quais notas você deseja lançar?");
            System.out.println("[1] P1");
            System.out.println("[2] P2");
            System.out.print("[3] P1 e P2: ");

            Integer opcao = sc.nextInt();
            sc.nextLine();

            Float n1 = null;
            Float n2 = null;

            switch(opcao){
                case 1:
                    System.out.print("Nota P1: ");
                    n1 = sc.nextFloat();

                    if(n1 < 0 || n1 > 10){
                        System.out.println("Nota inválida! Deve ser entre 0 e 10.");
                        return;
                    }

                    matriculaEncontrada.lançarNota1(n1);

                    break;

                case 2:
                    System.out.print("Nota P2: ");
                    n2 = sc.nextFloat();
                    
                    if(n2 < 0 || n2 > 10){
                        System.out.println("Nota inválida! Deve ser entre 0 e 10.");
                        return;
                    }

                    matriculaEncontrada.lançarNota2(n2);
                    break;

                case 3:
                    System.out.print("Nota P1: ");
                    n1 = sc.nextFloat();

                    if(n1 < 0 || n1 > 10){
                        System.out.println("Nota inválida! Deve ser entre 0 e 10.");
                        return;
                    }

                    matriculaEncontrada.lançarNota1(n1);

                    System.out.print("Nota P2: ");
                    n2 = sc.nextFloat();
                    
                    if(n2 < 0 || n2 > 10){
                        System.out.println("Nota inválida! Deve ser entre 0 e 10.");
                        return;
                    }

                    matriculaEncontrada.lançarNota2(n2);
                    break;
            }

            System.out.println();
            System.out.println("===== DADOS DA INSERÇÃO DE NOTA =====");
            System.out.println("Nome do aluno: " +aluno.getNome());
            System.out.println("Código da turma: "+matriculaEncontrada.getTurma().getCodigo()); 
            System.out.println("Notas inseridas: "); 

            if(n1 != null){
                System.out.println("P1: " +n1);
            }

            if(n2 != null){
                System.out.println("P2: " +n2);
            }

            System.out.print("Deseja recomeçar o cadastro? [1] Não | [0] Sim: "); 
            Integer resposta = sc.nextInt(); 
            sc.nextLine(); 
            System.out.println(); 

            if(resposta == 1){ 
                System.out.println("Notas lançadas com sucesso para o aluno " +aluno.getNome());
                matriculaEncontrada.atualizarMediaEStatusSePossivel();
                break;
            }
        }
    }

    public static void registrarFrequencia(Scanner sc){

        System.out.println("=======================================================");
        System.out.println("   BEM VINDO AO SISTEMA DE LANÇAMENTO DE FREQUÊNCIAS"   );
        System.out.println("=======================================================");
        System.out.println();

        System.out.print("Informe o ID do professor: ");
        Integer idProfessor = sc.nextInt();
        sc.nextLine();

        Professor professor = professores.get(idProfessor);

        if(professor == null){
            System.out.println("Professor não encontrado!");
            return;
        }

        if(professor.getTurmasMinistradas().isEmpty()){
            System.out.println("Professor não possui turmas.");
            return;
        }

        List<Turma> listaTurmas = new ArrayList<>();

        for(Turma turma : professor.getTurmasMinistradas().values()) {
            listaTurmas.add(turma);
        }

        System.out.println("\nTurmas:");

        int contador = 1;
        for(Turma turma : listaTurmas){
            System.out.println("[" + contador + "] " + turma.getDisciplina().getNome());
            contador++;
        }

        System.out.print("Escolha a turma: ");
        int escolhaTurma = sc.nextInt();
        sc.nextLine();

        if(escolhaTurma < 1 || escolhaTurma > listaTurmas.size()){
            System.out.println("Opção inválida.");
            return;
        }

        Turma turmaSelecionada = listaTurmas.get(escolhaTurma - 1);

        if(turmaSelecionada.getMatriculas().isEmpty()){
            System.out.println("Nenhum aluno na turma selecionada.");
            return;
        }

        List<Matricula> listaMatriculas = new ArrayList<>(turmaSelecionada.getMatriculas());

        System.out.println("\nAlunos:");

        contador = 1;
        for(Matricula matricula : listaMatriculas){
            System.out.println("[" + contador + "] " + matricula.getAluno().getNome());
            contador++;
        }

        System.out.print("Escolha o aluno: ");
        int escolhaAluno = sc.nextInt();
        sc.nextLine();

        if(escolhaAluno < 1 || escolhaAluno > listaMatriculas.size()){
            System.out.println("Opção inválida.");
            return;
        }

        Matricula matriculaSelecionada = listaMatriculas.get(escolhaAluno - 1);

        System.out.print("O aluno está presente? (1 = Sim / 0 = Não): ");
        int presente = sc.nextInt();

        matriculaSelecionada.registrarPresenca(presente == 1);

        System.out.println("Frequência registrada com sucesso!");
        System.out.println("Percentual atual: " +matriculaSelecionada.getPercentualFrequencia() + " %");
    }

    public static void exibirBoletimAluno(Scanner sc){

        System.out.println("==============================================");
        System.out.println("   SISTEMA DE EMISSÃO DE BOLETIM INDIVIDUAL"   );
        System.out.println("==============================================");
        System.out.println();

        System.out.print("Informe o registro do aluno: ");
        Integer matriculaInformada = sc.nextInt();
        sc.nextLine();

        Aluno alunoAchado = alunos.get(matriculaInformada);

        if(alunoAchado == null){
            System.out.println("Registro não encontrada.");
            return;
        }

        System.out.println("===== NOTAS DO ALUNO "+ alunoAchado.getNome()+" ! =====");

        for (Matricula matricula : alunoAchado.getMatriculas()) {
            System.out.println(
                "Código turma: " + matricula.getTurma().getCodigo() +
                " | Disciplina: " + matricula.getTurma().getDisciplina() +
                " | Professor: " + matricula.getTurma().getProfessor() +
                " | Nota P1: " + matricula.getNota1() +
                " | Nota P2: " + matricula.getNota2() +
                " | Média da disciplina: " + matricula.getMediaDisciplina() +
                " | Frequência da disciplina: " + matricula.getPercentualFrequencia() +
                " | Status da disciplina: " + matricula.getStatus()
            );
            System.out.println();
        }
    }

    public static void exibirRankingTurma(Scanner sc){

        System.out.println("===========================================");
        System.out.println("   SISTEMA DE EMISSÃO DE BOLETIM DA TURMA"  );
        System.out.println("===========================================");
        System.out.println();


        System.out.print("Informe o código da turma a ser exibida: ");
        Integer codigoTurma = sc.nextInt();
        sc.nextLine();

        Turma turmaAchada = turmas.get(codigoTurma);

        if(turmaAchada == null){
            System.out.println("Turma não encontrada!");
            return;
        }

        System.out.println();
        System.out.println("===== NOTAS DA TURMA " + turmaAchada.getCodigo() + " =====");
        System.out.println();

        turmaAchada.getMatriculas().stream().sorted(
        Comparator.comparing(
        Matricula::getMediaDisciplina,
        Comparator.nullsLast(Comparator.reverseOrder())))

        .forEach(matricula -> {System.out.println(
                "Nome do Aluno: " + matricula.getAluno().getNome() +
                " | Média da disciplina: " + matricula.getMediaDisciplina() +
                " | Frequência da disciplina: " + matricula.getPercentualFrequencia() +
                " | Status da disciplina: " + matricula.getStatus()
            );
            System.out.println();});
    }

    public static void geraRelatorio(Scanner sc){
        System.out.println("======================================");
        System.out.println("   SISTEMA DE EMISSÃO DE RELATÓRIOS"   );
        System.out.println("======================================");
        System.out.println();
    }

    public static void mostrarEstatisticas(){

        System.out.println("======================================");
        System.out.println("   ESTATÍSTICAS GERAIS DA FACULDADE   ");
        System.out.println("======================================");
        System.out.println();

        int numeroMatriculas = 0; 
        int contadorReprovadosNota = 0;
        int contadorReprovadosFrequencia = 0;
        int numeroAprovados = 0;
        int alunosEmRisco = 0;

        double notaTotal = 0.0;
        double somaFrequencia = 0.0;
        double maiorMedia = 0.0;
        
        String nomeMelhorAluno = "";

        for(Aluno aluno : alunos.values()){ 

            double somaNotasAluno = 0.0;
            int totalMatriculasAluno = 0;
            boolean alunoEmRisco = false;

            for(Matricula matricula : aluno.getMatriculas()){

                notaTotal += matricula.getMediaDisciplina();
                numeroMatriculas++;
                somaFrequencia += matricula.getPercentualFrequencia();

                somaNotasAluno += matricula.getMediaDisciplina();
                totalMatriculasAluno++;

                if(matricula.getPercentualFrequencia() < 70){
                    alunoEmRisco = true;
                }

                if(matricula.getStatus() == StatusMatricula.APROVADO){
                    numeroAprovados++;
                }else if (matricula.getStatus() == StatusMatricula.REPROVADO_NOTA){
                    contadorReprovadosNota++;
                }else if(matricula.getStatus() == StatusMatricula.REPROVADO_FREQUENCIA){
                    contadorReprovadosFrequencia++;
                }
            }

            if(totalMatriculasAluno > 0){
                double mediaAluno = somaNotasAluno / totalMatriculasAluno;

                if(mediaAluno > maiorMedia){
                    maiorMedia = mediaAluno;
                    nomeMelhorAluno = aluno.getNome();
                }
            }

            if(alunoEmRisco){
                alunosEmRisco++;
            }
        }

        double mediaGeral = 0.0;
        double percentualAprovados = 0.0;
        double mediaFrequencia = 0.0;
        double percentualReprovacao = 0.0;
        double mediaMatriculasPorAluno = 0.0;

        if (numeroMatriculas > 0) {
            mediaGeral = notaTotal / numeroMatriculas;
            percentualAprovados = numeroAprovados * 100.0 / numeroMatriculas;
            mediaFrequencia = somaFrequencia / numeroMatriculas;
            percentualReprovacao = (contadorReprovadosNota + contadorReprovadosFrequencia) * 100.0 / numeroMatriculas;
        }

        if(alunos.size() > 0){
            mediaMatriculasPorAluno = numeroMatriculas * 1.0 / alunos.size();
        }

        System.out.println("Total de alunos: " + alunos.size());
        System.out.println("Total de turmas: " + turmas.size());
        System.out.println("Total de matrículas: " + numeroMatriculas);
        System.out.println();

        System.out.printf("Média geral institucional: %.2f\n", mediaGeral);
        System.out.printf("Percentual geral de aprovação: %.2f%%\n", percentualAprovados);
        System.out.printf("Percentual geral de reprovação: %.2f%%\n", percentualReprovacao);
        System.out.println();

        System.out.println("Total aprovados: " + numeroAprovados);
        System.out.println("Total reprovados por nota: " + contadorReprovadosNota);
        System.out.println("Total reprovados por frequência: " + contadorReprovadosFrequencia);
        System.out.println();

        System.out.printf("Média de frequência da faculdade: %.2f%%\n", mediaFrequencia);
        System.out.printf("Média de matrículas por aluno: %.2f\n", mediaMatriculasPorAluno);
        System.out.println();

        if(!nomeMelhorAluno.isEmpty()){
            System.out.printf("Melhor aluno da faculdade: %s (Média %.2f)\n", nomeMelhorAluno, maiorMedia);
        }
        System.out.println("Alunos em risco por frequência (<75%): " + alunosEmRisco);
    }
}


    










