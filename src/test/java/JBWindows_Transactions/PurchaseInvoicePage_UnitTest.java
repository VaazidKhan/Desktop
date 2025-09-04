package JBWindows_Transactions;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.FRM.FRM_Payment;
import JBWindows.FRM.FRM_PaymentNotes;
import JBWindows.PUR.PUR_AddPuchaseInvoice;
import JBWindows.PUR.PUR_PurchaseInvoice;
import JBWindows.SAL.SAL_DocumentHistory;
import JBWindows.SAL.SAL_PointOfSales;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows.Transactions.Trans_Order_Page;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;


public class PurchaseInvoicePage_UnitTest extends BaseClass {

	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessgBox;
	PUR_PurchaseInvoice RefPurchaseInvoice;
	PUR_AddPuchaseInvoice RefAddPuchaseInvoice;
	SAL_PointOfSales RefPurchaseInvoiceScreen;
	FRM_Payment RefPaymentWindow;
	FRM_PaymentNotes RefPaymentDenominationWindow;
	SAL_DocumentHistory RefEstimationHistory;
	Trans_Order_Page refOrderPage;
	PUR_PurchaseInvoice refPurPurchaseInvoice;
	
    Logger log = Logger.getLogger(PurchaseInvoicePage_UnitTest.class);


	public PurchaseInvoicePage_UnitTest() {
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
		refPurPurchaseInvoice=new PUR_PurchaseInvoice();
	}

	@AfterClass
	public void terminatingBrowser() {
		GenericMethods.fnwait(2);
		RefLogin.ClickCloseButton();
	}

	@BeforeMethod
	public void setUp() {
		GenericMethods.fnwait(10);
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(9);
		RefDashboard.clickMenuBtn();
		RefMenu.OpenPage("purchase invoices");

	}

	@AfterMethod
	public void tearDown() {

	//	refOrderPage.click_On_DashBoard();
		GenericMethods.fnwait(2);
		RefDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		RefMessgBox.ExitApplication_Yes();
		GenericMethods.fnwait(10);

	}

