package br.edu.unisep.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PerfilDto {

    private String nome;

    private String email;

    private String senha;

    public PerfilDto(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
