package com.base;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.util.ElementUtils;

public class TestBase {
	
	static WebDriver driver = null;
	static ElementUtils elementUtils;
	public static WebDriver initializeBrowser(String browserName) {
		
		if (browserName.equals("chrome")) {

			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {

			driver = new FirefoxDriver();

		} else if (browserName.equals("edge")) {

			driver = new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementUtils.IMPLICIT_WAIT_TIME));
		return driver;
	}
	
	
	public static WebDriver getDriver() {
		
		return driver;
	}
	
    public String getEmailTimeStamp() {
		
		Date date=new Date();
		
		return "ngovindselenium"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
		
	}
}
