#===========================================#
#Imports
from functions_admin import TakeFiles, CheckRightInfoToAddProducts, CheckRightInfoToSellProducts, FindProducts
from tkinter import messagebox
from tkinter import *
import sqlite3


#===========================================#
#Main function
def Start_pag_sell_product():
    from os import path, remove
    if path.exists(TakeFiles('temp_bill.txt')):
        remove(TakeFiles('temp_bill.txt'))
    #===========================================#
    #Root windown
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

    def SellingItems():
        cliente = ClientEntry.get()
        vendedor = SellerEntry.get()
        referencia = ProductRefEntry.get()
        cantidad = AmountProductEntry.get()
        if CheckRightInfoToSellProducts(cliente,vendedor,referencia,cantidad):
            ClientEntry.config(state="disable")
            SellerEntry.config(state="disable")
            ProductInfo = FindProducts(referencia,"ref")
            ProductInfo = ProductInfo[0]
            ProductName = ProductInfo[0]
            ProductCurrentAmount = ProductInfo[3]
            NotifyerText.config(text=f"{ProductName} (Ref: {referencia})\nx{cantidad}")

            #Temp-Facture
            cantidad = int(cantidad)
            send_data = {'producto':ProductName,'precio':ProductInfo[1],'referencia':ProductInfo[4], 'cantidad':cantidad}
            send_data = str(send_data)
            file_path = TakeFiles("temp_bill.txt")
            file = open(file_path,"a")
            file.write(send_data)
            file.write("\n")
            file.close()

            #Updating amount of product in db
            NewAmount = ProductCurrentAmount - cantidad
            CreatingDB()
            dbfile_path = TakeFiles("productos.db")
            DBConnector = sqlite3.connect(dbfile_path)
            DBCursor = DBConnector.cursor()
            DBCursor.execute(f"update productos set cantidad = {NewAmount} where referencia == '{referencia}'")
            DBConnector.commit()
            DBConnector.close()
            
    def BillCreator():
        from os import path, remove
        if (path.exists(TakeFiles("temp_bill.txt"))):
            from functions_admin import DataTaker
            if not (DataTaker("temp_bill.txt")) == []:
                    SoldItems = DataTaker("temp_bill.txt")
                    TotalToPay = 0
                    BillFormatString = ""
                    HtmlDataPrinter = {}

                    AcomToProduct = ""
                    AcomToAmount = ""
                    AcomToPrice = ""
                    AcomToRef = ""
                    for i in range(0,len(SoldItems)):
                        TotalToPay += (SoldItems[i]['precio']) * (SoldItems[i]['cantidad'])


                    for j in range(0,len(SoldItems)):
                        #{'producto': 'iPhone14', 'precio': 50.0, 'referencia': 'Apple4', 'cantidad': 3}
                        BillFormatString += "========================\n"
                        BillFormatString += f"Producto: {SoldItems[j]['producto']}\n"
                        BillFormatString += f"Cantidad: {SoldItems[j]['cantidad']}\n"
                        BillFormatString += f"Precio: {SoldItems[j]['precio']}\n"
                        BillFormatString += f"referencia: {SoldItems[j]['referencia']}\n"
                        BillFormatString += "========================\n\n\n"


                        AcomToProduct += f"{SoldItems[j]['producto']}<br>"
                        AcomToAmount += f"{SoldItems[j]['cantidad']}<br>"
                        AcomToPrice += f"{SoldItems[j]['precio']}<br>"
                        AcomToRef += f"{SoldItems[j]['referencia']}<br>"
                    
                    HtmlDataPrinter['ClientName'] = ClientEntry.get()
                    HtmlDataPrinter['SellerName'] = SellerEntry.get()
                    HtmlDataPrinter['AllProductName'] = AcomToProduct
                    HtmlDataPrinter['AllAmountProduct'] = AcomToAmount
                    HtmlDataPrinter['AllProductPrice'] = AcomToPrice
                    HtmlDataPrinter['AllProductRef'] = AcomToRef
                    HtmlDataPrinter['TotalToPay'] = TotalToPay


                    #print(HtmlDataPrinter)
                    #Creating last bill!!!!
                    from pdf_generator import Start_bill_creator
                    Start_bill_creator(HtmlDataPrinter)




        else:
            messagebox.showwarning(title="Alerta",message="Parece que no existe ningún producto añadido a la hoja contable")

    def GoToBack(event = True):
        root.destroy()
        root.quit()
        from pag_main import Start_pag_main
        from os import path,remove
        print("Cambiando a » Menú principal")
        if path.exists(TakeFiles("temp_bill.txt")):
            remove(TakeFiles("temp_bill.txt"))
        Start_pag_main()

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
    SellProductsFrame = Frame()
    SellProductsFrame.config(width = w, height = h)
    SellProductsFrame.place(x = 0, y = 0, relwidth = 1, relheight = 1)
    SellProductsFrame.config(background = config_bgcolor)
    SellProductsFrame.pack()

    #===========================================#
    #Widgets config
    img_logo = Label(SellProductsFrame, image=config_img_logo, background=config_bgcolor)
    img_logo.grid(row=0, column=1, padx=0, pady=60)

    ClientText = Label(SellProductsFrame, text="Cliente »", font=(config_font_type,14), background=config_bgcolor)
    ClientText.grid(row=1,column=0,padx=10,pady=15,sticky="w")

    ClientEntry = Entry(SellProductsFrame,justify=CENTER,font=(config_font_type,10))
    ClientEntry.grid(row=1,column=1,padx=10,pady=15,sticky="w")

    SellerText = Label(SellProductsFrame, text="Vendedor »", font=(config_font_type,14), background=config_bgcolor)
    SellerText.grid(row=2,column=0,padx=10,pady=15,sticky="w")

    SellerEntry = Entry(SellProductsFrame,justify=CENTER,font=(config_font_type,10))
    SellerEntry.grid(row=2,column=1,padx=10,pady=15,sticky="w")

    ProductRefText = Label(SellProductsFrame, text="Ref. Producto »", font=(config_font_type,14), background=config_bgcolor)
    ProductRefText.grid(row=3,column=0,padx=10,pady=15,sticky="w")

    ProductRefEntry = Entry(SellProductsFrame,justify=CENTER,font=(config_font_type,10))
    ProductRefEntry.grid(row=3,column=1,padx=10,pady=15,sticky="w")

    AmountProductText = Label(SellProductsFrame, text="Cantidad a vender »", font=(config_font_type,14), background=config_bgcolor)
    AmountProductText.grid(row=4,column=0,padx=10,pady=15,sticky="w")

    AmountProductEntry = Entry(SellProductsFrame,justify=CENTER,font=(config_font_type,10))
    AmountProductEntry.grid(row=4,column=1,padx=10,pady=15,sticky="w")

    AddItemButton = Button(SellProductsFrame, image=config_img_add, background=config_bgcolor, borderwidth=0, command=SellingItems)
    AddItemButton.grid(row=2,column=2,padx=10,pady=15)

    CreateBillButton = Button(SellProductsFrame,image=config_img_create_bill, background=config_bgcolor, borderwidth=0, command=BillCreator)
    CreateBillButton.grid(row=3,column=2,padx=10,pady=15)

    BackButton = Button(SellProductsFrame, image=config_img_back, borderwidth=0, background=config_bgcolor,command=GoToBack)
    BackButton.grid(row=4,column=2,padx=10,pady=15)

    NotifyerText = Label(SellProductsFrame, fg = "green", font=(config_font_type,15), background=config_bgcolor)
    NotifyerText.grid(row=5,column=1,padx=0,pady=30)
    #===========================================#
    #Binds
    root.bind("<Escape>",GoToBack)

    #===========================================#
    #Mainloop 
    root.mainloop()