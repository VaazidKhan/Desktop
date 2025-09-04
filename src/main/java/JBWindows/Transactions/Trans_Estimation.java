package JBWindows.Transactions;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonClass.BaseClass;
import commonClass.GenericMethods;

import org.apache.log4j.Logger;


public class Trans_Estimation extends BaseClass {
    Logger log = Logger.getLogger(Trans_Estimation.class);

	
	@FindBy (id="btnSalesOrderType")
	WebElement dropsalesordertype;
	
	@FindBy (id="btnCustomer")
	WebElement BtnCustomer;
	
	@FindBy (id="txtSearch")
	WebElement txtSearchBox;
	
	@FindBy (id="btnAll")
	WebElement categories;

	//Footer Elements
	
	@FindBy (id="btnRecall")
	WebElement BtnRecall;
	
	@FindBy (id="btnCancel")
	WebElement BtnCancel;
	
	@FindBy (id="btnDiscount")
	WebElement discount;
	
	@FindBy (id="btnPayment")
	WebElement btnSaveandEstimation;
	
	@FindBy (id="btnDashBoard")
	WebElement btnDashboard;
	
	// WebElements related to Customer Creation and To select customer
	
	@FindBy (id="txtSearch")
	WebElement txtSearchBoxCustomer;
	
	@FindBy (id="txtFirstName")
	WebElement TxtFirstName;
	
	
	@FindBy (id="txtPhoneNo")
	WebElement TxtPhoneNo;
	
	@FindBy (id="cboCustomerType")
	WebElement dropCustType;
	
	@FindBy (id="btnCancel")
	WebElement btnCancelCustomer;
	
	@FindBy (id="btnSave")
	WebElement btnSaveCustomer;
	
	@FindBy (id="btnOk")
	WebElement BtnOk;
	
	@FindBy (id="btnConvert")
	WebElement btnEstimationConvert;
	
	@FindBy (name="Order")
	WebElement radioOrder;
	
	@FindBy (name="Invoice")
	WebElement radioInvoice;
	
	@FindBy (id="memoInstruction")
	WebElement txtBoxInstructions;
	
	@FindBy (id="grdBillingDetail")
	WebElement productGrid;
	
	@FindBy (id="calcQuantityValue")
	WebElement txtQuantity;
	
	@FindBy (id="btnFinish")
	WebElement BtnFinish;
	
	@FindBy (id="buttonBack")
	WebElement btnBack;
	
	@FindBy (id="txtDoorNo")
	WebElement TxtDoorNo;
	
	@FindBy (id="txtStreetName")
	WebElement TxtStreetName;
	
	@FindBy (id="txtArea")
	WebElement TxtArea;
	
	@FindBy (id="txtZipCode")
	WebElement TxtZipCode;
	
	@FindBy (id="picLogo")
	WebElement JBLogo;
	

	//Intialize WebElements
	
	public Trans_Estimation() {
		PageFactory.initElements(driver, this);
	}
	
	//Click on dashboard
	public void click_On_DashBoard() {
		btnDashboard.click();
	}
	
	//Validate WebElements in Estimation Creation Page
	
