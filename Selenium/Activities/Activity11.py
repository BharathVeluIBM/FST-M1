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

checkbox = driver.find_element(By.NAME, "toggled")
checkbox.click()
print("Checkbox is selected: " + str(checkbox.is_selected()))

checkbox.click()
print("Checkbox is selected: " + str(checkbox.is_selected()))

driver.quit()
