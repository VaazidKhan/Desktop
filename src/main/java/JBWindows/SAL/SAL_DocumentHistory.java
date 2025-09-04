package JBWindows.SAL;

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
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import commonClass.BaseClass;
import commonClass.GenericMethods;

public class SAL_DocumentHistory extends BaseClass {

	@FindBy(id = "SAL_DocumentHistory")
	WebElement pageName;
	@FindBy(id = "picClose")
	WebElement BtnClose;
	@FindBy (id="picLogo")
	WebElement jbPicLogo;
	@FindBy(id = "grdBillingDetail")
	WebElement productGrid;
	@FindBy(id = "switchOrders")
	WebElement switchOrders;
	@FindBy(id = "TxtSearch")
	WebElement txtSearch;
	@FindBy(id = "txtSearch")
	WebElement TxtSearch;
	@FindBy(id = "btnFilter")
	WebElement btnFilter;
	@FindBy(id = "grdReturns")
	WebElement grdReturns;
	@FindBy(id = "gridOrder")
	WebElement gridOrder;
	@FindBy(id = "grdQuotation")
	WebElement grdQuotation;
	@FindBy(id = "grdInvoice")
	WebElement grdInvoice;
	@FindBy(id = "ReportPreview")
	WebElement ReportPreview;
	@FindBy (id="btnCash")
	WebElement BtnCash;
	@FindBy(id = "btnPayment")
	WebElement BtnPayment;
	@FindBy(id = "btnEdit")
	WebElement BtnEdit;
	@FindBy(id = "btnCancelOrders")
	WebElement BtnCancelOrders;
	@FindBy(id = "btnConvertToOrder")
	WebElement BtnConvertToOrder;
	@FindBy(id = "btnConvertToInvoice")
	WebElement BtnConvertToInvoice;
	@FindBy(id = "btnShare")
	WebElement BtnShare;
	@FindBy(id = "btnPrint")
	WebElement BtnPrint;
	@FindBy (id="btnOk")
	WebElement btnok;
	@FindBy (id="lblHeader")
	WebElement PopUpClick;
	@FindBy(id = "buttonBack")
	WebElement btnBack;
	@FindBy (id="lookUpEdit")
	WebElement btnEdit;
	@FindBy(id = "calcQuantityValue")
	WebElement txtQuantity;
	@FindBy (id="lblCaption")
	WebElement HistoryHeader;
	@FindBy(id = "btnSave")
	WebElement btnSaveCustomer;
	@FindBy (id="Line Down")
	WebElement btnColumnDown;
	
	@FindBy (id="btnFinish")
	WebElement btnFinish;
	@FindBy(id = "memoInstruction")
	WebElement txtBoxInstructions;
	@FindBy (id="btnSave")
	WebElement btnSave;
	@FindBy (id="lblMessage")
	WebElement txtInsidePopUp;
	@FindBy (id="btnCancel")
	WebElement btnCancel;
	@FindBy (id = "CalcDiscountRecovered")
	WebElement DiscountRecovered;
	// ---10-Feb-2018-----Added by Moumita---------
	@FindBy(id = "2")
	WebElement selectFileCancel;

	// ---14-Feb-2018-----Added by Moumita---------
	@FindBy(id = "switchOrders")
	WebElement DuePaidToggle;

	// ---8-Feb-2018-----Added by Moumita---------
	public SAL_DocumentHistory() {
		PageFactory.initElements(driver, this);
	}

	public void activePage() {
		pageName.click();
	}

	public void clickCloseButton() {
		GenericMethods.fnwait(2);
		HistoryHeader.click();
		BtnClose.click();
	}

	public void clickPaymentButton() {
		BtnPayment.click();
	}
   public void click_Header_Ok_Button() {
	   PopUpClick.click();
	   btnok.click();
   }
	public void clickSaveButton() {
		BtnEdit.click();
	}

	public void clickCancelOrderButton() {
		BtnCancelOrders.click();
	}

