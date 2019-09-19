package br.edu.unisep.blog.dao;

import br.edu.unisep.blog.entity.Post;
import br.edu.unisep.blog.entity.Usuario;
import com.rcpadilha.hibernate.dao.HibernateDao;
import com.rcpadilha.hibernate.factory.HibernateSessionFactory;
import org.hibernate.Hibernate;

import java.util.List;


public class PostDao extends HibernateDao<Post> {

    public List<Post> findByUsuario(String login) {
        var session = HibernateSessionFactory.getSession();
        var query = session.createQuery("from Post where usuario.login = :USUARIO", Post.class);
        query.setParameter("USUARIO", login);

        var lista = query.list();
        session.close();

        return lista;
    }
}
