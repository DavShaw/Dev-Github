import pyautogui
import dataclasses
from pynput import mouse

@dataclasses.dataclass(init=True, repr=True, eq=True)
class Clicks:
    
    point1: tuple = dataclasses.field(init=False, default=None)
    point2: tuple = dataclasses.field(init=False, default=None)
    width: int = dataclasses.field(init=False, default=0)
    height: int = dataclasses.field(init=False, default=0)
    
    def _on_click(self, x, y, button, pressed):
        if button == mouse.Button.left:
            self.point1 = (x, y)
        elif button == mouse.Button.right:
            self.point2 = (x, y)
        if self.point1 and self.point2:
            return False
        
    def get_sizes(self):
        aux_a = (self.point2[0], self.point1[1])
        aux_b = (self.point1[0], self.point2[1])
        
        """
        width will be the distance between point1 and aux_a
        height will be the distance between point1 and aux_b
        """
        
        self.width = ((self.point1[0] - aux_a[0])**2 + (self.point1[1] - aux_a[1])**2)**(1/2)
        self.height = ((self.point1[0] - aux_b[0])**2 + (self.point1[1] - aux_b[1])**2)**(1/2)
    
    def click_listener(self):
        with mouse.Listener(on_click=lambda x, y, button, pressed: self._on_click(x, y, button, pressed)) as listener:
            listener.join()
            
    def get_data(self):
        return {'P1': self.point1, 'P2': self.point2, 'W': self.width, 'H': self.height}