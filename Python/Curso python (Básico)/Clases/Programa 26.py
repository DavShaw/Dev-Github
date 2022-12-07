#Hoy aprenderemos: Uso del format()

print("\n=================================")
print("Bienvenido al sistema de registro")
print("=================================\n\n")

user_name = str(input("Indicanos tu nombre: "))
user_age = str(input("Indicanos tu edad: "))
user_mommy_name = str(input("Indicanos el nombre de tu madre: "))
user_daddy_name = str(input("Indicanos el nombre de tu padre: "))
user_favorite_color = str(input("Indicanos tu color favorito: "))
user_daddy_name = user_daddy_name.upper()
user_favorite_color = user_favorite_color.upper()
user_mommy_name = user_mommy_name.upper()
user_name = user_name.upper()

print("\n\n===============[Datos recolectados]===============")
print("Nombre: {}".format(user_name))
print("Edad: {}".format(user_age))
print("Nombre de la madre: {}".format(user_mommy_name))
print("Nombre del padre: {}".format(user_daddy_name))
print("Color favorito: {}".format(user_favorite_color))
print("==================================================\n\n")

#Forma uno de usar format() al concatenar

nombre_mio = "David"
edad_mia = 20
print("format() '#1'")
print("{} tienes {} años de edad.".format(nombre_mio, edad_mia))

#Forma dos de usar format() al concatenar

print("format() '#2'")
print("{yo} tienes {edad} años de edad.".format(yo="David", edad=20))

#Forma tres de usar format() al concatenar

nombre999 = "David"
edad999 = 20

print("format() '#3'")
print("{1} tienes {0} años de edad.".format(edad999, nombre999))