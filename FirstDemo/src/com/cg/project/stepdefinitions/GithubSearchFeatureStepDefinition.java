package com.cg.project.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.beans.LoginPage;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GithubSearchFeatureStepDefinition {
	private WebDriver driver;
	private LoginPage loginPage;
	
	@Before
	public void setUpStepEnv() {
		 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	}
	
@Given("^user is on the homepage of 'Github'$")
public void user_is_on_the_homepage_of_Github() throws Throwable {
	driver=new ChromeDriver();
	driver.get("https://github.com/login");
       loginPage=new LoginPage();
       PageFactory.initElements(driver, loginPage);
}

@When("^user enters valid login credentials$")
public void user_enters_valid_login_credentials() throws Throwable {
	/* WebElement serachElement=driver.findElement(By.id("login_field"));
	 WebElement serachElement1=driver.findElementchinkygilla96(By.id("password"));
	 serachElement.sendKeys("chinkygilla96@gmail.com");
	 serachElement1.sendKeys("cHINKY@123");
	 serachElement1.submit();
	 WebElement s=driver.findElement(By.linkText("pravallikachinky"));
	 s.click();*/
	loginPage.setUsername("chinkygilla96@gmail.com");
	loginPage.setPassword("cHINKY@123");
	loginPage.button();
	
}

@Then("^user should login to 'Github account'$")
public void user_should_login_to_Github_account() throws Throwable {
	//String actualTitle=driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[3]/details/details-menu/ul/li[1]/a/strong")).getText();
	String expectedT="";
	
	Assert.assertEquals(expectedT,loginPage.getActualErrorMessage());
	
    
}

@When("^user enters invalid login credentials$")
public void user_enters_invalid_login_credentials() throws Throwable {
	/*WebElement serachElement=driver.findElement(By.id("login_field"));
	 WebElement serachElement1=driver.findElement(By.id("password"));
	 serachElement.sendKeys("");
	 serachElement1.sendKeys("");
	 serachElement1.submit();
*/
	loginPage.setUsername("chinkygilla96@gmail.com");
	loginPage.setPassword("cHINKY@12389");
	loginPage.button();
}

@Then("^user shouldnot login to 'Github account'$")
public void user_shouldnot_login_to_Github_account() throws Throwable {
   
//	String actualTitle=driver.findElement(By.xpath(""
	//		+ "//*[@id=\"js-flash-container\"]/div/div")).getText();
	String expectedT="Incorrect username or password.";
	
	Assert.assertEquals(expectedT, loginPage.getActualErrorMessageInvalid());
	
}


}
