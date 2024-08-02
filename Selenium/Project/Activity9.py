from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

# Initialize the WebDriver
service = Service(ChromeDriverManager().install())
with webdriver.Chrome(service=service) as driver:
    wait = WebDriverWait(driver, 10)

    # a. Open the OrangeHRM page and login with credentials provided
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")
    
    username = wait.until(EC.visibility_of_element_located((By.ID, "txtUsername")))
    username.send_keys("orange")

    password = driver.find_element(By.ID, "txtPassword")
    password.send_keys("orangepassword123")

    login_btn = driver.find_element(By.ID, "btnLogin")
    login_btn.click()

    # b. Navigate to the “My Info” page
    my_info = wait.until(EC.element_to_be_clickable((By.XPATH, "//b[contains(text(),'My Info')]")))
    my_info.click()

    # c. Locate the left-hand menu
    left_menu = wait.until(EC.visibility_of_element_located((By.ID, "sidenav")))

    # d. Click on the “Emergency Contacts” menu item
    emergency_contacts = left_menu.find_element(By.XPATH, "//a[contains(text(),'Emergency Contacts')]")
    emergency_contacts.click()

    # e. Retrieve information about all the contacts listed in the table
    rows = wait.until(EC.visibility_of_all_elements_located((By.XPATH, "//table[@id='emgcontact_list']//tr")))

    # f. Print all the information to the console
    for row in rows:
        row_text = row.text
        print(row_text)
