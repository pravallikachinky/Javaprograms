package com.cg.project.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.beans.GithubCreation;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GithubAccountCreationFeature {
	private WebDriver driver;
	private GithubCreation creation;
	
	@Before
	public void setUpStepEnv() {
		 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	}

	@Given("^user has to be on signin page of github$")
	public void user_has_to_be_on_signin_page_of_github() throws Throwable {
		// System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.get("https://github.com/join");
		   creation=new GithubCreation();
		   PageFactory.initElements(driver, creation);
	}

	@When("^user enters valid emailid, username, password$")
	public void user_enters_valid_emailid_username_password() throws Throwable {
     /* WebElement user=driver.findElement(By.id("user_login"));
      WebElement email=driver.findElement(By.id("user_email"));
      WebElement password=driver.findElement(By.id("user_password"));
      user.sendKeys("jhczgv");
      email.sendKeys("nciug@gmail.com");
      password.sendKeys("nkjvxhg@79443");
      password.submit();*/
	 
		creation.setUsername("jSHudsafg");
		creation.setEmail("VJHTSf@gmail.com");
		creation.setPassword("VHGrb@986432");
		creation.clickIn();
	}

	@Then("^Github account should be created for user$")
	public void github_account_should_be_created_for_user() throws Throwable {
	    String actual=driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/"
	    		+ "div/div[1]/h1")).getText();
	    String expected="Welcome to GitHub";
	    
	    Assert.assertEquals(expected, actual);
	    driver.close();
		
	}

	@When("^user enters invalid emailid, valid username, password$")
	public void user_enters_invalid_emailid_valid_username_password() throws Throwable {
		/* WebElement user=driver.findElement(By.id("user_login"));
	      WebElement email=driver.findElement(By.id("user_email"));
	      WebElement password=driver.findElement(By.id("user_password"));
	      user.sendKeys("hellohyd1");
	      email.sendKeys("jsadhgf@gmail.com");
	      password.sendKeys("mnDbfkwgfwa@7648");
	      password.submit();*/
		creation.setUsername("hellohyd1");
		creation.setEmail("jsadhgf@gmail.com");
		creation.setPassword("mnDbfkwgfwa@7648");
		creation.clickIn();
		

	}

	@Then("^Github account should not be created for user$")
	public void github_account_should_not_be_created_for_user() throws Throwable {
	    String actual=driver.findElement(By.xpath("//*[@id=\"signup-form\"]/auto-check[1]/dl/dd[2]")).getText();
	    String expected="Login is already taken";	
	    Assert.assertEquals(expected, actual);
	    driver.close();
	}

	@When("^user enters invalid username, valid emailid, password$")
	public void user_enters_invalid_username_valid_emailid_password() throws Throwable {
		/* WebElement user=driver.findElement(By.id("user_login"));
	      WebElement email=driver.findElement(By.id("user_email"));
	      WebElement password=driver.findElement(By.id("user_password"));
	      user.sendKeys("kbgskfdbgkfa");
	      email.sendKeys("hemnadbssss@gmail.com");
	      password.sendKeys("kjczxvgw@8765");
	      password.submit();*/
		creation.setUsername("kbgskfdbgkfa");
		creation.setEmail("hemnadbssss@gmail.com");
		creation.setPassword("kjczxvgw@8765");
		creation.clickIn();
		
	}
	
	@Then("^Github account should not be created for user because of email$")
	public void github_account_should_not_be_created_for_user_because_of_email() throws Throwable {
		 String actual=driver.findElement(By.xpath("//*[@id=\"signup-form\"]/auto-check[2]/dl/dd[2]")).getText();
		   String expected="Email is invalid or already taken";
		   Assert.assertEquals(expected, actual);
		   driver.close();
	}


	@When("^user enters invalid password, valid emailid, username$")
	public void user_enters_invalid_password_valid_emailid_username() throws Throwable {
		/* WebElement user=driver.findElement(By.id("user_login"));
	      WebElement email=driver.findElement(By.id("user_email"));
	      WebElement password=driver.findElement(By.id("user_password"));
	      user.sendKeys("kbgskfdbgkfa");
	      email.sendKeys("jDgflkjfd@gmail.com");
	      password.sendKeys("kJ@26");
	      password.submit();*/
		creation.setUsername("kbgskfdbgkfa");
		creation.setEmail("jDgflkjfd@gmail.com");
		creation.setPassword("kJ@26");
		creation.clickIn();
		
	   
	}
	
	@Then("^Github account should not be created for user because of password$")
	public void github_account_should_not_be_created_for_user_because_of_password() throws Throwable {
	  String actual=driver.findElement(By.xpath("//*[@id=\"signup-form\"]/dl/dd[2]")).getText();
	  String expected="Password is too short (minimum is 7 characters)";
	  Assert.assertEquals(expected, actual);
	  driver.close();
	}
	@When("^user enters invalid password with no number$")
	public void user_enters_invalid_password_with_no_number() throws Throwable {
		/* WebElement user=driver.findElement(By.id("user_login"));
	      WebElement email=driver.findElement(By.id("user_email"));
	      WebElement password=driver.findElement(By.id("user_password"));
	      user.sendKeys("kbgskfdbgkfa");
	      email.sendKeys("jDgflkjfd@gmail.com");
	      password.sendKeys("gnfdsjmhgf");
	      password.submit();*/
		creation.setUsername("kbgskfdbgkfa");
		creation.setEmail("jDgflkjfd@gmail.com");
		creation.setPassword("gnfdsjmhgf");
		creation.clickIn();
	}
	
	@Then("^Github account should not be created beacuse of no numbers$")
	public void github_account_should_not_be_created_beacuse_of_no_numbers() throws Throwable {
	   String actual=driver.findElement(By.xpath("//*[@id=\"signup-form\"]/dl/dd[2]")).getText();
	   String expected="Password needs at least one number";
	   Assert.assertEquals(expected, actual);
	   driver.close();
	}

}
