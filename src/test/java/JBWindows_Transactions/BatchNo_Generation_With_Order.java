package JBWindows_Transactions;

import org.apache.log4j.xml.DOMConfigurator;
import org.sikuli.script.FindFailed;
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

public class BatchNo_Generation_With_Order extends BaseClass {
	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessgBox;
	SAL_DocumentHistory RefEstimationHistory;
	Trans_Order_Page refOrderPage;

	public BatchNo_Generation_With_Order() {
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
		GenericMethods.fnwait(18);
		RefLogin.ClickCloseButton();
	}

	@BeforeMethod
	public void setUp() {
		GenericMethods.fnwait(34);
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(5);
		RefDashboard.clickMenuBtn();
		RefMenu.OpenPage("order");

	}

	@AfterMethod
	public void tearDown() {
		GenericMethods.fnStartTestCase("tearDown");
		refOrderPage.click_On_DashBoard();
		GenericMethods.fnwait(2);
		RefDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		RefMessgBox.ExitApplication_Yes();
	}
	@Test 
	public void Validate_Order_Creation_with_a_product_Managed_by_Batch_Number_and_While_Selecting_BatchNo_With_Customer() {
		GenericMethods.fnStartTestCase("validate Sales Order Creation with a product Managed by Batch Number and While Selecting BatchNo With Customer");
		int rowindex=55;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Order", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 1);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 6);
		String strCustomer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 7);
		String salesOrderVochure = refOrderPage.Sales_Order_Creation_To_Convert_Invoice_While_Selecting_BatchNo(strSalesOrderType,Customer,strProduct,strCustomer,strInstructions);
		boolean result = refOrderPage.validate_Sales_Order_Creation(salesOrderVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3,salesOrderVochure);
		fnWriteSteps("Pass","Sales Order Is Successfully Created with a product Managed by Batch Number and While Selecting BatchNo With Customer");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void Select_BatchNo_while_converting_Order_to_Invoice_with_a_product_Managed_by_Batch_Number_and_WithSelecting_Customer() throws FindFailed {
		GenericMethods.fnStartTestCase("Select BatchNo while converting Order to Invoice with a product Managed by Batch Number and WithSelecting Customer");
		int rowindex=55;
		String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
		String Quantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order", rowindex,4);
		String ConvertionFor=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order", rowindex,8);
		refOrderPage.BatchNo_Selection_while_Order_To_Invoice_Convertion(strSalesOrder,ConvertionFor);
		refOrderPage.Select_BatchNo();
		refOrderPage.BatchNo_Selection(Quantity);
		refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_OK_Button();
		refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_Header_Button();
		refOrderPage.Click_On_Payment_Cash();
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		refOrderPage.click_Header_Button();
		boolean result=refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(strSalesOrder);
		Assert.assertTrue(result);
		fnWriteSteps("Pass","Successfully BatchNo selected while converting Order to Invoice with a product Managed by Batch Number and WithSelecting Customer");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void Validate_Order_Creation_with_a_combination_of_Managed_by_BatchNo_and_Not_Managed_by_BatchNo_products() {
		GenericMethods.fnStartTestCase("validate Order Creation with a combination of Managed by BatchNo and Not Managed by BatchNo products");
		int rowindex=56;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Order", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 1);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 2);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 5);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 6);
		String strCustomer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 7);
		refOrderPage.enter_Product_Details(strProduct1);
		String salesOrderVochure = refOrderPage.Sales_Order_Creation_To_Convert_Invoice_While_Selecting_BatchNo(strSalesOrderType,Customer,strProduct,strCustomer,strInstructions);
		boolean result = refOrderPage.validate_Sales_Order_Creation(salesOrderVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3,salesOrderVochure);
		fnWriteSteps("Pass","Sales Order Is Successfully Created with a combination of Managed by BatchNo and Not Managed by BatchNo products");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void Select_BatchNo_while_converting_Order_to_Invoice_with_a_combination_of_Managed_by_BatchNo_and_Not_Managed_by_BatchNo_products() throws FindFailed {
		GenericMethods.fnStartTestCase("Select BatchNo while converting Order to Invoice with a combination of Managed by BatchNo and Not Managed by BatchNo products");
		int rowindex=56;
		String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
		String Quantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order", rowindex,4);
		String ConvertionFor=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order", rowindex,8);
	    refOrderPage.BatchNo_Selection_while_Order_To_Invoice_Convertion(strSalesOrder,ConvertionFor);
		refOrderPage.Select_BatchNo();
		refOrderPage.BatchNo_Selection(Quantity);
		GenericMethods.fnwait(2);
		refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_OK_Button();
		refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_Header_Button();
		refOrderPage.Click_On_Payment_Cash();
		refOrderPage.click_Finish_Button();
		refOrderPage.click_Header_Button();
		boolean result=refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(strSalesOrder);
		Assert.assertTrue(result);
		fnWriteSteps("Pass","Successfully BatchNo selected while converting Order to Invoice with a combination of Managed by BatchNo and Not Managed by BatchNo products");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void Validate_Partial_Order_Creation_with_a_product_Managed_by_Batch_Number_and_While_Selecting_BatchNo_With_Customer() {
		GenericMethods.fnStartTestCase("validate Partial Order Creation with a product Managed by Batch Number and While Selecting BatchNo With Customer");
		int rowindex=57;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Order", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 1);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 2);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 6);
		String strCustomer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 7);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 5);
		refOrderPage.enter_Product_Details(strProduct1);
		String salesOrderVochure = refOrderPage.Sales_Order_Creation_To_Convert_Invoice_While_Selecting_BatchNo(strSalesOrderType,Customer,strProduct,strCustomer,strInstructions);
		boolean result = refOrderPage.validate_Sales_Order_Creation(salesOrderVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3,salesOrderVochure);
		fnWriteSteps("Pass","Partial Order Is Successfully Created with a product Managed by Batch Number and While Selecting BatchNo With Customer");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void Select_BatchNo_while_partially_converting_Order_to_Invoice_with_a_product_Managed_by_Batch_Number_and_With_Selecting_Customer() throws FindFailed {
		GenericMethods.fnStartTestCase("Select BatchNo while partially converting Order to Invoice with a product Managed by Batch Number and With Selecting Customer");
		int rowindex=57;
		String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
		String Quantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order", rowindex,4);
		String ConvertionFor=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order", rowindex,8);
		refOrderPage.BatchNo_Selection_while_Order_To_Invoice_Convertion(strSalesOrder,ConvertionFor);
		refOrderPage.Select_BatchNo();
		refOrderPage.BatchNo_Selection(Quantity);
		refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_OK_Button();
		refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_Header_Button();
		refOrderPage.Click_On_Payment_Cash();
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		refOrderPage.click_Header_Button();
		boolean result=refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(strSalesOrder);
		Assert.assertTrue(result);
		fnWriteSteps("Pass","Successfully BatchNo selected while partially converting Order to Invoice with a product Managed by Batch Number and With Selecting Customer");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void Validate_Partial_Order_Creation_with_a_combination_of_Managed_by_BatchNo_and_Not_Managed_by_BatchNo_products() {
		GenericMethods.fnStartTestCase("validate Partial Order Creation with a combination of Managed by BatchNo and Not Managed by BatchNo products");
		int rowindex=58;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Order", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 1);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 2);
		String strProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 5);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 6);
		String strCustomer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 7);
		String strProduct2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 9);
		refOrderPage.enter_Product_Details(strProduct1);
		refOrderPage.enter_Product_Details(strProduct2);
		String salesOrderVochure = refOrderPage.Sales_Order_Creation_To_Convert_Invoice_While_Selecting_BatchNo(strSalesOrderType,Customer,strProduct,strCustomer,strInstructions);
		boolean result = refOrderPage.validate_Sales_Order_Creation(salesOrderVochure);
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3,salesOrderVochure);
		fnWriteSteps("Pass","Partial Order Is Successfully Created with a combination of Managed by BatchNo and Not Managed by BatchNo products");
		GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void Select_BatchNo_while_Partially_converting_Order_to_Invoice_with_a_combination_of_Managed_by_BatchNo_and_Not_Managed_by_BatchNo_products() throws FindFailed {
		GenericMethods.fnStartTestCase("Select BatchNo while Partially converting Order to Invoice with a combination of Managed by BatchNo and Not Managed by BatchNo products");
		int rowindex=58;
		String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
		String Quantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order", rowindex,4);
		String ConvertionFor=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order", rowindex,8);
	    refOrderPage.BatchNo_Selection_while_Order_To_Invoice_Convertion(strSalesOrder,ConvertionFor);
		refOrderPage.Select_BatchNo();
		refOrderPage.BatchNo_Selection(Quantity);
		GenericMethods.fnwait(2);
		refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_OK_Button();
		refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_Header_Button();
		refOrderPage.Click_On_Payment_Cash();
		refOrderPage.click_Finish_Button();
		refOrderPage.click_Header_Button();
		boolean result=refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(strSalesOrder);
		Assert.assertTrue(result);
		fnWriteSteps("Pass","Successfully BatchNo selected while Partially converting Order to Invoice with a combination of Managed by BatchNo and Not Managed by BatchNo products");
		GenericMethods.fnEndTestCase();
		
	}
}


