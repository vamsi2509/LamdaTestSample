package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SeleniumPlayground;
import pages.SimpleDragAndDropSlider;
import pages.SimpleFormDemo;
import pages.SimpleFormFill;

public class ParallelTest {
	WebDriver driver;

	@BeforeMethod
	public void setupSelenium() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		driver = new ChromeDriver(options);
		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void TestCaseOne() throws Exception {
		System.out.println("The thread ID for testTitle Chrome is "+ Thread.currentThread().getId());
		SeleniumPlayground spg = new SeleniumPlayground(driver);
		spg.clickLinkforForm();
		SimpleFormDemo sfd = new SimpleFormDemo(driver);
		sfd.passText();
		sfd.clickButtonAndValidate();
	}

	@Test(priority=2)
	public void TestCaseTwo() throws Exception {
		System.out.println("The thread ID for testTitle Chrome is "+ Thread.currentThread().getId());
		driver.navigate().to("https://www.lambdatest.com/selenium-playground/");
		SeleniumPlayground sp = new SeleniumPlayground(driver);
		sp.clickLinkforSlider();
		SimpleDragAndDropSlider sdd = new SimpleDragAndDropSlider(driver);
		sdd.sliderDrag();
	}

	@Test(priority=3)
	public void TestCaseThree() throws Exception {
		System.out.println("The thread ID for testTitle Chrome is "+ Thread.currentThread().getId());
		driver.navigate().to("https://www.lambdatest.com/selenium-playground/input-form-demo");
		SimpleFormFill sff = new SimpleFormFill(driver);
		sff.formFill();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
