package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.SeleniumPlayground;
import pages.SimpleDragAndDropSlider;
import pages.SimpleFormDemo;
import pages.SimpleFormFill;

public class ParallelTest {
	WebDriver driver;

	@BeforeMethod
	public void setupSelenium() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\Admin\\Downloads\\edgedriver_win64 (3)\\msedgedriver.exe");
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		driver = new EdgeDriver(options);
		driver.manage().window().maximize();
	}

	@Test()
	public void TestCaseOne() throws Exception {
		driver.get("https://www.lambdatest.com/selenium-playground/");
		SeleniumPlayground spg = new SeleniumPlayground(driver);
		spg.clickLinkforForm();
		SimpleFormDemo sfd = new SimpleFormDemo(driver);
		sfd.passText();
		sfd.clickButtonAndValidate();
	}

	@Test()
	public void TestCaseTwo() throws Exception {
		driver.get("https://www.lambdatest.com/selenium-playground/");
		SeleniumPlayground sp = new SeleniumPlayground(driver);
		sp.clickLinkforSlider();
		SimpleDragAndDropSlider sdd = new SimpleDragAndDropSlider(driver);
		sdd.sliderDrag();
	}

	@Test()
	public void TestCaseThree() throws Exception {
		driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
		SimpleFormFill sff = new SimpleFormFill(driver);
		sff.formFill();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
