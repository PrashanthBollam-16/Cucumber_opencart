package stepsDefination;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Myaccountpage;
import utilites.DataReader;

public class Loginsteps {
	
	WebDriver driver;
	HomePage hp;
	LoginPage Lp;
	Myaccountpage myacc;
	
	List<HashMap<String,String>> datamap;//Data Driven

	@Given("the user navigates to the Login page")
	public void the_user_navigates_to_the_login_page() throws InterruptedException {
		
		hp = new HomePage(Baseclass.getDriver());
		hp.clickMyaccount();
		Baseclass.getLogger().info("user is on homepage and clicked on myaccount");
		hp.clickLogin();
		Baseclass.getLogger().info("clicked on Login");
		
	    Baseclass.getLogger().info("the user is on the login page know");
	}

	@When("the user enters email as {string} and password as {string}")
	public void the_user_enters_email_as_and_password_as(String email, String password) {
	   Lp=new LoginPage(Baseclass.getDriver());
	   Baseclass.getLogger().info("the user enters email and password");
	   Lp.Emailtxt(email);
	   Baseclass.getLogger().info("user entered email");
	   Lp.Passowrdtxt(password);
	   Baseclass.getLogger().info("user entered password");
	}

	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
	   Lp=new LoginPage(Baseclass.getDriver());
	   Lp.Loginbtn();
	   Baseclass.getLogger().info("user clicks on the loginbtn");
	  
	}

	@Then("user should be redirected to my account page")
	public void user_should_be_redirected_to_my_account_page() {
	   myacc=new Myaccountpage(Baseclass.getDriver());
	  boolean targetpage= myacc.ismyaccountexists();
	  Assert.assertEquals(targetpage, true);
	}
	

	@Then("user should be redirected to my account page by passing email and password with excel row {string}")
	public void user_should_be_redirected_to_my_account_page_by_passing_email_and_password_with_excel_row(String rows) 
	{
     datamap=DataReader.data(System.getProperty("user.dir")+"//testData//Opencart_LoginData.xlsx","Sheet1");
    int index= Integer.parseInt(rows)-1;
   String email= datamap.get(index).get("username");
   String password=datamap.get(index).get("password");
   String exp_res=datamap.get(index).get("res");
   
   Lp=new LoginPage(Baseclass.getDriver());
   Lp.Emailtxt(email);
   Lp.Passowrdtxt(password);
   Lp.Loginbtn();
   
   myacc = new Myaccountpage(Baseclass.getDriver());
   try
   {
   boolean targetpage= myacc.ismyaccountexists();
   System.out.println("teargetpage is :"+targetpage);
   if(exp_res.equals("Valid"))
   {
	   if(targetpage==true)
	   {
		   myacc=new Myaccountpage(Baseclass.getDriver());
		   myacc.clicklogout();
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   Assert.assertTrue(false);
	   }
   }
   if(exp_res.equals("Invalid"))
   {
	   if(targetpage==true)
	   {
		   myacc.clicklogout();
		   Assert.assertTrue(false);
	   }
	   else
	   {
		   Assert.assertTrue(true);
	   }
   }
   }
   catch(Exception e)
   {
	   Assert.assertTrue(false);
	   
   }
   
   
     
     
}


	
}
