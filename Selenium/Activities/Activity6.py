from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys
from webdriver_manager.chrome import ChromeDriverManager
import pyperclip
import time

# Setup the Chrome driver
print("Setting up the Chrome driver...")
service = ChromeService(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service)
actions = ActionChains(driver)

# Open the target website
print("Opening the target website...")
driver.get("https://v1.training-support.net/selenium/input-events")
print("Home page title:", driver.title)

# Perform actions to select all text and copy it
print("Performing actions to copy all text on the page...")
actions.send_keys("S").perform()  
time.sleep(1)  
actions.key_down(Keys.CONTROL).send_keys("a").send_keys("c").key_up(Keys.CONTROL).perform()  # Select all and copy
time.sleep(1)  

# Retrieve text from the clipboard
copied_text = pyperclip.paste()
print("Copied text:", copied_text)

# Close the browser
print("Closing the browser...")
driver.close()
print("Script completed successfully.")
