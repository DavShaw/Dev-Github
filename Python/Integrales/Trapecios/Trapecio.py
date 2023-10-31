import math

# Lo mas dificil de esto será no tirar código en inglés

# Integrales por métodos numéricos (Método de los trapecios)

# Fuente de información: https://www.youtube.com/watch?v=rREhW5wjkUI

# La integral entre [a,b] usando la regla del trapecio está dada por la fórmula: (deltax/n)/2 * [f(x0) + 2f(x1) + 2f(x2) + . . . . . . 2f(xn-1) + f(xn)]

# dónde n es el número de trapecios que usaremos, y siempre la cantidad de intervalos será igual a n + 1

# NOTA: Como mediante inputs no somos capaces de introducir en una variable la función a integrar, esa función y los demás parámetros se ingresarán modificando el código


# f = función
# n = número de trapecios
# deltax = diferencial x
# x = variable


# deltax = (b-a) / n
# xi = a + (i*deltax)
# NOTA: i es igual a la iteración de n en la que estamos, por ejemplo, f(x0) es f(xi) donde i = 0

# FÓRMULA: (deltax/n)/2 * [f(x0) + 2f(x1) + 2f(x2) + . . . . . . 2f(xn-1) + f(xn)]



# Se declara n
n = 5

# Se define la función
def f (x, como_string = False):
    if (como_string):
        return "(math.e) ** (x**2)"
    return (math.e) ** (x**2)

# Se define el intervalo 
a = 0
b = 1

# Se define deltax
deltax = (b-a)/n

# Obtener lista de funciones evaluadas en xi
lista_funciones = []

# Obtener lista de xi
lista_xi = []

# Iniciamos iteración desde 0 (inicio) hasta n + 1 (final)
for i in range(n+1):

    # xi = a + (i*deltax)

    # Si i = 0, entonces solo se añade la función evaluada, sin multiplicar

    if (i == 0 or i == n):
        xi = a + (i * deltax)
        lista_xi.append(xi)
        fxi = f(xi)
        lista_funciones.append(fxi)
    else:
        xi = a + (i * deltax)
        lista_xi.append(xi)
        fxi = f(xi) * 2
        lista_funciones.append(fxi)

# Usaremos la función "sum" de python, la cual suma funciones uwu
# Reinventaré la fórmula xd -> (deltax/2) * (sum(lista_funciones))

resultado = (deltax/2) * (sum(lista_funciones))

# Código puro y documentado


