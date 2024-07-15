package br.com.jeffpine.mercadinho.controller;


import br.com.jeffpine.mercadinho.dto.LoginDto;
import br.com.jeffpine.mercadinho.model.Usuario;
import br.com.jeffpine.mercadinho.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody LoginDto loginDto){
        Usuario usuario = usuarioService.login(loginDto.getNome(), loginDto.getSenha());
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
