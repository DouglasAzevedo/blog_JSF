package br.edu.unisep.blog.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name="ds_login")
    private String login;

    @Column(name="ds_senha")
    private String senha;

    @Column(name="ds_usuario")
    private String nome;

    @Column(name="ds_email")
    private String email;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private PapelUsuario papel;
}
