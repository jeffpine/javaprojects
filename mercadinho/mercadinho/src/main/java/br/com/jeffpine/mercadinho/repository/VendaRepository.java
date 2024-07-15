package br.com.jeffpine.mercadinho.repository;

import br.com.jeffpine.mercadinho.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
