
print("\n===================================")
print("Validar si un numero es par o impar")
print("===================================\n")

user_input_int = int(input("Escribe el número entero a validar: "))

confirm_pair_odd = user_input_int % 2

if confirm_pair_odd == 0:
    print("\n\n==================\n")
    print("Número ingresado:", user_input_int)
    print("Resultado: Es par")
    print("\n==================\n")
elif confirm_pair_odd == 1: 
    print("\n\n==================\n")
    print("Número ingresado:", user_input_int)
    print("Resultado: Es impar")
    print("\n==================\n")
else: 
    print("¡El sistema ha fallado!")
