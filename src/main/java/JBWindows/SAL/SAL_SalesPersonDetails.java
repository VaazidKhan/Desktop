package JBWindows.SAL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class SAL_SalesPersonDetails extends BaseClass{

	@FindBy(id = "SAL_SalesPersonDetails") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "calcTotalAmount") WebElement calcTotalAmount;
	@FindBy(id = "LookUpAgents") WebElement LookUpAgents;
	@FindBy(id = "txtStartTime") WebElement txtStartTime;
	@FindBy(id = "txtVahicleNo") WebElement txtVahicleNo;
	@FindBy(id = "txtEWayBillNo") WebElement txtEWayBillNo;
	
	@FindBy(id = "btnCancel") WebElement BtnCancel;
	@FindBy(id = "btnSave") WebElement BtnSave;


	public SAL_SalesPersonDetails() {
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

	public void selectAgent(int rowNumber) {
		
		LookUpAgents.sendKeys(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Delivery", rowNumber, 1));
		LookUpAgents.click();
		GenericMethods.fnwait(1);
		clickSaveButton();
		GenericMethods.fnwait(2);
	}
}
