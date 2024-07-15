package br.com.pinedev.saladeaula.repositorio;

import br.com.pinedev.saladeaula.modelo.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
}
