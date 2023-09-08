package org.davshaw.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.davshaw.external.DataBase;

public class TestData
{
    private List<String> names = new ArrayList<String>(
    Arrays.asList(
        "Juan", "María", "Carlos", "Ana", "José", "Laura", "Luis", "Carmen",
        "Antonio", "Isabel", "Francisco", "Elena", "Manuel", "Patricia", "David",
        "Rosa", "Javier", "Marta", "Daniel", "Sofia", "Miguel", "Alicia", "Alejandro",
        "Paula", "Raúl", "Beatriz", "Pedro", "Julia", "Sergio", "Adriana",
        "Gonzalo", "Valentina", "Fernando", "Camila", "Andrés", "Valeria", "Héctor", "Marina",
        "Roberto", "Lucía", "Guillermo", "Natalia", "Diego", "Carolina", "Ricardo", "Verónica",
        "Simón", "Florencia", "Eduardo", "Cecilia", "Lorenzo", "Daniela",
        "Víctor", "Mónica", "Pablo", "Lucas", "Manuela", "Tomás", "Renata",
        "Gabriel", "Valeria", "Eduardo", "Catalina", "Joaquín", "Luna", "Federico", "Clara",
        "Rafael", "Mariana", "Alejo", "Julieta", "Matías", "Sol", "Bruno", "Antonia",
        "Leonardo", "Aurora", "Nicolás", "Diana", "Esteban", "Olivia", "Sebastián", "Elena",
        "Ignacio", "Bianca", "Eugenio", "Amelia", "Lautaro", "Sara", "Emilio", "Carla"
    ));

    private List<String> descriptions = new ArrayList<String>(
    Arrays.asList(
        "Pérdida de conexión a Internet",
        "Velocidad de Internet lenta",
        "Error de DNS: no se puede resolver el nombre de dominio",
        "Fallo en el enrutador: no se puede acceder a la configuración",
        "Pérdida de energía: equipo apagado inesperadamente",
        "Pantalla azul de la muerte (BSOD) en Windows",
        "Sobrecalentamiento de la CPU",
        "Error de lectura de disco duro",
        "Fallo en la tarjeta gráfica: pantalla en blanco o distorsionada",
        "Problema de impresora: atascada o sin tinta",
        "Dispositivo USB no reconocido",
        "Problema de sonido: sin audio o ruido estático",
        "Problema de batería: no carga o descarga rápidamente",
        "Error de actualización del sistema operativo",
        "Aplicación que se bloquea o no responde",
        "Problema con el correo electrónico: no se pueden enviar o recibir correos",
        "Fallo de seguridad: virus o malware detectado",
        "Problema de almacenamiento: espacio insuficiente en disco",
        "Error de impresión: página en blanco o distorsionada",
        "Problema de red: no se puede conectar a una red Wi-Fi",
        "Problema de videoconferencia: mala calidad de video o audio",
        "Error de software: aplicación se cierra inesperadamente",
        "Problema de teclado: teclas no funcionan correctamente",
        "Problema de ratón: puntero errático o no responde",
        "Problema de pantalla: píxeles muertos o pantalla parpadeante",
        "Problema de copia de seguridad: no se pueden restaurar los archivos",
        "Error de hardware: componentes dañados o defectuosos",
        "Problema de correo electrónico: correos desaparecidos",
        "Fallo de seguridad: intento de acceso no autorizado",
        "Problema de almacenamiento: archivos perdidos o eliminados",
        "Error de impresión: impresora no responde",
        "Problema de red: conexión intermitente a Internet",
        "Problema de software: no se puede instalar una aplicación",
        "Problema de sonido: micrófono no funciona",
        "Problema de pantalla: parpadeo o pantalla negra",
        "Problema de teclado: tecla atascada",
        "Fallo de hardware: disco duro dañado",
        "Problema de seguridad: contraseña olvidada",
        "Problema de software: programa se bloquea al abrirlo",
        "Problema de batería: duración corta",
        "Problema de red: no se puede acceder a sitios web",
        "Error de hardware: dispositivo USB no reconocido",
        "Problema de impresora: impresión lenta",
        "Problema de copia de seguridad: restauración fallida",
        "Problema de sonido: ruido de fondo molesto",
        "Problema de videoconferencia: no se pueden unir a reunión",
        "Problema de pantalla: parpadeo al ver videos",
        "Problema de software: programa se congela",
        "Problema de red: IP no válida",
        "Error de hardware: ventilador de la CPU ruidoso",
        "Problema de teclado: teclas pegajosas",
        "Fallo de seguridad: cuenta comprometida",
        "Problema de software: no se puede abrir un archivo",
        "Problema de impresora: atascada en papel"
    ));

    private List<Integer> ages = new ArrayList<Integer>(
        Arrays.asList(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
            51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
            61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
            71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
            81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
            91, 92, 93, 94, 95, 96, 97, 98, 99, 100,
            101, 102, 103, 104, 105, 106, 107, 108, 109, 110,
            111, 112, 113, 114, 115, 116, 117, 118, 119, 120
        ));

    private String host = "containers-us-west-31.railway.app";
    private int port = 6986;
    private String database = "railway";
    private String username = "root";
    private String password = "IIBDbFM36RhcoMDL5WyQ"; 
    private DataBase db;
    private Random random = new Random();
    private String nameToInto;
    private String descriptionToInto;
    private int ageToInto;

    /*
            int randomName = random.nextInt(maxNames);
            int randomDescription = random.nextInt(maxDescription);
            int randomAge = random.nextInt(maxAges);
            String nameToInto = this.names.get(randomName);
            String descriptionToInto = this.descriptions.get(randomDescription);
            int ageToInto = this.ages.get(randomAge);
     */

    private void updateData()
    {
        int randomName = random.nextInt(names.size());
        int randomDescription = random.nextInt(descriptions.size());
        int randomAge = random.nextInt(ages.size());

        this.nameToInto = this.names.get(randomName);
        this.descriptionToInto = this.descriptions.get(randomDescription);
        this.ageToInto = this.ages.get(randomAge);
    }

    public String getNameToInsert()
    {
        this.updateData();
        return this.nameToInto;
    }

    public String getDescriptionToInsert()
    {
        this.updateData();
        return this.descriptionToInto;
    }

    public int getAgeToInsert()
    {
        this.updateData();
        return this.ageToInto;
    }

    public DataBase getDatabase()
    {
        return this.db;
    }

    public TestData()
    {
        this.db = new DataBase(host,port,database,username,password);
    }


}
