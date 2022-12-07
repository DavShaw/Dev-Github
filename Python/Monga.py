#################################################################################################################
#Welcome to Monga (Monster Game) - By: David Torres [computerstystems engineer student - Universidad de Medellín]
#################################################################################################################

#########################################
              #Emoji zone#
#########################################
def change_emoji():
    import time
    print("\n\n¡Atento! El cambio de emojis es muy delicado :o")

    enemy = input("Simbolo del enemigo: ")
    allow = input("Simnolo de área permitida al enemigo: ")
    deny = input("Simbolo de área denegada al enemigo: ")
    print("\n\n\n")
    for i in range(1,6):
        space = "\n"
        time.sleep(1.5)
        print(f"{space}Procesando ({i*20}%) {space}")
    return enemy,allow,deny

"""
Old icons repository

icon_enemy = "👻"
icon_allow = "🟢"
icon_deny = "🔴"

"""
#########################################




#Fuctions Zone (Start)


#Newbies explain
def how_to_play():
    print(f"""
==============================================================================
¡Hola! Me alegra mucho tenerte acá, soy Monga, tu guía personal....

Procederé a explicarte lo más básico

* ¿En que ambiente me encuentro?
    Te encuentras luchando contra un monstro muy malvado ({icon_enemy}) llamado Fankou
    y tu objetivo es encarcelarlo por toda la eternidad :o

* ¿Cómo se encierra?
    Esperaba con ansias esta pregunta... Bueno, eres una deidad, así que
    con poderes mágicos podrás bloquear partes disponibles del campo, recuerda
    que en las partes disponibles ({icon_allow}) Fankou podrá moverse libremente, entonces
    deberás bloquear con mucha estrategía la mayoría de los campos disponibles

* ¿Con qué se encierra?
    Usando tus poderes, podrás bloquear su camino usando rocas misticas gigantes
    las cuales le impiden el movimiento ({icon_deny}) y estas mismas tienen un uso limitado
    dependiendo de la dificultad.

    Al iniciar el juego, verás con tus poderes donde está Fankou, así podrás
    bloquearle sus zonas de una forma inteligente. De igual forma, podrás ver
    en el mapa la ubicación por medio de coordenadas, y justamente, con las 
    coordenadas podrás bloquearle los saltos a Fankou....

    [ ] [ ] [ ] 1 < x

    [ ] [{icon_deny}] [ ] 2 < x

    [ ] [{icon_enemy}] [ ] 3 < x

     ^   ^   ^
     1   2   3
     y   y   y

    RECUERDA: (x,y)
    Fankou está en: 3,2
    Roca mistica está en: 2,2
    """)




#Gonna make a special position for the monster
def monster_starts(matrix):
    import random
    enemy = "\x1b[1;31m" +"♣"+"\x1b[37m"
    enemy = icon_enemy
    x = random.randint(0,len(matrix)-1)
    y = random.randint(0,len(matrix)-1)
    matrix[x][y] = f"  {enemy} "




#Avoid player override enemy position!
def anti_enemy_override(matrix):
    long = int(len(matrix))
    for i in range(0,long):
        if (f"  {icon_enemy} " in matrix[i]) == True:
            location = matrix[i].index(f"  {icon_enemy} ")
            x = i
            y = location
    return x,y


def cant_enemy_move(matrix):
#=================================================================================================================================
    x,y = anti_enemy_override(matrix)
    last = (len(matrix)-1)
#=================================================================================================================================   
#  
    #Is enemy in the top?True
    if x == 0:
        #Is enemy in the top left border?
        if y == 0:
            #Is enemy blocked?
            if matrix[0][1] == f"  {icon_deny} " and matrix[1][0] == f"  {icon_deny} ":
                return True
        #Is enemy in the top right border?
        elif y == last:
            #Is enemy blocked?
            if matrix[0][last-1] == f"  {icon_deny} " and matrix[1][last-1] == f"  {icon_deny} ":
                return True
        #Enemy have to be between 0 and last
        elif matrix[x][y-1] == f"  {icon_deny} " and matrix[x][y+1] == f"  {icon_deny} " and matrix[x+1][y] == f"  {icon_deny} ":
            return True
#=================================================================================================================================
    #Is enemy in the bottom?
    elif x == last:
        #Is enemy in the bottom left border?
        if y == 0:
            #Is enemy blocked?
            if matrix[last][1] == f"  {icon_deny} " and matrix[last-1][y] == f"  {icon_deny} ":
                return True
        #Is enemy in the bottom right border?
        elif y == last:
            #is enemy blocked?
            if matrix[last][y-1] == f"  {icon_deny} " and matrix[last-1][y] == f"  {icon_deny} ":
                return True
        #Is enemy between 0 and last?
        elif matrix[x][y-1] == f"  {icon_deny} " and matrix[x][y+1] == f"  {icon_deny} " and matrix[x-1][y] == f"  {icon_deny} ":
            return True
