from tkinter import *
from functions_admin import TakeFiles, ProductShower, ShowProducts

def Start_pag_show_products():
#======================================================================================================================#
    #Root config
    root = Tk()
    root.title("Multiadornos Maicao")
    root.resizable(0,0)
    root.iconbitmap(TakeFiles('img/terminal.ico'))
    w = 520
    h = 620
    s_w = root.winfo_screenwidth()
    s_h = root.winfo_screenheight()
    x = (s_w/2) - (w/2) 
    y = ((s_h/2)+200) - (h-2)
    root.geometry("%dx%d+%d+%d" % (w, h, x, y))
    #======================================================================================================================#

    def ToName():
        arg = entry1.get()
        tp = ProductShower(arg,"name")

        ProductsPrinter.config(state="normal")
        ProductsPrinter.delete(1.0, END)
        ProductsPrinter.insert(INSERT,tp)
        ProductsPrinter.config(state="disable")

    def ToRef():
        arg = entry2.get()
        tp = ProductShower(arg,"ref")
        ProductsPrinter.config(state="normal")
        ProductsPrinter.delete(1.0, END)
        ProductsPrinter.insert(INSERT,tp)
        ProductsPrinter.config(state="disable")

    def ToReset():
        ProductsPrinter.config(state="normal")
        ProductsPrinter.delete(1.0, END)
        tp = ShowProducts()
        ProductsPrinter.insert(INSERT,tp)
        ProductsPrinter.config(state="disable")

    def GoToBack():
        root.destroy()
        root.quit()
        from pag_main import Start_pag_main
        print("Cambiando a » Página principal")
        Start_pag_main()


    #======================================================================================================================#
    #Config zone of SPFrame (Login page)
    bgcolor = "#A6C7F7"
    font_type = "Times New Roman"

    SPFrame = Frame()
    SPFrame.config(width = w, height = h)
    SPFrame.pack(fill = "both", expand = True)
    SPFrame.config(background = bgcolor)
    SPFrame.place(x = 0, y = 0, relwidth = 1, relheight = 1)
    #root.state("zoomed")

    companylogo = PhotoImage(file = TakeFiles('img/logo_aux1.png'))
    img_button_7 = PhotoImage(file = TakeFiles('img/boton_8.png'))#65*26 (px)
    img_button_10 = PhotoImage(file = TakeFiles('img/boton_10.png'))#65*26 (px)
    img_button_11 = PhotoImage(file = TakeFiles('img/boton_11.png'))#65*26 (px)
    
    img_logo = Label(SPFrame, image = companylogo, background = bgcolor)
    img_logo.grid(row = 0, column = 1, padx = 0, pady = 30)


    text1 = Label(SPFrame,text="Búsqueda por nombre",background=bgcolor,font=(font_type,12))
    text1.grid(row=1,column=0,padx=0,pady=5)

    entry1 = Entry(SPFrame)
    entry1.grid(row=2,column=0,padx=0,pady=5)

    button1 = Button(SPFrame, image=img_button_10, command=ToName,background=bgcolor,borderwidth=0)
    button1.grid(row=3,column=0,padx=0,pady=5)


    text2 = Label(SPFrame,text="Búsqueda por referencia",background=bgcolor,font=(font_type,12))
    text2.grid(row=1,column=2,padx=0,pady=5)

    entry2 = Entry(SPFrame)
    entry2.grid(row=2,column=2,padx=0,pady=5)

    button2 = Button(SPFrame, image=img_button_10, command=ToRef,background=bgcolor,borderwidth=0)
    button2.grid(row=3,column=2,padx=0,pady=5)

    button3 = Button(SPFrame,image=img_button_11 , command=ToReset,background=bgcolor,borderwidth=0)
    button3.grid(row=1,column=1,padx=0,pady=5)

    button4 = Button(SPFrame, image=img_button_7, command=GoToBack,background=bgcolor,borderwidth=0)
    button4.grid(row=3,column=1,padx=0,pady=5)
    
    show_products = ShowProducts()
    ProductsPrinter = Text(SPFrame)
    ProductsPrinter.grid(row=4,column=1,padx=0,pady=30)
    ProductsPrinter.insert(INSERT,show_products)
    ProductsPrinter.config(state="disable", background="black", fg="white", width=25,height=15, borderwidth=10, font=(font_type,12))



    #======================================================================================================================#
    root.mainloop()