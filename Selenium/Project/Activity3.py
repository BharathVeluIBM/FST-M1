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
    # Open the browser to the login page of OrangeHRM site
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")

    title = driver.title
    print("Home page title:", title)

    # Find and select the username and password fields
    wait = WebDriverWait(driver, 10)
    username = wait.until(EC.visibility_of_element_located((By.ID, "txtUsername")))
    username.send_keys("orange")

    password = driver.find_element(By.ID, "txtPassword")
    password.send_keys("orangepassword123")

    # Click login
    login_btn = driver.find_element(By.ID, "btnLogin")
    login_btn.click()

    # Verify that the homepage has opened
    dashboard = wait.until(EC.visibility_of_element_located((By.XPATH, "//b[contains(text(),'Dashboard')]")))

    # Check if the dashboard is displayed
    if dashboard.is_displayed():
        print("Landed into the HomePage")
    else:
        print("User still not landed into the HomePage")
        
# The browser will automatically close at the end of the 'with' block