	public void validate_WebElements_Estimation_Page() {
		if (dropsalesordertype.isDisplayed() ) {
			fnWriteSteps("Pass", "Sales Order Type dropdown is displayed ");
			log.info("Sales Order Type dropdow is displayed ");
			if(dropsalesordertype.isEnabled()) {
				fnWriteSteps("Pass","Sales Order Type dropdown is enabled");
				log.info("Sales order type dropdown is enabled");
			}else {
				fnWriteSteps("Fail","Sales Order Type dropdown is not enabled");
				log.info("sales order type dropdown is not enabled");	
			}
			}else {
				fnWriteSteps("Fail", "Sales Order Type dropdown is not displayed");
				log.info("Sales Order Type dropdown is not displayedx ");
			}
		
		if(BtnCustomer.isDisplayed()) {
			fnWriteSteps("Pass","Customer button is displayed");
			log.info("Customer button is displayed");
			if(BtnCustomer.isEnabled()) {
				fnWriteSteps("Pass","Customer button is enabled");
				log.info("Customer Button is enabled");
			}else {
				fnWriteSteps("Fail","Customer Button is not enabled");
				log.info("Customer button is not enabled");
			}
		}else {
			fnWriteSteps("Fail","Customer button is not displayed");
			log.info("Customer button is not displayed");
				
			}
		if(txtSearchBox.isDisplayed()) {
			fnWriteSteps("Pass","Text Search Box is displayed");
			log.info("Text Search Box is displayed");
			if(txtSearchBox.isEnabled()) {
				fnWriteSteps("Pass","Text Searc Box is enabled");
				log.info("Text search Box is enabled");
			}else {
				fnWriteSteps("Fail","Text search Box is not enabled");
			}
			}else {
				fnWriteSteps("Fail","Text Search Box is not displayed");
		}
		if(BtnRecall.isDisplayed()) {
			fnWriteSteps("Pass","Recall button is displayed");
			log.info("Recall button is displayed");
			if(BtnRecall.isEnabled()) {
				fnWriteSteps("Pass","Recall Button is enabled");
				log.info("Recall button is enabled");
			}else {
				fnWriteSteps("Fail","Recall button is not enabled");
				log.info("Recall button is not enabled");
			}
		}else {
			fnWriteSteps("Fail", "Recall button is not displayed");
			log.info("Recall button is not displayed");
		
		}
		if(btnSaveandEstimation.isDisplayed()) {
			fnWriteSteps("Pass","Save and Estimation button is displayed");
			log.info("Save and estimation button is displayed");
			if(btnSaveandEstimation.isEnabled()) {
				fnWriteSteps("Pass", "Save and EStimation button is enabled");
				log.info("Save and Estimation button is enabled");
			}else {
				fnWriteSteps("Fail", "Save and Estimation button is not enabled");
				log.info("Save and Estimation button is not enabled");
			}
		}else {
			fnWriteSteps("Fail", "Save and Estimation button is not displayed");
		}
	}
		
		
	
	//Estimation Creation
	
	public String estimation_Creation_Page(String strSalesOrderType,String strProduct, String field,String strCustomer,
			String Customertype,String strFirstName,String strPhoneNo ) throws AWTException {
		GenericMethods.fnwait(2);
		GenericMethods.select_Standard_SalesOrderType(dropsalesordertype, strSalesOrderType);
		GenericMethods.windows_Set_TextBoxValue(txtSearchBox, strProduct);
		GenericMethods.fnwait(3);
		Actions act=new Actions(driver);
		
	    switch (field) {
		
		case "existingcustomer":
			BtnCustomer.click();
			GenericMethods.fnwait(2);
			//Actions act=new Actions(driver);
			GenericMethods.windows_Set_TextBoxValue(txtSearchBoxCustomer, strCustomer);
		//	System.out.println("search keyword has been entered");
			txtSearchBoxCustomer.submit();
			//System.out.println("Selection triggered");
/*			GenericMethods.fnwait(2);
			txtSearchBoxCustomer.sendKeys(Keys.ARROW_DOWN);
			System.out.println("Arrowdown triggered");*/
/*			GenericMethods.fnwait(2);
			txtSearchBoxCustomer.sendKeys(Keys.RETURN);
			System.out.println("Entered triggered");*/
			GenericMethods.fnwait(1);
			//txtSearchBoxCustomer.sendKeys(Keys.ENTER);
						
			//act.moveToElement(driver.findElement(By.name(""+strCustomer+""))).click().build().perform();
		//	btnSaveCustomer.click();
			break;
		case "runtimecustomer":
			BtnCustomer.click();
			GenericMethods.fnwait(3);
			
			dropCustType.click();
			
			switch (Customertype) {
			case "B2C":
				act.moveToElement(driver.findElement(By.name("B2C"))).click().build().perform();
				break;
				
			case "B2B":
				act.moveToElement(driver.findElement(By.name("B2B"))).click().build().perform();
				break;
			}
			
			TxtFirstName.sendKeys(strFirstName);
			TxtPhoneNo.sendKeys(strPhoneNo);
			btnSaveCustomer.click();
			break;
			
		}
		btnSaveandEstimation.click();
		String estimationVochure1=driver.findElement(By.id("lblMessage")).getAttribute("Name");
		String estimationVochure=estimationVochure1.split(" ")[5];
		
		driver.findElement(By.id("btnOk")).click();
		return estimationVochure;
		
		}
	
