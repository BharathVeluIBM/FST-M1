from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from webdriver_manager.chrome import ChromeDriverManager

service = Service(ChromeDriverManager().install())
driver = webdriver.Chrome(service=service)
wait = WebDriverWait(driver, 10)

driver.get("https://v1.training-support.net/selenium/dynamic-attributes")
print("Home page title: " + driver.title)

username = driver.find_element(By.XPATH, "//input[starts-with(@class, 'username-')]")
password = driver.find_element(By.XPATH, "//input[starts-with(@class, 'password-')]")

username.send_keys("admin")
password.send_keys("password")
driver.find_element(By.XPATH, "//button[@type='submit']").click()

message = driver.find_element(By.ID, "action-confirmation").text
print("Login message: " + message)

driver.quit()
