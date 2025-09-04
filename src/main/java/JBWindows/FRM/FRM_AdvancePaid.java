package JBWindows.FRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonClass.BaseClass;

public class FRM_AdvancePaid extends BaseClass{

	@FindBy(id = "FRM_AdvancePaid") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "txtSearch") WebElement txtSearch;
	
	@FindBy(id = "lookUpSupplier") WebElement lookUpSupplier;
	@FindBy(id = "calcNetPayable") WebElement calcNetPayable;
	@FindBy(id = "calcCurrentDue") WebElement calcCurrentDue;
	@FindBy(id = "calcBalanceAmount") WebElement calcBalanceAmount;
	
	@FindBy(id = "btnAdd") WebElement BtnAdd;
	@FindBy(id = "btnSave") WebElement BtnEdit;
	@FindBy(id = "btnPayment") WebElement BtnPayment;
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnSave") WebElement BtnSave;


	public FRM_AdvancePaid() {
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
	
	public void clickAddButton()
	{
		BtnAdd.click();
	}
	
	public void clickEditButton()
	{
		BtnEdit.click();
	}
	
	public void clickPaymentButton()
	{
		BtnPayment.click();
	}
	
}
