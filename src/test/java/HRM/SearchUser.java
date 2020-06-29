package HRM;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ObjectRepository.LoginLogouobj;
import ObjectRepository.UserMnagementobj;
import Resources.Base;

public class SearchUser extends Base
{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void beforetest() throws IOException
	{
		log.debug("Intializing DriverInitilize method.");
		driver = DriverInitilize();	
	}
	
	@AfterTest
	public void aftertest()
	{
		log.debug("Closing driver after test case execution.");
		driver.close();
		driver = null;
		log.info("Diver closeed sucessfully.");
	}
	
	@Test(dataProvider="getdata")
	public void SearchUsername(String username, String hint)
	{
		log.debug("Now hitting URL");
		driver.get(prop.getProperty("URL"));
		log.info("Landed on OrangeHRM login Page.");
		LoginLogouobj login = new LoginLogouobj(driver);
		login.UserName().sendKeys(prop.getProperty("Username"));
		login.Password().sendKeys(prop.getProperty("password"));
		login.Loginbtd().click();
		Assert.assertTrue(login.WelcomeText().getText().contains(prop.getProperty("Username")));
		log.info("Successfully Login into aplication with "+prop.getProperty("Username"));
		
		UserMnagementobj user = new UserMnagementobj(driver);
		Actions a = new Actions(driver);
		a.moveToElement(user.MainAdmin()).perform();
		a.moveToElement(user.MenuUserManagement()).perform();
		user.MenuUsers().click();
		log.info("Landed on User Management page.");
		
		user.SearchName().sendKeys(username);
		user.SearchButton().click();
		log.info("Search funcationality of user working properly.");
	}
	
	@DataProvider(name="getdata")
	public Object[][] getdata()
	{
		Object [][] data = new Object[3][2];
//		String data[]= new String[2];
		data[0][0]="john.smith";
		data[0][1]="John Smith";
		data[1][0]="steven.edwards";
		data[1][1]="Steven Edwards";
		data[2][0]="robert.craig";
		data[2][1]="Robert Craig";
		return data;
	}
}
