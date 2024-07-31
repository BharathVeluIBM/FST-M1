from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

# Set up the Chrome Driver with WebDriverManager
service = Service(ChromeDriverManager().install())
driver = webdriver.Chrome(service=service)

# Navigate to the URL
driver.get("https://v1.training-support.net/selenium/login-form")
print("Home page title:", driver.title)

# Find elements and perform actions
driver.find_element(By.ID, "username").send_keys("admin")
driver.find_element(By.ID, "password").send_keys("password")
driver.find_element(By.XPATH, "//button[contains(text(), 'Log in')]").click()

# Close the browser
driver.close()
