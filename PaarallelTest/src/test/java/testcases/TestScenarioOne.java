package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.SeleniumPlayground;
import pages.SimpleFormDemo;

public class TestScenarioOne {

	WebDriver driver;

	@BeforeTest
	public void setupSelenium() {
		System.setProperty("webdriver.edge.driver","C:\\Users\\Admin\\Downloads\\edgedriver_win64 (3)\\msedgedriver.exe");
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/");
	}

	@Test
	public void TestCaseOne() throws Exception {
		SeleniumPlayground spg = new SeleniumPlayground(driver);
		spg.clickLinkforForm();
		SimpleFormDemo sfd = new SimpleFormDemo(driver);
		sfd.passText();
		sfd.clickButtonAndValidate();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
