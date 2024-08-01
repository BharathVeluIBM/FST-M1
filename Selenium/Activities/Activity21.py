from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.support import expected_conditions as EC

service = Service(ChromeDriverManager().install())
driver = webdriver.Chrome(service=service)
wait = WebDriverWait(driver, 10)

driver.get("https://v1.training-support.net/selenium/tab-opener")
print("Home page title:", driver.title)

wait.until(EC.number_of_windows_to_be(2))
print("Currently open windows:", driver.window_handles)
for handle in driver.window_handles:
    driver.switch_to.window(handle)

wait.until(EC.element_to_be_clickable((By.ID, "actionButton")))
print("Current tab:", driver.current_window_handle)
print("Page title:", driver.title)
page_heading = driver.find_element(By.CLASS_NAME, "content").text
print("Page Heading:", page_heading)
driver.find_element(By.ID, "actionButton").click()

wait.until(EC.number_of_windows_to_be(3))
for handle in driver.window_handles:
    driver.switch_to.window(handle)

wait.until(EC.visibility_of_element_located((By.CLASS_NAME, "content")))
print("Current tab:", driver.current_window_handle)
print("Page title:", driver.title)
page_heading = driver.find_element(By.CLASS_NAME, "content").text
print("Page Heading:", page_heading)

driver.quit()
