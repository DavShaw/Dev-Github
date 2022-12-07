#Hoy aprenderemos: Operadores relacionales

#Variables universales

null = ""
adorno = "========================================="

#Variables universales


print(null)
print(adorno)
print("¡Hola! Te damos la bienvenida")
print(adorno)
print(null)
print(null)
user_name = str(input("¿Cuál es tu nombre?: "))
user_name = user_name.upper()
print(null)
print(null)
print(adorno)
print("¡"+user_name+ ", Bienvenido al programa comparador!")
print(adorno)
print(null)
print(null)
print(adorno)
print("Introduce dos números a comparar")
print(adorno)
print(null)
print(null)
number1 = int(input("Primer número: "))
number2 = int(input("Segundo número: "))
print(null)
print(null)
print("Se están comparando los números", number1, "y", number2)
print(null)
print(null)

comparation1 = number1 != number2
comparation2 = number1 > number2
comparation3 = number1 >= number2


print(adorno)
if comparation1 == True:
    print("(!=)   ---> Es distinto")
else:
    print("(!=)   ---> No es distinto")
if comparation2 == True:
    print("(>)   ---> Es mayor")
else:
    print("(>)   ---> No es mayor")
if comparation3 == True:
    print("(>=)   ---> Es mayor o igual")
else:
    print("(>=)   ---> No es mayor o igual")
print(adorno)



