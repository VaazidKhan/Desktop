package JBWindows.APP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class APP_ShotcutListPopup extends BaseClass{
	
	@FindBy(id = "APP_ShotcutListPopup")	WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	public APP_ShotcutListPopup() {
		pageName.click();
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}

}
