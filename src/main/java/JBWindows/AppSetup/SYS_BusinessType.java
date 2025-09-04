package JBWindows.AppSetup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class SYS_BusinessType extends BaseClass{
	
	@FindBy(id = "SYS_BusinessType") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "btnBack") WebElement BtnBack;
	@FindBy(id = "btnNext") WebElement BtnNext;

	public SYS_BusinessType() {
		pageName.click();
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickBackButton()
	{
		BtnBack.click();
	}
	
	public void clickNextButton()
	{
		BtnNext.click();
	}

}
