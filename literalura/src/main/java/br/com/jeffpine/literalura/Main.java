package br.com.jeffpine.literalura;

import br.com.jeffpine.literalura.model.Livro;
import br.com.jeffpine.literalura.service.GutendexService;
import br.com.jeffpine.literalura.service.LivroService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        LivroService livroService = context.getBean(LivroService.class);
        GutendexService gutendexService = context.getBean(GutendexService.class);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Buscar livro pelo título");
            System.out.println("2. Listar livros registrados");
            System.out.println("3. Listar autores");
            System.out.println("4. Listar autores em determinado ano");
            System.out.println("5. Listar livros em determinado idioma");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            String option = reader.readLine();

            switch (option) {
                case "1":
                    System.out.print("Digite o título do livro: ");
                    String titulo = reader.readLine();
                    gutendexService.buscarELivroPorTituloESalvar(titulo);
                    System.out.println("Livro buscado e salvo com sucesso.");
                    break;
                case "2":
                    List<Livro> livros = livroService.listarTodos();
                    livros.forEach(livro -> System.out.println(livro));
                    break;
                case "3":
                    List<String> autores = livroService.listarAutores();
                    autores.forEach(System.out::println);
                    break;
                case "4":
                    System.out.print("Digite o ano: ");
                    int ano = Integer.parseInt(reader.readLine());
                    List<String> autoresPorAno = livroService.listarAutoresPorAno(ano);
                    autoresPorAno.forEach(System.out::println);
                    break;
                case "5":
                    System.out.print("Digite o idioma (es, en, fr, pt): ");
                    String idioma = reader.readLine();
                    List<Livro> livrosPorIdioma = livroService.listarLivrosPorIdioma(idioma);
                    livrosPorIdioma.forEach(livro -> System.out.println(livro));
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}