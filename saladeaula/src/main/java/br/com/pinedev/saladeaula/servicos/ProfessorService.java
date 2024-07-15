package br.com.pinedev.saladeaula.servicos;

import br.com.pinedev.saladeaula.modelo.Professor;
import br.com.pinedev.saladeaula.repositorio.ProfessorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor salvarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> recuperarTodosProfessores() {
        return professorRepository.findAll();
    }
}