	@Test 
	public void validate_Purchase_Invoice_Creation_Hold_Without_Reference_Invoice_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Creation_Test");
		log.info("*******Purchase Invoice Creatio With Hold Payment****");
		int rowindex = 1;
		String FieldType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strPurchaseInvoiceDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strReferenceNumber=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String strReveivingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String SaveType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.purchase_Invoice_Creation(FieldType, strPurchaseInvoiceDate, strSupplier, strReferenceNumber, strReveivingDate, strProduct, SaveType);
	String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		String strValidation="Your invoice number is";
		boolean result=refPurPurchaseInvoice.get_Purchase_Invoice_Vochure(strValidation.trim());
		RefEstimationHistory.click_On_Close_Button();
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 25, purchaseInvoice);
		Assert.assertTrue(result);
		log.info("*******Purchase Invoice Is Created Successfully******");
		GenericMethods.fnEndTestCase();
		}
	
	@Test 
	public void validate_Purchase_Invoice_Creation_With_RefernceInvoice_Cash_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Creation_With_RefernceInvoice_Cash_Test");
		log.info("Purchase Invoice Creation By Cash Payment");
		int rowindex = 2;
		String FieldType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strPurchaseInvoiceDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strReferenceNumber=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String strReveivingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String SaveType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String BankCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 23);
		String ChequeCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 24);
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.purchase_Invoice_Creation(FieldType, strPurchaseInvoiceDate, strSupplier, strReferenceNumber, strReveivingDate, strProduct, SaveType);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		String strValidation="Your invoice number is";
		boolean result=refPurPurchaseInvoice.get_Purchase_Invoice_Vochure(strValidation.trim());
		RefEstimationHistory.click_On_Close_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 25, purchaseInvoice);
		log.info("*******Purchase Invoice Is Created Successfully With Cash Payment******");
		GenericMethods.fnEndTestCase();	
	}
	//Failed Test Case
	@Test 
	public void validate_Purchase_Invoice_Creation_Only_Purchase_Item_From_Dashboard_Full_Due_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Creation_Only_Purchase_Item_From_Dashboard_Full_Due_Test");
		log.info("Purchase Invoice Creation With Purchase Item Only From Dashboard");
		int rowindex = 3;
		String FieldType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strPurchaseInvoiceDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strReferenceNumber=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String strReveivingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String SaveType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String BankCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 23);
		String ChequeCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 24);
		RefEstimationHistory.click_On_Close_Button();
		RefDashboard.click_Purchase_Page_Button();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.purchase_Invoice_Creation(FieldType, strPurchaseInvoiceDate, strSupplier, strReferenceNumber, strReveivingDate, strProduct, SaveType);
	
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		refPurPurchaseInvoice.click_On_Header();
		refPurPurchaseInvoice.click_Ok_Button();
		refOrderPage.send_Instructions(strInstructions);
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		String strValidation="Your invoice number is";
		boolean result=refPurPurchaseInvoice.get_Purchase_Invoice_Vochure(strValidation.trim());
		GenericMethods.fnwait(5);
		RefEstimationHistory.click_On_Close_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 25, purchaseInvoice);
		log.info("*******Purchase Invoice Is Successfully Created With Purchase Only Item From Dashboard");
		fnWriteSteps("Pass", "Purchase Invoice Is Successfully Created");
		GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void validate_Purchase_Creation_Partial_Due_Card_Product_Card_Test() throws FindFailed {
		GenericMethods.fnStartTestCase("validate_Purchase_Creation_Partial_Due_Card_Product_Card_Test");
		log.info("*******Purchase Invoice Creation With Card Payment With Partial Due******");
		int rowindex = 4;
		String FieldType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strPurchaseInvoiceDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strReferenceNumber=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String strReveivingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String SaveType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String BankCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 23);
		String ChequeCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 24);
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.purchase_Invoice_Creation(FieldType, strPurchaseInvoiceDate, strSupplier, strReferenceNumber, strReveivingDate, strProduct, SaveType);
		
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		refPurPurchaseInvoice.click_On_Header();
		refPurPurchaseInvoice.click_Ok_Button();
		refOrderPage.send_Instructions(strInstructions);
		
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		String strValidation="Your invoice number is";
		boolean result=refPurPurchaseInvoice.get_Purchase_Invoice_Vochure(strValidation.trim());
		GenericMethods.fnwait(2);
		RefEstimationHistory.click_On_Close_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 25, purchaseInvoice);
		log.info("*********Purchase Invoice Is Successfully Created********");
		fnWriteSteps("Pass", "Purchase Invoice is Successfully Created");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Purchase_Invoice_Creation_Past_Date_Paytm_Payment_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Creation_Past_Date_Paytm_Payment_Test");
		log.info("******Purchase Invoice Creation With Past Purchase Invoice Date With Paytm Payment************");
		int rowindex = 5;
		String FieldType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strPurchaseInvoiceDate=GenericMethods.getPropertyValue("PurchaseDate");//ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strReferenceNumber=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String strReveivingDate= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String SaveType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String BankCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 23);
		String ChequeCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 24);
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.purchase_Invoice_Creation(FieldType, strPurchaseInvoiceDate, strSupplier, strReferenceNumber, strReveivingDate, strProduct, SaveType);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		String strValidation="Your invoice number is";
		boolean result=refPurPurchaseInvoice.get_Purchase_Invoice_Vochure(strValidation.trim());
		RefEstimationHistory.click_On_Close_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 25, purchaseInvoice);
		log.info("*****Purchase Invoice Is Successfully Created*****");
		fnWriteSteps("Pass", "Purchase Invoice Is Successfully Created");
		GenericMethods.fnEndTestCase();	
	}
	@Test 
	public void validate_Purchase_Invoice_Creation_Wallet_Payment_Mobikwik_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Creation_Wallet_Payment_Mobikwik_Test");
		log.info("*******Purchase Invoice Creation With Wallet Payment***********");
		int rowindex = 6;
		String FieldType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strPurchaseInvoiceDate=GenericMethods.getPropertyValue("PurchaseDate"); //ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strReferenceNumber=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String strReveivingDate=GenericMethods.getPropertyValue("PurchaseDate"); //ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String SaveType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String BankCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 23);
		String ChequeCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 24);
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.purchase_Invoice_Creation(FieldType, strPurchaseInvoiceDate, strSupplier, strReferenceNumber, strReveivingDate, strProduct, SaveType);
		
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		/*refPurPurchaseInvoice.click_On_Header();
		refPurPurchaseInvoice.click_Ok_Button();
		refOrderPage.send_Instructions(strInstructions);*/
		String strValidation="Your invoice number is";
		boolean result=refPurPurchaseInvoice.get_Purchase_Invoice_Vochure(strValidation.trim());
		GenericMethods.fnwait(3);
		RefEstimationHistory.click_On_Close_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 25, purchaseInvoice);
		log.info("*****Purchase Invoice Is Successfully Created*****");
		fnWriteSteps("Pass", "Purchase Invoice Is Successfully Created");
		GenericMethods.fnEndTestCase();	
	}
	@Test 
	public void validate_Purchase_Invoice_Creation_Wallet_Freecharge_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Creation_Wallet_Freecharge_Test");
		log.info("******Purchase Invoice Creation With Full Payment Freecharge******");
		int rowindex = 7;
		String FieldType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strPurchaseInvoiceDate=GenericMethods.getPropertyValue("PurchaseDate"); //ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strReferenceNumber=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String strReveivingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String SaveType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String BankCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 23);
		String ChequeCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 24);
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.purchase_Invoice_Creation(FieldType, strPurchaseInvoiceDate, strSupplier, strReferenceNumber, strReveivingDate, strProduct, SaveType);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		String strValidation="Your invoice number is";
		boolean result=refPurPurchaseInvoice.get_Purchase_Invoice_Vochure(strValidation.trim());
		GenericMethods.fnwait(3);
		RefEstimationHistory.click_On_Close_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 25, purchaseInvoice);
		log.info("*****Purchase Invoice Is Successfully Created*****");
		fnWriteSteps("Pass", "Purchase Invoice Is Successfully Created");
		GenericMethods.fnEndTestCase();	
	}
	@Test 
	public void validate_Purchase_Invoice_Creation_Wallet_Airtel_Money_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Creation_Wallet_Airtel_Money_Test");
		log.info("*****Purchase Invoice Creation ");
		int rowindex = 8;
		String FieldType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strPurchaseInvoiceDate=GenericMethods.getPropertyValue("PurchaseDate"); //ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strReferenceNumber=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String strReveivingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String SaveType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String BankCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 23);
		String ChequeCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 24);
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.purchase_Invoice_Creation(FieldType, strPurchaseInvoiceDate, strSupplier, strReferenceNumber, strReveivingDate, strProduct, SaveType);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		String strValidation="Your invoice number is";
		boolean result=refPurPurchaseInvoice.get_Purchase_Invoice_Vochure(strValidation.trim());
		GenericMethods.fnwait(3);
		RefEstimationHistory.click_On_Close_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 25, purchaseInvoice);
		log.info("*****Purchase Invoice Is Successfully Created*****");
		fnWriteSteps("Pass", "Purchase Invoice Is Successfully Created");
		GenericMethods.fnEndTestCase();	
	}
	@Test 
	public void validate_Purchase_invoice_Creation_Wallet_Ola_Money_Test(){
		GenericMethods.fnStartTestCase("validate_Purchase_invoice_Creation_Wallet_Test");
		log.info("******Purchase Invoice Creation With Wallet Payment Ola Money");
		int rowindex = 9;
		String FieldType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strPurchaseInvoiceDate=GenericMethods.getPropertyValue("PurchaseDate"); //ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strReferenceNumber=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String strReveivingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String SaveType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String BankCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 23);
		String ChequeCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 24);
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.purchase_Invoice_Creation(FieldType, strPurchaseInvoiceDate, strSupplier, strReferenceNumber, strReveivingDate, strProduct, SaveType);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		String strValidation="Your invoice number is";
		boolean result=refPurPurchaseInvoice.get_Purchase_Invoice_Vochure(strValidation.trim());
		GenericMethods.fnwait(3);
		RefEstimationHistory.click_On_Close_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 25, purchaseInvoice);
		log.info("*****Purchase Invoice Is Successfully Created*****");
		fnWriteSteps("Pass", "Purchase Invoice Is Successfully Created");
		GenericMethods.fnEndTestCase();	
	}
	@Test 
	public void validate_Purchase_Invoice_Own_Gift_vochure_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Third_Party_vochure_Test");
		log.info("********Purchase Invoice Creation With Third Party Vochure******");
		int rowindex = 10;
		String FieldType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strPurchaseInvoiceDate=GenericMethods.getPropertyValue("PurchaseDate"); //ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strReferenceNumber=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String strReveivingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String SaveType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String BankCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 23);
		String ChequeCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 24);
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.purchase_Invoice_Creation(FieldType, strPurchaseInvoiceDate, strSupplier, strReferenceNumber, strReveivingDate, strProduct, SaveType);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		String strValidation="Your invoice number is";
		boolean result=refPurPurchaseInvoice.get_Purchase_Invoice_Vochure(strValidation.trim());
		GenericMethods.fnwait(3);
		RefEstimationHistory.click_On_Close_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 25, purchaseInvoice);
		log.info("*****Purchase Invoice Is Successfully Created*****");
		fnWriteSteps("Pass", "Purchase Invoice Is Successfully Created");
		GenericMethods.fnEndTestCase();	
	}
	@Test 
	public void validate_Purchase_Invoice_Creation_Third_Party_Vochure_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Creation_Third_Party_Vochure_Test");
		log.info("*********Purchase Invoice Creation*******");
		int rowindex = 11;
		String FieldType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strPurchaseInvoiceDate=GenericMethods.getPropertyValue("PurchaseDate"); //ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strReferenceNumber=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String strReveivingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String SaveType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String BankCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 23);;
		String ChequeCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 24);;
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.purchase_Invoice_Creation(FieldType, strPurchaseInvoiceDate, strSupplier, strReferenceNumber, strReveivingDate, strProduct, SaveType);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		String strValidation="Your invoice number is";
		boolean result=refPurPurchaseInvoice.get_Purchase_Invoice_Vochure(strValidation.trim());
		GenericMethods.fnwait(3);
		RefEstimationHistory.click_On_Close_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 25, purchaseInvoice);
		log.info("*****Purchase Invoice Is Successfully Created*****");
		fnWriteSteps("Pass", "Purchase Invoice Is Successfully Created");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Purchase_Invoice_Creation_Bank_Transfer_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Creation_Bank_Transfer_Test");
		log.info("*********Purchase Invoice Creation*******");
		int rowindex = 12;
		String FieldType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strPurchaseInvoiceDate=GenericMethods.getPropertyValue("PurchaseDate"); //ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strReferenceNumber=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String strReveivingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String SaveType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String BankCheck="NULL";
		String ChequeCheck="NULL";
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.purchase_Invoice_Creation(FieldType, strPurchaseInvoiceDate, strSupplier, strReferenceNumber, strReveivingDate, strProduct, SaveType);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		String strValidation="Your invoice number is";
		boolean result=refPurPurchaseInvoice.get_Purchase_Invoice_Vochure(strValidation.trim());
		GenericMethods.fnwait(3);
		RefEstimationHistory.click_On_Close_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 25, purchaseInvoice);
		log.info("*****Purchase Invoice Is Successfully Created*****");
		fnWriteSteps("Pass", "Purchase Invoice Is Successfully Created");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Purchase_Invoice_Creation_Payment_Cheque_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Creation_Payment_Cheque_Test");
		log.info("*********Purchase Invoice Creation*******");
		int rowindex = 13;
		String FieldType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strPurchaseInvoiceDate=GenericMethods.getPropertyValue("PurchaseDate"); //ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strReferenceNumber=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String strReveivingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String SaveType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String BankCheck="NULL";
		String ChequeCheck="NULL";
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.purchase_Invoice_Creation(FieldType, strPurchaseInvoiceDate, strSupplier, strReferenceNumber, strReveivingDate, strProduct, SaveType);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		String strValidation="Your invoice number is";
		boolean result=refPurPurchaseInvoice.get_Purchase_Invoice_Vochure(strValidation.trim());
		GenericMethods.fnwait(3);
		RefEstimationHistory.click_On_Close_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 25, purchaseInvoice);
		log.info("*****Purchase Invoice Is Successfully Created*****");
		fnWriteSteps("Pass", "Purchase Invoice Is Successfully Created");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Purchase_Invoice_Creation_Payment_Advance_Paid_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Creation_Payment_Advance_Paid_Test");
		log.info("*********Purchase Invoice Creation*******");
		int rowindex = 14;
		String FieldType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strPurchaseInvoiceDate=GenericMethods.getPropertyValue("PurchaseDate"); //ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strReferenceNumber=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String strReveivingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String SaveType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String BankCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 23);;
		String ChequeCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 24);;
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.purchase_Invoice_Creation(FieldType, strPurchaseInvoiceDate, strSupplier, strReferenceNumber, strReveivingDate, strProduct, SaveType);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		String strValidation="Your invoice number is";
		boolean result=refPurPurchaseInvoice.get_Purchase_Invoice_Vochure(strValidation.trim());
		GenericMethods.fnwait(3);
		RefEstimationHistory.click_On_Close_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 25, purchaseInvoice);
		log.info("*****Purchase Invoice Is Successfully Created*****");
		fnWriteSteps("Pass", "Purchase Invoice Is Successfully Created");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Purchase_Invoive_Creation_Payment_DebitNotes_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Invoive_Creation_Payment_DebitNotes_Test");
		log.info("*********Purchase Invoice Creation*******");
		int rowindex = 15;
		String FieldType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strPurchaseInvoiceDate=GenericMethods.getPropertyValue("PurchaseDate"); //ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strReferenceNumber=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String strReveivingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String SaveType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String BankCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 23);;
		String ChequeCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 24);;
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.purchase_Invoice_Creation(FieldType, strPurchaseInvoiceDate, strSupplier, strReferenceNumber, strReveivingDate, strProduct, SaveType);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		GenericMethods.fnwait(3);
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		String strValidation="Your invoice number is";
		boolean result=refPurPurchaseInvoice.get_Purchase_Invoice_Vochure(strValidation.trim());
		GenericMethods.fnwait(3);
		RefEstimationHistory.click_On_Close_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 25, purchaseInvoice);
		log.info("*****Purchase Invoice Is Successfully Created*****");
		fnWriteSteps("Pass", "Purchase Invoice Is Successfully Created");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Purchase_Invoice_Creation_Multiple_Payments_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Creation_Multiple_Payments_Test");
		log.info("*********Purchase Invoice Creation*******");
		int rowindex = 16;
		String FieldType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strPurchaseInvoiceDate= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strReferenceNumber=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String strReveivingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String SaveType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String BankCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 23);;
		String ChequeCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 24);;
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.purchase_Invoice_Creation(FieldType, strPurchaseInvoiceDate, strSupplier, strReferenceNumber, strReveivingDate, strProduct, SaveType);
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		GenericMethods.fnwait(3);
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		String strValidation="Your invoice number is";
		boolean result=refPurPurchaseInvoice.get_Purchase_Invoice_Vochure(strValidation.trim());
		GenericMethods.fnwait(3);
		RefEstimationHistory.click_On_Close_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 25, purchaseInvoice);
		log.info("*****Purchase Invoice Is Successfully Created*****");
		fnWriteSteps("Pass", "Purchase Invoice Is Successfully Created");
		GenericMethods.fnEndTestCase();
	}
	@Test
	public void validate_Purchase_Invoice_Creation_Invoice_Date_Future_Date() {
		GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Creation_Invoice_Date_Future_Date");
		log.info("*******Validating Purchase invoice Creation With Future Date******");
		int rowindex = 17;
		boolean result=false;
		String FieldType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strPurchaseInvoiceDate=GenericMethods.getPropertyValue("PurchaseFutureDate"); //ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strReferenceNumber=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String strReveivingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String SaveType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.purchase_Invoice_Creation(FieldType, strPurchaseInvoiceDate, strSupplier, strReferenceNumber, strReveivingDate, strProduct, SaveType);
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.click_On_Logo();
		GenericMethods.fnwait(2);
     	String actual=refOrderPage.get_Vochure_Date();
     	GenericMethods.fnwait(2);
		RefEstimationHistory.click_On_Close_Button();
		driver.findElement(By.id("btnCancel")).click();
		GenericMethods.fnwait(2);
		RefEstimationHistory.click_On_Close_Button();
		if(!actual.trim().substring(0, 2).equals(strPurchaseInvoiceDate.trim().substring(0,2))) {
			System.out.println(actual.trim().substring(0, 2));
			System.out.println(strPurchaseInvoiceDate.trim().substring(0,2));
			result=true;
		}
		Assert.assertTrue(result);
		log.info("*******Successfully Validated Purchase Invoice Creation With Future Date*********");
		fnWriteSteps("Pass","Successfully Validated Purchase Invoice Creation With Future Date");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void validate_Purchase_Invoice_Creation_Fully_Due_For_Deletion_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Creation_For_Deletion_Test");
		log.info("*******Purchase Invoice Creation******");
		int rowindex =18;
		String FieldType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strPurchaseInvoiceDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strReferenceNumber=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String strReveivingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String SaveType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String BankCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 23);
		String ChequeCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 24);
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurPurchaseInvoice.purchase_Invoice_Creation(FieldType, strPurchaseInvoiceDate, strSupplier, strReferenceNumber, strReveivingDate, strProduct, SaveType);
	
		refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2,BankCheck,ChequeCheck);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		refPurPurchaseInvoice.click_On_Header();
		refPurPurchaseInvoice.click_Ok_Button();
		refOrderPage.send_Instructions(strInstructions);
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		String strValidation="Your invoice number is";
		boolean result=refPurPurchaseInvoice.get_Purchase_Invoice_Vochure(strValidation.trim());
		GenericMethods.fnwait(5);
		RefEstimationHistory.click_On_Close_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 25, purchaseInvoice);
		log.info("*******Purchase Invoice Is Successfully Created With Purchase Only Item From Dashboard");
		fnWriteSteps("Pass", "Purchase Invoice Is Successfully Created");
		GenericMethods.fnEndTestCase();
	}
	@SuppressWarnings("unused")
	@Test 
	public void validate_Purchase_Modification_By_Increasing_Quantity_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Modification_By_Increasing_Quantity_Test");
		log.info("******Purchase Invoice Modification********");
		int rowindex = 27;
		boolean result=false;
		String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String Modification=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String Invoice=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String PageType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex,6);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String BankCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);;
		String ChequeCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", 3, 25);
        refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.search_Vochure(vochure);
		GenericMethods.fnwait(2);
		RefEstimationHistory.clickSaveButton();
	    String beforeModify=refPurPurchaseInvoice.vochure_Modification_Page(Modification, strFieldValue);
	    String amountAfterModify=driver.findElement(By.id("lblTotalAmountValue")).getAttribute("Name");
	    if(!amountAfterModify.equals(beforeModify)) {
			GenericMethods.fnwait(3);
			refPurPurchaseInvoice.click_On_Payment_Button();
			refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2, BankCheck, ChequeCheck);
			refOrderPage.click_Scroll_Down();
			refOrderPage.click_Finish_Button();
			GenericMethods.fnwait(3);
			refPurPurchaseInvoice.click_On_Header();
			refPurPurchaseInvoice.click_Ok_Button();
			refOrderPage.send_Instructions(strInstructions);
			refPurPurchaseInvoice.click_On_Header();
			refPurPurchaseInvoice.click_Ok_Button();
			RefEstimationHistory.click_On_Close_Button();
			result=true;
	}
	    Assert.assertTrue(result);
	    log.info("********Successfully Modified Purchase Invoice*******");
	    fnWriteSteps("Pass","Successfully Modified Purchase Invoice");
	    GenericMethods.fnEndTestCase();
	}
	@SuppressWarnings("unused")
	@Test 
	public void validate_Purchase_Modification_Decreasing_Quantity_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Modification_Decreasing_Quantity_Test");
		log.info("******Purchase Invoice Modification********");
		int rowindex = 28;
		boolean result=false;
		String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String Modification=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String Invoice=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String PageType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex,6);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String BankCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);;
		String ChequeCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", 3 ,25);
	//	RefEstimationHistory.serachRecord(vochure);
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.search_Vochure(vochure);
		GenericMethods.fnwait(2);
		RefEstimationHistory.clickSaveButton();
	    String beforeModify=refPurPurchaseInvoice.vochure_Modification_Page(Modification, strFieldValue);
	    String amountAfterModify=driver.findElement(By.id("lblTotalAmountValue")).getAttribute("Name");
	    if(!amountAfterModify.equals(beforeModify)) {
			GenericMethods.fnwait(3);
			refPurPurchaseInvoice.click_On_Payment_Button();
			refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2, BankCheck, ChequeCheck);
			refOrderPage.click_Scroll_Down();
			refOrderPage.click_Finish_Button();
			GenericMethods.fnwait(3);
			refPurPurchaseInvoice.click_On_Header();
			refPurPurchaseInvoice.click_Ok_Button();
			refOrderPage.send_Instructions(strInstructions);
			refPurPurchaseInvoice.click_On_Header();
			refPurPurchaseInvoice.click_Ok_Button();
			RefEstimationHistory.click_On_Close_Button();
			result=true;
	}
	    Assert.assertTrue(result);
	    log.info("********Successfully Modified Purchase Invoice*******");
	    fnWriteSteps("Pass","Successfully Modified Purchase Invoice");
	    GenericMethods.fnEndTestCase();
	}
	@SuppressWarnings("unused")
	@Test 
	public void valoidate_Purchase_Invoice_Modification_Adding_Product_Test() {
		GenericMethods.fnStartTestCase("valoidate_Purchase_Invoice_Modification_Adding_Product_Test");
		log.info("******Purchase Invoice Modification********");
		int rowindex = 29;
		boolean result=false;
		String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String Modification=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String Invoice=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String PageType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex,6);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String BankCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);;
		String ChequeCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase",3, 25);
	//	RefEstimationHistory.serachRecord(vochure);
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.search_Vochure(vochure);
		GenericMethods.fnwait(2);
		RefEstimationHistory.clickSaveButton();
	    String beforeModify=refPurPurchaseInvoice.vochure_Modification_Page(Modification, strFieldValue);
	    String amountAfterModify=driver.findElement(By.id("lblTotalAmountValue")).getAttribute("Name");
	    if(!amountAfterModify.equals(beforeModify)) {
			GenericMethods.fnwait(3);
			refPurPurchaseInvoice.click_On_Payment_Button();
			refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2, BankCheck, ChequeCheck);
			refOrderPage.click_Scroll_Down();
			refOrderPage.click_Finish_Button();
			GenericMethods.fnwait(3);
			refPurPurchaseInvoice.click_On_Header();
			refPurPurchaseInvoice.click_Ok_Button();
			refOrderPage.send_Instructions(strInstructions);
			refPurPurchaseInvoice.click_On_Header();
			refPurPurchaseInvoice.click_Ok_Button();
			RefEstimationHistory.click_On_Close_Button();
			result=true;
	}
	    Assert.assertTrue(result);
	    log.info("********Successfully Modified Purchase Invoice*******");
	    fnWriteSteps("Pass","Successfully Modified Purchase Invoice");
	    GenericMethods.fnEndTestCase();
	}
	@SuppressWarnings("unused")
	@Test 
	public void validate_Purchase_Invoice_Modification_By_Removing_Product_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Modification_By_Removing_Product_Test");
		log.info("******Purchase Invoice Modification********");
		int rowindex = 30;
		boolean result=false;
		String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String Modification=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String Invoice=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String PageType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String Payment=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex,6);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strWallet=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strBankAccNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strReference=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		String strBankName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11);
		String strVochureType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 12);
		String strVochureNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 13);
		String strChequeNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 14);
		String strBranch=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 15);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		String strCreditNote=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 17);
		String strAdvanceAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 18);
		String strAmount1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 19);
		String strAmount2=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 20);
		String BankCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 21);;
		String ChequeCheck=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 22);
		String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", 3, 25);
	//	RefEstimationHistory.serachRecord(vochure);
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.search_Vochure(vochure);
		GenericMethods.fnwait(2);
		RefEstimationHistory.clickSaveButton();
	    String beforeModify=refPurPurchaseInvoice.vochure_Modification_Page(Modification, strFieldValue);
	    String amountAfterModify=driver.findElement(By.id("lblTotalAmountValue")).getAttribute("Name");
	    if(!amountAfterModify.equals(beforeModify)) {
			GenericMethods.fnwait(3);
			refPurPurchaseInvoice.click_On_Payment_Button();
			refOrderPage.payment_Page(Payment, strAmount, strCardNo, strWallet, strBankAccNo, strReference, strBankName, strVochureType, strVochureNo, strChequeNo, strBranch, strInstructions, strCreditNote, strAdvanceAmount, strAmount1, strAmount2, BankCheck, ChequeCheck);
			refOrderPage.click_Scroll_Down();
			refOrderPage.click_Finish_Button();
			GenericMethods.fnwait(3);
			refPurPurchaseInvoice.click_On_Header();
			refPurPurchaseInvoice.click_Ok_Button();
			refOrderPage.send_Instructions(strInstructions);
			refPurPurchaseInvoice.click_On_Header();
			refPurPurchaseInvoice.click_Ok_Button();
		result=true;
	}
	    Assert.assertTrue(result);
		RefEstimationHistory.click_On_Close_Button();
	    log.info("********Successfully Modified Purchase Invoice*******");
	    fnWriteSteps("Pass","Successfully Modified Purchase Invoice");
	    GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Purchase_Invoice_Modification_For_Fully_Paid_Invoice_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Modification_For_Fully_Paid_Invoice_Test");
		log.info("*******Validate Purchase Invoice Modification For Completed Vochure*******");
		String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", 7, 25);
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.search_Vochure(vochure);
	boolean result=	RefEstimationHistory.validate_Edit_Button();
	RefEstimationHistory.click_On_Close_Button();
	Assert.assertTrue(result);
	log.info("******Validated Purchase Invoice For Completed Payment***");
	fnWriteSteps("Pass","Validated Purchase Invoice Modification");
	GenericMethods.fnEndTestCase();	
	}
	//failed test case
	@Test 
	public void validate_Purchase_Modification_Partial_Payment_Test() {
		GenericMethods.fnStartTestCase("validate_Purchase_Modification_Partial_Payment_Test");
		log.info("***Purchase Modification For Partial Paymnet*******");
		boolean result=false;
		int rowindex = 31;
		String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", 4, 25);
		String Modification=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 16);
		System.out.println(vochure);
		refPurPurchaseInvoice.click_On_Logo();
		refPurPurchaseInvoice.search_Vochure(vochure);
		GenericMethods.fnwait(2);
		RefEstimationHistory.clickSaveButton();
		  String beforeModify=refPurPurchaseInvoice.vochure_Modification_Page(Modification, strFieldValue);
		    String amountAfterModify=driver.findElement(By.id("lblTotalAmountValue")).getAttribute("Name");
		    if(!amountAfterModify.equals(beforeModify)) {
				GenericMethods.fnwait(3);
				refPurPurchaseInvoice.click_On_Payment_Button();
				refOrderPage.click_Scroll_Down();
				refOrderPage.click_Finish_Button();
				GenericMethods.fnwait(3);
				refPurPurchaseInvoice.click_On_Header();
				refPurPurchaseInvoice.click_Ok_Button();
				GenericMethods.fnwait(3);
				refOrderPage.send_Instructions(strInstructions);
				GenericMethods.fnwait(2);
				refPurPurchaseInvoice.click_On_Header();
				refPurPurchaseInvoice.click_Ok_Button();
				GenericMethods.fnwait(1);
				RefEstimationHistory.click_On_Close_Button();
				result=true;
		}
		    Assert.assertTrue(result);
		    log.info("********Successfully Modified Purchase Invoice*******");
		    fnWriteSteps("Pass","Successfully Modified Purchase Invoice");
		    GenericMethods.fnEndTestCase();
	}
