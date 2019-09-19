package br.edu.unisep.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostDto {

    private Integer id;

    private String usuario;

    private String titulo;

    private String conteudo;

    private String tags;

    private LocalDateTime data;

}
