from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select, WebDriverWait
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

service = Service(ChromeDriverManager().install())
driver = webdriver.Chrome(service=service)
wait = WebDriverWait(driver, 10)

driver.get("https://v1.training-support.net/selenium/selects")
print("Home page title:", driver.title)

select_element = driver.find_element(By.ID, "multi-select")
multi_select = Select(select_element)

multi_select.select_by_visible_text("Javascript")

for i in range(4, 7):
    multi_select.select_by_index(i)

multi_select.select_by_value("node")

selected_options = multi_select.all_selected_options
print("Selected options are:")
for option in selected_options:
    print(option.text)

multi_select.deselect_by_index(5)
selected_options = multi_select.all_selected_options
print("Selected options are:")
for option in selected_options:
    print(option.text)

driver.quit()
