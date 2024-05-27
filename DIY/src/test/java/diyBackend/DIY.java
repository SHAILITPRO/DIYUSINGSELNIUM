package diyBackend;

import java.net.MalformedURLException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
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
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(browserOptions);
            driver.manage().window().maximize();
        } 
        
        
        else if(browserName.equalsIgnoreCase("firefox")) {
            // Initialize FirefoxDriver
        	FirefoxOptions browserOptions1 = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(browserOptions1);
            driver.manage().window().maximize();
        }
        
        else if (browserName.equalsIgnoreCase("MicrosoftEdge")) {
            // Initialize EdgeDriver
            EdgeOptions browserOptions3 = new EdgeOptions();
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
    
    public String generateRandomEmail() {
        String prefix = "shailendra+";
        String domain = "@dreamcast.co";
        Random random = new Random();
        
        // Generate a random number between 1000 and 9999
        int randomNumber = 1000 + random.nextInt(9000);
        
        // Concatenate prefix, random number, and domain
        String email = prefix + randomNumber + domain;
        
        return email;
    }

    @Test
    public void loginTest() throws InterruptedException {
    	
    	
    	
    	
        driver.get("https://event.godreamcast.com/staging-e/admin");
        
        System.out.println(driver.getTitle());
        
WebElement element = driver.findElement(By.xpath(textWelcom));
        
        // Verify the text is present
        if (element.getText().contains("Welcome")) {
            Reporter.log("Text 'welcom' is present");
            System.out.println("Text 'Welcome' is present");
        } else {
            Reporter.log("Text 'welcom' is not present");
            System.out.println("Text 'Welcome' is not present");
        }

        String randomEmail = generateRandomEmail();
        text(email, randomEmail);
        System.out.println(randomEmail);
        linkbtn(contBtn);
        Thread.sleep(5000);
        WebElement toasterMessageElement = driver.findElement(By.xpath("//div[@class='Toastify']"));
        
        // Extract the text of the toaster message
        String toasterMessage = toasterMessageElement.getText();
        
        // Print the message to the console
        System.out.println("Toaster message: " + toasterMessage);
        
        
WebElement sendOtp = driver.findElement(By.xpath("//div[@class='Toastify']"));
        
        // Extract the text of the toaster message
        String sendOtpMessage = sendOtp.getText();
        
        // Print the message to the console
        System.out.println("Toaster message: " + sendOtpMessage);
        
        
       
        text(otp, "124421");
        text(phone, "7987583023");
        linkbtn(contBtnfrompwd);
        
        //text(pwd, "Testing1@3");
       // linkbtn(contBtnfrompwd);

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

        Thread.sleep(5000);
        driver.quit();
    }
}
