package diyBackend;

import java.net.MalformedURLException;

import java.time.Duration;
import java.util.Random;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

 
public class DIY extends Elements {
    private WebDriver driver;
    

    @BeforeClass
    @Parameters({"browserName", "version", "platform"})
    public void setUp(String browserName, String version, String platform) throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName(platform);
        browserOptions.setBrowserVersion(version);

        // Initialize WebDriver instance based on the provided browserName
        if(browserName.equalsIgnoreCase("chrome")) {
            // Initialize ChromeDriver
        	
        	 // Configure logging preferences
            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable(LogType.BROWSER, Level.ALL);

            // Set Chrome options
            ChromeOptions options = new ChromeOptions();
            options.setCapability("goog:loggingPrefs", logPrefs);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(browserOptions);
            driver.manage().window().maximize();
        } 
        
        
        else if(browserName.equalsIgnoreCase("firefox")) {
            // Initialize FirefoxDriver
        	FirefoxOptions browserOptions1 = new FirefoxOptions();
        	 // Configure logging preferences
            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable(LogType.BROWSER, Level.ALL);

            // Set Chrome options
            ChromeOptions options = new ChromeOptions();
            options.setCapability("goog:loggingPrefs", logPrefs);
            
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(browserOptions1);
            driver.manage().window().maximize();
        }
        
        else if (browserName.equalsIgnoreCase("MicrosoftEdge")) {
            // Initialize EdgeDriver
            EdgeOptions browserOptions3 = new EdgeOptions();
            // Configure logging preferences
            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable(LogType.BROWSER, Level.ALL);

            // Set Chrome options
            ChromeOptions options = new ChromeOptions();
            options.setCapability("goog:loggingPrefs", logPrefs);
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(browserOptions3);
            driver.manage().window().maximize();
        }

        // Set other capabilities and configurations as needed
        // ...
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
    }

        
        
    
    
    public void text(String locators, String keys) {
        driver.findElement(By.xpath(locators)).sendKeys(keys);
    }

    public void linkbtn(String locators) {
        driver.findElement(By.xpath(locators)).click();
    }
    public void clearText(String locators) {
        driver.findElement(By.xpath(locators)).clear();;
    }
    public void textWithCSS(String locators, String keys) {
        driver.findElement(By.cssSelector(locators)).sendKeys(keys);
    }
    
    public void linkBtnWithCss(String locators) {
        driver.findElement(By.cssSelector(locators)).click();
    }
    
    //---------------------- Random Email Genrate-----------------------
    
    public String generateRandomEmail() {
        String prefix = "shailendra+";
        String domain = "@dreamcast.co";
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000);
        String email = prefix + randomNumber + domain;
        return email;
    }
    
    

    @Test
    public void loginTest() throws InterruptedException {
        driver.get("https://event.godreamcast.com/staging-e/admin"); 
        System.out.println(driver.getTitle());  
        
      //--------------------------Enter Email---------------------------------
        
        
        
        
        WebElement element = driver.findElement(By.xpath(textWelcom));
        // Verify the text is present
        if (element.getText().contains("Welcome")) {
            System.out.println("Text 'Welcome' is present");
        } else {
            System.out.println("Text 'Welcome' is not present");
        }

        String randomEmail = generateRandomEmail();
        text(email, randomEmail);
        System.out.println(randomEmail);
        linkbtn(contBtn);
        Thread.sleep(5000);
        
        //--------------------------OTP Page---------------------------------
        WebElement toasterMessageElement = driver.findElement(By.xpath("//div[@class='Toastify']"));
        String toasterMessage = toasterMessageElement.getText();
        System.out.println("Toaster message: " + toasterMessage);   
        WebElement sendOtp = driver.findElement(By.xpath("//div[@class='Toastify']"));
        String sendOtpMessage = sendOtp.getText();
        System.out.println("Toaster message: " + sendOtpMessage);
        text(otp, "124421");
        
        //--------------------------Enter Phone number Page---------------------------------
        text(phone, "7987583023");
        linkbtn(contBtnfrompwd);
        Thread.sleep(5000);
        clearText(phone);      
        Thread.sleep(3000);
        WebElement phoneAlreadyExist = driver.findElement(By.xpath("//div[@class='Toastify']"));
        String phoneAlreadyExistMessage = phoneAlreadyExist.getText();
        System.out.println("Toaster message: " + phoneAlreadyExistMessage);
        Thread.sleep(3000);
        clearText(phone);
        linkbtn(skip);
        Thread.sleep(3000);
        
        
        //----------------------------Profile page-------------------------------
        WebElement element2 = driver.findElement(By.xpath(completeYourProfile));
        if (element2.getText().contains("Complete Your Profile")) {
           
            System.out.println("Text 'Complete Your Profile' is present");
        } else {
            
            System.out.println("Text 'Complete Your Profile' is not present");
        }
        text(firstNameBackend, "Shailendra");
        text(lastNameBackend, "Singh");
        linkbtn(letsGo);
      //-------------------------Create Event----------------------------------
        
       
       
        
        Random rand = new Random();
        int randomNumber = rand.nextInt(1000); // Generating a random number between 0 and 999
        // Append the random number to the text
        String eventNameEnter = "Creativity Unleashed Gathering: " + randomNumber;
        System.out.println(eventNameEnter);
        text(eventName, eventNameEnter);
        
        String eventDescription = "Creativity Unleashed Gathering: Descriptions" + randomNumber + " This is descriptions";
        System.out.println(eventDescription);
        text(eventDescrElement, eventDescription);
        
        
        // Start date
        
        linkBtnWithCss(EventStartdate);
        textWithCSS(EventStartdate, "2024-05-09");
       
        // Start time 
        linkBtnWithCss(eventStartTime);
        linkBtnWithCss(eventStartTimeSelect);
        
        
     // End Date
        linkBtnWithCss(eventEndDate);
        textWithCSS(eventEndDate, "2024-05-09");
        
        
     // End Time
        linkBtnWithCss(eventEndTime);
        linkBtnWithCss(eventEndTimeSelect);
        
        linkBtnWithCss(".py-2\\.5");
        linkBtnWithCss(".SearchLocation");
        textWithCSS(".SearchLocation", "jaipur");
        
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (org.openqa.selenium.logging.LogEntry entry : logEntries) {
            System.out.println(entry.getLevel() + " " + entry.getMessage());
        }
    
        
        
       
        
        
        /*
        linkbtn(goToEvent);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // Switch to the new tab
        driver.switchTo().window(tabs.get(1)); 
        String newTabUrl = driver.getCurrentUrl();
        System.out.println("URL of the new tab: " + newTabUrl);

        System.out.println(driver.getTitle());
        linkbtn(registerBtn);
        linkbtn(contibueBtnfrmQty);
        text(firstName, "Shailendra");
        text(lastName, "Singh");
        text(emailFront, "shailendra@dreamcast.co");
        linkbtn(saveForm);
        Thread.sleep(3000);
       // linkbtn(checkout);

*/
        Thread.sleep(5000);
        driver.quit();
    }
    
    





	
}