#=================================================================================================================================

    #Is enemy in the left column?
    elif y == 0:
        #Is enemy blocked?
        if matrix[x+1][y] == f"  {icon_deny} " and matrix[x-1][y] == f"  {icon_deny} " and matrix[x][y+1] == f"  {icon_deny} ":
            return True
#=================================================================================================================================

    #Is enemy in the right column?
    elif y == last:
        #Is enemy blocked?
        if matrix[x+1][y] == f"  {icon_deny} " and matrix[x-1][y] == f"  {icon_deny} " and matrix[x][y-1] == f"  {icon_deny} ":
            return True
#=================================================================================================================================
    #If enemy doesn't is in: top or bottom or left side or right side, enemy HAVE to be inside matrix borders
    
    #Checking all slots in front, behiden, up and down the enemy...
    elif x != 0 and x != last and y != 0 and y != last:
        #Is enemy blocked?
        if matrix[x][y-1] == f"  {icon_deny} " and matrix[x][y+1] and matrix[x-1][y] == f"  {icon_deny} " and matrix[x+1][y] == f"  {icon_deny} ":
            return True

    return False
#=================================================================================================================================








#block any position by player
def block(matrix):

    coor1,coor2 = anti_enemy_override(matrix) #Enemy position

    x = input(f"Bloquear en X (0 - {len(matrix)-1}): ")

    if x.isdigit(): #Avoid non integer elemets
        x = int(x)
    else:
        while(True):
            print("X no válida. Vamos nuevamente\n")
            x = input(f"Bloquear en X (0 - {len(matrix)-1}): ")
            if x.isdigit():
                x = int(x)
                break

    while(x < 0 or x > (len(matrix)-1)): #If X is out of range
        print("X no válida. Vamos nuevamente\n")
        x = int(input(f"Bloquear en X (0 - {len(matrix)-1}): "))




    y = input(f"Bloquear en y (0 - {len(matrix)-1}): ")

    if y.isdigit(): #Avoid non integer elemets
        y = int(y)
    else:
        while(True):
            print("Y no válida. Vamos nuevamente\n")
            y = input(f"Bloquear en y (0 - {len(matrix)-1}): ")
            if y.isdigit():
                y = int(y)
                break
    while(y < 0 or y > (len(matrix)-1)): #If Y is out of range
        print("y no válida. Vamos nuevamente\n")
        y = int(input(f"Bloquear en X (0 - {len(matrix)-1}): "))


    while(x == coor1 and y == coor2): #IF entered X,y is equals to X,y enemy position
        print("Oops, ahí parece estar el enemigo, no puedes hacer el bloqueo...\n")
        x = int(input(f"Bloquear en X (0 - {len(matrix)-1}): "))
        y = int(input(f"Bloquear en X (0 - {len(matrix)-1}): "))
    

    matrix[x][y] = f"  {icon_deny} "



#Gonna give you any number between [1,2]
def random(): 
    import random
    number = random.randint(1,2)
    return number
    #1 -> horizontal (y)
    #2 -> vertical (x)


def move_enemy(type,matrix):
    x,y = anti_enemy_override(matrix)
    last = (len(matrix[0])-1)
    if type == 1: #Move horizontal

        if y == 0: #If enemy is in the 1st slot

            if matrix[x][y+1] != f"  {icon_deny} ": #Checking if enemy can move to next slot
                matrix[x][y] = f"  {icon_allow}  "
                y += 1
                matrix[x][y] = f"  {icon_enemy} "
                show_matrix(matrix)

        elif y == last: #If enemy is in the last slot

            if matrix[x][y-1] != f"  {icon_deny} ": #Checking if enemy can move to the previous slot
                matrix[x][y] = f"  {icon_allow}  "
                y -= 1
                matrix[x][y] = f"  {icon_enemy} "
                show_matrix(matrix)



        elif (y != 0) and (y != last): #If enemy is between 1st and last slots     <Marked - IS IMPORTANT>

            if matrix[x][y+1] != f"  {icon_deny} ": #Checking if enemy can move to next slot
                matrix[x][y] = f"  {icon_allow}  "
                y += 1
                matrix[x][y] = f"  {icon_enemy} "
                show_matrix(matrix)

            elif matrix[x][y-1] != f"  {icon_deny} ": #Checking if enemy can move to the previous slot
                matrix[x][y] = f"  {icon_allow}  "
                y -= 1
                matrix[x][y] = f"  {icon_enemy} "
                show_matrix(matrix)

    elif type == 2: #Move horizontal
        if x == 0: #If enemy is in the 1st slot

            if matrix[x+1][y] != f"  {icon_deny} ": #Checking if enemy can move to next row
                matrix[x][y] = f"  {icon_allow}  "
                x += 1
                matrix[x][y] = f"  {icon_enemy} "
                show_matrix(matrix)

        elif x == last: #If enemy is in the last row

            if matrix[x-1][y] != f"  {icon_deny} ": #Checking if enemy can move to the previous row
                matrix[x][y] = f"  {icon_allow}  "
                x -= 1
                matrix[x][y] = f"  {icon_enemy} "
                show_matrix(matrix)



        elif (x != 0) and (x != last): #If enemy is between 1st and last rows     <Marked - IS IMPORTANT>

            if matrix[x+1][y] != f"  {icon_deny} ": #Checking if enemy can move to next row
                matrix[x][y] = f"  {icon_allow}  "
                x += 1
                matrix[x][y] = f"  {icon_enemy} "
                show_matrix(matrix)

            elif matrix[x-1][y] != f"  {icon_deny} ": #Checking if enemy can move to the previous row
                matrix[x][y] = f"  {icon_allow}  "
                x -= 1
                matrix[x][y] = f"  {icon_enemy} "
                show_matrix(matrix)
    return x,y
                

    #Remove current enemy position to null
    



