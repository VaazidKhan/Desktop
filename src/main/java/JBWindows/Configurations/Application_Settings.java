package JBWindows.Configurations;

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

public class Application_Settings extends BaseClass {
	//WebElements
	@FindBy (id ="btnAppConfig")   WebElement BtnAppConfig;
	@FindBy (id ="btnSalesConfiguration")   WebElement BtnSalesConfiguration;
	@FindBy (id ="btnInvoiceTemplates")   WebElement BtnInvoiceTemplates ;
	@FindBy (id ="btnInvoiceDelivery")   WebElement BtnInvoiceDelivery;
	@FindBy (id ="btnPaymentModes")   WebElement BtnPaymentModes;
	@FindBy (id ="btnCustomerPromotion")   WebElement BtnCustomerPromotion;
	@FindBy (id ="LookUpPriceCatelog")    WebElement DefaultPriceCatalog;
	@FindBy (id ="chkAddNewCustomer")  WebElement AddnewCustomerWhileBilling;
	@FindBy (id ="chkAllowCashierEditTransaction")  WebElement AllowcashierToEditTransaction;
	@FindBy (id ="chkShowBarCode")  WebElement  ShowBarCodeInInvoice;
	@FindBy (id ="chkOnlingBilling")  WebElement OnlineBilling;
	@FindBy (id ="chkSendOTPtoRedeem")  WebElement SendOTPToReedem ;
	@FindBy (id ="chkAutoEditItemPopup")  WebElement ShowItemEditPopupWhileBilling;
	@FindBy (id ="cboCustomerDisplayDevice")  WebElement customerDisplaydevice;
	@FindBy (id ="calcReturnAllowedDays")  WebElement SalesReturnsAcceptedtill ;
	@FindBy (id ="cmbPortWeighingScales")  WebElement SelectWeighingScales;
	@FindBy (id ="btnWeighingScaleCheckPort")  WebElement Weighingscalecheckport;
	@FindBy (id ="btnCheckPortForCustomerDisplayDevice")  WebElement Checkportforcustomerdisplaydevice;
	@FindBy (id ="cboCashDrawer")  WebElement Cashdrawer;
	@FindBy (id ="chkShowFeedBack")  WebElement ChkshowfeedBack;
	@FindBy (id ="chkAllowCashierDeleteTransaction")  WebElement AllowcashierdeleteTransaction ;
	@FindBy (id ="chkShowQRCode")  WebElement ShowQRCODE ;
	@FindBy (id ="btnApplicationConfigSave")  WebElement ConfigSave;
	@FindBy (id ="cboPurgeData")  WebElement Purgedata;
	@FindBy (id ="picClose")  WebElement Close;
	@FindBy (id ="btnOk")    WebElement BtnOk;
	@FindBy (id ="picCreateBill") WebElement CreateBill;
	@FindBy (id ="btnCustomer") WebElement SelectCustomer;
	@FindBy (id ="txtSearch") WebElement TxtSearch;
	@FindBy (id ="btnSave")  WebElement BtnSave;
	@FindBy (id ="btnPayment")  WebElement BtnPayment;
	@FindBy (id ="btnCash") WebElement BtnCash;
	@FindBy (id ="btnFinish") WebElement BtnFinish;
	@FindBy (id ="lblCaption")  WebElement CaptionFeedback;
	@FindBy (id ="btnDashBoard") WebElement BtnDashboard;
	@FindBy (id ="txtFirstName") WebElement FirstName;
	@FindBy (id = "txtMenuSearch")	WebElement SearchBox;
	@FindBy (id = "lblCaption")	   WebElement ProductEditCaption;
	@FindBy (id ="btnReturn") WebElement Return;
	@FindBy (id ="grdBillingDetail") WebElement grdRecordList;
	@FindBy (id ="btnPriceListCode") WebElement PriceListCode;
	@FindBy (id ="btnCancel")  WebElement Cancel;
	@FindBy(id ="chkCardPayment")   WebElement CardPayment;
	@FindBy(id ="btnPaymentModeSave")   WebElement PaymentModeSave;
	
	// WebElement Initialization method
	public Application_Settings() {
		PageFactory.initElements(driver, this);
	}
	// Action
	public void clickCloseButton()
	{
		Close.click();
	}
	
