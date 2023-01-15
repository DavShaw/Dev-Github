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
        Hey! There's a error. That looks like you have entered any character that isn't allowed.
        If the system detects any character don't register, the Encrypter will not work correctly
        Check here our allowed character list:
        ================================
        {characters_list_4_user}
        ================================
        You've entered: {information}
        """)
        information_new = "none"
        return information_new
    

def Unencrypter(information):
    information_list = []
    for i in range(2,len(information),3):
        pass


Unencrypter("123456")



