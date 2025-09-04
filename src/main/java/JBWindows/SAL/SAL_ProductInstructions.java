package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class SAL_ProductInstructions extends BaseClass{

	@FindBy(id = "SAL_ProductInstructions") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "txtProductCode") WebElement txtProductCode;
	@FindBy(id = "txtProductName") WebElement txtProductName;
	@FindBy(id = "gcProductInstruction") WebElement gcProductInstruction;
	
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnSave") WebElement BtnSave;


	public SAL_ProductInstructions() {
		pageName.click();
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickCancelButton()
	{
		BtnCancel.click();
	}
	
	public void clickSaveButton()
	{
		BtnSave.click();
	}

}
