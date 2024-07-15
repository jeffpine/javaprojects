package br.com.jeffpine.mercadinho.service;

import br.com.jeffpine.mercadinho.model.Venda;
import br.com.jeffpine.mercadinho.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }

    public Venda salvarVenda(Venda venda) {
        return vendaRepository.save(venda);
    }
}