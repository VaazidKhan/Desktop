package JBWindows.APP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonClass.BaseClass;

public class APP_ImportData extends BaseClass {

	@FindBy(id = "APP_ImportData")
	WebElement pageName;
	@FindBy(id = "picClose")
	WebElement BtnClose;

	public APP_ImportData() {
		PageFactory.initElements(driver, this);
	}

	public void activatePage() {
		pageName.click();
	}

	public void clickCloseButton() {
		BtnClose.click();
	}

}
