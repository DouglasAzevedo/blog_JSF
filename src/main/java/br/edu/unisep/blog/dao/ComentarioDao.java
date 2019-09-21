package br.edu.unisep.blog.dao;

import br.edu.unisep.blog.entity.Comentario;
import com.rcpadilha.hibernate.dao.HibernateDao;
import com.rcpadilha.hibernate.factory.HibernateSessionFactory;

import java.util.List;

public class ComentarioDao extends HibernateDao<Comentario> {

    public List<Comentario> listaComentario(String post) {
        var session = HibernateSessionFactory.getSession();
        var q = session.createQuery("from Comentario where comentario.post = :POST", Comentario.class);
        q.setParameter("POST", post);

        var lista = q.list();

        session.close();

        return lista;
    }

}
