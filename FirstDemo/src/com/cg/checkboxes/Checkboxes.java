package com.cg.checkboxes;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Checkboxes {
	public static void main(String[] args) throws InterruptedException {
		System.getProperty("webdriver.chrome.driver");
      //  checkBoxTest();
		//radioBoxTest();
		selectBoxTest();
	}
	
	private static void checkBoxTest() throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		driver.get("D:\\html\\CheckboxTest.html");
		WebElement checkbox=driver.findElement(By.id("mayoCheckbox"));
		Thread.sleep(1000);
		checkbox.click();
		
		if(checkbox.isSelected())
			System.out.println("value of checkbox:" +checkbox.getAttribute("value"));
		
	}
	private static void radioBoxTest() throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		driver.get("D:\\html\\radioButton.html");
		By elements=By.name("color");
		List<WebElement> radioButtons=driver.findElements(elements);
		
		WebElement radioBtn=radioButtons.get(1);
		
		radioBtn.click();
		WebElement radioBtn1=radioButtons.get(2);
		
		radioBtn1.click();

		
		for(WebElement radioButton:radioButtons) {
			if(radioButton.isSelected()) {
				System.out.println(radioButton.getAttribute("value"));
			}
		}
	}
	private static void selectBoxTest() throws InterruptedException{
		WebDriver driver=new ChromeDriver();
		driver.get("D:\\html\\SelectBox.html");
		WebElement selectElement=driver.findElement(By.id("select1"));
		Select select=new Select(selectElement);
		//select.selectByIndex(1);
		select.selectByVisibleText("Maybe");
		
		
	}
}
