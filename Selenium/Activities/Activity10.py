from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from webdriver_manager.chrome import ChromeDriverManager

driver = webdriver.Chrome(ChromeDriverManager().install())
wait = WebDriverWait(driver, 10)

driver.get("https://v1.training-support.net/selenium/dynamic-controls")
print("Home page title: " + driver.title)

checkbox = driver.find_element(By.CLASS_NAME, "willDisappear")
checkbox_toggle = driver.find_element(By.ID, "toggleCheckbox")
checkbox_toggle.click()

wait.until(EC.invisibility_of_element_located((By.CLASS_NAME, "willDisappear")))
print("Checkbox is displayed: " + str(checkbox.is_displayed()))
checkbox_toggle.click()

wait.until(EC.visibility_of_element_located((By.ID, "dynamicCheckbox")))
print("Checkbox is displayed: " + str(checkbox.is_displayed()))
driver.find_element(By.XPATH, "//input[@class='willDisappear']").click()

driver.quit()

