#Hoy aprenderemos: Uso de While


print("******************************")
print("Bienvenido a adivina mi nombre")
print("******************************")
print("")
print("")
print("Sólo debes adivinar mi nombre, y en caso\nde hacerlo correctamente, el while\ncomenzará a funcionar :D\n\n\n")

guess_my_name = str(input("¿Cuál es mi nombre?: "))
guess_my_name = guess_my_name.lower()

admin_name = "david"

while admin_name == guess_my_name:
    print("Has adivinado mi nombre correctamente, que bueno eres")
    
print("Eres pésimo adivinando nombres")