package resources;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	public static WebDriver driver;
	public Properties prop;
	public static Logger log=LogManager.getLogger(Base.class.getName());

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream file = new FileInputStream("./src\\main\\java\\resources\\data.properties");
		prop.load(file);
		String browserName= prop.getProperty("browserName");
		String headLessFlag=prop.getProperty("headLess");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			if(headLessFlag.equals("true")) {
				ChromeOptions options = new ChromeOptions();  
				options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");  
				driver = new ChromeDriver(options);  
			}
			else if(headLessFlag.equals("false")) {
				driver = new ChromeDriver();	
			}
			else {
				log.error("Invalid Headless flag property");
			}
		}
		else if (browserName.equals("firefox")) {
			log.error("Please add support for firefox");
		}
		else if(browserName.equals("ie")) {
			log.error("Please add support for IE");
		}
		else {
			log.error("Invalid Browser Name preperty");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public void getScreenshot(String testName) throws Exception{
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile,new File("./screenshots\\"+testName+"ScreenShot.png"));
		
	}
}
	
