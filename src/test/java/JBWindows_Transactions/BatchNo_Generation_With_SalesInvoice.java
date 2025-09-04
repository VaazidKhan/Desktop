package JBWindows_Transactions;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.PUR.PUR_PurchaseInvoice;
import JBWindows.SAL.SAL_DocumentHistory;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows.Transactions.Trans_Order_Page;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class BatchNo_Generation_With_SalesInvoice extends BaseClass  {
	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessgBox;
    Trans_Order_Page refOrderPage;
    SAL_DocumentHistory RefEstimationHistory;
    PUR_PurchaseInvoice refPurchaseInvoice;
   
	public BatchNo_Generation_With_SalesInvoice() {
		super();
	}

	@BeforeClass
	public void initializingWindows() {
		DOMConfigurator.configure("log4j.xml");
		RefLogin = new Login(driver);
		RefDashboard = new APP_Dashboard(driver);
		RefMenu = new APP_Menu(driver);
		RefMessgBox = new MessageBoxEffia(driver);
		refOrderPage = new Trans_Order_Page();
		RefEstimationHistory = new SAL_DocumentHistory();
		refPurchaseInvoice=new PUR_PurchaseInvoice();
	}

	@AfterClass
	public void terminatingBrowser() {
		GenericMethods.fnwait(28);
		RefLogin.ClickCloseButton();
	}

	@BeforeMethod
	public void setUp() {
		GenericMethods.fnwait(28);
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(9);
		RefDashboard.clickMenuBtn();
		RefMenu.OpenPage("invoicing");

	}

	@AfterMethod
	public void tearDown() {
		GenericMethods.fnStartTestCase("tearDown");
		refOrderPage.click_On_DashBoard();
		GenericMethods.fnwait(2);
		RefDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		RefMessgBox.ExitApplication_Yes();
		GenericMethods.fnwait(20);
		RefLogin.ClickCloseButton();
		fnWriteSteps("Pass", "Application Close Successfully");
		GenericMethods.fnEndTestCase();

	} 
	@Test 
	public void Validate_SalesInvoice_Creation_While_Selecting_BatchNo_Without_Customer() {
		GenericMethods.fnStartTestCase("Validate SalesInvoice Creation While Selecting BatchNo Without Customer");
		int rowindex = 60;
		String strBatchNoProduct =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 0);
		String Quantity =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 1);
		String SelectProduct =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 8);
		refOrderPage.BatchNo_Selection_for_SalesInvoice(SelectProduct,strBatchNoProduct,Quantity);
		boolean result =refOrderPage.Validate_BatchNO_Selected_or_Not();
		GenericMethods.fnwait(1);
		refOrderPage.click_On_Payment();
		refOrderPage.Click_On_Payment_Cash();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
	    Assert.assertTrue(result);
	    ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 7, vochure);
		fnWriteSteps("Pass", "SalesInvoice Is Successfully Created While Selecting BatchNo Without Customer");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void Validate_SalesInvoice_Creation_With_a_Product_Managed_by_Batch_Number_and_While_Selecting_BatchNo_With_Customer() {
		GenericMethods.fnStartTestCase("Validate SalesInvoice Creation With a Product Managed by Batch Number and While Selecting BatchNo With Customer");
		int rowindex = 61;
		String strBatchNoProduct =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 0);
		String Quantity =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 1);
		String strCustomer =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 2);
		String strAmount =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 4);
		String strCardNo =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 5);
		String strInstructions =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 6);
		String SelectProduct =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 8);
		refOrderPage.Select_Customer_Details(strCustomer);
		refOrderPage.BatchNo_Selection_for_SalesInvoice(SelectProduct,strBatchNoProduct,Quantity);
		boolean result =refOrderPage.Validate_BatchNO_Selected_or_Not();
		GenericMethods.fnwait(1);
		refOrderPage.click_On_Payment();
		GenericMethods.fnwait(2);
		refPurchaseInvoice.Due_Operation_With_Card_PaymentMode(strAmount, strCardNo);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		refPurchaseInvoice.click_Ok_Button();
		refOrderPage.send_Instructions(strInstructions);
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 7, vochure);
		fnWriteSteps("Pass", "SalesInvoice Is Successfully Created With a Product Managed by Batch Number and While Selecting BatchNo With Customer");
		GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void Validate_SalesInvoice_Creation_with_a_combination_of_Managed_by_Batch_No_and_not_Managed_by_Batch_No_products() {
		GenericMethods.fnStartTestCase("Validate SalesInvoice Creation with a combination of Managed by Batch No and not Managed by Batch No products");
		int rowindex = 62;
		String strBatchNoProduct =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 0);
		String Quantity =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 1);
		String strCustomer =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 2);
		String strProduct =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 3);
		String strAmount =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 4);
		String strCardNo =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 5);
		String strInstructions =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 6);
		String SelectProduct =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 8);
		refOrderPage.Select_Customer_Details(strCustomer);
		refOrderPage.enter_Product_Details(strProduct);
		GenericMethods.fnwait(1);
		refOrderPage.BatchNo_Selection_for_SalesInvoice(SelectProduct,strBatchNoProduct,Quantity);
		boolean result =refOrderPage.Validate_BatchNO_Selected_or_Not();
		GenericMethods.fnwait(1);
		refOrderPage.click_On_Payment();
		GenericMethods.fnwait(2);
		refPurchaseInvoice.Due_Operation_With_Card_PaymentMode(strAmount, strCardNo);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		refPurchaseInvoice.click_Ok_Button();
		refOrderPage.send_Instructions(strInstructions);
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
	    Assert.assertTrue(result);
	    ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 7, vochure);
		fnWriteSteps("Pass", "SalesInvoice Is Successfully Created With a combination of Managed by Batch No and not Managed by Batch No products");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void Validate_SalesInvoice_Creation_While_Selecting_BatchNo_Without_Customer_for_Return_Exchange_Equal_to_Exchange_Amount() {
		GenericMethods.fnStartTestCase("Validate SalesInvoice Creation While Selecting BatchNo Without Customer for Return Exchange Equal to Exchange Amount");
		int rowindex = 63;
		String strBatchNoProduct =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 0);
		String Quantity =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 1);
		String SelectProduct =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 8);
		refOrderPage.BatchNo_Selection_for_SalesInvoice(SelectProduct,strBatchNoProduct,Quantity);
		boolean result =refOrderPage.Validate_BatchNO_Selected_or_Not();
		GenericMethods.fnwait(1);
		refOrderPage.click_On_Payment();
		refOrderPage.Click_On_Payment_Cash();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
	    Assert.assertTrue(result);
	    ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 7, vochure);
		fnWriteSteps("Pass", "SalesInvoice Is Successfully Created While Selecting BatchNo Without Customer for Return Exchange Equal to Exchange Amount");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void Validate_SalesInvoice_Creation_While_Selecting_BatchNo_Without_Customer_for_Return_Exchange_Greater_than_Exchange_Amount() {
		GenericMethods.fnStartTestCase("Validate SalesInvoice Creation While Selecting BatchNo Without Customer for Return Exchange Greater than Exchange Amount");
		int rowindex = 64;
		String strBatchNoProduct =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 0);
		String Quantity =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 1);
		String SelectProduct =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 8);
		refOrderPage.BatchNo_Selection_for_SalesInvoice(SelectProduct,strBatchNoProduct,Quantity);
		boolean result =refOrderPage.Validate_BatchNO_Selected_or_Not();
		GenericMethods.fnwait(1);
		refOrderPage.click_On_Payment();
		refOrderPage.Click_On_Payment_Cash();
		refOrderPage.click_Finish_Button();
		String invoiceVochure = refOrderPage.get_Vochure_Page();
		String vochure = invoiceVochure.split(" ")[5];
	    Assert.assertTrue(result);
	    ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice", rowindex, 7, vochure);
		fnWriteSteps("Pass", "SalesInvoice Is Successfully Created While Selecting BatchNo Without Customer for Return Exchange Greater than Exchange Amount");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void Select_BatchNo_while_Modifying_Invoice_with_selecting_Customer() {
		GenericMethods.fnStartTestCase("Select BatchNo while Modifying Invoice with selecting Customer");
		int rowindex = 68;
		String strVochure =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", 61, 7);
		String strFieldValue =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 0);
		String SelectProduct =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 1);
		String strBatchNoProduct =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 2);
		String Quantity =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 3);
		refOrderPage.get_Invoice_Vochure(strVochure);
		refOrderPage.Sales_Product_Quantity_Modification(strFieldValue);
		refOrderPage.BatchNo_Selection_for_SalesInvoice(SelectProduct,strBatchNoProduct,Quantity);
		boolean result =refOrderPage.Validate_BatchNO_Selected_or_Not();
		GenericMethods.fnwait(1);
		refOrderPage.click_On_Payment();
		refOrderPage.Click_On_Payment_Cash();
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		refPurchaseInvoice.click_Ok_Button();
		Assert.assertTrue(result);
	    fnWriteSteps("Pass", "Successfully BatchNo selected while Modifying Invoice with selecting Customer");
		GenericMethods.fnEndTestCase();
		
		
     }
	@Test 
	public void Select_BatchNo_while_Modifying_Invoice_with_a_combination_of_Managed_by_BatchNo_and_not_managed_by_BatchNo_products() {
		GenericMethods.fnStartTestCase("Select BatchNo while Modifying Invoice with a combination of Managed by BatchNo and not managed by BatchNo products");
		int rowindex = 69;
		String strVochure =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", 62, 7);
		String strFieldValue =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 0);
		String SelectProduct =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 1);
		String strBatchNoProduct =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 2);
		String Quantity =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Invoice", rowindex, 3);
		refOrderPage.get_Invoice_Vochure(strVochure);
		refOrderPage.Sales_Product_Quantity_Modification(strFieldValue);
		refOrderPage.BatchNo_Selection_for_SalesInvoice(SelectProduct,strBatchNoProduct,Quantity);
		boolean result =refOrderPage.Validate_BatchNO_Selected_or_Not();
		GenericMethods.fnwait(1);
		refOrderPage.click_On_Payment();
		refOrderPage.Click_On_Payment_Cash();
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		refPurchaseInvoice.click_Ok_Button();
		Assert.assertTrue(result);
	    fnWriteSteps("Pass", "Successfully BatchNo selected while Modifying Invoice with a combination of Managed by BatchNo and not managed by BatchNo products");
		GenericMethods.fnEndTestCase();
		
		
     }
}
