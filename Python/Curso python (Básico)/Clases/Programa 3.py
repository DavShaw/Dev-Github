#Hoy aprenderemos: A usar el str(), .find para buscar y extraer porciones de textos/numeros

'''=Zona especial para asignar variables=='''

'''Variables para iniciar codificacion'''

number_pi = "3,141592653589793238462"
find_subchain = number_pi.find("93238462")

'''Variables para transformar numeros a texto y contatenar'''
Resultados_de_la_busqueda = ("Resultados de la busqueda (Sólo posición): ")
Resultados_de_la_busqueda += str(find_subchain)
'''Variables de extración'''
numero_telefonico_del_developer = "3107053966"
extract_subchain = numero_telefonico_del_developer[5:10]
'''=Zona especial para asignar variables=='''
print(Resultados_de_la_busqueda)
print("")
print("Últimos 4 digitos del numero telefonico del Developer: "+extract_subchain)