#The matrix have to be NxN
def create_matrix(long):
    matrix = []
    for i in range(0,long):
        matrix.append([])
        for j in range(0,long):
            matrix[i].append(f"  {icon_allow}  ")
    return matrix









#The matrix have to be NxN
def show_matrix(matrix):
    vector = []
    long = len(matrix)
    for i1 in range(0,long):
        text = f" y: {i1}"
        vector.append(text)
    
    print("\n")
    print(vector)
    for j in range(0,long):
        print("")
        print(matrix[j],f" < x: {j}")
        print("")







#Show welcome message
def welcome():
    print(f"""
                                                    ====== < [Bienvenido a Monga] > ======
                                                        1) Nivel fácil > (2x2) [x2 {icon_deny}]
                                                        2) Nivel medio > (3x3) [x5 {icon_deny}]
                                                        3) Nivel intermedio > (4x4) [x10 {icon_deny}]
                                                        4) Nivel dificil > (5x5) [x20 {icon_deny} ]
                                                        5) Nivel legendario > (6x6) [x30 {icon_deny}]
                                                    ======================================
""")
#Select your level
def select_level():

    level = int(input("Elegir nivel: "))
    
    while(level < 1 or level > 5):
        print(f"\nHas elegido un nivel inválido. Hazlo nuevamente")
        level = int(input("Elegir nivel: "))
    return (level+1)

def spacer(long):
    for i in range(0,long):
        print("\n")

#Fuctions Zone (End)


















#Developing game...



#Part #1 (Starting game)
print(f"""
|========================|
|version: 1.0 (BETA)     |
|by: David Torres        |
|========================|
""")
spacer(8)
print(f"""
|========================================|
|            ¿Qué deseas hacer?          |         
|========================================|
""")
spacer(2)
print("""
1) Guía del juego
2) Jugar
3) Cambiar iconos
""")
spacer(2)
what_to_do = int(input("Elegir: "))
if what_to_do == 1:
    icon_enemy = "👻"
    icon_allow = "🟢"
    icon_deny = "🔴"
    how_to_play()
    spacer(2)
    ready = input("Presiona 'ENTER' para continuar...\n")
    if ready != "{+g+.gwe+ñ{--,lpw-{wfkutyudavidad0258512515":
        spacer(50)
        pass
elif what_to_do == 2:
    icon_enemy = "👻"
    icon_allow = "🟢"
    icon_deny = "🔴"
    spacer(50)
    pass
elif what_to_do == 3:
    x,y,z = change_emoji()

    icon_enemy = x
    icon_allow = y
    icon_deny = z


welcome()
level = select_level()
Monga = create_matrix(level)
monster_starts(Monga)
show_matrix(Monga)


#Part #2 (Blocking slots) and block max number
blocks_slots = 0
if (level-1) == 1:
    blocks_slots = 2

elif (level-1) == 2:
    blocks_slots = 5

elif (level-1) == 3:
    blocks_slots = 10

elif (level-1) == 4:
    blocks_slots = 20
    
elif (level-1) == 5:
    blocks_slots = 30

for i in range(blocks_slots,0,-1):
    lose = True
    print("Movimientos restantes:",i)
    block(Monga)
    show_matrix(Monga)


    if (cant_enemy_move(Monga)):
        spacer(2)
        lose = False
        print(f"¡Has ganado! Fankou no puede moverse, lo has encerrado :D\n\n(Te sobraron {i-1} movimientos)")
        break


    moving_type = random()
    spacer(8)
    move_enemy(moving_type,Monga)

if lose:
    print("¡Los movimientos han acabado y Fankou sigue moviendose libremente :(!")






