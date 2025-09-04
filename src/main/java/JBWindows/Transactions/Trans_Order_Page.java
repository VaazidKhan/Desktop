package JBWindows.Transactions;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonClass.BaseClass;
import commonClass.GenericMethods;


public class Trans_Order_Page extends BaseClass {
	@FindBy(id = "btnSalesOrderType")
	WebElement dropsalesordertype;

	@FindBy(id = "btnCustomer")
	WebElement BtnCustomer;

	@FindBy(id = "txtSearch")
	WebElement txtSearchBox;

	@FindBy(id = "btnAll")
	WebElement categories;

	// Footer Elements

	@FindBy(id = "btnRecall")
	WebElement    BtnRecall;

	@FindBy(id = "btnCancel")
	WebElement    BtnCancel;

	@FindBy(id = "btnDiscount")
	WebElement discount;

	@FindBy(id = "btnDashBoard")
	WebElement btnDashboard;

	@FindBy(id = "txtSearch")
	WebElement txtSearchBoxCustomer;

	@FindBy(id = "txtFirstName")
	WebElement TxtFirstName;

	@FindBy(id = "btnPayment")
	WebElement btnSaveandEstimation;

	@FindBy(id = "txtPhoneNo")
	WebElement TxtPhoneNo;

	@FindBy(id = "cboCustomerType")
	WebElement dropCustType;

	

	@FindBy(id = "btnSave")
	WebElement btnSaveCustomer;

	@FindBy(id ="btnOk")
	WebElement BtnOk;

	@FindBy(id = "memoInstruction")
	WebElement txtBoxInstructions;

	@FindBy(id = "grdBillingDetail")
	WebElement productGrid;

	@FindBy(id = "calcQuantityValue")
	WebElement txtQuantity;

	@FindBy(id = "btnFinish")
	WebElement BtnFinish;

	@FindBy(id = "buttonBack")
	WebElement btnBack;
	

	@FindBy(id = "txtDoorNo")
	WebElement TxtDoorNo;

	@FindBy(id = "txtStreetName")
	WebElement TxtStreetName;

	@FindBy(id = "txtArea")
	WebElement TxtArea;

	@FindBy(id = "txtZipCode")
	WebElement TxtZipCode;
	
	@FindBy(id = "picLogo")
	WebElement jbPicLogo;

	@FindBy(id = "dtDueDate")
	WebElement dropDueDate;
	
	@FindBy(id="lblHeader")
	WebElement Header;
	
	@FindBy(id = "lblMessage")
	WebElement txtOrder;
	
	@FindBy (id="btnConvert")
	WebElement BtnConvert;
	@FindBy (id="textVoucherNo")
	WebElement txtVochureNo;
	@FindBy (id="btnCash")
	WebElement BtnCash;
	@FindBy (id="btnCard")
	WebElement BtnCard;
	@FindBy (id="btnWallet")
	WebElement BtnWallet;
	@FindBy (id="btnBank")
	WebElement BtnBank;
	@FindBy (id="btnVoucher")
	WebElement btnVochure;
	@FindBy (id="btnCheque")
	WebElement BtnCheque;
	@FindBy (id="btnCredit")
	WebElement btnCreditOnAccount;
	@FindBy (id="btnLoyaltyWallet")
	WebElement btnRedeem;
	@FindBy (id="btnCreditNote")
	WebElement btnCreditNote;
	@FindBy (id="btnAdvanceReceived")
	WebElement btnAdvancedCollections;
	@FindBy (id="calcAmount")
	WebElement btnAmount;
	@FindBy (id="btnConfirm")
	WebElement btnConfirmation;
	@FindBy (name="Line Down")
	WebElement btnScrollDown;
	@FindBy (id="lookUpEdit")
	WebElement dropDown;
	@FindBy (id="textReferenceNo")
	WebElement txtReferenceNo;
	@FindBy (id="textBankName")
	WebElement txtBankName;
	@FindBy (id="textChequeNo")
	WebElement txtChequeNo;
	@FindBy (id="textBranchName")
	WebElement txtBranchName;
	@FindBy (id="calcAmount")
	WebElement amount;
	@FindBy (id="dtVoucherDate")
	WebElement vochureDate;
	@FindBy (id="btnReturn")
	WebElement btnReturn;
	@FindBy (id = "btnProductAliasSelection")
	WebElement ProductAlias;
	@FindBy (id = "lblDiscountValue")
	WebElement DiscountValue;
	@FindBy(name ="Selected Quantity row 0")
	WebElement SelectedQNTY;
	@FindBy (name ="row 0")
	WebElement SelectSymbol;
	@FindBy (id = "btnSelectExisting")
	WebElement SelectExisting;
	@FindBy (name = "Select row 0")
	WebElement SelectCheckBox;
	
