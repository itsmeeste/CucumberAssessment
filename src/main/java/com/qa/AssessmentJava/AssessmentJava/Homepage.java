package com.qa.AssessmentJava.AssessmentJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage
{	
	private WebElement usernameText;
	
	private WebElement passwordText;
	
	private WebElement submitButton;
	
	
	
	public boolean loginToJenkins(WebDriver driver)
	{
		usernameText = driver.findElement(By.id("j_username"));
		passwordText = driver.findElement(By.name("j_password"));
		submitButton = driver.findElement(By.id("yui-gen1-button"));
		if(usernameText == null)
		{
			System.out.println("Username textbox was null");
			return false;
		}
		if(passwordText == null)
		{
			System.out.println("Password textbox was null");
			return false;
		}
		if(submitButton == null)
		{
			System.out.println("Submit button was null");
			return false;
		}
		
		usernameText.sendKeys(Constants.JENKINSLOGIN);
		passwordText.sendKeys(Constants.JENKINSPASSWORD);
		submitButton.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
			
	}

}
