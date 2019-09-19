package br.edu.unisep.blog.bean;

import br.edu.unisep.blog.dto.PostDto;
import br.edu.unisep.blog.repository.PostRepository;
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

    // usuario logado
    @Inject
    private UsuarioBean usuarioBean;

    private PostRepository repo;

    //lista dos posts do banco
    @Getter
    @Setter
    private List<PostDto> posts;

    @PostConstruct
    public void iniciar() {
        this.repo = new PostRepository();
        this.posts = repo.listar(usuarioBean.getUsuario().getLogin());
    }

}
