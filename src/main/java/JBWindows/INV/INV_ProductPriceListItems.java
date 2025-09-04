package JBWindows.INV;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class INV_ProductPriceListItems extends BaseClass {

	@FindBy(id = "INV_ProductPriceListItems")
	WebElement pageName;
	@FindBy(id = "picClose")
	WebElement BtnClose;
	@FindBy(id = "txtProductCode")
	WebElement txtProductCode;
	@FindBy(id = "txtProductName")
	WebElement txtProductName;
	@FindBy(id = "gcProductPriceCatelog")
	WebElement gcProductPriceCatelog;
	@FindBy(id = "btnSave")
	WebElement BtnSave;
	@FindBy(id = "btnCancel")
	WebElement BtnCancel;

	// 3-May-2018--Added by Moumita--------
	@FindBy(name = "Unit Price row 0")
	WebElement txtUnitPriceStandardSalesPrice;
	@FindBy(name = "Unit Price row 1")
	WebElement txtUnitPriceHappyHours;
	@FindBy(name = "Unit Price row 2")
	WebElement txtUnitPriceStandardPurchasePrice;

	// 4-May-2018--Added by Moumita--------
	@FindBy(name = "Tax Group row 0")
	WebElement cboTaxGroupStandardSalesPrice;
	@FindBy(name = "Tax Group row 1")
	WebElement cboTaxGroupHappyHours;
	@FindBy(name = "Tax Group row 2")
	WebElement cboTaxGroupStandardPurchasePrice;
	@FindBy(name = "Discount row 0")
	WebElement cboDiscountStandardSalesPrice;
	@FindBy(name = "Discount row 1")
	WebElement cboDiscountHappyHours;
	@FindBy(name = "Discount row 2")
	WebElement cboDiscountStandardPurchasePrice;

	@FindBy(name = "Inclusive Tax row 0")
	WebElement chkInclusiveTaxStandardSalesPrice;
	@FindBy(name = "Inclusive Tax row 1")
	WebElement chkInclusiveHappyHours;
	@FindBy(name = "Inclusive Tax row 2")
	WebElement chkInclusiveStandardPurchasePrice;

	public INV_ProductPriceListItems() {
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

	// 3-May-2018--Added by Moumita--------
	// This is the method to modify product unit price from product master page
	// parameters are priceList & rowNumber_ModifiedPrice
	int count = 0;

	public void fnVerifyProductUnitPriceEditFromMasterPage(String priceList, int rowNumber_ModifiedPrice) {
		count = count + 1;
		switch (priceList.toUpperCase()) {
		case "STANDARD_SALES_PL":
			txtUnitPriceStandardSalesPrice.clear();
			txtUnitPriceStandardSalesPrice.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
					"Transaction_Invoice_TakeAway", rowNumber_ModifiedPrice, 28).trim());
			fnWriteSteps("Pass", "Product price has been modified successfully for Standard Sales Price List " + count);
			break;
		case "STANDARD_PURCHASE_PL":
			txtUnitPriceStandardPurchasePrice.clear();
			txtUnitPriceStandardPurchasePrice
					.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
							"Transaction_Invoice_TakeAway", rowNumber_ModifiedPrice, 29).trim());
			fnWriteSteps("Pass",
					"Product price has been modified successfully for Standard Purchase Price List " + count);
			break;
		case "HAPPY_HOURS_PL":
			txtUnitPriceHappyHours.clear();
			txtUnitPriceHappyHours.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
					"Transaction_Invoice_TakeAway", rowNumber_ModifiedPrice, 30).trim());
			fnWriteSteps("Pass", "Product price has been modified successfully for HAppy Hours Price List " + count);
			break;
		}

	}

	// 4-May-2018--Added by Moumita--------
	// This is the method to update the tax group of a product from product master
	// page
	// parameters are priceList & rowNumber_TaxGroup
	public void fnVerifyProductTaxGroupUpdateFromMasterPage(String priceList, int rowNumber_TaxGroup) {
		switch (priceList.toUpperCase()) {
		case "STANDARD_SALES_PL":
			cboTaxGroupStandardSalesPrice.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
					"Transaction_Invoice_TakeAway", rowNumber_TaxGroup, 31).trim());
			cboTaxGroupStandardSalesPrice.click();
			fnWriteSteps("Pass", "Tax Group has been modified successfully for Standard Sales Price List");
			break;
		case "STANDARD_PURCHASE_PL":
			cboTaxGroupStandardPurchasePrice
					.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
							"Transaction_Invoice_TakeAway", rowNumber_TaxGroup, 32).trim());
			cboTaxGroupStandardPurchasePrice.click();
			fnWriteSteps("Pass", "Tax Group has been modified successfully for Standard Purchase Price List");
			break;
		case "HAPPY_HOURS_PL":
			cboTaxGroupHappyHours.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
					"Transaction_Invoice_TakeAway", rowNumber_TaxGroup, 33).trim());
			cboTaxGroupHappyHours.click();
			fnWriteSteps("Pass", "Tax Group has been modified successfully for Happy Hours Price List");
			break;
		}
	}

	// This is the method to update the discount of a product from product master
	// page
	// parameters are priceList & rowNumber_DiscountRule
	public void fnVerifyProductDiscountUpdateFromMasterPage(String priceList, int rowNumber_DiscountRule) {
		switch (priceList.toUpperCase()) {
		case "STANDARD_SALES_PL":
			cboDiscountStandardSalesPrice.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
					"Transaction_Invoice_TakeAway", rowNumber_DiscountRule, 34).trim());
			cboDiscountStandardSalesPrice.click();
			fnWriteSteps("Pass", "Discount Rule has been modified successfully for Standard Sales Price List");
			break;
		case "STANDARD_PURCHASE_PL":
			cboDiscountStandardPurchasePrice
					.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
							"Transaction_Invoice_TakeAway", rowNumber_DiscountRule, 35).trim());
			cboDiscountStandardPurchasePrice.click();
			fnWriteSteps("Pass", "Discount Rule has been modified successfully for Standard Purchase Price List");
			break;
		case "HAPPY_HOURS_PL":
			cboDiscountHappyHours.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
					"Transaction_Invoice_TakeAway", rowNumber_DiscountRule, 36).trim());
			cboDiscountHappyHours.click();
			fnWriteSteps("Pass", "Discount Rule has been modified successfully for Happy Hours Price List");
			break;
		}
	}

	// This is the method to apply inclusive tax of a product from product master
	// page
	// parameters is priceList
	public void fnEnableExclusiveTaxFromMasterPage(String priceList) {
		switch (priceList.toUpperCase()) {
		case "STANDARD_SALES_PL":
			Actions builder1 = new Actions(driver);
			builder1.moveToElement(gcProductPriceCatelog, 910, 80).click().build().perform();
			BtnSave.click();
			fnWriteSteps("Pass", "Exclusive Tax has been enabled successfully for Standard Sales Price List");
			break;
		case "STANDARD_PURCHASE_PL":
			Actions builder2 = new Actions(driver);
			builder2.moveToElement(gcProductPriceCatelog, 910, 120).click().build().perform();
			BtnSave.click();
			fnWriteSteps("Pass", "Exclusive Tax has been enabled successfully for Standard Purchase Price List");
			break;
		case "HAPPY_HOURS_PL":
			Actions builder3 = new Actions(driver);
			builder3.moveToElement(gcProductPriceCatelog, 910, 100).click().build().perform();
			BtnSave.click();
			fnWriteSteps("Pass", "Exclusive Tax has been enabled successfully for Happy Hours Price List");
			break;
		}
	}
}
