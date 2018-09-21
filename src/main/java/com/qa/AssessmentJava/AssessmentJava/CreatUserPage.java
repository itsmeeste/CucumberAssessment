package com.qa.AssessmentJava.AssessmentJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreatUserPage 
{
	
	private WebElement username;
	private WebElement password;
	private WebElement confirmPassword;
	private WebElement fullname;
	private WebElement submit;
	
	
	
	public boolean createUser(WebDriver driver,String user,String pass,String confirmPass,String name)
	{
		username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		password = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input"));
		confirmPassword = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input"));
		fullname = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input"));
		submit = driver.findElement(By.xpath("//*[@id=\"yui-gen3-button\"]"));
		if(username == null)
		{
			System.out.println("The username box was null");
			return false;
		}
		if(password == null)
		{
			System.out.println("The password box was null");
			return false;
		}
		if(confirmPassword == null)
		{
			System.out.println("The confirm password box was null");
			return false;
		}
		if(fullname == null)
		{
			System.out.println("The fullname box was null");
			return false;
		}
		if(submit == null)
		{
			System.out.println("the submit button was null");
			return false;
		}
		username.sendKeys(user);
		password.sendKeys(pass);
		confirmPassword.sendKeys(confirmPass);
		fullname.sendKeys(name);
		
		return true;
		
	}
	public boolean submitUser(WebDriver driver)
	{
		submit = driver.findElement(By.xpath("//*[@id=\"yui-gen3-button\"]"));
		if(submit == null)
		{
			System.out.println("the submit button is not there");
			return false;
		}
		
		submit.click();
		return true;
	}

}
