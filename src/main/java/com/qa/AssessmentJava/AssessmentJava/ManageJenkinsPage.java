package com.qa.AssessmentJava.AssessmentJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageJenkinsPage 
{
	private WebElement manageUsers;
	
	
	public boolean clickManageUsers(WebDriver driver)
	{
		manageUsers = driver.findElement(By.xpath("//*[@id=\"management-links\"]/tbody/tr[15]/td[2]/div[1]/a"));
		// Check to see if manage users is null
		if(manageUsers == null)
		{
			System.out.println("Manage users was null");
			return false;
		}
		manageUsers.click();
		return true;
	}

}
