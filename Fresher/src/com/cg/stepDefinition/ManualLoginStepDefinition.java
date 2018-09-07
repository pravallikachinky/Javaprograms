package com.cg.stepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.beans.ManualLogin;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManualLoginStepDefinition {
	private WebDriver driver;
	private ManualLogin loginM;
	
	@Before
	public void setUpStepEnv() {
		 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	}

	@Given("^user is on Loginpage$")
	public void user_is_on_Loginpage() throws Throwable {
		  driver=new ChromeDriver();
		   driver.get("file:///D:/html/BDDpage.html");
		   loginM=new ManualLogin();
		   PageFactory.initElements(driver, loginM);
	}

	@When("^user enter valid username and password$")
	public void user_enter_valid_username_and_password() throws Throwable {
	   loginM.setUsername("hello");
	   loginM.setPassword("chinky");
	   Thread.sleep(1000);
	   loginM.onClick();
	}

	@Then("^user logins successfully$")
	public void user_logins_successfully() throws Throwable {
      // String actual=driver.findElement(By.xpath("/html/body")).getText();
		String actual=driver.switchTo().alert().getText();
       String expected="login successful";
       assertEquals(expected, actual);
	}

	@When("^user enter invalid username and password$")
	public void user_enter_invalid_username_and_password() throws Throwable {
		 loginM.setUsername("");
		   loginM.setPassword("chinky");
		   Thread.sleep(1000);
		   loginM.onClick();


	}

	@Then("^user login fails$")
	public void user_login_fails() throws Throwable {
		//String actual=driver.findElement(By.xpath("/html/body")).getText();
		String actual=driver.switchTo().alert().getText();
	    String expected="enter valid name and password";
	    assertEquals(expected, actual);

	}


}
