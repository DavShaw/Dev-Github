import turtle
import random

computadora = 0
t = turtle.Turtle()
t.up()
t.goto(-100,100)
t.down()
t.speed(0)

# campo de carrera
for i in range(15): 
    t.write(i)
    t.right(90)
    t.forward(200)
    t.left(180)  
    t.forward(200)
    t.right(90)
    t.forward(20)
    
    
t1 = turtle.Turtle()
t1.shape("circle")
t1.color("red")
t1.up()
t1.goto(-120,70)
t1.down()

t2 = turtle.Turtle()
t2.shape("circle")
t2.color("green")
t2.up() 
t2.goto(-120,30)
t2.down()

t3 = turtle.Turtle()
t3.shape("circle")
t3.color("black")
t3.up()
t3.goto(-120,-10)
t3.down()

x =  input("¿Quien ganara? cr,cg,cd :")


cr = 0
cg = 0
cb = 0

# Acá hacemos los aficionados ó espectadores

# Hacerlo con for
for i in range(0,6):
    aficionado1 = turtle.Turtle()
    aficionado1.color("blue")
    aficionado1.shape("turtle")
    aficionado1.left(90)
    aficionado1.up()
    mover_aficionado = i*20
    aficionado1.goto(-100 + mover_aficionado,-125)


while True:
    cr = random.randint(1,10)
    cg = random.randint(1,10)
    cb = random.randint(1,10)
    computadora = random.radint(1,3)
    if computadora == 1:
        computadora = "cr"
    elif computadora == 2:
        computadora = "cg"
    elif computadora == 3:
        computadora = "cb"
    
    t1.forward(rm)
    cr = cr + rm
        
    t2.forward(gr)
    cg = cg + gr
    
    t3.forward(bm)
    cb = cb + bm
    
    if cr > 300: 
        t.write("ganador fue el rojo")
        break
    
    elif cg > 300:
        t.write("gandor fue el verde")
        break
    elif cb > 300:
        t.write("ganador fue el negro")
        break