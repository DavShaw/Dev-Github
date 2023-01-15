characters_list = "abcdefghijklmnopqrstvwxyz0123456789ABCDEFGHIJKLMNOPQRSTVWXYZ$%&/><,;.:-_{+@"
characters_encrypted = ['xvP', 'LHM', 'N:m', '%yZ', 'id_', 'lfq', '@&>', 'BTD', 'oNG', ',4E', '8gm', 'we.', '8$1', 'fwO', 'xPM', 'SAx', 'RhE', 'm8/', 'gFo', '{Ps', '4x-', 'eN>', 'hKX', 'RCq', 'bf,', 'zn-', 'EpO', '2TK', 'p>s', '<9>', 'rpe', '%Ny', '/v4', 'K>%', '@ID', 'LEW', 'Cyf', 'IE4', 'R@_', 'QX0', 'E.f', ':c-', 'Evs', 'i<Y', 'jwh', '37W', 'yk0', '-z.', 'jsY', 'XMI', 'VlW', 'Oto', 'NlR', 'RWe', 'a8l', '-Ps', 'Xy-', 'iak', 'zDL', 'W$A', '@+i', 'T79', 'XVr', 'v_k', '8{X', 't-D', 'D&7', 'KxW', 'Cy6', 'vG0', 't;F', 'JPO', '-dZ', 'l3d', 'FB$']

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
        characters_list_4_user = "a b c d e f g h i j k l m n o p q r s t v w x y z 0 1 2 3 4 5 6 7 8 9 A B C D E F G H I J K L M N O P Q R S T V W X Y Z $ % & / > < , ; . : - _ { + @"
        print(f"""
Hey! There's a error. That looks like you have entered any character that isn't allowed.
If the system detects any character don't register, the Encrypter will not work correctly

Check here our allowed character list:

================================
{characters_list_4_user}
================================

You've entered: {information}

        """)

        information_new = "InvalidProccess"
        return information_new

test = Encrypter("ElPP")
print(test)