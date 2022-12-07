#Hoy aprendermos: Operadores lógicos (AND - OR - NOT)
null = ""
adorno = "==========="

operador_and = "Conjunción -> AND"
operador_or = "Disyunción -> OR"
operador_not = "Negación -> NOT"

#========================(AND)========================
user_name = "cuchy_torres@hotmail.com"
user_pass = "1022"

print(adorno,operador_and,adorno)

login_user_name = str(input("¿Cuál es tu nombre de usuario/E-mail?: "))
login_user_pass = str(input("¿Cuál es la contraseña?: "))

login_user_name = login_user_name.lower()

if user_name == login_user_name and user_pass == login_user_pass:
    print("Has accedido con éxito. Bienvenido")
else:
    print("No has logrado acceder. Rechazado")
#========================(AND)========================

print(null)
print(null)
print(null)
print(null)

#========================(OR)========================
print(adorno,operador_or,adorno)

user_answer = str(input("Por favor, escriba 'SI' o 'NO': "))
user_answer = user_answer.upper()

if user_answer == "SI" or user_answer == "NO":
    print("Has respetado las peticiones")
else: 
    print("No has respetado las peticiones")


#========================(OR)========================

print(null)
print(null)
print(null)
print(null)

#========================(NOT)========================
print(adorno,operador_not,adorno)

correct_answer = "AZUL"

ask_to_user = str(input("Di algo diferente a 'AZUL': "))
ask_to_user = ask_to_user.upper()

if not correct_answer == ask_to_user:
    print("Has dicho algo diferente a 'azul'. Felicidades")
else:
    print("Has dicho 'AZUL'. Perdedor")
#========================(not)========================