	public Trans_Order_Page() {
		PageFactory.initElements(driver, this);
	}
	public void click_On_Close_Image() {
		jbPicLogo.click();
		driver.findElement(By.id("picClose")).click();
	}
	public void click_On_DashBoard() {
		btnDashboard.click();
	}
	public void click_On_OK_Button() {
		Header.click();
		BtnOk.click();
	}
	public void click_On_SAVE_Button() {
		btnSaveCustomer.click();
	}
	public void click_On_Cancel_Button() {
		BtnCancel.click();
	}
	public String get_Vochure_Date() {
		jbPicLogo.click();
		GenericMethods.fnwait(2);
		String vochure=vochureDate.getAttribute("Name");
		return vochure;
	}
	public void Click_On_Payment_Cash() {
		GenericMethods.fnwait(2);
		jbPicLogo.click();
		BtnCash.click();
		GenericMethods.fnwait(2);
		jbPicLogo.click();
		driver.findElement(By.id("btnNotes1")).click();
		btnSaveCustomer.click();
	}
	public void Sales_Product_Quantity_Modification(String strFieldValue) {
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
			r1.mouseMove(x1-75, y1-200);
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
	    btnSaveCustomer.click();
	}
	
	// Functions to Create Sales Order
	public String sales_Order_Creation_page(String strSalesOrderType,String strProduct,String Customer,
		String strCustType,String strFirstName,String strPhoneNo,String Date,String strDate,String strInstructions) {
		GenericMethods.fnwait(3);
		if(strSalesOrderType.trim()!="STANDARD") {
        GenericMethods.select_Standard_SalesOrderType(dropsalesordertype, strSalesOrderType);
		}
		GenericMethods.windows_Set_TextBoxValue(txtSearchBox, strProduct);
		GenericMethods.fnwait(2);
		
		switch (Customer) {
		case "existingcustomer":
			BtnCustomer.click();
			GenericMethods.fnwait(3);
            GenericMethods.windows_Set_TextBoxValue(txtSearchBoxCustomer, strPhoneNo);
            txtSearchBoxCustomer.submit();
            GenericMethods.fnwait(2);
	        break;
		case "runtimecustomer":
			BtnCustomer.click();
			if(strCustType!="B2C") {
			dropCustType.sendKeys(strCustType);
			}
			dropCustType.submit();
			TxtFirstName.sendKeys(strFirstName);
			TxtPhoneNo.sendKeys(strPhoneNo);
			btnSaveCustomer.click();
			break;
         }
		GenericMethods.fnwait(2);
		btnSaveCustomer.click();
		jbPicLogo.click();
		switch (Date) {
		case "Due Date":
			dropDueDate.sendKeys(strDate);
			break;
		}
		txtBoxInstructions.sendKeys(strInstructions);
		btnSaveCustomer.click();
		
		
		Header.click();
		String orderVochure=txtOrder.getAttribute("Name").split(" ")[5];
		BtnOk.click();
		return orderVochure;
		
	}
	public boolean validate_Sales_Order_Creation(String salesOrderVochure) {
		boolean result=false;
		BtnRecall.click();
		driver.findElement(By.id("txtSearch")).sendKeys(salesOrderVochure);
	int act=driver.findElements(By.name("Order No. row 0")).size();
	if(act==1) {
		result=true;
	}
	BtnOk.click();
	GenericMethods.fnwait(3);
	btnSaveCustomer.click();
	btnSaveCustomer.click();
	BtnOk.click();
		return result;
	}
	//Order creation for Home Delivery
	
