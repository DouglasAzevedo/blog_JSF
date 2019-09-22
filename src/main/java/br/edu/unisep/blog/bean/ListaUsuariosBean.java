package br.edu.unisep.blog.bean;

import br.edu.unisep.blog.dto.UsuarioDto;
import br.edu.unisep.blog.repository.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListaUsuariosBean {

    @Inject
    private UsuarioBean usuarioLogado;

    @Getter @Setter
    private List<UsuarioDto> usuarios;

    private UsuarioRepository repo;

    @PostConstruct
    public void iniciar() {
        repo = new UsuarioRepository();
        usuarios = repo.listar(usuarioLogado.getUsuario().getLogin());
    }
}
