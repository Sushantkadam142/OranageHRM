package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Resources.Base;

public class UserMnagementobj extends Base
{
	private By viewAdmin= By.id("menu_admin_viewAdminModule");
	private By menuUserManagement=By.id("menu_admin_UserManagement");
	private By menuUsers = By.id("menu_admin_viewSystemUsers");
	private By textName = By.id("searchSystemUser_userName");
	private By Searchbtn = By.id("searchBtn");
	private By btnAdd = By.id("btnAdd");
	private By UserType=By.id("systemUser_userType");
	private By empname=By.id("systemUser_employeeName_empName");
	private By username = By.name("systemUser[userName]");
	private By pwd = By.id("systemUser_password");
	private By confompwd = By.id("systemUser_confirmPassword");
	private By userstatus= By.id("systemUser_status");
	private By btnSave = By.id("btnSave");


public UserMnagementobj(WebDriver driver)
{
	this.driver=driver;
}

public WebElement MainAdmin()
{
	return driver.findElement(viewAdmin);
}

public WebElement MenuUserManagement()
{
	return driver.findElement(menuUserManagement);
}

public WebElement MenuUsers()
{
	return driver.findElement(menuUsers);
}
public WebElement SearchName()
{
	return driver.findElement(textName);
}
public WebElement SearchButton()
{
	return driver.findElement(Searchbtn);
}

public WebElement AddButton()
{
	return driver.findElement(btnAdd);
}

public WebElement EmployeeName()
{
	return driver.findElement(empname);
}
public WebElement Password()
{
	return driver.findElement(pwd);
}

public WebElement DroupDownUserType()
{
	return driver.findElement(UserType);
}

public WebElement UserName()
{
	return driver.findElement(username);
}

public WebElement UserStatus()
{
	return driver.findElement(userstatus);
}
public WebElement SaveButton()
{
	return driver.findElement(btnSave);
}

public WebElement ConformPassword()
{
	return driver.findElement(confompwd);
}

}