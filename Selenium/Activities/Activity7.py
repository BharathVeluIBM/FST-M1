from selenium import webdriver
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
import time

# Setup the Chrome driver
print("Setting up the Chrome driver...")
service = ChromeService(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service)
actions = ActionChains(driver)

# Open the target website
print("Opening the target website...")
driver.get("https://v1.training-support.net/selenium/drag-drop")
print("Home page title:", driver.title)

# Locate the elements
football = driver.find_element(By.ID, "draggable")
dropzone1 = driver.find_element(By.XPATH, "//div[contains(text(),'Dropzone 1')]")
dropzone2 = driver.find_element(By.XPATH, "//div[contains(text(),'Dropzone 2')]")


# Perform drag and drop action
print("Dragging and dropping the ball to dropzone 1...")
actions.click_and_hold(football).move_to_element(dropzone1).pause(2).release().perform()

# Verify dropzone 1
dropzone1_verify = dropzone1.find_element(By.TAG_NAME, "p").text
if dropzone1_verify == "Dropped!":
    print("Ball was dropped in dropzone 1")

# Perform drag and drop action to dropzone 2
print("Dragging and dropping the ball to dropzone 2...")
actions.drag_and_drop(football, dropzone2).perform()

# Verify dropzone 2
dropzone2_verify = dropzone2.find_element(By.TAG_NAME, "p").text
if dropzone2_verify == "Dropped!":
    print("Ball was dropped in dropzone 2")

# Close the browser
print("Closing the browser...")
driver.close()
