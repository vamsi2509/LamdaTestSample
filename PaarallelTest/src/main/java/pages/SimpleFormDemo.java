package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SimpleFormDemo {
	WebDriver driver;
	String expectedPageURL = "simple-form-demo";
	String textToPass = "Welcome to LambdaTest";

	public SimpleFormDemo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using ="showInput")
	@CacheLookup
	WebElement button_showmessage;

	@FindBy(how = How.ID, using = "user-message")
	@CacheLookup
	WebElement textbox_usermessage;

	public void validateURL() {
		String actualPageURL = driver.getCurrentUrl();
		Assert.assertTrue(actualPageURL.equals(expectedPageURL));
	}

	public void passText() {
		textbox_usermessage.sendKeys(textToPass);
	}

	public void clickButtonAndValidate() throws Exception {
		button_showmessage.click();
		WebElement messageElement = new WebDriverWait(driver, Duration.ofMillis(5000))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		String messageText = messageElement.getText();
		System.out.println("Text loaded: " + messageText);
		Assert.assertEquals(messageText, textToPass);
	}
}
