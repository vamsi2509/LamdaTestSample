package testcases;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SeleniumPlayground;
import pages.SimpleDragAndDropSlider;
import pages.SimpleFormDemo;
import pages.SimpleFormFill;

public class EdgePTest {
	WebDriver driver;
	
		@BeforeTest
		public void setupSelenium() {
			WebDriverManager.edgedriver().setup();
			EdgeOptions browserOptions = new EdgeOptions();
			browserOptions.setPlatformName("Windows 10");
			browserOptions.setBrowserVersion("122.0");
			browserOptions.addArguments("--remote-allow-origins=*");
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			//ltOptions.put("username", "Your LambdaTest Username");
			//ltOptions.put("accessKey", "Your LambdaTest Access Key");
			ltOptions.put("geoLocation", "IN");
			ltOptions.put("visual", true);
			ltOptions.put("video", true);
			ltOptions.put("network", true);
			ltOptions.put("timezone", "Kolkata");
			ltOptions.put("project", "VamsiLamdaTestProject");
			ltOptions.put("name", "VamsiParallelTest");
			ltOptions.put("tunnel", true);
			ltOptions.put("w3c", true);
			ltOptions.put("plugin", "java-testNG");
			browserOptions.setCapability("LT:Options", ltOptions);
			driver = new EdgeDriver(browserOptions);
			driver.manage().window().maximize();	
		}

		@Test(priority = 1)
		public void TestCaseOne() throws Exception {
			System.out.println("The thread ID for testTitle Edge is "+ Thread.currentThread().getId());
			driver.get("https://www.lambdatest.com/selenium-playground/");
			SeleniumPlayground spg = new SeleniumPlayground(driver);
			spg.clickLinkforForm();
			SimpleFormDemo sfd = new SimpleFormDemo(driver);
			sfd.passText();
			sfd.clickButtonAndValidate();
		}
		@Test(priority = 2)
		public void TestCaseTwo() throws Exception {
			System.out.println("The thread ID for testTitle Edge is "+ Thread.currentThread().getId());
			driver.get("https://www.lambdatest.com/selenium-playground/");
			SeleniumPlayground sp = new SeleniumPlayground(driver);
			sp.clickLinkforSlider();
			SimpleDragAndDropSlider sdd = new SimpleDragAndDropSlider(driver);
			sdd.sliderDrag();
		}
		@Test(priority = 3)
		public void TestCaseThree() throws Exception {
			System.out.println("The thread ID for testTitle Edge is "+ Thread.currentThread().getId());
			driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
			SimpleFormFill sff = new SimpleFormFill(driver);
			sff.formFill();
		}

		@AfterTest
		public void tearDown() {
			driver.quit();
		}

	}