	public void clickConvertToOrderButton() {
		BtnConvertToOrder.click();
	}

	public void clickConvertToInvoiceButton() {
		BtnConvertToInvoice.click();
	}

	public void clickShareButton() {
		BtnShare.click();
	}

	public void clickPrintButton() {
		BtnPrint.click();
	}
	public void click_On_Close_Button() {
		
        jbPicLogo.click();
		GenericMethods.fnwait(1);
		BtnClose.click();
		
	}
  public void click_On_Logo() {
	  jbPicLogo.click();
  }
  
  public void click_On_Toggle_Switch() {
	  DuePaidToggle.click();
  }
  public void Enter_DiscountRecovered_Amount(String RefundORExchangeDisc) {
	  jbPicLogo.click();
	  GenericMethods.windows_Set_TextBoxValue(DiscountRecovered, RefundORExchangeDisc);
  }
  public void Click_On_Cash_paymentMode() {
	  jbPicLogo.click();
	  BtnCash.click();
  }
  
 public void Product_Quantity_Modification(String strFieldValue) {
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
		txtQuantity.clear();
	    txtQuantity.sendKeys(strFieldValue);
	    jbPicLogo.click();
	    GenericMethods.fnwait(2);
	    btnSaveCustomer.click();
	    GenericMethods.fnwait(2);
  }
		
  
	// ---10-Feb-2018-----Added by Moumita---------
	public void clickFileCancelButton() {
		selectFileCancel.click();
	}

	// ---8-Feb-2018---Added by Moumita-----
	// This method is to click the Edit button
	public void verifyOrderOrEstimationIsSavedOrNot() {
		if (BtnEdit.isDisplayed()) {
			fnWriteSteps("Pass", "Record is saved Successfully");
		} else {
			fnWriteSteps("Fail", "Record no is not found");
		}
	}

	// This method is to search the record by estimation no
	// Parameter is txtEstimationNo
	public void serachRecord(String transactionalNo) {
		jbPicLogo.click();
		GenericMethods.fnwait(2);
		txtSearch.click();
		txtSearch.sendKeys(transactionalNo);
		GenericMethods.fnwait(3);
	}
	public void searchReturnRecord(String transactionalNo) {
		jbPicLogo.click();
		GenericMethods.fnwait(2);
		TxtSearch.click();
		TxtSearch.sendKeys(transactionalNo);
		GenericMethods.fnwait(3);
	}

	// ---9-Feb-2018---Added by Moumita-----
	public void verifyEditFeature(String holdInvoice) {
		GenericMethods.fnwait(3);
	  driver.findElement(By.id("picLogo")).click();
	  //GenericMethods.fnwait(3);
	  //DuePaidToggle.click();
	   GenericMethods.fnwait(2);
	   txtSearch.click();
	   GenericMethods.fnwait(2);
	    txtSearch.clear();
		txtSearch.sendKeys(holdInvoice.trim());
		GenericMethods.fnwait(4);
		BtnEdit.click();
		GenericMethods.fnwait(5);
		driver.findElement(By.id("lblHeader")).click();
		btnok.click();
	}

	// ---12-Feb-2018---Added by Moumita-----
	public void verifyOrderCancellation() {
		if (BtnEdit.isDisplayed()) {
			fnWriteSteps("Pass", "Order cancellation is successfull");
		} else {
			fnWriteSteps("Fail", "Order has not been cancelled successfully");
		}
	}

	// ---14-Feb-2018---Added by Moumita-----
	public void verifyInvoiceIsSavedOrNot() {
		if (BtnPrint.isDisplayed()) {
			fnWriteSteps("Pass", "Invoice is saved Successfully");
		} else {
			fnWriteSteps("Fail", "Invoice no is not found");
		}
	}

	public void clickDuePaidToggle() {
		DuePaidToggle.click();
	}
	
