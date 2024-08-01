from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from webdriver_manager.chrome import ChromeDriverManager

service = Service(ChromeDriverManager().install())
driver = webdriver.Chrome(service=service)
wait = WebDriverWait(driver, 10)

driver.get("https://v1.training-support.net/selenium/dynamic-controls")
print("Home page title: " + driver.title)

textbox = driver.find_element(By.ID, "input-text")
print("Input field is enabled: " + str(textbox.is_enabled()))
driver.find_element(By.ID, "toggleInput").click()
print("Input field is enabled: " + str(textbox.is_enabled()))

driver.quit()
