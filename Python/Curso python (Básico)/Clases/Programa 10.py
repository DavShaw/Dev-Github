#Hoy aprenderemos: A usar sentencias condicionales simple

# user info below
# user_nickname_plus_password = David Torres+king0246

#
adorno = "========================================"
#

print(adorno)
print ("¡Bienvenido a la base de datos de DTP!")
print (adorno)
user_saved_files = "Melissa+2525M"
user_nickname_plus_password = str(input("""Requerimos validar tu información

Ej: VaneZZa+1234
Nombre + contraseña: """))

if user_nickname_plus_password == user_saved_files:
	print("Datos válidos. Accediendo a la base de datos")
print(". . .")