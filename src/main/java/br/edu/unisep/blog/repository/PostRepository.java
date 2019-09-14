package br.edu.unisep.blog.repository;

import br.edu.unisep.blog.bean.UsuarioBean;
import br.edu.unisep.blog.dto.NovoPostDto;
import br.edu.unisep.blog.entity.Post;
import br.edu.unisep.blog.entity.Usuario;
import com.rcpadilha.hibernate.dao.HibernateDao;
import com.rcpadilha.hibernate.exception.DaoException;

import java.time.LocalDateTime;

public class PostRepository {


    private HibernateDao<Post> dao = new HibernateDao<>();

    public void salvar(NovoPostDto novoPost) throws DaoException {

        var post = new Post();

        post.setConteudo(novoPost.getConteudo());
        post.setTitulo(novoPost.getTitulo());
        post.setTags(novoPost.getTags());
        post.setData(LocalDateTime.now());

        var usuario = new Usuario();
        usuario.setLogin(novoPost.getUsuario());
        post.setUsuario(usuario);

        dao.save(post);
    }

}
