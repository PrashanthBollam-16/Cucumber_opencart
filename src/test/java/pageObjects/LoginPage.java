package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailtxt;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passwordtxt;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;

	
	public void Emailtxt(String email) {
		emailtxt.sendKeys(email);
	}
	public void Passowrdtxt(String password) {
		passwordtxt.sendKeys(password);
	}
	public void Loginbtn() {
	  loginbtn.click();
	}
}
