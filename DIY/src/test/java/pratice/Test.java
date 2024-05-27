package pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	public static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		WebElement ele=driver.findElement(By.xpath("//td[contains(text(),'Island Trading')]"));
		WebElement ele1=driver.findElement(By.xpath("//tbody/tr[5]/td[3]"));
		if(ele.isDisplayed()) {
			
			System.out.println(ele1);
		}
		else {
			
			System.out.println("Country is not there");
		}
			
	}

}
