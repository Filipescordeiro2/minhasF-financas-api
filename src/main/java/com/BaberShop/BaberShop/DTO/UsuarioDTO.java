package com.BaberShop.BaberShop.DTO;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
public class UsuarioDTO {

    private String email;
    private String nome;
    private String senha;

}
