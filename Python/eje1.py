print("1 - cual es mayor")
print("2 - cual es menor")
print("")
user_chose = int(input("Elige una opción: "))
if user_chose == 1:
    print("")
    print("Vamos a saber cual es mayor")
    print("")
    n1 = int(input("1er numero: "))
    n2 = int(input("2do numero: "))
    if n1 > n2:
        print(f"El numero {n1} es mayor que {n2}")
    else:
        print(f"El numero {n2} es mayor que {n1}")
    
    
    
    
    
    
    
elif user_chose == 2:
    print("")
    print("Vamos a saber cual es menor")
    print("")
    n1 = int(input("1er numero: "))
    n2 = int(input("2do numero: "))
    if n1 < n2:
        print(f"El numero {n1} es menor que {n2}")
    else:
        print(f"El numero {n2} es menor que {n1}")
        
        
    

    