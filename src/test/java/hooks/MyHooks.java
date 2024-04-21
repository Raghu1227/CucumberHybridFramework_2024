package hooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.base.TestBase;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {

	ConfigReader configReader = new ConfigReader();
	WebDriver driver;
	Properties prop;
    TestBase tBase=new TestBase();
	@Before
	public void setup() throws IOException {

		prop = configReader.intializeProperties();
		driver = TestBase.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	}

	@After
	public void tearDown(Scenario scenario) {
		
		String scenarioName=scenario.getName().replaceAll(" ", "_");
		
		if(scenario.isFailed()) {
			
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot,"image/png", scenarioName);
		}
		
		driver.quit();

	}

}
