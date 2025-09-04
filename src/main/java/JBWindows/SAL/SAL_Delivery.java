package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class SAL_Delivery extends BaseClass {

	@FindBy(id = "SAL_Delivery")
	WebElement pageName;
	@FindBy(id = "picClose")
	WebElement BtnClose;

	@FindBy(id = "txtSearch")
	WebElement txtSearch;
	@FindBy(id = "grdDelivery")
	WebElement grdDelivery;
	@FindBy(id = "btnCollectDelivery")
	WebElement BtnCollectDelivery;

	@FindBy(id = "btnCancel")
	WebElement BtnCancel;
	@FindBy(id = "btnProcess")
	WebElement BtnProcess;

	// ---15-Feb-2018-----Added by Moumita---------
	@FindBy(name = "Delivery row 0")
	WebElement DeliveryRowFirst;

	public SAL_Delivery() {
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

	public void clickProcessButton() {
		BtnProcess.click();
	}

	public void clickCollectDeliveryButton() {
		BtnCollectDelivery.click();
	}

	// ---15-Feb-2018-----Added by Moumita---------
	public void selectFirstRecord() {
		DeliveryRowFirst.click();
	}

	public void searchAndSelectMultipleRecordForDispatch(int startingRowNumber, int lastRowNumber) {
		for (int startFrom = startingRowNumber; startFrom <= lastRowNumber; startFrom++) {
			txtSearch.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Delivery", startFrom, 0));
			GenericMethods.fnwait(2);
			DeliveryRowFirst.click();
			GenericMethods.fnwait(1);
			fnWriteSteps("Pass", "Selected order has been dispatched successfully");
		}
		clickProcessButton();
		GenericMethods.fnwait(1);
	}

	public void searchAndSelectSingleRecordForDispatch(String orderNo) {
		txtSearch.sendKeys(orderNo); 
		GenericMethods.fnwait(2);
		DeliveryRowFirst.click();
		GenericMethods.fnwait(1);
		fnWriteSteps("Pass", "Selected order has been dispatched successfully");

		clickProcessButton();
		GenericMethods.fnwait(1);
	}

}
