package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SimpleFormFill {
	WebDriver driver;
	String expected_erromessage="Please fill out this field.";
	String expected_successmessage="Thanks for contacting us, we will get back to you shortly.";
	public SimpleFormFill(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(how=How.ID,using="name")
	@CacheLookup
	WebElement text_name;
	
	@FindBy(how=How.ID,using="inputEmail4")
	@CacheLookup
	WebElement text_email;
	
	@FindBy(how=How.ID,using="inputPassword4")
	@CacheLookup
	WebElement text_password;
	
	@FindBy(how=How.ID,using="company")
	@CacheLookup
	WebElement text_company;
	
	@FindBy(how=How.ID,using="websitename")
	@CacheLookup
	WebElement text_websitename;
	
	@FindBy(how=How.NAME,using="country")
	@CacheLookup
	WebElement country_Dropdown;
	
	@FindBy(how=How.NAME,using="city")
	@CacheLookup
	WebElement text_city;
	
	@FindBy(how=How.NAME,using="address_line1")
	@CacheLookup
	WebElement text_address1;
	
	@FindBy(how=How.NAME,using="address_line2")
	@CacheLookup
	WebElement text_address2;
	
	@FindBy(how=How.ID,using="inputState")
	@CacheLookup
	WebElement text_state;
	
	@FindBy(how=How.ID,using="inputZip")
	@CacheLookup
	WebElement text_zip;
	
	@FindBy(how=How.XPATH,using="//button[text()='Submit']")
	@CacheLookup
	WebElement button_submit;
	
	public void formFill()
	{
		//driver.navigate().to("https://www.lambdatest.com/selenium-playground/input-form-demo");
		button_submit.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String actual_erromessage=(String) js.executeScript("return document.getElementById('name').validationMessage");
		System.out.println("Actual Error Message: " +actual_erromessage);
		Assert.assertEquals(actual_erromessage, expected_erromessage);
		text_name.sendKeys("sample");
		text_email.sendKeys("sample@yopmail.com");
		text_password.sendKeys("Sample@1234");
		text_company.sendKeys("Sample Company");
		text_websitename.sendKeys("sample.com");
		new Select(country_Dropdown).selectByVisibleText("United States");
		text_city.sendKeys("Dallas");
		text_address1.sendKeys("123, Mc Kence");
		text_address2.sendKeys("Dallaspuram");
		text_state.sendKeys("Texas");
		text_zip.sendKeys("2222323");
		button_submit.click();
		WebElement messageElement = new WebDriverWait(driver, Duration.ofMillis(5000))
	            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@style='display: block;']")));
		String messageText = messageElement.getText();
		System.out.println("Text loaded: " + messageText);
	    Assert.assertEquals(messageText, expected_successmessage);
	}
	
}
