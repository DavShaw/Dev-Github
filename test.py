from tkinter import *
from tkinter import messagebox
import sqlite3

'''
# Clase de RadioButton

root = Tk()


def rb_function():
    print("Has elegido:", selected_rb.get())


selected_rb = StringVar()
rb1 = Radiobutton(root, text= "Java", variable=selected_rb, value="Java", command=rb_function).pack()
rb2 = Radiobutton(root, text= "Python", variable=selected_rb, value="Python", command=rb_function).pack()
rb3 = Radiobutton(root, text= "JavaScript", variable=selected_rb, value="Ruby",command=rb_function).pack()

root.mainloop()
'''









'''
#Clase de menues

def configracion_colores_rojo():
    root.config(background="red")
def configracion_colores_azul():
    root.config(background="blue")
def configracion_colores_blanco():
    root.config(background="white")
def configracion_sistema_cerrar():
    root.destroy()
    root.quit()
def info_quienes_somos():
    messagebox.showinfo(title="Info", message="Somos DavidAsotak")



root = Tk()
MainMenu = Menu(root)
root.config(menu=MainMenu)

configuracion = Menu(MainMenu, tearoff=0)
configuracion.add_command(label="Rojo", command=configracion_colores_rojo)
configuracion.add_command(label="Azul", command=configracion_colores_azul)
configuracion.add_command(label="Blanco", command=configracion_colores_blanco)
configuracion.add_separator()
configuracion.add_cascade(label="Cerrar", command=configracion_sistema_cerrar)


info = Menu(MainMenu, tearoff=0)
info.add_command(label="Quienes somos", command=info_quienes_somos)


MainMenu.add_cascade(label="Ajustes", menu = configuracion)
MainMenu.add_cascade(label="Info", menu = info)

root.mainloop()
'''


#Clase de DB

DBConnector = sqlite3.connect("productos")
DBCursor = DBConnector.cursor()

DBCursor.execute("create table productos (nombre VARCHAR(50), precio INTEGER, medida VARCHAR(50), referencia VARCHAR(50) PRIMARY KEY)")


DBConnector.close()
