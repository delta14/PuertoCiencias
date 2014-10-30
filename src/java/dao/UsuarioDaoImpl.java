/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ubl.HibernateUtil;

/**
 *
 * @author Roberto
 */
public class UsuarioDaoImpl implements UsuarioDao {

    @Override
    public Usuario findByUsuario(Usuario usuario) {
        Usuario model = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();

        String sql = "FROM Usuario WHERE usuario = '" + usuario.getUsername() + "' ";

        try {
            sesion.beginTransaction();
            model = (Usuario) sesion.createSQLQuery(sql).uniqueResult();

            sesion.beginTransaction().commit();
        } catch (HibernateException e) {
            sesion.beginTransaction().rollback();
        }
        return model;
    }

    @Override
    public Usuario login(Usuario usuario) {
        Usuario model = this.findByUsuario(usuario);

        if (model != null) {
            if (!usuario.getPass().equals(model.getPass())) {
                model = null;
            }
        }
        return model;

    }
}
