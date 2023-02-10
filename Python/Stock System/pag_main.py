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
    def boton1():
        root.destroy()
        root.quit()
        from pag_add_product import Start_pag_add_product
        print("Cambiando a » Añadir productos")
        Start_pag_add_product()

    def boton2():
        from tkinter import messagebox
        from tkinter.simpledialog import askstring
        from functions_admin import FindProducts
        
        product_ref = askstring('Editar','Ref. a editar')
        if FindProducts(product_ref) != []:
            messagebox.showinfo(title="Válido",message=f"El producto ({product_ref}) ha sido encontrado.\n¡Vamos a editarlo!")

            root.destroy()
            root.quit()
            from pag_edit_product import Start_pag_edit_product
            print("Cambiando a » Editar productos")
            Start_pag_edit_product(product_ref)
        elif product_ref == None:
            pass
        elif (product_ref).strip() == "":
            messagebox.showwarning(title="Inválido", message="No puedes dejar el campo vacío")
        else:
            messagebox.showwarning(title="Inválido",message=f"El producto ({product_ref}) no ha sido encontrado.")
            

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

    def GoToSellProducts():
        root.destroy()
        root.quit()
        from pag_sell_products import Start_pag_sell_product
        print("Cambiando a » Vender productos")
        Start_pag_sell_product()
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
    root.state("zoomed")

    #===========================================#
    #Frame config
    MenuFrame = Frame()
    MenuFrame.config(width = w, height = h, background = config_bgcolor)
    MenuFrame.place(x = 0, y = 0, relwidth = 1, relheight = 1)
    MenuFrame.pack()

    
    #===========================================#
    #Widgets
    text_welcome = Label(MenuFrame, text = "M E N Ú   P R I N C I P A L", background = config_bgcolor)
    text_welcome.grid(row = 0, column = 1, padx = 0, pady = 20)
    text_welcome.config(fg = "black", font = (config_font_type,25), bd = 12)

    img_logo = Label(MenuFrame, image = config_img_logo, background = config_bgcolor)
    img_logo.grid(row = 1, column = 1, padx = 0, pady = 30)

    button_1 = Button(MenuFrame, image=config_img_add_products, borderwidth=0, background= config_bgcolor, command=boton1) #Agregar productos
    button_1.grid(row=2, column=0, padx=0, pady=30)

    button_2 = Button(MenuFrame, image=config_img_edit_products, borderwidth=0, background= config_bgcolor, command=boton2) #Editar productos
    button_2.grid(row=2, column=1, padx=0, pady=30)

    button_3 = Button(MenuFrame, image=config_img_view_products, borderwidth=0, background= config_bgcolor, command=boton3) #Ver productos
    button_3.grid(row=2, column=2, padx=0, pady=30)

    button_4 = Button(MenuFrame, image=config_img_sell_products, borderwidth=0, background= config_bgcolor, command=GoToSellProducts) #Vender productos
    button_4.grid(row=3, column=0, padx=0, pady=30)

    button_5 = Button(MenuFrame, image=config_img_log_out, borderwidth=0, background= config_bgcolor, command=boton4) #Cerrar sesión
    button_5.grid(row=3, column=1, padx=0, pady=30)

    button_6 = Button(MenuFrame, image=config_img_exit, borderwidth=0, background= config_bgcolor, command=boton5) #Cerrar sistema
    button_6.grid(row=3, column=2, padx=0, pady=30)

    #===========================================#
    #Binds
    root.bind("<Escape>",boton4)

    #===========================================#
    #Mainloop
    root.mainloop()