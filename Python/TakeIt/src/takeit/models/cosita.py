import pyautogui
import time
import keyboard  # Importa la biblioteca keyboard

global active
active = False  # Variable global para controlar el estado del autoclick

def toggle_active():  # Función para cambiar el estado de active
    global active
    active = not active

def autoclick(intervalo):
    while True:
        if active:
            pyautogui.click()
        time.sleep(intervalo)

# Configura el intervalo entre cada clic en segundos
intervalo_de_clic = 0.1  # Ejemplo: un clic cada 0.5 segundos

# Define el atajo de teclado para cambiar el estado de active
keyboard.add_hotkey('+', toggle_active)

# Inicia el autoclick
autoclick(intervalo_de_clic)
