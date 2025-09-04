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

public class PUR_PurchaseInvoice extends BaseClass{
	// Header elements
	@FindBy(id = "PUR_PurchaseInvoice")	 WebElement pageName;
	@FindBy(id = "picClose")	         WebElement btnClose;
	@FindBy(id = "lblCaption")	         WebElement PageCaption;
	@FindBy(id = "picLogo")	             WebElement HeaderJBLogo;
	//Master page elements
	@FindBy(id = "txtSearch")	    WebElement txtSearch;
	@FindBy(id = "grdGRNListView")	WebElement grdGRNListView;
	@FindBy(id = "ReportPreview")	WebElement ReportPreview;
	// Buttons elements
	@FindBy(id = "btnAdd")	        WebElement btnAdd;
	@FindBy(id = "btnEdit")	        WebElement btnEdit;
	@FindBy(id = "btnPrint")	    WebElement btnPrint;
	@FindBy(id = "btnFilter")	    WebElement btnFilter;
	@FindBy (id="dtInvoiceDate")    WebElement purchaseInvoiveDate;
	@FindBy (id="lookUpEdit")        WebElement purchaseOrderType;
	@FindBy (id="txtReferenceNo")
	WebElement referenceInvoiceNumber;
	@FindBy (id="dtReceivingDate")
	WebElement ReceivingDate;
	@FindBy (id="lookUpSupplier")
	WebElement supplier;
	@FindBy (id="btnPayment")
	WebElement payment;
	@FindBy (id="lblHeader")
	WebElement header;
	@FindBy (id="lblMessage")
	WebElement messageBox;
	@FindBy (id="btnOk")
	WebElement btnOk;
	@FindBy (id="btnSave")
	WebElement BtnSave;
	@FindBy(id = "grdBillingDetail")
	WebElement productGrid;
	@FindBy (id="buttonBack")
	WebElement btnBack;
	@FindBy (id="calcQuantityValue")
	WebElement txtQuantity;
	@FindBy(name ="Batch No. row 0")
	WebElement BatchNorow1;
	@FindBy(name ="Lot Size row 0")
	WebElement LotSizerow1;
	@FindBy(name ="Manufacturing Date row 0")
	WebElement ManufacturingDaterow1;
	@FindBy(name ="Expiration Date row 0")
	WebElement ExpirationDaterow1;
	@FindBy (id ="btnCash")
	WebElement Btncash;
	@FindBy (id="btnCard")
	WebElement BtnCard;
	@FindBy (id="calcAmount")
	WebElement amount;
	
	//WebElement Initialization method
		public PUR_PurchaseInvoice() {
			PageFactory.initElements(driver, this);
		}
		
		//Operations
		public void activatePage()
		{
			pageName.click();
		}
		public void clickCreateNewButton()
		{
			btnAdd.click();
		}
		public void clickEditButton()
		{
			btnEdit.click();
		}
		public void clickCloseButton()
		{
			btnClose.click();
		}
		public void click_On_Logo() {
			HeaderJBLogo.click();
		}
		public void search_Vochure(String strVochure) {
			GenericMethods.fnwait(2);
			driver.findElement(By.id("txtSearch")).sendKeys(strVochure);
		}
		public void click_Ok_Button() {
			header.click();
			btnOk.click();
		}
		
		public void Due_Operation_With_Card_PaymentMode(String strAmount,String strCardNo) {
			HeaderJBLogo.click();
			BtnCard.click();
			GenericMethods.fnwait(2);
			HeaderJBLogo.click();
			GenericMethods.fnwait(4);
			amount.clear();
			amount.sendKeys(strAmount);
			WebElement cardNo=driver.findElement(By.id("textCardNo"));
			cardNo.sendKeys(strCardNo);
			BtnSave.click();
			
		}
		public void click_On_Payment_Button() {
			payment.click();
		}
		
