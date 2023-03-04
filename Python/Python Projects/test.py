
select_key = input("Con qué tecla deseas activar / desactivar el script: ")

select_click = input("Cuál click deseas autoclickear (i = Izquierdo / d = Derecho): ")

select_interval = float(input("¿Con qué intervalo deseas clickear (Recomendado: 0.5)?: "))

select_exit_key = input("Con qué tecla deseas cerrar el script: ")

import time
from os import system
import threading
from pynput.mouse import Controller, Button
from  pynput.keyboard import Listener, KeyCode  

toggle_key = KeyCode(char = select_key)

clicking = False

exit = False

mouse = Controller()

def Clicker():
    while True:
        if clicking:
            if select_click == "d":
                mouse.click(Button.right, 1)
            else:
                mouse.click(Button.left, 1)
        time.sleep(select_interval)

        if exit:
            system('exit()')
            


def toggle_event(key):
    if key == toggle_key:
        global clicking
        clicking = not clicking

def exit_event(key):
    if key == select_exit_key:
        global exit
        exit = not exit




clicking_thread = threading.Thread(target = Clicker)
clicking_thread.start()

with Listener(on_press = toggle_event) as listener:
    listener.join()

with Listener(on_press = exit_event) as Listener2:
    Listener2.join()