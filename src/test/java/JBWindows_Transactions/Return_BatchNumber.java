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
import JBWindows.PUR.PUR_PurchaseInvoice;
import JBWindows.SAL.SAL_DocumentHistory;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows.Transactions.Trans_Order_Page;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class Return_BatchNumber extends BaseClass{
	
	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessgBox;
	SAL_DocumentHistory RefEstimationHistory;
	Trans_Order_Page refOrderPage;
	 PUR_PurchaseInvoice refPurchaseInvoice;
	
	public Return_BatchNumber() {
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
		refPurchaseInvoice = new PUR_PurchaseInvoice();
	}

	@AfterClass
	public void terminatingBrowser() {
		GenericMethods.fnwait(2);
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
		GenericMethods.fnwait(26);
		RefLogin.ClickCloseButton();
		fnWriteSteps("Pass", "Application Close Successfully");
		GenericMethods.fnEndTestCase();
		
	} 
	@Test 
	public void Select_BatchNo_with_EqualQuantity_while_creating_Return_Refund_Invoice_with_the_product_Managed_by_BatchNo() throws FindFailed {
		GenericMethods.fnStartTestCase("Select BatchNo with EqualQuantity while creating Return Refund Invoice with the product Managed by BatchNo");
		int rowindex=20;
		String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", 61, 4);
		String returnType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 0);
		String Quantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 1);
		String RefundDisc=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 2);
		String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 3);
		GenericMethods.fnwait(2);
		refOrderPage.click_Return_Button();
		GenericMethods.fnwait(2);
		refOrderPage.get_Invoice_Vochure(strVochure);
		RefEstimationHistory.Product_Quantity_Modification(strFieldValue);
		refOrderPage.BatchNo_Selection(Quantity);
		boolean result = refOrderPage.Validate_BatchNO_Selected_or_Not();
		refOrderPage.click_OK_Button();
		refOrderPage.return_Type(returnType);
		RefEstimationHistory.Enter_DiscountRecovered_Amount(RefundDisc);
		RefEstimationHistory.Click_On_Cash_paymentMode();
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Successfully EqualQuantity of BatchNO Selected while creating Return Refund Invoice with the product Managed by BatchNo");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void Select_BatchNo_with_LessQuantity_while_creating_Return_Refund_Invoice_with_the_product_Managed_by_BatchNo() throws FindFailed {
		GenericMethods.fnStartTestCase("Select BatchNo with LessQuantity while creating Return Refund Invoice with the product Managed by BatchNo");
		int rowindex=21;
		String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", 60, 4);
		String Quantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 1);
		String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 3);
		GenericMethods.fnwait(2);
		refOrderPage.click_Return_Button();
		GenericMethods.fnwait(2);
		refOrderPage.get_Invoice_Vochure(strVochure);
		GenericMethods.fnwait(2);
		RefEstimationHistory.Product_Quantity_Modification(strFieldValue);
		refOrderPage.BatchNo_Selection(Quantity);
		boolean result = refOrderPage.Validation_of_BatchNo_with_LessQuantity();
		RefEstimationHistory.click_On_Close_Button();
		refOrderPage.click_On_Cancel_Button();
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Successfully LessQuantity of BatchNO Not Selected while creating Return Refund Invoice with the product Managed by BatchNo");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void Select_BatchNo_while_creating_Return_Exchange_Invoice_with_the_product_Managed_by_BatchNo_and_Less_than_Exchange_Amount() throws FindFailed {
		GenericMethods.fnStartTestCase("Select BatchNo while creating Return Exchange Invoice with the product Managed by BatchNo and Less than Exchange Amount");
		int rowindex=22;
		String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", 60, 4);
		String returnType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 0);
		String Quantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 1);
		String ExchangeDisc=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 2);
		String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 3);
		String strBatchNoProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 4);
		String SelectedQuantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 5);
		String SelectProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 6);
		GenericMethods.fnwait(2);
		refOrderPage.click_Return_Button();
		GenericMethods.fnwait(2);
		refOrderPage.get_Invoice_Vochure(strVochure);
		RefEstimationHistory.Product_Quantity_Modification(strFieldValue);
	    refOrderPage.BatchNo_Selection(Quantity);
	    refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_OK_Button();
		refOrderPage.return_Type(returnType);
		RefEstimationHistory.Enter_DiscountRecovered_Amount(ExchangeDisc);
		refOrderPage.click_OK_Button();
		refOrderPage.BatchNo_Selection_for_SalesInvoice(SelectProduct,strBatchNoProduct,SelectedQuantity);
		refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_Payment_Button();
		boolean result = refOrderPage.Validate_ExchangeAmount_Lessthan_ExchangeLimit_allowed_or_Not();
		refOrderPage.click_On_Cancel_Button();
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Successfully BatchNO Selected while creating Return Exchange Invoice with the product Managed by BatchNo but not allowed Less than Exchange Amount");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void Select_BatchNo_while_creating_Return_Exchange_Invoice_with_the_product_Managed_by_BatchNo_and_Equal_to_Exchange_Amount() throws FindFailed {
		GenericMethods.fnStartTestCase("Select BatchNo while creating Return Exchange Invoice with the product Managed by BatchNo and Equal to Exchange Amount");
		boolean result=false;
		int rowindex=23;
		String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", 63, 4);
		String returnType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 0);
		String Quantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 1);
		String ExchangeDisc=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 2);
		String strBatchNoProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 4);
		String SelectedQuantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 5);
		String SelectProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 6);
		GenericMethods.fnwait(2);
		refOrderPage.click_Return_Button();
		GenericMethods.fnwait(2);
		refOrderPage.get_Invoice_Vochure(strVochure);
		refOrderPage.return_Type(returnType);
		GenericMethods.fnwait(2);
		refOrderPage.Select_BatchNo();
		refOrderPage.BatchNo_Selection(Quantity);
		refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_OK_Button();
		refOrderPage.click_On_SAVE_Button();
		RefEstimationHistory.Enter_DiscountRecovered_Amount(ExchangeDisc);
		refOrderPage.click_OK_Button();
		refOrderPage.BatchNo_Selection_for_SalesInvoice(SelectProduct,strBatchNoProduct,SelectedQuantity);
		refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_Payment_Button();
		refOrderPage.click_Finish_Button();
		GenericMethods.fnwait(2);
		String exchangeVochure=refOrderPage.get_Vochure_Page();
		String vochure = exchangeVochure.split(" ")[5];
		if(vochure!=null || vochure!="") {
			result=true;
		}
	   Assert.assertTrue(result);
		fnWriteSteps("Pass", "Successfully BatchNO Selected while creating Return Exchange Invoice with the product Managed by BatchNo and Equal to Exchange Amount");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void Select_BatchNo_while_creating_Return_Exchange_Invoice_with_the_product_Managed_by_BatchNo_and_Greater_than_Exchange_Amount() throws FindFailed {
		GenericMethods.fnStartTestCase("Select BatchNo while creating Return Exchange Invoice with the product Managed by BatchNo and Greater than Exchange Amount");
		boolean result=false;
		int rowindex=24;
		String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", 64, 4);
		String returnType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 0);
		String Quantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 1);
		String ExchangeDisc=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 2);
		String strBatchNoProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 4);
		String SelectedQuantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 5);
		String SelectProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 6);
		GenericMethods.fnwait(2);
		refOrderPage.click_Return_Button();
		GenericMethods.fnwait(2);
		refOrderPage.get_Invoice_Vochure(strVochure);
		refOrderPage.return_Type(returnType);
		GenericMethods.fnwait(2);
		refOrderPage.Select_BatchNo();
		refOrderPage.BatchNo_Selection(Quantity);
		refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_OK_Button();
		refOrderPage.click_On_SAVE_Button();
		RefEstimationHistory.Enter_DiscountRecovered_Amount(ExchangeDisc);
		refOrderPage.click_OK_Button();
		refOrderPage.BatchNo_Selection_for_SalesInvoice(SelectProduct,strBatchNoProduct,SelectedQuantity);
		refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_Payment_Button();
		refOrderPage.Click_On_Payment_Cash();
		refOrderPage.click_Finish_Button();
		GenericMethods.fnwait(2);
		String exchangeVochure=refOrderPage.get_Vochure_Page();
		String vochure = exchangeVochure.split(" ")[5];
		if(vochure!=null || vochure!="") {
			result=true;
		}
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Successfully BatchNO Selected while creating Return Exchange Invoice with the product Managed by BatchNo and Greater than Exchange Amount");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void Select_BatchNo_while_creating_Return_Exchange_Invoice_partially() throws FindFailed {
		GenericMethods.fnStartTestCase("Select BatchNo while creating Return Exchange Invoice partially");
		boolean result=false;
		int rowindex=25;
		String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", 62, 4);
		String returnType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 0);
		String Quantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 1);
		String ExchangeDisc=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 2);
		String strBatchNoProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 4);
		String SelectedQuantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 5);
		String SelectProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Return", rowindex, 6);
		GenericMethods.fnwait(2);
		refOrderPage.click_Return_Button();
		GenericMethods.fnwait(2);
		refOrderPage.get_Invoice_Vochure(strVochure);
		refOrderPage.return_Type(returnType);
		GenericMethods.fnwait(2);
		refOrderPage.Select_BatchNo();
		refOrderPage.BatchNo_Selection(Quantity);
		refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_OK_Button();
		refOrderPage.click_On_SAVE_Button();
		RefEstimationHistory.Enter_DiscountRecovered_Amount(ExchangeDisc);
		refOrderPage.click_OK_Button();
		refOrderPage.BatchNo_Selection_for_SalesInvoice(SelectProduct,strBatchNoProduct,SelectedQuantity);
		refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_Payment_Button();
		refOrderPage.click_Finish_Button();
		GenericMethods.fnwait(2);
		String exchangeVochure=refOrderPage.get_Vochure_Page();
		String vochure = exchangeVochure.split(" ")[5];
		if(vochure!=null || vochure!="") {
			result=true;
		}
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Successfully BatchNO Selected while creating Return Exchange Invoice partially");
		GenericMethods.fnEndTestCase();
		
		
	}
	
	
	

	}

