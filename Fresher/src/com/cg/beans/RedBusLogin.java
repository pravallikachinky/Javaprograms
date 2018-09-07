package com.cg.beans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RedBusLogin {

	@FindBy(how=How.ID,id="src")
	private WebElement from;
	
	@FindBy(how=How.ID,id="dest")
	private WebElement to;
	
	@FindBy(how=How.ID,id="onward_cal")
	private WebElement onward;
	
	@FindBy(how=How.ID,id="return_cal")
	private WebElement ret;
	
	@FindBy(how=How.XPATH,xpath="//*[@id=\"search\"]/div/div[1]/div/ul/li[1]")
	private WebElement from1;
	
	@FindBy(how=How.XPATH,xpath="//*[@id=\"search\"]/div/div[2]/div/ul/li[1]")
	private WebElement to1;
	
	@FindBy(how=How.XPATH,xpath="//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[6]/td[5]")
	private WebElement onward1;
	
	@FindBy(how=How.XPATH,xpath="//*[@id=\"rb-calendar_return_cal\"]/table/tbody/tr[7]/td[4]")
	private WebElement ret1;
	
	@FindBy(how=How.XPATH,xpath="//*[@id=\"search_btn\"]")
	private WebElement button;

	public String getFrom() {
		return from.getAttribute("value");
	}

	public void setFrom(String from) {
		this.from.sendKeys(from);
	}

	public String getTo() {
		return to.getAttribute("value");
	}

	public void setTo(String to) {
		this.to.sendKeys(to);
	}

	public String getOnward() {
		return onward.getAttribute("value");
	}

	public void setOnward(String onward) {
		this.onward.sendKeys(onward);
	}

	public String getRet() {
		return ret.getAttribute("value");
	}

	public void setRet(String ret) {
		this.ret.sendKeys(ret);
	}
	
	public void clickFrom() {
		from1.click();
	}
	public void clickTo() {
		to1.click();
	}
	public void clickOnward() {
		onward1.click();
	}
	public void clickRet() {
		ret1.click();
	}
	public void clickButton() {
		button.click();
	}
}
