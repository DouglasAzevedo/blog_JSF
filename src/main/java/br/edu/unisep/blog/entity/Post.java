package br.edu.unisep.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_post")
    private Integer id;

    @OneToOne
    @JoinColumn(name="ds_login")
    private Usuario usuario;

    @Column(name="ds_conteudo")
    private String conteudo;

    @Column(name="ds_titulo")
    private String titulo;

    @Column(name="ds_tags")
    private String tags;

    @Column(name="dt_post")
    private LocalDateTime data;

}
