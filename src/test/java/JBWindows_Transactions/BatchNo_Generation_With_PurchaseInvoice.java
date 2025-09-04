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

public class BatchNo_Generation_With_PurchaseInvoice extends BaseClass  {
	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessgBox;
    PUR_AddPuchaseInvoice RefAddPuchaseInvoice;
	SAL_PointOfSales RefPurchaseInvoiceScreen;
    SAL_DocumentHistory RefEstimationHistory;
	Trans_Order_Page refOrderPage;
	PUR_PurchaseInvoice refPurchaseInvoice;

	public BatchNo_Generation_With_PurchaseInvoice() {
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
		refPurchaseInvoice=new PUR_PurchaseInvoice();
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
		RefMenu.OpenPage("purchase invoices");

	}

	@AfterMethod
	public void tearDown() {
		GenericMethods.fnwait(1);
		RefEstimationHistory.click_On_Close_Button();
        GenericMethods.fnwait(2);
		RefDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		RefMessgBox.ExitApplication_Yes();
		GenericMethods.fnwait(19);

	}
	@Test 
	public void Validate_Purchaseinvoice_creation_with_a_Product_Managed_by_Batch_Number() {
		GenericMethods.fnStartTestCase("Validate Purchaseinvoice creation with a Product Managed by Batch Number");
		int rowindex = 45;
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strBatchNoProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String BatchNo1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String Lotsize=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String ManufacturingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String ExpiryDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String ProductManagedBy=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		refPurchaseInvoice.click_On_Logo();
		refPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurchaseInvoice.Enter_Supplier_Details(strSupplier);
		refPurchaseInvoice.BatchNo_Generation_for_PurchaseInvoice(strBatchNoProduct, BatchNo1, Lotsize, ManufacturingDate, ExpiryDate,ProductManagedBy);
		boolean result = refPurchaseInvoice.Validate_Adding_of_BatchNumber();
		refPurchaseInvoice.click_On_Payment_Button();
		GenericMethods.fnwait(1);
		refPurchaseInvoice.Due_Operation_With_Card_PaymentMode(strAmount, strCardNo);
		GenericMethods.fnwait(2);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
	    refPurchaseInvoice.click_Ok_Button();
		refOrderPage.send_Instructions(strInstructions);
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		refPurchaseInvoice.click_Ok_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11, purchaseInvoice);
		fnWriteSteps("Pass", "Purchase Invoice Is Successfully Created With a Product Managed by Batch Number");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void Validate_Purchaseinvoice_creation_with_a_Product_Not_Managed_by_Batch_Number() {
		GenericMethods.fnStartTestCase("Validate Purchaseinvoice creation with a Product Not Managed by Batch Number");
		int rowindex = 46;
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		refPurchaseInvoice.click_On_Logo();
		refPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
		refPurchaseInvoice.Enter_Supplier_Details(strSupplier);
		 refOrderPage.enter_Product_Details(strProduct);
	    boolean result = refPurchaseInvoice.Validate_paymentButton();
		refPurchaseInvoice.click_On_Payment_Button();
		 GenericMethods.fnwait(1);
		refPurchaseInvoice.Due_Operation_With_Card_PaymentMode(strAmount, strCardNo);
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		refPurchaseInvoice.click_Ok_Button();
		refOrderPage.send_Instructions(strInstructions);
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		refPurchaseInvoice.click_Ok_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11, purchaseInvoice);
		fnWriteSteps("Pass", "Purchase Invoice Is Successfully Created With a Product Not Managed by Batch Number");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void Validate_Purchaseinvoice_creation_with_a_combination_of_Managed_by_Batch_No_and_not_Managed_by_Batch_No_products() {
		GenericMethods.fnStartTestCase("Validate Purchaseinvoice creation with a combination of Managed by Batch No and not Managed by Batch No products");
		int rowindex = 47;
		String strSupplier=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String strBatchNoProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String BatchNo1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String Lotsize=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String ManufacturingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String ExpiryDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String ProductManagedBy=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		refPurchaseInvoice.click_On_Logo();
		refPurchaseInvoice.clickCreateNewButton();
		GenericMethods.fnwait(2);
	    refPurchaseInvoice.Enter_Supplier_Details(strSupplier);
	    refOrderPage.enter_Product_Details(strProduct);
	    GenericMethods.fnwait(2);
		refPurchaseInvoice.BatchNo_Generation_for_PurchaseInvoice(strBatchNoProduct, BatchNo1, Lotsize, ManufacturingDate, ExpiryDate,ProductManagedBy);
		boolean result = refPurchaseInvoice.Validate_Adding_of_BatchNumber();
	    GenericMethods.fnwait(2);
	    refPurchaseInvoice.click_On_Payment_Button();
	    GenericMethods.fnwait(2);
	    refPurchaseInvoice.Due_Operation_With_Card_PaymentMode(strAmount, strCardNo);
	    refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
		refPurchaseInvoice.click_Ok_Button();
		refOrderPage.send_Instructions(strInstructions);
		String purchaseInvoice=	RefMessgBox.fnGetPurchaseInvoiceNo();
		refPurchaseInvoice.click_Ok_Button();
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 11, purchaseInvoice);
		fnWriteSteps("Pass", "Purchase Invoice Is Successfully Created With a combination of Managed by Batch No and not Managed by Batch No products");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void Validate_BatchNo_with_Entering_Existing_PurchaseInvoice_record_for_the_same_product() {
		GenericMethods.fnStartTestCase("Validate BatchNo with Entering Existing PurchaseInvoice record for the same product");
		int rowindex = 48;
		String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", 45, 11);
		String strBatchNoProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String BatchNo1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String Lotsize=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String ManufacturingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String ExpiryDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String ProductManagedBy=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		refPurchaseInvoice.click_On_Logo();
		refPurchaseInvoice.search_Vochure(vochure);
		GenericMethods.fnwait(2);
		RefEstimationHistory.clickSaveButton();
	    GenericMethods.fnwait(1);
		refPurchaseInvoice.BatchNo_Generation_for_PurchaseInvoice(strBatchNoProduct, BatchNo1, Lotsize, ManufacturingDate, ExpiryDate,ProductManagedBy);
		boolean result = refPurchaseInvoice.Validate_Existed_BatchNumber();
		RefEstimationHistory.click_On_Close_Button();
		  GenericMethods.fnwait(1);
		  refPurchaseInvoice.click_On_Payment_Button();
			GenericMethods.fnwait(1);
			refPurchaseInvoice.Due_Operation_With_Card_PaymentMode(strAmount, strCardNo);
			GenericMethods.fnwait(2);
			refOrderPage.click_Scroll_Down();
			refOrderPage.click_Finish_Button();
			refPurchaseInvoice.click_Ok_Button();
			refOrderPage.send_Instructions(strInstructions);
			refPurchaseInvoice.click_Ok_Button();
			Assert.assertTrue(result);
			fnWriteSteps("Pass", "BatchNo with Entering Existing PurchaseInvoice record for the same product validated Successfully");
			GenericMethods.fnEndTestCase();
	}
	@Test 
	public void Validate_BatchNo_with_Entering_Existing_PurchaseInvoice_record_for_the_Different_product() {
		GenericMethods.fnStartTestCase("Validate BatchNo with Entering Existing PurchaseInvoice record for the Different product");
		int rowindex = 49;
		String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", 45, 11);
		String strBatchNoProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String BatchNo1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String Lotsize=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String ManufacturingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String ExpiryDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String ProductManagedBy=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 8);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 9);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 10);
		refPurchaseInvoice.click_On_Logo();
		refPurchaseInvoice.search_Vochure(vochure);
		GenericMethods.fnwait(2);
		RefEstimationHistory.clickSaveButton();
		GenericMethods.fnwait(1);
		refPurchaseInvoice.BatchNo_Generation_for_PurchaseInvoice(strBatchNoProduct, BatchNo1, Lotsize, ManufacturingDate, ExpiryDate,ProductManagedBy);
		boolean result = refPurchaseInvoice.Validate_Adding_of_BatchNumber();
		GenericMethods.fnwait(1);
		 refPurchaseInvoice.click_On_Payment_Button();
		 GenericMethods.fnwait(1);
			refPurchaseInvoice.Due_Operation_With_Card_PaymentMode(strAmount, strCardNo);
			GenericMethods.fnwait(2);
			refOrderPage.click_Scroll_Down();
			refOrderPage.click_Finish_Button();
			refPurchaseInvoice.click_Ok_Button();
			refOrderPage.send_Instructions(strInstructions);
			refPurchaseInvoice.click_Ok_Button();
			Assert.assertTrue(result);
			fnWriteSteps("Pass", "BatchNo with Entering Existing PurchaseInvoice record for the Different product validated Successfully");
			GenericMethods.fnEndTestCase();
	}
	@Test 
	public void Generate_BatchNo_while_Modifying_Purchase_invoice_with_a_product_managed_by_BatchNo() {
		GenericMethods.fnStartTestCase("Generate BatchNo while Modifying Purchase invoice with a product managed by BatchNo");
		int rowindex = 52;
		String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", 45, 11);
		String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String BatchNo1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String Lotsize=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String ManufacturingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String ExpiryDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		refPurchaseInvoice.click_On_Logo();
		refPurchaseInvoice.search_Vochure(vochure);
		GenericMethods.fnwait(2);
		RefEstimationHistory.clickSaveButton();
		refPurchaseInvoice.Purchase_Product_Quantity_Modification(strFieldValue);
		refPurchaseInvoice.Generate_BatchNO(BatchNo1, Lotsize, ManufacturingDate, ExpiryDate);
		boolean result = refPurchaseInvoice.Validate_Adding_of_BatchNumber();
		refPurchaseInvoice.click_On_Payment_Button();
		GenericMethods.fnwait(1);
			refPurchaseInvoice.Due_Operation_With_Card_PaymentMode(strAmount, strCardNo);
			GenericMethods.fnwait(2);
			refOrderPage.click_Scroll_Down();
			refOrderPage.click_Finish_Button();
			refPurchaseInvoice.click_Ok_Button();
			refOrderPage.send_Instructions(strInstructions);
			refPurchaseInvoice.click_Ok_Button();
			Assert.assertTrue(result);
			fnWriteSteps("Pass", "Successfully BatchNo generated while Modifying Purchase invoice with a product managed by BatchNo");
			GenericMethods.fnEndTestCase();
		
		
	}
	@Test 
	public void Generate_BatchNo_while_modifying_Purchase_invoice_with_a_product_not_managed_by_BatchNo() {
		GenericMethods.fnStartTestCase("Generate BatchNo while modifying Purchase invoice with a product not managed by BatchNo");
		int rowindex = 53;
		String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", 46, 11);
		String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		refPurchaseInvoice.click_On_Logo();
		refPurchaseInvoice.search_Vochure(vochure);
		GenericMethods.fnwait(2);
		RefEstimationHistory.clickSaveButton();
		refPurchaseInvoice.Purchase_Product_Quantity_Modification(strFieldValue);
		boolean result = refPurchaseInvoice.Validate_paymentButton();
		refPurchaseInvoice.click_On_Payment_Button();
		  refOrderPage.Click_On_Payment_Cash();
		  refOrderPage.click_Scroll_Down();
			refOrderPage.click_Finish_Button();
			refPurchaseInvoice.click_Ok_Button();
			Assert.assertTrue(result);
			fnWriteSteps("Pass", "Successfully BatchNo generated while modifying Purchase invoice with a product not managed by BatchNo");
			GenericMethods.fnEndTestCase();
		
		}
	@Test 
	public void Generate_BatchNo_while_modifying_Purchase_invoice_with_a_combination_of_managed_by_BatchNo_and_not_managed_by_BatchNo_products() {
		GenericMethods.fnStartTestCase("Generate BatchNo while modifying Purchase invoice with a combination of managed by BatchNo and not managed by BatchNo products");
		int rowindex = 54;
		String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", 47, 11);
		String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String BatchNo1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String Lotsize=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String ManufacturingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String ExpiryDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		refPurchaseInvoice.click_On_Logo();
		refPurchaseInvoice.search_Vochure(vochure);
		GenericMethods.fnwait(2);
		RefEstimationHistory.clickSaveButton();
		refPurchaseInvoice.Purchase_Product_Quantity_Modification(strFieldValue);
		refPurchaseInvoice.Generate_BatchNO(BatchNo1, Lotsize, ManufacturingDate, ExpiryDate);
		boolean result = refPurchaseInvoice.Validate_Adding_of_BatchNumber();
		refPurchaseInvoice.click_On_Payment_Button();
		  refOrderPage.Click_On_Payment_Cash();
		  refOrderPage.click_Scroll_Down();
			refOrderPage.click_Finish_Button();
			refPurchaseInvoice.click_Ok_Button();
			Assert.assertTrue(result);
			fnWriteSteps("Pass", "Successfully BatchNo generated while modifying Purchase invoice with a combination of managed by BatchNo and not managed by BatchNo products");
			GenericMethods.fnEndTestCase();
		
		}
	@Test 
	public void Generate_BatchNo_while_modifying_Purchase_invoice_with_entering_existing_record_for_the_same_product() {
		GenericMethods.fnStartTestCase("Generate BatchNo while modifying Purchase invoice with entering existing record for the same product");
		int rowindex = 55;
		String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", 45, 11);
		String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
		String BatchNo1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String Lotsize=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String ManufacturingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String ExpiryDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		String strAmount=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 5);
		String strCardNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 6);
		String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 7);
		refPurchaseInvoice.click_On_Logo();
		refPurchaseInvoice.search_Vochure(vochure);
		GenericMethods.fnwait(2);
		RefEstimationHistory.clickSaveButton();
	    GenericMethods.fnwait(1);
	    refPurchaseInvoice.Purchase_Product_Quantity_Modification(strFieldValue);
		refPurchaseInvoice.Generate_BatchNO(BatchNo1, Lotsize, ManufacturingDate, ExpiryDate);
		boolean result = refPurchaseInvoice.Validate_Existed_BatchNumber();
		RefEstimationHistory.click_On_Close_Button();
		    GenericMethods.fnwait(1);
		    refPurchaseInvoice.click_On_Payment_Button();
			GenericMethods.fnwait(1);
			refPurchaseInvoice.Due_Operation_With_Card_PaymentMode(strAmount, strCardNo);
			GenericMethods.fnwait(2);
			refOrderPage.click_Scroll_Down();
			refOrderPage.click_Finish_Button();
			refPurchaseInvoice.click_Ok_Button();
			refOrderPage.send_Instructions(strInstructions);
			refPurchaseInvoice.click_Ok_Button();
			Assert.assertTrue(result);
			fnWriteSteps("Pass", "Successfully BatchNo generated while modifying Purchase invoice with entering existing record for the same product");
			GenericMethods.fnEndTestCase();
	}
	@Test 
	public void Try_to_generate_BatchNo_while_modifying_Purchase_invoice_with_entering_existing_record_for_the_different_product() {
		GenericMethods.fnStartTestCase("Try to generate BatchNo while modifying Purchase invoice with entering existing record for the different product");
		int rowindex = 56;
		String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", 45, 11);
		String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 0);
	    String BatchNo1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 1);
		String Lotsize=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 2);
		String ManufacturingDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 3);
		String ExpiryDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Purchase", rowindex, 4);
		refPurchaseInvoice.click_On_Logo();
		refPurchaseInvoice.search_Vochure(vochure);
		GenericMethods.fnwait(2);
		RefEstimationHistory.clickSaveButton();
		GenericMethods.fnwait(1);
		refPurchaseInvoice.Purchase_Product_Quantity_Modification(strFieldValue);
		refPurchaseInvoice.Generate_BatchNO(BatchNo1, Lotsize, ManufacturingDate, ExpiryDate);
		boolean result = refPurchaseInvoice.Validate_Adding_of_BatchNumber();
		refPurchaseInvoice.click_On_Payment_Button();
		  refOrderPage.Click_On_Payment_Cash();
		  refOrderPage.click_Scroll_Down();
			refOrderPage.click_Finish_Button();
			refPurchaseInvoice.click_Ok_Button();
			Assert.assertTrue(result);
			fnWriteSteps("Pass", "Successfully BatchNo generated while modifying Purchase invoice with entering existing record for the different product");
			GenericMethods.fnEndTestCase();
	}
	
 }
