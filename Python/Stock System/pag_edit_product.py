#===========================================#
#Imports
from functions_admin import TakeFiles, CheckRightInfoToAddProducts, ayuda_msg
from tkinter import messagebox
from tkinter import *
import sqlite3


#===========================================#
#Main function
def Start_pag_edit_product(ref = ""):
    #===========================================#
    #Root windown
    root = Tk()

    #===========================================#
    #Assignments
    from config import config_bgcolor,config_font_type,config_img_add,config_img_add_products,config_img_back,config_img_edit,config_img_edit_products,config_img_exit,config_img_find,config_img_help,config_img_log_in,config_img_log_out,config_img_logo,config_img_password,config_img_reset,config_img_sell_products,config_img_terminal,config_img_user,config_img_view_products,config_main_menu,config_stock_system,config_title,config_img_create_bill,config_measurement,config_staff

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
    def CreatingDB():
        try:
            dbfile_path = TakeFiles("productos.db")
            DBConnector = sqlite3.connect(dbfile_path)
            DBCursor = DBConnector.cursor()
            DBCursor.execute("CREATE TABLE PRODUCTOS (nombre text, precio float, medida text,cantidad integer ,referencia text PRIMARY KEY, agregadopor text)")
            DBConnector.close()
        except sqlite3.Error as the_error:
            print("Hay un imprevisto en la zona de DB...")
            print("Tipo de error:",the_error)
    
    def SettingCurrentData(ref):
        ref = str(ref)
        from functions_admin import FindProducts
        if (FindProducts(ref,"ref") != []):
            dbfile_path = TakeFiles("productos.db")
            DBConnector = sqlite3.connect(dbfile_path)
            DBCursor = DBConnector.cursor()
            DBCursor.execute(f"select * from productos where referencia == '{ref}'")
            producto_data = DBCursor.fetchall()
            producto_data = producto_data[0]
            DBConnector.close()

            ProductName.insert(END, producto_data[0])
            ProductPrice.insert(END, round(producto_data[1]))
            ProductMeasurement.insert(END, producto_data[2])
            ProductAmount.insert(END, producto_data[3])
            ProductRef.insert(END, producto_data[4])
            ProductAddedBy.insert(END, producto_data[5])

            ProductRef.config(state="disable")


        else:
            messagebox.showwarning(title="Referencia",message="El producto no existe...")
            ProductName.config(state="disable")
            ProductPrice.config(state="disable")
            ProductMeasurement.config(state="disable")
            ProductAmount.config(state="disable")
            ProductRef.config(state="disable")
            ProductAddedBy.config(state="disable")

    def boton6(event = True):
        messagebox.showinfo(title="Ayuda", message=ayuda_msg)

    def boton7(event = True):
        root.destroy()
        root.quit()
        from pag_main import Start_pag_main
        print("Cambiando a » Menú principal")
        Start_pag_main()

    def boton8(event = True):
            nombre = ProductName.get()
            precio = ProductPrice.get()
            medida = ProductMeasurement.get()
            cantidad = ProductAmount.get()
            referencia = ProductRef.get()
            agregadopor = ProductAddedBy.get()
            if CheckRightInfoToAddProducts(nombre,precio,medida,cantidad,"False",agregadopor):
                CreatingDB()
                dbfile_path = TakeFiles("productos.db")
                DBConnector = sqlite3.connect(dbfile_path)
                DBCursor = DBConnector.cursor()
                DBCursor.execute(f"update productos set nombre = '{nombre}' where referencia == '{ref}'")
                DBCursor.execute(f"update productos set precio = '{precio}' where referencia == '{ref}'")
                DBCursor.execute(f"update productos set medida = '{medida}' where referencia == '{ref}'")
                DBCursor.execute(f"update productos set cantidad = '{cantidad}' where referencia == '{ref}'")
                DBCursor.execute(f"update productos set agregadopor = '{agregadopor}' where referencia == '{ref}'")
                DBConnector.commit()
                DBConnector.close()
                text7.config(text=f"Último producto editado:\n({referencia})", font=(config_font_type,15), fg="green")

    #===========================================#
    #Root config
    root.title(config_title)
    root.resizable(1,1)
    root.iconbitmap(config_img_terminal)

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
    ProductFrame = Frame()
    ProductFrame.config(width = w, height = h)
    ProductFrame.place(x = 0, y = 0, relwidth = 1, relheight = 1)
    ProductFrame.config(background = config_bgcolor)
    ProductFrame.pack()

    #===========================================#
    #Widgets config

    img_logo = Label(ProductFrame, image=config_img_logo, background=config_bgcolor)
    img_logo.grid(row=0, column=1, padx=0, pady=30)

    text1 = Label(ProductFrame, text="Nombre Producto »", font=(config_font_type,12), background=config_bgcolor)#Entry -> Product Name
    text1.grid(row=1, column=0, padx=0, pady=10, sticky="w")
    ProductName = Entry(ProductFrame, justify=CENTER, font=(config_font_type,10))
    ProductName.grid(row=1, column=1, padx=0, pady=10)

    text2 = Label(ProductFrame, text="Precio Producto »", font=(config_font_type,12), background=config_bgcolor)#Entry -> Product Price
    text2.grid(row=2, column=0, padx=0, pady=10, sticky="w")
    ProductPrice = Entry(ProductFrame, justify=CENTER, font=(config_font_type,10))
    ProductPrice.grid(row=2, column=1, padx=0, pady=10)

    text3 = Label(ProductFrame, text="Medida Producto »", font=(config_font_type,12), background=config_bgcolor)#Entry -> Measurement Product
    text3.grid(row=3, column=0, padx=0, pady=10, sticky="w")
    ProductMeasurement = Entry(ProductFrame, justify=CENTER, font=(config_font_type,10))
    ProductMeasurement.grid(row=3, column=1, padx=0, pady=10)

    text4 = Label(ProductFrame, text="Cantidad Producto »", font=(config_font_type,12), background=config_bgcolor)#Entry -> Amount product
    text4.grid(row=4, column=0, padx=0, pady=10, sticky="w")
    ProductAmount = Entry(ProductFrame, justify=CENTER, font=(config_font_type,10))
    ProductAmount.grid(row=4, column=1, padx=0, pady=10)

    text5 = Label(ProductFrame, text="Ref. Producto »", font=(config_font_type,12), background=config_bgcolor)#Entry -> Ref product
    text5.grid(row=5, column=0, padx=0, pady=10, sticky="w")
    ProductRef = Entry(ProductFrame, justify=CENTER, font=(config_font_type,10))
    ProductRef.grid(row=5, column=1, padx=0, pady=10)

    text6 = Label(ProductFrame, text="Añadido por »", font=(config_font_type,12), background=config_bgcolor)#Entry -> Added by
    text6.grid(row=6, column=0, padx=0, pady=10, sticky="w")
    ProductAddedBy = Entry(ProductFrame, justify=CENTER, font=(config_font_type,10))
    ProductAddedBy.grid(row=6,column=1, padx=0, pady=10)

    button_6 = Button(ProductFrame, text="Ayuda", image=config_img_help,background=config_bgcolor, borderwidth=0, command=boton6)#Button ayuda
    button_6.grid(row=4,column=2, padx=25, pady=10)

    button_7 = Button(ProductFrame, text="Atrás", image=config_img_back, background=config_bgcolor, borderwidth=0, command=boton7)#Button atrás
    button_7.grid(row=5,column=2, padx=25, pady=10)

    button_8 = Button(ProductFrame, text="Añadir", image=config_img_edit, background=config_bgcolor, borderwidth=0, command=boton8)#Button editar
    button_8.grid(row=6,column=2, padx=25, pady=10)

    text7 = Label(ProductFrame, text="", font=(config_bgcolor,0), background=config_bgcolor) #Text that shows last item added
    text7.grid(row=7,column=1,padx=0,pady=15)

    #===========================================#
    #Binds
    root.bind("<Escape>",boton7)
    root.bind("<Return>",boton8)

    #===========================================#
    #Mainloop 
    
    #Testing
    SettingCurrentData(ref)
    root.mainloop()