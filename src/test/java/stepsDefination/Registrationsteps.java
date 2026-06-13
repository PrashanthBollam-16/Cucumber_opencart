package stepsDefination;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Myaccountpage;
import pageObjects.RegisterPage;

public class Registrationsteps {
	
	WebDriver driver;
	HomePage Hp;
	LoginPage Lp;
	Myaccountpage Myaccpge;
	RegisterPage Rp;

	@Given("user is on the registration page")
	public void user_is_on_the_registration_page() throws InterruptedException {
		
		Hp=new HomePage(Baseclass.getDriver());
		Hp.clickMyaccount();
		Hp.clickRegister();
	   
	}

	@When("user gives all the required details like")
	public void user_gives_all_the_required_details_like(io.cucumber.datatable.DataTable dataTable) {
		
		Map<String,String> datamap = dataTable.asMap(String.class,String.class);
		
		Rp =new RegisterPage(Baseclass.getDriver());
		Rp.Txtfirstname(datamap.get("firstName"));
		Rp.TxtLastname(datamap.get("lastName"));
		Rp.TxtEmail(Baseclass.randomeAlphaNumeric()+"@gmail.com");
	   Rp.Telephoneno(datamap.get("telephone"));
	   Rp.TxtPassword(datamap.get("password"));
	   Rp.Txtconfmpassword(datamap.get("cnfpassword"));
	}

	@When("user selects the privacy chechbox")
	public void user_selects_the_privacy_chechbox() {
	   Rp.Clickchkbox();
	}

	@When("user selects the continue button")
	public void user_selects_the_continue_button() {
	    Rp.Clickctnbtn();
	}

	@Then("user should be successfully registred")
	public void user_should_be_successfully_registred() {
		
		String confmsg=Rp.Conformationmasg();
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
	   
	}

}
