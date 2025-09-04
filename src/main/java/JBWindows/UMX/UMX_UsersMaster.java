package JBWindows.UMX;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;

public class UMX_UsersMaster extends BaseClass{
	// Header elements
	@FindBy(id = "picClose")	WebElement btnClose;
	@FindBy(id = "lblCaption")	WebElement PageCaption;
	@FindBy(id = "picLogo")	WebElement HeaderJBLogo;
	
	// Master page elements
	@FindBy(id = "UMX_UsersMaster")	WebElement pageName;
	@FindBy(id = "txtSearch")	WebElement txtSearch;

	// Entry OR Edit screen elements
	@FindBy(id = "txtUsername")	WebElement txtUsername;
	@FindBy(id = "txtPassword")	WebElement txtPassword;
	@FindBy(id = "txtName")	WebElement txtName;
	@FindBy(id = "lookupRole")	WebElement lookupRole;
	@FindBy(id = "lookupAccessLevel")	WebElement lookupAccessLevel;
	@FindBy(id = "txtEmail")	WebElement txtEmail;
	@FindBy(id = "txtMobile")	WebElement txtMobile;
	@FindBy(id = "txtPhoneNo")	WebElement txtPhoneNo;
	@FindBy(id = "dtActivationDate")	WebElement dtActivationDate;
	@FindBy(id = "dtExpirationDate")	WebElement dtExpirationDate;
	@FindBy(id = "memoDescription")	WebElement memoDescription;
	@FindBy(id = "ChkEnable")	WebElement ChkEnable;

	// Buttons elements
	@FindBy(id = "btnAdd")	WebElement btnAdd;
	@FindBy(id = "btnSave")	WebElement btnEdit;
	@FindBy(id = "btnSave")	WebElement btnSave;
	@FindBy(id = "btnCancel")	WebElement btnCancel;
	
	//WebElement Initialization method
	public UMX_UsersMaster() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void clickCreateNewButton()
	{
		btnAdd.click();
	}
	public void clickEditButton()
	{
		btnEdit.click();
	}
	public void clickSaveButton()
	{
		btnSave.click();
	}
	public void clickCancelButton()
	{
		btnCancel.click();
	}
	public void clickCloseButton()
	{
		btnClose.click();
	}
	
	//Operations
	public void activatePage()
	{
		pageName.click();
	}
	public UMX_UsersMaster CreateNewRecord()
	{
		txtUsername.sendKeys("");
		txtPassword.sendKeys("");
		txtName.sendKeys("");
		lookupRole.sendKeys("");
		lookupAccessLevel.sendKeys("");
		txtEmail.sendKeys("");
		txtMobile.sendKeys("");
		txtPhoneNo.sendKeys("");
		dtActivationDate.sendKeys("");
		dtExpirationDate.sendKeys("");
		memoDescription.sendKeys("");
		ChkEnable.click();
		
		//save the changes
		btnSave.click();
		
		//redirect to master page
		return new UMX_UsersMaster();
	}
}
