from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

service = Service(ChromeDriverManager().install())
with webdriver.Chrome(service=service) as driver:
    
    driver.get("https://v1.training-support.net/")
    print("Page title is: ", driver.title)
    driver.find_element
