#Hoy aprenderemos: Formas de comentar en Python3


'''Zona especial para variables'''
null = " "

adorno = "==============================================================="

comment_type = "Tipo de comentario: "

comment_type_text_1 = "Numeral"
comment_type_text_2 = "Comillas triples"
comment_type_text_3 = "Comillas dobles"


comment1 = "#"
comment2 = "'''"
comment3 = ""

description_type = "Descripción: "

desciption_comment1 = "Es simple, y es para una sola línea"
desciption_comment2 = "Es complejo, pero sirve para multiples líneas"
desciption_comment3 = "Es simple, pero no es como tal un comentario"


'''Zona especial para variables'''

#Acá comienzan los códigos

print(adorno)
print(comment_type + comment_type_text_1)
print("Simbolo: "+ comment1)
print(description_type + desciption_comment1)
print(adorno)

print(null)
print(null)
print(null)

print(adorno)
print(comment_type + comment_type_text_2)
print("Simbolo: "+ comment2)
print(description_type + desciption_comment2)
print(adorno)

print(null)
print(null)
print(null)

print(adorno)
print(comment_type + comment_type_text_3)
print('Simbolo: ' + '""')
print(description_type + desciption_comment3)
print(adorno)


