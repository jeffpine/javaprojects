package br.com.pinedev.saladeaula;

import br.com.pinedev.saladeaula.modelo.Aluno;
import br.com.pinedev.saladeaula.servicos.AlunoService;
import br.com.pinedev.saladeaula.servicos.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Main {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private TurmaService turmaService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("Menu:");
                System.out.println("1. Adicionar Aluno");
                System.out.println("2. Listar Alunos");
                System.out.println("3. Criar Turma");
                System.out.println("4. Listar Turmas");
                System.out.println("5. Sair");

                System.out.print("Escolha uma opção: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha

                switch (choice) {
                    case 1:
                        adicionarAluno(scanner);
                        break;
                    case 2:
                        listarAlunos();
                        break;
                    case 3:
                        criarTurma();
                        break;
                    case 4:
                        listarTurmas();
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }

            scanner.close();
        };
    }

    private void adicionarAluno(Scanner scanner) {
        System.out.print("Nome do Aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone do Aluno: ");
        String telefone = scanner.nextLine();

        System.out.print("Data de Nascimento (yyyy-mm-dd): ");
        String dataNascimento = scanner.nextLine();

        alunoService.adicionarAluno(nome, telefone, dataNascimento);
        System.out.println("Aluno adicionado com sucesso!");
    }

    private void listarAlunos() {
        List<Aluno> alunos = alunoService.recuperarTodosAlunos();
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            alunos.forEach(aluno -> {
                System.out.println("ID: " + aluno.getId() + ", Nome: " + aluno.getNome());
            });
        }
    }

    private void criarTurma() {
        turmaService.criarTurma();
        System.out.println("Turma criada com sucesso!");
    }

    private void listarTurmas() {
        turmaService.recuperarTodasTurmas().forEach(turma -> {
            System.out.println("ID: " + turma.getId() + ", Número de Alunos: " + turma.getAlunos().size());
        });
    }
}
