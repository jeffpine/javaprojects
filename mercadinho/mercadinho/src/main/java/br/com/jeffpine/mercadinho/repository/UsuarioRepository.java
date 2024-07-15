package br.com.jeffpine.mercadinho.repository;

import br.com.jeffpine.mercadinho.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNome(String nome);
}
