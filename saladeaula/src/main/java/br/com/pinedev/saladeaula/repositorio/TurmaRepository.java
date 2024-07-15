package br.com.pinedev.saladeaula.repositorio;

import br.com.pinedev.saladeaula.modelo.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {
}