package JBWindows.SYS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonClass.BaseClass;

public class ContactUs extends BaseClass {

	@FindBy(id = "ContactUs")
	WebElement pageName;
	@FindBy(id = "btnClose")
	WebElement btnClose;

	// WebElement initialization
	public ContactUs() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void clickCloseButton() {
		btnClose.click();
	}

}
