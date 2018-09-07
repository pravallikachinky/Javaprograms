package com.cg.stepDefinition;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.beans.RedBusLogin;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RedBusBookingStepDefinition {
	private WebDriver driver;
	private RedBusLogin login; 
	
	@Before
	public void setUpStepEnv() {
		 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	}

	@Given("^user is on reb bus page$")
	public void user_is_on_reb_bus_page() throws Throwable {
		// System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.get("https://www.redbus.in");
		   login=new RedBusLogin();
		   PageFactory.initElements(driver, login);
	}

	@When("^user enters required data$")
	public void user_enters_required_data() throws Throwable {
	  /*  WebElement bus=driver.findElement(By.id("txtSource"));
	    bus.sendKeys("Bangalore");
	    WebElement toDest=driver.findElement(By.id("txtDestination"));
	    toDest.sendKeys("Hyderabad");
	    
	    
	  WebElement onwardBus=driver.findElement(By.id("txtOnwardCalendar"));
	  
	    onwardBus.sendKeys("15-Aug-2018");
	    
	    WebElement returnBus=driver.findElement(By.id("txtReturnCalendar"));
	    returnBus.sendKeys("18-Aug-2018");
	 //   WebElement press=driver.findElement(By.className("search-btn searchBuses"));
	 //   press.submit();
	  //  driver.get("https://www.redbus.in/search?fromCityName=Bangalore&toCityName=Hyderabad&fromCityId=122&toCityId=124&busType=Any&opId=0&onward=16-Aug-2018&return=24-Aug-2018");
	  driver.switchTo().alert().dismiss();
	  returnBus.submit();*/
		
		/*WebElement busFrom=driver.findElement(By.id("src"));
		busFrom.sendKeys("Bengaluru");
		Thread.sleep(1000);
		
		busFrom=driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[1]/div/ul/li[1]"));
		busFrom.click();
		
		WebElement busTo=driver.findElement(By.id("dest"));
		busTo.sendKeys("Hyderabad");
		Thread.sleep(1000);
		
		busTo=driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[2]/div/ul/li[1]"));
		busTo.click();
	//	 driver.switchTo().alert().dismiss();
		
		WebElement dateTo=driver.findElement(By.id("onward_cal"));
		dateTo.sendKeys("24-Aug-2018");
		Thread.sleep(1000);
		
		dateTo=driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[6]/td[5]"));
		dateTo.click();
		
		WebElement dateFrom=driver.findElement(By.id("return_cal"));
		dateFrom.sendKeys("30-Aug-2018");
		Thread.sleep(1000);
		
		dateFrom=driver.findElement(By.xpath("//*[@id=\"rb-calendar_return_cal\"]/table/tbody/tr[7]/td[4]"));
		dateFrom.click();
		
		WebElement button=driver.findElement(By.xpath("//*[@id=\"search_btn\"]"));
		button.click();
*/
		
		login.setFrom("Bengaluru");
		Thread.sleep(1000);
		login.clickFrom();
	
		login.setTo("Hyderabad");
		Thread.sleep(1000);
		login.clickTo();
		
		login.setOnward("24-Aug-2018");
		Thread.sleep(1000);
		login.clickOnward();
		
		login.setRet("30-Aug-2018");
		Thread.sleep(1000);
		login.clickRet();
		
		login.clickButton();
	
	}

	@Then("^it gives all buses related to it$")
	public void it_gives_all_buses_related_to_it() throws Throwable {
	   String actualError=driver.getTitle();
	   String expectedError="Search Bus Tickets";
	   assertEquals(actualError, expectedError);
	   driver.close();
	}


}
