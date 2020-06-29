package HRM;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ObjectRepository.LoginLogouobj;
import Resources.Base;

public class LoginLogout extends Base
{
	public static Logger log = LogManager.getLogger(Base.class.getName());
@Test(dataProvider="getDate")
public void Login(String name, String pwd) throws IOException
{
	log.debug("Now hitting URL");
	driver.get(prop.getProperty("URL"));
	log.info("Landed on OrangeHRM login Page.");
	LoginLogouobj logobj= new LoginLogouobj (driver);
	logobj.UserName().sendKeys(name);
	logobj.Password().sendKeys(pwd);
	logobj.Loginbtd().click();
	log.info("Successfully Login into aplication with "+prop.getProperty("Username"));
}

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
@DataProvider
public Object[][] getDate()
{
	Object[][] data = new Object[2][2];
	data[0][0] = "Adamin";
	data[0][1] = "Adamin";
	
	data[1][0] = "Admin";
	data[1][1] = "admin123";
	return data;
}
}
