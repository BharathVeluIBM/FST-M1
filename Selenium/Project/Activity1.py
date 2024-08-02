from selenium import webdriver
from selenium.webdriver.chrome.service import Service
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

    # Check if the title matches "OrangeHRM"
    if title == "OrangeHRM":
        print("Title Matched")
    else:
        print("Title Not Matched")
