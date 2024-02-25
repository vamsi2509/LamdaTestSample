package testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.SeleniumPlayground;
import pages.SimpleDragAndDropSlider;
import pages.SimpleFormDemo;
import pages.SimpleFormFill;

public class SafariPTest {
	public RemoteWebDriver driver=null;
	public String username = "vamsi5544";
	public String accesskey = "1KlCR7P1xrCzwgTNARrxZEChVOkiSgw6KRFWyyMfshXFEEhHLf";
	public String gridURL = "@hub.lambdatest.com/wd/hub";
	boolean status = false;
	
	@BeforeTest
	  @org.testng.annotations.Parameters(value={"browser","version","platform"})
	  public void setUp(String browser, String version, String platform) throws Exception {
	     DesiredCapabilities capabilities = new DesiredCapabilities();
	      capabilities.setCapability("browserName", browser);
	      capabilities.setCapability("version", version);
	      capabilities.setCapability("platform", platform); // If this cap isn't specified, it will just get the any available one
	      capabilities.setCapability("build", "Selenium Grid");
	      capabilities.setCapability("name", "Sample Test");
	      capabilities.setCapability("network", true); // To enable network logs
	      capabilities.setCapability("visual", true); // To enable step by step screenshot
	      capabilities.setCapability("video", true); // To enable video recording
	      capabilities.setCapability("console", true); // To capture console logs
	      capabilities.setCapability("tunnel", true); // To capture Tunnel Logs
	      
	      try {
	          driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
	      } catch (MalformedURLException e) {
	          System.out.println("Invalid grid URL");
	      } catch (Exception e) {
	          System.out.println(e.getMessage());
	      }
			
			/*WebDriverManager.safaridriver().setup();
			SafariOptions browserOptions = new SafariOptions();
			browserOptions.setPlatformName("Monterey");
			browserOptions.setBrowserVersion("12");
			//browserOptions.addArguments("--remote-allow-origins=*");
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", username);
			ltOptions.put("accessKey", accesskey);
			ltOptions.put("geoLocation", "IN");
			ltOptions.put("visual", true);
			ltOptions.put("video", true);
			ltOptions.put("network", true);
			ltOptions.put("console", true);
			ltOptions.put("timezone", "Kolkata");
			ltOptions.put("project", "VamsiLamdaTestProject");
			ltOptions.put("name", "VamsiParallelTest");
			ltOptions.put("tunnel", true);
			ltOptions.put("w3c", true);
			ltOptions.put("plugin", "java-testNG");
			browserOptions.setCapability("LT:Options", ltOptions);
			driver = new SafariDriver(browserOptions);
			driver.manage().window().maximize();
			driver.get("https://\" + username + \":\" + accesskey + gridURL");*/
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
			if (driver != null) {
		          ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
		          driver.quit();
		      }
		}

	}


