package Resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class Base 
{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public static WebDriver driver;
	public Properties prop;

	public WebDriver DriverInitilize() throws IOException
	{
		prop = new Properties();
		FileInputStream propfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Environment.properties");
		prop.load(propfile);
		
		
		switch (prop.getProperty("browser"))
		{
		case "Chrome":
			log.info("Selected Google chrome browser for testcases excecution.");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Browsers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			log.debug("Chrome Driver executed.");
			break;
			
		case "Firefox":
			log.info("Selected Fire fox browser for testcases excecution.");
			System.setProperty("webdriver.gecko.drive", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Browsers\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.debug("Firefox Driver executed.");
			break;
			
		case "IE":
			log.info("Selected Internet explorer browser for testcases excecution.");
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Browsers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			log.debug("InternetExplorer Driver executed.");
			break;
			
		case "Headless":
			log.info("Selected Google chrome browser as headless for testcases excecution.");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Browsers\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions option =  new ChromeOptions();
			option.addArguments("--headless");
			driver = new ChromeDriver(option);
			log.debug("Chrome Driver executed as Headless.");
			break;
			
		default:
			log.info("Selected default browser for testcases excecution.");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Browsers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			log.debug("Chrome Driver executed.");
			break;		
			
		}
		driver.manage().window().maximize();
		log.info("Window Maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Implicit wait set as 10 SECONDS.");
		return driver;
	}
	
	/*
	 * public void getScreenshot(String result) throws IOException { File src =
	 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 * log.debug("File test "+result+" screenshot is captured");
	 * FileHandler.copy(src, new File ("D:\\Auto\\Test\\"+result+"ScreenShot.png"));
	 * log.info("Screenshot is store in path:"+"D:\\Auto\\Test\\"+result+"ScreenShot
	 * .png"); }
	 */


}
