package JBWindows.APP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class APP_InAppPaymentGateWay {

	@FindBy(id = "APP_InAppPaymentGateWay")
	WebElement pageName;
	@FindBy(id = "picClose")
	WebElement BtnClose;

	public APP_InAppPaymentGateWay() {
		pageName.click();
	}

	public void activatePage() {
		pageName.click();
	}

	public void clickCloseButton() {
		BtnClose.click();
	}
}
