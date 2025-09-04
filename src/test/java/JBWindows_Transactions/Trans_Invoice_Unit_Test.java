package JBWindows_Transactions;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.SAL.SAL_DocumentHistory;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows.Transactions.Trans_Order_Page;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;


public class Trans_Invoice_Unit_Test extends BaseClass {
    Logger log = Logger.getLogger(Trans_Invoice_Unit_Test.class);

	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessgBox;
	SAL_DocumentHistory RefEstimationHistory;
	Trans_Order_Page refOrderPage;

	public Trans_Invoice_Unit_Test() {
		super();
	}


	@BeforeClass
	public void initializingWindows() {
		DOMConfigurator.configure("log4j.xml");
		RefLogin = new Login(driver);
		RefDashboard = new APP_Dashboard(driver);
		RefMenu = new APP_Menu(driver);
		RefMessgBox = new MessageBoxEffia(driver);
		RefEstimationHistory = new SAL_DocumentHistory();
		refOrderPage = new Trans_Order_Page();
	}

	@AfterClass
	public void terminatingBrowser() {
		GenericMethods.fnwait(5);
		RefLogin.ClickCloseButton();
	}

	@BeforeMethod
	public void setUp() {
		GenericMethods.fnwait(15);
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(8);
		RefDashboard.clickMenuBtn();
		RefMenu.OpenPage("invoicing");

	}

	@AfterMethod
	public void tearDown() {

		refOrderPage.click_On_DashBoard();
		GenericMethods.fnwait(2);
		RefDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		RefMessgBox.ExitApplication_Yes();
		GenericMethods.fnwait(1);

	}

