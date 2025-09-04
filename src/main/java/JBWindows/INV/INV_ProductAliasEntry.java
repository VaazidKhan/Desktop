package JBWindows.INV;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;
import commonClass.GenericMethods;

public class INV_ProductAliasEntry extends BaseClass{

	@FindBy(id = "INV_ProductAliasEntry") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "txtProductCode") WebElement txtProductCode;
	@FindBy(id = "txtProductName") WebElement txtProductName;
	@FindBy(id = "gcProductAlias") WebElement gcProductAlias;
	@FindBy(id = "btnSave") WebElement BtnSave;
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	
	/*
	 * -----------added by Moumita on 25/May/18------
	 */
	@FindBy(id = "396836") WebElement lookUpLanguage; 
	@FindBy(name = "Product Alias row 0") WebElement txtProductAlias; 
	

	public INV_ProductAliasEntry() {
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
	
	/*
	 * -----------added by Moumita on 25/May/18--------------- 
	 * This method is to set the product alias from product page
	 * Parameters are strLanguge & strProductAlias
	 */

	public void fnSetProductAlias(String strLanguge, String strProductAlias)
	{		
		
		Actions builder = new Actions(driver);
		builder.moveToElement(gcProductAlias, 100,80).click().build().perform();
		gcProductAlias.sendKeys(strLanguge);
		builder.moveToElement(gcProductAlias, 200,80).click().build().perform();
		gcProductAlias.sendKeys(strProductAlias);
		builder.moveToElement(gcProductAlias, 500,80).click().build().perform();
		fnWriteSteps("Pass", "Product Alias has been selected successfully");
		GenericMethods.fnwait(1);
		clickSaveButton();
		GenericMethods.fnwait(1);
		
	}
}
