from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
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

    # Find the PIM option in the menu and click it
    pim = wait.until(EC.element_to_be_clickable((By.XPATH, "//b[contains(text(),'PIM')]")))
    pim.click()

    employee_list = wait.until(EC.visibility_of_element_located((By.XPATH, "//a[contains(text(),'Employee List')]")))
    if employee_list.is_displayed():
        print("User Landed into the Employee List Page")

    # Click the Add button to add a new Employee
    add_btn = wait.until(EC.element_to_be_clickable((By.ID, "btnAdd")))
    add_btn.click()
    
    # Fill in the required fields and click Save
    first_name = wait.until(EC.visibility_of_element_located((By.ID, "firstName")))
    last_name = driver.find_element(By.ID, "lastName")
    save_btn = driver.find_element(By.ID, "btnSave")

    first_name.send_keys("Ramya")
    last_name.send_keys("Velu")
    save_btn.click()

    personal_details = wait.until(EC.visibility_of_element_located((By.XPATH, "//h1[contains(text(),'Personal Details')]")))

    if personal_details.is_displayed():
        print("User Landed into the Personal Details Page")

    # Navigate back to the PIM page (Employee List tab) and verify the creation of your employee
    pim = wait.until(EC.element_to_be_clickable((By.XPATH, "//b[contains(text(),'PIM')]")))
    pim.click()

    # Search for the employee details
    emp_name_search = wait.until(EC.visibility_of_element_located((By.ID, "empsearch_employee_name_empName")))
    emp_name_search.send_keys("Ramya Velu")

    search_btn = driver.find_element(By.ID, "searchBtn")
    search_btn.click()
    print("User can search for the employee")

# The browser will automatically close at the end of the 'with' block