	@Test 
	public void validate_Sales_Invoice_Creation_Hold() {
		GenericMethods.fnStartTestCase("validate Sales Invoice Creation Hold");
		log.info("Sales Invoice Creation Payment Hold");
		int rowindex = 1;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1,Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		refOrderPage.get_Vochure_From_Grid(strPhoneNo);
		refOrderPage.click_On_Close_Image();
		log.info("Sales Invoice Is Created and Validated Successfully");
		fnWriteSteps("Pass", "Sales Invoice Is Created Successfully With Payment Hold");
		GenericMethods.fnEndTestCase();

	}
	@Test 
	public void validate_Sales_Invoice_Modification_Hold_Increasing_Quantity_Test() {
		GenericMethods.fnStartTestCase("validate Sales Invoice Modification Hold Increasing Quantity Test");
		log.info("Sales Invoice Modification For Hold Invoice");
		int rowindex = 28;
		String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", 1,22);
		String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 1);
		String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String Invoice =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 4);
		String PageType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 5);
		String amount=refOrderPage.sales_Order_Modification_Page(invoiceVochure,PageType,Modification, Quantity, Invoice);
		String Type="Hold";
	     refOrderPage.validate_Sales_Invoice_Modification(amount, Type);
		GenericMethods.fnwait(2);
		String txtValidate="Are you sure that you want to put the invoice on hold?";
		boolean result=refOrderPage.validate_Sales_Invoice_Hold(txtValidate.trim());
		Assert.assertTrue(result);
		log.info("Hold invoice is Successfully Modified");
		fnWriteSteps("Pass", "Hold Invoice Is Successfully Modified By increasing Quantity");
		GenericMethods.fnEndTestCase();
 }
	@Test 
	public void validate_Sales_Invoice_Modification_Hold_Decresing_Quantity_Test() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Modification_Hold_Decresing_Quantity_Test");
		log.info("Sales Invoice Modification For Hold Invoice");
		int rowindex = 29;
		String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", 1, 22);
		String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 1);
		String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String Invoice =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 4);
		String PageType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 5);
		String amount=refOrderPage.sales_Order_Modification_Page(invoiceVochure,PageType, Modification, Quantity, Invoice);
	    String Type="Hold";
	   refOrderPage.validate_Sales_Invoice_Modification(amount, Type);
		GenericMethods.fnwait(2);
		String txtValidate="Are you sure that you want to put the invoice on hold?";
		boolean result=refOrderPage.validate_Sales_Invoice_Hold(txtValidate.trim());
		Assert.assertTrue(result);
		log.info("Hold invoice is Successfully Modified");
		fnWriteSteps("Pass", "Hold Invoice Is Successfully Modified By decreasing Quantity");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Sales_Invoice_Modification_Adding_Product_Hold_Test() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Modification_Adding_Product_Hold_Test");
		log.info("Sales Invoice Modification For Hold Invoice");
		int rowindex = 30;
		String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", 1, 22);
		String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 1);
		String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String Invoice =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 4);
		String PageType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 5);
		String amount=refOrderPage.sales_Order_Modification_Page(invoiceVochure,PageType, Modification, Quantity, Invoice);
		String Type="Hold";
	    refOrderPage.validate_Sales_Invoice_Modification(amount, Type);
		GenericMethods.fnwait(2);
		String txtValidate="Are you sure that you want to put the invoice on hold?";
		boolean result=refOrderPage.validate_Sales_Invoice_Hold(txtValidate.trim());
		Assert.assertTrue(result);
		log.info("Hold invoice is Successfully Modified");
		fnWriteSteps("Pass", "Hold Invoice Is Successfully Modified By Adding Product");
		GenericMethods.fnEndTestCase();
 }
	@Test 
	public void validate_Sales_Invoice_Hold_Removing_Product_Test() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Hold_Removing_Product_Test");
		log.info("Sales Invoice Modification For Hold Invoice");
		int rowindex = 31;
		String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", 1, 22);
		String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 1);
		String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String Invoice =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 4);
		String PageType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 5);
		String amount=refOrderPage.sales_Order_Modification_Page(invoiceVochure,PageType, Modification, Quantity, Invoice);
		String Type="Hold";
	    refOrderPage.validate_Sales_Invoice_Modification(amount, Type);
		GenericMethods.fnwait(2);
		String txtValidate="Are you sure that you want to put the invoice on hold?";
		boolean result=refOrderPage.validate_Sales_Invoice_Hold(txtValidate.trim());
		Assert.assertTrue(result);
		log.info("Hold invoice is Successfully Modified");
		fnWriteSteps("Pass", "Hold Invoice Is Successfully Modified By Removing Product");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Sales_Invoice_Creation_Hold_Payment() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_Hold_Payment");
		log.info("Validate Sales Payment For Hold Payment");
        int rowindex = 19;
        
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				1, 22);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.get_Invoice_Vochure(strPhoneNo);
		refOrderPage.click_On_Payment();
	    refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		boolean result=refOrderPage.click_On_Header();
		Assert.assertTrue(result);
		log.info("Successfully payment done for hold ");
		fnWriteSteps("Pass","Successfully payment done for Hold Invoice");
		GenericMethods.fnEndTestCase();
		
	}
	/*@Test (enabled = false,priority = 26) //Feature changed -- Hold Invoice record shown on Recall Window only
	public void validate_Sales_Invoice_Hold_Modification_From_Invoice_History_Test() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Hold_Modification_From_Invoice_History_Test");
		log.info("Sales Hold Invoice Modification ");
		int rowindex = 32;
		String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", 1, 21);
		String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 1);
		String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Invoice =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String PageType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 4);
		refOrderPage.click_On_DashBoard();
		RefMenu.OpenPage("invoice history");
		RefEstimationHistory.verifyEditFeature(invoiceVochure);
		String amount=refOrderPage.sales_Order_Modification_Page(invoiceVochure, Modification, Quantity, Invoice, PageType);
		String Type="Hold";
	    refOrderPage.validate_Sales_Invoice_Modification(amount, Type);
	    GenericMethods.fnwait(2);
		String txtValidate="Are you sure that you want to put the invoice on hold?";
		boolean result=refOrderPage.validate_Sales_Invoice_Hold(txtValidate.trim());
		refOrderPage.click_On_DashBoard();
		RefEstimationHistory.click_On_Close_Button();
		RefMenu.OpenPage("invoicing");
		Assert.assertTrue(result);
		log.info("Hold invoice is Successfully Modified");
		fnWriteSteps("Pass", "Sales Hold Invoice Modification From Invoice History Page ");
		GenericMethods.fnEndTestCase();
	}*/
	
	/*@Test (enabled = false,priority = 20) // Feature changed -- Hold Invoice record shown on Recall Window only
	public void validate_Sales_Invoice_Payment_For_Hold_From_Invoice_History() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_For_Hold_From_Invoice_History");
		log.info("Payment For Hold Invoice From Invoice History Page");
		String holdInvoice=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				1, 22);
		
		int rowindex=20;
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 7);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 11);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 17);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 18);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 22);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		refOrderPage.click_On_DashBoard();
		RefMenu.OpenPage("invoice history");
		RefEstimationHistory.verifyEditFeature(holdInvoice);
	    refOrderPage.click_On_Payment();
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		boolean result=refOrderPage.click_On_Header();
		GenericMethods.fnwait(3);
		RefEstimationHistory.click_On_Close_Button();
		RefMenu.OpenPage("invoicing");
		Assert.assertTrue(result);
		log.info("Payment completed for Hold Invoice From Invoice History");
		fnWriteSteps("Pass", "Successfully Completed Payment For Hold Invoice Payment");
		GenericMethods.fnEndTestCase();
		
	}*/

	@Test 
	public void validate_Sales_Invoice_Existing_B2B_Cust_Payment_Cash() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Existing_B2B_Cust_Payment_Cash");
		log.info("Sales Invoice Creation Existing B2C Cust With Cash Payment");
		int rowindex = 2;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1, Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice for B2B Cust With Payment Cash is done Successfully");
		GenericMethods.fnEndTestCase();
}
	@Test 
	public void validate_Sales_Invoice_Existing_B2C_Cust_Card_Payment_Test() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Existing_B2C_Cust_Card_Payment_Test");
		log.info("Sales Invoice Creation With Existing B2C Customer With Card Payment");
		int rowindex = 3;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1,Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice for B2C Cust With Card Payment is done Successfully");
		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void validate_Sales_Invoice_Creation_Running_B2C_ProductCode_Wallet_Paytm_Test() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_Running_B2C_ProductCode_Wallet_Paytm_Test");
		log.info("Sales Invoice Creation With Running B2C Customer With Wallet Payment Through Paytm");
		int rowindex = 4;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1, Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice for B2C Cust With Wallet Payment through Paytm is done Successfully");
		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void validate_Sales_Invoice_Running_B2B_Wallet_Payment_Mobikwik_Test() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Running_B2B_Wallet_Payment_Mobikwik_Test");
		log.info("Sales Invoice Creation With Running B2B Customer With Wallet Payment Through Mobikwik");
		int rowindex = 5;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1,Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice for B2B Cust With Wallet Payment through Mobikwik is done Successfully");
		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void validate_Sales_Invoice_Creation_Payment_Wallet_Freecharge() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_Payment_Wallet_Freecharge");
		log.info("Sales Invoice Creation  With Wallet Payment Through Freecharge");
		int rowindex = 6;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1, Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice  With Wallet Payment through Freecharge is done Successfully");
		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void validate_Sales_Invoice_Creation_Payment_Wallet_AirtelMoney_Test() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_Payment_Wallet_AirtelMoney_Test");
		log.info("Sales Invoice Creation  With Wallet Payment Through AirtelMoney");
		int rowindex = 7;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1, Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice  With Wallet Payment through Airtel Money is done Successfully");
		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void validate_Sales_Invoice_Creation_Payment_Wallet_OlaMoney_Test() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_Payment_Wallet_OlaMoney_Test");
		log.info("Sales Invoice Creation  With Wallet Payment Through OlaMoney");
		int rowindex = 8;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice",rowindex ,0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1, Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice  With Wallet Payment through Ola Money is done Successfully");
		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void validate_Sales_Invoice_Creation_Payment_Wallet_BHIM_Test() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_Payment_Wallet_BHIM_Test");
		log.info("Sales Invoice Creation  With Wallet Payment Through BHIM");
		int rowindex = 9;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1, Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice  With Wallet Payment through BHIM is done Successfully");
		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void validate_Sales_Invoice_Creation_Payment_Wallet_GooglePay_Test() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_Payment_Wallet_GooglePay_Test");
		log.info("Sales Invoice Creation  With Wallet Payment Through GOOGLE PAY");
		int rowindex = 10;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1, Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice  With Wallet Payment through Google Pay is done Successfully");
		GenericMethods.fnEndTestCase();
	}

   @Test 
	public void validate_Sales_Invoice_Creation_Without_Cust_With_Zero_Payment() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_Without_Cust_With_Zero_Payment");
		log.info("Sales Invoice Creation  Without Customer With Zero Payment");
		int rowindex = 13;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1, Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Finish_Button();
	    String invoiceVochure = refOrderPage.get_Vochure_Page();
	    String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice  Created Without Customer And With Zero Payment");
		GenericMethods.fnEndTestCase();
}
    @Test 
	public void validate_Sales_Invoice_Creation_Payment_Bank_Account() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_Payment_Bank_Account");
		log.info("Sales Invoice Creation  Without Customer With Bank Account Payment");
		int rowindex = 14;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1, Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		// refOrderPage.payment_Due_Operations(strInstructions);
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice  Created With Bank Account Payment");
		GenericMethods.fnEndTestCase();
}
   	@Test 
	public void validate_Sales_Invoice_Creation_Own_Gift_Vochure_Test() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_Own_Gift_Vochure_Test");
		log.info("Sales Invoice Creation With Own Gift Vochure");
		int rowindex = 15;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1, Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice  Created With Own Gift Vochure");
		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void validate_Sales_Invoice_Creation_ThirdParty_Vochure_Payment_Test() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_ThirdParty_Vochure_Payment_Test");
		log.info("Sales Invoice Creation With Third Gift Vochure");
		int rowindex = 16;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1, Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice  Created With Third Gift Vochure");
		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void validate_Sales_Invoice_Creation_Payment_Credit_Note() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_Payment_Credit_Note");
		log.info("Sales Invoice Creation With Credit Note");
		int rowindex = 17;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1, Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice  Created With Credit Note");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Sales_Invoice_Creation_Payment_RedeemAmount() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_Payment_RedeemAmount");
		log.info("Sales Invoice Creation With Redeem Points");
		int rowindex = 18;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1, Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice  Created With Redeem Points");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Sales_Invoice_Creation_Payment_Cheque_Test() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_Payment_Cheque_Test");
		log.info("Sales Invoice Creation  With Cheque PaymentMode");
		int rowindex = 22;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		 
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1, Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice  With Cheque PaymentMode is done Successfully");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Sales_Invoice_Creation_Payment_AdvanceReceivedCollection_Test() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_Payment_AdvanceReceivedCollection_Test");
		log.info("Sales Invoice Creation  With AdvanceReceivedCollection PaymentMode");
		int rowindex = 23;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		 
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1, Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice  With AdvanceReceivedCollection PaymentMode is done Successfully");
		GenericMethods.fnEndTestCase();
	}
	
	
	@Test 
	public void validate_Sales_Invoice_Creation_Payment_Multiple_Modes() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_Payment_Multiple_Modes");
		log.info("Sales Invoice Creation With Multiple Paymments Mode");
		int rowindex = 21;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice",
				rowindex ,0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1, Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Successfully Created Sales Invoice With Multiple Payment Modes");
		fnWriteSteps("Pass", "Sales Invoice Is Created With Multiple Payment Modes");
		GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void validate_Sales_Invoice_Creation_With_Partial_Payment_Test() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_With_Partial_Payment_Test");
		log.info("Sales Invoice Creation  With Partial Payments");
		int rowindex = 11;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1, Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		refOrderPage.payment_Due_Operations(strInstructions);
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice  With Partial Payments");
		GenericMethods.fnEndTestCase();
	}
 @Test 
 public void validate_Sales_Invoice_Modification_Partial_Due_From_Recall_Window() {
 	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Modification_Partial_Due_From_Recall_Window");
 	log.info("Sales Invoice Modification For Partial Due");
 	int rowindex = 42;
 	String Type="Payment";
 	String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", 11, 22);
 	String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 1);
 	String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 3);
 	String Invoice = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 4);
 	String PageType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 5);
 	String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 6);
 	String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 7);
 	String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 8);
 	
 	String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 9);
 	String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 10);
 	String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 11);
 	String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 12);
 	String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 13);
 	String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 14);
 	String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 15);
 	String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 16);
 	String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 17);
 	String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 18);
 	String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 19);
 	String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 20);
 	String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 21);
 	String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 22);
 	String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 23);
 	String amount=refOrderPage.sales_Order_Modification_Page(invoiceVochure,PageType, Modification, Quantity, Invoice);
 	GenericMethods.fnwait(2);
     refOrderPage.validate_Sales_Invoice_Modification(amount, Type);
     refOrderPage.payment_Page(PaymentType, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
     refOrderPage.click_Scroll_Down();
 	refOrderPage.click_Finish_Button();
 	String txtValidate="Do you want to proceed with a credit transaction for the balance amount";
 	boolean result=refOrderPage.validate_Sales_Invoice_Hold(txtValidate.trim());
 	refOrderPage.send_Instructions(strInstructions);
 	refOrderPage.click_On_OK_Button();
 	Assert.assertTrue(result);
 	log.info("Sales Invoice is Successfully Modified For Partial Payment");
 	fnWriteSteps("Pass", "Sales invoice Is Successfully Modified For Partial Payment");
 	GenericMethods.fnEndTestCase();
 }
 @Test 
 public void validate_Sales_Invoice_Modification_Partial_Due_From_History_Test() {
 	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Modification_Due_From_History_Test");
 	log.info("Sales Invoice Modification With Partial Due Payment From Invoice History Page");
 	int rowindex = 43;
 	String Type="Payment";
 	String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", 11, 22);
 	String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 1);
 	String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 3);
 	String Invoice = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 4);
 	String PageType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 5);
 	String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 6);
 	String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 7);
 	String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 8);
 	
 	String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 9);
 	String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 10);
 	String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 11);
 	String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 12);
 	String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 13);
 	String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 14);
 	String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 15);
 	String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 16);
 	String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 17);
 	String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 18);
 	String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
 			"Sales Invoice", rowindex, 19);
 	String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 20);
 	String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 21);
 	String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 22);
 	String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
 			rowindex, 23);
 	refOrderPage.click_On_DashBoard();
 	RefMenu.OpenPage("invoice history");
 	GenericMethods.fnwait(2);
 	RefEstimationHistory.click_On_Logo();
 	RefEstimationHistory.click_On_Toggle_Switch();
 	RefEstimationHistory.verifyEditFeature(invoiceVochure);
 	String amount=	refOrderPage.sales_Order_Modification_Page(invoiceVochure,PageType, Modification, Quantity, Invoice);
 	refOrderPage.validate_Sales_Invoice_Modification(amount, Type);
 	refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
 	refOrderPage.click_Scroll_Down();
 	refOrderPage.click_Finish_Button();
 	String txtValidate="Do you want to proceed with a credit transaction for the balance amount";
 	boolean result=refOrderPage.validate_Sales_Invoice_Hold(txtValidate.trim());
 	refOrderPage.send_Instructions(strInstructions);
 	refOrderPage.click_On_OK_Button();
 	RefEstimationHistory.click_On_Close_Button();
 	RefMenu.OpenPage("invoicing");
 	Assert.assertTrue(result);
 	log.info("Successfully Modified Fully Due Invoice From Invoice History ");
 	fnWriteSteps("Pass", "Sales Invoice Modification with Partial Due Payment From History");
 	GenericMethods.fnEndTestCase();
 }

	@Test 
	public void validate_Sales_Invoice_Creation_With_Full_Due_Test() {
		GenericMethods.fnStartTestCase("validate_Sales_Invoice_Creation_With_Full_Due_Test");
		log.info("Sales Invoice Creation  With Full Due");
		int rowindex = 12;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 3);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 4);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 5);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 7);
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 8);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 9);
		String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 10);
		String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 11);
		String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 12);
		String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 13);
		String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 14);
		String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 15);
		String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 16);
		String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 17);
		String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 18);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 19);
		String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 20);
		String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", rowindex, 21);
		String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 23);
		String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 24);
		String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 25);
		String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 26);
		refOrderPage.sales_Invoice_Creation_Page(strSalesOrderType, strProduct,strProduct1, Customer, strCustType, strFirstName,
				strPhoneNo, PaymentType);
		GenericMethods.fnwait(3);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName,
				strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount,strAmount1,strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		refOrderPage.payment_Due_Operations(strInstructions);
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		boolean result = refOrderPage.validate_Sales_Vochure_Page(invoiceVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 22, vochure);
		log.info("Sales Invoice is Successfully Created and Validated");
		fnWriteSteps("Pass", "Sales invoice  With Complete Due");
		GenericMethods.fnEndTestCase();
	}

  @Test 
  public void validate_Sales_Invoice_Modification_Due_From_Recall_Window() {
	GenericMethods.fnStartTestCase("validate Sales Invoice Modification Due From Recall Window");
	log.info("Sales Invoice Modification For Due Payment From Recall Window");
	int rowindex = 41;
	String Type="Payment";
	String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", 12,22);
	String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 1);
	String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 3);
	String Invoice = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 4);
	String PageType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 5);
	String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 6);
	String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 7);
	String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 8);
    String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 9);
	String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 10);
	String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 11);
	String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 12);
	String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 13);
	String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 14);
	String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 15);
	String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 16);
	String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 17);
	String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 18);
	String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 19);
	String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 20);
	String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 21);
	String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 22);
	String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 23);
	String amount=refOrderPage.sales_Order_Modification_Page(invoiceVochure,PageType, Modification, Quantity, Invoice);
	GenericMethods.fnwait(2);
    refOrderPage.validate_Sales_Invoice_Modification(amount, Type);
    refOrderPage.payment_Page(PaymentType, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
    refOrderPage.click_Scroll_Down();
	refOrderPage.click_Finish_Button();
	String txtValidate="Do you want to proceed with a credit transaction for the balance amount";
	boolean result=refOrderPage.validate_Sales_Invoice_Hold(txtValidate.trim());
	refOrderPage.send_Instructions(strInstructions);
	refOrderPage.click_On_OK_Button();
	Assert.assertTrue(result);
	log.info("Successfully Modified Fully Due Invoice From Recall Window ");
	fnWriteSteps("Pass", "Sales invoice Is Successfully Modified For Due payment From Recall Window");
	GenericMethods.fnEndTestCase();
}

