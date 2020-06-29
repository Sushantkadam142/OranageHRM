package HRM;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ObjectRepository.JobTitleObj;
import ObjectRepository.LoginLogouobj;
import Resources.Base;

public class AddJobTitle extends Base
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
public void AddingJobTitle(String jobtitle, String jobdescription)
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
	JobTitleObj job =new JobTitleObj(driver);
	job.MainAdmin().click();
	job.MenuJob().click();
	job.MenuJobTitle().click();
	Assert.assertTrue(job.DisplayText().isDisplayed());
	log.info("Landed on "+job.DisplayText().getText()+ "page.");
	job.AddButton().click();
	job.JobTitle().sendKeys(jobtitle);
	job.JobDescription().sendKeys(jobdescription);
	job.SaveButton().click();
	Assert.assertTrue(driver.findElement(By.linkText(jobtitle)).isDisplayed());
	log.info("Successfully Added job title in database.");
}

@DataProvider
public Object[][] getdata()
{
	Object [][] data = new Object[2][2];
	data[0][0]="Software Tester";
	data[0][1]="Software Tester";
	data[1][0]="Software Developer";
	data[1][1]="Software Developer";
	return data;
}
}
