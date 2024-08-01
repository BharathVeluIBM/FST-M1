from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from webdriver_manager.chrome import ChromeDriverManager

service = Service(ChromeDriverManager().install())
driver = webdriver.Chrome(service=service)
wait = WebDriverWait(driver, 10)

driver.get("https://v1.training-support.net/selenium/tables")
print("Home page title: " + driver.title)

cols = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[1]/td")
print("Number of columns: " + str(len(cols)))

rows = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr")
print("Number of rows: " + str(len(rows)))

third_row = driver.find_elements(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[3]/td")
print("Third row cell values: ")
for cell in third_row:
    print(cell.text)

cell_value = driver.find_element(By.XPATH, "//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]")
print("Second row, second cell value: " + cell_value.text)

driver.quit()
