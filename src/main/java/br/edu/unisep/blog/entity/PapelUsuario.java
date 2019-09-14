package br.edu.unisep.blog.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "papel_usuario")
public class PapelUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_papelusuario")
    private Integer id;

    @Column(name="ds_papel")
    private String papel;

    @OneToOne
    @JoinColumn(name="ds_login")
    private Usuario usuario;

}
