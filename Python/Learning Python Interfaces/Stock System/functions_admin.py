import sys
import os
import random
import re
import json










#============================================#
#G L O B A L   V A R I A B L E S

characters_list = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ$%&/><;.:-_+@"
characters_encrypted = ['Stq', 'RS.', '1Bh', '>YD', '5Ug', '5/.', 'odt', 'XmL', 'cg>', '3hx', 'oIh', 'Ouc', 'few', '4ic', 'yGJ', '9z.', 'zPX', 'KU0', 'eVg', '9My', '8kA', '3rJ', 'XGr', '%2s', '02L', '$Ub', 'E:f', '&Lh', '30o', '2n.', '8qx', 'neQ', '1uS', '9Xt', '.53', 'p0s', 'hiS', 'GQe', '2Jt', '/48', 'ZiD', 'dKW', 'XOJ', 'vn0', 'lmv', 'Zhy', 'F_;', '7+i', '/dt', 'J0R', 'si3', 'W_q', 'P;R', 'U.-', ';C>', 'Gjo', 'clE', '+7r', 'VeL', 'rgv', 'y%j', '.J6', 'N>+', 'iEP', 'EAc', 'KrV', 'z8y', 'NsQ','/0v', 'TQA', '2vR', 'Arj', 'JN5', 's62', 'o9S']
ayuda_msg = ("""
Parece que no entiendes mucho sobre esto... Te lo explicaré.
Sólo rellena la información que se te pide, de forma correcta.\n
----------------------------------------------------------------------------
Nombre Producto »\n
* Este será el nombre con el cual el producto será registrado.
Te recomiendo usar el nombre exacto con el que habitualmente lo
llamas. Eje: boton, guipiur, collar, cinta\n
----------------------------------------------------------------------------
Precio Producto »\n
* Este será el costo del producto, así de simple.
No uses ningún tipo de punto y/o coma, si el producto
cuesta 4,999,52 pesos, escribe directamente 4999 o 5000\n
----------------------------------------------------------------------------
Medida Producto »\n
* Es sencillamente el tipo de medida que usará este producto,
si se trata de un cuello, cinta, tela, deberá ser de medida 'metro'\n
    Te indicaré las medidas que admitimos.
     * mts » metros
     * und » unidad
     * mllr » millar\n
----------------------------------------------------------------------------
Ref. Producto »\n
* Simplemente es la referencia con la cual se identifica en el 
inventario al producto.\n
----------------------------------------------------------------------------
Añadido por »\n
* Sólo escribe tú nombre, persona la cual se encuentra editando el listado de
productos. Hasta la fecha sólo permitimos los siguientes personales:\n
    * Gloria
    * Miguel
    * Henrry
    * Ana
    * David\n
        """)
#============================================#








#============================================#
#N O   C L A S S I F I C A T I O N Z O N E

def RandomNumber(amount = 3, limit = 75):
    togive = []
    for i in range(0,amount):
        temp = random.randint(0,limit)
        togive.append(temp)
    return togive
#----------------------------------------------#
def TakeFiles(file = "nothing"):
    file = str(file)
    if (file != "nothing"):
        give = os.path.join(sys.path[0], f"{file}")
        return give
    else:
        return "> You must enter a file to find it <"
#----------------------------------------------#
def ChangeStrToDic(value):
        value_as_dict = re.sub("'", '"', value)
        value_as_dict = json.loads(value_as_dict)
        return value_as_dict
#============================================#










#============================================#

#E N C R Y P T E R   Z O N E
def MakeEncryptedList():
    aux_list = []
    for i in range(0,len(characters_list)):
        aux1 = RandomNumber(3,len(characters_list)-1)
        aux2 = ""
        for j in range(0,len(aux1)):
            aux2 = aux2 + characters_list[aux1[j]]
        aux_list.append(aux2)
    return aux_list
#----------------------------------------------#
def Encrypter(information):
    #Verify if the string is allowed
    space = " "
    if space in information:
        information_new = None
        return information_new
    allowed = False
    for v1 in range(0,len(information)):
        if (information[v1]) in characters_list:
            allowed = True
        else:
            allowed = False
    if allowed:
        information = str(information)
        information_split = []
        information_new = ""
        #Split the character into a list (for indexes)
        for i in range(0,len(information)):
            information_split.append(information[i])
        #For x index of splited character, it'll take y index of another list
        for j in range(0,len(information)):
            temp1 = information[j]
            temp2 = characters_list.index(temp1)
            information_new += characters_encrypted[temp2]
        return information_new
    else:
        characters_list_4_user = "a b c d e f g h i j k l m n o p q r s t u v w x y z 0 1 2 3 4 5 6 7 8 9 A B C D E F G H I J K L M N O P Q R S T U V W X Y Z $ % & / > < ; . : - _ + @"
        print(f"""
        Has ingresado un carácter no válido.
        Sólo permitimos mezclas de los siguientes carácteres
        ================================
        {characters_list_4_user}
        ================================
        Ingresaste: {information}
        """)
        information_new = None
        return information_new
#============================================#











#============================================#
#L O G I N  Z O N E

def AccountRegister(user,password,safe = True):
    if safe:
        user = Encrypter(user)
        password = Encrypter(password)
    send_data = {'user':user,'password':password}
    send_data = str(send_data)
    file_path = TakeFiles("data.txt")
    file = open(file_path,"a")
    file.write(send_data)
    file.write("\n")
    file.close()
#----------------------------------------------#
def DataTaker(take_from = "data.txt"):
    file_path = TakeFiles(take_from)
    file = open(file_path,"r")
    data = file.readlines()
    #Remove \n from lines
    new_data = []
    for i in range(0,len(data)):
        temp_user = data[i]
        temp_user2 = ""
        for j in range(0,(len(temp_user)-1),1):
            temp_user2 += temp_user[j]
        temp_user2 = ChangeStrToDic(temp_user2)
        new_data.append(temp_user2)
    return new_data
#----------------------------------------------#
def UserExist(user, giveindex = False):
    data = DataTaker()
    DoesUserExist = False
    data_index = 0
    for i in range(0,len(data)):
        if (data[i]['user']) == user:
            data_index = i
            DoesUserExist = True
    if giveindex == True:
        return data_index
    else:
        return DoesUserExist
#----------------------------------------------#
def LoginChecker(user,password):
    if not UserExist(user):
        return False
    if UserExist(user):
        user_index = UserExist(user,True)
        user_data = DataTaker()
        user_data = user_data[user_index]
        if (user_data['user'] == user) and (user_data['password'] == password):
            return True
        else:
            return False
#============================================#