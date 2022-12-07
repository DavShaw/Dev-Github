#Hoy aprenderemos: Uso del break

admin_name = "martilloloco"

print("*****************************")
print("¡Hola! Te damos la bienvenida")
print("*****************************")
print("")
print("")
user_name = str(input("Necesitamos tu nombre antes de iniciar: "))
print("")
print("")
print("***********************************")
print(user_name+", Adivina el nombre del administrador")
print("***********************************")
print("")
print("")
admin_name_user_guessing = str(input("Adivina el nombre del admin: "))
admin_name_user_guessing = admin_name_user_guessing.lower()

if admin_name == admin_name_user_guessing:
    admin_name_user_guessing = admin_name_user_guessing.lower()
    print("")
    print("")
    print("Eres un crack adivinando")
    print("")
    print("")
else:
    while admin_name_user_guessing != admin_name:
        admin_name_user_guessing = admin_name_user_guessing.lower()
        print("Nombre incorrecto, intenta nuevamente")
        print("")
        admin_name_user_guessing = str(input("Adivina el nombre del admin: "))
        
        if admin_name_user_guessing == admin_name:
            admin_name_user_guessing = admin_name_user_guessing.lower()
            print("")
            print("Eres un crack adivinando (Luego de muchos intentos xd)")
            break