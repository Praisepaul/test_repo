import time
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

num_iterations = 50
for _ in range(num_iterations):
# Set Chrome options for incognito mode
    chrome_options = Options()
    chrome_options.add_argument("--incognito")

# Path to your chromedriver executable
#chromedriver_path = "C:/Users/HP/Downloads/chromedriver_win32/chromedriver.exe"

# Create a new instance of ChromeDriver with the desired options
    driver = webdriver.Chrome(options=chrome_options)

# Open the link in incognito mode
    link = "https://www.vahanischolarship.com/post/my-journey-with-the-captivating-vahani-english-programme"

    # Load the page
    driver.get(link)

    # Find and click the like button using alternate approaches
    try:
        like_button = WebDriverWait(driver, 15, 3).until(EC.element_to_be_clickable((By.CSS_SELECTOR, '.LtaU1R')))
        time.sleep(10)
        like_button.click()
        
        # Approach 1: Use JavaScript to click the element
        #driver.execute_script("arguments[0].click();", like_button)
        
        # Approach 2: Scroll to the element before clicking
        # driver.execute_script("arguments[0].scrollIntoView(true);", like_button)
        # like_button.click()
        
        # Approach 3: Simulate a mouse click using ActionChains
        action_chains = webdriver.ActionChains(driver)
        action_chains.move_to_element(like_button).click().perform()
        
        print("Heart icon clicked successfully!")
    except:
        print("Failed to click the heart icon.")
    driver.quit()
