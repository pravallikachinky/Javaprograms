package com.cg.beans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AmazonPage {

	@FindBy(how=How.ID,id="twotabsearchtextbox")
	private WebElement amazon;
	
	@FindBy(className="nav-input")
	private WebElement button;

    @FindBy(how=How.XPATH,xpath="//*[@id=\"bcKwText\"]/span")
	private WebElement actualerror;
		
	
	
	
	public String getActualerror() {
		return actualerror.getText();
	}

	public String getAmazon() {
		return amazon.getAttribute("value");
	}

	public void setAmazon(String amazon) {
		this.amazon.sendKeys(amazon);
	}
	
	public void clickIn() {
		button.submit();
	}
	
	
	
}
