import json
from login_admin import TakeFiles, AccountRegister, DataTaker, UserExist, LoginChecker, Encrypter


'''
user_input = input("Usuario: ")
password_input = input("Clave: ")


data = {user_input:password_input}

data_entry = json.dumps(data)
print(data_entry)

#print(data_entry)

#Escribiendo en un archivo

file_path = 'uandp.json'
with open(file_path, 'w') as file:
    json.dump(data, file)

'''


'''data = [
  {
    "name": "Arena1",
    "disabled": False,
    "kits": [],
    "positions": {}
  },
  {
    "name": "Torneo Argenta",
    "disabled": False,
    "kits": [],
    "positions": {}
  },
  {
    "name": "Jardin del Eden",
    "disabled": False,
    "kits": [],
    "positions": {}
  },
  {
    "name": "Dungeon",
    "disabled": False,
    "kits": [],
    "positions": {}
  }
]'''

'''
data = [
    {
        'user':'david',
        'password': '123'
    },
    {
        'user':'paola',
        'password':'321'
    },
    {
        'user':'calacho',
        'password':'nose'
    }
]
'''


print("""
==================
Lista de opciones
==================

1) Registrarse (New Way)
2) Imprimir lista de datos
3) Verificar si un usuario existe
4) Iniciar sesión
""")
user_choose = input("Elige una opción: ")

if user_choose == "1":
    print("Registrar usuario\n\n")

    user = input("Usuario: ")
    password = input("Contraseña: ")
    #safer = input("¿Quieres proteger tu cuenta (Si - No)?: ")
    safer = "si"
    YoN = True
    if (safer).lower() == "no":
        YoN = False
    else:
        YoN = True
    AccountRegister(user,password,YoN)


elif user_choose == "2":
    data = DataTaker("data.txt")
    for i in range(0,len(data)):
        print(data[i])

elif user_choose == "3":
    user = input("Usuario a buscar: ")
    user = Encrypter(user)
    DoesUserExist = UserExist(user)
    if DoesUserExist:
        print("Sí, el usuario existe")
    else:
        print("No, el usuario no existe")

elif user_choose == "4":
    user = input("Usuario: ")
    password = input("Contraseña: ")
    user_e = Encrypter(user)
    password_e = Encrypter(password)
    AccessAllowed = LoginChecker(user_e,password_e)
    if AccessAllowed:
        print("Has iniciado sesión con éxito")
        user_index = UserExist(user,True)
        print(f"Bienvenid, {user}. Te encuentras en la base de datos en la posición {user_index}")
    else:
        print("Acceso inválido")