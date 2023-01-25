from tkinter import *
from tkinter import messagebox
from functions_admin import Encrypter, UserExist, LoginChecker, TakeFiles
import sys
import os
def Start_pag_login():    
    #======================================================================================================================#
    def Login():
        user = str(usuario.get())
        password = str(clave.get())
        if (user != "") and (password != ""):
            hidden_user = Encrypter(user)
            hidden_password = Encrypter(password)
            if UserExist(hidden_user) == True:
                if LoginChecker(hidden_user,hidden_password):
                    messagebox.showinfo(title="Acceso válido", message=f"Bienvenido al sistema, {user}\n\nTe redireccionaremos en unos segundos a la\npágina principal del sistema")
                    root.destroy()
                    root.quit()
                    from pag_main import Start_pag_main
                    Start_pag_main()
                else:
                    messagebox.showwarning(title="Acceso inválido", message="Credenciales inválidos")
                    #usuario.delete(0,END)
                    clave.delete(0,END)
            else:
                messagebox.showwarning(title="Acceso inválido", message="Este usuario no existe")
        else:
            messagebox.showwarning(title="Acceso inválido", message="No puedes dejar los campos vacíos")
    #======================================================================================================================#




    #======================================================================================================================#
    #Root config
    root = Tk()
    root.title("Multiadornos Maicao")
    root.resizable(0,0)
    root.iconbitmap(TakeFiles('img/terminal.ico'))
    w = 350
    h = 500
    s_w = root.winfo_screenwidth()
    s_h = root.winfo_screenheight()
    x = (s_w/2) - (w/2) 
    y = ((s_h/2)+200) - (h-2)
    root.geometry("%dx%d+%d+%d" % (w, h, x, y))
    #======================================================================================================================#



    #======================================================================================================================#
    #Config zone of LoginFrame (Login page)
    bgcolor = "#A6C7F7"


    LoginFrame = Frame()
    LoginFrame.config(width = w, height = h)
    #LoginFrame.pack(fill = "both", expand = True)
    LoginFrame.config(background = bgcolor)
    LoginFrame.place(x = 0, y = 0, relwidth = 1, relheight = 1)

    companylogo = PhotoImage(file = TakeFiles('img/logo_aux1.png'))
    system_img1 = PhotoImage(file = TakeFiles('img/user_logo_aux1.png'))
    system_img2 = PhotoImage(file = TakeFiles('img/password_logo_aux1.png'))
    message1 = "S I S T E M A  D E   V E N T A S"

    #======================================#
    #Creating frame widgets (So important part)

    #======================================#
    text_welcome = Label(LoginFrame, text = message1, background = bgcolor)
    text_welcome.grid(row = 0, column = 0, padx = 0, pady = 15)
    text_welcome.config(fg = "black", font = ("Times New Roman",18), bd = 12)
    #======================================#
    img_logo = Label(LoginFrame, image = companylogo, background = bgcolor)
    img_logo.grid(row = 1, column = 0, padx = 0, pady = 0)
    #======================================#
    img_usuario = Label(LoginFrame, image = system_img1, background = bgcolor)
    img_usuario.grid(row = 2, column = 0, padx = 0, pady = 25)
    #======================================#
    usuario = Entry(LoginFrame)
    usuario.grid(row = 3, column = 0, padx = 0, pady = 0)
    usuario.config(fg = "#262626", font = ("Times New Roman",14), justify = CENTER, background = "#E7E7E7")
    #======================================#
    img_clave = Label(LoginFrame, image = system_img2, background = bgcolor)
    img_clave.grid(row = 4, column = 0, padx = 0, pady = 25)
    #======================================#
    clave = (Entry(LoginFrame))
    clave.grid(row = 5, column = 0, padx = 0, pady = 0)
    clave.config(fg = "#262626", font = ("Times New Roman",14), justify = CENTER, show = "•", background = "#E7E7E7")
    #======================================#
    iniciar_sesion = Button(LoginFrame)
    iniciar_sesion.grid(row = 6, column = 0, padx = 0, pady = 35)
    iniciar_sesion.config(text = "Iniciar sesión", fg = "#000", font = ("Times New Roman", 15), background = "#9dc3fa")
    iniciar_sesion.config(command = Login)
    #======================================#
    #======================================================================================================================#
    root.mainloop()