import sys
import os
import random
from tkinter import messagebox
import re
import json
import sqlite3
from config import config_staff, config_measurement
#============================================#
#G L O B A L   V A R I A B L E S

characters_list = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ$%&/><;.:-_+@"
characters_encrypted = ['Stq', 'RS.', '1Bh', '>YD', '5Ug', '5/.', 'odt', 'XmL', 'cg>', '3hx', 'oIh', 'Ouc', 'few', '4ic', 'yGJ', '9z.', 'zPX', 'KU0', 'eVg', '9My', '8kA', '3rJ', 'XGr', '%2s', '02L', '$Ub', 'E:f', '&Lh', '30o', '2n.', '8qx', 'neQ', '1uS', '9Xt', '.53', 'p0s', 'hiS', 'GQe', '2Jt', '/48', 'ZiD', 'dKW', 'XOJ', 'vn0', 'lmv', 'Zhy', 'F_;', '7+i', '/dt', 'J0R', 'si3', 'W_q', 'P;R', 'U.-', ';C>', 'Gjo', 'clE', '+7r', 'VeL', 'rgv', 'y%j', '.J6', 'N>+', 'iEP', 'EAc', 'KrV', 'z8y', 'NsQ','/0v', 'TQA', '2vR', 'Arj', 'JN5', 's62', 'o9S']
staff = config_staff
medidas = config_measurement

ayuda_medidas = ""
for i in range(0,len(medidas)):
    ayuda_medidas += f" * {medidas[i]}"
    ayuda_medidas += "\n"
ayuda_msg = (f"""
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

{ayuda_medidas}
----------------------------------------------------------------------------
Ref. Producto »\n
* Simplemente es la referencia con la cual se identifica en el 
inventario al producto.\n
----------------------------------------------------------------------------
Añadido por »\n
* Sólo escribe tú nombre, persona la cual se encuentra editando el listado de
productos (Es posible que tu nombre se añada automáticamente).
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
#DATABASE ZONE

def CheckPrimaryKey(vaule):
    #Setting input as string
    vaule = str(vaule)
    ref_products = []
    dbfile_path = TakeFiles("productos.db")
    DBConnector = sqlite3.connect(dbfile_path)
    DBCursor = DBConnector.cursor()
    DBCursor.execute(f"SELECT * FROM productos")
    all_products = DBCursor.fetchall()
    DBConnector.commit()
    DBConnector.close()
    for i in range(0,len(all_products)):
        ref_products.append(all_products[i][4])
    if vaule in ref_products:
        return True
    return False


def CheckRightInfoToAddProducts(nombre,precio,medida,cantidad,referencia,agregadopor):

    #Checking if any entry is null
    if (nombre == "") or (precio == "") or (medida == "") or (cantidad == "") or (referencia == "") or (agregadopor == ""):
        messagebox.showwarning(title="Alerta",message="No puedes dejar campos vacíos")
        return False

    #Checking if name entry is a digit (That cannot be)
    if nombre.isdigit():
        messagebox.showwarning(title="Alerta",message="El nombre del producto no puede ser un número")
        return False

    #Checking if price entry isn't a digit (float or int)
    if not (precio.isdigit()):
        messagebox.showwarning(title="Alerta",message=f"El precio debe de ser un número")
        return False

    #Checking if medida isn't register
    if not (medida in medidas):
        messagebox.showwarning(title="Alerta",message="La medida ingresada no está registrada (Revisa el botón de ayuda)")
        return False

    #Checking if cantidad is a digit
    if not (cantidad.isdigit()):
        messagebox.showwarning(title="Alerta",message=f"La cantidad debe ser un número")
        return False

    #Checking if ref is allowed (Doesnt exist another product with the same ref)
    if CheckPrimaryKey(referencia):
        messagebox.showwarning(title="Alerta",message=f"Ya existe un producto con esta misma referencia ({referencia})")
        return False

    #Cheking if staff who added the product is allowed
    if not (agregadopor in staff):
        messagebox.showwarning(title="Alerta",message="El personal ingresado no está registrado")
        return False
    #If anyone condiction is true (That means: there's not erros in the information input) that gonna return True
    return True

def ShowProducts(vaule_center = 0):
    products = ""
    dbfile_path = TakeFiles("productos.db")
    DBConnector = sqlite3.connect(dbfile_path)
    DBCursor = DBConnector.cursor()
    DBCursor.execute(f"SELECT * FROM productos")
    all_products = DBCursor.fetchall()
    DBConnector.commit()
    DBConnector.close()
    products += (f"Productos totales: {len(all_products)}\n\n").center(vaule_center)
    for i in range(0,len(all_products)):
        products += ("==================").center(vaule_center)
        products += ("\n").center(vaule_center)
        products += (f"Nombre: {all_products[i][0]}").center(vaule_center)
        products += ("\n").center(vaule_center)
        products += (f"Precio: {all_products[i][1]}").center(vaule_center)
        products += ("\n").center(vaule_center)
        products += (f"Medida: {all_products[i][2]}").center(vaule_center)
        products += ("\n").center(vaule_center)
        products += (f"Cantidad: {all_products[i][3]}").center(vaule_center)
        products += ("\n").center(vaule_center)
        products += (f"Referencia: {all_products[i][4]}").center(vaule_center)
        products += ("\n").center(vaule_center)
        products += (f"Agregado por: {all_products[i][5]}").center(vaule_center)
        products += ("\n").center(vaule_center)
        products += ("==================").center(vaule_center)
        products += ("\n\n\n").center(vaule_center)
    return products

def SetFormatData(productlist = []):
    products = f"Productos totales: {len(productlist)}\n\n"
    for i in range(0,len(productlist)):
        products += ("==================")
        products += ("\n")
        products += (f"Nombre: {productlist[i][0]}")
        products += ("\n")
        products += (f"Precio: {productlist[i][1]}")
        products += ("\n")
        products += (f"Medida: {productlist[i][2]}")
        products += ("\n")
        products += (f"Cantidad: {productlist[i][3]}")
        products += ("\n")
        products += (f"Referencia: {productlist[i][4]}")
        products += ("\n")
        products += (f"Agregado por: {productlist[i][5]}")
        products += ("\n")
        products += ("==================")
        products += ("\n\n\n")
    return products


def FindProducts(producttosearch = "",searchmode = "ref"):
    all_products = []
    send_products = []
    

    dbfile_path = TakeFiles("productos.db")
    DBConnector = sqlite3.connect(dbfile_path)
    DBCursor = DBConnector.cursor()
    DBCursor.execute(f"SELECT * FROM productos")
    all_products = DBCursor.fetchall()
    DBConnector.commit()
    DBConnector.close()

    if (searchmode == "ref"):
        for i in range(0,len(all_products)):
            if all_products[i][4] == producttosearch:
                send_products.append(all_products[i])
        return send_products

    elif (searchmode == "name"):
        for i in range(0,len(all_products)):
            if all_products[i][0] == producttosearch:
                send_products.append(all_products[i])
        return send_products
    else:
        messagebox.showerror(title="Busqueda",message="Parece que has ingresado una opción no válida. (sólo se permite ref o name)")
        return send_products

def ProductShower(producttosearch = "",searchmode = ""):
    MainList = FindProducts(producttosearch,searchmode)
    MainString = SetFormatData(MainList)
    return MainString
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