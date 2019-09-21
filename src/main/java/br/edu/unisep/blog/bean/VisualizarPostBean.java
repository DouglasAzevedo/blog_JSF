package br.edu.unisep.blog.bean;

import br.edu.unisep.blog.dto.ComentarioDto;
import br.edu.unisep.blog.dto.PostDto;
import br.edu.unisep.blog.entity.Comentario;
import br.edu.unisep.blog.repository.ComentarioRepository;
import br.edu.unisep.blog.repository.PostRepository;
import com.rcpadilha.hibernate.exception.DaoException;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class VisualizarPostBean {

    @Getter
    @Setter
    private Integer idPost;

    @Getter
    @Setter
    private PostDto post;

    @Getter
    @Setter
    private ComentarioDto comentario;

    @Getter
    @Setter
    private List<ComentarioDto> comentarios;

    private PostRepository repo;

    private ComentarioRepository cepo;




    public void iniciar() {
        this.repo = new PostRepository();
        this.cepo = new ComentarioRepository();

        this.comentarios = cepo.listar(idPost);
        this.post = repo.consultar(idPost);
    }

        public String novoComentario() {
        try {
            cepo.salvar(comentario);
            return "/post?faces-redirect-true";
        } catch (DaoException e) {
            e.printStackTrace();
            return "Erro";
        }
    }

}
