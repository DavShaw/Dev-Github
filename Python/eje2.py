

def setoptouser():
    name = str(input("enter name: "))
    print("/deop *")
    print("/op " + name)
    print("*Magic command that I dunno, and it's disappers all in console and logs*")
    
whattodo = str(input("what do you want to do: "))
whattodo = whattodo.upper()

if whattodo == "GIVE ME OP":
    setoptouser()
    
elif whattodo != "GIVE ME OP":
    print("Nah, ure noooobzzzz")