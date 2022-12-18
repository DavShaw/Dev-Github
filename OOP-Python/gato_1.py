class Gatos():


    def __init__(self):
        #Identidad
        self.identidad_apariencia = "Liso (Inicial)"
        self.identidad_pelaje = "Blanco (Inicial)"
        self.identidad_ojos = "Negros (Inicial)"
        #Comportamiento
        self.comportamiento_maullando = False
        self.comportamiento_durmiendo = False
        self.comportamiento_saltando = False

    #Métodos
    def m_Maullando(self,yorn):
        self.comportamiento_maullando = yorn
    def m_Durmiendo(self,yorn):
        self.comportamiento_durmiendo = yorn
    def m_Saltando(self,yorn):
        self.comportamiento_saltando = yorn

    #Estados
    def f_Estados(self):
        to_return = ""
        if (self.comportamiento_maullando):
            to_return += "\n"
            to_return += "Maullando: SÍ"
        else:
            to_return += "\n"
            to_return += "Maullando: NO"

        if (self.comportamiento_durmiendo):
            to_return += "\n"
            to_return += "Durmiendo: SÍ"
        else:
            to_return += "\n"
            to_return += "Durmiendo: NO"
    
        if (self.comportamiento_saltando):
            to_return += "\n"
            to_return += "Saltando: SÍ"
        else:
            to_return += "\n"
            to_return += "Saltando: NO"
        return to_return
    
    #enseñar identidades (Funcion)
    def f_identidades(self):
        nl = "\n"
        show_iden = f"{nl}Apariencia: {self.identidad_apariencia}{nl}Ojos: {self.identidad_ojos}{nl}Pelaje: {self.identidad_pelaje}{nl}"
        return show_iden






#Objetos
Zoro = Gatos()
PolloDavid = Gatos()
Chandita = Gatos()
#Objetos


#====[Modificando el objeto Zoro (Asintota inicial) ]====#

#Identidades del objeto#
Zoro.identidad_apariencia = "Manchas amarillas"
Zoro.identidad_ojos = "Amarillos"
Zoro.identidad_pelaje = "Blanco"

#Comportamientos del objeto
Zoro.m_Durmiendo(False)
Zoro.m_Maullando(True)
Zoro.m_Saltando(False)

#====[Modificando el objeto Zoro (Asintota final) ]====#




#====[Modificando el objeto PolloDavid (Asintota inicial) ]====#

#Identidades del objeto#
PolloDavid.identidad_apariencia = "Manchas negras"
PolloDavid.identidad_ojos = "Negros"
PolloDavid.identidad_pelaje = "Blanco"

#Comportamientos del objeto
PolloDavid.m_Durmiendo(True)
PolloDavid.m_Maullando(False)
PolloDavid.m_Saltando(False)

#====[Modificando el objeto PolloDavid (Asintota final) ]====#




#====[Modificando el objeto Chandita (Asintota inicial) ]====#

#Identidades del objeto#
#Comportamientos del objeto

#====[Modificando el objeto Chandita (Asintota final) ]====#

def ReporteObjeto(nombre,objeto):
    print(f"==========[{nombre}]==========")
    print(f"\n(Estados) \n{objeto.f_Estados()}\n")
    print(f"\n(Identidades) \n{objeto.f_identidades()}\n")
    print(f"==========[{nombre}]==========")



ReporteObjeto("Zoro",Zoro)