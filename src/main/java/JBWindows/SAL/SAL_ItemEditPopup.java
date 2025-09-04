package JBWindows.SAL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class SAL_ItemEditPopup extends BaseClass {

	@FindBy(id = "SAL_ItemEditPopup")
	WebElement pageName;
	@FindBy(id = "picClose")
	WebElement BtnClose;

	@FindBy(id = "lookupBinLocation")
	WebElement lookupBinLocation;
	@FindBy(id = "calcQuantityValue")
	WebElement calcQuantityValue;
	@FindBy(id = "calcUnitPrice")
	WebElement calcUnitPrice;
	@FindBy(id = "lookupDiscountRules")
	WebElement lookupDiscountRules;
	@FindBy(id = "calcDiscountRate")
	WebElement calcDiscountRate;
	@FindBy(id = "calcCashDiscount")
	WebElement calcCashDiscount;
	@FindBy(id = "lookupTaxGroup")
	WebElement lookupTaxGroup;
	@FindBy(id = "txtPromoCode")
	WebElement txtPromoCode;
	@FindBy(id = "lookupTax1")
	WebElement lookupTax1;
	@FindBy(id = "lookupTax2")
	WebElement lookupTax2;
	@FindBy(id = "lookupTax3")
	WebElement lookupTax3;
	@FindBy(id = "calcCurrentStock")
	WebElement calcCurrentStock;

	@FindBy(id = "txtSpecification")
	WebElement txtSpecification;
	@FindBy(id = "calcSubTotal")
	WebElement calcSubTotal;
	@FindBy(id = "memoInstruction")
	WebElement memoInstruction;
	@FindBy(id = "touchPad1")
	WebElement touchPad1;
	@FindBy(id = "btnIns1")
	WebElement BtnIns1;
	@FindBy(id = "btnIns2")
	WebElement BtnIns2;
	@FindBy(id = "btnIns3")
	WebElement BtnIns3;
	@FindBy(id = "btnIns4")
	WebElement BtnIns4;
	@FindBy(id = "btnIns5")
	WebElement BtnIns5;
	@FindBy(id = "btnInsMore")
	WebElement BtnInsMore;
	@FindBy(id = "btnClear")
	WebElement BtnClear;
	@FindBy(id = "btnEnter")
	WebElement BtnEnter;
	@FindBy(id = "btnComma")
	WebElement BtnComma;

	@FindBy(id = "btnDelete")
	WebElement BtnDelete;
	@FindBy(id = "btnCancel")
	WebElement BtnCancel;
	@FindBy(id = "btnSave")
	WebElement BtnSave;

	public SAL_ItemEditPopup() {
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

	public void clickDeleteButton() {
		BtnDelete.click();
	}

	public void clickEnterButton() {
		BtnEnter.click();
	}

	public void clickCommaButton() {
		BtnComma.click();
	}

	public void clickClearButton() {
		BtnClear.click();
	}

	public void clickInstruction1Button() {
		BtnIns1.click();
	}

	public void clickInstruction2Button() {
		BtnIns2.click();
	}

	public void clickInstruction3Button() {
		BtnIns3.click();
	}

	public void clickInstruction4Button() {
		BtnIns4.click();
	}

	public void clickInstruction5Button() {
		BtnIns5.click();
	}

	public void clickInstructionMoreButton() {
		BtnInsMore.click();
	}

	// 25-April-2018--Added by Moumita--------
	// This is the method to modify the item unit price at run time from product
	// edit screen
	public void fnRuntimeProductUnitPriceEdit(int rowNumber) {
		calcUnitPrice.click();
		calcUnitPrice.clear();
		calcUnitPrice.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", rowNumber, 37));
		GenericMethods.fnwait(2);

	}

	// 30-April-2018--Added by Moumita--------
	// This is the method to get the Sub Total amount
	public String fnGetSubTotalAmount() {
		String subTotal = null;
		WebElement amountEle = driver.findElement(By.id("calcSubTotal"));
		subTotal = amountEle.getAttribute("Name");
		return subTotal;
	}

	// 30-April-2018--Added by Moumita--------
	// This is the method to set the item level tax at run time
	// Parameter is rowNumber
	public void fnSetItemLevelTaxAtRunTime(int rowNumber) {

		if (lookupTax1.isDisplayed()) {
			lookupTax1.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "TaxRate", rowNumber, 9));
			lookupTax1.click();
		} else {
			fnWriteSteps("Fail", "Tax Name 1 is not displayed in UI");
		}
		if (lookupTax2.isDisplayed()) {
			lookupTax2.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "TaxRate", rowNumber, 10));
			lookupTax2.click();
		} else {
			fnWriteSteps("Fail", "Tax Name 2 is not displayed in UI");
		}
		GenericMethods.fnwait(2);
	}

	// 30-April-2018--Added by Moumita--------
	// This is the method to set different types of item level discounts, according
	// to the user input, at run time
	// Parameter are rowNumber & discountType
	public void fnSetItemLevelDiffDiscountsAtRunTime(int rowNumber, String discountType) {

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

	// 1-May-2018--Added by Moumita--------
	// This is the method to modify the item quantity at run time from product edit
	// screen
	// Parameter is rowNumber
	public void fnRuntimeProductQuantityEdit(int rowNumber) {
		calcQuantityValue.click();
		calcQuantityValue.clear();
		calcQuantityValue.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", rowNumber, 38));
		GenericMethods.fnwait(2);

	}

	// 1-May-2018--Added by Moumita--------
	// This is the method to remove the item from cart
	public void fnRemoveItemFromCart() {
		clickDeleteButton();
		GenericMethods.fnwait(1);
	}
}
