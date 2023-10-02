package com.BaberShop.BaberShop.Service;

import com.BaberShop.BaberShop.model.Usuario;

public interface UsuarioService {

    Usuario autenticar(String email,String senha);

    Usuario salvarUsuario(Usuario usuario);

    void validarEmail(String email);


}
