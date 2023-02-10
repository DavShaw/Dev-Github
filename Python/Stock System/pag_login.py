#===========================================#
#Imports
from tkinter import *
from tkinter import messagebox
from functions_admin import Encrypter, UserExist, LoginChecker, TakeFiles
import sys
import os

#===========================================#
#Main function
def Start_pag_login():
    #===========================================#
    #Root window
    root = Tk()    

    #===========================================#
    #Assignments
    from config import config_bgcolor,config_font_type,config_img_add,config_img_add_products,config_img_back,config_img_edit,config_img_edit_products,config_img_exit,config_img_find,config_img_help,config_img_log_in,config_img_log_out,config_img_logo,config_img_password,config_img_reset,config_img_sell_products,config_img_terminal,config_img_user,config_img_view_products,config_main_menu,config_stock_system,config_title,config_img_create_bill,config_measurement,config_staff,dev_config_zoom_type

    #===========================================#
    #Variables
    config_img_add = PhotoImage(file = config_img_add)
    config_img_add_products = PhotoImage(file = config_img_add_products)
    config_img_back = PhotoImage(file = config_img_back)
    config_img_edit = PhotoImage(file = config_img_edit)
    config_img_edit_products = PhotoImage(file = config_img_edit_products)
    config_img_exit = PhotoImage(file = config_img_exit)
    config_img_find = PhotoImage(file = config_img_find)
    config_img_help = PhotoImage(file = config_img_help)
    config_img_log_in = PhotoImage(file = config_img_log_in)
    config_img_log_out = PhotoImage(file = config_img_log_out)
    config_img_logo = PhotoImage(file = config_img_logo)
    config_img_password = PhotoImage(file = config_img_password)
    config_img_reset = PhotoImage(file = config_img_reset)
    config_img_sell_products = PhotoImage(file = config_img_sell_products)
    config_img_user = PhotoImage(file = config_img_user)
    config_img_view_products = PhotoImage(file = config_img_view_products)
    config_img_create_bill = PhotoImage(file = config_img_create_bill)

    #===========================================#
    #Functions
    def Login(event = True):
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

    #===========================================#
    #Root config
    root.title(config_title)
    root.resizable(1,1)
    root.iconphoto(False, config_img_logo)

    w = 600
    h = 600
    s_w = root.winfo_screenwidth()
    s_h = root.winfo_screenheight()
    x = (s_w/2) - (w/2) 
    y = ((s_h/2)+200) - (h-2)

    root.geometry("%dx%d+%d+%d" % (w, h, x, y))
    root.config(background = config_bgcolor)
    root.state(dev_config_zoom_type)

    #===========================================#
    #Frame config
    LoginFrame = Frame()
    LoginFrame.config(width = w, height = h)
    LoginFrame.config(background = config_bgcolor)
    LoginFrame.place(x = 0, y = 0, relwidth = 1, relheight = 1)
    LoginFrame.pack()

    #===========================================#
    #Widgets
    text_welcome = Label(LoginFrame, text = config_stock_system, background = config_bgcolor)
    text_welcome.grid(row = 0, column = 0, padx = 0, pady = 15)
    text_welcome.config(font = (config_font_type,18), bd = 12)

    img_logo = Label(LoginFrame, image = config_img_logo, background = config_bgcolor)
    img_logo.grid(row = 1, column = 0, padx = 0, pady = 0)

    img_usuario = Label(LoginFrame, image = config_img_user, background = config_bgcolor)
    img_usuario.grid(row = 2, column = 0, padx = 0, pady = 25)

    usuario = Entry(LoginFrame)
    usuario.grid(row = 3, column = 0, padx = 0, pady = 0)
    usuario.config(font = (config_font_type,14), justify = CENTER)

    img_clave = Label(LoginFrame, image = config_img_password, background = config_bgcolor)
    img_clave.grid(row = 4, column = 0, padx = 0, pady = 25)

    clave = (Entry(LoginFrame))
    clave.grid(row = 5, column = 0, padx = 0, pady = 0)
    clave.config(font = (config_font_type,14), justify = CENTER, show = "•")

    iniciar_sesion = Button(LoginFrame)
    iniciar_sesion.grid(row = 6, column = 0, padx = 0, pady = 35)
    iniciar_sesion.config(image=config_img_log_in, font = (config_font_type, 15), background = config_bgcolor, borderwidth=0)
    iniciar_sesion.config(command = Login)

    #===========================================#
    #Binds
    root.bind("<Return>",Login)
    
    #===========================================#
    #Mainloop
    root.mainloop()