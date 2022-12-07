#Hoy aprenderemos: A usar sentencias condicionales compuesta

#
adorno = str("================================================")
null = str(" ")
#

print(adorno)
print("¡Hola, te damos la bienvenida al menú de inicio!")
print(adorno)
print(null)
#Solicitud de nombre, procedemos a crear variable de input
user_name = str(input("Necesitamos tu nombre antes de iniciar: "))
user_pin = int(input("Necesitamos un pin de máximo 8 digitos: "))
user_cellphone_number = int(input("Necesitamos tu numero de contacto: "))
user_password_recovery = str(input("Color favorito: "))
user_confirmation = str(input("¿Todo está correcto? (SI o NO): ")) 
user_confirmation = user_confirmation.lower()
print(null)
print(null)

if user_pin <=99999999:
	pass
else:
	print("El pin no puede ser mayor a 8 digitos")
	print("Inicimos de nuevo")

#if user_confirmation == "SI" or user_confirmation == "Si" or user_confirmation == "si" or user_confirmation == "sI":
if user_confirmation == "si":
	pass
else:
	print("Nos indicas que has ingresado")
	print("datos incorrectos, vamos a")
	print("iniciar de nuevo")
	print(adorno)
	print(null)
	#Se cumplió el ELSE, asi que solicita todos los input nuevamente
	print(null)
	print("¡Hola, te damos la bienvenida al menú de inicio!")
	print(adorno)
	print(null)
	#Solicitud de nombre, procedemos a crear variable de input
	user_name = str(input("Necesitamos tu nombre antes de iniciar: "))
	user_pin = int(input("Necesitamos un pin de máximo 8 digitos: "))
	user_cellphone_number = int(input("Necesitamos tu numero de contacto: "))
	user_password_recovery = str(input("Color favorito: "))
	user_confirmation = str(input("¿Todo está correcto? (SI o NO): "))


print(adorno)
print("Bienvenido de nuevo, " + user_name + " tus datos son:")
print(adorno)
print(null)
print("Nombre: " + user_name)
print("Pin:", user_pin)
print("Numero telefonico: +57", user_cellphone_number)
print("Color favorito: " + user_password_recovery)
