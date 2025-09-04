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
import JBWindows.SAL.SAL_DocumentHistory;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows.Transactions.Trans_Order_Page;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class Trans_MultiDiscount_SalesInvoice_Test extends BaseClass  {
	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessgBox;
	SAL_DocumentHistory RefEstimationHistory;
	Trans_Order_Page refOrderPage;

	public Trans_MultiDiscount_SalesInvoice_Test() {
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
		GenericMethods.fnwait(8);
		RefDashboard.clickMenuBtn();
		RefMenu.OpenPage("invoicing");

	}

	@AfterMethod
	public void tearDown() {

		refOrderPage.click_On_DashBoard();
		GenericMethods.fnwait(1);
		refOrderPage.click_On_OK_Button();
		GenericMethods.fnwait(2);
		RefDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		RefMessgBox.ExitApplication_Yes();
		GenericMethods.fnwait(1);

	}
	@Test 
	public void fnVerify_After_Applying_only_default_discount() {
		GenericMethods.fnStartTestCase("fnVerify After Applying only default discount");
		int rowindex = 48;
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 0);
		String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
	    refOrderPage.enter_Product_Details(strProduct);
		float ExpDisc = refOrderPage.fnVerify_SalesInvoice_With_MultipleDiscounts(Modification);
		float ActualDisc = refOrderPage.Get_ActualDiscount();
		boolean result = refOrderPage.Validate_AppliedDiscount(ExpDisc,ActualDisc);
		Assert.assertNotNull(result);
		fnWriteSteps("Pass", "Default Discount should be applied Successfully");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnVerify_After_Applying_only_Pricecatalog_discount() {
		GenericMethods.fnStartTestCase("fnVerify After Applying only Pricecatalog discount");
		int rowindex = 49;
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 0);
		String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		refOrderPage.enter_Product_Details(strProduct);
		float ExpDisc = refOrderPage.fnVerify_SalesInvoice_With_MultipleDiscounts(Modification);
		float ActualDisc = refOrderPage.Get_ActualDiscount();
		boolean result = refOrderPage.Validate_AppliedDiscount(ExpDisc,ActualDisc);
		Assert.assertNotNull(result);
		fnWriteSteps("Pass", "Pricecatalog Discount should be applied Successfully");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void fnVerify_After_Applying_only_Brand_discount() {
		GenericMethods.fnStartTestCase("fnVerify After Applying only Brand discount");
		int rowindex = 50;
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 0);
		String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
	    refOrderPage.enter_Product_Details(strProduct);
		float ExpDisc = refOrderPage.fnVerify_SalesInvoice_With_MultipleDiscounts(Modification);
		float ActualDisc = refOrderPage.Get_ActualDiscount();
		boolean result = refOrderPage.Validate_AppliedDiscount(ExpDisc,ActualDisc);
		Assert.assertNotNull(result);
		fnWriteSteps("Pass", "Brand Discount should be applied Successfully");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnVerify_After_Applying_only_Category_discount() {
		GenericMethods.fnStartTestCase("fnVerify After Applying only Category discount");
		int rowindex = 51;
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 0);
		String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
	    refOrderPage.enter_Product_Details(strProduct);
		float ExpDisc = refOrderPage.fnVerify_SalesInvoice_With_MultipleDiscounts(Modification);
		float ActualDisc = refOrderPage.Get_ActualDiscount();
		boolean result = refOrderPage.Validate_AppliedDiscount(ExpDisc,ActualDisc);
		Assert.assertNotNull(result);
		fnWriteSteps("Pass", "Category Discount should be applied Successfully");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnVerify_After_Applying_only_Department_discount() {
		GenericMethods.fnStartTestCase("fnVerify After Applying only Department discount");
		int rowindex = 52;
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 0);
		String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		refOrderPage.enter_Product_Details(strProduct);
		float ExpDisc = refOrderPage.fnVerify_SalesInvoice_With_MultipleDiscounts(Modification);
		float ActualDisc = refOrderPage.Get_ActualDiscount();
		boolean result = refOrderPage.Validate_AppliedDiscount(ExpDisc,ActualDisc);
		Assert.assertNotNull(result);
		fnWriteSteps("Pass", "Department Discount should be applied Successfully");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnVerify_After_Applying_only_Customer_discount() {
		GenericMethods.fnStartTestCase("fnVerify After Applying only Customer discount");
		int rowindex = 53;
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 0);
		String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strCustomer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		refOrderPage.enter_Product_Details(strProduct);
		refOrderPage.Select_Customer_Details(strCustomer);
		float ExpDisc = refOrderPage.fnVerify_SalesInvoice_With_MultipleDiscounts(Modification);
		float ActualDisc = refOrderPage.Get_ActualDiscount();
		refOrderPage.Click_On_Payment_Cash();
		refOrderPage.click_Scroll_Down();
		refOrderPage.click_Finish_Button();
	    String InvoiceVochure = refOrderPage.get_Vochure_Page();
	    String vochure = InvoiceVochure.split(" ")[5];
	    refOrderPage.click_Return_Button();
	    RefEstimationHistory.searchReturnRecord(vochure);
	    refOrderPage.click_OK_Button();
		boolean result = refOrderPage.Validate_AppliedDiscount(ExpDisc,ActualDisc);
		Assert.assertNotNull(result);
		fnWriteSteps("Pass", "Customer Discount should be applied Successfully");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnVerify_After_Applying_Customer_discount_and_DefaultDisc_PriceListDisc_BrandDisc_CategoryDisc_DeptDisc() {
		GenericMethods.fnStartTestCase("fnVerify After Applying Customer discount and DefaultDisc PriceListDisc BrandDisc CategoryDisc DeptDisc");
		int rowindex = 54;
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 0);
		String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strCustomer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
	    refOrderPage.enter_Product_Details(strProduct);
		refOrderPage.Select_Customer_Details(strCustomer);
		float ExpDisc = refOrderPage.fnVerify_SalesInvoice_With_MultipleDiscounts(Modification);
		float ActualDisc = refOrderPage.Get_ActualDiscount();
		boolean result = refOrderPage.Validate_AppliedDiscount(ExpDisc,ActualDisc);
		Assert.assertNotNull(result);
		fnWriteSteps("Pass", "Only Customer Discount should be applied Successfully");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnVerify_After_Applying_DefaultDisc_BrandDisc_CategoryDisc_DeptDisc() {
		GenericMethods.fnStartTestCase("fnVerify After Applying DefaultDisc BrandDisc CategoryDisc DeptDisc");
		int rowindex = 55;
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 0);
		String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
	    refOrderPage.enter_Product_Details(strProduct);
		float ExpDisc = refOrderPage.fnVerify_SalesInvoice_With_MultipleDiscounts(Modification);
		float ActualDisc = refOrderPage.Get_ActualDiscount();
		boolean result = refOrderPage.Validate_AppliedDiscount(ExpDisc,ActualDisc);
		Assert.assertNotNull(result);
		fnWriteSteps("Pass", "Only Default Discount should be applied Successfully");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnVerify_After_Applying_CustomerDisc_CustomerSchemeDisc_DeptDisc_CategoryDisc() {
		GenericMethods.fnStartTestCase("fnVerify After Applying CustomerDisc and CustomerSchemeDisc and DeptDisc and CategoryDisc");
		int rowindex = 56;
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 0);
		String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strCustomer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		refOrderPage.enter_Product_Details(strProduct);
		refOrderPage.Select_Customer_Details(strCustomer);
		float ExpDisc = refOrderPage.fnVerify_SalesInvoice_With_MultipleDiscounts(Modification);
		float ActualDisc = refOrderPage.Get_ActualDiscount();
		boolean result = refOrderPage.Validate_AppliedDiscount(ExpDisc,ActualDisc);
		Assert.assertNotNull(result);
	    fnWriteSteps("Pass", "CustomerDisc and CustomerSchemeDisc should be applied Successfully");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnVerify_After_Applying_CustomerDisc_CustomerSchemeDisc_PaymentTermDisc() {
		GenericMethods.fnStartTestCase("fnVerify After Applying CustomerDisc CustomerSchemeDisc PaymentTermDisc");
		int rowindex = 57;
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 0);
		String Modification = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 1);
		String strCustomer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Invoice",
				rowindex, 2);
		refOrderPage.enter_Product_Details(strProduct);
		refOrderPage.Select_Customer_Details(strCustomer);
		float ExpDisc = refOrderPage.fnVerify_SalesInvoice_With_MultipleDiscounts(Modification);
		float ActualDisc = refOrderPage.Get_ActualDiscount();
		boolean result = refOrderPage.Validate_AppliedDiscount(ExpDisc,ActualDisc);
		Assert.assertNotNull(result);
		fnWriteSteps("Pass", "CustomerDisc and CustomerSchemeDisc and PaymentTermDisc should be applied Successfully");
		GenericMethods.fnEndTestCase();
	}


}