@Test 
public void validate_Sales_Invoice_Modification_Due_From_History_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Modification_Due_From_History_Test");
	log.info("Sales Invoice Modification For Due Payment From Invoice History Page");
	int rowindex = 44;
	String Type="Payment";
	String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", 12, 22);
	String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 1);
	String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 3);
	String Invoice = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 4);
	String PageType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 5);
	String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 6);
	String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 7);
	String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 8);
	
	String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 9);
	String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 10);
	String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 11);
	String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 12);
	String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 13);
	String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 14);
	String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 15);
	String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 16);
	String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 17);
	String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 18);
	String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 19);
	String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 20);
	String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 21);
	String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 22);
	String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 23);
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("invoice history");
	GenericMethods.fnwait(2);
	RefEstimationHistory.click_On_Logo();
	RefEstimationHistory.click_On_Toggle_Switch();
	RefEstimationHistory.verifyEditFeature(invoiceVochure);
	String amount=	refOrderPage.sales_Order_Modification_Page(invoiceVochure,PageType, Modification, Quantity, Invoice);
	refOrderPage.validate_Sales_Invoice_Modification(amount, Type);
	refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
	refOrderPage.click_Scroll_Down();
	refOrderPage.click_Finish_Button();
	String txtValidate="Do you want to proceed with a credit transaction for the balance amount";
	boolean result=refOrderPage.validate_Sales_Invoice_Hold(txtValidate.trim());
	refOrderPage.send_Instructions(strInstructions);
	refOrderPage.click_On_OK_Button();
	RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("invoicing");
	Assert.assertTrue(result);
	log.info("Successfully Modified Fully Due Invoice From Invoice History ");
	fnWriteSteps("Pass", "Sales Invoice Modification For Due Payment From History");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Sales_Invoice_Modification_Increasing_Quantity_Recall_Window_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Modification_Increasing_Quantity_Recall_Window_Test");
	log.info("Sales Invoice Modification By Increasing Quantity");
	int rowindex = 33;
	String Type="Payment";
	String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", 12, 22);
	String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 1);
	String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 3);
	String Invoice = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 4);
	String PageType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 5);
	String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 6);
	String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 7);
	String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 8);
	
	String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 9);
	String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 10);
	String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 11);
	String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 12);
	String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 13);
	String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 14);
	String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 15);
	String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 16);
	String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 17);
	String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 18);
	String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 19);
	String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 20);
	String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 21);
	String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 22);
	String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 23);
	String amount=refOrderPage.sales_Order_Modification_Page(invoiceVochure,PageType, Modification, Quantity, Invoice);
	GenericMethods.fnwait(2);
    refOrderPage.validate_Sales_Invoice_Modification(amount, Type);
    refOrderPage.payment_Page(PaymentType, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
    refOrderPage.click_Scroll_Down();
	refOrderPage.click_Finish_Button();
	refOrderPage.payment_Due_Operations(strInstructions);
	String InvoiceVochure = refOrderPage.get_Vochure_Page();
    boolean result = refOrderPage.validate_Sales_Vochure_Page(InvoiceVochure);
	Assert.assertTrue(result);
	log.info("Sales Invoice is Successfully Modified By Increasing Quantity");
	fnWriteSteps("Pass", "Sales invoice Is Successfully Modified By Increasing Quantity");
	GenericMethods.fnEndTestCase();
	
	
}
@Test 
public void validate_Sales_Invoice_Modification_Decreasing_Quantity_From_Recall_Window_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Modification_Decreasing_Quantity_From_Recall_Window_Test");
	log.info("Sales Invoice Modification By Decreasing Quantity");
	int rowindex = 34;
	String Type="Payment";
	String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", 12, 22);
	String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 1);
	String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 3);
	String Invoice = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 4);
	String PageType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 5);
	String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 6);
	String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 7);
	String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 8);
	
	String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 9);
	String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 10);
	String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 11);
	String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 12);
	String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 13);
	String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 14);
	String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 15);
	String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 16);
	String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 17);
	String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 18);
	String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 19);
	String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 20);
	String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 21);
	String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 22);
	String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 23);
	String amount=refOrderPage.sales_Order_Modification_Page(invoiceVochure,PageType, Modification, Quantity, Invoice);
	GenericMethods.fnwait(2);
    refOrderPage.validate_Sales_Invoice_Modification(amount, Type);
    refOrderPage.payment_Page(PaymentType, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
    refOrderPage.click_Scroll_Down();
	refOrderPage.click_Finish_Button();
	refOrderPage.payment_Due_Operations(strInstructions);
	String InvoiceVochure = refOrderPage.get_Vochure_Page();
	boolean result = refOrderPage.validate_Sales_Vochure_Page(InvoiceVochure);
	Assert.assertTrue(result);
	log.info("Sales Invoice is Successfully Modified By Decreasing Quantity");
	fnWriteSteps("Pass", "Sales invoice Is Successfully Modified By Decreasing Quantity");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Sales_Invoice_Modification_By_Adding_Product_From_Recall_Window_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Modification_By_Adding_Product_From_Recall_Window_Test");
	log.info("Sales Invoice Modification By Adding Product");
	int rowindex = 35;
	String Type="Payment";
	String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", 12, 22);
	String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 1);
	String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 3);
	String Invoice = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 4);
	String PageType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 5);
	String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 6);
	String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 7);
	String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 8);
	
	String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 9);
	String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 10);
	String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 11);
	String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 12);
	String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 13);
	String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 14);
	String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 15);
	String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 16);
	String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 17);
	String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 18);
	String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 19);
	String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 20);
	String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 21);
	String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 22);
	String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 23);
	String amount=refOrderPage.sales_Order_Modification_Page(invoiceVochure,PageType, Modification, Quantity, Invoice);
	GenericMethods.fnwait(2);
    refOrderPage.validate_Sales_Invoice_Modification(amount, Type);
    refOrderPage.payment_Page(PaymentType, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
    refOrderPage.click_Scroll_Down();
	refOrderPage.click_Finish_Button();
	refOrderPage.payment_Due_Operations(strInstructions);
	String InvoiceVochure = refOrderPage.get_Vochure_Page();
	boolean result = refOrderPage.validate_Sales_Vochure_Page(InvoiceVochure);
	Assert.assertTrue(result);
    log.info("Sales Invoice is Successfully Modified By Decreasing Quantity");
	fnWriteSteps("Pass", "Sales invoice Is Successfully Modified By Decreasing Quantity");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Sales_Invoice_Modification_Removing_Product_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Modification_Removing_Product_Test");
	log.info("Sales Invoice Modification By Removing Product");
	int rowindex = 36;
	String Type="Payment";
	String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", 12,22);
	String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 1);
	String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 3);
	String Invoice = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 4);
	String PageType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 5);
	String PaymentType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 6);
	String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 7);
	String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 8);
	
	String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 9);
	String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 10);
	String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 11);
	String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 12);
	String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 13);
	String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 14);
	String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 15);
	String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 16);
	String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 17);
	String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 18);
	String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 19);
	String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 20);
	String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 21);
	String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 22);
	String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 23);
	String amount=refOrderPage.sales_Order_Modification_Page(invoiceVochure,PageType, Modification, Quantity, Invoice);
	GenericMethods.fnwait(2);
    refOrderPage.validate_Sales_Invoice_Modification(amount, Type);
    refOrderPage.payment_Page(PaymentType, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
    refOrderPage.click_Scroll_Down();
	refOrderPage.click_Finish_Button();
	refOrderPage.payment_Due_Operations(strInstructions);
	String InvoiceVochure = refOrderPage.get_Vochure_Page();
	boolean result = refOrderPage.validate_Sales_Vochure_Page(InvoiceVochure);
	Assert.assertTrue(result);
	log.info("Sales Invoice is Successfully Modified By Removing Product");
	fnWriteSteps("Pass", "Sales invoice Is Successfully Modified By Removing Product");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Sales_Invoice_Modification_Increasing_Quantity_Invoice_History() {
	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Modification_Increasing_Quantity_Invoice_History");
	log.info("Sales Invoice Modification By Increasing Quantity From Invoice History ");
	int rowindex = 37;
	String Type="Payment";
	String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", 12,22);
	String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 1);
	String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 3);
	String Invoice = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 4);
	String PageType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 5);
	String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 6);
	String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 7);
	String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 8);
	
	String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 9);
	String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 10);
	String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 11);
	String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 12);
	String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 13);
	String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 14);
	String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 15);
	String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 16);
	String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 17);
	String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 18);
	String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 19);
	String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 20);
	String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 21);
	String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 22);
	String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 23);
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("invoice history");
	RefEstimationHistory.click_On_Logo();
	RefEstimationHistory.click_On_Toggle_Switch();
	RefEstimationHistory.verifyEditFeature(invoiceVochure);
	String amount=	refOrderPage.sales_Order_Modification_Page(invoiceVochure,PageType, Modification, Quantity, Invoice);
	refOrderPage.validate_Sales_Invoice_Modification(amount, Type);
	refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
	refOrderPage.click_Scroll_Down();
	refOrderPage.click_Finish_Button();
	refOrderPage.payment_Due_Operations(strInstructions);
	String InvoiceVochure = refOrderPage.get_Vochure_Page();
	boolean result = refOrderPage.validate_Sales_Vochure_Page(InvoiceVochure);
	GenericMethods.fnwait(3);
	RefEstimationHistory.click_On_Close_Button();
	GenericMethods.fnwait(2);
	RefMenu.OpenPage("invoicing");
	Assert.assertTrue(result);
	log.info("Due Invoice Has Been Successfully Modified And Fully Paid");
	fnWriteSteps("Pass", "Successfully Modified Sales Invoice From Invoice History page");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Sales_Invoice_Decresing_Qunatity_From_Invoice_History() {
	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Decresing_Qunatity_From_Invoice_History");
	log.info("Sales Invoice Modification By Decreasing Quantity From Invoice History ");
	int rowindex = 38;
	String Type="Payment";
	String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", 12, 22);
	String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 1);
	String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 3);
	String Invoice = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 4);
	String PageType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 5);
	String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 6);
	String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 7);
	String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 8);
	
	String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 9);
	String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 10);
	String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 11);
	String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 12);
	String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 13);
	String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 14);
	String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 15);
	String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 16);
	String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 17);
	String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 18);
	String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 19);
	String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 20);
	String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 21);
	String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 22);
	String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 23);
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("invoice history");
	RefEstimationHistory.click_On_Logo();
	RefEstimationHistory.click_On_Toggle_Switch();
	RefEstimationHistory.verifyEditFeature(invoiceVochure);
	String amount=	refOrderPage.sales_Order_Modification_Page(invoiceVochure,PageType, Modification, Quantity, Invoice);
	refOrderPage.validate_Sales_Invoice_Modification(amount, Type);
	refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
	refOrderPage.click_Scroll_Down();
	refOrderPage.click_Finish_Button();
	refOrderPage.payment_Due_Operations(strInstructions);
	String InvoiceVochure = refOrderPage.get_Vochure_Page();
	boolean result = refOrderPage.validate_Sales_Vochure_Page(InvoiceVochure);
    GenericMethods.fnwait(3);
	RefEstimationHistory.click_On_Close_Button();
	GenericMethods.fnwait(2);
	RefMenu.OpenPage("invoicing");
	Assert.assertTrue(result);
	log.info("Due Invoice Has Been Successfully Modified And Fully Paid");
	fnWriteSteps("Pass", "Successfully Modified Sales Invoice From Invoice History page");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Sales_Invoice_Modification_From_History_Adding_Product_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Modification_From_History_Adding_Product_Test");
	log.info("Sales Invoice Modification By Adding From Invoice History ");
	int rowindex = 39;
	String Type="Payment";
	String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", 12, 22);
	String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 1);
	String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 3);
	String Invoice = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 4);
	String PageType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 5);
	String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 6);
	String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 7);
	String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 8);
	
	String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 9);
	String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 10);
	String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 11);
	String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 12);
	String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 13);
	String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 14);
	String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 15);
	String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 16);
	String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 17);
	String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 18);
	String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", rowindex, 19);
	String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 20);
	String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 21);
	String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 22);
	String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
			rowindex, 23);
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("invoice history");
	RefEstimationHistory.click_On_Logo();
	RefEstimationHistory.click_On_Toggle_Switch();
	RefEstimationHistory.verifyEditFeature(invoiceVochure);
	String amount=	refOrderPage.sales_Order_Modification_Page(invoiceVochure,PageType, Modification, Quantity, Invoice);
	refOrderPage.validate_Sales_Invoice_Modification(amount, Type);
	refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
	refOrderPage.click_Scroll_Down();
	refOrderPage.click_Finish_Button();
	refOrderPage.payment_Due_Operations(strInstructions);
	String InvoiceVochure = refOrderPage.get_Vochure_Page();
	boolean result = refOrderPage.validate_Sales_Vochure_Page(InvoiceVochure);
	GenericMethods.fnwait(3);
	RefEstimationHistory.click_On_Close_Button();
	GenericMethods.fnwait(2);
	RefMenu.OpenPage("invoicing");
	Assert.assertTrue(result);
	log.info("Due Invoice Has Been Successfully Modified And Fully Paid");
	fnWriteSteps("Pass", "Successfully Modified Sales Invoice From Invoice History page");
	GenericMethods.fnEndTestCase();
}

     @Test 
     public void validate_Sales_Invoice_Modification_From_History_Deleting_Product_Test() {
     GenericMethods.fnStartTestCase("validate_Sales_Invoice_Modification_From_History_Deleting_Product_Test");
     log.info("Sales Invoice Modification By Deleting Product From Invoice History ");
     int rowindex = 40;
     String Type="Payment";
     String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
		"Sales Invoice", 12, 22);
     String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
		rowindex, 1);
     String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
		rowindex, 3);
     String Invoice = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
		"Sales Invoice", rowindex, 4);
     String PageType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
		"Sales Invoice", rowindex, 5);
     String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
		rowindex, 6);
     String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
		"Sales Invoice", rowindex, 7);
     String strCardNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
		rowindex, 8);

     String strWallet = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
		rowindex, 9);
     String strBankAccNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
		"Sales Invoice", rowindex, 10);
     String strReference = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
		"Sales Invoice", rowindex, 11);
     String strBankName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
		"Sales Invoice", rowindex, 12);
     String strVochureType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
		"Sales Invoice", rowindex, 13);
     String strVochureNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
		"Sales Invoice", rowindex, 14);
     String strChequeNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
		"Sales Invoice", rowindex, 15);
     String strBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
		rowindex, 16);
     String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
		"Sales Invoice", rowindex, 17);
     String strCreditNote = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
		"Sales Invoice", rowindex, 18);
     String strAdvanceAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
		"Sales Invoice", rowindex, 19);
     String strAmount1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
		rowindex, 20);
     String strAmount2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
		rowindex, 21);
     String BankCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
		rowindex, 22);
     String ChequeCheck= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
		rowindex, 23);
     refOrderPage.click_On_DashBoard();
     RefMenu.OpenPage("invoice history");
     GenericMethods.fnwait(2);
     RefEstimationHistory.click_On_Logo();
     RefEstimationHistory.click_On_Toggle_Switch();
     RefEstimationHistory.verifyEditFeature(invoiceVochure);
     String amount=	refOrderPage.sales_Order_Modification_Page(invoiceVochure,PageType, Modification, Quantity, Invoice);
     refOrderPage.validate_Sales_Invoice_Modification(amount, Type);
     refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
     refOrderPage.click_Scroll_Down();
     refOrderPage.click_Finish_Button();
     refOrderPage.payment_Due_Operations(strInstructions);
     String InvoiceVochure = refOrderPage.get_Vochure_Page();
     boolean result = refOrderPage.validate_Sales_Vochure_Page(InvoiceVochure);
     GenericMethods.fnwait(3);
     RefEstimationHistory.click_On_Close_Button();
     GenericMethods.fnwait(2);
     RefMenu.OpenPage("invoicing");
     Assert.assertTrue(result);
     log.info("Due Invoice Has Been Successfully Modified And Fully Paid");
     fnWriteSteps("Pass", "Successfully Modified Sales Invoice From Invoice History page");
     GenericMethods.fnEndTestCase();
  }
     @Test 
    public void validate_Sales_Invoice_Modification_HomeDelivery_Recall_Window() {
	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Modification_HomeDelivery_Recall_Window");
	log.info("Home Delivery Sales Invoice Modification From Recall Window");
	String salesInvoiceVochure=GenericMethods.getPropertyValue("HomeDeliveryInvoice");
	boolean result=refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(salesInvoiceVochure);
	Assert.assertTrue(result);
	log.info("Home Delivery Invoice Cannot Be Modified From Recall Window");
	fnWriteSteps("Pass", "Home Delivery Invoice Cannot Be Modified From Recall Window");
	GenericMethods.fnEndTestCase();
  }
  @Test 
  public void validate_Sales_Invoice_Modification_HomeDelivery_Invoice_History_Page_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Modification_HomeDelivery_Invoice_History_Page_Test");
	log.info("Validate Sales Home Delivery Invoice Modification From Invoice History Page ");
	String salesInvoiceVochure=GenericMethods.getPropertyValue("HomeDeliveryInvoice");
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("invoice history");
	GenericMethods.fnwait(2);
	RefEstimationHistory.click_On_Logo();
	GenericMethods.fnwait(2);
	RefEstimationHistory.clickDuePaidToggle();
	GenericMethods.fnwait(2);
	RefEstimationHistory.serachRecord(salesInvoiceVochure);
	GenericMethods.fnwait(2);
	boolean result=RefEstimationHistory.validate_Edit_Button();
	GenericMethods.fnwait(2);
	RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("invoicing");
	Assert.assertTrue(result);
	log.info("Home Delivery invoice Cannot Be Modified");
	fnWriteSteps("Pass", "Home Delivery invoice Cannot Be Modified");
	GenericMethods.fnEndTestCase();
	
 }
  @Test 
  public void validate_Sales_Invoice_Deletion_Fully_Paid_From_Invoice_History_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Deletion_Fully_Paid_From_Invoice_History_Test");
	log.info("Sales Invoice Deletion For Fully Paid From Invoice History");
	String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", 10,22);
	String remarks="Remarks";
	String internet ="NULL";
	refOrderPage.click_On_DashBoard();
    RefMenu.OpenPage("invoice history");
    boolean result=RefEstimationHistory.document_History_Deletion(invoiceVochure, remarks,internet);
	GenericMethods.fnwait(3);
	RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("invoicing");
	Assert.assertTrue(result);
	log.info("Successfully Deleted Fully Paid Invoice");
	fnWriteSteps("Pass", "Sales Invoice Is Successfully Deleted for fully paid");
	GenericMethods.fnEndTestCase();
	
}
  @Test 
  public void validate_Sales_Invoice_Deletion_B2C_Order_Converted_To_Invoice_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Deletion_B2C_Order_Converted_To_Invoice_Test");
	log.info("Sales Invoice Deletion Sales order Converted To Invoice");
	String invoiceVochure =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Order", 12,9);
	String remarks="Remarks";
	String internet ="NULL";
	refOrderPage.click_On_DashBoard();
    RefMenu.OpenPage("invoice history");
	RefEstimationHistory.click_On_Toggle_Switch();
	boolean result=RefEstimationHistory.document_History_Deletion(invoiceVochure, remarks,internet);
	GenericMethods.fnwait(3);
	RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("invoicing");
	Assert.assertTrue(result);
	log.info("Successfully Deleted Fully Paid Invoice");
	fnWriteSteps("Pass", "Sales Invoice Is Successfully Deleted for fully paid");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validated_Sales_Invoice_Deletion_Without_Customer_Test() {
	GenericMethods.fnStartTestCase("validated_Sales_Invoice_Deletion_Without_Customer_Test");
	log.info("Sales Invoice Deletion Created Without Customer");
	String invoiceVochure =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice",13, 22);
	String remarks="Remarks";
	String internet ="NULL";
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("invoice history");
    boolean result=RefEstimationHistory.document_History_Deletion(invoiceVochure, remarks,internet);
	GenericMethods.fnwait(5);
	RefEstimationHistory.click_On_Close_Button();
    RefMenu.OpenPage("invoicing");
	Assert.assertTrue(result);
	log.info("Successfully Deleted sales Invoice Created Without Customer");
	fnWriteSteps("Pass", "Successfully Deleted sales Invoice Created Without Customer");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Invoice_Deletion_Fully_Due_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Deletion_Fully_Due_Test");
	log.info("Sales Invoice Deletion with Fully Due");
	String invoiceVochure =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", 12,22);
	String remarks="Remarks";
	String internet ="NULL";
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("invoice history");
	GenericMethods.fnwait(2);
	RefEstimationHistory.click_On_Toggle_Switch();
	boolean result=RefEstimationHistory.document_History_Deletion(invoiceVochure, remarks,internet);
	GenericMethods.fnwait(5);
	RefEstimationHistory.click_On_Close_Button();
    RefMenu.OpenPage("invoicing");
	Assert.assertTrue(result);
	log.info("Successfully Deleted sales Invoice With Fully Due");
	fnWriteSteps("Pass", "Successfully Deleted sales Invoice With Fully Due");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Invoice_Deletion_HomeDelivery_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Deletion_HomeDelivery_Test");
	log.info("Sales Invoice Deletion with Home Delivery");
	String invoiceVochure ="INV/B1/2/119";/* ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", 44, 0);*/
	String remarks="Remarks";
	String internet ="NULL";
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("invoice history");
	GenericMethods.fnwait(2);
	RefEstimationHistory.click_On_Toggle_Switch();
	boolean result=RefEstimationHistory.document_History_Deletion(invoiceVochure, remarks,internet);
	GenericMethods.fnwait(5);
	RefEstimationHistory.click_On_Close_Button();
	//System.out.println("entered");
	RefMenu.OpenPage("invoicing");
	Assert.assertTrue(result);
	log.info("Successfully Deleted sales Invoice With Home Delivery");
	fnWriteSteps("Pass", "Successfully Deleted sales Invoice With Home Delivery");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Invoice_Deletion_Estimation_Converted_To_Invoice_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Deletion_Estimation_Converted_To_Invoice_Test");
	log.info("Sales Invoice Deletion Converted From Sales Estimation");
	String invoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"EStimations",56, 2);
	String remarks="Remarks";
	String internet ="NULL";
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("invoice history");
	GenericMethods.fnwait(2);
	RefEstimationHistory.click_On_Toggle_Switch();
	boolean result=RefEstimationHistory.document_History_Deletion(invoiceVochure, remarks,internet);
	GenericMethods.fnwait(5);
	RefEstimationHistory.click_On_Close_Button();
    RefMenu.OpenPage("invoicing");
	Assert.assertTrue(result);
	log.info("Successfully Deleted sales Invoice Converted From Sales Estimation");
	fnWriteSteps("Pass", "Successfully Deleted sales Invoice From Converted From Sales Estimation");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Invoice_Deletion_Partial_Payment_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Deletion_Partial_Payment_Test");
	log.info("Sales Invoice Deletion For Partial Payment");
	String invoiceVochure =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", 22,22);
	String remarks="Remarks";
	String internet ="NULL";
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("invoice history");
	GenericMethods.fnwait(2);
	RefEstimationHistory.click_On_Toggle_Switch();
	boolean result=RefEstimationHistory.document_History_Deletion(invoiceVochure, remarks,internet);
	GenericMethods.fnwait(5);
	RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("invoicing");
	Assert.assertTrue(result);
	log.info("Successfully Deleted sales Invoice For Partial Payment");
	fnWriteSteps("Pass", "Successfully Deleted sales Invoice For Partial Payment");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Invoice_Deletion_Without_Internet_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Invoice_Deletion_Without_Internet_Test");
	log.info("************Sales Invoice Deletion Without Internet***********");
	String invoiceVochure =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
			"Sales Invoice", 16,22);
	String remarks="Remarks";
	String internet ="Without Internet";
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("invoice history");
	GenericMethods.fnwait(2);
	RefEstimationHistory.document_History_Deletion(invoiceVochure, remarks,internet);
	GenericMethods.fnwait(5);
	String txtValidate="Please check the internet connection";
	boolean result=refOrderPage.validate_Sales_Invoice_Hold(txtValidate);
	RefEstimationHistory.click_On_Close_Button();
	RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("invoicing");
	Assert.assertTrue(result);
	log.info("************Sales Invoice Deletion Without Internet***********");
	fnWriteSteps("Pass", "Successfully Validated Sales Invoice Deletion Without Internet");
	GenericMethods.fnEndTestCase();
}

   
}
