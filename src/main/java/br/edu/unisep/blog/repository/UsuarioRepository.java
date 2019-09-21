package br.edu.unisep.blog.repository;

import br.edu.unisep.blog.dao.UsuarioDao;
import br.edu.unisep.blog.dto.PerfilDto;
import br.edu.unisep.blog.dto.UsuarioDto;
import br.edu.unisep.blog.entity.Usuario;
import com.rcpadilha.hibernate.exception.DaoException;

public class UsuarioRepository {

    private UsuarioDao dao = new UsuarioDao();

    public UsuarioDto findByLogin(String login) {
        var usuario = dao.findByLogin(login);
        return new UsuarioDto(usuario.getLogin(),
                usuario.getEmail(),
                usuario.getNome());
    }

    public PerfilDto buscarDadosPerfil (String login) {
        var usuario = dao.findByLogin(login);
        return new PerfilDto(usuario.getNome(),usuario.getEmail());
    }

    public void editar(String login, PerfilDto perfilDto) {
        var usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setNome(perfilDto.getNome());
        usuario.setEmail(perfilDto.getEmail());
        usuario.setSenha(perfilDto.getSenha());

        try {
            dao.update(usuario);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

}
