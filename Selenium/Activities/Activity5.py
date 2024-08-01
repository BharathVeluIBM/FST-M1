from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.common.action_chains import ActionChains
from webdriver_manager.chrome import ChromeDriverManager
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

# Left Click
print("Performing left click...")
actions.click().perform()
time.sleep(5)  # Pause for 5 seconds
front_text = driver.find_element(By.CLASS_NAME, "active").text
print("Left click result:", front_text)

# Double Click
print("Performing double click...")
actions.double_click().perform()
time.sleep(5)  # Pause for 5 seconds
front_text = driver.find_element(By.CLASS_NAME, "active").text
print("Double click result:", front_text)

# Right Click (Context Click)
print("Performing right click...")
actions.context_click().perform()
time.sleep(5)  # Pause for 5 seconds
front_text = driver.find_element(By.CLASS_NAME, "active").text
print("Right click result:", front_text)

# Close the browser
print("Performed all the operations. Closing the browser...")
driver.close()
print("Script completed successfully.")
