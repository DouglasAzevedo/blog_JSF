package br.edu.unisep.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioDto {

    private String login;
    private String email;
    private String nome;

}
