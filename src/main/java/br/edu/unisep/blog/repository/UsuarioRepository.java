package br.edu.unisep.blog.repository;

import br.edu.unisep.blog.dao.UsuarioDao;
import br.edu.unisep.blog.dto.CadastroDto;
import br.edu.unisep.blog.dto.UsuarioDto;
import br.edu.unisep.blog.entity.PapelUsuario;
import br.edu.unisep.blog.entity.Usuario;
import com.rcpadilha.hibernate.exception.DaoException;
import org.apache.commons.codec.digest.DigestUtils;

public class UsuarioRepository {

    private UsuarioDao dao = new UsuarioDao();

    public UsuarioDto findByLogin(String login) {

        var usuario = dao.findByLogin(login);

     return new UsuarioDto(usuario.getLogin(),usuario.getEmail(),usuario.getNome());
    }

    public void salvarNovoUsuario(CadastroDto novoUsuario) throws DaoException {

        var usuario = new Usuario();

        usuario.setLogin(novoUsuario.getLogin());
        usuario.setNome(novoUsuario.getNome());
        usuario.setEmail(novoUsuario.getEmail());

        var senha = DigestUtils.md5Hex(novoUsuario.getSenha());
        usuario.setSenha(senha);

        var papel = new PapelUsuario();

        papel.setPapel("USER");
        papel.setUsuario(usuario);
        usuario.setPapel(papel);

        dao.save(usuario);
    }

}
