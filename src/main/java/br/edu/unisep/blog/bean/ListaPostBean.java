package br.edu.unisep.blog.bean;

import br.edu.unisep.blog.dto.PostDto;
import br.edu.unisep.blog.repository.PostRepository;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListaPostBean {

    @Inject
    private UsuarioBean usuario;

    private PostRepository postRepository;

    @Getter @Setter
    private List<PostDto> posts;

    @PostConstruct
    public void iniciar(){
        this.postRepository = new PostRepository();
        this.posts = postRepository.listar(usuario.getUsuario().getLogin());
    }
}
