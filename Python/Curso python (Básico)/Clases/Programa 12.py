#Hoy aprenderemos: Sentencias condicionales multiples

#



adorno = str("================================")
name_adorno = str("======================================")
null = str(" ")
adorno_int_to_str = str("====================")

#

print(adorno)
print("Binvenido al inicio del programa")
print(adorno)
print(null)
user_name = str(input("¿Cómo te llamas?: "))


print(null)
print(null)
print(null)

print(name_adorno)
print(user_name + ", te damos la bienvenida programa")
print(name_adorno)

print(null)
print(null)
print(null)


number_convert = int(input("""¿Qué numero quieres convertir?: """))

if number_convert == 1:
    print("""
    
El numero es uno""")
elif number_convert == 2:
    print("""
    
El numero es dos""")
elif number_convert == 3:
    print("""
    
El numero es tres""")
elif number_convert == 4:
    print("""
    
El numero es cuatro""")
elif number_convert == 5:
    print("""
    
El numero es cinco""")
elif number_convert == 6:
    print("""
    
El numero es seis""")
elif number_convert == 7:
    print("""

El numero es siete""")
elif number_convert == 8:
    print("""
    
El numero es ocho""")   
elif number_convert == 9:
    print("""
    
El numero es nueve""")
elif number_convert == 10:
    print("""
    
El numero es diez""")
else: 
    print("""
    
    El programa solo reconoce hasta el número 10""")
