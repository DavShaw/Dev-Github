import tkinter as tk


root = tk.Tk()


def SUMAR_FUNCTION():
    n1 = n.get()
    n2 = p.get()
    n1 = int(n1)
    n2 = int(n2)
    root.title(n1+n2)

n = tk.Entry(root)
n.grid(row=0,column=0)


p = tk.Entry(root)
p.grid(row=0,column=1)


b = tk.Button(text= "Sumar", command= SUMAR_FUNCTION)
b.grid(column=0, row=1)





root.mainloop()