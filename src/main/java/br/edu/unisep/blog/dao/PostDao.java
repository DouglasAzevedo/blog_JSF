package br.edu.unisep.blog.dao;

import br.edu.unisep.blog.entity.Post;
import com.rcpadilha.hibernate.dao.HibernateDao;
import com.rcpadilha.hibernate.factory.HibernateSessionFactory;

import java.util.List;

public class PostDao extends HibernateDao<Post> {

    public List<Post> findByUsuario(String usuario) {
        var session = HibernateSessionFactory.getSession();
        var q = session.createQuery("from Post where usuario.login = :USUARIO", Post.class);
        q.setParameter("USUARIO", usuario);

        var lista = q.list();

        session.close();

        return lista;
    }

    

}
