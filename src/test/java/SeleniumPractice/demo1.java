package SeleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class demo1 {
	public WebDriver driver; 
	
	@BeforeClass
	public void setUp() {
		this.driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterClass
	public void tearDown() {
		if(driver != null) {
			driver.close();
		}
	}
	@Test
	public void webTable() {
		
		String contact =  driver.findElement(By.xpath("//*[@id = 'customers']/tbody/tr[2]/td[2]")).getText();
		System.out.println(contact);
		
		List<WebElement> webTableDetails = driver.findElements(By.xpath("//*[@id = 'customers']"));
		
		for(WebElement companyDetails: webTableDetails) {
			companyDetails.getText();
			System.out.println("Comapany details are as followed: "+ companyDetails);
		}
		
	}

}
