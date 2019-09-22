package br.edu.unisep.blog.dao;

import br.edu.unisep.blog.entity.Usuario;
import com.rcpadilha.hibernate.dao.HibernateDao;
import com.rcpadilha.hibernate.factory.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao extends HibernateDao<Usuario> {

    public Usuario findByLogin(String login) {
        var session = HibernateSessionFactory.getSession();

        var q = session.createQuery("from Usuario where login = :LOGIN", Usuario.class);
        q.setParameter("LOGIN", login);

        var usuario = q.uniqueResult();
        session.close();

        return usuario;
    }

    public List<Usuario> listar(String loginAtual) {
        var session = HibernateSessionFactory.getSession();
        var q = session.createQuery("from Usuario where login <> :LOGIN", Usuario.class);
        q.setParameter("LOGIN", loginAtual);
        var usuarios = q.list();
        session.close();
        return usuarios;
    }

}
