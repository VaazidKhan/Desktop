package JBWindows.INV;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonClass.BaseClass;
import commonClass.GenericMethods;


public class INV_ProductPurchasing extends BaseClass{
	
	@FindBy(id = "INV_ProductPurchasing") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "txtProductCode") WebElement txtProductCode;
	@FindBy(id = "txtProductName") WebElement txtProductName;
	@FindBy(id = "gcProductSuppliers") WebElement gcProductSuppliers;
	@FindBy(id = "btnSave") WebElement BtnSave;
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	
	@FindBy(name = "Supplier Name row 0") WebElement txtSupplierName;
	@FindBy(name = "Editing control") WebElement editingControl;
	
	// ----4-May-18----Added by Moumita------------
	public INV_ProductPurchasing() {
		PageFactory.initElements(driver, this);
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickCancelButton()
	{
		BtnCancel.click();
	}
	
	public void clickSaveButton()
	{
		BtnSave.click();
	}
	
	// ----4-May-18----Added by Moumita------------
	public void fnVerifyProductSupplierMapping(String supplierName) {		
		
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(gcProductSuppliers, 250,50).click().build().perform();	
		GenericMethods.fnwait(1);		
		editingControl.sendKeys(supplierName);
		BtnSave.click();
		GenericMethods.fnwait(1);		
		fnWriteSteps("Pass", "Supplier-Product mapping has been done successfully");
	}
}
