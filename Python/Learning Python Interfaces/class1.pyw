from tkinter import *
import time


#================================================================================#
#Functions zone

def TakeFiles(file = "nothing"):
    file = str(file)
    if (file != "nothing"):
        import sys
        import os
        give = os.path.join(sys.path[0], f"{file}")
        return give
    else:
        return "> You must type a path to find the file! - Debes especificar una ruta de archivo para obtenerlo <"


def TakeLogin():
    ruser = "david"
    rpass = "123"
    if (userinput.get() == ruser) and (passwordinput.get() == rpass):
        print("You've logged!")
    else:
        print("Nope, that's hard to hacked")


def Testing(a,b):
    print("The user is:",a)
    print("The password is:",b)
#================================================================================#












#Raice frame
root = Tk()
root.title("M.A.M. Stock System")
root.resizable(False,False)
root.iconbitmap(TakeFiles('img/terminal.ico'))
print(TkVersion)
#Raice frame



#================================================================================#
#Config zone of MainFrame (Login page)


MainFrame = Frame()
MainFrame.config(width = "450", height = "650")
MainFrame.pack()

#MainFrame - Widgets

companylogo = PhotoImage(file = TakeFiles('img/logo_aux1.png'))
system_img1 = PhotoImage(file = TakeFiles('img/user_logo_aux1.png'))
system_img2 = PhotoImage(file = TakeFiles('img/password_logo_aux1.png'))


text1 = "S I S T E M A  D E   V E N T A S"
companyname = "Multiadornos Maicao"

#Message
Label(MainFrame, text = text1, fg = "black", font = ("Times New Roman",18)).place(relx=0.5, rely=0.5,y=-250,anchor=CENTER)
#CompanyLogo
Label(MainFrame, image = companylogo).place(relx=0.5, rely=0.5,y=-160,anchor=CENTER)


#User login logo
Label(MainFrame, image = system_img1).place(relx=0.5, rely=0.5,y=-50,anchor=CENTER)
#User login row
userinput = Entry(MainFrame, font = ("Times New Roman",12), justify=CENTER).place(relx=0.5, rely=0.5,y=-10,anchor=CENTER)
#Password login logo
Label(MainFrame, image = system_img2).place(relx=0.5, rely=0.5,y=50,anchor=CENTER)
#Password login row
passwordinput = Entry(MainFrame, font = ("Times New Roman",12), justify=CENTER, show = "*").place(relx=0.5, rely=0.5,y=90,anchor=CENTER)

#Button login
Login = Button(MainFrame, command = TakeLogin, text = "Iniciar", font = ("Times New Roman", 12)).place(relx=0.5, rely=0.5,y=170,anchor=CENTER)


#MainFrame - Widgets





#================================================================================#








root.mainloop()