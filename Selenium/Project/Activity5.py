from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import Select
from webdriver_manager.chrome import ChromeDriverManager

# Initialize the ChromeDriver service
service = Service(ChromeDriverManager().install())

# Use 'with' to ensure the browser is properly closed
with webdriver.Chrome(service=service) as driver:
    # Open the OrangeHRM page and login with credentials provided
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")

    title = driver.title
    print("Home page title:", title)

    wait = WebDriverWait(driver, 10)
    username = wait.until(EC.visibility_of_element_located((By.ID, "txtUsername")))
    username.send_keys("orange")

    password = driver.find_element(By.ID, "txtPassword")
    password.send_keys("orangepassword123")

    login_btn = driver.find_element(By.ID, "btnLogin")
    login_btn.click()

    dashboard = wait.until(EC.visibility_of_element_located((By.XPATH, "//b[contains(text(),'Dashboard')]")))

    if dashboard.is_displayed():
        print("Landed into the HomePage")
    else:
        print("User still not landed into the HomePage")

    # Find the “My Info” menu item and click it
    my_info = wait.until(EC.element_to_be_clickable((By.XPATH, "//b[contains(text(),'My Info')]")))
    my_info.click()

    # On the new page, click the Edit button
    edit_btn = wait.until(EC.element_to_be_clickable((By.XPATH, "//input[@value='Edit']")))
    edit_btn.click()

    # Fill in the Name, Gender, Nationality, and the DOB fields
    first_name = wait.until(EC.element_to_be_clickable((By.XPATH, "//input[@id='personal_txtEmpFirstName']")))
    first_name.send_keys("Hellow")

    last_name = driver.find_element(By.XPATH, "//input[@id='personal_txtEmpLastName']")
    last_name.send_keys("World")

    gender = driver.find_element(By.ID, "personal_optGender_1")
    gender.click()

    nationality = driver.find_element(By.ID, "personal_cmbNation")  
    dropdown = Select(nationality)  
    dropdown.select_by_index(5)    

    # Click Save
    save_btn = driver.find_element(By.ID, "btnSave")
    save_btn.click()

    print("Record edited and saved")
