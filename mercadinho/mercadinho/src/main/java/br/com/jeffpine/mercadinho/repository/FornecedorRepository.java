package br.com.jeffpine.mercadinho.repository;

import br.com.jeffpine.mercadinho.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
