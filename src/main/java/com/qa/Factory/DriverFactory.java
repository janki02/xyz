package com.qa.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.description.modifier.SynchronizationState;

public class DriverFactory {
 //public WebDriver driver;
	public static ThreadLocal<WebDriver> TL_Driver = new ThreadLocal<>();
	
	public WebDriver Init_Driver(String browser) {
		
		System.out.println("browser valu is : "+ browser);
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			TL_Driver.set(new ChromeDriver());
		}
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			TL_Driver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Please pass the correct browser value:"+ browser);
			
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return TL_Driver.get();
	}
	
	
	}


