package com.cg.project.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.beans.AmazonPage;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonSearchFeatureStepDefinition {
	private WebDriver driver;
	private AmazonPage amPage;
	@Before
	public void setUpStepEnv() {
		 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	}
	
	@Given("^User will be on homepage of 'Amazon'$")
	public void user_will_be_on_homepage_of_Amazon() throws Throwable {
		  // System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.get("https://www.amazon.in/");
		   amPage=new AmazonPage();
		   PageFactory.initElements(driver, amPage);

	}

	@When("^User enter particular phone$")
	public void user_enter_particular_phone() throws Throwable {
		//WebElement amazon=driver.findElement(By.id("twotabsearchtextbox"));
		// amazon.sendKeys("redmi note 4");
		// amazon.submit();
		amPage.setAmazon("redmi note 4");
		amPage.clickIn();
	}

	@Then("^User should find related links on 'Amazon'$")
	public void user_should_find_related_links_on_Amazon() throws Throwable {
	 //   String actual=driver.findElement(By.xpath("//*[@id=\"bcKwText\"]/span")).getText();
	    String expected="\"redmi note 4\"";
		//String actual=driver.getTitle();
		//String expected="Amazon.in: redmi note 4 - Smartphones / Smartphones & Basic Mobiles: Electronics";
		Assert.assertEquals(expected, amPage.getActualerror());
		driver.close();

	}
	 

}
