package br.edu.unisep.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_comentario")
    private Integer id;

    @OneToOne
    @JoinColumn(name="id_post")
    private Post post;

    @OneToOne
    @JoinColumn(name="ds_login")
    private Usuario usuario;

    @Column(name="ds_comentario")
    private String conteudo;

    @Column(name="dt_comentario")
    private LocalDateTime data;

}
