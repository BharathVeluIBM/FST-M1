from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import Select
from webdriver_manager.chrome import ChromeDriverManager

# Setup WebDriver
service = Service(ChromeDriverManager().install())
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

    # Verify that the “Directory” menu item is visible and clickable
    directory = driver.find_element(By.XPATH, "//b[contains(text(),'Directory')]")

    if directory.is_displayed():
        directory.click()
    else:
        print("Directory was not visible")

    # Verify that the heading of the page matches “Search Directory”
    header = wait.until(EC.visibility_of_element_located((By.XPATH, "//h1[contains(text(),'Search Directory')]")))

    header_text = header.text

    if header_text == "Search Directory":
        print("Search Directory was getting displayed")
    else:
        print("Search Directory was not displayed")


    driver.quit()
