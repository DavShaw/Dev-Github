from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time

driver = webdriver.Edge()

url = 'https://www.rottentomatoes.com/browse/movies_at_home/sort:popular?page=5'
driver.get(url)

clicks = 13
button_data_qa = 'dlp-load-more-button'

time.sleep(5)

for i in range(clicks):
    button = WebDriverWait(driver, 10).until(
        EC.element_to_be_clickable((By.CSS_SELECTOR, f'[data-qa="{button_data_qa}"]'))
    )
    button.click()
    if i < 5:
        time.sleep(5)
    elif i < 10:
        time.sleep(10)
    elif i < 15:
        time.sleep(25)
    else:
        time.sleep(60) 

current_html = driver.page_source
print(current_html)

with open("html.txt", "w", encoding="utf-8") as file:
    file.write(current_html)

driver.quit()