	  public void searchPurchaseInvoice(String purchaseInvoiceNo)
		{
			txtSearch.sendKeys(purchaseInvoiceNo);
			GenericMethods.fnwait(1);
			clickEditButton();
			GenericMethods.fnwait(1);
			fnWriteSteps("Pass", "Purchase invoice record search is successful");			
		}
		
		public void purchase_Invoice_Creation(String FieldType,String strPurchaseInvoiceDate,String strSupplier,String strReferenceNumber,String strReveivingDate,String strProduct,String SaveType) {
			click_On_Logo();
			GenericMethods.fnwait(3);
			GenericMethods.windows_Set_DropDown_Value(supplier, strSupplier.trim());
			switch (FieldType) {
			case "purchase invoice date":
				purchaseInvoiveDate.clear();
				purchaseInvoiveDate.sendKeys(strPurchaseInvoiceDate.trim());
				break;
			case "receiving date":
				ReceivingDate.clear();
				ReceivingDate.sendKeys(strReveivingDate.trim());
				break;
			case "reference invoice":
				referenceInvoiceNumber.sendKeys(strReferenceNumber.trim());
				break;
				
			case "invoice and reference":
				purchaseInvoiveDate.clear();
				purchaseInvoiveDate.sendKeys(strPurchaseInvoiceDate.trim());
				referenceInvoiceNumber.sendKeys(strReveivingDate.trim());
				break;
			}
			BtnSave.click();
		    txtSearch.sendKeys(strProduct.trim());
			switch (SaveType) {
			case "Hold":
				BtnSave.click();
				break;
				case "Payment":
				payment.click();
				break;
			}
			}
		
			
	//To get Purchase invoice Vochure
		public boolean get_Purchase_Invoice_Vochure(String strValidation) {
		    header.click();
			GenericMethods.fnwait(2);
			if(messageBox.getAttribute("Name").contains(strValidation)) {
				btnOk.click();
				return true;
			}
			return false;
		}
		public void click_On_Header() {
			header.click();
		}
		