	//Validation for Estimation Creation
	
	public boolean validate_Estimation_Creation(String estimationVochure) {
	    boolean result=false;
		BtnRecall.click();
		driver.findElement(By.id("txtSearch")).sendKeys(estimationVochure);
	int act=driver.findElements(By.name("Estimation No. row 0")).size();
	if(act==1) {
		result=true;
	}
	
	 BtnOk.click();
	GenericMethods.fnwait(1);
		btnSaveandEstimation.click();
		BtnOk.click();
	/*	if(estimationVochure.contains(actual)) {
			result=true;
			
		}*/
		return result;
		
	}
	
	//Estimation to order and invoice creation
	
	public String estimation_Conversion_Page(String strEstimationVochure,String HomeDelivery,String convertType,String strInstructions,String EditType) {
		String vochure=null;
		BtnRecall.click();
		driver.findElement(By.id("picLogo")).click();
		txtSearchBoxCustomer.sendKeys(strEstimationVochure);
		//driver.findElement(By.id("lblHeader")).click();
		BtnOk.click();
		GenericMethods.fn_ConditionalWaitForElement(btnEstimationConvert, 10);
		btnEstimationConvert.click();
		
		if(HomeDelivery.equals("Home Delievery".trim())) {
		
			GenericMethods.fnwait(1);
			//driver.findElement(By.id("picLogo")).click();
			BtnOk.click();
			btnSaveCustomer.click();
			txtBoxInstructions.sendKeys(strInstructions);
			btnSaveCustomer.click();
			 vochure=driver.findElement(By.id("lblMessage")).getAttribute("Name").split(" ")[5].replace(".","").trim();
			GenericMethods.fnwait(1);
			btnCancelCustomer.click();
		}
		switch (convertType) {
		case "order":
			if(!radioOrder.isSelected()) {
				radioOrder.click();
				BtnOk.click();
				
				BtnOk.click();
				txtBoxInstructions.sendKeys(strInstructions);
				btnSaveCustomer.click();
				 vochure=driver.findElement(By.id("lblMessage")).getAttribute("Name").split(" ")[5].replace(".","").trim();
				GenericMethods.fnwait(1);
				switch (EditType) {
				case "No":
					btnCancelCustomer.click();
					break;
				case "Yes":
					BtnOk.click();
					btnSaveCustomer.click();
					btnSaveCustomer.click();
					txtBoxInstructions.sendKeys(strInstructions);
					btnSaveCustomer.click();
					BtnOk.click();
					break;
				}
				
			
			
					
			}
			break;
		case "invoice":
			if(!radioInvoice.isSelected()) {
				radioInvoice.click();
				BtnOk.click();
				BtnOk.click();
				txtBoxInstructions.sendKeys(strInstructions);
				btnSaveCustomer.click();
				GenericMethods.fnwait(2);
				vochure=driver.findElement(By.id("textVoucherNo")).getAttribute("Name");
				System.out.println(vochure);
				GenericMethods.fnwait(2);
				btnCancelCustomer.click();
				
			}
			break;
		}
	
	
		
		return vochure;
		
	}
	
	//Validation for Estimation Conversion
	
	public boolean validate_Estimation_Conversion(String strEstimationVochure) {
		boolean result=false;
		BtnRecall.click();
		txtSearchBoxCustomer.sendKeys(strEstimationVochure);
		int actual=driver.findElements(By.name("Estimation No. row 0")).size();
		if(actual==0) {
			result=true;
		}
		btnCancelCustomer.click();
		
		return result;
			
	}
	
	//Estimation Modification
	
	
	public boolean validate_Estimation_Modification(String strEstimationVochure,String field,String strquantity,String strProduct ) {
		boolean result=false;
		GenericMethods.fnwait(2);
		BtnRecall.click();
		txtSearchBoxCustomer.sendKeys(strEstimationVochure);
		BtnOk.click();
		String amount=driver.findElement(By.id("lblTotalAmountValue")).getAttribute("Name");
		//productGrid.click();
	
	
		switch (field) {
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
			GenericMethods.fnwait(2);
			
			driver.findElement(By.id("touchPad1")).click();
			btnBack.click();
			btnBack.click();
			//txtQuantity.click();
			txtQuantity.clear();
		txtQuantity.sendKeys(strquantity);
			
		btnSaveCustomer.click();
		break;
		case "Add Product":
			txtSearchBox.sendKeys(strProduct);
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
				r2.mouseMove(x2+140, y2-190);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			GenericMethods.fnwait(1);
			Actions builder2 = new Actions(driver);
			builder2.click().build().perform();
			GenericMethods.fnwait(2);
			break;
			
		}
			
		String amountAfterModify=driver.findElement(By.id("lblTotalAmountValue")).getAttribute("Name");
		if(!amountAfterModify.equals(amount)) {
			result=true;
		}
		btnSaveandEstimation.click();
		BtnOk.click();
		return result;
		}

