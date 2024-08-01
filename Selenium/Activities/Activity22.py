from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.support import expected_conditions as EC

service = Service(ChromeDriverManager().install())
driver = webdriver.Chrome(service=service)
wait = WebDriverWait(driver, 10)
actions = ActionChains(driver)

driver.get("https://v1.training-support.net/selenium/popups")
print("Home page title:", driver.title)

button = driver.find_element(By.CLASS_NAME, "orange")
actions.move_to_element(button).perform()

tooltip_message = button.get_attribute("data-tooltip")
print(tooltip_message)

button.click()
wait.until(EC.visibility_of_element_located((By.ID, "username")))

username = driver.find_element(By.ID, "username")
password = driver.find_element(By.ID, "password")

username.send_keys("admin")
password.send_keys("password")

driver.find_element(By.XPATH, "//button[text()='Log in']").click()

message = driver.find_element(By.ID, "action-confirmation").text
print("Login message:", message)

driver.quit()
