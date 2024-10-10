package org.opencart.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(name = "email")
	WebElement emailInput;
	
	@FindBy(name = "password")
	WebElement passwordInput;
	
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement clickOnSumbit;
	
	@FindBy(xpath  = "//*[@id=\"column-right\"]/div/a[13]")
	WebElement clickOnLogout;
	
	
	public void provideUserDetails(String userId, String password) {
		emailInput.sendKeys(userId);
		passwordInput.sendKeys(password);
	}
	
	public boolean clickOnSubmitButton() {
		return clickOnSumbit.isDisplayed();
	}
	
	public boolean clickOnLogOutButton() {
		return clickOnLogout.isDisplayed();
	}

}
