package br.edu.unisep.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComentarioDto {

    private String comentario;

    private Integer id_post;

    private String login;

}
