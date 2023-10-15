import random
import math
opciones = {
    1: "y es divisor de x",
    2: "x es primo",
    3: "los n divisores (primos) de x",
    4: "obtener los primeros n numeros primos",
    5: "generar un numero x y validar si es primo",
    6: "generar 10 numeros primos y/o capicuas"
}

def borrar_mensajes():
    for i in range(500):
        print("")

def invertir_mensaje(mensaje):
    mensaje = str(mensaje)
    mensaje_invertido = ""
    for i in range(-1, -len(mensaje) - 1, -1):
        mensaje_invertido += mensaje[i]
    return mensaje_invertido

def esta_en_intervalo(inicio, fin, valor):
    esta = (inicio <= valor <=fin)
    return esta

def elegir_opcion():
    while True:
        borrar_mensajes()
        print("------------------------")
        print(f"1. {opciones[1]}")
        print(f"2. {opciones[2]}")
        print(f"3. {opciones[3]}")
        print(f"4. {opciones[4]}")
        print(f"5. {opciones[5]}")
        print(f"6. {opciones[6]}")
        print("------------------------")
        respuesta = input("Elige una opción: ")
        if(respuesta.isdigit()):
            respuesta = int(respuesta)
            if(esta_en_intervalo(1,6,respuesta)):
                return respuesta

def y_es_divisor_de_x(x,y):
    if (y != 0):
        return x%y == 0
    else:
        return False

def x_es_primo(x):
    divisores = 0
    for i in range(1, x+1):
        if (x % i == 0):
            divisores += 1
    return divisores == 2

def x_es_capicua(x):
    x = str(x)
    if (x == invertir_mensaje(x)):
        return True

def n_divisores_primos_de_x(x, n):
    divisores = []
    for i in range(1, n + 1):
        if (x % i) == 0:
            if x_es_primo(i):
                divisores.append(i)
    return divisores

def n_primos(n):
    primos = []
    numero = 1
    while True:
        if x_es_primo(numero):
            primos.append(numero)
        numero += 1
        if len(primos) >= n:
            return primos

def x_generado_es_primo():
    x = random.randint(0, 999999)
    if x_es_primo(x):
        return (x,True)
    return (x,False)

def generar_10_primos_o_capicuas():
    primos_o_capicuas = []

    while True:
        x = random.randint(100, 999)
        if(x_es_primo(x)) or (x_es_capicua(x)):
            primos_o_capicuas.append(x)
        if (len(primos_o_capicuas)) >= 10:
            return primos_o_capicuas

def ejecutar_programa():
    print("---------------------------------------------------------")
    print("¡Hola! Bienvenido al sistema de operaciones matemáticas")
    print("")
    print("Te daremos un menú de opciones, elige la que mas te guste.")
    print("Esperamos puedas disfrutas nuestro programa.")
    print("")
    print("Gracias por preferirnos :)")
    print("---------------------------------------------------------")
    print("")
    print("")
    iniciar = input("PULSA CUALQUIER TECLA PARA CONTINUAR")

    opcion = elegir_opcion()

    if(opcion == 1):
        while True:
            x = input("Numero X: ")
            y = input("Numero Y: ")
            if (x.isdigit() and y.isdigit()):
                x = int(x)
                y = int(y)
                if (y_es_divisor_de_x(x,y)):
                    print(f"El numero {y} es divisor exacto de {x}.")
                    break
                print(f"El numero {y} no es divisor exacto de {x}.")

    elif(opcion == 2):
        while True:
            x = input("Numero X: ")
            if (x.isdigit()):
                x = int(x)
                if (x_es_primo(x)):
                    print(f"El numero {x} es primo.")
                    break
                print(f"El numero {x} no es primo.")

    elif(opcion == 3):
        while True:
            n = input("Numero N: ")
            x = input("Numero X: ")
            if (n.isdigit() and x.isdigit()):
                n = int(n)
                x = int(x)
                resultado = n_divisores_primos_de_x(x,n)
                print(f"Lo primeros {n} numeros primos divisores exactos de {x} son:")
                print(resultado)
                break

    elif(opcion == 4):
        while True:
            n = input("Numero N: ")
            if (n.isdigit()):
                n = int(n)
                resultado = n_primos(n)
                print(f"Los primeros {n} numeros primos son:")
                print(resultado)

    elif(opcion == 5):
        tupla = x_generado_es_primo()
        if(tupla[1]):
            print(f"Generamos el numero {tupla[0]} y si es primo :)")
        else:
            print(f"Generamos el numero {tupla[0]} y no es primo :(")

    elif(opcion == 6):
        resultado = generar_10_primos_o_capicuas()
        print(f"Generamos muchos numeros hasta el cansancio, pero solo estos 10 han sido primos o capicuas ;)")
        print(resultado)

    else:
        print("Opción inválida :(")

ejecutar_programa()









