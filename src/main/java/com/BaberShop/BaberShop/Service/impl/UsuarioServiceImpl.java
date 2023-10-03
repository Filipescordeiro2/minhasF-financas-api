package com.BaberShop.BaberShop.Service.impl;

import com.BaberShop.BaberShop.Repository.UsuarioRepository;
import com.BaberShop.BaberShop.Service.UsuarioService;
import com.BaberShop.BaberShop.exception.ErroAutenticacao;
import com.BaberShop.BaberShop.exception.RegraNegocioException;
import com.BaberShop.BaberShop.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario autenticar(String email, String senha) {
 Optional<Usuario>usuario= repository.findByEmail(email);
 if (!usuario.isPresent()){

     throw new ErroAutenticacao("usuario não encontrado para o email encontrado");
 }
 if(usuario.get().getSenha().equals(senha)){
     throw new ErroAutenticacao("Senha Incorreta");

 }
     return usuario.get();

    }

    @Override
    @Transactional
    public Usuario salvarUsuario(Usuario usuario) {
        validarEmail(usuario.getEmail());
        return repository.save(usuario);
    }

    @Override
    public void validarEmail(String email) {
    boolean existe =repository.existsByEmail(email);
     if (existe){
    throw new RegraNegocioException("Ja existe um usuario cadastrado com esse email");
}
    }

    @Override
    public Optional<Usuario> obterPorId(Long id) {
        return repository.findById(id);
    }

}
