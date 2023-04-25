package basePacakage;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BaseHRMClass {
	//browser info Webdriver driver=new 
	//url info
	//username and password
	
	public static Properties prop=new Properties();
	public static WebDriver driver;
	
	//Step1
	public BaseHRMClass() {
		
		try {
		FileInputStream file=new FileInputStream("C:\\Users\\parmi\\eclipse-workspace\\HRmanagement\\src\\test\\java\\environmentvariables\\Config.properties");
	                 prop.load(file);
	                 
		} 
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException a) {
			a.printStackTrace();
		}
	}
			//step2
		
		public static void initiate() {
			//if brower=chrome webdriver.chrome.driver
			//elseif(browser=firefox){
			//webdriver.gecko.driver
			//maximize pageload,implicit,getting url
		String browsername=	prop.getProperty("browser");
		  
		if(browsername.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			ChromeOptions op=new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		}

		public static void screenshots(String Filename) {
			  File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  try {
			  
			  FileUtils.copyFile(file, new File("C:\\Users\\parmi\\eclipse-workspace\\HRmanagement\\src\\test\\java\\screenshot1" +Filename+".jpg" ));
			  }
			  catch (IOException e) {
				  e.printStackTrace();
			  }
		}
			
}
	
		
		



