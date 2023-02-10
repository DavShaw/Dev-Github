#===========================================#
#Imports
from tkinter import *
from functions_admin import TakeFiles, ProductShower, ShowProducts


#===========================================#
#Main function
def Start_pag_show_products():
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

    def ToReset(event = True):
        ProductsPrinter.config(state="normal")
        ProductsPrinter.delete(1.0, END)
        tp = ShowProducts()
        ProductsPrinter.insert(INSERT,tp)
        ProductsPrinter.config(state="disable")

    def GoToBack(event = True):
        root.destroy()
        root.quit()
        from pag_main import Start_pag_main
        print("Cambiando a » Página principal")
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

    #===========================================#
    #Frame config
    SPFrame = Frame()
    SPFrame.config(width = w, height = h, background = config_bgcolor)
    SPFrame.place(x = 0, y = 0, relwidth = 1, relheight = 1)
    root.state("zoomed")
    root.config(background=config_bgcolor)
    SPFrame.pack()
    
    #===========================================#
    #Widgets
    img_logo = Label(SPFrame, image = config_img_logo, background = config_bgcolor)
    img_logo.grid(row = 0, column = 1, padx = 0, pady = 30)


    text1 = Label(SPFrame,text="Búsqueda por nombre",background=config_bgcolor,font=(config_font_type,12))
    text1.grid(row=1,column=0,padx=0,pady=5)

    entry1 = Entry(SPFrame)
    entry1.grid(row=2,column=0,padx=0,pady=5)

    button1 = Button(SPFrame, image=config_img_find, command=ToName,background=config_bgcolor,borderwidth=0)
    button1.grid(row=3,column=0,padx=0,pady=5)


    text2 = Label(SPFrame,text="Búsqueda por referencia",background=config_bgcolor,font=(config_font_type,12))
    text2.grid(row=1,column=2,padx=0,pady=5)

    entry2 = Entry(SPFrame)
    entry2.grid(row=2,column=2,padx=0,pady=5)

    button2 = Button(SPFrame, image=config_img_find, command=ToRef,background=config_bgcolor,borderwidth=0)
    button2.grid(row=3,column=2,padx=0,pady=5)

    button3 = Button(SPFrame,image=config_img_reset , command=ToReset,background=config_bgcolor,borderwidth=0)
    button3.grid(row=1,column=1,padx=0,pady=5)

    button4 = Button(SPFrame, image=config_img_back, command=GoToBack,background=config_bgcolor,borderwidth=0)
    button4.grid(row=3,column=1,padx=0,pady=5)
    
    show_products = ShowProducts()
    ProductsPrinter = Text(SPFrame)
    ProductsPrinter.grid(row=4,column=1,padx=0,pady=30)
    ProductsPrinter.insert(INSERT,show_products)
    ProductsPrinter.config(state="disable", background="black", fg="white", width=25,height=22, borderwidth=10, font=(config_font_type,12))

    #===========================================#
    #Bind
    root.bind("<Escape>",GoToBack)
    root.bind("<BackSpace>",ToReset)
    root.bind("<Return>",ToReset)

    #===========================================#
    #Mainloop
    root.mainloop()