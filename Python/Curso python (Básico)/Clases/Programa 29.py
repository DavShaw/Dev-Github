#Hoy aprenderemos: Uso del rstrip() - lstrip()

# rstrip() - Elimina carácteres espeficicados en final de un str (Sino se es especifico en qué eliminar, eliminará los espacios)

user_input1 = input("Escribe: Hola, bebe: ")
user_input1 = user_input1.lower()
user_input1 = user_input1.rstrip(" eb ")

#Debe imprimir: Hola, 

print(user_input1)

# lstrip() - Elimina carácteres espeficicados en inicio de un str (Sino se es especifico en qué eliminar, eliminará los espacios)


user_input2 = input("Escribe: Hola, bebe: ")
user_input2 = user_input2.lower()
user_input2 = user_input2.lstrip(" ho ")

#Debe imprimir: la, bebe

print(user_input2)