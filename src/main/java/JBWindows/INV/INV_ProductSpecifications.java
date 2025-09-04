package JBWindows.INV;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class INV_ProductSpecifications extends BaseClass{
	
	@FindBy(id = "INV_ProductSpecifications") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "btnOk") WebElement BtnOk;


	public INV_ProductSpecifications() {
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
