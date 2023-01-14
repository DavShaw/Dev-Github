class Animales():

    def __init__(self,tipo,nombre,extremidades,alimentacion):
        tipo = str(tipo)
        nombre = str(nombre)
        extremidades = str(extremidades)
        alimentacion = str(alimentacion)
        self.tipo = tipo
        self.nombre = nombre
        self.extremidades = extremidades
        self.alimentacion = alimentacion


    def method_tipo(self,tipo):
        if tipo == ("mamifero", "ave", "reptil", "pez", "planta", "desconocido"):
            self.tipo = tipo
        else:
            print("""
            ¡Hey!, has ingresado un tipo de animal inválido (mamifero, ave, reptil, pez)
            Estableceremos el tipo a 'desconocido'
            """)
            self.tipo = "desconocido"
    

    def method_nombre(self,nombre):
        self.nombre = nombre


    def method_extremidades(self,extremidades):
        self.extremidades = extremidades


    def method_alimentacion(self,alimentacion):
        if self.tipo != "planta":
            if alimentacion == ("herbivoro", "carnivoro", "insectivoro", "omnivoro", "desconocido"):
                self.alimentacion = alimentacion
            else:
                print("""
                ¡Hey!, has ingresado un tipo de alimentación inválida (herbivoro, carnivoro, insectivoro, omnivoro)
                Estableceremos el tipo a 'desconocido'
                """)
        else:
            self.alimentacion = "fotosintesis"



    def InformacionObjeto(name,objectname):
        if (name == ""):
            name = "Desconocido"
            print(f"\nNo se ha definido el nombre exacto del objeto. Acá dejaremos su ID\n\n({objectname})\n\n")
        print(f"""

        [Estados de {name}]

        - Tipo: {objectname.tipo}
        - Nombre: {name}
        - Extremidades: {objectname.extremidades}
        - Alimentación: {objectname.alimentacion}
    
        """)





class Perros(Animales):
    pass

Pitbull = Perros("mamifero","Nicolas","4","carnivoro")

Pitbull.InformacionObjeto("Pitbull")
