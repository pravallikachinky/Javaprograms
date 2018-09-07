package com.cg.beans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleLogin {

	@FindBy(how=How.ID,id="lst-ib")
	private WebElement searchEle;
	
	@FindBy(how=How.XPATH,xpath="//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")
	private WebElement button;

	public String getSearchEle() {
		return searchEle.getAttribute("value");
	}

	public void setSearchEle(String searchEle) {
		this.searchEle.sendKeys(searchEle);
	}
	
	public void clickButton() {
		button.click();;
	}
}
