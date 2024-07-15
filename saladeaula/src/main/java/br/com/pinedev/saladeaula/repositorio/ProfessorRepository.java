package br.com.pinedev.saladeaula.repositorio;

import br.com.pinedev.saladeaula.modelo.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}