		public String vochure_Modification_Page(String Modification,String strFieldValue) {
			GenericMethods.fnwait(3);
			String amount=driver.findElement(By.id("lblTotalAmountValue")).getAttribute("Name");
			switch (Modification) {
			case "Qunatity Modification":
				productGrid.click();
				PointerInfo a1 = MouseInfo.getPointerInfo();
				Point b1 = a1.getLocation();
				GenericMethods.fnwait(1);
				int x1 = (int) b1.getX();
				GenericMethods.fnwait(1);
				int y1 = (int) b1.getY();

				Robot r1;
				try {
					r1 = new Robot();
					r1.mouseMove(x1-75, y1-250);
				} catch (AWTException e) {
					e.printStackTrace();
				}
				GenericMethods.fnwait(1);
				Actions builder1 = new Actions(driver);
				builder1.click().build().perform();
				GenericMethods.fnwait(5);
				
				driver.findElement(By.id("touchPad1")).click();
				btnBack.click();
				btnBack.click();
				//txtQuantity.click();
				txtQuantity.clear();
			txtQuantity.sendKeys(strFieldValue);
			BtnSave.click();
			break;
			case "Add Product":
				txtSearch.sendKeys(strFieldValue);
				txtSearch.submit();
				break;
			case "delete":
				productGrid.click();
				PointerInfo a2 = MouseInfo.getPointerInfo();
				Point b2 = a2.getLocation();
				GenericMethods.fnwait(1);
				int x2 = (int) b2.getX();
				GenericMethods.fnwait(1);
				int y2 = (int) b2.getY();

				Robot r2;
				try {
					r2 = new Robot();
					r2.mouseMove(x2+150, y2-160);
				} catch (AWTException e) {
					e.printStackTrace();
				}
				GenericMethods.fnwait(1);
				Actions builder2 = new Actions(driver);
				builder2.click().build().perform();
				GenericMethods.fnwait(5);
				break;
				
			}
			return amount;
		}
		public boolean vochure_Deletion_From_History(String strRemarks) {
			PointerInfo a2 = MouseInfo.getPointerInfo();
			Point b2 = a2.getLocation();
				GenericMethods.fnwait(1);
				int x2 = (int) b2.getX();
				GenericMethods.fnwait(1);
				int y2 = (int) b2.getY();

				Robot r2;
				try {
					r2 = new Robot();
					r2.mouseMove(x2+350, y2+110);
				} catch (AWTException e) {
					e.printStackTrace();
				}
				GenericMethods.fnwait(1);
				Actions builder2 = new Actions(driver);
				builder2.click().build().perform();
				GenericMethods.fnwait(3);
				header.click();
				btnOk.click();
				HeaderJBLogo.click();
				driver.findElement(By.name("Delete remarks")).sendKeys(strRemarks);
				WebElement saveButton=driver.findElement(By.id("btnSave"));//click();
				if(saveButton.isDisplayed()) {
					saveButton.click();
					return true;
				}
				return false;
			
		}
		public void BatchNo_Generation_for_PurchaseInvoice(String strBatchNoProduct,String BatchNo1,String Lotsize,String ManufacturingDate,String ExpiryDate,String ProductManagedBy ) {
			
			 GenericMethods.fnwait(2);
		    txtSearch.sendKeys(strBatchNoProduct.trim());
		    txtSearch.submit();
		    GenericMethods.fnwait(3);
		    switch(ProductManagedBy) {
		    case "With batch No":
		    	click_On_Logo();
			    BatchNorow1.sendKeys(BatchNo1);
				LotSizerow1.sendKeys(Lotsize);
				ManufacturingDaterow1.sendKeys(ManufacturingDate);
				ExpirationDaterow1.sendKeys(ExpiryDate);
				 GenericMethods.fnwait(1);
				
			break;
		}
	}
		public boolean Validate_Adding_of_BatchNumber() {
		    if(driver.findElement(By.id("lblCaption")).getAttribute("Name").contains("Add Batch Numbers".trim())) {
				 GenericMethods.fnwait(1);
				 btnOk.click();
				return true;
				}
				return false; 
		}
		public boolean Validate_Existed_BatchNumber() {
			header.click();
		    if(driver.findElement(By.id("lblMessage")).getAttribute("Name").contains("Batch number already exists.".trim())) {
				 GenericMethods.fnwait(1);
				 btnOk.click();
				return true;
				}
				return false; 
		}
		public void Enter_Supplier_Details(String strSupplier) {
			click_On_Logo();
			GenericMethods.fnwait(2);
			GenericMethods.windows_Set_DropDown_Value(supplier, strSupplier.trim());
			BtnSave.click();
			
		}
		public boolean Validate_paymentButton() {
			if(payment.isDisplayed()&&payment.isEnabled()){
				return true;
			}
			    return false;
		}
		public void Purchase_Product_Quantity_Modification(String strFieldValue) {
			productGrid.click();
			PointerInfo a1 = MouseInfo.getPointerInfo();
			Point b1 = a1.getLocation();
			GenericMethods.fnwait(1);
			int x1 = (int) b1.getX();
			GenericMethods.fnwait(1);
			int y1 = (int) b1.getY();

			Robot r1;
			try {
				r1 = new Robot();
				r1.mouseMove(x1-75, y1-250);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			GenericMethods.fnwait(1);
			Actions builder1 = new Actions(driver);
			builder1.click().build().perform();
			GenericMethods.fnwait(5);
			
			driver.findElement(By.id("touchPad1")).click();
			btnBack.click();
			btnBack.click();
			txtQuantity.clear();
		    txtQuantity.sendKeys(strFieldValue);
		    BtnSave.click();
		}
		public void Generate_BatchNO(String BatchNo1,String Lotsize,String ManufacturingDate,String ExpiryDate) {
			click_On_Logo();
		    BatchNorow1.sendKeys(BatchNo1);
			LotSizerow1.sendKeys(Lotsize);
			ManufacturingDaterow1.sendKeys(ManufacturingDate);
			ExpirationDaterow1.sendKeys(ExpiryDate);
			 GenericMethods.fnwait(1);
			
		}
		
		}

		

		

