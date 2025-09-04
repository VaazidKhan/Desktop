package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;
import commonClass.GenericMethods;

public class SR_TablePopUp extends BaseClass{
	
	@FindBy(id = "SR_TablePopUp") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "grdTable") WebElement grdTable;

	public SR_TablePopUp() {
		PageFactory.initElements(driver, this);
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	//----12-Feb-2018---added by Moumita---
	public void tableSelection()
	{
		GenericMethods.DoubleClickAction("window", grdTable);
	}
}
