package pl.lait.Setup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Init {
	
	//static FirefoxDriver driver;
	static WebDriver driver;
	
	public static WebDriver getDriver(){
		
		if(driver == null){
			
			URL hubUrl = null;
			
			try{
				//po uruchomieniu huba i noda (java -jar seleniumserver...) ustawiamy adres IP (localhost - 
				hubUrl = new URL ("http://192.168.0.117:4444/wd/hub/");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//zmieniamy firefoxDriver na WebDriver więc trzeba też podać jakiej przeglądarki potrzebujemy
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			
			
			//włączamy stary sposób i wskazujemy nowy - RemoteWebDriver - podjąć w parametrach gdzie ma wołać na przeglądarce
			//driver = new FirefoxDriver();
			driver = new RemoteWebDriver(hubUrl, cap);
			
			driver.get("http://newtours.demoaut.com");
			
			
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
		}else{
			return driver;
		}
	}

	
	public static void close(){
		driver.close();
		driver.quit();
		driver = null;
	}
	
	@After
	public void cleanUp(){
	close();	
	}
}
