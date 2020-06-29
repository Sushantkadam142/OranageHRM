package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.Base;

public class JobTitleObj extends Base
{
public JobTitleObj(WebDriver driver)
{
	this.driver=driver;
}

private By viewAdmin= By.id("menu_admin_viewAdminModule");
private By menujob = By.id("menu_admin_Job");
private By menujobtile =By.id("menu_admin_viewJobTitleList");
private By btnAdd =By.name("btnAdd");
private By jobTitle =By.xpath("//input[@id='jobTitle_jobTitle']");
private By jobDescription = By.cssSelector("#jobTitle_jobDescription");
private By btnSave = By.id("btnprivateSave");
private By displaytext=By.xpath("//h1[contains(text(),'Job Titles')]");

public WebElement MainAdmin()
{
	return driver.findElement(viewAdmin);
}

public WebElement MenuJob()
{
	return driver.findElement(menujob);
}

public WebElement MenuJobTitle()
{
	return driver.findElement(menujobtile);
}
public WebElement AddButton()
{
	return driver.findElement(btnAdd);
}
public WebElement JobTitle()
{
	return driver.findElement(jobTitle);
}
public WebElement JobDescription()
{
	return driver.findElement(jobDescription);
}
public WebElement SaveButton()
{
	return driver.findElement(btnSave);
}

public WebElement DisplayText()
{
	return driver.findElement(displaytext);
}
}
