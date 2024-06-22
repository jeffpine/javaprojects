package br.com.jeffpine.literalura.service;

import br.com.jeffpine.literalura.model.Livro;
import br.com.jeffpine.literalura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        return livroRepository.findByTituloContaining(titulo);
    }

    public List<String> listarAutores() {
        return livroRepository.findAll()
                .stream()
                .map(Livro::getAutor)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> listarAutoresPorAno(int ano) {
        return livroRepository.findAutoresByAno(ano);
    }

    public List<Livro> listarLivrosPorIdioma(String idioma) {
        return livroRepository.findByIdioma(idioma);
    }
}