package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.Base;

public class LoginLogouobj extends Base
{
	private By username= By.id("txtUsername");
	private By password= By.name("txtPassword");
	private By loginbtd= By.xpath("//input[@id='btnLogin']");
	private By welcome= By.id("welcome");
	
	public LoginLogouobj(WebDriver driver) 
	{
		this.driver=driver;
	}

	public WebElement UserName()
	{
		return driver.findElement(username);
	}
	
	public WebElement Password()
	{
		return driver.findElement(password);
	}
	
	public WebElement Loginbtd()
	{
		return driver.findElement(loginbtd);
	}
	
	public WebElement WelcomeText()
	{
		return driver.findElement(welcome);
	}


	
}