	public String sales_Order_Creation_HomeDelivery_Page(String strSalesOrderType,String strProduct,String Customer,
			String strCustType,String strFirstName,String strPhoneNo,String strDoorNo,String strStreetName,String strArea,String  strZipcode) {
		
		GenericMethods.select_Standard_SalesOrderType(dropsalesordertype, strSalesOrderType);

		GenericMethods.fnwait(2);
		BtnCustomer.click();
		switch (Customer) {
		case "existing":
			GenericMethods.windows_Set_TextBoxValue(txtSearchBoxCustomer, strPhoneNo);
            txtSearchBoxCustomer.submit();
            GenericMethods.fnwait(2);
			break;
		case "new":
			dropCustType.sendKeys(strCustType);
			dropCustType.submit();
			TxtFirstName.sendKeys(strFirstName);
			TxtPhoneNo.sendKeys(strPhoneNo);
			TxtDoorNo.sendKeys(strDoorNo);
			TxtStreetName.sendKeys(strStreetName);
			TxtArea.sendKeys(strArea);
			TxtZipCode.sendKeys(strZipcode);
			btnSaveCustomer.click();
			break;
		}
		GenericMethods.windows_Set_TextBoxValue(txtSearchBox, strProduct);
		GenericMethods.fnwait(2);
		btnSaveCustomer.click();
		jbPicLogo.click();
		btnSaveCustomer.click();
		
			jbPicLogo.click();
		        TxtArea.click();
			    TxtArea.sendKeys(strArea);
			GenericMethods.fnwait(2);
			btnSaveCustomer.click();
			Header.click();
			String orderVochure=txtOrder.getAttribute("Name").split(" ")[5];
			BtnOk.click();
			return orderVochure;
			/*if(!orderVochure.equals(null)  &&  !orderVochure.equals("")) {
				return true;
			}
			return false;*/
			//boolean result=false;
			/*BtnRecall.click();
			driver.findElement(By.id("txtSearch")).sendKeys(orderVochure);
		int act=driver.findElements(By.name("Order No. row 0")).size();
		if(act==1) {
			BtnOk.click();
			result=true;
		}
		
		GenericMethods.fnwait(3);
		btnSaveCustomer.click();
		btnSaveCustomer.click();
		btnSaveCustomer.click();
		BtnOk.click();*/
		//return result;
			
	}
	//methods for Sales Order Modification
	public String sales_Order_Modification_Page(String strSalesOrder,String PageType,String Modification,String strFieldValue,String Invoice){
		GenericMethods.fnwait(1);
		switch (PageType) {
		case "recall":
			GenericMethods.fnwait(4);
			BtnRecall.click();
			txtSearchBox.sendKeys(strSalesOrder);
		    BtnOk.click();
		break;
		}
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
				r1.mouseMove(x1-75, y1-150);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			GenericMethods.fnwait(1);
			Actions builder1 = new Actions(driver);
			builder1.click().build().perform();
			GenericMethods.fnwait(5);
			
			driver.findElement(By.id("touchPad1")).click();
			btnBack.click();
			txtQuantity.clear();
		    txtQuantity.sendKeys(strFieldValue);
		    jbPicLogo.click();
		    
		switch (Invoice) {
		case "invoice":
			GenericMethods.fnwait(2);
			btnScrollDown.click();
			break;
			}
		
	    GenericMethods.fnwait(2);
	    btnSaveCustomer.click();
		break;
		case "Add Product":
			GenericMethods.fnwait(5);
			txtSearchBox.sendKeys(strFieldValue);
			txtSearchBox.submit();
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
				r2.mouseMove(x2+150, y2-190);
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
		
		public boolean validate_Sales_Order_Modification(String amount) {
		boolean result=false;
			
		String amountAfterModify=driver.findElement(By.id("lblTotalAmountValue")).getAttribute("Name");
		if(!amountAfterModify.equals(amount)) {
			GenericMethods.fnwait(3);
			btnSaveCustomer.click();
			btnSaveCustomer.click();
			Header.click();
			BtnOk.click();
			result=true;
		}
		return result;
		
	}
	//Method to convert to Sales Invoice
	public String sales_Order_To_Sales_Invoice_Conversion(String strSalesOrder,String  Customer,String strInstructions ) {
		
	String invoiceVochure=null;
	    BtnRecall.click();
		GenericMethods.fnwait(3);
		txtSearchBox.sendKeys(strSalesOrder);
		BtnOk.click();
		GenericMethods.fnwait(3);
		GenericMethods.fnwait(1);
		BtnConvert.click();
		GenericMethods.fnwait(3);
		Header.click();
		GenericMethods.fnwait(3);
		BtnOk.click();
		GenericMethods.fnwait(4);
		jbPicLogo.click();
		
		switch (Customer) {
		case "With Customer":
			
		  BtnFinish.click();
		  GenericMethods.fnwait(3);
		 Header.click();
		 GenericMethods.fnwait(3);
		 BtnOk.click();
		 GenericMethods.fnwait(3);
		 jbPicLogo.click();
		 GenericMethods.fnwait(3);
		 txtBoxInstructions.sendKeys(strInstructions);
		 GenericMethods.fnwait(3);
		 btnSaveCustomer.click();
		 GenericMethods.fnwait(3);
		Header.click();
		GenericMethods.fnwait(3);
	  invoiceVochure=txtOrder.getAttribute("Name").split(" ")[5];
		GenericMethods.fnwait(3);
		BtnOk.click();
		break;
		case "Without Customer":
          
			invoiceVochure=txtVochureNo.getAttribute("Name");
			GenericMethods.fnwait(2);
			BtnFinish.click();
			GenericMethods.fnwait(2);
			Header.click();
			BtnOk.click();
			BtnCancel.click();
			break;
		}
			
		return 	invoiceVochure;
	}
	
	//Sales Order Converted To Sales Invoice Modification Validation
	
	public boolean validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(String salesOrderVochure) {
		boolean result=false;
		BtnRecall.click();
		driver.findElement(By.id("txtSearch")).sendKeys(salesOrderVochure);
	int act=driver.findElements(By.name("Order No. row 0")).size();
	if(act==0) {
		result=true;
	}
	GenericMethods.fnwait(2);
	jbPicLogo.click();
	BtnCancel.click();
	return result;
	
	}

	
	//Invoice Creation
	
	public void sales_Invoice_Creation_Page( String strSalesOrderType,String strProduct,String strProduct1,String Customer,String strCustType,
		String strFirstName,String strPhoneNo,String PaymentType) {
			GenericMethods.fnwait(3);
			if(!strSalesOrderType.trim().equals("STANDARD")) {
			GenericMethods.select_Standard_SalesOrderType(dropsalesordertype, strSalesOrderType);
			}
			GenericMethods.fnwait(6);
			GenericMethods.windows_Set_TextBoxValue(txtSearchBox, strProduct);
			ProductAlias.click();
			GenericMethods.windows_Set_TextBoxValue(txtSearchBox, strProduct1);
			GenericMethods.fnwait(2);
		     switch (Customer) {
			
			case "existingcustomer":
				
				BtnCustomer.click();
				GenericMethods.fnwait(2);
				txtSearchBoxCustomer.click();
				GenericMethods.windows_Set_TextBoxValue(txtSearchBoxCustomer, strPhoneNo.trim());
				GenericMethods.fnwait(2);
                txtSearchBoxCustomer.submit();
                GenericMethods.fnwait(2);
				

				break;
			case "runtimecustomer":
				
				BtnCustomer.click();
				if(strCustType!="B2C") {
				dropCustType.sendKeys(strCustType);
				}
				dropCustType.submit();
				TxtFirstName.sendKeys(strFirstName);
				TxtPhoneNo.sendKeys(strPhoneNo);
				btnSaveCustomer.click();
				break;

			}
			
			GenericMethods.fnwait(2);
			switch (PaymentType) {
			case "Hold":
				btnSaveCustomer.click();
				Header.click();
				GenericMethods.fnwait(2);
				BtnOk.click();
				break;
            case "Payment":
				btnSaveandEstimation.click();
				break;
			}
	}
	public void click_On_Hold_Button() {
		GenericMethods.fnwait(2);
		btnSaveCustomer.click();
	}
	
	public void click_On_Payment() {
		btnSaveandEstimation.click();
	}
	public void send_Instructions(String strInstructions){
		jbPicLogo.click();
		txtBoxInstructions.sendKeys(strInstructions);
		btnSaveCustomer.click();
	}
	
		//payment Method
		public void payment_Page(String Payment,String strAmount,String strCardNo,String strWallet,String strBankAccNo,String strReference,
			String strBankName,String strVochureType,String strVochureNo,String  strChequeNo,String strBranch,String strInstructions,
			String strCreditNote,String strAdvanceAmount,String strAmount1,String strAmount2,String BankCheck,String ChequeCheck ){
			GenericMethods.fnwait(4);
			jbPicLogo.click();
			switch (Payment) {
			case "Cash":
				BtnCash.click();
				GenericMethods.fnwait(2);
				jbPicLogo.click();
				driver.findElement(By.id("btnNotes1")).click();
				btnSaveCustomer.click();
				break;

			case "Card":
				BtnCard.click();
				GenericMethods.fnwait(2);
				jbPicLogo.click();
				GenericMethods.fnwait(4);
				amount.clear();
				amount.sendKeys(strAmount);
				WebElement cardNo=driver.findElement(By.id("textCardNo"));
				cardNo.sendKeys(strCardNo);
				btnSaveCustomer.click();
				break;
				
			case "Wallet":
				BtnWallet.click();
				GenericMethods.fnwait(2);
				jbPicLogo.click();
				GenericMethods.fnwait(2);
				driver.findElement(By.name(strWallet)).click();
				btnAmount.clear();
				btnAmount.sendKeys(strAmount);
				btnConfirmation.click();
				break;
			case "Bank":
				BtnBank.click();
				GenericMethods.fnwait(2);
				jbPicLogo.click();
				GenericMethods.fnwait(3);
				dropDown.click();
				dropDown.sendKeys(strBankAccNo);
				dropDown.submit();
				txtReferenceNo.sendKeys(strReference);
				switch (BankCheck) {
				case "invoice":
					txtBankName.sendKeys(strBankName);
					break;
				}
				btnAmount.clear();
				btnAmount.sendKeys(strAmount);
				btnSaveCustomer.click();
				break;
			case "Gift Vochure":
				btnVochure.click();
				GenericMethods.fnwait(2);
				jbPicLogo.click();
				GenericMethods.fnwait(2);
				driver.findElement(By.name(strVochureType)).click();
				GenericMethods.fnwait(4);
				WebElement vochureNO=driver.findElement(By.id("textGiftVoucherNo"));
				vochureNO.sendKeys(strVochureNo);
				btnAmount.clear();
				btnAmount.sendKeys(strAmount);
				btnSaveCustomer.click();
				break;
			case "Cheque":
				BtnCheque.click();
				GenericMethods.fnwait(2);
				jbPicLogo.click();
				GenericMethods.fnwait(2);
				GenericMethods.windows_Set_DropDown_Value(dropDown, strBankAccNo);
				txtChequeNo.sendKeys(strChequeNo);
				
				switch (ChequeCheck) {
				case "invoice":
					txtBankName.sendKeys(strBankName);
					txtBranchName.sendKeys(strBranch);
				   break;
				}
				btnAmount.clear();
				btnAmount.sendKeys(strAmount);
				btnSaveCustomer.click();
			     break;
			case "Credit On Account":
				btnCreditOnAccount.click();
				GenericMethods.fnwait(2);
				jbPicLogo.click();
				GenericMethods.fnwait(2);
				GenericMethods.fn_SetTextBoxValue(txtBoxInstructions, strInstructions);
				GenericMethods.fnwait(2);
				btnSaveCustomer.click();
				break;
			case "Redeem":
				btnRedeem.click();
				GenericMethods.fnwait(2);
				jbPicLogo.click();
				GenericMethods.fnwait(2);
				WebElement calAmountRedeemed=driver.findElement(By.id("calcAmountRedeemed"));
				calAmountRedeemed.clear();
				calAmountRedeemed.sendKeys(strAmount);
				btnSaveCustomer.click();
				break;
			case "Credit Note":
				btnCreditNote.click();
				GenericMethods.fnwait(2);
				jbPicLogo.click();
				GenericMethods.fnwait(2);
				GenericMethods.windows_Set_DropDown_Value(dropDown, strCreditNote);
				GenericMethods.windows_Set_TextBoxValue(btnAmount, strAmount);
				GenericMethods.fnwait(3);
				btnSaveCustomer.click();
				break;
			case "Advanced Received":
				btnAdvancedCollections.click();
				GenericMethods.fnwait(2);
				jbPicLogo.click();
				GenericMethods.fnwait(2);
				GenericMethods.windows_Set_DropDown_Value(dropDown, strAdvanceAmount);
				GenericMethods.windows_Set_TextBoxValue(btnAmount, strAmount);
				btnSaveCustomer.click();
				break;
			case "Advance Paid":
			driver.findElement(By.id("btnAdvancePaid")).click();
			GenericMethods.fnwait(2);
			jbPicLogo.click();
			GenericMethods.fnwait(2);
			GenericMethods.windows_Set_DropDown_Value(dropDown, strAdvanceAmount);
				GenericMethods.windows_Set_TextBoxValue(btnAmount, strAmount);
			btnSaveCustomer.click();
			break;
			case "Debit Note":
				driver.findElement(By.id("btnDebitNote")).click();
				GenericMethods.fnwait(2);
				jbPicLogo.click();
				GenericMethods.fnwait(2);
				
				GenericMethods.windows_Set_DropDown_Value(dropDown, strAdvanceAmount);
				
					GenericMethods.windows_Set_TextBoxValue(btnAmount, strAmount);
			
				btnSaveCustomer.click();
				break;
				
			case "All Payments":
				BtnCard.click();
				GenericMethods.fnwait(2);
				jbPicLogo.click();
				GenericMethods.fnwait(4);
				amount.clear();
				amount.sendKeys(strAmount);
				WebElement cardNO=driver.findElement(By.id("textCardNo"));
				cardNO.sendKeys(strCardNo);
				btnSaveCustomer.click();
				BtnWallet.click();
				GenericMethods.fnwait(2);
				jbPicLogo.click();
				GenericMethods.fnwait(2);
				driver.findElement(By.name(strWallet)).click();
				btnAmount.clear();
				btnAmount.sendKeys(strAmount1);
				btnConfirmation.click();
				BtnBank.click();
				GenericMethods.fnwait(2);
				jbPicLogo.click();
				GenericMethods.fnwait(2);
				dropDown.sendKeys(strBankAccNo);
				dropDown.submit();
				txtReferenceNo.sendKeys(strReference);
				switch (BankCheck) {
				case "invoice":
					txtBankName.sendKeys(strBankName);
					break;
				}
				btnAmount.clear();
				btnAmount.sendKeys(strAmount2);
				btnSaveCustomer.click();
				break;
			}
		}
			public void click_Scroll_Down() {
				
				GenericMethods.fnwait(2);
				 driver.findElement(By.name("Line Down")).click();
				 driver.findElement(By.name("Line Down")).click();
				GenericMethods.fnwait(2);
				
			}
			public void click_Finish_Button() {
				BtnFinish.click();
			}
			
			public void payment_Due_Operations(String strInstructions){
				
				Header.click();
				GenericMethods.fnwait(2);
				BtnOk.click();
				GenericMethods.fnwait(2);
				jbPicLogo.click();
				txtBoxInstructions.sendKeys(strInstructions);
				btnSaveCustomer.click();
				}
			
			public String get_Vochure_Page() {
				
				Header.click();
				GenericMethods.fnwait(2);
				String Vochure=txtOrder.getAttribute("Name");
				BtnOk.click();
				return Vochure;
			}
			
			
			
			//Method to get Invoice number for hold Customer
			
			public void get_Invoice_Vochure(String strVochure) {
				BtnRecall.click();
				GenericMethods.fnwait(1);
				jbPicLogo.click();
				txtSearchBox.sendKeys(strVochure);
				BtnOk.click();
				}
			
			public boolean validate_Sales_Vochure_Page(String strVochure) {
				
				if(strVochure.trim().contains("Your invoice number is")) {
					return true;
				}
				return false;
				
			}
			
			//validate Hold Sales invoice hold
			public boolean validate_Sales_Invoice_Hold(String txtValidate) {
				GenericMethods.fnwait(2);
				Header.click();
				if(txtOrder.getAttribute("Name").contains(txtValidate.trim())) {
					BtnOk.click();
					return true;
				}
				return false;
			}
			public boolean click_On_Header() {
				GenericMethods.fnwait(2);
				driver.findElement(By.id("lblHeader")).click();
				GenericMethods.fnwait(2);
				if(driver.findElement(By.id("lblMessage")).getAttribute("Name").contains("completed successfully".trim())) {
					BtnOk.click();
					return true;
				}
				return false;
			}
			
			//Validate Sales Invoice Modification
			
			public void validate_Sales_Invoice_Modification(String amount,String Type ) {
				
				String amountAfterModify=driver.findElement(By.id("lblTotalAmountValue")).getAttribute("Name");
				if(!amountAfterModify.equals(amount)) {
					GenericMethods.fnwait(3);
					switch (Type) {
					case "Hold":
						click_On_Hold_Button();
						break;
					case "Payment":
						click_On_Payment();
						break;
					}
			}
				
			
	}
			public void click_Return_Button() {
				btnReturn.click();
				
			}
			public void return_Type(String returnType ) {
				switch (returnType) {
				case "refund":
					driver.findElement(By.id("btnRefund")).click();
					break;

				case "Exchange":
					driver.findElement(By.id("btnExchange")).click();
					break;
				}
			}
			
			public boolean return_Payment_Details(String PaymentType) {
				jbPicLogo.click();
				boolean result=false;
				switch (PaymentType) {
				case "Wallet":
					WebElement wallet=driver.findElement(By.id("btnWallet"));
					if(wallet.isDisplayed()) {
						wallet.click();
						result=true;	
					}
					break;

				case "Cash":
					WebElement cash=driver.findElement(By.id("btnCash"));
					if(cash.isDisplayed()) {
						cash.click();
						result=true;
					}
					break;
				}
				return result;
			}
			public void click_OK_Button() {
				jbPicLogo.click();
				GenericMethods.fnwait(2);
				BtnOk.click();
			}
			public void enter_Product_Details(String strProduct) {
				txtSearchBox.click();
				txtSearchBox.sendKeys(strProduct);
				txtSearchBox.submit();
			}
			public void Select_Customer_Details(String strCustomer) {
				BtnCustomer.click();
				GenericMethods.fnwait(3);
			    GenericMethods.windows_Set_TextBoxValue(txtSearchBoxCustomer, strCustomer);
	            txtSearchBoxCustomer.submit();
			}
			
			public void click_Payment_Button() {
				driver.findElement(By.id("btnPayment")).click();
			}
			
			public void click_Header_Button() {
				Header.click();
				GenericMethods.fnwait(2);
				BtnOk.click();
			}
			public void get_Vochure_From_Grid(String strSearchEntity) {
				driver.findElement(By.id("btnRecall")).click();
				GenericMethods.fnwait(2);
				driver.findElement(By.id("txtSearch")).sendKeys(strSearchEntity);
				GenericMethods.fnwait(2);
			}
   // This Method for SalesInvoice Creation with MultipleDiscounts 
   public float fnVerify_SalesInvoice_With_MultipleDiscounts(String Modification) {
	   float Expedisc = 0;
	   GenericMethods.fnwait(2);
	   String TotalAmount = driver.findElement(By.id("lblTotalAmountValue")).getAttribute("Name");
	   System.out.println("TotalAMT is "  + TotalAmount);
	   String TotAmt = TotalAmount.substring(0, 0) + ' ' + TotalAmount.substring(1);
	   System.out.println("Total Amt after Substring" +TotAmt.trim());
	   float TA =Float.parseFloat(TotAmt.trim());
	   System.out.println("Total Amt after FloatConvertion" +TA);
	   GenericMethods.fnwait(2);
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
				r1.mouseMove(x1-75, y1-150);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			GenericMethods.fnwait(1);
			Actions builder1 = new Actions(driver);
			builder1.click().build().perform();
			jbPicLogo.click();
			GenericMethods.fnwait(5);
        String ProductPrice =driver.findElement(By.id("calcUnitPrice")).getAttribute("Name");
		System.out.println("Product Price is" +ProductPrice);
		String ProPrice = ProductPrice.substring(0, 0) + ' ' + ProductPrice.substring(1);
		System.out.println("Product Price after Substring is " +ProPrice.trim());
		float PP =Float.parseFloat(ProPrice.trim());  
		System.out.println("Product Price after FloatConvertion is "+PP);
		GenericMethods.fnwait(2);
	    Expedisc = PP-TA;
		System.out.println("Expected Discount is "+ Expedisc);
		GenericMethods.fnwait(5);
		 break;
	 }
		
	    GenericMethods.fnwait(1);
	    btnSaveCustomer.click();
	    GenericMethods.fnwait(2);
	    return Expedisc;
	    
	   }
   
  
       public float Get_ActualDiscount() {
	   String ActualDisc = driver.findElement(By.id("lblDiscountValue")).getAttribute("Name");
	    System.out.println("Actual Disc is " +ActualDisc);
	    String ActDisc = ActualDisc.substring(0, 0) + ' ' + ActualDisc.substring(1);
		System.out.println("Actual Disc after Substring" +ActDisc);
	   float AD = Float.parseFloat(ActDisc); 
	    System.out.println("Actual discount after FloatConverstion is " +AD);
	    return AD;
   }
     public boolean Validate_AppliedDiscount(float ExpectedDisc,float ActualDisc) {
    	 if (ExpectedDisc==(ActualDisc)) {
    		 
    		 return true;
        }
    	 return false;

    	 }
     public void BatchNo_Selection_for_SalesInvoice(String SelectProduct,String strBatchNoProduct,String Quantity) {
    	    
    	   switch(SelectProduct) {
		    case "Select Product":
		    	GenericMethods.fnwait(2);
	    	    txtSearchBox.sendKeys(strBatchNoProduct.trim());
	    	    txtSearchBox.submit();
			    GenericMethods.fnwait(3);
		    break;
		    }
		    jbPicLogo.click();
	    	 GenericMethods.windows_Set_TextBoxValue(SelectedQNTY, Quantity);
	    	 GenericMethods.fnwait(2);
     }
     public boolean Validate_BatchNO_Selected_or_Not() {
    	 if(driver.findElement(By.id("lblCaption")).getAttribute("Name").contains("Select Batch Numbers".trim())) {
			 GenericMethods.fnwait(1);
			 btnSaveCustomer.click();
			return true;
		}
			return false; 
	}
     public boolean Validate_ExchangeAmount_Lessthan_ExchangeLimit_allowed_or_Not() {
    	 Header.click();
    	 if(driver.findElement(By.id("lblMessage")).getAttribute("Name").contains("Total amount must be greater than exchange limit.".trim())) {
			 GenericMethods.fnwait(1);
			 BtnOk.click();
			return true;
		}
			return false; 
    	 
    	 
     }
     public void Select_BatchNo() throws FindFailed {
    	 jbPicLogo.click();
    	 Screen screen=new Screen();
		  Pattern pr = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\SquareSymbol.PNG");
		  screen.click(pr);
		  GenericMethods.fnwait(1);
     }
     public void BatchNo_Selection(String Quantity) {
    	 jbPicLogo.click();
    	 SelectExisting.click();
    	 GenericMethods.fnwait(1);
    	 SelectCheckBox.click();
    	 GenericMethods.windows_Set_TextBoxValue(SelectedQNTY, Quantity);
    	 GenericMethods.fnwait(2);
     }
     public boolean Validation_of_BatchNo_with_LessQuantity() {
    	 GenericMethods.fnwait(1);
    	 btnSaveCustomer.click();
    	 GenericMethods.fnwait(1);
    	 BtnOk.click();
    	 if(driver.findElement(By.id("lblMessage")).getAttribute("Name").contains("Total created should be equal to total needed.".trim())) {
    		 GenericMethods.fnwait(1);
    		 BtnOk.click();
    		 return true;
 		}
 			return false; 
    	 }
    
     
    public String Sales_Order_Creation_To_Convert_Invoice_While_Selecting_BatchNo(String strSalesOrderType,String Customer,String strProduct,String strCustomer,String strInstructions) {
    	GenericMethods.fnwait(3);
    	if(strSalesOrderType.trim()!="STANDARD") {
    	GenericMethods.select_Standard_SalesOrderType(dropsalesordertype, strSalesOrderType);
    			}
    	GenericMethods.windows_Set_TextBoxValue(txtSearchBox,strProduct);
    	GenericMethods.fnwait(2);
    	switch(Customer) {
    	case"Without Customer":
    		btnSaveCustomer.click();
        break;
    	
        case"With Customer":
       Select_Customer_Details(strCustomer);
       btnSaveCustomer.click();
       break;
      }
       jbPicLogo.click();
   	  txtBoxInstructions.sendKeys(strInstructions);
   	  btnSaveCustomer.click();
    	Header.click();
    	String orderVochure=txtOrder.getAttribute("Name").split(" ")[5];
    	BtnOk.click();
    	return orderVochure;
    			
    			
    	 }
    public void fnRecordDelete() {

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
			r2.mouseMove(x2+150, y2-110);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		GenericMethods.fnwait(1);
		Actions builder2 = new Actions(driver);
		builder2.click().build().perform();
		GenericMethods.fnwait(5);
	}
    
   public void BatchNo_Selection_while_Order_To_Invoice_Convertion(String strSalesOrder,String ConvertionFor) {
	    BtnRecall.click();
		GenericMethods.fnwait(3);
		txtSearchBox.sendKeys(strSalesOrder);
		BtnOk.click();
		GenericMethods.fnwait(3);
		GenericMethods.fnwait(1);
		switch(ConvertionFor){
		case "Partially":
			fnRecordDelete();
			GenericMethods.fnwait(3);
		break;
		}
		BtnConvert.click();
		GenericMethods.fnwait(2);
      }
  }




	
	



