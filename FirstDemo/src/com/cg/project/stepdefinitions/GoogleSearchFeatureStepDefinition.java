package com.cg.project.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.beans.GoogleLogin;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class GoogleSearchFeatureStepDefinition {
   private WebDriver driver;
   private GoogleLogin loginG;
   
   @Before
	public void setUpStepEnv() {
		 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	}
   @Given("^User is on google home page$")
	public void user_is_on_google_home_page() throws Throwable {
	 //  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	   driver=new ChromeDriver();
	   driver.get("https://www.google.com/");
	   loginG=new GoogleLogin();
	   PageFactory.initElements(driver, loginG);
	}

	@When("^User searches for 'Agile Methodology' term$")
	public void user_searches_for_Agile_Methodology_term() throws Throwable {
	  //  WebElement serachElement=driver.findElement(By.id("lst-ib"));
	    //serachElement.sendKeys("Agile Methodology");
	   // serachElement.submit();
		loginG.setSearchEle("Agile Methodology");
		loginG.clickButton();
	}

	@Then("^All pages linked with 'Agile Methodology' should be displayed$")
	public void all_pages_linked_with_Agile_Methodology_should_be_displayed() throws Throwable {
	    String actualTitle=driver.getTitle();
	    String expectedTitle="Agile Methodology - Google Search";
	    
	    Assert.assertEquals(expectedTitle, actualTitle);
	    
	    driver.close();
	}

}
