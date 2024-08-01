from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select, WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from webdriver_manager.chrome import ChromeDriverManager

driver = webdriver.Chrome(ChromeDriverManager().install())
wait = WebDriverWait(driver, 10)

driver.get("https://v1.training-support.net/selenium/selects")
print("Home page title:", driver.title)

dropdown = driver.find_element(By.ID, "single-select")
single_select = Select(dropdown)
single_select.select_by_visible_text("Option 2")
print("Second option:", single_select.first_selected_option.text)

single_select.select_by_index(3)
print("Third option:", single_select.first_selected_option.text)

single_select.select_by_value("4")
print("Fourth option:", single_select.first_selected_option.text)

all_options = single_select.options
print("Options in the dropdown:")
for option in all_options:
    print(option.text)

driver.quit()
