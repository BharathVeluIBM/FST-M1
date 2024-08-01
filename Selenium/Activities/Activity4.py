from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service as ChromeService
from webdriver_manager.chrome import ChromeDriverManager

try:
    # Setup the Chrome driver
    print("Setting up the Chrome driver...")
    service = ChromeService(executable_path=ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service)
    
    # Open the target website
    print("Opening the target website...")
    driver.get("https://v1.training-support.net/selenium/target-practice")
    print("Home page title:", driver.title)
    
    # Find and print the third header text
    print("Finding the third header...")
    third_header = driver.find_element(By.XPATH, "//h3[@id='third-header']").text
    print("The 3rd Header is:", third_header)
    
    # Find and print the color of the fifth header
    print("Finding the fifth header color...")
    fifth_header_color = driver.find_element(By.XPATH, "//h5[contains(text(),'Fifth header')]").value_of_css_property("color")
    print("The color of the Fifth Header is:", fifth_header_color)
    
    # Find and print the class attribute of the violet button
    print("Finding the violet button class attribute...")
    violet_button_class = driver.find_element(By.XPATH, "//button[contains(text(),'Violet')]").get_attribute("class")
    print("The Attribute of Violet color button is:", violet_button_class)
    
    # Find and print the text of the grey button
    print("Finding the grey button text...")
    grey_button_text = driver.find_element(By.XPATH, "//button[contains(text(),'Grey')]").text
    print("Grey button text:", grey_button_text)
    
    # Close the browser
    print("Closing the browser...")
    driver.close()
    print("Script completed successfully.")
    
except Exception as e:
    print("An error occurred:", str(e))
