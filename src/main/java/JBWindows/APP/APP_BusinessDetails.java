package JBWindows.APP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;

public class APP_BusinessDetails extends BaseClass {
	// Header elements
	@FindBy(id = "picClose")
	WebElement btnClose;
	@FindBy(id = "lblCaption")
	WebElement PageCaption;
	@FindBy(id = "picLogo")
	WebElement HeaderJBLogo;

	// Organization details elements
	@FindBy(id = "picCompanyLogo")
	WebElement picCompanyLogo;
	@FindBy(id = "picClearImage")
	WebElement picClearImage;
	@FindBy(id = "APP_BusinessDetails")
	WebElement pageName;
	@FindBy(id = "txtCompanyName")
	WebElement txtCompanyName;
	@FindBy(id = "txtBusinessPhone")
	WebElement txtBusinessPhone;
	@FindBy(id = "txtBusinessOtherPhone")
	WebElement txtBusinessOtherPhone;
	@FindBy(id = "txtBusinessEmail")
	WebElement txtBusinessEmail;
	@FindBy(id = "txtWebsite")
	WebElement txtWebsite;
	@FindBy(id = "txtBusinessTinNo")
	WebElement txtBusinessTinNo;
	@FindBy(id = "txtBusinessVATNo")
	WebElement txtBusinessVATNo;
	@FindBy(id = "txtBusinessServiceTax")
	WebElement txtBusinessServiceTax;
	@FindBy(id = "txtBusinessGST")
	WebElement txtBusinessGST;
	@FindBy(id = "txtCIN")
	WebElement txtCIN;
	@FindBy(id = "memoBusinessAddress")
	WebElement memoBusinessAddress;

	// Branch details elements
	@FindBy(id = "txtBranch")
	WebElement txtBranch;
	@FindBy(id = "txtBranchEmail")
	WebElement txtBranchEmail;
	@FindBy(id = "txtBranchPhone")
	WebElement txtBranchPhone;
	@FindBy(id = "txtBranchOtherPhone")
	WebElement txtBranchOtherPhone;
	@FindBy(id = "txtBranchTinNo")
	WebElement txtBranchTinNo;
	@FindBy(id = "txtBranchVATNo")
	WebElement txtBranchVATNo;
	@FindBy(id = "txtBranchServiceTax")
	WebElement txtBranchServiceTax;
	@FindBy(id = "txtBranchGST")
	WebElement txtBranchGST;
	@FindBy(id = "lookupState")
	WebElement lookupState;
	@FindBy(id = "lookupCity")
	WebElement lookupCity;
	@FindBy(id = "memoBranchAddress")
	WebElement memoBranchAddress;
	@FindBy(id = "chkCompositeGST")
	WebElement chkCompositeGST;

	// Buttons elements
	@FindBy(id = "btnSave")
	WebElement btnSave;
	@FindBy(id = "btnCancel")
	WebElement btnCancel;

	// WebElement Initialization method
	public APP_BusinessDetails() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void clickSaveButton() {
		btnSave.click();
	}

	public void clickCancelButton() {
		btnCancel.click();
	}

	public void clickCloseButton() {
		btnClose.click();
	}

	// Operations
	public void activatePage() {
		pageName.click();
	}
	
	public void activateCompositGST()
	{
		chkCompositeGST.click();
	}

}
