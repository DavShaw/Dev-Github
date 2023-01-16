import sys
import os

characters_list = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ$%&/><;.:-_+@"
characters_encrypted = ['Stq', 'RS.', '1Bh', '>YD', '5Ug', '5/.', 'odt', 'XmL', 'cg>', '3hx', 'oIh', 'Ouc', 'few', '4ic', 'yGJ', '9z.', 'zPX', 'KU0', 'eVg', '9My', '8kA', '3rJ', 'XGr', '%2s', '02L', '$Ub', 'E:f', '&Lh', '30o', '2n.', '8qx', 'neQ', '1uS', '9Xt', '.53', 'p0s', 'hiS', 'GQe', '2Jt', '/48', 'ZiD', 'dKW', 'XOJ', 'vn0', 'lmv', 'Zhy', 'F_;', '7+i', '/dt', 'J0R', 'si3', 'W_q', 'P;R', 'U.-', ';C>', 'Gjo', 'clE', '+7r', 'VeL', 'rgv', 'y%j', '.J6', 'N>+', 'iEP', 'EAc', 'KrV', 'z8y', 'NsQ','/0v', 'TQA', '2vR', 'Arj', 'JN5', 's62', 'o9S']
#add new characters:u and U
def RandomNumber(amount = 3, limit = 35):
    import random
    togive = []
    for i in range(0,amount):
        temp = random.randint(0,limit)
        togive.append(temp)
    return togive


def MakeEncryptedList():
    aux_list = []
    for i in range(0,len(characters_list)):
        aux1 = RandomNumber(3,len(characters_list)-1)
        aux2 = ""
        for j in range(0,len(aux1)):
            aux2 = aux2 + characters_list[aux1[j]]
        aux_list.append(aux2)
    return aux_list
        
def Encrypter(information):
    
    #Verify if the string is allowed
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
        information_new = "none"
        return information_new


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

def TakeFiles(file = "nothing"):
    file = str(file)
    if (file != "nothing"):
        give = os.path.join(sys.path[0], f"{file}")
        return give
    else:
        return "> You must enter a path to find the file! - Debes especificar una ruta de archivo para obtenerlo <"


def CheckLogin(user,password):
    user_list = JustUsers()
    UserAndPassword = user + "," + password
    file = open(TakeFiles("data.txt"))
    data_list = file.readlines()
    data_list = CorrectData(data_list)
    if (UserAndPassword) in (data_list):
        return True
    else: 
        return False


def CorrectData(data):
    new_data = []
    for i in range(0,len(data)):
        current_data = data[i]
        current_data_len = len(current_data)
        new_current_data = ""
        for j in range(0,len(current_data)-1,1):
            new_current_data += current_data[j]
        new_data.append(new_current_data)
    return new_data