@SuppressWarnings("unused")
@Test 
public void validate_Purchase_Invoice_Deletion_Fully_Paid_Test() {
	GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Deletion_Fully_Paid_Test");
	log.info("****Purchase Invoice Deletion*****");
	int rowindex=38;
	String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", 10,25);
	String strRemarks=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
	GenericMethods.fnwait(2);	
	refPurPurchaseInvoice.click_On_Logo();
	refPurPurchaseInvoice.search_Vochure(vochure);
	boolean result=refPurPurchaseInvoice.vochure_Deletion_From_History(strRemarks);
	GenericMethods.fnwait(3);
	RefEstimationHistory.click_On_Close_Button();
	}
@SuppressWarnings("unused")
@Test 
public void validate_Purchase_Invoice_Deletion_Fully_Due_Test() {
	GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Deletion_Fully_Due_Test");
	log.info("******Purchase Invoice Deletion*****");
	int rowindex=40;
	String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", 18, 25);
	String strRemarks=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
	GenericMethods.fnwait(2);
	refPurPurchaseInvoice.click_On_Logo();
	refPurPurchaseInvoice.search_Vochure(vochure);
	boolean result=refPurPurchaseInvoice.vochure_Deletion_From_History(strRemarks);
	GenericMethods.fnwait(4);
	RefEstimationHistory.click_On_Close_Button();
	log.info("*********Purchase Invoice Is Successfully Deleted*******");
	fnWriteSteps("Pass", "Purchase Invoice Is Successfully Deleted");
	GenericMethods.fnEndTestCase();
	
}
@Test
public void validate_Purchase_Invoice_Deletion_Without_Internet_Test() {
     GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Deletion_Without_Internet_Test");
	log.info("********Purchase Deletion Without Internet********");
	int rowindex=39;
	String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", 11, 25);
	String strRemarks=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
	GenericMethods.fnwait(2);
	refPurPurchaseInvoice.click_On_Logo();
	refPurPurchaseInvoice.search_Vochure(vochure);
	refPurPurchaseInvoice.vochure_Deletion_From_History(strRemarks);
	String strValidation="Please check the internet connection";
	boolean result=refPurPurchaseInvoice.get_Purchase_Invoice_Vochure(strValidation.trim());
	GenericMethods.fnwait(3);
	RefEstimationHistory.click_On_Close_Button();
	GenericMethods.fnwait(3);
	RefEstimationHistory.click_On_Close_Button();
	Assert.assertTrue(result);
	log.info("********Validated Purchase Invoice Deletion*********");
	fnWriteSteps("Pass","Validated Purchase Invoice Deletion Without Deletion");
	GenericMethods.fnEndTestCase();
	
}
@Test 
public void validate_Purchase_Invoice_Deletion_For_Partial_Payment_Test() {
	GenericMethods.fnStartTestCase("validate_Purchase_Invoice_Deletion_For_Partial_Payment_Test");
	log.info("*****Purchase Invoice Deletion For Patial Payment****");
	int rowindex=41;
	String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", 4, 25);
	String strRemarks=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
	GenericMethods.fnwait(2);
	refPurPurchaseInvoice.click_On_Logo();
	refPurPurchaseInvoice.search_Vochure(vochure);
	refPurPurchaseInvoice.vochure_Deletion_From_History(strRemarks);
	GenericMethods.fnwait(4);
	RefEstimationHistory.click_On_Close_Button();
	log.info("*********Purchase Invoice Is Successfully Deleted*******");
	fnWriteSteps("Pass", "Purchase Invoice Is Successfully Deleted");
	GenericMethods.fnEndTestCase();
	
}


	
}
