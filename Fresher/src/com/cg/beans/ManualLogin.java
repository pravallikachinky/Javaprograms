package com.cg.beans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ManualLogin {

	@FindBy(how=How.ID,id="user")
	private WebElement username;
	
	@FindBy(how=How.ID,id="pass")
	private WebElement password;
	
	@FindBy(how=How.XPATH,xpath="/html/body/form/button")
	private WebElement click1;

	public String getUsername() {
		return username.getAttribute("value");
	}

	public void setUsername(String username) {
		this.username.sendKeys(username);
	}

	public String getPassword() {
		return password.getAttribute("value");
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public String getClick() {
		return click1.getText();
	}
	
	public void onClick() {
		click1.click();
	}
	
}
