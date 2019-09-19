package br.edu.unisep.blog.bean;

import br.edu.unisep.blog.dto.PostDto;
import br.edu.unisep.blog.entity.Post;
import br.edu.unisep.blog.repository.PostRepository;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class VisualizarPostBean {

    @Getter @Setter
    private Integer idPost;

    @Getter @Setter
    private PostDto post;

    private PostRepository postRepository;

    public void iniciar() {
        this.postRepository = new PostRepository();
        this.post = postRepository.consultar(idPost);
    }
}
