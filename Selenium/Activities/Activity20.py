from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

service = Service(ChromeDriverManager().install())
driver = webdriver.Chrome(service=service)
wait = WebDriverWait(driver, 10)

driver.get("https://v1.training-support.net/selenium/javascript-alerts")
print("Home page title:", driver.title)

driver.find_element(By.ID, "prompt").click()

prompt_alert = driver.switch_to.alert

alert_text = prompt_alert.text
print("Text in alert:", alert_text)

prompt_alert.send_keys("Awesome!")
prompt_alert.accept()

driver.quit()
