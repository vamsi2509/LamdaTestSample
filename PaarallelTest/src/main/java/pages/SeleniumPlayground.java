package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPlayground {
	WebDriver driver;

	public SeleniumPlayground(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Simple Form Demo']")
	@CacheLookup
	WebElement linkForForm;

	@FindBy(how = How.XPATH, using = "//a[text()='Drag & Drop Sliders']")
	@CacheLookup
	WebElement linkForSiders;

	public void clickLinkforForm() {
		linkForForm.click();
	}

	public void clickLinkforSlider() {
		linkForSiders.click();
	}
}
