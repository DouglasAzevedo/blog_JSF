package br.edu.unisep.blog.repository;

import br.edu.unisep.blog.dao.UsuarioDao;
import br.edu.unisep.blog.dto.UsuarioDto;
import br.edu.unisep.blog.entity.Usuario;

public class UsuarioRepository {

    private UsuarioDao dao = new UsuarioDao();

    public UsuarioDto findByLogin(String login) {
        var usuario = dao.findByLogin(login);
        return new UsuarioDto(usuario.getLogin(),
                usuario.getEmail(),
                usuario.getNome());
    }

}
