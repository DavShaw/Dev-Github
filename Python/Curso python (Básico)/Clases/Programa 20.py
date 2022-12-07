
print("\n*********************************")
print("*Bienvenido a la calculadora DTC*")
print("*********************************\n\n\n")

print("Menú de opción a elegir")

print("""

1) Suma (+)
2) Resta (-)
3) Multiplicación (*)
4) División (/)
5) División entera (//)
6) Exponente (**)
7) Módulo o resto (%)

""")

numero = int(input("¿Qué operación deseas realizar?: "))

if numero == 1:


    print("\n\n=================")
    print("Has elegido suma")
    print("=================\n")
    numero = int(input("Indica la primera cifra: "))
    numero += int(input("Indica la segunda cifra: "))
    
    print("\nEl resultado es:",numero)

elif numero == 2:

    print("\n\n=================")
    print("Has elegido resta")
    print("=================\n")
    numero = int(input("Indica la primera cifra: "))
    numero -= int(input("Indica la segunda cifra: "))
    
    print("\nEl resultado es:",numero)

elif numero == 3:

    print("\n\n=================")
    print("Has elegido multi")
    print("=================\n")
    numero = int(input("Indica la primera cifra: "))
    numero *= int(input("Indica la segunda cifra: "))
    
    print("\nEl resultado es:",numero)

elif numero == 4:

    print("\n\n=================")
    print("Has elegido divi")
    print("=================\n")
    numero = int(input("Indica la primera cifra: "))
    numero /= int(input("Indica la segunda cifra: "))
    
    print("\nEl resultado es:",numero)

elif numero == 5:

    print("\n\n=================")
    print("Has elegido divi entera")
    print("=================\n")
    numero = int(input("Indica la primera cifra: "))
    numero //= int(input("Indica la segunda cifra: "))
    
    print("\nEl resultado es:",numero)

elif numero == 6:

    print("\n\n=================")
    print("Has elegido exponente")
    print("=================\n")
    numero = int(input("Indica la primera cifra: "))
    numero **= int(input("Indica la segunda cifra: "))
    
    print("\nEl resultado es:",numero)

elif numero == 7:

    print("\n\n=================")
    print("Has elegido módulo")
    print("=================\n")
    numero = int(input("Indica la primera cifra: "))
    numero %= int(input("Indica la segunda cifra: "))
    
    print("\nEl resultado es:",numero)

else:
    print("Opción no válida")
   