package com.cg.stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterForNaukriStepDefinition {
	private WebDriver driver;
	
	@Given("^user is on naukri home page$")
	public void user_is_on_naukri_home_page() throws Throwable {

		 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.get("https://www.naukri.com");
	}

	@When("^user clicks on 'registration with us' button$")
	public void user_clicks_on_registration_with_us_button() throws Throwable {
		WebElement naukri=driver.findElement(By.xpath("//*[@id=\"p0widget\"]/div/div[1]/div/input"));
	    naukri.click();
	    WebElement fresher=driver.findElement(By.className("action-btn fresh"));
	    fresher.submit();
	
	}

	@Then("^user will be redirected to fresher registration$")
	public void user_will_be_redirected_to_fresher_registration() throws Throwable {
	   
	}



}
