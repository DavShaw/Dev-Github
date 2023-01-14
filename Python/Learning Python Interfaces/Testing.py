from tkinter import *
from tkinter import messagebox
import sys
import os
#======================================================================================================================#
#Functions zone
def TakeFiles(file = "nothing"):
    file = str(file)
    if (file != "nothing"):
        give = os.path.join(sys.path[0], f"{file}")
        return give
    else:
        return "> You must type a path to find the file! - Debes especificar una ruta de archivo para obtenerlo <"

def Login():
    if (usuario.get() != "") and (clave.get() != ""):
        if (usuario.get() == "DavSha") and (clave.get() == "king0246"):
            messagebox.showinfo(title="Inicio de sesión", message=f"¡Bienvenido {usuario.get()}!\n\nHas iniciado sesión con éxito")
        else:
            messagebox.showerror(title="Inicio de sesión", message="¡Acceso denegado!\n\nClave y/o contraseña no válidos")
            usuario.delete(0,END)
            clave.delete(0,END)
    else:
        messagebox.showinfo(title="inicio de sesión", message="¡Hey!, debes ingresar tus credenciales")
#======================================================================================================================#




#======================================================================================================================#
#Main window (Frames container)
root = Tk()
root.title("Multiadornos Maicao")
root.resizable(1,1)

icon = TakeFiles('img/terminal.ico')
root.iconbitmap(rf'{icon}')


#======================================#
#Setting app in the center of the screen
w = 350
h = 500

s_w = root.winfo_screenwidth()
s_h = root.winfo_screenheight()

x = (s_w/2) - (w/2) 
y = ((s_h/2)+200) - (h-2)

root.geometry("%dx%d+%d+%d" % (w, h, x, y))
#root.geometry("{}x{}{}+{}".format(s_w, s_h, int(x), int(y)))
#======================================#

#======================================================================================================================#



#======================================================================================================================#
#Config zone of MainFrame (Login page)


MainFrame = Frame()
MainFrame.config(width = w, height = h)
MainFrame.pack(fill="both", expand=True)

companylogo = PhotoImage(file = TakeFiles('img/logo_aux1.png'))
system_img1 = PhotoImage(file = TakeFiles('img/user_logo_aux1.png'))
system_img2 = PhotoImage(file = TakeFiles('img/password_logo_aux1.png'))
system_img3 = PhotoImage(file = TakeFiles('img/fondo_aux1.png'))


root_background = Label(MainFrame, background = "#C2F1B7")
root_background.place(x=0,y=0,relwidth=1,relheight=1)

message1 = "S I S T E M A  D E   V E N T A S"
companyname = "Multiadornos Maicao"

#======================================#
#Creating rows and columns to set widgets


text_welcome = Label(MainFrame, text = message1, background = "#C2F1B7")
text_welcome.grid(row = 0, column = 0, padx = 0, pady = 0, sticky = "n")
text_welcome.config(fg = "#94998F", font = ("Times New Roman",18))

img_logo = Label(MainFrame, image = companylogo)
img_logo.grid(row = 1, column = 0, padx = 0, pady = 0)
img_logo.config()

usuario = Entry(MainFrame)
usuario.grid(row = 2, column = 0, padx = 0, pady = 0)
usuario.config(fg = "#262626", font = ("Times New Roman",14), justify = CENTER)

clave = Entry(MainFrame)
clave.grid(row = 3, column = 0, padx = 0, pady = 0)
clave.config(fg = "#262626", font = ("Times New Roman",14), justify = CENTER, show = "•")

iniciar_sesion = Button(MainFrame)
iniciar_sesion.grid(row = 4, column = 0)
iniciar_sesion.config(text = "Iniciar sesión", fg = "#000", font = ("Times New Roman", 15))
iniciar_sesion.config(command = Login)


#======================================#


#======================================================================================================================#








root.mainloop()