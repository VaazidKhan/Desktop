package JBWindows_Configurations;

import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.Configurations.InvoiceDelivery;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class InvoiceDeliveryTest extends BaseClass {
	
	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	InvoiceDelivery refInvoiceDelivery;
	MessageBoxEffia refMessageBoxEffia;

	public InvoiceDeliveryTest() {
		super();
	}

	@BeforeMethod
	public void fn_Login_and_Open_Page() throws InterruptedException, FindFailed {

		refLogin = new Login(driver);
		refDashboard = new APP_Dashboard(driver);
		refMenu = new APP_Menu(driver);
		refInvoiceDelivery = new InvoiceDelivery();
		refMessageBoxEffia = new MessageBoxEffia(driver);

		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		refLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(10);
		refDashboard.clickMenuBtn();
        GenericMethods.fnwait(3);
       //fnWriteSteps("Pass", "Application Open Successfully" );
		GenericMethods.fnEndTestCase();

      }   
	@Test 
	public void InvoiceDelivery_OptionsEnabled() {
		GenericMethods.fnStartTestCase("InvoiceDelivery OptionsEnabled");
		  refMenu.OpenPage("application settings");
		refInvoiceDelivery.InvoiceDelivery_Option_Enabling();
		refInvoiceDelivery.clickCloseButton();
		fnWriteSteps("Pass", "InvoiceDelivery Options Enabled Successfully"); 
		GenericMethods.fnEndTestCase();
	}
	
   @Test 
	public void PaymentMode_OptionsEnabled_Validation_of_InvoiceGeneration_with_CardPaymentMode() {
		GenericMethods.fnStartTestCase("PaymentMode OptionsEnabled and Validation of InvoiceGeneration with CardPaymentMode");
		 refMenu.OpenPage("application settings");
		 refInvoiceDelivery.PaymentModes_Enabling();
		 refInvoiceDelivery.clickCloseButton();
		 refMenu.OpenPage("invoicing");
		 String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
		 String StrSheetName ="AppSettings_Configuration";
		    int RowNumber = 1;
		    String SelectedCustomer = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		    String strProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		 boolean result = refInvoiceDelivery.InvoiceGeneration_with_CardPaymentMode(SelectedCustomer,strProduct);
		 Assert.assertTrue(result);
		 fnWriteSteps("Pass", "PaymentModes Enabled and Invoice Generation with CardPaymentMode Valid Successfully");
		GenericMethods.fnEndTestCase();
	}
   
   @Test 
   public void Validation_of_InvoiceGeneration_withCustomer_through_CashPaymentmode() {
	   GenericMethods.fnStartTestCase("Validation of InvoiceGeneration withCustomer through CashPaymentmode");
	   refMenu.OpenPage("invoicing");
		String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="AppSettings_Configuration";
	    int RowNumber = 1;
	    String SelectedCustomer = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String strProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    boolean result = refInvoiceDelivery.InvoiceGeneration_with_Customer_and_CashPaymentMode(SelectedCustomer,strProduct);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "InvoiceGeneration withCustomer through CashPaymentmode Valid successfully");
		GenericMethods.fnEndTestCase();
   }
   @Test 
   public void Validation_of_InvoiceGeneration_withoutCustomer_through_CashPaymentmode() {
	   GenericMethods.fnStartTestCase("Validation of InvoiceGeneration withoutCustomer through CashPaymentmode");
	   refMenu.OpenPage("invoicing");
		String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="AppSettings_Configuration";
	    int RowNumber = 1;
	    String strProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    boolean result = refInvoiceDelivery.InvoiceGeneration_without_Customer_and_CashPaymentMode(strProduct);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "InvoiceGeneration withoutCustomer through CashPaymentmode Valid successfully");
		GenericMethods.fnEndTestCase();
   }
   @Test 
   public void Validation_of_PurchaseInvoiceGeneration() {
	   GenericMethods.fnStartTestCase("Validation of PurchaseInvoiceGeneration");
	   refMenu.OpenPage("purchase invoices");
	   String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="PurchaseInvoice";
	    int RowNumber = 1;
	    String PurchaseInvoicedate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String suppliers = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String RefInvoiceNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String Receivingdate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String strProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	   boolean result = refInvoiceDelivery.PurchaseInvoiceGeneration_with_AllPaymentModes(PurchaseInvoicedate,suppliers,RefInvoiceNo,Receivingdate,strProduct);
	   Assert.assertTrue(result);
	   fnWriteSteps("Pass", "PurchaseInvoiceGeneration Valid successfully");
		GenericMethods.fnEndTestCase();
   }
   @Test 
   public void Validation_of_PurchaseInvoiceGeneration_with_CardPaymentMode() {
	   GenericMethods.fnStartTestCase("Validation of PurchaseInvoiceGeneration with CardPaymentMode");
	   refMenu.OpenPage("purchase invoices");
	   String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="PurchaseInvoice";
	    int RowNumber = 1;
	    String PurchaseInvoicedate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String suppliers = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String RefInvoiceNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String Receivingdate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String strProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    String CardNumber = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
	    boolean result = refInvoiceDelivery.PurchaseInvoiceGeneration_with_CardPaymentModes(PurchaseInvoicedate,suppliers,RefInvoiceNo,Receivingdate,strProduct,CardNumber);
	    Assert.assertTrue(result);
		   fnWriteSteps("Pass", "PurchaseInvoiceGeneration with CardPaymentMode Valid Successfully");
			GenericMethods.fnEndTestCase();
   }
   
   @Test 
   public void Payment_Modes_Validation_withCustomer() {
	   GenericMethods.fnStartTestCase("Payment Modes Validation withCustomer");
	   refMenu.OpenPage("invoicing");
		String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="AppSettings_Configuration";
	    int RowNumber = 1;
	    String SelectedCustomer = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String strProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		boolean result = refInvoiceDelivery.PaymentModes_Validation(SelectedCustomer,strProduct);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Payment Modes Validation withCustomer Valid Successfully");
		GenericMethods.fnEndTestCase();
		
   }
   @Test 
   public void Payment_Modes_Validation_withoutCustomer() {
	   GenericMethods.fnStartTestCase("Payment Modes Validation withoutCustomer");
	   refMenu.OpenPage("invoicing");
		String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="AppSettings_Configuration";
	    int RowNumber = 1;
	    String strProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		boolean result = refInvoiceDelivery.PaymentModes_Validation_withoutCustomer(strProduct);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Payment Modes Validation withoutCustomer Valid Successfully");
		GenericMethods.fnEndTestCase();
		
   }
   @Test 
   public void Validation_of_InvoiceGeneration_with_AdvanceReceivedPaymentMode() {
	   GenericMethods.fnStartTestCase("Validation of InvoiceGeneration with AdvanceReceivedPaymentMode");
	   refMenu.OpenPage("invoicing");
		String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="AppSettings_Configuration";
	    int RowNumber = 1;
	    String SelectedCustomer = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String strProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String AdvanceReceivedid = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    boolean result= refInvoiceDelivery.InvoiceGeneration_with_AdvanceReceivedPaymentMode(SelectedCustomer, strProduct, AdvanceReceivedid);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "InvoiceGenerated with AdvanceReceivedPaymentMode Valid Successfully");
		GenericMethods.fnEndTestCase();
   }
   @Test 
   public void Validation_of_PurchaseInvoiceGeneration_with_AdvancedPaidMode() {
	   GenericMethods.fnStartTestCase("Validation of PurchaseInvoiceGeneration with AdvancedPaidMode");
	   refMenu.OpenPage("purchase invoices");
	   String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="PurchaseInvoice";
	    int RowNumber = 1;
	    String PurchaseInvoicedate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String suppliers = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String RefInvoiceNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String Receivingdate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String strProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    String Advancedpaid = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
	    boolean result = refInvoiceDelivery.PurchaseInvoiceGeneration_with_AdvancedPaidMode(PurchaseInvoicedate, suppliers, RefInvoiceNo, Receivingdate, strProduct, Advancedpaid);
	    Assert.assertTrue(result);
		   fnWriteSteps("Pass", "PurchaseInvoiceGenerated with AdvancedPaidMode Valid Successfully");
			GenericMethods.fnEndTestCase();
   }
   
   @Test 
   public void InvoiceTemplateSize_A4() {
	   
	 GenericMethods.fnStartTestCase("Generation of InvoiceTemplateSize_A4"); 
	 refMenu.OpenPage("application settings");
	 String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="AppSettings_Configuration";
	    int RowNumber = 3;
	    String TemplateSize = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	  refInvoiceDelivery.InvoiceTemplate_Generation(TemplateSize);
   }
   
   @AfterMethod
	public void fnAfterMethod() {
		GenericMethods.fnStartTestCase("fnAfterMethod");
	    refDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(2);
		refMessageBoxEffia.ExitApplication_Yes();
		GenericMethods.fnwait(5);
		refLogin.ClickCloseButton();
		fnWriteSteps("Pass", "Application Close Successfully");
		GenericMethods.fnEndTestCase();
	}
    
  }

 



