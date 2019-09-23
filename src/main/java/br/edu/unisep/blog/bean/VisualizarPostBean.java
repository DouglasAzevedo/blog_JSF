package br.edu.unisep.blog.bean;

import br.edu.unisep.blog.dto.ComentarioDto;
import br.edu.unisep.blog.dto.PostDto;
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
public class VisualizarPostBean {

    @Inject
    private UsuarioBean usuarioBean;

    @Getter
    @Setter
    private Integer idPost;

    @Getter
    @Setter
    private PostDto post;

    @Getter
    @Setter
    private ComentarioDto comentario = new ComentarioDto();

    // lista dos comentarios de acordo com o post.
    @Getter
    @Setter
    private List<ComentarioDto> comentarios;

    private PostRepository repo = new PostRepository();

    private ComentarioRepository cepo = new ComentarioRepository();

    public void iniciar() {
        this.comentarios = cepo.listar(idPost);
        this.post = repo.consultar(idPost);
    }

    public String novoComentario() {
        try {
            comentario.setLogin(usuarioBean.getUsuario().getLogin());
            comentario.setIdPost(idPost);
            cepo.salvar(comentario);
            return "/post?faces-redirect-true";
        } catch (DaoException e) {
            e.printStackTrace();
            return "Erro";
        }
    }

}
