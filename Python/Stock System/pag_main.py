#===========================================#
#Imports
from tkinter import *
from functions_admin import TakeFiles


#===========================================#
#Main function
def Start_pag_main():
    #===========================================#
    #Root window
    root = Tk()

    #===========================================#
    #Assignments
    companylogo = PhotoImage(file = TakeFiles('img/logo.png'))
    img_button_1 = PhotoImage(file = TakeFiles('img/add_products.png'))#120*42 (px)
    img_button_2 = PhotoImage(file = TakeFiles('img/edit_products.png'))#120*42 (px)
    img_button_3 = PhotoImage(file = TakeFiles('img/view_products.png'))#120*42 (px)
    img_button_4 = PhotoImage(file = TakeFiles('img/sell_products.png'))#120*42 (px)
    img_button_5 = PhotoImage(file = TakeFiles('img/log_out.png'))#120*42 (px)
    img_button_6 = PhotoImage(file = TakeFiles('img/exit.png'))#120*42 (px)
    font_type = "Times New Roman"

    #===========================================#
    #Variables
    bgcolor = "#A6C7F7"

    #===========================================#
    #Functions
    def boton1():
        root.destroy()
        root.quit()
        from pag_add_product import Start_pag_add_product
        print("Cambiando a » Añadir productos")
        Start_pag_add_product()

    def boton3():
        root.destroy()
        root.quit()
        from pag_show_products import Start_pag_show_products
        print("Cambiando a » Visualizar productos")
        Start_pag_show_products()

    def boton4(event = True):
            root.destroy()
            root.quit()
            from pag_login import Start_pag_login
            print("Cerrando sesión (Botón 4)")
            Start_pag_login()

    def boton5():
            root.destroy()
            root.quit()
            print("Sistema cerrado (Botón 5)")

    #===========================================#
    #Root config
    root.title("Multiadornos Maicao")
    root.resizable(1,1)
    root.iconbitmap(TakeFiles('img/terminal.ico'))

    w = 600
    h = 600
    s_w = root.winfo_screenwidth()
    s_h = root.winfo_screenheight()
    x = (s_w/2) - (w/2) 
    y = ((s_h/2)+200) - (h-2)

    root.geometry("%dx%d+%d+%d" % (w, h, x, y))
    root.config(background = bgcolor)
    root.state("zoomed")

    #===========================================#
    #Frame config
    MenuFrame = Frame()
    MenuFrame.config(width = w, height = h, background = bgcolor)
    MenuFrame.place(x = 0, y = 0, relwidth = 1, relheight = 1)
    MenuFrame.pack()

    
    #===========================================#
    #Widgets
    text_welcome = Label(MenuFrame, text = "M E N Ú   P R I N C I P A L", background = bgcolor)
    text_welcome.grid(row = 0, column = 1, padx = 0, pady = 20)
    text_welcome.config(fg = "black", font = (font_type,25), bd = 12)

    img_logo = Label(MenuFrame, image = companylogo, background = bgcolor)
    img_logo.grid(row = 1, column = 1, padx = 0, pady = 30)

    button_1 = Button(MenuFrame, image=img_button_1, borderwidth=0, background= bgcolor, command=boton1) #Agregar productos
    button_1.grid(row=2, column=0, padx=0, pady=30)

    button_2 = Button(MenuFrame, image=img_button_2, borderwidth=0, background= bgcolor) #Editar productos
    button_2.grid(row=2, column=1, padx=0, pady=30)

    button_3 = Button(MenuFrame, image=img_button_3, borderwidth=0, background= bgcolor, command=boton3) #Ver productos
    button_3.grid(row=2, column=2, padx=0, pady=30)

    button_4 = Button(MenuFrame, image=img_button_4, borderwidth=0, background= bgcolor) #Vender productos
    button_4.grid(row=3, column=0, padx=0, pady=30)

    button_5 = Button(MenuFrame, image=img_button_5, borderwidth=0, background= bgcolor, command=boton4) #Cerrar sesión
    button_5.grid(row=3, column=1, padx=0, pady=30)

    button_6 = Button(MenuFrame, image=img_button_6, borderwidth=0, background= bgcolor, command=boton5) #Cerrar sistema
    button_6.grid(row=3, column=2, padx=0, pady=30)
    #===========================================#

    #===========================================#
    #Binds
    root.bind("<Escape>",boton4)

    #===========================================#
    #Mainloop
    root.mainloop()