package br.com.pinedev.saladeaula.repositorio;


import br.com.pinedev.saladeaula.modelo.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}