	// This method is to verify all the fields are visible&&Enabled or not
	public void VerifyFieldVisibility_FieldEnabledorNot() {
		if(BtnAppConfig.isDisplayed()) {
			BtnAppConfig.click();
		}
		if(DefaultPriceCatalog.isDisplayed()&&DefaultPriceCatalog.isEnabled()) {
			DefaultPriceCatalog.click();
			fnWriteSteps("Pass", "DefaultPriceCatalog field is present and Enable");
		} else {
			fnWriteSteps("Fail", "DefaultPriceCatalog field is not present and Enable");
		}
		if(AddnewCustomerWhileBilling.isDisplayed()&&AddnewCustomerWhileBilling.isEnabled()) {
			AddnewCustomerWhileBilling.click();
			fnWriteSteps("Pass", "AddnewCustomerWhileBilling field is present and Enable");
		} else {
			fnWriteSteps("Fail", "AddnewCustomerWhileBilling field is not present and Enable");
		}
		if(AllowcashierToEditTransaction.isDisplayed()&&AllowcashierToEditTransaction.isEnabled()) {
			AllowcashierToEditTransaction.click();
			fnWriteSteps("Pass", "AllowcashierToEditTransaction field is present and Enable");
		} else {
			fnWriteSteps("Fail", "AllowcashierToEditTransaction field is not present and Enable");
		}
		if(ShowBarCodeInInvoice.isDisplayed()&&ShowBarCodeInInvoice.isEnabled()) {
			ShowBarCodeInInvoice.click();
			fnWriteSteps("Pass", "ShowBarCodeInInvoice field is present and Enable");
		} else {
			fnWriteSteps("Fail", "ShowBarCodeInInvoice field is not present and Enable");
		}
		if(OnlineBilling.isDisplayed()&&OnlineBilling.isEnabled()) {
			OnlineBilling.click();
			fnWriteSteps("Pass", "OnlineBilling field is present and Enable");
		} else {
			fnWriteSteps("Fail", "OnlineBilling field is not present and Enable");
		}
		if(SendOTPToReedem.isDisplayed()&&SendOTPToReedem.isEnabled()) {
			SendOTPToReedem.click();
			fnWriteSteps("Pass", "SendOTPToReedem field is present and Enable");
		} else {
			fnWriteSteps("Fail", "SendOTPToReedem field is not present and Enable");
		}
		if(ShowItemEditPopupWhileBilling.isDisplayed()&&ShowItemEditPopupWhileBilling.isEnabled()) {
			ShowItemEditPopupWhileBilling.click();
			fnWriteSteps("Pass", "ShowItemEditPopupWhileBilling field is present and Enable");
		} else {
			fnWriteSteps("Fail", "ShowItemEditPopupWhileBilling field is not present and Enable");
		}
		if(Purgedata.isDisplayed()&&Purgedata.isEnabled()) {
			Purgedata.click();
			fnWriteSteps("Pass", "Purgedata field is present and Enable");
		} else {
			fnWriteSteps("Fail", "Purgedata field is not present and Enable");
		}
		if(SalesReturnsAcceptedtill.isDisplayed()&&SalesReturnsAcceptedtill.isEnabled()) {
			SalesReturnsAcceptedtill.click();
			fnWriteSteps("Pass", "SalesReturnsAcceptedtill field is present and Enable");
		} else {
			fnWriteSteps("Fail", "SalesReturnsAcceptedtill field is not present and Enable");
		}
		if(SelectWeighingScales.isDisplayed()&&SelectWeighingScales.isEnabled()) {
			SelectWeighingScales.click();
			fnWriteSteps("Pass", "SelectWeighingScales field is present and Enable");
		} else {
			fnWriteSteps("Fail", "SelectWeighingScales field is not present and Enable");
		}
		if(Checkportforcustomerdisplaydevice.isDisplayed()&&Checkportforcustomerdisplaydevice.isEnabled()) {
			Checkportforcustomerdisplaydevice.click();
			fnWriteSteps("Pass", "Checkportforcustomerdisplaydevice field is present and Enable");
		} else {
			fnWriteSteps("Fail", "Checkportforcustomerdisplaydevice field is not present and Enable");
		}
		if(Cashdrawer.isDisplayed()&&Cashdrawer.isEnabled()) {
			Cashdrawer.click();
			fnWriteSteps("Pass", "Cashdrawer field is present and Enable");
		} else {
			fnWriteSteps("Fail", "Cashdrawer field is not present and Enable");
		}
		if(ChkshowfeedBack.isDisplayed()&&ChkshowfeedBack.isEnabled()) {
			ChkshowfeedBack.click();
			fnWriteSteps("Pass", "Show feedback after Billing field is present and Enable");
		} else {
			fnWriteSteps("Fail", "Show feedback after Billing field is not present and Enable");
		}
		if(AllowcashierdeleteTransaction.isDisplayed()&&AllowcashierdeleteTransaction.isEnabled()) {
			AllowcashierdeleteTransaction.click();
			fnWriteSteps("Pass", "AllowcashierdeleteTransaction field is present and Enable");
		} else {
			fnWriteSteps("Fail", "AllowcashierdeleteTransaction field is not present and Enable");
		}
		if(ShowQRCODE.isDisplayed()&&ShowQRCODE.isEnabled()) {
			ShowQRCODE.click();
			fnWriteSteps("Pass", "ShowQRCODE field is present and Enable");
		} else {
			fnWriteSteps("Fail", "ShowQRCODE field is not present and Enable");
		}
		
	}
	// This method for ShowfeedBackafterBilling field is present and Enable or not :
	  public void fnConfiguration_ShowFeedbackafterBilling() {
		if(BtnAppConfig.isDisplayed()) {
			BtnAppConfig.click();
		}
		if(ChkshowfeedBack.isDisplayed()&&ChkshowfeedBack.isEnabled()) {
			ChkshowfeedBack.click();
			fnWriteSteps("Pass", "ShowfeedBackafterBilling field is present and Enable");
		} 
		if(ConfigSave.isDisplayed()) {
			ConfigSave.click();
			GenericMethods.fnwait(2);
			driver.findElement(By.id("lblHeader")).click();
			BtnOk.click();
			GenericMethods.fnwait(3);
			
		}
	}
	// This method for PaymentModes Enabling :
	  
