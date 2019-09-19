package br.edu.unisep.blog.bean;

import br.edu.unisep.blog.dto.NovoPostDto;
import br.edu.unisep.blog.repository.PostRepository;
import com.rcpadilha.hibernate.exception.DaoException;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class NovoPostBean {

    @Getter @Setter
    private NovoPostDto novoPost = new NovoPostDto();

    private PostRepository postRepository = new PostRepository();

    @Inject
    private UsuarioBean usuarioBean;

    public String salvar() {
        try {
            novoPost.setUsuario(usuarioBean.getUsuario().getLogin());
            postRepository.salvar(novoPost);
            return "/app/home?faces-redirect=true";
        } catch (DaoException e) {
            e.printStackTrace();
            return "/app/novoPost";
        }
    }
}
