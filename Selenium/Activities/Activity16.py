from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from webdriver_manager.chrome import ChromeDriverManager

# Set up ChromeDriver using WebDriverManager
driver = webdriver.Chrome(ChromeDriverManager().install())
wait = WebDriverWait(driver, 10)

# Navigate to the target page
driver.get("https://v1.training-support.net/selenium/dynamic-attributes")
print("Home page title:", driver.title)

# Locate elements using dynamic attributes
user_name = driver.find_element(By.XPATH, "//input[contains(@class, '-username')]")
password = driver.find_element(By.XPATH, "//input[contains(@class, '-password')]")
confirm_password = driver.find_element(By.XPATH, "//label[text() = 'Confirm Password']/following-sibling::input")
email = driver.find_element(By.XPATH, "//label[contains(text(), 'mail')]/following-sibling::input")

# Input values into the form fields
user_name.send_keys("NewUser")
password.send_keys("Password")
confirm_password.send_keys("Password")
email.send_keys("real_email@xyz.com")

# Click the Sign Up button
driver.find_element(By.XPATH, "//button[contains(text(), 'Sign Up')]").click()

# Wait for the confirmation message to appear and print it
login_message = wait.until(EC.visibility_of_element_located((By.ID, "action-confirmation"))).text
print("Login message:", login_message)

# Close the browser
driver.quit()
