package diyBackend;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
        } 
        
        
        else if(browserName.equalsIgnoreCase("firefox")) {
            // Initialize FirefoxDriver
        	FirefoxOptions browserOptions1 = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(browserOptions1);
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

    @Test
    public void loginTest() throws InterruptedException {
        driver.get("https://event.godreamcast.com/staging-e/admin");

        text(email, "shailendra+1@dreamcast.co");
        linkbtn(contBtn);
        Thread.sleep(3000);
        text(pwd, "Testing1@3");
        linkbtn(contBtnfrompwd);

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
