package com.qa.AssessmentJava.AssessmentJava;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepJenkins 
{
	WebDriver driver;
	
	@Before
	public void startUp()
	{
		System.setProperty("webdriver.chrome.driver",Constants.CHROMEDRIVER);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		ReportUtil.startReport();
	}
	@After
	public void tearDown()
	{
		driver.close();
		driver.quit();
		ReportUtil.EndReport();
	}
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() throws Throwable {
		// Go to the url
		ReportUtil.createTest("NavigateToUserPage");
		driver.get(Constants.URL);
		Homepage page = new Homepage();
		ReportUtil.logTestWithScreenShot(LogStatus.INFO, "Started Navigation to User Page with screenShot", driver);
		boolean check = false;
		check =page.loginToJenkins(driver);
		
		if(check)
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "Navigate to user");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, "none");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "Pass");
			ReportUtil.logTestWithScreenShot(LogStatus.INFO, "Logged into jenkins", driver);
			Assert.assertTrue(check);
		}
		else
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "Navigate to user");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, "none");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "failed");
			ReportUtil.logTestWithScreenShot(LogStatus.FAIL, "Failed to login to jenkins", driver);
			Assert.assertTrue(check);
		}
		
		driver.get(Constants.URLManage);
		ReportUtil.logTestWithScreenShot(LogStatus.INFO, "Navigated to the manage page", driver);
		
		
		ManageJenkinsPage manageJenkins = new ManageJenkinsPage();
		check = manageJenkins.clickManageUsers(driver);
		if(check)
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "Navigated to the manage user page");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, "none");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "Pass");
			ReportUtil.logTestWithScreenShot(LogStatus.INFO, "Navigated to the manage user page", driver);
			Assert.assertTrue(check);
		}
		else
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "Navigated to the manage user page");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, "none");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "failed");
			ReportUtil.logTestWithScreenShot(LogStatus.FAIL, "Did not find the button for the link to manage users", driver);
			Assert.assertTrue(check);
		}
		
		ManageUserPage manageUsers = new ManageUserPage();
		check = manageUsers.clickCreateUser(driver);
		if(check)
		{
			ReportUtil.logTestWithScreenShot(LogStatus.INFO, "Clicked create user", driver);
			Assert.assertTrue(check);
		}
		else
		{
			ReportUtil.logTestWithScreenShot(LogStatus.FAIL, "Failed to click the create user button", driver);
			Assert.assertTrue(check);
		}
		
		ReportUtil.logTestWithScreenShot(LogStatus.PASS, "Went to the create user screen", driver);
		ReportUtil.EndTest();
		
		
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() throws Throwable 
	{
		ReportUtil.createTest("EnterUserInfo");
		CreatUserPage createUser = new CreatUserPage();
		boolean check = false;
		check = createUser.createUser(driver, "someone", "pass", "pass", "someones");
		if(check)
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "Entered user info");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, "someone, " + "pass, "+ "pass, "+ "someones");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "Pass");
			ReportUtil.logTestWithScreenShot(LogStatus.INFO, "Entered user info", driver);
			Assert.assertTrue(check);
		}
		else
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "Entered user info");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, "someone, " + "pass, "+ "pass, "+ "someones");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "failed");
			ReportUtil.logTestWithScreenShot(LogStatus.FAIL, "Failed to Enter user info", driver);
			Assert.assertTrue(check);
		}
		
		Assert.assertTrue(check);
		ReportUtil.logTestWithScreenShot(LogStatus.PASS, "details was entered on the user screen", driver);
		ReportUtil.EndTest();
	    // Write code here that turns the phrase above into concrete action
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() throws Throwable 
	{
		ReportUtil.createTest("Submitted user info");
		CreatUserPage createUser = new CreatUserPage();
		
		boolean check = false;
		check =createUser.submitUser(driver); 
		if(check)
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "Submitted user info");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, "none");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "Pass");
			ReportUtil.logTestWithScreenShot(LogStatus.INFO, "Submitted user info", driver);
			Assert.assertTrue(check);
		}
		else
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "Submitted user info");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, "none");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "failed");
			ReportUtil.logTestWithScreenShot(LogStatus.FAIL, "Failed to submit user info", driver);
			Assert.assertTrue(check);
		}
		Assert.assertTrue(check);
		ReportUtil.logTestWithScreenShot(LogStatus.PASS, "user info submitted", driver);
		ReportUtil.EndTest();
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() throws Throwable {
		ReportUtil.createTest("Username is visable");
		boolean check = false;
	    // Write code here that turns the phrase above into concrete actions
		ManageUserPage manageUsers = new ManageUserPage();
		check = manageUsers.checkUserName(driver,"");
		if(check)
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "username is there");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, "none");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "Pass");
			ReportUtil.logTestWithScreenShot(LogStatus.INFO, "username is there", driver);
			Assert.assertTrue(check);
		}
		else
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "username is there");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, "none");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "failed");
			ReportUtil.logTestWithScreenShot(LogStatus.FAIL, "username is not there", driver);
			Assert.assertTrue(check);
		}
		Assert.assertTrue(check);
		ReportUtil.logTestWithScreenShot(LogStatus.PASS, "Found the username ", driver);
		ReportUtil.EndTest();
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, \"([^\"]*)\" Fullname and \"([^\"]*)\" EmailAddress are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_Fullname_and_EmailAddress_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ReportUtil.createTest("EnterUserInfo with params");
		boolean check = false;
		CreatUserPage createUser = new CreatUserPage();
		check =createUser.createUser(driver, arg1, arg2, arg3, arg4); 
		
		if(check)
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "entered user info with params");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4);
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "Pass");
			ReportUtil.logTestWithScreenShot(LogStatus.INFO, "Entered user info", driver);
			Assert.assertTrue(check);
		}
		else
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "entered user info with params");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4);
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "fail");
			ReportUtil.logTestWithScreenShot(LogStatus.FAIL, "Failed to Enter user info", driver);
			Assert.assertTrue(check);
		}
		
		
		Assert.assertTrue(check);
		ReportUtil.logTestWithScreenShot(LogStatus.PASS, "entered the data ", driver);
		ReportUtil.EndTest();
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ReportUtil.createTest("Username Visable on userscreen");
		ManageUserPage manageUsers = new ManageUserPage();
		System.out.println("got to this point");
		boolean check = manageUsers.checkUserName(driver,arg1);
		if(check)
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "Username Visable on userscreen");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, arg1);
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "Pass");
			ReportUtil.logTestWithScreenShot(LogStatus.INFO, "username was found", driver);
			Assert.assertTrue(check);
		}
		else
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "Username Visable on userscreen");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, arg1);
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "fail");
			ReportUtil.logTestWithScreenShot(LogStatus.FAIL, "Failed to find username", driver);
			Assert.assertTrue(check);
		}
		Assert.assertTrue(check);
		ReportUtil.logTestWithScreenShot(LogStatus.PASS, "Found the username ", driver);
		ReportUtil.EndTest();
	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ReportUtil.createTest("Check if username is visable :3");
		driver.get(Constants.URL);
		ReportUtil.logTestWithScreenShot(LogStatus.INFO, "gone to homepage", driver);
		Homepage page = new Homepage();
		page.loginToJenkins(driver);
		ReportUtil.logTestWithScreenShot(LogStatus.INFO, "logged in", driver);
		driver.get(Constants.URLManage);
		ManageJenkinsPage manageJenkins = new ManageJenkinsPage();
		ReportUtil.logTestWithScreenShot(LogStatus.INFO, "gone to manage users page", driver);
		manageJenkins.clickManageUsers(driver);
		ManageUserPage manageUsers = new ManageUserPage();
		boolean check = manageUsers.checkUserName(driver,arg1);
		if(check)
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "gone to manage users page");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, arg1);
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "Pass");
			ReportUtil.logTestWithScreenShot(LogStatus.INFO, "name is visable", driver);
			Assert.assertTrue(check);
		}
		else
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "gone to manage users page");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, arg1);
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "fail");
			ReportUtil.logTestWithScreenShot(LogStatus.FAIL, "name is not there", driver);
			Assert.assertTrue(check);
		}
		Assert.assertTrue(check);
		ReportUtil.logTestWithScreenShot(LogStatus.PASS, "Found the username ", driver);
		ReportUtil.EndTest();
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ReportUtil.createTest("Clicked on the username");
		ManageUserPage manageUsers = new ManageUserPage();
		
		boolean check = manageUsers.clickUsername(arg1, driver);
		if(check)
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "Clicked on the username");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, arg1);
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "Pass");
			ReportUtil.logTestWithScreenShot(LogStatus.INFO, "clicked on the username", driver);
			Assert.assertTrue(check);
		}
		else
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "Clicked on the username");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, arg1);
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "fail");
			ReportUtil.logTestWithScreenShot(LogStatus.FAIL, "failed to click on the username", driver);
			Assert.assertTrue(check);
		}
		Assert.assertTrue(check);
		ReportUtil.logTestWithScreenShot(LogStatus.PASS, "username was clicked and working ", driver);
		ReportUtil.EndTest();
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ReportUtil.createTest("Check username on profile");
		ManageUserPage manageUsers = new ManageUserPage();
		System.out.println("sdfsdfsdfsdf    " + arg1);
		boolean check = manageUsers.checkProfile(arg1,driver);
		if(check)
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "Check username on profile");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, arg1);
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "Pass");
			ReportUtil.logTestWithScreenShot(LogStatus.INFO, "name was found", driver);
			Assert.assertTrue(check);
		}
		else
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "Check username on profile");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, arg1);
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "fail");
			ReportUtil.logTestWithScreenShot(LogStatus.FAIL, "name not found", driver);
			Assert.assertTrue(check);
		}
		ReportUtil.EndTest();
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ReportUtil.createTest("profile page been loaded");
		
		driver.get(Constants.URL);
		Homepage page = new Homepage();
		page.loginToJenkins(driver);
		ReportUtil.logTestWithScreenShot(LogStatus.INFO, "logged into jenkins", driver);	
		driver.get(Constants.URLManage);
		ManageJenkinsPage manageJenkins = new ManageJenkinsPage();
		
		manageJenkins.clickManageUsers(driver);
		ReportUtil.logTestWithScreenShot(LogStatus.INFO, "clicked on users", driver);
		ManageUserPage manageUsers = new ManageUserPage();
		manageUsers.clickUsername(arg1, driver);
		boolean check = manageUsers.checkPageTitle(driver, driver.getTitle());
		if(check)
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "clicked on users");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, arg1);
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "Pass");
			ReportUtil.logTestWithScreenShot(LogStatus.INFO, "page title was the same", driver);
			Assert.assertTrue(check);
		}
		else
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "clicked on users");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, arg1);
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "fail");
			ReportUtil.logTestWithScreenShot(LogStatus.FAIL, "page title was not the same", driver);
			Assert.assertTrue(check);
		}
		ReportUtil.EndTest();
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ReportUtil.createTest("configure was clicked");
		ManageUserPage manageUsers = new ManageUserPage();
		boolean check = manageUsers.configureUserClick(driver);
		if(check)
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "the configure button has been clicked on the profile page");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, "none");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "Pass");
			ReportUtil.logTestWithScreenShot(LogStatus.INFO, "config was clicked", driver);
			Assert.assertTrue(check);
		}
		else
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "the configure button has been clicked on the profile page");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, "none");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "fail");
			ReportUtil.logTestWithScreenShot(LogStatus.FAIL, "config not clicked", driver);
			Assert.assertTrue(check);
		}
		ReportUtil.EndTest();
	}

	@When("^I change the old email address on the Configure Page to a new email address \"([^\"]*)\"$")
	public void i_change_the_old_email_address_on_the_Configure_Page_to_a_new_email_address(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ReportUtil.createTest("Change email");
	    ManageUserPage manageUsers = new ManageUserPage();
	    boolean check = manageUsers.changeEmail(arg1, driver);
	    if(check)
		{
	    	Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "I change the old email address on the Configure Page to a new email address");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, arg1);
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "Pass");
			ReportUtil.logTestWithScreenShot(LogStatus.INFO, "email changed", driver);
			Assert.assertTrue(check);
		}
		else
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "I change the old email address on the Configure Page to a new email address");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, arg1);
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "fail");
			ReportUtil.logTestWithScreenShot(LogStatus.FAIL, "email not changed", driver);
			Assert.assertTrue(check);
		}
		ReportUtil.EndTest();
	    
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ReportUtil.createTest("save email change");
		ManageUserPage manageUsers = new ManageUserPage();
	    boolean check = manageUsers.saveNewEmail(driver);
	    if(check)
		{
	    	Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "I save the changes to the Configure Page");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, "none");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "Pass");
			ReportUtil.logTestWithScreenShot(LogStatus.INFO, "email saved", driver);
			Assert.assertTrue(check);
		}
		else
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "I save the changes to the Configure Page");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, "none");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "fail");
			ReportUtil.logTestWithScreenShot(LogStatus.FAIL, "email not saved", driver);
			Assert.assertTrue(check);
		}
		ReportUtil.EndTest();
	}

	@Then("^the Configure Page should show the new email address \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_new_email_address(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(Constants.SCREENSHOTFILEPATH);
		ReportUtil.createTest("new emails shows");
		ManageUserPage manageUsers = new ManageUserPage();
		manageUsers.configureUserClick(driver);
		boolean check = manageUsers.checkEmail(arg1, driver);
		if(check)
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "the Configure Page should show the new email address");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, arg1);
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "Pass");
			ReportUtil.logTestWithScreenShot(LogStatus.INFO, "new email was shown", driver);
			Assert.assertTrue(check);
		}
		else
		{
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 0, "the Configure Page should show the new email address");
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.getRow(), 1, arg1);
			Utils.SetCellAndSaveString(Constants.TESTEXCEL, 0, Utils.increaseRow(), 2, "fail");
			ReportUtil.logTestWithScreenShot(LogStatus.FAIL, "new email not shown", driver);
			Assert.assertTrue(check);
		}
		ReportUtil.EndTest();
	}

}
