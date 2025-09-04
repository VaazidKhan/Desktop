package JBWindows.PUR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import JBWindows.SAL.SAL_PointOfSales;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;

public class PUR_AddPuchaseInvoice extends BaseClass {
	// Header elements
	@FindBy(id = "PUR_AddPuchaseInvoice")
	WebElement pageName;
	@FindBy(id = "picClose")
	WebElement btnClose;
	@FindBy(id = "lblCaption")
	WebElement PageCaption;
	@FindBy(id = "picLogo")
	WebElement HeaderJBLogo;
	// Entry OR Edit screen elements
	@FindBy(id = "dtInvoiceDate")
	WebElement dtInvoiceDate;
	@FindBy(id = "lookupPOType")
	WebElement lookupPOType;
	@FindBy(id = "lookUpSupplier")
	WebElement lookUpSupplier;
	@FindBy(id = "txtReferenceNo")
	WebElement txtReferenceNo;
	@FindBy(id = "dtReceivingDate")
	WebElement dtReceivingDate;
	@FindBy(id = "lookupPriceList")
	WebElement lookupPriceList;
	// Buttons elements
	@FindBy(id = "btnSave")
	WebElement btnProceed;

	// WebElement Initialization method
	public PUR_AddPuchaseInvoice() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void activatePage() {
		pageName.click();
	}

	public SAL_PointOfSales clickProceedButton() {
		btnProceed.click();
		return new SAL_PointOfSales();
	}

	public void clickCloseButton() {
		btnClose.click();
	}

	// ----20-Feb-2018--Added by Moumita------
	public void setSupplierAndReferenceNo(int rowNo) {
		lookUpSupplier.sendKeys(
				ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "PuchaseInvoice", rowNo, 0));
		lookUpSupplier.click();

		txtReferenceNo.sendKeys(
				ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "PuchaseInvoice", rowNo, 1));
		clickProceedButton();
	}
}
