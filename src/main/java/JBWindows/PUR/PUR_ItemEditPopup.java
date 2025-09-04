package JBWindows.PUR;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonClass.BaseClass;
import commonClass.GenericMethods;

public class PUR_ItemEditPopup extends BaseClass {
	// Header elements
	@FindBy(id = "PUR_ItemEditPopup")
	WebElement pageName;
	@FindBy(id = "picClose")
	WebElement btnClose;
	@FindBy(id = "lblCaption")
	WebElement PageCaption;
	@FindBy(id = "picLogo")
	WebElement HeaderJBLogo;
	// elements
	@FindBy(id = "lookupBinLocation")
	WebElement lookupBinLocation;
	@FindBy(id = "calcQuantityValue")
	WebElement calcQuantityValue;
	@FindBy(id = "calcUnitPrice")
	WebElement calcUnitPrice;
	@FindBy(id = "calcDiscountRate")
	WebElement calcDiscountRate;
	@FindBy(id = "calcCashDiscount")
	WebElement calcCashDiscount;
	@FindBy(id = "lookupTaxGroup")
	WebElement lookupTaxGroup;
	@FindBy(id = "lookupTax1")
	WebElement lookupTax1;
	@FindBy(id = "lookupTax2")
	WebElement lookupTax2;
	@FindBy(id = "lookupTax3")
	WebElement lookupTax3;
	@FindBy(id = "chkTaxInclusive")
	WebElement chkTaxInclusive;
	@FindBy(id = "calcTaxAmount")
	WebElement calcTaxAmount;
	@FindBy(id = "calcSubTotal")
	WebElement calcSubTotal;
	@FindBy(id = "calcPrice4Unit")
	WebElement calcPrice4Unit;
	@FindBy(id = "touchPad1")
	WebElement touchPad1;
	// Buttons elements
	@FindBy(id = "btnSave")
	WebElement btnUpdate;
	@FindBy(id = "btnCancel")
	WebElement btnCancel;

	// WebElement Initialization method
	public PUR_ItemEditPopup() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void activatePage() {
		pageName.click();
	}

	public void clickUpdateButton() {
		btnUpdate.click();
	}

	public void clickCancelButton() {
		btnCancel.click();
	}

	public void clickCloseButton() {
		btnClose.click();
	}

	// Operations
	public void ProductEditDetails(String DiscountType, String ReqdIncTax, String ReqdTax1, String ReqdTax2,
			String ReqdTax3) {
		calcQuantityValue.sendKeys(GenericMethods.fnGenRandNumber(10, 1));
		calcUnitPrice.sendKeys(GenericMethods.fnGenRandNumber(9999, 1));

		switch (DiscountType.toLowerCase()) {
		case "percentage":
			calcDiscountRate.sendKeys(GenericMethods.fnGenRandNumber(100, 1));
			break;
		case "cash":
			calcCashDiscount.sendKeys(GenericMethods.fnGenRandNumber(9999, 1));
			break;
		}

		if (ReqdTax1.equals("Yes")) {
			lookupTax1.sendKeys("CGST @ 14%");
			lookupTax1.click();
		} else if (ReqdTax2.equals("Yes")) {
			lookupTax2.sendKeys("SGST @ 14%");
			lookupTax2.click();
		} else if (ReqdTax3.equals("Yes")) {
			lookupTax3.sendKeys("CGST @ 14%");
			lookupTax3.click();
		}

		switch (ReqdIncTax.toLowerCase()) {
		case "yes":
			chkTaxInclusive.click();
			break;
		case "no":
			break;
		}
		// save the changes
		clickUpdateButton();
	}

}
