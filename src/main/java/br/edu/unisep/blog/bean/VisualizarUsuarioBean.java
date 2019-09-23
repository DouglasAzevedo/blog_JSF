package br.edu.unisep.blog.bean;

import br.edu.unisep.blog.dto.PerfilDto;
import br.edu.unisep.blog.dto.PostDto;
import br.edu.unisep.blog.dto.UsuarioDto;
import br.edu.unisep.blog.repository.PostRepository;
import br.edu.unisep.blog.repository.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class VisualizarUsuarioBean {

    @Getter @Setter
    private String idUsuario;

    @Getter @Setter
    private List<PostDto> posts;

    @Getter @Setter
    private PerfilDto usuario = new PerfilDto();

    private PostRepository repo = new PostRepository();

    private UsuarioRepository usuRepo = new UsuarioRepository();

    public void iniciar() {
        posts = repo.listar(idUsuario);
        usuario = usuRepo.buscarDadosPerfil(idUsuario);
    }
}
