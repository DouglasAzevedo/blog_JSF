package br.edu.unisep.blog.dto;

import lombok.Data;

@Data
public class NovoPostDto {

    private String titulo;

    private String conteudo;

    private String tags;

    private String usuario;

}
