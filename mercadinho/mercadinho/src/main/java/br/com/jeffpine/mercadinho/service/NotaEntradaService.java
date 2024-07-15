package br.com.jeffpine.mercadinho.service;

import br.com.jeffpine.mercadinho.model.NotaEntrada;
import br.com.jeffpine.mercadinho.repository.NotaEntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaEntradaService {
    @Autowired
    private NotaEntradaRepository notaEntradaRepository;

    public List<NotaEntrada> listarNotasEntrada() {
        return notaEntradaRepository.findAll();
    }

    public NotaEntrada salvarNotaEntrada(NotaEntrada notaEntrada) {
        return notaEntradaRepository.save(notaEntrada);
    }
}