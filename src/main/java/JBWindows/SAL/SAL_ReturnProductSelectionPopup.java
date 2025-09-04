package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class SAL_ReturnProductSelectionPopup extends BaseClass{
	
	@FindBy(id = "SAL_ReturnProductSelectionPopup") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "grdContraProduct") WebElement grdContraProduct;
	@FindBy(id = "btnSave") WebElement BtnSave;


	public SAL_ReturnProductSelectionPopup() {
		pageName.click();
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickSaveButton()
	{
		BtnSave.click();
	}

}
