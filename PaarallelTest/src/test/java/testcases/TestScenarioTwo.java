package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.SeleniumPlayground;
import pages.SimpleDragAndDropSlider;
import pages.SimpleFormDemo;

public class TestScenarioTwo {

	WebDriver driver;

	@BeforeTest
	public void setupSelenium() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");

		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/");
	}

	@Test
	public void TestCaseOne() throws Exception {
		SeleniumPlayground sp = new SeleniumPlayground(driver);
		sp.clickLinkforSlider();
		SimpleDragAndDropSlider sdd = new SimpleDragAndDropSlider(driver);
		sdd.sliderDrag();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
