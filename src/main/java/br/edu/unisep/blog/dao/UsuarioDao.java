package br.edu.unisep.blog.dao;

import br.edu.unisep.blog.entity.Usuario;
import com.rcpadilha.hibernate.dao.HibernateDao;
import com.rcpadilha.hibernate.factory.HibernateSessionFactory;

public class UsuarioDao extends HibernateDao<Usuario> {

    public Usuario findByLogin(String login) {
        var session = HibernateSessionFactory.getSession();

        var q = session.createQuery("from Usuario where login = :LOGIN", Usuario.class);
        q.setParameter("LOGIN", login);

        var usuario = q.uniqueResult();
        session.close();

        return usuario;
    }

}
