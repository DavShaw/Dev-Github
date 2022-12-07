#Hoy aprenderemos: Uso del strip()

# Strip() - Elimina carácteres espeficicados en inicio y final de un str (Sino se es especifico en qué eliminar, eliminará los espacios)
print("=========================")
print("Borrador de letras (Re troll)")
print("=========================\n\n")
borrador = input("Escribe algo: ")
borrador = borrador.lower()
borrador = borrador.strip("abcdefghijklmnñopqrstuvwxyz ")

print(borrador)