	//*******Method to Delete Order/Estimation/Invoice**********
	public boolean document_History_Deletion(String strVochure, String strRemarks,String internet )  {
		GenericMethods.fnwait(3);
		driver.findElement(By.id("lblCaption")).click();
		GenericMethods.windows_Set_TextBoxValue(txtSearch, strVochure);
		GenericMethods.fnwait(3);
		/*Screen screen=new Screen();
		Pattern pattern=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Delete1.PNG");
		screen.click(pattern);*/
		//screen.click(pattern);
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
		PopUpClick.click();
		btnok.click();
		GenericMethods.fnwait(5);
		jbPicLogo.click();
		driver.findElement(By.name("Delete remarks")).sendKeys(strRemarks);
		WebElement saveButton=driver.findElement(By.id("btnSave"));//click();
		if(saveButton.isDisplayed()) {
			saveButton.click();
			GenericMethods.fnwait(8);
			switch(internet) {
			case "Without Internet":
				PopUpClick.click();
				btnok.click();
				GenericMethods.fnwait(1);
				jbPicLogo.click();
				BtnClose.click();
				GenericMethods.fnwait(1);
				jbPicLogo.click();
				BtnClose.click();
				break;
			}
			
			return true;
		}
		
		return false;
	}
		public boolean validate_Vochure_Close() {
			boolean actual=false;
		GenericMethods.fnwait(4);
		//driver.findElement(By.id("lblCaption")).click();
		if(jbPicLogo.isDisplayed()) {
			System.out.println("Logo");
		jbPicLogo.click();
		BtnClose.click();
		
		
		
		}else {
			System.out.println("wait");
			GenericMethods.fnwait(3);
			PopUpClick.click();
			btnok.click();
			GenericMethods.fnwait(3);
			btnCancel.click();
			GenericMethods.fnwait(3);
			jbPicLogo.click();
			BtnClose.click();
			actual=true;
		}
		return actual;
		
		
	}
	
	public boolean sales_Estimation_Deletion_Converted_Order_Invoice(String strVochure ) throws FindFailed {
		boolean result=false;
		GenericMethods.fnwait(2);
		jbPicLogo.click();
		driver.findElement(By.id("lblCaption")).click();
		driver.findElement(By.id("btnFilter")).click();
		GenericMethods.fnwait(2);
		jbPicLogo.click();
		WebElement status=driver.findElement(By.id("lookUpEdit"));
		status.sendKeys("Approved");
		status.submit();
		btnok.click();
		GenericMethods.windows_Set_TextBoxValue(txtSearch, strVochure);
		GenericMethods.fnwait(2);
		Screen screen=new Screen();
		Pattern pattern=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Delete.PNG");
		screen.click(pattern);
		String expected="Cannot delete";
		driver.findElement(By.id("lblHeader")).click();
		String actual=driver.findElement(By.id("lblMessage")).getAttribute("Name");
		System.out.println(actual);
		if(actual.contains(expected)) {
			result=true;
			
		}
		btnok.click();
		jbPicLogo.click();
		BtnClose.click();
		
		
		
		return result;
	
	}
	
