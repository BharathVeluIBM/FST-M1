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
    # a. Open the OrangeHRM page and login with credentials provided
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")

    wait = WebDriverWait(driver, 10)
    username = wait.until(EC.visibility_of_element_located((By.ID, "txtUsername")))
    username.send_keys("orange")

    password = driver.find_element(By.ID, "txtPassword")
    password.send_keys("orangepassword123")

    login_btn = driver.find_element(By.ID, "btnLogin")
    login_btn.click()

    # b. Find the “My Info” menu item and click it
    my_info = wait.until(EC.element_to_be_clickable((By.XPATH, "//b[contains(text(),'My Info')]")))
    my_info.click()
    print("User clicked the My Info")

    # c. On the new page, find the Qualification option on the left side menu and click it
    qualifications = wait.until(EC.element_to_be_clickable((By.XPATH, "//ul[@id='sidenav']//a[contains(text(),'Qualifications')]")))
    qualifications.click()
    print("User clicked the Qualification")

    # d. Add Work Experience and click Save
    add_work_experience = wait.until(EC.element_to_be_clickable((By.ID, "addWorkExperience")))
    add_work_experience.click()
    print("User clicked the Add Work Experience Button")

    company_name = wait.until(EC.visibility_of_element_located((By.ID, "experience_employer")))
    company_name.send_keys("Example Company")

    job_title = driver.find_element(By.ID, "experience_jobtitle")
    job_title.send_keys("Software Engineer")

    from_date = driver.find_element(By.ID, "experience_from_date")
    from_date.send_keys("2010-01-01")

    to_date = driver.find_element(By.ID, "experience_to_date")
    to_date.send_keys("2020-01-01")

    save_btn = driver.find_element(By.ID, "btnWorkExpSave")
    save_btn.click()

    print("Work Experience added and saved.")
