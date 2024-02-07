'''
import PIL
import dataclasses
import pyautogui

@dataclasses.dataclass(init=True, repr=True, eq=True)
class Screenshot:

    """
    A screenshot taken by the program.
    """
    
    image: PIL.Image = dataclasses.field(init=False)
    x: int = dataclasses.field(init=True, default=0)
    y: int = dataclasses.field(init=True, default=0)
    w: int = dataclasses.field(init=True, default=0)
    h: int = dataclasses.field(init=True, default=0)
    
    @dataclasses.staticmethod
    def equals(pic1, pic2):
        return pic1.image == pic2.image
    
    def _check_attributes(self):
        if float in [type(self.x), type(self.y), type(self.w), type(self.h)]:
            self.x = int(self.x)
            self.y = int(self.y)
            self.w = int(self.w)
            self.h = int(self.h)
    
    def _take_screenshot(self):
        """
        Take a screenshot.
        """
        self._check_attributes()
        region: tuple = (self.x, self.y, self.w, self.h)
        self.image = pyautogui.screenshot(region=region)
        return self.image
    
    def _convert_image(self):
        """
        Convert the image to grayscale.
        """
        if self.image:
            return self.image.convert('L')
        
    def get_image(self, converted = True):
        """
        Get the image.
        """
        self._take_screenshot()
        if converted:
            return self._convert_image()
        return self.image
    
    def show(self):
        if self.image:
            self.image.show()
'''










"""
import keyboard

def mantener_shift():
    keyboard.press('shift')

def mantener_w():
    keyboard.press('w')

# Asociar la función `mantener_shift` a la tecla "P"
keyboard.add_hotkey('-', mantener_shift)
keyboard.add_hotkey('+', mantener_w)

# Mantener el script en ejecución
keyboard.wait('esc')  # Presiona "Esc" para salir del programa"""



# Programa hecho por Alejandro, obviamente

def sumar(a,b ):
    return a+b

def restar(a,b):
    return a-b

def multiplicar(a,b):
    return a*b

def dividir(a,b):
    return a/b

def potenciar(a,b):
    return a**b

diccionario = {
    1: sumar,
    2: restar,
    3: multiplicar,
    4: dividir,
    5: potenciar
}

def menu():
    print("""
    =========== [ Cálculadora ] ===========  
    1. Sumar
    2. Restar
    3. Multiplicar
    4. Dividir
    5. Potenciar
    ===== [- - - - - - - - - - - - -] =====
    """)

def main(info: dict):
    a = float(input("Ingrese el primer número: "))
    b = float(input("Ingrese el segundo número: "))

    menu()

    opcion = int(input("Seleccionar opción: "))

    if opcion in info.keys():
        print(info[opcion](a,b))
    else:
        print("Opción inválida :D")

main(diccionario)
