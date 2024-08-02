from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import Select
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

# Initialize the WebDriver
service = Service(ChromeDriverManager().install())
with webdriver.Chrome(service=service) as driver:
    wait = WebDriverWait(driver, 10)
    actions = ActionChains(driver)

    # a. Open the OrangeHRM page and login with credentials provided
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")

    username = wait.until(EC.visibility_of_element_located((By.ID, "txtUsername")))
    username.send_keys("orange")

    password = driver.find_element(By.ID, "txtPassword")
    password.send_keys("orangepassword123")

    login_btn = driver.find_element(By.ID, "btnLogin")
    login_btn.click()

    # b. Navigate to the Dashboard page and click on the Apply Leave option.
    dashboard = wait.until(EC.visibility_of_element_located((By.XPATH, "//b[contains(text(),'Dashboard')]")))
    if dashboard.is_displayed():
        print("Landed into the HomePage")
    else:
        print("User still not landed into the HomePage")

    apply_leave_link = wait.until(EC.visibility_of_element_located((By.XPATH, "//span[contains(text(),'Apply Leave')]")))
    apply_leave_link.click()

    apply_leave_header = wait.until(EC.visibility_of_element_located((By.XPATH, "//h1")))
    apply_leave_header_section = apply_leave_header.text

    if apply_leave_header_section == "Apply Leave":
        print("User Land into the Apply Leave Section")

    # c. Select leave type and duration of the leave
    leave_type = driver.find_element(By.ID, "applyleave_txtLeaveType")
    dropdown = Select(leave_type)
    dropdown.select_by_index(1)

    from_date = driver.find_element(By.ID, "applyleave_txtFromDate")
    from_date.clear()
    from_date.send_keys("2024-07-01")

    to_date = driver.find_element(By.ID, "applyleave_txtToDate")
    to_date.clear()
    to_date.send_keys("2024-07-01")

    actions.send_keys(webdriver.common.keys.Keys.TAB).perform()

    duration = wait.until(EC.visibility_of_element_located((By.ID, "applyleave_duration_duration")))
    dropdown1 = Select(duration)
    dropdown1.select_by_index(1)

    comment_box = driver.find_element(By.ID, "applyleave_txtComment")
    comment_box.send_keys("Apply sick Leave")

    # d. Click Apply.
    apply_btn = driver.find_element(By.ID, "applyBtn")
    apply_btn.click()

    # e. Navigate to the My Leave page to check the status of the leave application.
    my_leave = wait.until(EC.visibility_of_element_located((By.ID, "menu_leave_viewMyLeaveList")))
    my_leave.click()

    leave_status = wait.until(EC.visibility_of_element_located((By.XPATH, "//table[@id='resultTable']")))
    if leave_status.is_displayed():
        print("Leave status page is displayed.")
    else:
        print("Leave status page is not displayed.")
