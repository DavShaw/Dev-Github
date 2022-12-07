def PedirValores():
    a = int(input("Valor de a: ")) 
    b = int(input("Valor de b: ")) 
    c = int(input("Valor de c: ")) 
    return a,b,c

def Discriminante(a,b,c):
    resultado = b**2
    resultado += -(4*a*c)
    resultado = resultado**(1/2)
    return resultado

def FormulaGeneral(a,b,c):
    d = Discriminante(a,b,c)
    x1 = -(b)-d
    x1 /= 2*a
    x2 = -(b)+d
    x2 /= 2*a
    return x1,x2


a,b,c = PedirValores()
x1,x2 = FormulaGeneral(a,b,c)
print(f"x1 = {x1}\nx2 = {x2}")

