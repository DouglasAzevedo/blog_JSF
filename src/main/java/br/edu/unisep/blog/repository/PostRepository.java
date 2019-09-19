package br.edu.unisep.blog.repository;

import br.edu.unisep.blog.dao.PostDao;
import br.edu.unisep.blog.dto.NovoPostDto;
import br.edu.unisep.blog.dto.PostDto;
import br.edu.unisep.blog.entity.Post;
import br.edu.unisep.blog.entity.Usuario;
import com.rcpadilha.hibernate.exception.DaoException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {

    private PostDao dao = new PostDao();

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

    public List<PostDto> listar(String usuario) {

        var posts = dao.findByUsuario(usuario);

        var retorno = new ArrayList<PostDto>();
        posts.forEach(p -> {

            var conteudo = p.getConteudo();
            if (conteudo.length() > 400) {
                conteudo = conteudo.substring(0, 400) + "...";
            }
            retorno.add(new PostDto(p.getId(), p.getUsuario().getNome(), p.getTitulo(), conteudo, p.getTags(), p.getData()));

        });
        return retorno;
    }

    public PostDto consultar(Integer id) {
        var post = dao.findById(Post.class, id);
        return new PostDto(post.getId(), post.getUsuario().getNome(),
                post.getTitulo(), post.getConteudo(),
                post.getTags(), post.getData());
    }

}
