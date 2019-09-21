package br.edu.unisep.blog.dto;

import lombok.Data;

@Data
public class CadastroDto {

    private String login;

    private String email;

    private String nome;

    private String senha;

    private Integer papel;

}
