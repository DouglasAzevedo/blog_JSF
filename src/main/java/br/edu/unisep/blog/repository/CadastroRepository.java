package br.edu.unisep.blog.repository;

import br.edu.unisep.blog.dao.UsuarioDao;
import br.edu.unisep.blog.dto.CadastroDto;
import br.edu.unisep.blog.entity.PapelUsuario;
import br.edu.unisep.blog.entity.Usuario;
import com.rcpadilha.hibernate.exception.DaoException;
import org.apache.commons.codec.digest.DigestUtils;

public class CadastroRepository {

    private UsuarioDao dao = new UsuarioDao();

    public void salvar(CadastroDto novoUsuarioDto) throws DaoException {

        var novoUsuario = new Usuario();

        novoUsuario.setLogin(novoUsuarioDto.getLogin());
        novoUsuario.setNome(novoUsuarioDto.getNome());
        novoUsuario.setEmail(novoUsuarioDto.getEmail());

        var senha = DigestUtils.md5Hex(novoUsuarioDto.getSenha());
        novoUsuario.setSenha(senha);

        var papel = new PapelUsuario();

        papel.setPapel("USER");
        papel.setUsuario(novoUsuario);

        novoUsuario.setPapel(papel);

        dao.save(novoUsuario);
    }

}
