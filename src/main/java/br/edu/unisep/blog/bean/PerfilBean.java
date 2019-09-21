package br.edu.unisep.blog.bean;

import br.edu.unisep.blog.dto.PerfilDto;
import br.edu.unisep.blog.repository.UsuarioRepository;
import com.rcpadilha.hibernate.exception.DaoException;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class PerfilBean {

    @Inject
    private UsuarioBean usuarioBean;

    private UsuarioRepository repo;

    @Getter @Setter
    private PerfilDto perfilDto = new PerfilDto();

    @PostConstruct
    public void iniciar(){
        repo = new UsuarioRepository();
        perfilDto = repo.buscarDadosPerfil(usuarioBean.getUsuario().getLogin());
    }

    public String salvar() {
        perfilDto.setSenha(DigestUtils.md5Hex(perfilDto.getSenha()));
        try {
            repo.editar(usuarioBean.getUsuario().getLogin() ,perfilDto);
            return "/app/perfil?faces-redirect=true";
        } catch (DaoException e) {
            e.printStackTrace();
            return "/app/novoPerfil";
        }
    }
}
