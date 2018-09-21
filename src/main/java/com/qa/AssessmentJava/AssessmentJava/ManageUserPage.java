package com.qa.AssessmentJava.AssessmentJava;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageUserPage
{
	private WebElement manageUserButton;
	private WebElement checkUsername;
	private WebElement profileName;
	
	public boolean clickCreateUser(WebDriver driver)
	{
		manageUserButton = driver.findElement(By.xpath("//*[@id=\"tasks\"]/div[3]/a[2]"));
		
		if(manageUserButton == null)
		{
			System.out.println("The manage user button was not found");
			return false;
		}
		manageUserButton.click();
		return true;
	}
	
	public boolean checkUserName(WebDriver driver,String username)
	{
		String user = "someone";
		if(username != "")
		{
			user = username;
		}
		checkUsername = driver.findElement(By.linkText(user));
		if(checkUsername == null)
		{
			System.out.println("The username wasnt found");
			return false;
			
		}
		System.out.println(checkUsername.getText());
		System.out.println("was found");
		return true;
	}
	
	public boolean clickUsername(String username,WebDriver driver)
	{
		System.out.println("Click Username: " + username);
		checkUsername = driver.findElement(By.linkText(username));
		ArrayList<WebElement> elements =(ArrayList<WebElement>) driver.findElements(By.linkText(username));
		System.out.println(elements.size());
		if(checkUsername == null)
		{
			System.out.println("The username wasnt found");
			return false;
			
		}
		if(elements.size() > 1)
			elements.get(1).click();
		else
			checkUsername.click();
		return true;
	}
	
	public boolean checkProfile(String username,WebDriver driver)
	{
		username = username.toLowerCase();
		profileName = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/div[2]"));
		int index = profileName.getText().indexOf("Id: ");
		String name = profileName.getText().substring(index+4);
		name = name.toLowerCase();
		System.out.println("Name: " +name + " Length " + name.length());
		System.out.println("Username: " +username+ " Length " + username.length());
		
		
		
		if(name.equals(username))
			return true;
		else 
			return false;
	}
	
	
	public boolean configureUserClick(WebDriver driver)
	{
		WebElement configButton;
		configButton = driver.findElement(By.xpath("//*[@id=\"tasks\"]/div[4]/a[2]"));
		if(configButton == null)
			return false;
		configButton.click();
		return true;
	}
	public boolean checkPageTitle(WebDriver driver, String title)
	{
		WebElement titleText = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/h1"));
		String text = titleText.getText() + " [Jenkins]";
		if(text.equals(title))
			return true;
		
		return false;
	}
	public boolean changeEmail(String email,WebDriver driver)
	{
		WebElement emailField;
		
		emailField = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/form/table/tbody/tr[1]/td[3]/input"));
		if(emailField == null)
			return false;
		emailField.clear();
		emailField.sendKeys(email);
		
		return true;
		
	}
	public boolean saveNewEmail(WebDriver driver)
	{
		WebElement submit;
		submit = driver.findElement(By.xpath("//*[@id=\"yui-gen5-button\"]"));
		if(submit == null)
			return false;
		submit.click();
		return true;
		
	}
	
	public boolean checkEmail(String arg1,WebDriver driver)
	{
		WebElement textbox;
		textbox = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/form/table/tbody/tr[1]/td[3]/input"));
		System.out.println("Email: " +textbox.getText());
		System.out.println("Arg1 " + arg1);
		if(textbox.getAttribute("value").equals(arg1))
			return true;
		else 
			return false;
	}
	

}
