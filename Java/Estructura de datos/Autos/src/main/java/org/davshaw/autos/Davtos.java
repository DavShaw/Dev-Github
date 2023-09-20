package org.davshaw.autos;

import org.davshaw.resources.CarLinkedList.CarLinkedList;
import org.davshaw.resources.CarLinkedList.CarNode;
import org.davshaw.resources.RegisterLinkedList.RegisterLinkedList;
import org.davshaw.resources.userLinkedList.UserLinkedList;
import org.davshaw.resources.userLinkedList.UserNode;


public class Davtos
{
    CarLinkedList carrosRegistrados = new CarLinkedList();
    CarLinkedList carrosDisponibles = new CarLinkedList();
    UserLinkedList usuariosRegistrados = new UserLinkedList();
    RegisterLinkedList registroAlquiler = new RegisterLinkedList();

    public void registrarCarro(String marca, String modelo, int anioFabricacion, double costoAlquiler)
    {
        Car carro = new Car(marca, modelo, anioFabricacion, costoAlquiler);
        this.carrosRegistrados.addNodeAtTail(carro);
        this.carrosDisponibles.addNodeAtTail(carro);
    }

    public boolean usuarioRegistrado(int dni)
    {
        for (int i = 0; i < this.usuariosRegistrados.size(); i++)
        {
            UserNode nodoUsuario = this.usuariosRegistrados.getNodeAt(i);
            User usuario = nodoUsuario.Value();
            if(usuario.getDni() == dni)
            {
                return true;
            }
        }
        return false;
    }

    public boolean carroRegistrado(int id)
    {
        for (int i = 0; i < this.carrosRegistrados.size(); i++)
        {
            CarNode nodoCarro = this.carrosRegistrados.getNodeAt(i);
            Car Carro = nodoCarro.Value();
            if(Carro.getId() == id)
            {
                return true;
            }
        }
        return false;
    }

    public void registrarUsuario(String nombre, String correo, int numero, int dni)
    {
        try
        {
            //Verificar que no exista un usuario con este DNI
            if (this.usuarioRegistrado(dni))
            {
                throw new Exception("Ya existe un usuario registrado con este DNI");
            }
            User usuario = new User(nombre, correo, numero, dni);
            this.usuariosRegistrados.addNodeAtTail(usuario);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void alquilarCarro(int usuarioDNI, int carroID)
    {
        try
        {
            //Verificar que exista el usuario
            if(!(this.usuarioRegistrado(usuarioDNI)))
            {
                throw new Exception("No existe el usuario registrado con este DNI");
            }

            //Verificar que exista el carro
            if(!(this.carroRegistrado(carroID)))
            {
                throw new Exception("No existe el carro registrado con este ID");
            }

            //Verificar que el carro este disponible
            //! CREAR METODO PARA VER SI UN CARRO ESTA DISPONIBLE

            //Sino, podemos alquilar el carro

        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String carrosDisponibles()
    {
        String StringcarrosDisponibles = "";
        for (int i = 0; i < this.carrosDisponibles.size(); i++)
        {
            CarNode nodoCarro = this.carrosDisponibles.getNodeAt(i);
            Car carro = nodoCarro.Value();
            StringcarrosDisponibles += carro.getView();
            StringcarrosDisponibles += "\n";
            StringcarrosDisponibles += "\n";
        }
        return StringcarrosDisponibles;
    }

    public void verCarrosDisponibles()
    {
        System.out.println(this.carrosDisponibles());
    }

    public String usuariosRegistrados()
    {
        String StringUsuariosRegistrados = "";
        for (int i = 0; i < this.usuariosRegistrados.size(); i++)
        {
            UserNode nodoUsuario = this.usuariosRegistrados.getNodeAt(i);
            User usuario = nodoUsuario.Value();
            StringUsuariosRegistrados += usuario.getView();
            StringUsuariosRegistrados += "\n";
            StringUsuariosRegistrados += "\n";
        }
        return StringUsuariosRegistrados;
    }

    public void verUsuariosRegistrados()
    {
        System.out.println(this.usuariosRegistrados());
    }

    public RegisterLinkedList asd()
    {
        return this.registroAlquiler;
    }


    /*
    * To do:
    ? - Método para saber si un usuario está registrado (Ver si existe el usuario)  //!DONE
    ? - Método para	saber si un auto está registrado (Ver si existe el carro) //!DONE
    ? - Método para registrar un usuario (null) //!DONE
    ? - Método para agregar nuevos vehículos a la lista (Ha sido comprado por la empresa) //!DONE
    ? - Método para remover un vehículo de la lista (Ha sido alquilado) 
    ? - Método para re-ingresar un vehículo que ha sido regresado (Ya se acabó su tiempo de alquiler)

    ! - Método para obtener un carro por su ID
    ! - Método para obtener un usuario por su DNI
    */


    public static void main(String[] args) {
        Davtos empresa = new Davtos();
        empresa.registrarCarro("Honda", "Civic", 2019, 55.0);
        empresa.registrarCarro("Toyota", "Corolla", 2020, 50.0);

        empresa.registrarUsuario("Bob Johnson", "bob.johnson@example.com", 456789, 987654);
        empresa.registrarUsuario("David Wang", "david.wang@example.com", 567890, 765432);

        empresa.alquilarCarro(987654, 1);
        empresa.alquilarCarro(765432, 2);

        System.out.println(empresa.asd());

    }
}
