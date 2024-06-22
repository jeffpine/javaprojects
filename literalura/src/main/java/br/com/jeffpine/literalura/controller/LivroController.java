package br.com.jeffpine.literalura.controller;



import br.com.jeffpine.literalura.model.Livro;
import br.com.jeffpine.literalura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> listarTodos() {
        return livroService.listarTodos();
    }

    @GetMapping("/titulo")
    public List<Livro> buscarPorTitulo(@RequestParam String titulo) {
        return livroService.buscarPorTitulo(titulo);
    }

    @GetMapping("/idioma")
    public List<Livro> listarPorIdioma(@RequestParam String idioma) {
        return livroService.listarLivrosPorIdioma(idioma);
    }

    @PostMapping
    public Livro salvar(@RequestBody Livro livro) {
        return livroService.salvar(livro);
    }
}
