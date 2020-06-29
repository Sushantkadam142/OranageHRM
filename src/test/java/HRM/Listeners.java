package HRM;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import Resources.Base;

public class Listeners implements ITestListener
{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	Base b = new Base();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		log.info(result+ " Start execution");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		log.info(result+ " Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
//		try {
//			log.error(result.getName()+" got fail.");
//			b.getScreenshot(result.getName());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		 Calendar calendar = Calendar.getInstance();

		  SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");    

		  String methodName = result.getName();

		  if(!result.isSuccess())

		  {

		       File scrFile =((TakesScreenshot) b.driver).getScreenshotAs(OutputType.FILE);

		   try{

		        String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+ "/src/main/java/ScreenshotFailure/";

	        File destFile = new File((String) reportDirectory + "" + methodName + "_" + formater.format(calendar.getTime())+".png");


		FileHandler.copy(scrFile, destFile);

		Reporter.log("<a herf='" +destFile.getAbsolutePath()+"'> <img src ='" + destFile.getAbsolutePath()+"' height='100' width='100'/> </a>");

		}

		catch(IOException e)

		{

		     e.printStackTrace();

		}

		   }
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
