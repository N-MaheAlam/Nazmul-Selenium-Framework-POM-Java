package TestUsableProperties;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModel.LandingPageRahulShetty;

public class DriverBaseClass {
	
	 public WebDriver d;
	  public Properties property;
	
	

		
	public WebDriver browserCall() throws IOException {
		
		
		/*-
		 
		 
		
		   property = new Properties();
		 
		
		FileInputStream files = new FileInputStream(System.getProperty("user.dir")+
								"/src//main/java/resources/data.properties");
		property.load(files);
		String browserName = property.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			d = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			d = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("safari")){
			WebDriverManager.safaridriver().setup();
			d = new SafariDriver();
			
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			d = new EdgeDriver();
		}
		System.out.println(browserName);
		
		
		*/ 
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		d.manage().window().maximize();
		
		
		return d;
		
	}
	
	public LandingPageRahulShetty lunchApplication() throws IOException {
		d = browserCall();
		LandingPageRahulShetty landingPage = new LandingPageRahulShetty(d);
		landingPage.goToLandingPage();
		return landingPage;
		
	}
	
	

}
