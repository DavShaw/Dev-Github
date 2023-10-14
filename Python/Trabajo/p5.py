import math
# Definir diccionarios
posiciones = {
    1: "Delantero",
    2: "Centrocampista",
    3: "Defensor",
    4: "Portero"
    }

continentes = {
    1: "Europa",
    2: "America",
    3: "Otros" 
    }
# Definir mensaje


def borrar_consola():
    for i in range(500):
        print("")

def esta_en_intervalo(inicio, fin, valor):
    esta = (inicio <= valor <=fin)
    return esta

def pedir_edad_jugador():
    borrar_consola()
    while True:
        borrar_consola()
        edad = input("Ingresar edad del jugador: ")
        if (edad.isdigit()):
            edad_numero = int(edad)
            return edad_numero

def pedir_posicion_jugador():
    borrar_consola()
    
    menu = f"""
    1. {posiciones[1]}
    2. {posiciones[2]}
    3. {posiciones[3]}
    4. {posiciones[4]}
    """
    posicion = ""
    while True:
        borrar_consola()
        print(menu)
        posicion_str = input("Posicion del jugador: ")

        if posicion_str.isdigit():
            posicion = int(posicion_str)
            if esta_en_intervalo(1, 4, posicion):
                return posicion
            
def ha_representado_seleccion():
    borrar_consola()
    while True:
        borrar_consola()
        respuesta = input("¿Has representado a tu selección (S/N)?: ")
        respuesta = respuesta.lower()

        if (respuesta == "s"):
            return True
        if (respuesta == "n"):
            return False

def ha_jugado_exterior():
    menu = f"""
    1. {continentes[1]}
    2. {continentes[2]}
    3. {continentes[3]}
    """
    continente = ""
    while True:
        borrar_consola()
        print(menu)
        continente_str = input("¿En que continentes has jugado?: ")

        if continente_str.isdigit():
            continente = int(continente_str)
            if esta_en_intervalo(1, 3, continente):
                return continente
            
def pedir_goles():
    borrar_consola()
    while True:
        goles = input("¿Cuántos goles ha marcado?: ")
        if(goles.isdigit()):
            goles_numero = int(goles)
            return goles_numero

def calcular_puntos_edad(edad):
    puntos = 0

    # Obtener puntos para la edad

    # Menor (O IGUAL) de 20 años → 10 puntos
    # Entre 21 y 26 → 7 puntos
    # Entre 27 y 30 → 5 puntos 
    # Mayor a 30 → 3 puntos

    if(esta_en_intervalo(0,20,edad)):
        puntos += 10
    elif(esta_en_intervalo(21,26,edad)):
        puntos += 7
    elif(esta_en_intervalo(27,30,edad)):
        puntos += 5
    elif(esta_en_intervalo(30,9999999, edad)):
        puntos += 3
    return puntos

def calcular_puntos_posicion(posicion):
    puntos = 0
    
    # Obtener puntos para posicion

    # Delantero 10 puntos 
    # Centrocampista: 9 puntos
    # Defensor: 8 puntos
    # Portero: 7 puntos 

    if(posicion == 1):
        puntos += 10
    elif(posicion == 2):
        puntos += 9
    elif(posicion == 3):
        puntos += 8
    elif(posicion == 4):
        puntos += 7
    return puntos

def calcular_puntos_seleccion(seleccion):
    puntos = 0

    # Obtener puntos si jugo en la seleccion

    #Si Representa la selección del país 5 puntos adicionales

    if(seleccion == True):
        puntos += 5
    return puntos

def calcular_puntos_exterior(exterior):
    puntos = 0

    # Obtener puntos para el exterior

    # En Europa 8 puntos
    # En América 5 puntos
    # En otros continentes 3 puntos
    
    if(exterior == 1):
        puntos += 8
    elif(exterior == 2):
        puntos += 5
    elif(exterior == 3):
        puntos += 3
    return puntos

def calcular_puntos_goles(goles):
    puntos = 0

    # Obtener puntos para goles

    # Mas de 50 goles → 10 puntos
    # Entre 30 y 50 → 7 puntos
    # Entre 10 y 29 → 5 puntos

    if(esta_en_intervalo(10,29,goles)):
        puntos += 5
    elif(esta_en_intervalo(30,50,goles)):
        puntos += 7
    elif(esta_en_intervalo(51,9999999,goles)):
        puntos += 10
    return puntos

def calcular_puntos_totales(edad, posicion, seleccion, exterior, goles):
    puntos_totales = 0

    puntos_totales = puntos_totales +  calcular_puntos_edad(edad)
    puntos_totales = puntos_totales + calcular_puntos_posicion(posicion)
    puntos_totales = puntos_totales + calcular_puntos_seleccion(seleccion)
    puntos_totales = puntos_totales + calcular_puntos_exterior(exterior)
    puntos_totales = puntos_totales + calcular_puntos_goles(goles)

    return puntos_totales

def calcular_salario(puntos):
    base = 10000
    adicionales = (2000*puntos)
    return base + adicionales

def ejecutar_programa():
    print("---------------------------------------------------------")
    print("¡Hola! Bienvenido al sistema de calculos de salario para")
    print("jugadores de futbol.")
    print("")
    print("El programa funciona recogiendo las estadísticas del jugador")
    print("y mediante comparaciones se obtiene un monto, el cual será")
    print("el salario del jugador...")
    print()
    print("Gracias por usar nuestro programa.")
    print("---------------------------------------------------------")
    print("")
    print("")
    iniciar = input("PULSA CUALQUIER TECLA PARA CONTINUAR")

    jugador_edad = pedir_edad_jugador()
    jugador_posicion = pedir_posicion_jugador()
    jugador_seleccion = ha_representado_seleccion()
    jugador_exterior = ha_jugado_exterior()
    jugador_goles = pedir_goles()

    puntos_edad = calcular_puntos_edad(jugador_edad)
    puntos_posicion = calcular_puntos_posicion(jugador_posicion)
    puntos_seleccion = calcular_puntos_seleccion(jugador_seleccion)
    puntos_exterior = calcular_puntos_exterior(jugador_exterior)
    puntos_goles = calcular_puntos_goles(jugador_goles)

    puntos = puntos_edad + puntos_posicion + puntos_seleccion + puntos_exterior + puntos_goles
    
    salario = calcular_salario(puntos)

    mensaje = f"""
***********************************
* Procesando información obtenida *
***********************************


El resumen de datos se verá de la siguiente forma ->
Dato: respuesta (puntos)

Por ejemplo:

Edad: 95 (0)

*********************
* Mostrando resumen *
*********************

Edad del jugador: {jugador_edad} ({puntos_edad})
Posicion del jugador: {posiciones[jugador_posicion]} ({puntos_posicion})
Jugo en la selección: {jugador_seleccion} ({puntos_seleccion})
En que continente ha jugado: {continentes[jugador_exterior]} ({puntos_exterior})
Goles marcados: {jugador_goles} ({puntos_goles})

Esto nos da un total de: ${salario} (USD) 
"""
    borrar_consola()
    print(mensaje)

ejecutar_programa()