package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class SAL_InvoiceTaxAndDiscount extends BaseClass {

	@FindBy(id = "SAL_InvoiceTaxAndDiscount")
	WebElement pageName;
	@FindBy(id = "picClose")
	WebElement BtnClose;

	@FindBy(id = "txtPromoCode")
	WebElement txtPromoCode;
	@FindBy(id = "lookupDiscountRules")
	WebElement lookupDiscountRules;
	@FindBy(id = "calcDiscountRate")
	WebElement calcDiscountRate;
	@FindBy(id = "calcCashDiscount")
	WebElement calcCashDiscount;
	@FindBy(id = "lookupTaxGroup")
	WebElement lookupTaxGroup;
	@FindBy(id = "lookUpTax1")
	WebElement lookUpTax1;
	@FindBy(id = "lookUpTax2")
	WebElement lookUpTax2;
	@FindBy(id = "lookUpTax3")
	WebElement lookUpTax3;

	@FindBy(id = "btnCancel")
	WebElement BtnCancel;
	@FindBy(id = "btnSave")
	WebElement BtnSave;

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

	// ----9-Feb-2018------added by Moumita---
	public SAL_InvoiceTaxAndDiscount() {
		PageFactory.initElements(driver, this);
	}

	// ---30-April-2018--Added by Moumita--------
	// This is the method to set the invoice level tax at run time
	// Parameter is rowNumber
	public void setInvoiceLevelTax(int rowNumber) {
		if (lookUpTax1.isDisplayed()) {
			lookUpTax1.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "TaxRate", rowNumber, 9));
			lookUpTax1.click();
		} else {
			fnWriteSteps("Fail", "Tax Name 1 is not displayed in UI");
		}
		if (lookUpTax2.isDisplayed()) {
			lookUpTax2.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "TaxRate", rowNumber, 10));
			lookUpTax2.click();
		} else {
			fnWriteSteps("Fail", "Tax Name 2 is not displayed in UI");
		}
		if (lookUpTax3.isDisplayed()) {
			lookUpTax3.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "TaxRate", rowNumber, 10));
			lookUpTax3.click();
		} else {
			fnWriteSteps("Fail", "Tax Name 3 is not displayed in UI");
		}
		clickSaveButton();
		GenericMethods.fnwait(2);
	}

	// ---30-April-2018--Added by Moumita--------
	// This is the method to set different type of invoice level discount, according
	// to the user input, at run time
	// Parameter are rowNumber & discountType
	public void setInvoiceLevelDiscount(int rowNumber, String discountType) {

		switch (discountType.toUpperCase()) {
		case "PROMOCODE":
			if (txtPromoCode.isDisplayed()) {
				txtPromoCode.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Discount",
						rowNumber, 12));

			} else {
				fnWriteSteps("Fail", "Promo code field  is not displayed in UI");
			}

			GenericMethods.fnwait(1);
			clickSaveButton();
			break;

		case "DISCOUNTRULE":
			if (lookupDiscountRules.isDisplayed()) {
				lookupDiscountRules.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Discount", rowNumber, 13));
				lookupDiscountRules.click();

			} else {
				fnWriteSteps("Fail", "Discount Rules field  is not displayed in UI");
			}

			GenericMethods.fnwait(1);
			clickSaveButton();
			break;

		case "DISCOUNTRATE":
			if (calcDiscountRate.isDisplayed()) {
				calcDiscountRate.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Discount", rowNumber, 14));

			} else {
				fnWriteSteps("Fail", "Discount Rate field  is not displayed in UI");
			}

			GenericMethods.fnwait(1);
			clickSaveButton();
			break;

		case "DISCOUNTCASH":
			if (calcCashDiscount.isDisplayed()) {
				calcCashDiscount.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Discount", rowNumber, 15));

			} else {
				fnWriteSteps("Fail", "Fixed Discount amount field  is not displayed in UI");
			}

			GenericMethods.fnwait(1);
			clickSaveButton();
			break;

		}
	}
}
