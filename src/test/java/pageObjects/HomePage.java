package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super (driver);	
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement clickmyaccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement clickregister;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement clicklogin;
	
	
	public void clickMyaccount() throws InterruptedException 
	
	{
		Thread.sleep(20);
		clickmyaccount.click();
	}
	
	public void clickRegister() {
		clickregister.click();
	}
	
	public void clickLogin() {
		clicklogin.click();
	}
	
	
			

}
