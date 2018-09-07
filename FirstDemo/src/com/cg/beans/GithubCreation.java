package com.cg.beans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GithubCreation {

	@FindBy(how=How.ID,id="user_login")
	private WebElement username;
	
	@FindBy(how=How.ID,id="user_email")
	private WebElement email;
	
	@FindBy(how=How.ID,id="user_password")
	private WebElement password;
	
	@FindBy(how=How.ID,id="signup_button")
	private WebElement button;

	public String getButton() {
		return button.getText();
	}

	public String getUsername() {
		return username.getAttribute("value");
	}

	public void setUsername(String username) {
		this.username.sendKeys(username);
	}

	public String getEmail() {
		return email.getAttribute("value");
	}

	public void setEmail(String email) {
		this.email.sendKeys(email);
	}

	public String getPassword() {
		return password.getAttribute("value");
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickIn() {
		button.click();
	}
	
	
}
