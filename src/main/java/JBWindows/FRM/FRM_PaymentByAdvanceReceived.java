package JBWindows.FRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class FRM_PaymentByAdvanceReceived extends BaseClass {

	@FindBy(id = "FRM_PaymentByAdvanceReceived")
	WebElement pageName;
	@FindBy(id = "picClose")
	WebElement BtnClose;

	@FindBy(id = "lookupAdvanceReceived")
	WebElement lookupAdvanceReceived;
	@FindBy(id = "dtAdvanceDate")
	WebElement dtAdvanceDate;
	@FindBy(id = "txtCustomer")
	WebElement txtCustomer;
	@FindBy(id = "calcNetReceivable")
	WebElement calcNetReceivable;
	@FindBy(id = "calcAmount")
	WebElement calcAmount;

	@FindBy(id = "btnCancel")
	WebElement BtnCancel;
	@FindBy(id = "btnSave")
	WebElement BtnSave;

	public FRM_PaymentByAdvanceReceived() {
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

	// ---26-April-2018--Added by Moumita--------
	public void selectRunTimeAdvanceReceivedDetails(String voucherNumber) {

		lookupAdvanceReceived.sendKeys(voucherNumber);
		lookupAdvanceReceived.click();

		BtnSave.click();
		GenericMethods.fnwait(2);
	}

	// ---27-April-2018--Added by Moumita--------
	public void selectExistingAdvanceReceivedDetails(int rowNumber, String amount) {

		lookupAdvanceReceived.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", rowNumber, 26));
		lookupAdvanceReceived.click();
		calcAmount.clear();
		calcAmount.sendKeys(amount);
		GenericMethods.fnwait(1);
		BtnSave.click();
		GenericMethods.fnwait(2);
	}
}
