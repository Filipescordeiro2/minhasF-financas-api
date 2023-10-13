package com.BaberShop.BaberShop.Controller;


import com.BaberShop.BaberShop.DTO.UsuarioDTO;
import com.BaberShop.BaberShop.Service.LancamentoService;
import com.BaberShop.BaberShop.Service.UsuarioService;
import com.BaberShop.BaberShop.exception.ErroAutenticacao;
import com.BaberShop.BaberShop.exception.RegraNegocioException;
import com.BaberShop.BaberShop.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

@Autowired
private UsuarioService service;
@Autowired
private LancamentoService lancamentoService;
  
@PostMapping("/autenticar")
    public ResponseEntity autenticar(@RequestBody UsuarioDTO dto){
try {
   Usuario usuarioAuteticado = service.autenticar(dto.getEmail(), dto.getSenha());
   return ResponseEntity.ok(usuarioAuteticado);
}catch (ErroAutenticacao e){
    return ResponseEntity.badRequest().body(e.getMessage());
}
    }

    @PostMapping
    public ResponseEntity salvar (@RequestBody UsuarioDTO dto){

        Usuario usuario = Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha()).build();

try {
  Usuario usuarioSalvo = service.salvarUsuario(usuario);
  return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
}catch (RegraNegocioException e){
    return ResponseEntity.badRequest().body(e.getMessage());
}

    }
    @GetMapping("{id}/saldo")
    public ResponseEntity obterSaldo(@PathVariable ("id")Long id){
        Optional<Usuario>usuario=service.obterPorId(id);
        if (!usuario.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        BigDecimal saldo=lancamentoService.obterSaldoPorUsuario(id);

    return ResponseEntity.ok(saldo);
    }

}
