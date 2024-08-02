from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager

# Initialize the ChromeDriver service
service = Service(ChromeDriverManager().install())

# Use 'with' to ensure the browser is properly closed
with webdriver.Chrome(service=service) as driver:
    # Open the browser to the login page of OrangeHRM site
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")

    # Get and print the title of the page
    title = driver.title
    print("Home page title:", title)

    # Get and print the URL of the logo image
    image_url = driver.find_element(By.XPATH, "//div[@id='divLogo']/img").get_attribute("src")
    print("Logo image URL:", image_url)
