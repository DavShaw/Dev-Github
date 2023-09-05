# Usando la clase pila, solicitar al usuario un mensaje e invertir la mitad del mensaje.
# Ejemplo:
# Mensaje original: "Hola, soy david"
# Mensaje editado: "Hola, sodivad y"

from Stack import Stack

message = input("Enter a message: ")

stack = Stack(len(message))

mid = len(message) // 2
leftLength = stack.getLenth() - mid

stackMid = Stack(stack.getLenth() - mid)

# Añadir todos los elementos, menos los que se invierten
for i in range(mid):
    stack.push(message[i])

# Añadir todos los elementos que faltan (Los de la mitad en adelante)
for i in range(leftLength):
    stackMid.push(stack.pop())

# Crear el mensaje editado combinando las dos partes
edited_message = ""
for i in range(len(message)):
    if i < mid:
        edited_message += stack.pop()
    else:
        edited_message += stackMid.pop()

print("Mensaje original:", message)
print("Mensaje editado:", edited_message)