package HRM;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjectRepository.LoginLogouobj;
import ObjectRepository.UserMnagementobj;
import Resources.Base;

public class AddUser extends Base
{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void beforetest() throws IOException
	{
		log.debug("Intializing DriverInitilize method.");
		driver = DriverInitilize();
		log.debug("Now hitting URL");
		driver.get(prop.getProperty("URL"));
		log.info("Landed on OrangeHRM login Page.");
	}
	
	@AfterTest
	public void aftertest()
	{
		log.debug("Closing driver after test case execution.");
		driver.close();
		driver = null;
		log.info("Diver closeed sucessfully.");
	}
	@Test
	public void creatnewuser()
	{
		LoginLogouobj login = new LoginLogouobj(driver);
		login.UserName().sendKeys(prop.getProperty("Username"));
		login.Password().sendKeys(prop.getProperty("password"));
		login.Loginbtd().click();
		Assert.assertTrue(login.WelcomeText().getText().contains(prop.getProperty("Username")));
		log.info("Successfully Login into aplication with "+prop.getProperty("Username"));
		UserMnagementobj ursman = new UserMnagementobj(driver);
		
		Actions a = new Actions(driver);
		a.moveToElement(ursman.MainAdmin()).perform();
		a.moveToElement(ursman.MenuUserManagement()).perform();
		ursman.MenuUsers().click();
		ursman.AddButton().click();
		

		log.info("Landed on User Management page.");
		
		Select s = new Select(ursman.DroupDownUserType());
		s.selectByIndex(1);
		ursman.EmployeeName().sendKeys("Fiona Grace");
		ursman.UserName().sendKeys("fiona_123");
		Select b = new Select(ursman.UserStatus());
		b.selectByIndex(1);
		ursman.Password().sendKeys("Pass$123");
		ursman.ConformPassword().sendKeys("Pass$123");
		ursman.SaveButton().click();
		log.info("Sucessfully added new user");
		
	}
}
