package JBWindows.PUR;

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
import commonClass.BaseClass;
import commonClass.GenericMethods;

public class PUR_GoodsReceivedNotes extends BaseClass {
	// Header elements
	@FindBy(id = "PUR_GoodsReceivedNotes")
	WebElement pageName;
	@FindBy(id = "picClose")
	WebElement btnClose;
	@FindBy(id = "lblCaption")
	WebElement PageCaption;
	@FindBy(id = "picLogo")
	WebElement HeaderJBLogo;
	// Master page elements
	@FindBy(id = "txtSearch")
	WebElement TxtSearch;
	@FindBy(id = "grdGRNLinesView")
	WebElement GrdGRNLinesView;
	// Entry OR Edit screen elements
	@FindBy(id = "lookUpEdit")
	WebElement TransferOutOrderNo;
	@FindBy(id = "txtStockTransferNo")
	WebElement TxtStockTransferNo;
	@FindBy(name = "Received Quantity row 0")
	WebElement UpdateReceivedQnty;
	// Buttons elements
	@FindBy(id = "btnAdd")
	WebElement BtnAdd;
	@FindBy(id = "btnSave")
	WebElement BtnEdit;
	@FindBy(id = "btnSave")
	WebElement BtnSave;
	@FindBy(id = "btnCancel")
	WebElement BtnCancel;
	@FindBy (id="lblHeader")
	WebElement header;
	@FindBy(id ="btnOk")
	WebElement BtnOk;

	// WebElement Initialization method
	public PUR_GoodsReceivedNotes() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void activatePage() {
		pageName.click();
	}

	public void clickCreateNewButton() {
		BtnAdd.click();
	}

	public void clickEditButton() {
		BtnEdit.click();
	}

	public void clickSaveButton() {
		BtnSave.click();
	}

	public void clickCancelButton() {
		BtnCancel.click();
	}

	public void clickCloseButton() {
		HeaderJBLogo.click();
		btnClose.click();
	}
	public void GoodsReceivedNote_creation(String TransferoutNo,String ReceivedQNTY,String Type) {
		HeaderJBLogo.click();
		GenericMethods.windows_Set_DropDown_Value(TransferOutOrderNo,TransferoutNo);
		switch(Type) {
		case "Partial":
			GenericMethods.windows_Set_TextBoxValue(UpdateReceivedQnty,ReceivedQNTY );
			break;
		}
		clickSaveButton();
		
	}
	public void GoodsReceivedNote_Edit(String GRNVoucher,String ReceivedQNTY) {
		HeaderJBLogo.click();
		TxtSearch.click();
		TxtSearch.sendKeys(GRNVoucher);
		clickEditButton();
		GenericMethods.fnwait(2);
		UpdateReceivedQnty.click();
		UpdateReceivedQnty.clear();
		UpdateReceivedQnty.sendKeys(ReceivedQNTY);
		clickSaveButton();
		
	}
	
	public boolean Record_Deletion(String strVochure, String strRemarks)  {
		HeaderJBLogo.click();
		GenericMethods.windows_Set_TextBoxValue(TxtSearch, strVochure);
		GenericMethods.fnwait(3);
		PointerInfo a2 = MouseInfo.getPointerInfo();
	    Point b2 = a2.getLocation();
		GenericMethods.fnwait(1);
		int x2 = (int) b2.getX();
		GenericMethods.fnwait(1);
		int y2 = (int) b2.getY();

		Robot r2;
		try {
			r2 = new Robot();
			r2.mouseMove(x2+345, y2+82);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		GenericMethods.fnwait(1);
		Actions builder2 = new Actions(driver);
		builder2.click().build().perform();
		GenericMethods.fnwait(1);
		header.click();
		BtnOk.click();
		HeaderJBLogo.click();
		driver.findElement(By.name("Delete remarks")).sendKeys(strRemarks);
		WebElement saveButton=driver.findElement(By.id("btnSave"));
		if(saveButton.isDisplayed()) {
			saveButton.click();
			GenericMethods.fnwait(7);
			return true;
			

		}
		return false;
}
}