	//Method to Create Estimation For Home Delivery
	public String estimation_Craetion_HomeDelievery(String strSalesOrderType,String strProduct,String Customertype,String strFirstName,String strPhoneNo,String strDoorNo,
			String	strStreetName,String strArea,String strZipcode) {
		GenericMethods.fnwait(2);
		GenericMethods.select_Standard_SalesOrderType(dropsalesordertype, strSalesOrderType);
		GenericMethods.windows_Set_TextBoxValue(txtSearchBox, strProduct);
		GenericMethods.fnwait(3);
		Actions act=new Actions(driver);
		BtnCustomer.click();
		GenericMethods.fnwait(3);
		
		dropCustType.click();
		
		switch (Customertype) {
		case "B2C":
			act.moveToElement(driver.findElement(By.name("B2C"))).click().build().perform();
			break;
			
		case "B2B":
			act.moveToElement(driver.findElement(By.name("B2B"))).click().build().perform();
			break;
		}
		
		TxtFirstName.sendKeys(strFirstName);
		TxtPhoneNo.sendKeys(strPhoneNo);
		TxtDoorNo.sendKeys(strDoorNo);
		TxtStreetName.sendKeys(strStreetName);
		TxtArea.sendKeys(strArea);
		TxtZipCode.sendKeys(strZipcode);
		JBLogo.click();
		btnSaveCustomer.click();
		btnSaveandEstimation.click();
		String estimationVochure1=driver.findElement(By.id("lblMessage")).getAttribute("Name");
		String estimationVochure=estimationVochure1.split(" ")[5];
		driver.findElement(By.id("btnOk")).click();
		return estimationVochure;
	}
		//Function to modify Estimation from Estimation History Page
	public boolean estimation_Modification_Estimation_History(String field,String strquantity,String strProduct) {
		boolean result=false;
		String amount=driver.findElement(By.id("lblTotalAmountValue")).getAttribute("Name");
		//productGrid.click();
	
	
		switch (field) {
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
			GenericMethods.fnwait(2);
			
			driver.findElement(By.id("touchPad1")).click();
			btnBack.click();
			btnBack.click();
			//txtQuantity.click();
			txtQuantity.clear();
		txtQuantity.sendKeys(strquantity);
			
		btnSaveCustomer.click();
		break;
		case "Add Product":
			txtSearchBox.sendKeys(strProduct);
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
				r2.mouseMove(x2+140, y2-190);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			GenericMethods.fnwait(1);
			Actions builder2 = new Actions(driver);
			builder2.click().build().perform();
			GenericMethods.fnwait(2);
			break;
			
		}
			
		String amountAfterModify=driver.findElement(By.id("lblTotalAmountValue")).getAttribute("Name");
		if(!amountAfterModify.equals(amount)) {
			result=true;
		}
		btnSaveandEstimation.click();
		BtnOk.click();
	
		return result;
		}
		

   public void close_Estimation() {
	btnDashboard.click();
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
    public void BatchNo_Selection_while_Estimation_To_Invoice_Convertion(String strEstimationVochure,String ConvertionFor) {
	BtnRecall.click();
	driver.findElement(By.id("picLogo")).click();
	txtSearchBoxCustomer.sendKeys(strEstimationVochure);
    BtnOk.click();
	GenericMethods.fn_ConditionalWaitForElement(btnEstimationConvert, 10);
	switch(ConvertionFor){
	case "Partially":
		fnRecordDelete();
		GenericMethods.fnwait(3);
	break;
	}
	btnEstimationConvert.click();
	if(!radioInvoice.isSelected()) {
		radioInvoice.click();
		BtnOk.click();
	}
}


}
	
	


