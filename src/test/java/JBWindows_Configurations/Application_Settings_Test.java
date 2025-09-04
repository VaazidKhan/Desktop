package JBWindows_Configurations;

import java.io.IOException;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.Configurations.Application_Settings;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class Application_Settings_Test extends BaseClass {
	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	Application_Settings refAppSettings;
	MessageBoxEffia refMessageBoxEffia;

	public Application_Settings_Test() {
		super();
	}


	@BeforeMethod
	public void fn_Login_and_Open_Page() throws InterruptedException, FindFailed {

		refLogin = new Login(driver);
		refDashboard = new APP_Dashboard(driver);
		refMenu = new APP_Menu(driver);
		refAppSettings = new Application_Settings();
		refMessageBoxEffia = new MessageBoxEffia(driver);

		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		refLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(10);
		refDashboard.clickMenuBtn();
        GenericMethods.fnwait(3);
}
	@Test 
	public void fnVerifyFieldVisibility_FieldEnabledorNot() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Configuration are present/Enable or not ");
		refMenu.OpenPage("application settings");
		refAppSettings.VerifyFieldVisibility_FieldEnabledorNot();
		refAppSettings.clickCloseButton();
		GenericMethods.fnEndTestCase();
	} 
	
	@Test 
	public void Showfeedback_after_Create_Billing() {
		GenericMethods.fnStartTestCase("Show feedback_after_Create_Billing");
		refMenu.OpenPage("application settings");
		refAppSettings.fnConfiguration_ShowFeedbackafterBilling();
		refAppSettings.PaymentMode_Enabling();
		String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="AppSettings_Configuration";
	    int RowNumber = 1;
	    String SelectedCustomer = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String strProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		boolean result = refAppSettings.fnCreateBill(SelectedCustomer,strProduct);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Show Feedback after Create Billing option Enabled");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void Showfeedback_after_Billing_Invoice() {
		GenericMethods.fnStartTestCase("Show feedback_after_Billing_Invoice");
		 refMenu.OpenPage("invoicing");
		String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="AppSettings_Configuration";
	    int RowNumber = 2;
	    String SelectedCustomer = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String strProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		boolean result = refAppSettings.fnInvoice(SelectedCustomer, strProduct);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Show Feedback after Billing option Enabled");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void AddnewCustomer_while_Billing_Estimation_generation_with_Enabling_the_Option() {
		GenericMethods.fnStartTestCase("AddNewCustomer while Billing Estimation generation with Enabling the Option");
		refMenu.OpenPage("application settings");
		refAppSettings.fnConfiguration_AddNewCustomerwhileBilling();
		refMenu.OpenPage("estimation");
		boolean result = refAppSettings.fnEstimation_AddNewCustomer_while_Billing();
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Add New Customer While Billing option Enabled");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void AddnewCustomer_while_Billing_Estimation_generation_without_Enabling_the_Option() {
		GenericMethods.fnStartTestCase("AddNewCustomer_while_Billing_Estimation generation without Enabling the Option");
		refMenu.OpenPage("application settings");
		refAppSettings.fnConfiguration_AddNewCustomerwhileBilling();
		refMenu.OpenPage("estimation");
		boolean result = refAppSettings.fnEstimation_AddNewCustomer_while_Billing();
		Assert.assertFalse(result);
		fnWriteSteps("Pass", "Add New Customer While Billing option not Enabled");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void AddnewCustomer_while_Billing_Invoice_generation_with_Enabling_the_Option() {
		GenericMethods.fnStartTestCase("AddnewCustomer while Billing Invoice generation with Enabling the Option");
		refMenu.OpenPage("application settings");
		 refAppSettings.fnConfiguration_AddNewCustomerwhileBilling();
		 refMenu.OpenPage("invoicing");
	   boolean result = refAppSettings.fnInvoice_fnOrder_AddNewCustomer_while_Billing();
		Assert.assertTrue(result);
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void AddnewCustomer_while_Billing_Invoice_generation_without_Enabling_the_Option(){
		GenericMethods.fnStartTestCase("AddnewCustomer while Billing Invoice generation without Enabling the Option");
		refMenu.OpenPage("application settings");
		refAppSettings.fnConfiguration_AddNewCustomerwhileBilling();	
		 refMenu.OpenPage("invoicing");
		 boolean result = refAppSettings.fnInvoice_fnOrder_AddNewCustomer_while_Billing();
		Assert.assertFalse(result);
		fnWriteSteps("Pass", "Add New Customer While Billing option not Enabled");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void AddnewCustomer_while_Billing_Order_generation_with_Enabling_the_Option() {
		GenericMethods.fnStartTestCase("AddnewCustomer while Billing Order generation with Enabling the Option");
		refMenu.OpenPage("application settings");
		 refAppSettings.fnConfiguration_AddNewCustomerwhileBilling();
		 refMenu.OpenPage("order");
	    boolean result = refAppSettings.fnInvoice_fnOrder_AddNewCustomer_while_Billing();
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Add New Customer While Billing option Enabled");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void AddnewCustomer_while_Billing_Order_generation_without_Enabling_the_Option(){
		GenericMethods.fnStartTestCase("AddnewCustomer while Billing Order generation without Enabling the Option");
		 refMenu.OpenPage("application settings");
		 refAppSettings.fnConfiguration_AddNewCustomerwhileBilling();
		 refMenu.OpenPage("order");
		boolean result = refAppSettings.fnInvoice_fnOrder_AddNewCustomer_while_Billing();
		Assert.assertFalse(result);
		fnWriteSteps("Pass", "Add New Customer While Billing option not Enabled");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void Show_ItemEditpopup_while_Billing_Invoice() {
		GenericMethods.fnStartTestCase("ItemEditPopup_while_Billing_Invoice");
		refMenu.OpenPage("application settings");
		refAppSettings.fnConfiguration_ItemEdit_Popup_while_Billing();
		 refMenu.OpenPage("invoicing");
		String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="AppSettings_Configuration";
	    int RowNumber = 1;
	    String SelectedCustomer = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String strProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		boolean result = refAppSettings.fnInvoice_fnOrder_ItemEdit_Popup_while_Billing(SelectedCustomer, strProduct);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "ItemEditpopup_while_Billing option Enabled");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void Show_ItemEditpopup_while_Billing_Order() {
		GenericMethods.fnStartTestCase("ItemEditPopup_while_Billing_Order");
		refMenu.OpenPage("order");
		String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="AppSettings_Configuration";
	    int RowNumber = 2;
	    String SelectedCustomer = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String strProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		boolean result = refAppSettings.fnInvoice_fnOrder_ItemEdit_Popup_while_Billing(SelectedCustomer, strProduct);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "ItemEditpopup_while_Billing option Enabled");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void Show_ItemEditpopup_while_Billing_ReturnInvoice() {
		GenericMethods.fnStartTestCase("ItemEditPopup_while_Billing_ReturnInvoice");
		 refMenu.OpenPage("invoicing");
		String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="AppSettings_Configuration";
	    int RowNumber = 3;
	    String SelectedCustomer = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String strProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		boolean result = refAppSettings.fnReturnInvoice_ItemEdit_Popup_while_Billing(SelectedCustomer, strProduct);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "ItemEditpopup_while_Billing option Enabled");
		GenericMethods.fnEndTestCase();
		
	}
    @Test 
	public void Show_ItemEditpopup_while_Billing_Order_generation_without_enabling_the_option() {
		GenericMethods.fnStartTestCase("ItemEditPopup while Billing Order generation without enabling the option");
		refMenu.OpenPage("application settings");
		refAppSettings.fnConfiguration_ItemEdit_Popup_while_Billing();
		refMenu.OpenPage("order");
		String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="AppSettings_Configuration";
	    int RowNumber = 2;
	    String SelectedCustomer = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String strProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		boolean result = refAppSettings.fnInvoice_fnOrder_ItemEdit_Popup_while_Billing_generation_without_Enabling_the_option(SelectedCustomer, strProduct);
		Assert.assertFalse(result);
		fnWriteSteps("Pass", "ItemEditpopup_while_Billing option not Enabled");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void Show_ItemEditpopup_while_Billing_Invoice_generation_without_enabling_the_option() {
		GenericMethods.fnStartTestCase("ItemEditPopup while Billing Invoice generation without enabling the option");
	      refMenu.OpenPage("invoicing");
		String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="AppSettings_Configuration";
	    int RowNumber = 1;
	    String SelectedCustomer = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String strProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		boolean result = refAppSettings.fnInvoice_fnOrder_ItemEdit_Popup_while_Billing_generation_without_Enabling_the_option(SelectedCustomer, strProduct);
		Assert.assertFalse(result);
		fnWriteSteps("Pass", "ItemEditpopup_while_Billing option not Enabled");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void Show_ItemEditpopup_while_Billing_ReturnInvoice_generation_without_enabling_the_option() {
		GenericMethods.fnStartTestCase("ItemEditPopup while Billing ReturnInvoice generation without enabling the option");
		refMenu.OpenPage("invoicing");
		String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="AppSettings_Configuration";
	    int RowNumber = 3;
	    String SelectedCustomer = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String strProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		boolean result = refAppSettings.fnReturnInvoice_ItemEdit_Popup_while_Billing_generation_without_enabling_the_option(SelectedCustomer, strProduct);
		Assert.assertFalse(result);
		fnWriteSteps("Pass", "ItemEditpopup_while_Billing option not Enabled");
		GenericMethods.fnEndTestCase();
	}
	
   @AfterMethod
	public void fnAfterMethod() {
		GenericMethods.fnStartTestCase("fnAfterMethod");
		refDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		refMessageBoxEffia.ExitApplication_Yes();
		GenericMethods.fnwait(5);
		refLogin.ClickCloseButton();
		fnWriteSteps("Pass", "Application Close Successfully");
		GenericMethods.fnEndTestCase();
	}

}



