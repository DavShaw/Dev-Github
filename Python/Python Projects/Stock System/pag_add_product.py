from tkinter import *
from tkinter import messagebox
import sqlite3
from functions_admin import TakeFiles, CheckPrimaryKey, CheckRightInfoToAddProducts, ayuda_msg



def Start_pag_add_product():

    #=================================
    #D A T A B A S E   Z O N E
    try:
        dbfile_path = TakeFiles("productos.db")
        DBConnector = sqlite3.connect(dbfile_path)
        DBCursor = DBConnector.cursor()
        #DBCursor.execute("CREATE TABLE PRODUCTOS (nombre text, precio float, medida text,cantidad integer ,referencia text PRIMARY KEY, agregadopor text)")
        DBConnector.close()
    except:
        print("Hay un imprevisto en la zona de DB...")
        import sys
        print("Posiblemente el error sea: Tabla existente - Nombre no válido - Error de sintaxis")
        print("Tipo de error:",sys.exc_info()[0])
    #=================================

    #=================================
    #F U N C T I O N S   Z O N E
    def boton6():
        messagebox.showinfo(title="Ayuda", message=ayuda_msg)

    def boton7():
        root.destroy()
        root.quit()
        from pag_main import Start_pag_main
        print("Cambiando a » Menú principal")
        Start_pag_main()

    def boton8():
            nombre = ProductName.get()
            precio = ProductPrice.get()
            medida = ProductMeasurement.get()
            cantidad = ProductAmount.get()
            referencia = ProductRef.get()
            agregadopor = ProductAddedBy.get()
            if CheckRightInfoToAddProducts(nombre,precio,medida,cantidad,referencia,agregadopor):
                dbfile_path = TakeFiles("productos.db")
                DBConnector = sqlite3.connect(dbfile_path)
                DBCursor = DBConnector.cursor()
                producttoadd = [(nombre,precio,medida,cantidad,referencia,agregadopor)]
                DBCursor.executemany("INSERT INTO productos VALUES (?,?,?,?,?,?)", producttoadd)
                DBConnector.commit()
                DBConnector.close()
                text7.config(text=f"Último producto agregado:\n({referencia})", font=(font_type,15), fg="green")
    #==================================

    #===========================================#
    #Root config
    root = Tk()
    root.title("Multiadornos Maicao")
    root.resizable(0,0)
    root.iconbitmap(TakeFiles('img/terminal.ico'))
    w = 550
    h = 500
    s_w = root.winfo_screenwidth()
    s_h = root.winfo_screenheight()
    x = (s_w/2) - (w/2) 
    y = ((s_h/2)+200) - (h-2)
    root.geometry("%dx%d+%d+%d" % (w, h, x, y))
    #===========================================#

    #===========================================#
    #Frame config

    bgcolor = "#A6C7F7"
    ProductFrame = Frame()
    ProductFrame = Frame()
    ProductFrame.config(width = w, height = h)
    ProductFrame.place(x = 0, y = 0, relwidth = 1, relheight = 1)
    ProductFrame.config(background = bgcolor)
    root.config(background = bgcolor)
    ProductFrame.pack()

    companylogo = PhotoImage(file = TakeFiles('img/logo_aux1.png'))
    img_button_6 = PhotoImage(file = TakeFiles('img/boton_7.png'))#65*26 (px)
    img_button_7 = PhotoImage(file = TakeFiles('img/boton_8.png'))#65*26 (px)
    img_button_8 = PhotoImage(file = TakeFiles('img/boton_9.png'))#65*26 (px)
    font_type = "Times New Roman"

    img_logo = Label(ProductFrame, image=companylogo, background=bgcolor)
    img_logo.grid(row=0, column=1, padx=0, pady=30)



    text1 = Label(ProductFrame, text="Nombre Producto »", font=(font_type,12), background=bgcolor)#Entry -> Product Name
    text1.grid(row=1, column=0, padx=0, pady=10, sticky="w")
    ProductName = Entry(ProductFrame, justify=CENTER, font=(font_type,10))
    ProductName.grid(row=1, column=1, padx=0, pady=10)

    text2 = Label(ProductFrame, text="Precio Producto »", font=(font_type,12), background=bgcolor)#Entry -> Product Price
    text2.grid(row=2, column=0, padx=0, pady=10, sticky="w")
    ProductPrice = Entry(ProductFrame, justify=CENTER, font=(font_type,10))
    ProductPrice.grid(row=2, column=1, padx=0, pady=10)

    text3 = Label(ProductFrame, text="Medida Producto »", font=(font_type,12), background=bgcolor)#Entry -> Measurement Product
    text3.grid(row=3, column=0, padx=0, pady=10, sticky="w")
    ProductMeasurement = Entry(ProductFrame, justify=CENTER, font=(font_type,10))
    ProductMeasurement.grid(row=3, column=1, padx=0, pady=10)

    text4 = Label(ProductFrame, text="Cantidad Producto »", font=(font_type,12), background=bgcolor)#Entry -> Amount product
    text4.grid(row=4, column=0, padx=0, pady=10, sticky="w")
    ProductAmount = Entry(ProductFrame, justify=CENTER, font=(font_type,10))
    ProductAmount.grid(row=4, column=1, padx=0, pady=10)

    text5 = Label(ProductFrame, text="Ref. Producto »", font=(font_type,12), background=bgcolor)#Entry -> Ref product
    text5.grid(row=5, column=0, padx=0, pady=10, sticky="w")
    ProductRef = Entry(ProductFrame, justify=CENTER, font=(font_type,10))
    ProductRef.grid(row=5, column=1, padx=0, pady=10)

    text6 = Label(ProductFrame, text="Añadido por »", font=(font_type,12), background=bgcolor)#Entry -> Added by
    text6.grid(row=6, column=0, padx=0, pady=10, sticky="w")
    ProductAddedBy = Entry(ProductFrame, justify=CENTER, font=(font_type,10))
    ProductAddedBy.grid(row=6,column=1, padx=0, pady=10)

    button_6 = Button(ProductFrame, text="Ayuda", image=img_button_6,background=bgcolor, borderwidth=0, command=boton6)#Button ayuda
    button_6.grid(row=4,column=2, padx=25, pady=10)

    button_7 = Button(ProductFrame, text="Atrás", image=img_button_7, background=bgcolor, borderwidth=0, command=boton7)#Button atrás
    button_7.grid(row=5,column=2, padx=25, pady=10)

    button_8 = Button(ProductFrame, text="Añadir", image=img_button_8, background=bgcolor, borderwidth=0, command=boton8)#Button añadir
    button_8.grid(row=6,column=2, padx=25, pady=10)

    text7 = Label(ProductFrame, text="", font=(font_type,0), background=bgcolor) #Text that shows last item added
    text7.grid(row=7,column=1,padx=0,pady=15)


    #ProductName.insert(END,"Agarradera")
    #ProductPrice.insert(END,50)
    #ProductMeasurement.insert(END,"mts")
    #ProductAmount.insert(END,2)
    #ProductRef.insert(END,"CTM-P")
    #ProductAddedBy.insert(END,"David")
    #===========================================#



    root.mainloop()