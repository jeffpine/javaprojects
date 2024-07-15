package br.com.jeffpine.mercadinho.repository;

import br.com.jeffpine.mercadinho.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