	public boolean validate_Edit_Button() {
		int editButton=driver.findElements(By.id("btnEdit")).size();
		System.out.println("NO Is" +editButton);
	         if(editButton==1) {
					return true;
				}
				return false;
	}
	//Sales Order Converted To Sales Invoice Modification
public boolean validate_Sales_Order_Converted_Sales_Invoice_Modifification(String strStatus,String strVochure) {
	GenericMethods.fnwait(3);
	HistoryHeader.click();
	driver.findElement(By.id("btnFilter")).click();
	GenericMethods.fnwait(3);
	jbPicLogo.click();
	btnEdit.sendKeys(strStatus);
	btnEdit.submit();
	btnok.click();
	GenericMethods.windows_Set_TextBoxValue(txtSearch, strVochure);
	GenericMethods.fnwait(5);
	int editButton=driver.findElements(By.id("lookUpEdit")).size();
/*	if(!btnEdit.isDisplayed()) {
		return true;
	}*/
	if(editButton==0) {
		return true;
	}
	return false;
	
	
	}
public boolean validate_Estimation_Converted_To_Order_Invoice_Modification(String strVochure) {
	GenericMethods.fnwait(3);
	HistoryHeader.click();
	GenericMethods.fnwait(3);
	GenericMethods.windows_Set_TextBoxValue(txtSearch, strVochure);
	GenericMethods.fnwait(5);
	int editButton=driver.findElements(By.id("lookUpEdit")).size();
/*	if(!btnEdit.isDisplayed()) {
		return true;
	}*/
	if(editButton==0) {
		return true;
	}
	return false;
	
}

//Sales Order to Sales Invoice Conversion
public String validate_Sales_Order_To_Sales_Invoice_From_History_Page(String vochureNo,String strInstructions) {
	serachRecord(vochureNo);
	GenericMethods.fnwait(4);
	BtnConvertToInvoice.click();
	GenericMethods.fnwait(4);
	PopUpClick.click();
	btnok.click();
	GenericMethods.fnwait(4);
	jbPicLogo.click();
	//GenericMethods.fnwait(4);
	  driver.findElement(By.name("Line Down")).click();
	GenericMethods.fnwait(4);
	btnFinish.click();
	GenericMethods.fnwait(4);
	PopUpClick.click();
	btnok.click();
	GenericMethods.fnwait(4);
	jbPicLogo.click();
	txtBoxInstructions.sendKeys(strInstructions);
	btnSave.click();
	GenericMethods.fnwait(3);
	PopUpClick.click();
	GenericMethods.fnwait(3);
	String invoiceVochure=txtInsidePopUp.getAttribute("Name").split(" ")[5];
	GenericMethods.fnwait(3);
	btnok.click();
	return invoiceVochure;
}

//Methods to Delete converted vochures
public boolean delete_Vochure_Converted_Page(String strStatus,String  strVochure) {
	GenericMethods.fnwait(3);
	HistoryHeader.click();
	driver.findElement(By.id("btnFilter")).click();
	GenericMethods.fnwait(3);
	jbPicLogo.click();
	btnEdit.sendKeys(strStatus);
	btnEdit.submit();
	btnok.click();
	GenericMethods.windows_Set_TextBoxValue(txtSearch, strVochure);
	GenericMethods.fnwait(5);
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
		PopUpClick.click();
		String errmsg=txtInsidePopUp.getAttribute("Name");
		if(errmsg.contains("Cannot delete")) {
			
			GenericMethods.fnwait(3);
			btnok.click();
			GenericMethods.fnwait(2);
			jbPicLogo.click();
			BtnClose.click();
			return true;
		}
		/*GenericMethods.fnwait(3);
		btnok.click();
		GenericMethods.fnwait(2);
		jbPicLogo.click();
		BtnClose.click()*/;
		return false;
		
		}
/*public void validate_Sales_Invoice_Deletion(String strVochure,String strRemarks) {
	GenericMethods.fnwait(3);
	driver.findElement(By.id("lblCaption")).click();
	GenericMethods.windows_Set_TextBoxValue(txtSearch, strVochure);
	GenericMethods.fnwait(3);
	Screen screen=new Screen();
	Pattern pattern=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Delete1.PNG");
	screen.click(pattern);
	//screen.click(pattern);
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
	PopUpClick.click();
	btnok.click();
	GenericMethods.fnwait(5);
	jbPicLogo.click();
	driver.findElement(By.name("Delete remarks")).sendKeys(strRemarks);
	WebElement saveButton=driver.findElement(By.id("btnSave"));//click();
	if(saveButton.isDisplayed()) {
		saveButton.click();
		return true;
	}
}*/
public void click_On_Close_Sikuli() throws FindFailed {
	Screen screen=new Screen();
	Pattern pattern=new Pattern(System.getProperty("user.dir")+"Sikuli-Images\\Close1.PNG");
	screen.click(pattern);
			}


}
