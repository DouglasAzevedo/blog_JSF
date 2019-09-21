package br.edu.unisep.blog.bean;

import br.edu.unisep.blog.dto.ComentarioDto;
import br.edu.unisep.blog.dto.PostDto;
import br.edu.unisep.blog.entity.Comentario;
import br.edu.unisep.blog.repository.ComentarioRepository;
import br.edu.unisep.blog.repository.PostRepository;
import com.rcpadilha.hibernate.exception.DaoException;
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

    @Getter @Setter
    private ComentarioDto novoComentario = new ComentarioDto();

    private ComentarioRepository cepo;

    //lista dos posts do banco
    @Getter
    @Setter
    private List<PostDto> posts;

    @Getter
    @Setter
    private List<ComentarioDto> comentarios;


    @PostConstruct
    public void iniciar() {
        this.repo = new PostRepository();
        this.posts = repo.listar(usuarioBean.getUsuario().getLogin());
        this.cepo = new ComentarioRepository();
    }

    public String novoComentario() {
        try {
            cepo.salvar(novoComentario);
            return "/post?faces-redirect-true";
        } catch (DaoException e) {
            e.printStackTrace();
            return "Erro";
        }
    }



}
