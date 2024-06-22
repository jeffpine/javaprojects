package br.com.jeffpine.literalura.controller;


import br.com.jeffpine.literalura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<String> listarAutores() {
        return livroService.listarAutores();
    }

    @GetMapping("/ano")
    public List<String> listarAutoresPorAno(@RequestParam int ano) {
        return livroService.listarAutoresPorAno(ano);
    }
}