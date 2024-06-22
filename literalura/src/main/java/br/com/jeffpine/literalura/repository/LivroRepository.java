package br.com.jeffpine.literalura.repository;

import br.com.jeffpine.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query("SELECT l FROM Livro l WHERE l.titulo LIKE %:titulo%")
    List<Livro> findByTituloContaining(@Param("titulo") String titulo);

    @Query("SELECT l.autor FROM Livro l WHERE :ano BETWEEN l.anoNascimentoAutor AND l.anoFalecimentoAutor")
    List<String> findAutoresByAno(@Param("ano") int ano);

    List<Livro> findByIdioma(String idioma);
}