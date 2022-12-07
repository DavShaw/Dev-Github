#Hoy aprenderemos: Sentencias condicionales anidadas

#
adorno = str("=====================================")
null = str("")
#


print(adorno)
print("""¡Hola! Indicanos tu nombre, por favor""")
print(adorno)
print(null)
print(null)
user_name = str(input("¿Cómo te llamas?: "))
print(null)
print(null)
print(adorno)
print("Bienvenido al conversor, " + user_name)
print(null)
print("1) Convertir de texto a número")
print("2) Convertir de número a texto")
print(adorno)
print(null)
print(null)
user_decision = int(input("Elige una opción del menú: "))
print(null)


if user_decision == 1:
  
    print(adorno)
    print("\nConvirtiendo TEXTO a NÚMEROS\n")
    print(adorno)

    text_to_num = str(input("¿Qué deseas convertir a números?: "))
    text_to_num = text_to_num.lower()

    if text_to_num == "uno":
        print(null)
        print("======")
        print("Es 1")
        print("======")
    elif text_to_num == "dos":
        print(null)
        print("======")
        print("Es 2")
        print("======")
    elif text_to_num == "tres":
        print(null)
        print("======")
        print("Es 3")
        print("======")
    elif text_to_num == "cuatro":
        print(null)
        print("======")
        print("Es 4")
        print("======")
    elif text_to_num == "cinco":
        print(null)
        print("======")
        print("Es 5")
        print("======")
    elif text_to_num == "seis":
        print(null)
        print("======")
        print("Es 6")
        print("======")
    elif text_to_num == "siete":
        print(null)
        print("======")
        print("Es 7")
        print("======")
    elif text_to_num == "ocho":
        print(null)
        print("======")
        print("Es 8")
        print("======")
    elif text_to_num == "nueve":
        print(null)
        print("======")
        print("Es 9")
        print("======")
    elif text_to_num == "diez":
        print(null)
        print("======")
        print("Es 10")
        print("======")
    else:
        print("Has ingresado un carácter inválido o no registrado")


elif user_decision == 2:
    print(adorno)
    print("\nConvirtiendo NÚMEROS a TEXTO\n")
    print(adorno)

    num_to_text = int(input("¿Qué deseas convertir a texto?: "))
    num_to_text = num_to_text.lower()

    if num_to_text == int(1):
        print(null)
        print("======")
        print("Es uno")
        print("======")
    elif num_to_text == int(2):
        print(null)
        print("======")
        print("Es dos")
        print("======")
    elif num_to_text == int(3):
        print(null)
        print("======")
        print("Es tres")
        print("======")
    elif num_to_text == int(4):
        print(null)
        print("======")
        print("Es cuatro")
        print("======")
    elif num_to_text == int(5):
        print(null)
        print("======")
        print("Es cinco")
        print("======")
    elif num_to_text == int(6):
        print(null)
        print("======")
        print("Es seis")
        print("======")
    elif num_to_text == int(7):
        print(null)
        print("======")
        print("Es siete")
        print("======")
    elif num_to_text == int(8):
        print(null)
        print("======")
        print("Es ocho")
        print("======")
    elif num_to_text == int(9):
        print(null)
        print("======")
        print("Es nueve")
        print("======")
    elif num_to_text == int(10):
        print(null)
        print("======")
        print("Es diez")
        print("======")
    else: 
        print("Has ingresado un carácter inválido o no registrado")

else:
    print("Opción no disponible.")