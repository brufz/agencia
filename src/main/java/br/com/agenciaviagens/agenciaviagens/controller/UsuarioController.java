package br.com.agenciaviagens.agenciaviagens.controller;

import br.com.agenciaviagens.agenciaviagens.model.Usuario;
import br.com.agenciaviagens.agenciaviagens.service.UserDetailsServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsuarioController {


    private final UserDetailsServiceImplements userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioController(UserDetailsServiceImplements userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario criarNovoUsuario(@RequestBody Usuario usuario){
        String encode = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encode);
        return userService.criarUsuario(usuario);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> buscarUsuarios(){
        return userService.buscarUsuarios();
    }
}
