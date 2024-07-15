package br.com.pinedev.saladeaula.servicos;

import br.com.pinedev.saladeaula.modelo.Turma;
import br.com.pinedev.saladeaula.repositorio.TurmaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Transactional
    public void criarTurma() {
        Turma turma = new Turma();
        turmaRepository.save(turma);
    }

    @Transactional
    public List<Turma> recuperarTodasTurmas() {
        return turmaRepository.findAll();
    }
}
