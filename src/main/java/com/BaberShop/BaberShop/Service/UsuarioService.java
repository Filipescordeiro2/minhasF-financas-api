package com.BaberShop.BaberShop.Service;

import com.BaberShop.BaberShop.model.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Usuario autenticar(String email,String senha);

    Usuario salvarUsuario(Usuario usuario);

    void validarEmail(String email);

    Optional<Usuario> obterPorId(Long id);
}
