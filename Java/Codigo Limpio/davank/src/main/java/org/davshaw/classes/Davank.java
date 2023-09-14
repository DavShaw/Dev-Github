package org.davshaw.classes;

import java.util.ArrayList;
import java.util.List;

public class Davank
{
    private String nombre;
    private List<Grupo> gruposDeAhorros = new ArrayList<Grupo>();
    private List<Usuario> usuariosDelBanco = new ArrayList<Usuario>();
    private List<Cuenta> cuentasDelBanco = new ArrayList<Cuenta>();

    public Davank(String nombre)
    {
        this.nombre = nombre;
    }

    public void registrarPersona(String n1, String n2, String a1, String a2, int dni, String pass)
    {
        //Instanciar persona
        Usuario usuario = new Usuario(this,n1,n2,a1,a2,dni,pass);
        //Agregarlo a la lista de usuarios del banco
        this.usuariosDelBanco.add(usuario);

        //Obtener la cuenta del usuario
        Cuenta cuenta = usuario.cuenta();
        //Agregarla a la lista de cuentas del banco
        this.cuentasDelBanco.add(cuenta);
    }
    
}
