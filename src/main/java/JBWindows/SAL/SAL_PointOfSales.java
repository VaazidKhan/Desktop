package JBWindows.SAL;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class SAL_PointOfSales extends BaseClass {

	@FindBy(id = "SAL_PointOfSales")
	WebElement pageName;
	@FindBy(id = "appTitleBar1")
	WebElement appTitleBar1;
	@FindBy(id = "appBilling1")
	WebElement appBilling1;
	@FindBy(id = "appStatusBar1")
	WebElement appStatusBar1;
	@FindBy(id = "btnBack")
	WebElement BtnBack;

	@FindBy(id = "btnDelivery")
	WebElement BtnDelivery;
	@FindBy(id = "btnSalesOrderType")
	WebElement BtnSalesOrderType;
	@FindBy(id = "btnCustomer")
	WebElement BtnCustomer;
	@FindBy(id = "btnAll")
	WebElement BtnAllCategory;

	@FindBy(id = "btnDiscount")
	WebElement BtnTaxDiscount;
	@FindBy(id = "txtSearch")
	WebElement txtCustomerSearch;
	@FindBy(id = "btnPayment")
	WebElement BtnPayment;
	@FindBy(id = "btnPayment")
	WebElement BtnSave;

	@FindBy(id = "btnRecall")
	WebElement BtnRecall;
	@FindBy(id = "btnReturn")
	WebElement BtnReturn;
	@FindBy(id = "btnRefund")
	WebElement BtnRefund;
	@FindBy(id = "btnExchange")
	WebElement BtnExchange;

	@FindBy(id = "btnCancel")
	WebElement BtnCancel;
	@FindBy(id = "btnSave")
	WebElement BtnHold;
	@FindBy(id = "lblTotalAmountLabel")
	WebElement BtnBillBreakUp;
	@FindBy(id = "LookUpTableNo")
	WebElement LookUpTableNo;

	@FindBy(id = "picSelectTable")
	WebElement BtnTable;
	@FindBy(id = "btnProductAliasSelection")
	WebElement BtnProductAlias;
	@FindBy(id = "btnPriceListCode")
	WebElement BtnPriceList;
	@FindBy(id = "btnShort")
	WebElement BtnShortBy;

	@FindBy(id = "btnDashBoard")
	WebElement BtnDashBoard;
	@FindBy(id = "btnConvert")
	WebElement BtnConvert;
	@FindBy(id = "txtBarcodeScan")
	WebElement txtBarcodeScan;

	// -------20-Feb-2018----added by Moumita---------

	@FindBy(id = "txtSearch")
	WebElement ProductSearch;

	// -------7-Feb-2018----added by Moumita--------

	@FindBy(name = "layoutControlItem16")
	WebElement ItemList;
	@FindBy(id = "grdProductList")
	WebElement grdProductList;
	@FindBy(id = "grdBillingDetail")
	WebElement grdBillingDetail;
	@FindBy(id = "txtFirstName")
	WebElement txtFirstName;
	@FindBy(id = "txtPhoneNo")
	WebElement txtPhoneNo;

	// -------8-Feb-2018----added by Moumita--------
	@FindBy(id = "txtLastName")
	WebElement txtLastName;
	@FindBy(id = "txtEmail")
	WebElement txtEmail;
	@FindBy(id = "txtDoorNo")
	WebElement txtDoorNo;
	@FindBy(id = "txtStreetName")
	WebElement txtStreetName;
	@FindBy(id = "txtArea")
	WebElement txtArea;
	@FindBy(id = "lookUpEdit")
	WebElement lookUpState;
	@FindBy(id = "lookupCity")
	WebElement lookupCity;
	@FindBy(id = "txtZipCode")
	WebElement txtZipCode;
	@FindBy(id = "memoBillingAddress")
	WebElement memoBillingAddress;
	@FindBy(id = "lblMessage")
	WebElement lblMessage;

	// ----25-April-18----Added by Moumita-------------
	@FindBy(id = "lblTotalAmountValue")
	WebElement totalAmountValue;

	// ----2-May-18----Added by Moumita-------------
	@FindBy(name = "Home Delivery")
	WebElement btnHomeDelivery;
	@FindBy(name = "Dine-In")
	WebElement btnDineIn;
	@FindBy(name = "Take Away")
	WebElement btnTakeAway;
	@FindBy(id = "grdBillingDetail")
	WebElement grdBillingCart;
	// ----3-May-18----Added by Moumita-------------
	@FindBy(name = "Line Down")
	WebElement btnLineDown;

	public SAL_PointOfSales() {
		PageFactory.initElements(driver, this);
	}

	public void activatePage() {
		pageName.click();
	}

	public void clickBackButton() {
		BtnBack.click();
	}

	public void clickDeliveryButton() {
		BtnDelivery.click();
	}

	public void clickDashboardButton() {
		BtnDashBoard.click();
	}

	public void clickConvertButton() {
		BtnConvert.click();
	}

	public void clickPriceListButton() {
		BtnPriceList.click();
	}

	public void clickShortByButton() {
		BtnShortBy.click();
	}

	public void clickProductAliasButton() {
		BtnProductAlias.click();
	}

	public void clickTableButton() {
		BtnTable.click();
	}

	public void clickBillBreakupButton() {
		BtnBillBreakUp.click();
	}

	public void clickHoldButton() {
		BtnHold.click();
	}

	public void clickCancelButton() {
		BtnCancel.click();
	}

	public void clickExchangeButton() {
		BtnExchange.click();
	}

	public void clickRefundButton() {
		BtnRefund.click();
	}

	public void clickReturnButton() {
		BtnReturn.click();
	}

	public void clickRecallButton() {
		BtnRecall.click();
	}

	public void clickSaveButton() {
		BtnSave.click();
	}

	public void clickPaymentButton() {
		BtnPayment.click();
	}

	public void clickAllCategoryButton() {
		BtnAllCategory.click();
	}

	public void clickCustomerButton() {
		BtnCustomer.click();
	}

	public void clickSalesOrderTypeButton() {
		BtnSalesOrderType.click();
	}

	// ----9-Feb-18----Added by Moumita-------------
	public void clickTaxDiscountButton() {
		BtnTaxDiscount.click();
	}

	// ----20-Feb-18----Added by Moumita-------------
	public void checkRefundIsSuccessfulOrNot() {
		if (BtnHold.isDisplayed()) {
			fnWriteSteps("Pass", "Refund is successful");
		} else {
			fnWriteSteps("Fail", "Refund is not successful");
		}
	}

	// ----6-Feb-18----Added by Moumita-------------
	// This is for creating the Estimation
	// Parameters are StartingRowNumber and LastRowNumber
	public void verifyTransactionRecordCreation(int StartingRowNumber_Customer, int StartingRowNumber_Product,
			int LastRowNumber_Product) {

		BtnCustomer.click();
		GenericMethods.fnwait(1);
		if (txtFirstName.isDisplayed()) {
			txtFirstName.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 0).toString());
		} else {
			fnWriteSteps("Fail", "First Name field is not visible in UI");
		}
		if (txtLastName.isDisplayed()) {
			txtLastName.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 1));
		} else {
			fnWriteSteps("Fail", "Last Name field is not enable");
		}
		if (txtPhoneNo.isDisplayed()) {
			txtPhoneNo.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 3));
		} else {
			fnWriteSteps("Fail", "Phone No field is not visible in UI");
		}
		if (txtEmail.isDisplayed()) {
			txtEmail.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 5));
		} else {
			fnWriteSteps("Fail", "Email field is not visible in UI");
		}
		if (txtDoorNo.isDisplayed()) {
			txtDoorNo.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 8));
		} else {
			fnWriteSteps("Fail", "Door No field is not visible in UI");
		}
		if (txtStreetName.isDisplayed()) {
			txtStreetName.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 9));
		} else {
			fnWriteSteps("Fail", "Street name field is not visible in UI");
		}
		if (txtArea.isDisplayed()) {
			txtArea.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 10));
		} else {
			fnWriteSteps("Fail", "Area field is not visible in UI");
		}
		if (lookUpState.isDisplayed()) {
			lookUpState.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 12));
			lookUpState.click();
		} else {
			fnWriteSteps("Fail", "State field is not visible in UI");
		}
		if (lookupCity.isDisplayed()) {
			lookupCity.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 13));
			lookupCity.click();
		} else {
			fnWriteSteps("Fail", "City field is not visible in UI");
		}
		if (txtZipCode.isDisplayed()) {
			txtZipCode.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 11));
		} else {
			fnWriteSteps("Fail", "Zip code field is not visible in UI");
		}
		if (memoBillingAddress.isDisplayed()) {
			memoBillingAddress.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
					"Customers", StartingRowNumber_Customer, 14));
		} else {
			fnWriteSteps("Fail", "Billing Address field is not visible in UI");
		}

		BtnHold.click();
		if (ProductSearch.isDisplayed()) {
			ProductSearch.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Estimations",
					StartingRowNumber_Product, 1).toString());
			grdProductList.click();
			GenericMethods.fnwait(2);
		} else {
			fnWriteSteps("Fail", "Prouduct search is not displayed in UI");
		}

		clickSaveButton();
		GenericMethods.fnwait(1);
	}

	// ----7-Feb-18----Added by Moumita-------------
	// This is for creating the Take Away Estimation
	// Parameters are StartingRowNumber and LastRowNumber

	public void VerifyRuntimeCustmerAndTransactionCreation(int StartingRowNumber_Customer,
			int StartingRowNumber_Product, int LastRowNumber_Product) {

		BtnCustomer.click();
		GenericMethods.fnwait(1);
		if (txtFirstName.isDisplayed()) {
			txtFirstName.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 0).toString());
		} else {
			fnWriteSteps("Fail", "First Name field is not visible in UI");
		}
		if (txtLastName.isDisplayed()) {
			txtLastName.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 1));
		} else {
			fnWriteSteps("Fail", "Last Name field is not enable");
		}
		if (txtPhoneNo.isDisplayed()) {
			txtPhoneNo.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 3));
		} else {
			fnWriteSteps("Fail", "Phone No field is not visible in UI");
		}
		if (txtEmail.isDisplayed()) {
			txtEmail.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 5));
		} else {
			fnWriteSteps("Fail", "Email field is not visible in UI");
		}
		if (txtDoorNo.isDisplayed()) {
			txtDoorNo.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 8));
		} else {
			fnWriteSteps("Fail", "Door No field is not visible in UI");
		}
		if (txtStreetName.isDisplayed()) {
			txtStreetName.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 9));
		} else {
			fnWriteSteps("Fail", "Street name field is not visible in UI");
		}
		if (txtArea.isDisplayed()) {
			txtArea.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 10));
		} else {
			fnWriteSteps("Fail", "Area field is not visible in UI");
		}
		if (lookUpState.isDisplayed()) {
			lookUpState.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 12));
			lookUpState.click();
		} else {
			fnWriteSteps("Fail", "State field is not visible in UI");
		}
		if (lookupCity.isDisplayed()) {
			lookupCity.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 13));
			lookupCity.click();
		} else {
			fnWriteSteps("Fail", "City field is not visible in UI");
		}
		if (txtZipCode.isDisplayed()) {
			txtZipCode.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers",
					StartingRowNumber_Customer, 11));
		} else {
			fnWriteSteps("Fail", "Zip code field is not visible in UI");
		}
		if (memoBillingAddress.isDisplayed()) {
			memoBillingAddress.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
					"Customers", StartingRowNumber_Customer, 14));
		} else {
			fnWriteSteps("Fail", "Billing Address field is not visible in UI");
		}

		BtnHold.click();
		fnWriteSteps("Pass", "Customer has been created successfully");

		for (int StartFromOne = StartingRowNumber_Product; StartFromOne <= LastRowNumber_Product; StartFromOne++) {
			if (ProductSearch.isDisplayed()) {

				ProductSearch.sendKeys(ExcelUtils
						.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Estimations", StartFromOne, 1)
						.toString());
				grdProductList.click();
				GenericMethods.fnwait(2);

			} else {
				fnWriteSteps("Fail", "Product search field is not visible in UI");
			}
		}
		clickSaveButton();
		GenericMethods.fnwait(2);
	}

	// ----9-Feb-18----Added by Moumita-------------
	// 21-April-2018--Modified by Moumita--------
	// This method is to add product to cart, while doing the transaction
	// Parameters are startingRowNumber_Product & lastRowNumber_Product
	public void addProductToCart(int startingRowNumber_Product, int lastRowNumber_Product) {
		for (int startFromOne = startingRowNumber_Product; startFromOne <= lastRowNumber_Product; startFromOne++) {
			if (ProductSearch.isDisplayed()) {

				String keyword = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Transaction_Invoice_TakeAway", startFromOne, 2).trim();

				ProductSearch.sendKeys(keyword);
				BtnAllCategory.click();
				GenericMethods.fnwait(2);

			} else {
				fnWriteSteps("Fail", "Prouduct search is not displayed in UI");
			}
		}
	} 
	
	/* 24/May/18--------Added by Moumita-----------
	 * This is the method to add single product to cart, while doing the transaction
	 * Parameter is strProductName
	 */	
	public void addProductToCartByProductName(String strProductName) {
		if (ProductSearch.isDisplayed()) {
			ProductSearch.sendKeys(strProductName);
			BtnAllCategory.click();
			GenericMethods.fnwait(2);
		} else {
			fnWriteSteps("Fail", "Prouduct search is not displayed in UI");
		}
	}

	/*// ----20-Feb-18----Added by Moumita-------------
	public void addProductToCartWithOutCustomer(int StartingRowNumber_Product, int LastRowNumber_Product) {
		for (int StartFromOne = StartingRowNumber_Product; StartFromOne <= LastRowNumber_Product; StartFromOne++) {
			ProductSearch.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Estimations",
					StartingRowNumber_Product, 1).toString());
			grdProductList.click();
			GenericMethods.fnwait(2);
		}
	}*/

	// ----25-April-18----Added by Moumita-------------
	public String getTotalAmount() {
		String totalAmount = null;
		WebElement totalAmountEle = driver.findElement(By.id("lblTotalAmountValue"));
		totalAmount = totalAmountEle.getAttribute("Name");
		return totalAmount;
	}

	// ----2-May-18----Added by Moumita------------
	// This is the method to select the Sales order type from Billing screen on run
	// time
	// Parameter is salesOrderType
	public void fnSelectSalesOrderType(int rowNumber_SOType) {

		String salesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", rowNumber_SOType, 39);
		switch (salesOrderType.toUpperCase()) {
		case "HOMEDELIVERY":
			clickSalesOrderTypeButton();
			GenericMethods.fnwait(1);
			btnHomeDelivery.click();
			fnWriteSteps("Pass", "Home Delivery sales order type has been selected successfully");
			break;

		case "TAKEAWAY":
			clickSalesOrderTypeButton();
			GenericMethods.fnwait(1);
			btnTakeAway.click();
			fnWriteSteps("Pass", "Take Away sales order type has been selected successfully");
			break;

		case "DINEIN":
			clickSalesOrderTypeButton();
			GenericMethods.fnwait(1);
			btnDineIn.click();
			fnWriteSteps("Pass", "Dine-In sales order type has been selected successfully");
			break;
		}
	}

	// ----2-May-18----Added by Moumita------------
	// This is the method to open the item edit window on runtime from Billing Cart
	// Parameter is product_Count
	public void fnVerifyBillingCartItemEditPopupOpen(int product_Count) throws AWTException {

		fnBillingCartItemEditPopupOpen(grdBillingCart, product_Count);

	}

	// ----2-May-18----Added by Moumita------------
	// This is the method to open the item edit window on runtime from Billing Cart
	// with the help of mouse pointer
	// Parameter are element & product_Count
	public static void fnBillingCartItemEditPopupOpen(WebElement element, int product_Count) throws AWTException {

		switch (product_Count) {

		case 1:
			element.click();
			PointerInfo a1 = MouseInfo.getPointerInfo();
			Point b1 = a1.getLocation();
			GenericMethods.fnwait(1);
			int x1 = (int) b1.getX();
			GenericMethods.fnwait(1);
			int y1 = (int) b1.getY();

			Robot r1 = new Robot();
			r1.mouseMove(x1, y1 - 200);
			GenericMethods.fnwait(1);
			Actions builder1 = new Actions(driver);
			builder1.click().build().perform();
			break;

		case 2:
			element.click();
			PointerInfo a2 = MouseInfo.getPointerInfo();
			Point b2 = a2.getLocation();
			GenericMethods.fnwait(1);
			int x2 = (int) b2.getX();
			GenericMethods.fnwait(1);
			int y2 = (int) b2.getY();

			Robot r2 = new Robot();
			r2.mouseMove(x2, y2 - 130);
			GenericMethods.fnwait(1);
			Actions builder2 = new Actions(driver);
			builder2.click().build().perform();
			break;

		case 3:
			element.click();
			PointerInfo a3 = MouseInfo.getPointerInfo();
			Point b3 = a3.getLocation();
			GenericMethods.fnwait(1);
			int x3 = (int) b3.getX();
			GenericMethods.fnwait(1);
			int y3 = (int) b3.getY();

			Robot r3 = new Robot();
			r3.mouseMove(x3, y3 - 50);
			GenericMethods.fnwait(1);
			Actions builder3 = new Actions(driver);
			builder3.click().build().perform();
			break;

		case 4:
			element.click();
			break;

		case 5:
			Actions builder5 = new Actions(driver);
			builder5.moveToElement(element, 155, 300).click().build().perform();
			break;

		case 6:
			Actions builder6 = new Actions(driver);
			builder6.moveToElement(element, 155, 360).click().build().perform();
			break;
		}
	}

	// ----15-May-18----Added by Moumita------------
	// This is the method to delete the item from Billing Cart
	// Parameter is product_Position
	public void fnRemoveProductFromBillingCartByDeleteIcon(int product_Position) {
		switch (product_Position) {

		case 1:
			Actions builder1 = new Actions(driver);
			builder1.moveToElement(grdBillingCart, 300, 50).click().build().perform();
			fnWriteSteps("Pass", "Item has been removed successfully from cart");
			break;

		case 2:
			Actions builder2 = new Actions(driver);
			builder2.moveToElement(grdBillingCart, 300, 80).click().build().perform();
			fnWriteSteps("Pass", "Item has been removed successfully from cart");
			break;

		case 3:
			Actions builder3 = new Actions(driver);
			builder3.moveToElement(grdBillingCart, 300, 110).click().build().perform();
			fnWriteSteps("Pass", "Item has been removed successfully from cart");
			break;

		case 4:
			Actions builder4 = new Actions(driver);
			builder4.moveToElement(grdBillingCart, 300, 160).click().build().perform();
			fnWriteSteps("Pass", "Item has been removed successfully from cart");
			break;

		case 5:
			Actions builder5 = new Actions(driver);
			builder5.moveToElement(grdBillingCart, 300, 270).click().build().perform();
			fnWriteSteps("Pass", "Item has been removed successfully from cart");
			break;

		case 6:
			Actions builder6 = new Actions(driver);
			builder6.moveToElement(grdBillingCart, 300, 340).click().build().perform();
			fnWriteSteps("Pass", "Item has been removed successfully from cart");
			break;
		}
	}
}
