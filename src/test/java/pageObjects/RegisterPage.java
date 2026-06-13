package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
	
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "firstname")
	WebElement txtfstname;
	
	@FindBy(name="lastname")
	WebElement txtlstname;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephoneno;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtconfpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement clickchbox;
	
	@FindBy(xpath= "//input[@value='Continue']")
	WebElement clickctnbtn;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconformation;
	
	public void Txtfirstname(String fname) {
		txtfstname.sendKeys(fname);
	}
	
	public void TxtLastname(String lname) {
		txtlstname.sendKeys(lname);
	}
	public void TxtEmail(String email) {
		txtmail.sendKeys(email);
	}
	
	public void Telephoneno(String tel) {
		telephoneno.sendKeys(tel);
	}
	public void TxtPassword(String pasword) {
		txtpassword.sendKeys(pasword);
	}
	public void Txtconfmpassword(String cnfpasword) {
		txtconfpassword.sendKeys(cnfpasword);
	}
	public void Clickchkbox() {
		clickchbox.click();
	}
	public void Clickctnbtn() {
		clickctnbtn.click();
	}
	public String Conformationmasg() {
		
		try {
			return(msgconformation.getText());
		}
		catch(Exception e){
			return(e.getMessage());
			
		}
		
		
	}

}
