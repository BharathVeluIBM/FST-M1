from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from webdriver_manager.chrome import ChromeDriverManager

service = Service(ChromeDriverManager().install())
driver = webdriver.Chrome(service=service)
wait = WebDriverWait(driver, 10)

driver.get("https://v1.training-support.net/selenium/tables")
print("Home page title: " + driver.title)

cols = driver.find_elements(By.XPATH, "//table[@id='sortableTable']/tbody/tr[1]/td")
print("Number of columns: " + str(len(cols)))

rows = driver.find_elements(By.XPATH, "//table[@id='sortableTable']/tbody/tr")
print("Number of rows: " + str(len(rows)))

cell_value = driver.find_element(By.XPATH, "//table[@id='sortableTable']/tbody/tr[2]/td[2]")
print("Second row, second cell value: " + cell_value.text)

driver.find_element(By.XPATH, "//table[@id='sortableTable']/thead/tr/th").click()

cell_value = driver.find_element(By.XPATH, "//table[@id='sortableTable']/tbody/tr[2]/td[2]")
print("Second row, second cell value after sorting: " + cell_value.text)

footer = driver.find_elements(By.XPATH, "//table[@id='sortableTable']/tfoot/tr/th")
print("Cell values of the footer: ")
for cell in footer:
    print(cell.text)

driver.quit()
