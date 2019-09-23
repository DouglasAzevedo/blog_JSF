package br.edu.unisep.blog.repository;

import br.edu.unisep.blog.dao.ComentarioDao;
import br.edu.unisep.blog.dto.ComentarioDto;
import br.edu.unisep.blog.entity.Comentario;
import br.edu.unisep.blog.entity.Post;
import br.edu.unisep.blog.entity.Usuario;
import com.rcpadilha.hibernate.exception.DaoException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ComentarioRepository {

    private ComentarioDao dao = new ComentarioDao();

    public void salvar(ComentarioDto comentario) throws DaoException {

        var coment = new Comentario();

        var usuario = new Usuario();
        usuario.setLogin(comentario.getLogin());

        var post = new Post();
        post.setId(comentario.getIdPost());

        coment.setPost(post);
        coment.setUsuario(usuario);
        coment.setConteudo(comentario.getConteudo());
        coment.setData(LocalDateTime.now());

        dao.save(coment);

    }

    public List<ComentarioDto> listar(Integer post) {

        var comentarios = dao.listaComentario(post);

        var retorno = new ArrayList<ComentarioDto>();
        comentarios.forEach(c -> {

            retorno.add(new ComentarioDto(c.getConteudo(),c.getPost().getId(),c.getUsuario().getLogin()));

        });

        return retorno;

    }


}
