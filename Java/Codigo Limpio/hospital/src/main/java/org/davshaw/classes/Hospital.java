package org.davshaw.classes;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.davshaw.external.ToSerializer;

public class Hospital implements Serializable
{
    private RequestQueue Solicitudes;

    public Hospital(int maximoSolicitudes)
    {
        this.Solicitudes = new RequestQueue(maximoSolicitudes);
    }

    public void agregarSolicitudes(String nombrePaciente, String descripcionSolicitud, int edadPaciente)
    {
        //instanciar objeto de Request
        Request solicitud = new Request(nombrePaciente, descripcionSolicitud, edadPaciente);
        //Añadir a la lista de solicitudes
        this.Solicitudes.enqueue(solicitud);
    }

    public RequestQueue obtenerSolicitudes()
    {
        return this.Solicitudes;
    }

    
    public void atenderSolicitud()
    {
        //Obtener la siguiente solicitud en la cola
        Request solicitud = this.Solicitudes.first();
        //Obtener los detalles de esa solicitud
        String detallesSolicitud = this.obtenerDetallesSolicictud(solicitud.getID());
        //Elimnarla
        this.Solicitudes.dequeue();
        System.out.println(detallesSolicitud);
    }
    
    public void imprimirVisualizadorSolicitudes()
    {
        System.out.println(this.visualizarSolicitudes());
    }

    public String visualizarSolicitudes()
    {
        //Lógica: iterar sobre cada Request en la lista de solicitudes, obtener su ID, con su id obtener detales
        //de la solicitud y concatenar a la variable (totalSolicitudes)
        String totalSolicitudes = "";
        //Debo iterar sobre la lista de solicitudes
        for (Request solicitud: this.Solicitudes)
        {
            if (solicitud != null)
            {
                int id = solicitud.getID();
                String informacionDetallada = this.obtenerDetallesSolicictud(id);
                totalSolicitudes += informacionDetallada;
            }
        }
        return totalSolicitudes;
    }

    public void cambiarPrioridad(int id, int nuevaPrioridad)
    {
        //Obtener objeto Request
        Request solicitud = this.Solicitudes.getRequestByID(id);
        //Actualizar prioridad
        solicitud.setPriority(nuevaPrioridad);
        this.Solicitudes.sort();
    }

    public void actualizarCola(RequestQueue nuevaCola)
    {
        this.Solicitudes.resetIDCounter();
        this.Solicitudes = nuevaCola;
    }


    public String obtenerDetallesSolicictud(int ID)
    {
        //Obtener la solicictud con ese ID
        Request solicictud = this.Solicitudes.getRequestByID(ID);
        //Hacer esquema del mensaje

        String detalle = "";

        detalle += "\n";
        detalle += "-=-=-=-=-=-=-=-=-=-=-=-=-\n";
        detalle += "Nombre: " + solicictud.getName() + "\n";
        detalle += "Descripción: " + solicictud.getRequestDescription() + "\n";
        detalle += "Edad: " + solicictud.getAge() + "\n";
        detalle += "ID: " + solicictud.getID() + "\n";
        detalle += "Prioridad: " + solicictud.getPriority() + "\n";
        detalle += "-=-=-=-=-=-=-=-=-=-=-=-=-\n";
        detalle += "\n";
        
        return detalle;
    }

    public void generateSerialized(String filepath) throws IOException
    {
        ToSerializer objectSerializer = new ToSerializer(filepath, this);
    }




}
