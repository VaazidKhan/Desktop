package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;
import commonClass.GenericMethods;

public class SAL_SelectMofifier extends BaseClass{
	
	@FindBy(id = "SAL_SelectMofifier") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "grdModifier") WebElement grdModifier;
	
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnSave") WebElement BtnSave;


	public SAL_SelectMofifier() {
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
	
	public void fnSelectProductModifier()
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(grdModifier, 100,30).click().build().perform();	
		fnWriteSteps("Pass", "Product modifier has been selected successfully");
		GenericMethods.fnwait(1);
		clickSaveButton();
		GenericMethods.fnwait(1);
	}

}
