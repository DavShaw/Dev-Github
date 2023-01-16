import os
import sys
from login_admin import Encrypter

def TakeFiles(file = "nothing"):
    file = str(file)
    if (file != "nothing"):
        give = os.path.join(sys.path[0], f"{file}")
        return give
    else:
        return "> You must enter a path to find the file! - Debes especificar una ruta de archivo para obtenerlo <"


def JustUsers(take_from = "data.txt"):
    file_path = TakeFiles(take_from)
    file = open(file_path,"r")
    data_list = file.readlines()
    user_data_list = []
    for i in range(0,len(data_list)):
        index_of_spliter = (data_list[i].index(","))
        user_data = (data_list[i])
        new_data = ""
        for j in range(0,index_of_spliter):
            new_data += user_data[j]
        user_data_list.append(new_data)
    return user_data_list

def CheckUserExist(user):
    user_list = JustUsers("data.txt")
    exist = False
    if user in user_list:
        exist = True
    return exist



print("""
=================================
Bienvenido al registro de datos
de Multiadornos Maicao.

1) Registrar datos
2) Buscar un usuario (Sí / No)
3) Iniciar sesión
=================================

""")

user_choose = input("Elige una opción: ")

if user_choose == "1":
    user = input("Ingresa un usuario: ")
    password = input("Ingresa una contraseña: ")
    user_encrypted = Encrypter(user)
    password_encrypted = Encrypter(password)
    if not CheckUserExist(user_encrypted):
        if (user_encrypted != "none") and (password_encrypted != "none"):
            #user_and_password = '{"'+user_encrypted+'"'+','+'"'+password_encrypted+'"}'
            user_and_password = f"{user_encrypted},{password_encrypted}"
            file_path = TakeFiles("data.txt")
            file = open(file_path,"a")
            file.write(user_and_password)
            file.write("\n")
            file.close()
            print(f"Se guardaron los siguientes datos:\n{user} (Usuario)\n{password} (Contraseña)")
        else:
            print("Datos no válidos. Intentalo nuevamente")
    else:
        print("El usuario ya existe. Intenta ingresar otro")
        

elif user_choose == "2":
    user_to_find = input("Escribe el usuario a buscar: ")
    user_to_find = Encrypter(user_to_find)
    checker_anwser = CheckUserExist(user_to_find)
    if checker_anwser:
        print("El usuario existe")
    else:
        print("El usuario no exite")
    
elif user_choose == "3":
    user = input("Usuario: ")
    password = input("Contraseña: ")
    user = Encrypter(user)
    password = Encrypter(password)

    if CheckUserExist(user):
        user_list = JustUsers("data.txt")
        total_login = user+","+password+"\n"
        file_path = TakeFiles("data.txt")
        file = open(file_path,"r")
        data_list = file.readlines()
        if total_login in data_list:
            print("Has iniciado sesión con éxito")
        else:
            print("Tu contraseña es incorrecta. Intenta nuevamente")

    else:
        print("El usuario ingresado no existe")
    



else:
    print("Debes elegir una de las anteriores opciones")



def CorrectData(data):
    new_data = []
    for i in range(0,len(data)):
        current_data = data[i]
        current_data_len = len(current_data)
        current_data = current_data[0][(current_data_len-1)]
        new_data.append(current_data)
    return new_data