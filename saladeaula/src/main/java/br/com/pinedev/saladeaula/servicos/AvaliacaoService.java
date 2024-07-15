package br.com.pinedev.saladeaula.servicos;

import br.com.pinedev.saladeaula.modelo.Avaliacao;
import br.com.pinedev.saladeaula.repositorio.AvaliacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public Avaliacao salvarAvaliacao(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public List<Avaliacao> recuperarTodasAvaliacoes() {
        return avaliacaoRepository.findAll();
    }
}
