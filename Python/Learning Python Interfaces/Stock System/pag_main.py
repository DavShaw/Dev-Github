from tkinter import *
from functions_admin import TakeFiles

def Start_pag_main():

    #=============================================#
    def boton1():
        root.destroy()
        root.quit()
        from pag_add_product import Start_pag_add_product
        print("Cambiando a » Añadir productos")
        Start_pag_add_product()
    def boton4():
            root.destroy()
            root.quit()
            from pag_login import Start_pag_login
            print("Cerrando sesión (Botón 4)")
            Start_pag_login()

    def boton5():
            root.destroy()
            root.quit()
            print("Sistema cerrado (Botón 5)")
    #=============================================#
        


    #======================================================================================================================#
    #Root config
    root = Tk()
    root.title("Multiadornos Maicao")
    root.resizable(0,0)
    root.iconbitmap(TakeFiles('img/terminal.ico'))
    w = 1000
    h = 600
    s_w = root.winfo_screenwidth()
    s_h = root.winfo_screenheight()
    x = (s_w/2) - (w/2) 
    y = ((s_h/2)+200) - (h-2)
    root.geometry("%dx%d+%d+%d" % (w, h, x, y))
    #======================================================================================================================#
    #MenuFrame config
    bgcolor = "#A6C7F7"


    MenuFrame = Frame()
    MenuFrame.config(width = w, height = h)
    MenuFrame.place(x = 0, y = 0, relwidth = 1, relheight = 1)
    MenuFrame.config(background = bgcolor)
    root.config(background = bgcolor)
    MenuFrame.pack()

    companylogo = PhotoImage(file = TakeFiles('img/logo_aux1.png'))
    system_img1 = PhotoImage(file = TakeFiles('img/user_logo_aux1.png'))
    system_img2 = PhotoImage(file = TakeFiles('img/password_logo_aux1.png'))
    img_button_1 = PhotoImage(file = TakeFiles('img/boton_1.png'))#120*42 (px)
    img_button_2 = PhotoImage(file = TakeFiles('img/boton_2.png'))#120*42 (px)
    img_button_3 = PhotoImage(file = TakeFiles('img/boton_3.png'))#120*42 (px)
    img_button_4 = PhotoImage(file = TakeFiles('img/boton_4.png'))#120*42 (px)
    img_button_5 = PhotoImage(file = TakeFiles('img/boton_5.png'))#120*42 (px)
    font_type = "Times New Roman"


    text_welcome = Label(MenuFrame, text = "M E N Ú   P R I N C I P A L", background = bgcolor)
    text_welcome.grid(row = 0, column = 1, padx = 0, pady = 20)
    text_welcome.config(fg = "black", font = (font_type,25), bd = 12)

    img_logo = Label(MenuFrame, image = companylogo, background = bgcolor)
    img_logo.grid(row = 1, column = 1, padx = 0, pady = 30)

    button_1 = Button(MenuFrame, image=img_button_1, borderwidth=0, background= bgcolor, command=boton1)
    button_1.grid(row=2, column=0, padx=0, pady=30)

    button_2 = Button(MenuFrame, image=img_button_2, borderwidth=0, background= bgcolor)
    button_2.grid(row=2, column=1, padx=0, pady=30)

    button_3 = Button(MenuFrame, image=img_button_3, borderwidth=0, background= bgcolor)
    button_3.grid(row=2, column=2, padx=0, pady=30)

    button_4 = Button(MenuFrame, image=img_button_4, borderwidth=0, background= bgcolor, command=boton4)
    button_4.grid(row=3, column=0, padx=0, pady=30)

    button_5 = Button(MenuFrame,image=img_button_5, borderwidth=0, background= bgcolor, command=boton5)
    button_5.grid(row=3, column=1, padx=0, pady=30)
    #======================================================================================================================#
    root.mainloop()