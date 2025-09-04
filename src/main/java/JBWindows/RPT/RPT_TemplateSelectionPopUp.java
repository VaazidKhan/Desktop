package JBWindows.RPT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class RPT_TemplateSelectionPopUp extends BaseClass{

	@FindBy(id = "RPT_TemplateSelectionPopUp") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "cmbTemplateSelection") WebElement cmbTemplateSelection;
	@FindBy(id = "btnOk") WebElement BtnOk;

	public RPT_TemplateSelectionPopUp() {
		pageName.click();
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickOkButton()
	{
		BtnOk.click();
	}

}
