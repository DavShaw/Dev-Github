from src.takeit.models.clicker import Clicks
from src.takeit.models.pics import Screenshot
import keyboard
import time
import threading

def screenshot():
    """
    Steps:
    1. Start clicks object
    2. Start click listener
    3. Get sizes
    4. Get data
    5. Start screenshot object
    6. Take screenshot
    """
    click = Clicks()
    click.click_listener()
    click.get_sizes()
    data = click.get_data()
    print(data)
    x = (data['P1'][0])
    y = data['P1'][1]
    w = data['W']
    h = data['H']
    ss = Screenshot(x,y,w,h)
    ss.get_image()
    ss.show()

def screenshot_thread():
    while True:
        if keyboard.is_pressed("9"):
            screenshot()
            time.sleep(0.1) 

if __name__ == "__main__":
    thread_screenshot = threading.Thread(target=screenshot_thread, daemon=True)
    thread_screenshot.start()
    keyboard.wait()