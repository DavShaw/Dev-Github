package org.davshaw.controller;

import org.davshaw.classes.Usuario;

import org.hibernate.cfg.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UsuarioController
{
    public String crearUsuario(
    int dni,
    String primerNombre,
    String segundoNombre,
    String primerApellido,
    String segundoApellido,
    String contraseña)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {

            Usuario usuario = new
            Usuario(
            dni,
            primerNombre,
            segundoNombre,
            primerApellido,
            segundoApellido,
            contraseña);

            session.beginTransaction();
            session.persist(usuario);
            session.getTransaction().commit();
            

            sessionFactory.close();

            return "Usuario creado correctamente.";
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "Error al crear usuario.";
    }
}
