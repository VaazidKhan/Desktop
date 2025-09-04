package JBWindows.FRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class FRM_PaymentByAdvancePaid extends BaseClass{
	
	@FindBy(id = "FRM_PaymentByAdvancePaid") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "lookupAdvancePaid") WebElement lookupAdvancePaid;
	@FindBy(id = "dtAdvanceDate") WebElement dtAdvanceDate;
	@FindBy(id = "txtSupplier") WebElement txtSupplier;
	@FindBy(id = "calcNetPayable") WebElement calcNetPayable;
	@FindBy(id = "calcAmount") WebElement calcAmount;
	
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnSave") WebElement BtnSave;


	public FRM_PaymentByAdvancePaid() {
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
