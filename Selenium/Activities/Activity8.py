from selenium import webdriver
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from webdriver_manager.chrome import ChromeDriverManager

# Setup the Chrome driver
print("Setting up the Chrome driver...")
service = ChromeService(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service)
wait = WebDriverWait(driver, 10)  # Timeout of 10 seconds

# Open the target website
print("Opening the target website...")
driver.get("https://v1.training-support.net/selenium/dynamic-controls")
print("Home page title:", driver.title)

# Locate the toggle button and click it
toggle_button = driver.find_element(By.ID, "toggleCheckbox")
toggle_button.click()

# Locate the dynamic checkbox
dynamic_box = driver.find_element(By.ID, "dynamicCheckbox")

# Wait until the dynamic checkbox is invisible
print("Waiting for the dynamic box to become invisible...")
wait.until(EC.invisibility_of_element_located((By.ID, "dynamicCheckbox")))
print("Dynamic box is visible:", dynamic_box.is_displayed())

# Click the toggle button again
toggle_button.click()

# Wait until the dynamic checkbox is visible again
print("Waiting for the dynamic box to become visible...")
wait.until(EC.visibility_of_element_located((By.ID, "dynamicCheckbox")))
print("Dynamic box is visible:", dynamic_box.is_displayed())

# Close the browser
print("Closing the browser...")
driver.close()
