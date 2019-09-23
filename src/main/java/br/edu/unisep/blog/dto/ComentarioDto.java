package br.edu.unisep.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioDto {

    private String conteudo;

    private Integer idPost;

    private String login;

}
