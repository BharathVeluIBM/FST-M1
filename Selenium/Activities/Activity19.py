from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
import time

service = Service(ChromeDriverManager().install())
driver = webdriver.Chrome(service=service)
wait = WebDriverWait(driver, 10)

driver.get("https://v1.training-support.net/selenium/javascript-alerts")
print("Home page title:", driver.title)

driver.find_element(By.ID, "confirm").click()

confirm_alert = driver.switch_to.alert

time.sleep(0.5)
alert_text = confirm_alert.text
print("Text in alert:", alert_text)

confirm_alert.accept()
driver.quit()
