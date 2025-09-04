package JBWindows.Transactions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonClass.BaseClass;
import commonClass.GenericMethods;

public class Stock_Transfer_Out_Page extends BaseClass {
	
	// Header elements
		@FindBy(id = "picClose")
		WebElement btnClose;
		@FindBy(id = "lblCaption")
		WebElement PageCaption;
		@FindBy(id = "picLogo")
		WebElement HeaderJBLogo;
		@FindBy(id = "btnAdd")
		WebElement BtnAdd;
		@FindBy(id = "btnSave")
		WebElement BtnSave;
		@FindBy(id = "btnSave")
		WebElement btnEdit;
		@FindBy(id = "btnCancel")
		WebElement BtnCancel;
		@FindBy(id = "lookUpEdit")
		WebElement RequisitionOrderNo;
		@FindBy(id = "txtSearch")
		WebElement TxtSearch;
		@FindBy(name = "Transfer Quantity row 0")
		WebElement UpdateTransqunty;
		@FindBy (id="lblHeader")
		WebElement header;
		@FindBy(id ="btnOk")
		WebElement BtnOk;
		
		public Stock_Transfer_Out_Page() {
			PageFactory.initElements(driver, this);
		}

		public void click_On_Add_Button() {
			BtnAdd.click();
		}
		public void click_On_Button_Ok() {
			BtnOk.click();
			}

		public void clickSaveButton() {
			BtnSave.click();
		}

		public void clickEditButton() {
			btnEdit.click();
		}

		
		public void clickCancelButton() {
			BtnCancel.click();
		}
		
		public void clickCloseButton() {
			HeaderJBLogo.click();
			btnClose.click();
		}
		public void Stock_Transfer_Out_creation(String RequisitionorderNo,String TransferQNTY,String Type) {
			HeaderJBLogo.click();
			GenericMethods.windows_Set_DropDown_Value(RequisitionOrderNo, RequisitionorderNo);
			switch(Type) {
			case "Partial":
				GenericMethods.windows_Set_TextBoxValue(UpdateTransqunty, TransferQNTY);
				break;
			}
			clickSaveButton();
			
		}
		public void Stock_Transfer_Out_Edit(String StocktransferoutVoucher,String TransferQNTY,String Quantity) {
			HeaderJBLogo.click();
			TxtSearch.click();
			TxtSearch.sendKeys(StocktransferoutVoucher);
			clickEditButton();
			GenericMethods.fnwait(2);
			UpdateTransqunty.click();
			UpdateTransqunty.clear();
			UpdateTransqunty.sendKeys(TransferQNTY);
			clickSaveButton();
			switch(Quantity){
				case "LorMQuantity":
					header.click();
					break;
				
			}
		}
			
			
			
		}

