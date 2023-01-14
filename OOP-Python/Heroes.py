class Heroes():

    def __init__(self):

        # Estado inicial de los objetos
        self.status_salud = 200
        self.status_altura = 5
        self.status_ancho = 3
        self.status_ataque = 5
        self.status_velocidad = 2.5
        self.status_hitbox = (self.status_altura*self.status_ancho)
        self.status_apariencia = "init_heroes_skin.png"

        # Comportamiento inicial de los objetos
        self.behavior_atacar = False
        self.behavior_caminar = False
        self.behavior_correr = False
        self.behavior_invisible = False
        self.behavior_inmortal = False
    
    # Métodos de los estados
    def method_status_salud(self,value):
        self.status_salud = value
    def method_status_altura(self,value):
        self.status_altura = value
    def method_status_ancho(self,value):
        self.status_ancho = value
    def method_status_ataque(self,value):
        self.status_ataque = value
    def method_status_velocidad(self,value):
        self.status_velocidad = value
    def method_status_apariencia(self,value):
        value = str(value)
        self.status_apariencia = value

    # Métodos de los comportamientos
    def method_behavior_atacar(self, mode=False):
        self.behavior_atacar = mode
        if mode:
            return f"Atacando: sí"
        else:
            return f"Atacando: no"

    def method_behavior_caminar(self, mode=False):
        self.behavior_caminar = mode
        if mode:
            return f"Caminando: sí"
        else:
            return f"Caminando: no"

    def method_behavior_correr(self, mode=False):
        self.behavior_correr = mode
        if mode:
            return f"Corriendo: sí"
        else:
            return f"Corriendo: no"

    def method_behavior_invisible(self, mode=False):
        self.behavior_invisible = mode
        if mode:
            return f"Invisible: sí"
        else:
            return f"Invisible: no"

    def method_behavior_inmortal(self, mode=False):
        self.behavior_inmortal = mode
        if mode:

            return f"Inmortal: sí"
        else:
            return f"Inmortal: no"
    




def InformacionObjeto(name,objectname):
    if (name == ""):
        name = f"Desconocido"
        print(f"\nNo se ha definido el nombre exacto del objeto. Acá dejaremos su ID\n\n({objectname})\n\n")
    print(f"""

    [Estados de {name}]

    - Salud: {objectname.status_salud}
    - Altura: {objectname.status_altura}
    - Ancho: {objectname.status_ancho}
    - Ataque: {objectname.status_ataque}
    - Velocidad: {objectname.status_velocidad}
    - Hitbox: {objectname.status_altura*objectname.status_ancho}
    - Apariencia: "{objectname.status_apariencia}"

    [Comportamiendo de {name}]

    - Atacando: {objectname.behavior_atacar}
    - Caminando: {objectname.behavior_caminar}
    - Corriendo: {objectname.behavior_correr}
    - Invisible: {objectname.behavior_invisible}
    - Inmortal: {objectname.behavior_inmortal}

    """)


Karina = Heroes()
Gusion = Heroes()
Angela = Heroes()


#Editando a Karina

# - Estado - #
Karina.method_status_salud(250)
Karina.method_status_altura(120)
Karina.method_status_ancho(54)
Karina.method_status_apariencia("default_karina.png")
Karina.method_status_velocidad(3.2)

# - Comportamiento - #
Karina.method_behavior_caminar(True)
Karina.method_behavior_atacar(False)
Karina.method_behavior_correr(True)
Karina.method_behavior_inmortal()
Karina.method_behavior_invisible(False)


# - Reporte del objeto - #
