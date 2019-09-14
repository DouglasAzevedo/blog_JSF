package br.edu.unisep.blog.repository;

import br.edu.unisep.blog.dao.UsuarioDao;
import br.edu.unisep.blog.entity.Usuario;

public class UsuarioRepository {

    private UsuarioDao dao = new UsuarioDao();

    public Usuario findByLogin(String login) {
        return dao.findByLogin(login);
    }

}
