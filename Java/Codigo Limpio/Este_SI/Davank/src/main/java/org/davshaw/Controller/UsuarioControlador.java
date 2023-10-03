package org.davshaw.Controller;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import org.davshaw.Model.derivatedentities.RegistroGrupo;
import org.davshaw.Model.pureentities.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UsuarioControlador
{

    /*
    ! CRUD
    ! C - Create DONE
    ! R - Read DONE
    ! U - Update DONE
    ! D - Delete  DONE

    ? Hibernate structure

    SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();
            session.persist(usuario);
            session.getTransaction().commit();
            

            return TORETURN;
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return TORETURN;
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    */

    public static String crearUsuario(
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

            Usuario usuario = new Usuario();
            
            //Establecer datos con setters (Reemplazando el constructor)
            usuario.setDni(dni);
            usuario.setPrimerNombre(primerNombre);
            usuario.setSegundoNombre(segundoNombre);
            usuario.setPrimerApellido(primerApellido);
            usuario.setSegundoApellido(segundoApellido);
            usuario.setContraseña(contraseña);

            session.beginTransaction();
            
            session.persist(usuario);
            
            session.getTransaction().commit();
            
            //Controlador de Cuentas
            CuentaControlador.crearCuenta(dni);
            

            return "Usuario creado correctamente.";
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al crear usuario.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }

    }

    public static Boolean existeUsuario(int dni)
    {
        SessionFactory sessionFactory = new
        Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();
    

        try
        {
            String sql = "SELECT COUNT(*) FROM Usuario WHERE dni = :dni";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("dni", dni);

    
            // Obtener el resultado de la consulta (cantidad de usuarios con el DNI dado)
            int count = ((Number) query.uniqueResult()).intValue();
    
            // Si count es mayor que 0, significa que existe un usuario con ese DNI
            return count > 0;
        }
        
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        
        finally
        {
            session.close();
            sessionFactory.close();
        }
    
    }

    public String eliminarUsuario(int dni)
    {
        SessionFactory sessionFactory = new
        Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();
    
        Session session = sessionFactory.openSession();
    
        try
        {
            if((UsuarioControlador.existeUsuario(dni)))
            {
                Usuario usuario = session.get(Usuario.class, dni);
                
                session.beginTransaction();
                session.remove(usuario);
                session.getTransaction().commit();
                sessionFactory.close();
                
                return "Usuario eliminado con éxito.";    
            }

            else
            {
                throw new IllegalStateException("Aja");
            }
            

        }
        
        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al eliminar usuario.";
        }
        
        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static Usuario obtenerUsuario(int dni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            session.beginTransaction();

            Usuario usuario = session.get(Usuario.class, dni);

            session.getTransaction().commit();

            return usuario;
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static String cambiarPrimerNombre(int dni, String nombre)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(UsuarioControlador.existeUsuario(dni))
            {
                session.beginTransaction();

                Usuario usuario = session.get(Usuario.class, dni);

                usuario.setPrimerNombre(nombre);
                session.merge(usuario);

                session.getTransaction().commit();

                return "Primer nombre cambiado con éxito.";
                

            }

            else
            {
                throw new IllegalArgumentException("No existe un usuario con este DNI");
            }

        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al cambiar el primer nombre.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static String cambiarSegundoNombre(int dni, String nombre)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(UsuarioControlador.existeUsuario(dni))
            {
                session.beginTransaction();

                Usuario usuario = session.get(Usuario.class, dni);

                usuario.setSegundoNombre(nombre);
                session.merge(usuario);

                session.getTransaction().commit();

                return "Segundo nombre cambiado con éxito.";
                

            }

            else
            {
                throw new IllegalArgumentException("No existe un usuario con este DNI");
            }

        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al cambiar el segundo nombre.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static String cambiarPrimerApellido(int dni, String apellido)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(UsuarioControlador.existeUsuario(dni))
            {
                session.beginTransaction();

                Usuario usuario = session.get(Usuario.class, dni);

                usuario.setPrimerApellido(apellido);
                session.merge(usuario);

                session.getTransaction().commit();

                return "Primer apellido cambiado con éxito.";
                

            }

            else
            {
                throw new IllegalArgumentException("No existe un usuario con este DNI");
            }

        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al cambiar el primer apellido.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static String cambiarSegundoApellido(int dni, String apellido)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que exista
            if(UsuarioControlador.existeUsuario(dni))
            {
                session.beginTransaction();

                Usuario usuario = session.get(Usuario.class, dni);

                usuario.setSegundoApellido(apellido);
                session.merge(usuario);

                session.getTransaction().commit();

                return "Segundo appelido cambiado con éxito.";
                

            }

            else
            {
                throw new IllegalArgumentException("No existe un usuario con este DNI");
            }

        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al cambiar el segundo apellido.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static String cambiarContrasena(int dni, String contrasena, String nuevaContrasena)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //!Verificar que exista
            if(UsuarioControlador.existeUsuario(dni))
            {
                session.beginTransaction();
                Usuario usuario = session.get(Usuario.class, dni);
                //!Verificar que la contraseña concuerde
                if(usuario.getContraseña().equals(contrasena))
                {
                    usuario.setContraseña(nuevaContrasena);
                    session.merge(usuario);
    
                    session.getTransaction().commit();
    
                    return "Contraseña cambiado con éxito.";
                }

                else
                {
                throw new IllegalArgumentException("Credenciales inválidas.");
                }
            }

            else
            {
                throw new IllegalArgumentException("No existe un usuario con este DNI");
            }

        }

        catch (Exception e)
        {
            e.printStackTrace();
            return "Error al cambiar la contraseña.";
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static Integer contadorGrupos(int usuariodni)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el usuario exista
            if(!(UsuarioControlador.existeUsuario(usuariodni)))
            {
                throw new IllegalArgumentException("No existe un usuario con este dni.");
            }

            session.beginTransaction();

            String sql = "SELECT Count(*) FROM RegistroGrupo WHERE (usuariodni = :usuariodni and nativo = :nativo)";
            Query<Long> query = session.createNativeQuery(sql, Long.class);
            query.setParameter("usuariodni", usuariodni);
            query.setParameter("nativo", true);
            session.getTransaction().commit();

            int count = Integer.valueOf(query.uniqueResult().toString());
            return count;
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static Boolean entrarGrupo(int usuariodni, int grupoid)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el grupo exista
            if(!(GrupoControlador.existeGrupo(grupoid)))
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
            }
            
            //Verificar que el usuario no este en mas de >= 3 grupos
            else if(UsuarioControlador.contadorGrupos(usuariodni) >= 3)
            {
                throw new IllegalArgumentException("El usuario está en el máximo de grupos permitidos.");
            }
            session.beginTransaction();

            RegistroGrupo registro = new RegistroGrupo();
            registro.setGrupoId(grupoid);
            registro.setNativo(true);
            registro.setUsuarioDni(usuariodni);

            session.persist(registro);

            session.getTransaction().commit();

            return true;
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static Boolean salirGrupo(int usuariodni, int grupoid)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el usuario este en al menos un grupo
            if(UsuarioControlador.contadorGrupos(usuariodni) <= 0)
            {
                throw new IllegalArgumentException("El usuario no está en ningún grupo.");
            }

            //Verificar que el grupo exista
            else if(!(GrupoControlador.existeGrupo(grupoid)))
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
            }

            //Obtener ID del registro
            Integer registroId = UsuarioControlador.obtenerRegistroId(usuariodni, grupoid);

            //Verificar que el registroId no sea null (No existe el registro)
            if (registroId == null)
            {
                throw new IllegalArgumentException("No se encontró que el usuario éste en un grupo con este id.");
            }

            session.beginTransaction();

            RegistroGrupo registro = RegistroGrupoControlador.obtenerRegistro(registroId);
            session.remove(registro);

            session.getTransaction().commit();

            return true;
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }

    public static Integer obtenerRegistroId(int usuariodni, int grupoid)
    {
        SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Usuario.class)
        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try
        {
            //Verificar que el grupo exista
            if(!(GrupoControlador.existeGrupo(grupoid)))
            {
                throw new IllegalArgumentException("No existe un grupo con este id.");
            }

            //Verificar que el usuario exista
            else if(!(UsuarioControlador.existeUsuario(usuariodni)))
            {
                throw new IllegalArgumentException("No existe un usuario con este dni.");
            }

            session.beginTransaction();

            String sql = "SELECT id FROM RegistroGrupo WHERE (grupoid = :grupoid AND usuariodni = :usuariodni AND nativo = :nativo)";
            Query<Integer> query = session.createNativeQuery(sql, Integer.class);
            query.setParameter("usuariodni", usuariodni);
            query.setParameter("grupoid", grupoid);
            query.setParameter("nativo", true);


            Integer id = (Integer) query.uniqueResult();

            session.getTransaction().commit();

            return id;
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        finally
        {
            session.close();
            sessionFactory.close();
        }
    }
}


