from tkinter import *
from functions_admin import TakeFiles, ShowProducts

def Start_pag_show_products():
#======================================================================================================================#
    #Root config
    root = Tk()
    root.title("Multiadornos Maicao")
    root.resizable(1,1)
    root.iconbitmap(TakeFiles('img/terminal.ico'))
    w = 350
    h = 600
    s_w = root.winfo_screenwidth()
    s_h = root.winfo_screenheight()
    x = (s_w/2) - (w/2) 
    y = ((s_h/2)+200) - (h-2)
    root.geometry("%dx%d+%d+%d" % (w, h, x, y))
    #======================================================================================================================#



    #======================================================================================================================#
    #Config zone of ShowProductsFrame (Login page)
    bgcolor = "#A6C7F7"

    ShowProductsFrame = Frame()
    ShowProductsFrame.config(width = w, height = h)
    ShowProductsFrame.pack(fill = "both", expand = True)
    ShowProductsFrame.config(background = bgcolor)
    ShowProductsFrame.place(x = 0, y = 0, relwidth = 1, relheight = 1)

    companylogo = PhotoImage(file = TakeFiles('img/logo_aux1.png'))
    
    img_logo = Label(ShowProductsFrame, image = companylogo, background = bgcolor)
    img_logo.grid(row = 0, column = 0, padx = 0, pady = 30)
    
    show_products = ShowProducts()
    ProductsPrinter = Label(ShowProductsFrame,text=show_products)
    ProductsPrinter.grid(row=1,column=0,padx=0,pady=30)
    #======================================================================================================================#
    root.mainloop()


Start_pag_show_products()