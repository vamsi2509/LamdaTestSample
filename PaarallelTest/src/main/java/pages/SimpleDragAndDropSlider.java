package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SimpleDragAndDropSlider {
	WebDriver driver;
	String Slider15_expectedValue = "95";

	public SimpleDragAndDropSlider(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//h4[text()=' Default value 15']/following::input[@class='sp__range'][1]")
	@CacheLookup
	WebElement Slider15;

	@FindBy(how = How.XPATH, using = "//h4[text()=' Default value 15']/following::output[@id='rangeSuccess']")
	@CacheLookup
	WebElement Slider15_value;

	public void sliderDrag() throws Exception {
		//driver.get("https://www.lambdatest.com/selenium-playground/");
		int initialPosition = Integer.parseInt(Slider15.getAttribute("value"));
		int targetPosition = 95;
		int moveOffset = targetPosition - initialPosition;
		for (int i = 1; i <= moveOffset; i++) {
			Slider15.sendKeys(Keys.ARROW_RIGHT);
		}
		Assert.assertTrue(Slider15_value.getText().equals(Slider15_expectedValue));
	}
}
