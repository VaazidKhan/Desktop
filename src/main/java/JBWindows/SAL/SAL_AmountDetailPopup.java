package JBWindows.SAL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;

public class SAL_AmountDetailPopup extends BaseClass {

	@FindBy(id = "SAL_AmountDetailPopup")
	WebElement pageName;
	@FindBy(id = "picClose")
	WebElement BtnClose;

	// -----30-April-2018----Added by Moumita-----------
	@FindBy(id = "lblTotalInvoiceTax")
	WebElement lblTotalInvoiceTax;
	@FindBy(id = "lblTotalInvoiceDiscount")
	WebElement lblTotalInvoiceDiscount;
	@FindBy(id = "lblTotalItemDiscount")
	WebElement lblTotalItemDiscount;
	@FindBy(id = "lblExclusiveTax")
	WebElement lblExclusiveTax;
	@FindBy(id = "lblInclusiveTax")
	WebElement lblInclusiveTax;

	public void activatePage() {
		pageName.click();
	}

	public void clickCloseButton() {
		BtnClose.click();
	}

	// -----30-April-2018----Added by Moumita-----------

	public SAL_AmountDetailPopup() {
		PageFactory.initElements(driver, this);
	}

	// -----30-April-2018----Added by Moumita-----------
	// This is the method to get the applied invoice level total tax amount
	public String fnGetAppliedInvoiceLevelTaxAmount() {

		String amount = null;

		WebElement amountEle = driver.findElement(By.id("lblTotalInvoiceTax"));

		amount = amountEle.getAttribute("Name");
		String[] stringList = amount.split(":");
		String taxAmount = stringList[1];
		clickCloseButton();
		return taxAmount;
	}

	// This is the method to get the applied invoice level total discount amount
	public String fnGetAppliedInvoiceLevelDiscountAmount() {

		String amount = null;

		WebElement amountEle = driver.findElement(By.id("lblTotalInvoiceDiscount"));

		amount = amountEle.getAttribute("Name");
		String[] stringList = amount.split(":");
		String discountAmount = stringList[1];
		clickCloseButton();
		return discountAmount;
	}

	// This is the method to get the applied item level inclusive tax amount
	public String fnGetAppliedItemLevelInclusiveTaxAmount() {
		String amount = null;
		WebElement amountEle = driver.findElement(By.id("lblInclusiveTax"));

		amount = amountEle.getAttribute("Name");
		String[] stringList = amount.split(":");
		String taxInclusiveAmount = stringList[1];
		clickCloseButton();
		return taxInclusiveAmount;
	}

	// This is the method to get the applied invoice level total discount amount
	public String fnGetAppliedItemLevelDiscountAmount() {

		String amount = null;

		WebElement amountEle = driver.findElement(By.id("lblTotalItemDiscount"));

		amount = amountEle.getAttribute("Name");
		String[] stringList = amount.split(":");
		String discountAmount = stringList[1];
		clickCloseButton();
		return discountAmount;
	}
}
