package JBWindows.FRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class FRM_AdvanceReceived extends BaseClass {

	@FindBy(id = "FRM_AdvanceReceived")
	WebElement pageName;
	@FindBy(id = "picClose")
	WebElement BtnClose;

	@FindBy(id = "txtSearch")
	WebElement txtSearch;

	@FindBy(id = "lookUpCustomer")
	WebElement lookUpCustomer;
	@FindBy(id = "calcNetReceivable")
	WebElement calcNetReceivable;
	@FindBy(id = "calcCurrentDue")
	WebElement calcCurrentDue;
	@FindBy(id = "calcBalanceAmount")
	WebElement calcBalanceAmount;

	@FindBy(id = "btnAdd")
	WebElement BtnAdd;
	@FindBy(id = "btnSave")
	WebElement BtnEdit;
	@FindBy(id = "btnPayment")
	WebElement BtnPayment;
	@FindBy(id = "btnCancel")
	WebElement BtnCancel;
	@FindBy(id = "btnSave")
	WebElement BtnSave;

	public FRM_AdvanceReceived() {
		PageFactory.initElements(driver, this);
	}

	public void activatePage() {
		pageName.click();
	}

	public void clickCloseButton() {
		BtnClose.click();
	}

	public void clickCancelButton() {
		BtnCancel.click();
	}

	public void clickSaveButton() {
		BtnSave.click();
	}

	public void clickAddButton() {
		BtnAdd.click();
	}

	public void clickEditButton() {
		BtnEdit.click();
	}

	public void clickPaymentButton() {
		BtnPayment.click();
	}

	// ---26-April-2018--Added by Moumita--------
	public void fnCreateAdvanceReceived(int rowNumber) {
		try {
			if (BtnAdd.isDisplayed()) {
				BtnAdd.click();
				GenericMethods.fnwait(1);
				calcNetReceivable.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Transaction_Invoice_TakeAway", rowNumber, 27));
				GenericMethods.fnwait(1);
				clickSaveButton();
				GenericMethods.fnwait(2);
			}
		} catch (Exception e) {
			calcNetReceivable.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
					"Transaction_Invoice_TakeAway", rowNumber, 27));
			GenericMethods.fnwait(1);
			clickSaveButton();
			GenericMethods.fnwait(2);
		}
	}
}
