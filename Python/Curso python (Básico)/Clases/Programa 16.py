print("==============================================")
print("¡Bienvenido al sistema de vacaciones de RAPPI!")
print("==============================================")

print("")
print("")

employee_name = str(input("¿Cuál es tu nombre y apellido?: "))
employee_dep = str(input("¿Cuál es tu departamiento (clave 1, 2 o 3)?: "))
employee_working_time =  int(input("¿Hace cuantos años trabajas con nosotros? (solo escribe el número): "))

employee_name = employee_name.upper()
employee_dep = employee_dep.upper()

print("")
print("")


#Departamiento de atención al cliente (Clave 1)
#1 año de servicio = 6 días
#2 - 6 años de servicio = 14 días
#7 años o más = 20 días
if employee_dep == "CLAVE 1" and employee_working_time == 1:
    print("=========== [Datos recopilados] ===========")
    print("")
    print("Trabajador:", employee_name)
    print("Departamento: Atención al cliente")
    print("Años de servicio:", employee_working_time)
    print("")
    print("Días de vacaciones: 6 días")
    print("")
    print("=========== [Datos recopilados] ===========")
    
elif employee_dep == "CLAVE 1" and employee_working_time <= 6:
    print("=========== [Datos recopilados] ===========")
    print("")
    print("Trabajador:", employee_name)
    print("Departamento: Atención al cliente")
    print("Años de servicio:", employee_working_time)
    print("")
    print("Días de vacaciones: 14 días")
    print("")
    print("=========== [Datos recopilados] ===========")
            
elif employee_dep == "CLAVE 1" and employee_working_time <= 7:
    print("=========== [Datos recopilados] ===========")
    print("")
    print("Trabajador:", employee_name)
    print("Departamento: Atención al cliente")
    print("Años de servicio:", employee_working_time)
    print("")
    print("Días de vacaciones: 20 días")
    print("")
    print("=========== [Datos recopilados] ===========")
    
    
#Departamiento de logistica (Clave 2)
#1 año de servicio = 7 días
#2 - 6 años de servicio = 15 días
#7 años o más = 22 días
if employee_dep == "CLAVE 2" and employee_working_time == 1:
    print("=========== [Datos recopilados] ===========")
    print("")
    print("Trabajador:", employee_name)
    print("Departamento: Logistica")
    print("Años de servicio:", employee_working_time)
    print("")
    print("Días de vacaciones: 7 días")
    print("")
    print("=========== [Datos recopilados] ===========")
elif employee_dep == "CLAVE 2" and employee_working_time <= 6:
    print("=========== [Datos recopilados] ===========")
    print("")
    print("Trabajador:", employee_name)
    print("Departamento: Logistica")
    print("Años de servicio:", employee_working_time)
    print("")
    print("Días de vacaciones: 15 días")
    print("")
    print("=========== [Datos recopilados] ===========")
elif employee_dep == "CLAVE 2" and employee_working_time <= 7:
    print("=========== [Datos recopilados] ===========")
    print("")
    print("Trabajador:", employee_name)
    print("Departamento: Logistica")
    print("Años de servicio:", employee_working_time)
    print("")
    print("Días de vacaciones: 22 días")
    print("")
    print("=========== [Datos recopilados] ===========")
    
    
    
#Departamiento de gerencia (Clave 3)
#1 año de servicio = 10 días
#2 - 6 años de servicio = 20 días
#7 años o más = 30 días   
if employee_dep == "CLAVE 3" and employee_working_time == 1:
    print("=========== [Datos recopilados] ===========")
    print("")
    print("Trabajador:", employee_name)
    print("Departamento: Gerencia")
    print("Años de servicio:", employee_working_time)
    print("")
    print("Días de vacaciones: 10 días")
    print("")
    print("=========== [Datos recopilados] ===========")
elif employee_dep == "CLAVE 3" and employee_working_time <= 6:
    print("=========== [Datos recopilados] ===========")
    print("")
    print("Trabajador:", employee_name)
    print("Departamento: Gerencia")
    print("Años de servicio:", employee_working_time)
    print("")
    print("Días de vacaciones: 20 días")
    print("")
    print("=========== [Datos recopilados] ===========")
elif employee_dep == "CLAVE 3" and employee_working_time <= 7:
    print("=========== [Datos recopilados] ===========")
    print("")
    print("Trabajador:", employee_name)
    print("Departamento: Gerencia")
    print("Años de servicio:", employee_working_time)
    print("")
    print("Días de vacaciones: 30 días")
    print("")
    print("=========== [Datos recopilados] ===========")
else: 
    print("Has ingresado datos errados")