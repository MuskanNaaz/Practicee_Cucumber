package CucumberIntegeration;

import java.time.Duration;

import org.opencart.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefiniationImpl {

	public WebDriver driver;
	public LoginPage loginPage;

	@Before
	public void setUp() {
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}
	}

	@Given("I am on the Opencart login page")
	public void i_am_on_the_opencart_login_page() {
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		loginPage = new LoginPage(driver);

	}

	@Given("I have entered a valid username and password")
	public void i_have_entered_a_valid_username_and_password() {
		loginPage.provideUserDetails("rozi@gmail.com", "qwerty@12345");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Given("I have entered invalid {string} and {string}")
	public void i_have_entered_invalid_and(String userName, String passWord) {
		loginPage.provideUserDetails(userName, passWord);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}


	@When("I click on the login button")
	public void i_click_on_the_login_button() throws InterruptedException {
		loginPage.clickOnSubmitButton();
		System.out.println("I click on the login button");
		Thread.sleep(5000);
	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Assert.assertEquals(loginPage.clickOnLogOutButton(), true);
	}

	
	@Then("I should see erroe messgae indicating {string}")
	public void i_should_see_erroe_messgae_indicating(String errorMessage) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

}
