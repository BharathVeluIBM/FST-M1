from selenium import webdriver
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from webdriver_manager.chrome import ChromeDriverManager

# Setup the Chrome driver
print("Setting up the Chrome driver...")
service = ChromeService(executable_path=ChromeDriverManager().install())
driver = webdriver.Chrome(service=service)
wait = WebDriverWait(driver, 10)  # Timeout of 10 seconds

# Open the target website
print("Opening the target website...")
driver.get("https://v1.training-support.net/selenium/ajax")

# Click the violet button
driver.find_element(By.CSS_SELECTOR, "button.violet").click()

# Wait until the h1 element is visible
wait.until(EC.visibility_of_element_located((By.TAG_NAME, "h1")))

# Print the text of the h1 element
text = driver.find_element(By.TAG_NAME, "h1").text
print(text)

# Print the text of the h3 element before it changes
delayed_text = driver.find_element(By.TAG_NAME, "h3").text
print(delayed_text)

# Wait until the text of the h3 element changes to "I'm late!"
wait.until(EC.text_to_be_present_in_element((By.TAG_NAME, "h3"), "I'm late!"))

# Print the text of the h3 element after it changes
late_text = driver.find_element(By.TAG_NAME, "h3").text
print(late_text)

# Close the browser
print("Closing the browser...")
driver.quit()
