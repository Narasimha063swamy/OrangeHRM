package com.OrangeHRM.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.OrangeHRM.Utilities.ReadConfig;
  
public class BaseClass {
	
	ReadConfig read=new ReadConfig();
	
	public String baseURL=read.getApplicationURL();
	public String username=read.getUsername();
	public String password=read.getPassword();
	public static WebDriver driver;
	
	public static Logger log;
	@Parameters("browser")
	@BeforeClass
	public void setup(@Optional("chrome")String br) {
	//public void setup(String br) {
		
		log=Logger.getLogger("NewTourse");
		PropertyConfigurator.configure("log4j.properties");

		// System.getProperty("user.dir")--->This is we can perform only in Java classes
// it use within in the java classes but within the properties file it will not work 
		//  ./---->we can perform in java classes and properties files
		// java class accepts only forward slashes(//) but properties file accepts the backward slashes(\\)
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",read.getchromepath());
		driver=new ChromeDriver();
	}else if(br.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", read.getfirefoxpath());
		driver=new FirefoxDriver();
		
	}else if(br.equals("ie")) {
		System.setProperty("webdriver.ie.driver", read.getIEpath());
		driver=new InternetExplorerDriver();
		
	}	//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(baseURL);
	
	}	
	
	@AfterClass
	
	public void tearDown() throws Exception {
	
		Thread.sleep(3000);
		driver.close();
	}

	public void CaptureScreenshot(WebDriver driver, String tname) throws Exception {
		TakesScreenshot sr=(TakesScreenshot)driver;
		File source=sr.getScreenshotAs(OutputType.FILE);
		File target =new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
		/*File Screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screenshot, new File("E:\\SELENIUM\\ORANGE\\Screenshots\\login.png"));
		System.out.println("Screenshot taken");		*/
		
		
				
	}
	
	
	
	
}







