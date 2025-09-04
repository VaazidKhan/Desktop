package JBWindows_Transactions;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
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


public class Trans_Return_Unit_Test extends BaseClass{
    Logger log = Logger.getLogger(Trans_Return_Unit_Test.class);

	
	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessgBox;
	SAL_DocumentHistory RefEstimationHistory;
	Trans_Order_Page refOrderPage;
	
	
	public Trans_Return_Unit_Test() {
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
		GenericMethods.fnwait(2);
		RefLogin.ClickCloseButton();
	}

	@BeforeMethod
	public void setUp() {
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

	    refOrderPage.click_On_DashBoard();
		GenericMethods.fnwait(2);
		RefDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		RefMessgBox.ExitApplication_Yes();
		GenericMethods.fnwait(1);
		
	}
	
	@Test 
	public void validate_Return_Invoice_Creation_with_ReturnAllowedProduct_Test() {
		GenericMethods.fnStartTestCase("validate_Return_Invoice_Creation_with_ReturnAllowedProductTest");
		log.info("******Return Invoice Creation*******");
		int rowindex=2;
		String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", 8, 22);
		String returnType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Return", rowindex, 1);
		String PaymentType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Return", rowindex, 2);
		GenericMethods.fnwait(2);
		refOrderPage.click_Return_Button();
		GenericMethods.fnwait(2);
		refOrderPage.get_Invoice_Vochure(strVochure);
		refOrderPage.return_Type(returnType);
		GenericMethods.fnwait(2);
		boolean result=refOrderPage.return_Payment_Details(PaymentType);
		Assert.assertTrue(result);
		log.info("********Return Invoice Creation********");
		fnWriteSteps("Pass", "Successfully Created Return Invoice");
		GenericMethods.fnEndTestCase();
		
		
	}
	@Test 
	public void validate_Return_Invoice_Creation_Both_Return_NonReturn_Test() {
		GenericMethods.fnStartTestCase("validate_Return_Invoice_Creation_Both_Return_NonReturn_Test");
		log.info("******Return Invoice Creation*******");
		int rowindex=3;
		String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", 5,22);
		String returnType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Return", rowindex, 1);
		String PaymentType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Return", rowindex, 2);
		GenericMethods.fnwait(2);
		refOrderPage.click_Return_Button();
		GenericMethods.fnwait(2);
		refOrderPage.get_Invoice_Vochure(strVochure);
		refOrderPage.return_Type(returnType);
		GenericMethods.fnwait(2);
		boolean result=refOrderPage.return_Payment_Details(PaymentType);
		Assert.assertTrue(result);
		log.info("********Return Invoice Creation********");
		fnWriteSteps("Pass", "Successfully Created Return Invoice");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void valoidate_Return_Creation_HomeDelievery_Test() {
		GenericMethods.fnStartTestCase("valoidate_Return_Creation_HomeDelievery_Test");
		log.info("******Return Invoice Creation*******");
		int rowindex=4;
		String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order", 35, 2);
		String returnType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Return", rowindex, 1);
		String PaymentType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Return", rowindex, 2);
		GenericMethods.fnwait(2);
		refOrderPage.click_Return_Button();
		GenericMethods.fnwait(2);
		refOrderPage.get_Invoice_Vochure(strVochure);
		refOrderPage.return_Type(returnType);
		GenericMethods.fnwait(2);
		boolean result=refOrderPage.return_Payment_Details(PaymentType);
		Assert.assertTrue(result);
		log.info("********Return Invoice Creation********");
		fnWriteSteps("Pass", "Successfully Created Return Invoice");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Return_Creation_Non_Return_Product() {
		GenericMethods.fnStartTestCase("validate_Return_Creation_Non_Return_Product");
		log.info("******Validate Return Creation With Non Return Product********");
		String InvoiceVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", 6,22);
		GenericMethods.fnwait(2);
		refOrderPage.click_Return_Button();
		GenericMethods.fnwait(2);
	boolean result=	refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(InvoiceVochure);
	Assert.assertTrue(result);
	log.info("******Validated Return Invoice Creation Wit7h Non Return Product*****");
	fnWriteSteps("Pass", "Validated Return Vochure Creation By Selecting Non Return Product");
	GenericMethods.fnEndTestCase();
	
	}
	@Test 
	public void validate_Partial_Return_Vochure_Creation_Test() throws FindFailed {
		GenericMethods.fnStartTestCase("validate_Partial_Return_Vochure_Creation_Test");
		log.info("******Return Invoice Creation*******");
		int rowindex=5;
		String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Invoice", 5, 22);
		String returnType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Return", rowindex, 1);
		String PaymentType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Return", rowindex, 2);
		GenericMethods.fnwait(2);
		refOrderPage.click_Return_Button();
		GenericMethods.fnwait(2);
		refOrderPage.get_Invoice_Vochure(strVochure);
		GenericMethods.fnwait(2);
		Screen screen=new Screen();
		Pattern pattern=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Delete1.PNG");
		screen.click(pattern);
		GenericMethods.fnwait(2);
		refOrderPage.return_Type(returnType);
		GenericMethods.fnwait(2);
		boolean result=refOrderPage.return_Payment_Details(PaymentType);
		Assert.assertTrue(result);
		log.info("********Return Invoice Creation********");
		fnWriteSteps("Pass", "Successfully Created Return Invoice");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Exchange_Invoice_Creation_Test() {
		GenericMethods.fnStartTestCase("validate_Exchange_Invoice_Creation_Test");
		log.info("*******Exchange Invoice Creation*****");
		int rowindex=28;
		boolean result=false;
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
		String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Return", 6, 0);
		String returnType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Return", 6, 1);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Return", 6, 2);
		GenericMethods.fnwait(2);
		refOrderPage.click_Return_Button();
		GenericMethods.fnwait(2);
		refOrderPage.get_Invoice_Vochure(strVochure);
		GenericMethods.fnwait(2);
		refOrderPage.return_Type(returnType);
		GenericMethods.fnwait(2);
		refOrderPage.click_OK_Button();
		GenericMethods.fnwait(3);
		refOrderPage.enter_Product_Details(strProduct);
		refOrderPage.click_Payment_Button();
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2, BankCheck, ChequeCheck);
		refOrderPage.click_Finish_Button();
		String exchangeVochure=refOrderPage.get_Vochure_Page();
		String vochure = exchangeVochure.split(" ")[5];
		if(vochure!=null || vochure!="") {
			result=true;
		}
		Assert.assertTrue(result);
		log.info("*****Exchange Invoice Creation********");
		fnWriteSteps("Pass","Exchange Creation Successfull");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Exchange_Invoice_Creation_Amount_Greater_Test() {
		GenericMethods.fnStartTestCase("validate_Exchange_Invoice_Creation_Amount_Greater_Test");
		log.info("*******Exchange Invoice Creation*****");
		int rowindex=28;
		boolean result=false;
		String Payment = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 6);
		String strAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 7);
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
		String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Return", 7, 0);
		String returnType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Return", 7, 1);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Return", 7, 2);
		GenericMethods.fnwait(2);
		refOrderPage.click_Return_Button();
		GenericMethods.fnwait(2);
		refOrderPage.get_Invoice_Vochure(strVochure);
		GenericMethods.fnwait(2);
		refOrderPage.return_Type(returnType);
		GenericMethods.fnwait(2);
		refOrderPage.click_OK_Button();
		GenericMethods.fnwait(3);
		refOrderPage.enter_Product_Details(strProduct);
		refOrderPage.click_Payment_Button();
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2, BankCheck, ChequeCheck);
		refOrderPage.click_Finish_Button();
		refOrderPage.click_Header_Button();
		GenericMethods.fnwait(3);
		refOrderPage.send_Instructions(strInstructions);
		GenericMethods.fnwait(3);
		String exchangeVochure=refOrderPage.get_Vochure_Page();
		String vochure = exchangeVochure.split(" ")[5];
		if(vochure!=null || vochure!="") {
			result=true;
		}
		Assert.assertTrue(result);
		log.info("*****Exchange Invoice Creation********");
		fnWriteSteps("Pass","Exchange Creation Successfull");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Return_Deletion_Fully_Return_Test() {
		GenericMethods.fnStartTestCase("validate_Return_Deletion_Fully_Return_Test");
		log.info("********Return Vochure Deletion*******");
		int rowindex=13;
		String strVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Return",
				rowindex, 0);
		String strRemarks = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Return",
				rowindex, 1);
		String internet ="NULL";
		refOrderPage.click_On_DashBoard();
		GenericMethods.fnwait(2);
		RefMenu.OpenPage("return history");
		GenericMethods.fnwait(2);
	boolean result=	RefEstimationHistory.document_History_Deletion(strVochure, strRemarks,internet);
		GenericMethods.fnwait(2);
		RefEstimationHistory.click_On_Close_Button();
		GenericMethods.fnwait(2);
		RefMenu.OpenPage("invoicing");
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Return Vochure Successfully Deleted");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Return_Deletion_Home_Delievery_Test() {
		GenericMethods.fnStartTestCase("validate_Return_Deletion_Home_Delievery_Test");
		log.info("********Return Vochure Deletion*******");
		int rowindex=14;
		String strVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Return",
				rowindex, 0);
		String strRemarks = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Return",
				rowindex, 1);
		String internet ="NULL";
		refOrderPage.click_On_DashBoard();
		GenericMethods.fnwait(2);
		RefMenu.OpenPage("return history");
		GenericMethods.fnwait(2);
	boolean result=	RefEstimationHistory.document_History_Deletion(strVochure, strRemarks,internet);
		GenericMethods.fnwait(2);
		RefEstimationHistory.click_On_Close_Button();
		GenericMethods.fnwait(2);
		RefMenu.OpenPage("invoicing");
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Return Vochure Successfully Deleted");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Return_Exchange_Invoice_Deletion_Test() {
		GenericMethods.fnStartTestCase("validate_Return_Exchange_Invoice_Deletion_Test");
		log.info("********EXchange Invoice Deletion********");
		int rowindex=15;
		String InvoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Return",
				rowindex, 2);
		String strRemarks = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Return",
				rowindex, 1);
		String exchangeVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Return",
				rowindex, 0);
		String internet ="NULL";
		refOrderPage.click_On_DashBoard();
		GenericMethods.fnwait(2);
		RefMenu.OpenPage("invoice history");
		GenericMethods.fnwait(2);
		RefEstimationHistory.document_History_Deletion(InvoiceVochure, strRemarks,internet);
		GenericMethods.fnwait(2);
		RefEstimationHistory.click_On_Close_Button();
		GenericMethods.fnwait(2);
		RefMenu.OpenPage("return history");
		GenericMethods.fnwait(2);
		boolean result=RefEstimationHistory.document_History_Deletion(exchangeVochure, strRemarks,internet);
		GenericMethods.fnwait(2);
		RefEstimationHistory.click_On_Close_Button();
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Exchange Vochure Successfully Deleted");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Exchange_Invoice_Home_Delievery_Deletion_Test() {
		GenericMethods.fnStartTestCase("validate_Exchange_Invoice_Deletion_Test");
		log.info("********EXchange Invoice Deletion********");
		int rowindex=16;
		String InvoiceVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Return",
				rowindex, 0);
		String strRemarks = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Return",
				rowindex, 1);
		String exchangeVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Return",
				rowindex, 2);
		String internet ="NULL";
		refOrderPage.click_On_DashBoard();
		GenericMethods.fnwait(2);
		RefMenu.OpenPage("invoice history");
		GenericMethods.fnwait(2);
		RefEstimationHistory.document_History_Deletion(InvoiceVochure, strRemarks,internet);
		GenericMethods.fnwait(2);
		RefEstimationHistory.click_On_Close_Button();
		GenericMethods.fnwait(2);
		RefMenu.OpenPage("return history");
		GenericMethods.fnwait(2);
		boolean result=RefEstimationHistory.document_History_Deletion(exchangeVochure, strRemarks,internet);
		GenericMethods.fnwait(2);
		RefEstimationHistory.click_On_Close_Button();
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Exchange Vochure Successfully Deleted");
		GenericMethods.fnEndTestCase();
	}

}
