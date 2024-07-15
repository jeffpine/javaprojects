package br.com.pinedev.saladeaula.servicos;

import br.com.pinedev.saladeaula.modelo.Aluno;
import br.com.pinedev.saladeaula.repositorio.AlunoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional
    public void adicionarAluno(String nome, String telefone, String dataNascimento) {
        Aluno aluno = new Aluno(nome, telefone, dataNascimento);
        alunoRepository.save(aluno);
    }

    @Transactional
    public List<Aluno> recuperarTodosAlunos() {
        return alunoRepository.findAll();
    }
}
