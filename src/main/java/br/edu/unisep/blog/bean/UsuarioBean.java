package br.edu.unisep.blog.bean;

import br.edu.unisep.blog.dto.UsuarioDto;
import br.edu.unisep.blog.entity.Usuario;
import br.edu.unisep.blog.repository.UsuarioRepository;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class UsuarioBean implements Serializable {

    private UsuarioRepository repo;

    @Getter
    private UsuarioDto usuario;

    @PostConstruct
    public void iniciar() {
        this.repo = new UsuarioRepository();
    }

    public void obterUsuario(String login) {
        this.usuario = repo.findByLogin(login);
    }

}
