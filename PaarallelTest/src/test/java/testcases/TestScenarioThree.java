package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SimpleFormFill;

public class TestScenarioThree {

	WebDriver driver;

	@BeforeTest
	public void setupSelenium() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
	}

	@Test
	public void TestCaseOne() throws Exception {
		SimpleFormFill sff=new SimpleFormFill(driver);
		sff.formFill();
	}

	@AfterTest
	public void tearDown() {
		 driver.quit();
	}
}
