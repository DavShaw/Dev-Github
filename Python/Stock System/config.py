#===========================================#
#Please, ignore it and DO NOT edit it!!
def TakeFiles(file = "nothing"):
    import sys
    import os
    file = str(file)
    if (file != "nothing"):
        give = os.path.join(sys.path[0], f"{file}")
        return give
    else:
        return "> You must enter a file to find it <"
#===========================================#




#PhotoImage
#Every new variable with the Tkinter method 'PhotoImage' have to be added here by David and updated in all pag

config_img_add = TakeFiles('img/add.png') #Button to add products
config_img_add_products = TakeFiles('img/add_products.png') #Button to go to add products pag
config_img_back = TakeFiles('img/back.png') #Button to back
config_img_edit = TakeFiles('img/edit.png') #Button to edit
config_img_edit_products = TakeFiles('img/edit_products.png') #Button to go to edit products pag
config_img_exit = TakeFiles('img/exit.png') #Button to exit system
config_img_find = TakeFiles('img/find.png') #Button to find anything
config_img_help = TakeFiles('img/help.png') #Button to get help
config_img_log_in = TakeFiles('img/log_in.png') #Button to log in
config_img_log_out = TakeFiles('img/log_out.png') #Button to log out
config_img_logo = TakeFiles('img/alt_logo.png') #Img of our company
config_img_password = TakeFiles('img/password.png') #Img of password
config_img_reset = TakeFiles('img/reset.png') #Img of reset (Anything that you was looking for)
config_img_sell_products = TakeFiles('img/sell_products.png') #Button to go to sell products pag
config_img_user = TakeFiles('img/user.png') #Img of user
config_img_view_products = TakeFiles('img/view_products.png') #Button to go to view products pag
config_img_create_bill = TakeFiles('img/create_bill.png') #Button to go to create a bill

#JustFile
config_img_terminal = (TakeFiles('img/alt_terminal.ico')) #Img (ICO) to startup the sysyem

#Strings
config_title = "David's Coffee" #Just system's title
config_stock_system = "S I S T E M A  D E   V E N T A S" #That message will appear if u are in login pag
config_main_menu = "M E N Ú   P R I N C I P A L" #That message will appear if u are in main menu pag
config_bgcolor = "#A6C7F7" #Just Hexadec. to set system background
config_font_type = "Times New Roman" #Just the font family system uses
config_company_email = "contact.devda.com"
config_company_address = "Av. 70 #10 - 20"

dev_config_wkhtmltopdf_path = r"C:/Program Files/wkhtmltopdf/bin/wkhtmltopdf.exe"
dev_config_zoom_type = "zoomed" #zoomed - normal - fullscreen

#List
config_staff = ["David", "Nicolas", "StockSystem"] #List of the staff allowed to add products
config_measurement = ["mts","metro","und","unidad","pq","paquete","mill","millar","grs","gruesa","par"] #List of the type of measurement































































'''
                    Update it
config_img_add = PhotoImage(file = 'img/add.png')
config_img_add_products = PhotoImage(file = 'img/add_products.png')
config_img_back = PhotoImage(file = 'img/back.png')
config_img_edit = PhotoImage(file = 'img/edit.png')
config_img_edit_products = PhotoImage(file = 'img/edit_products.png')
config_img_exit = PhotoImage(file = 'img/exit.png')
config_img_find = PhotoImage(file = 'img/find.png')
config_img_help = PhotoImage(file = 'img/help.png')
config_img_log_in = PhotoImage(file = 'img/log_in.png')
config_img_log_out = PhotoImage(file = 'img/log_out.png')
config_img_logo = PhotoImage(file = 'img/logo.png')
config_img_password = PhotoImage(file = 'img/password.png')
config_img_reset = PhotoImage(file = 'img/reset.png')
config_img_sell_products = PhotoImage(file = 'img/sell_products.png')
config_img_user = PhotoImage(file = 'img/user.png')
config_img_view_products = PhotoImage(file = 'img/view_products.png')
'''