       public void PaymentMode_Enabling() {
    	
    	if(BtnPaymentModes.isDisplayed()) {
    		BtnPaymentModes.click();
    	}
    	GenericMethods.fnwait(1);
    	CardPayment.click();
    	GenericMethods.fnwait(1);
    	PaymentModeSave.click();
    	driver.findElement(By.id("lblHeader")).click();
    	BtnOk.click();
    	driver.findElement(By.id("picLogo")).click();
    	clickCloseButton();
       }
       
      // This method for CreateBill : 
		public boolean fnCreateBill(String SelectedCustomer,String strProduct) {
			boolean result = false;
			GenericMethods.fnwait(2);
			driver.findElement(By.id("lblUserName")).click();
			GenericMethods.fnwait(5);
			CreateBill.click();
			GenericMethods.fnwait(2);
			SelectCustomer.click();
		    GenericMethods.windows_Set_DropDown_Value(TxtSearch,SelectedCustomer );
		    GenericMethods.fnwait(1);
		    GenericMethods.windows_Set_TextBoxValue(TxtSearch,strProduct);
		    GenericMethods.fnwait(1);
		    BtnPayment.click();
		    GenericMethods.fnwait(1);
		    BtnCash.click();
		    GenericMethods.fnwait(1);
		    BtnSave.click();
		    GenericMethods.fnwait(1);
		    BtnFinish.click();
		    GenericMethods.fnwait(1);
		    BtnOk.click();
		    GenericMethods.fnwait(1);
		  driver.findElement(By.id("picLogo")).click();
		 if(CaptionFeedback.isDisplayed()) {
			 result = true;
			 clickCloseButton();
			 BtnDashboard.click();
			 System.out.println("Show Feedback after Billing option Enabled");
		}
		  return result;
			
		}
		// This method for Invoice :
		public boolean fnInvoice(String SelectedCustomer,String strProduct) {
			boolean result = false;
           SelectCustomer.click();
		  GenericMethods.windows_Set_DropDown_Value(TxtSearch,SelectedCustomer );
		  GenericMethods.fnwait(1);
		  GenericMethods.windows_Set_TextBoxValue(TxtSearch,strProduct);
		  GenericMethods.fnwait(1);
		  BtnPayment.click();
		  GenericMethods.fnwait(1);
		  BtnCash.click();
		  GenericMethods.fnwait(1);
		  BtnSave.click();
		  GenericMethods.fnwait(1);
		  BtnFinish.click();
		  GenericMethods.fnwait(1);
		  BtnOk.click();
		  GenericMethods.fnwait(1);
		  driver.findElement(By.id("picLogo")).click();
		 if(CaptionFeedback.isDisplayed()) {
			 result = true;
			 clickCloseButton();
			 GenericMethods.fnwait(1);
			 BtnDashboard.click();
			 System.out.println("Show Feedback after Billing option Enabled");
		}
		  return result;
			
		}
		// This method for fnConfiguration AddNewCustomerwhileBilling :
		public void fnConfiguration_AddNewCustomerwhileBilling() {
			if(BtnAppConfig.isDisplayed()) {
				BtnAppConfig.click();
			}
			if(AddnewCustomerWhileBilling.isDisplayed()&&AddnewCustomerWhileBilling.isEnabled()) {
				AddnewCustomerWhileBilling.click();
			} 
			  GenericMethods.fnwait(2);
			if(ConfigSave.isDisplayed()) {
				GenericMethods.fnwait(1);
				ConfigSave.click();
				GenericMethods.fnwait(2);
				driver.findElement(By.id("lblHeader")).click();
				BtnOk.click();
				GenericMethods.fnwait(2);
				driver.findElement(By.id("picLogo")).click();
				clickCloseButton();
				
			}
		}
		// This method for fnEstimation AddNewCustomer while_Billing :
		public boolean fnEstimation_AddNewCustomer_while_Billing() {
			boolean result = false;
			SelectCustomer.click();
		  if(FirstName.isDisplayed()&&FirstName.isEnabled()) {
			 FirstName.click();
			 result = true;
		  }
		     driver.findElement(By.id("picLogo")).click();
		     GenericMethods.fnwait(2);
			 clickCloseButton();
			 BtnDashboard.click();
		
		  return result;
			
  }
		// This method for fnInvoice_fnOrder AddNewCustomer while Billing :
		public boolean fnInvoice_fnOrder_AddNewCustomer_while_Billing() {
			boolean result = false;
			GenericMethods.fnwait(1);
           SelectCustomer.click();
		  GenericMethods.fnwait(2);
		if(FirstName.isDisplayed()&&FirstName.isEnabled()) {
			 result = true;
		}
			 driver.findElement(By.id("picLogo")).click();
			 clickCloseButton();
			 GenericMethods.fnwait(1);
			 BtnDashboard.click();
		 
		    return result;
			
		}	
	// This method for fnConfiguration ItemEdit PopUp while_Billing :
		public void fnConfiguration_ItemEdit_Popup_while_Billing() {
			if(BtnAppConfig.isDisplayed()) {
				BtnAppConfig.click();
			}
			if(ShowItemEditPopupWhileBilling.isDisplayed()&&ShowItemEditPopupWhileBilling.isEnabled()) {
				ShowItemEditPopupWhileBilling.click();
				fnWriteSteps("Pass", "ShowItemEditPopupWhileBilling field is present and Enable");
			} 
			if(ConfigSave.isDisplayed()) {
				ConfigSave.click();
				GenericMethods.fnwait(2);
				driver.findElement(By.id("lblHeader")).click();
				BtnOk.click();
				GenericMethods.fnwait(1);
				driver.findElement(By.id("picLogo")).click();
				GenericMethods.fnwait(1);
				clickCloseButton();
			}
		}
	// This method for fnInvoice_fnOrder ItemEdit PopUp while Billing :
		public boolean fnInvoice_fnOrder_ItemEdit_Popup_while_Billing(String SelectedCustomer,String strProduct) {
			boolean result = false;
			GenericMethods.fnwait(1);
           SelectCustomer.click();
          GenericMethods.windows_Set_DropDown_Value(TxtSearch,SelectedCustomer );
 		  GenericMethods.fnwait(1);
 		  GenericMethods.windows_Set_TextBoxValue(TxtSearch,strProduct);
 		  GenericMethods.fnwait(3);
 		  driver.findElement(By.id("btnAll")).click();
 		 if(ProductEditCaption.isDisplayed()) {
 			 GenericMethods.fnwait(2);
			 result = true;
		}
			 driver.findElement(By.id("picLogo")).click();
			 clickCloseButton();
			 GenericMethods.fnwait(3);
			 BtnDashboard.click();
			 BtnOk.click();
		   return result;
			
		}	
		// This method for Access the Delete Button :
		public static void fnVerifyMasterRecord(WebElement element) {

			GenericMethods.fnwait(1);
			element.click();
			PointerInfo a1 = MouseInfo.getPointerInfo();
			Point b1 = a1.getLocation();
			GenericMethods.fnwait(1);
			int x1 = (int) b1.getX();
			GenericMethods.fnwait(1);
			int y1 = (int) b1.getY();

			Robot r1;
			try {
				r1 = new Robot();
				r1.mouseMove(x1 + 90, y1 - 200);
			} catch (AWTException e) {
				e.printStackTrace();
			}
			GenericMethods.fnwait(1);
			Actions builder1 = new Actions(driver);
			builder1.click().build().perform();
		}
   // This method for fnReturnInvoice ItemEdit PopUp while Billing :
		public boolean fnReturnInvoice_ItemEdit_Popup_while_Billing(String SelectedCustomer,String strProduct) {
			boolean result = false;
			GenericMethods.fnwait(1);
           SelectCustomer.click();
          GenericMethods.windows_Set_DropDown_Value(TxtSearch,SelectedCustomer );
 		  GenericMethods.fnwait(1);
 		  GenericMethods.windows_Set_TextBoxValue(TxtSearch,strProduct);
 		  GenericMethods.fnwait(1);
 		 driver.findElement(By.id("btnAll")).click();
 		  BtnSave.click();
 		  GenericMethods.fnwait(1);
 		  BtnPayment.click();
		  GenericMethods.fnwait(1);
		  BtnCash.click();
		  BtnSave.click();
		  GenericMethods.fnwait(1);
		  BtnFinish.click();
		  GenericMethods.fnwait(1);
		  BtnOk.click();
		  GenericMethods.fnwait(1);
		  driver.findElement(By.id("picLogo")).click();
		 if(CaptionFeedback.isDisplayed()) {
			 result = true;
		 }
		  clickCloseButton();
 		  GenericMethods.fnwait(1);
 		   Return.click();
 		   BtnOk.click();
 		  fnVerifyMasterRecord(grdRecordList);
 		
 		   GenericMethods.fnwait(2);
 		  if(ProductEditCaption.isDisplayed()) {
 			 result = true;
 		}
 			 
 		    GenericMethods.fnwait(1);
 			 BtnSave.click();
 			 GenericMethods.fnwait(2);
 			Cancel.click();
 			GenericMethods.fnwait(2);
 			 BtnDashboard.click();
	       return result;
			
		}	
	// This method for fnInvoice_fnOrder ItemEdit PopUp while Billing generation without Enabling the option :
		public boolean fnInvoice_fnOrder_ItemEdit_Popup_while_Billing_generation_without_Enabling_the_option(String SelectedCustomer,String strProduct) {
			boolean result = false;
		int elements=	driver.findElements(By.id("lblCaption")).size();
			GenericMethods.fnwait(1);
           SelectCustomer.click();
          GenericMethods.windows_Set_DropDown_Value(TxtSearch,SelectedCustomer );
 		  GenericMethods.fnwait(1);
 		  GenericMethods.windows_Set_TextBoxValue(TxtSearch,strProduct);
 		  GenericMethods.fnwait(2);
 		if(elements==1) {
 			result = true;
		}
			 GenericMethods.fnwait(3);
			 BtnDashboard.click();
			 BtnOk.click();
		   return result;
			
		}
	 // This method for fnReturnInvoice ItemEdit PopUp while Billing generation without enabling the option :
		public boolean fnReturnInvoice_ItemEdit_Popup_while_Billing_generation_without_enabling_the_option(String SelectedCustomer,String strProduct) {
			boolean result = false;
			int elements=	driver.findElements(By.id("lblCaption")).size();
			
           GenericMethods.fnwait(1);
 		   Return.click();
 		   BtnOk.click();
 		  GenericMethods.fnwait(2);
 		  if(elements==1) {
 			 result = true;
 		}
 			GenericMethods.fnwait(1);
 			Cancel.click();
 			GenericMethods.fnwait(2);
 			 BtnDashboard.click();
	       return result;
			
		}	
		
}

		
		
		
		
	
	
	
	
	
	

		
	

	
	
	


