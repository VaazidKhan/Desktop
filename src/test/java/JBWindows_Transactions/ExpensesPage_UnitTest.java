package JBWindows_Transactions;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.FRM.FRM_OperatingExpenses;
import JBWindows.FRM.FRM_PaymentDisbursement;
import JBWindows.FRM.FRM_PaymentNotes;
import JBWindows.SAL.SAL_DocumentHistory;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows.Transactions.Trans_Order_Page;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;


public class ExpensesPage_UnitTest extends BaseClass {
	
    Logger log = Logger.getLogger(ExpensesPage_UnitTest.class);


	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessageBoxEffia;
	FRM_OperatingExpenses RefExpensePage;
	FRM_PaymentDisbursement RefPaymentDisbursement;
	FRM_PaymentNotes RefPaymentDenominationWindow;
	SAL_DocumentHistory RefEstimationHistory;
	Trans_Order_Page refOrderPage;

	public ExpensesPage_UnitTest() {
		super();
	}


	@BeforeClass
	public void fnBeforeClass() throws InterruptedException {
		DOMConfigurator.configure("log4j.xml");
		GenericMethods.fnwait(2);
		RefLogin = new Login(driver);
		RefDashboard = new APP_Dashboard(driver);
		RefMenu = new APP_Menu(driver);
		RefMessageBoxEffia = new MessageBoxEffia(driver);
		RefExpensePage = new FRM_OperatingExpenses();
		RefPaymentDisbursement = new FRM_PaymentDisbursement();
		RefPaymentDenominationWindow = new FRM_PaymentNotes();
		RefEstimationHistory = new SAL_DocumentHistory();
		refOrderPage = new Trans_Order_Page();
	}

	@BeforeMethod
	public void fn_Login_and_Open_Page() {
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(2);
		// RefDashboard.activatePage();
		GenericMethods.fnwait(20);
		RefDashboard.clickMenuBtn();
		GenericMethods.fnwait(2);
		RefMenu.OpenPage("expenses");
		GenericMethods.fnwait(2);
	}

	@Test 
	public void fnVerifyFieldVisibility() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Expense add entry are present or not ");
        RefExpensePage.VerifyFieldVisibility();
		GenericMethods.fnwait(2);
		RefExpensePage.clickCancelButton();
        GenericMethods.fnEndTestCase();
	}

	@Test 
	public void fnVerifyFieldEnableOrNot() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Expense add entry are enable or not");
		RefExpensePage.VerifyFieldEnableOrNot();
		GenericMethods.fnwait(1);
		RefExpensePage.clickCancelButton();
		GenericMethods.fnEndTestCase();
	}

	/*@Test (enabled = false,priority = 3)
	public void fnExpenseCreation_From_Dashboard() {
		GenericMethods.fnStartTestCase("Verify Expense creation");
		boolean result = false;
		RefExpensePage.Click_on_ExpenseOption_From_Dashboard();
		RefExpensePage.createNewExpense(1);
		GenericMethods.fnwait(2);
		String expenseNumber = RefPaymentDisbursement.getExpenseNumber();
		GenericMethods.fnwait(2);
		RefPaymentDisbursement.selectPaymentMode("CASH");
		GenericMethods.fnwait(3);
		RefPaymentDenominationWindow.clickSaveButton();
		GenericMethods.fnwait(1);
		RefPaymentDisbursement.clickSaveButton();
		if (expenseNumber != null && expenseNumber != "") {
			result = true;
		}
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Expense has been created successfully");

		GenericMethods.fnEndTestCase();
	}

	@Test (enabled = true,priority = 4)
	public void fnVerifyExpenseSavedOrNot() {
		GenericMethods.fnStartTestCase("Verify Expense is saved or not");

		RefExpensePage.createNewExpense(1);
		GenericMethods.fnwait(2);
		String expenseNumber = RefPaymentDisbursement.getExpenseNumber();
		GenericMethods.fnwait(2);
		RefPaymentDisbursement.selectPaymentMode("CASH");
		GenericMethods.fnwait(1);
		RefPaymentDenominationWindow.clickSaveButton();
		GenericMethods.fnwait(1);
		RefPaymentDisbursement.clickSaveButton();
		fnWriteSteps("Pass", "Expense has been created successfully");

		RefExpensePage.fnExpenseSavedOrNot(expenseNumber);
		GenericMethods.fnwait(1);

		GenericMethods.fnEndTestCase();
	}

	@Test (enabled = true,priority = 5)
	public void fnVerifyDueExpenseCreationAndPayment() {
		GenericMethods.fnStartTestCase("Verify Due Expense creation and due expense payment");

		RefExpensePage.createNewExpense(1);
		GenericMethods.fnwait(2);
		String expenseNumber = RefPaymentDisbursement.getExpenseNumber();
		GenericMethods.fnwait(2);
        RefPaymentDisbursement.clickCancelButton();
		GenericMethods.fnwait(1);
		fnWriteSteps("Pass", "Due Expense has been created successfully");
		RefExpensePage.fnSearchExpenseAndCompletePayment(expenseNumber);
        RefPaymentDisbursement.selectPaymentMode("CASH");
		GenericMethods.fnwait(1);
		RefPaymentDenominationWindow.clickSaveButton();
		GenericMethods.fnwait(1);
		RefPaymentDisbursement.clickSaveButton();
		fnWriteSteps("Pass", "Payment for due Expense has been done successfully");
		GenericMethods.fnwait(1);
        GenericMethods.fnEndTestCase();
	}
 */

	@Test 
	public void validate_Expense_Creation_With_Expense_Category_Test() {
		GenericMethods.fnStartTestCase("validate_Expense_Creation_With_Expense_Category_Test");
		log.info("******Expense Category Creation*****");
		int rowindex = 1;
		boolean result = false;
		String strLedge = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 0);
		String strPaymentTo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 1);
		String Category = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 2);
		String strCategoryValue1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 3);
		String stCategoryValue2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 4);
		String Date = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Operating Expenses",
				rowindex, 5);
		String strExpenseAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 6);
		String document = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 7);
		String strDocument = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 8);
		String strExpenseDetails = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 9);
		String strExpenseDate = "NULL";
		String strTax = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 11);
		String strTax1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 12);
		String strTax2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 13);
		String strTax3 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 14);

		String strExpenseVochureDate = "NULL";
		RefExpensePage.clickCloseButton();
		GenericMethods.fnwait(2);
		RefDashboard.ClickExpencePageButton();
		GenericMethods.fnwait(2);
		RefExpensePage.clickNewExpense();
		GenericMethods.fnwait(2);
		RefExpensePage.create_Expense_Vochure(strLedge, strPaymentTo, Category, strCategoryValue1, stCategoryValue2,
				Date, strExpenseDate, strExpenseVochureDate, strExpenseAmount, document, strDocument, strExpenseDetails,
				strTax, strTax1, strTax2, strTax3);
		GenericMethods.fnwait(2);
		String expenseNumber = RefPaymentDisbursement.getExpenseNumber();
		GenericMethods.fnwait(2);
		RefPaymentDisbursement.selectPaymentMode("CASH");
		GenericMethods.fnwait(3);
		RefPaymentDenominationWindow.clickSaveButton();
		GenericMethods.fnwait(1);
		RefPaymentDisbursement.clickSaveButton();
		if (expenseNumber != null && expenseNumber != "") {
			result = true;
		}
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Operating Expenses", rowindex, 10,
				expenseNumber);
		fnWriteSteps("Pass", "Expense has been created successfully");

		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void validate_Expense_Creation_With_Expense_Date_Greater_Than_Expense_Vochure_Date_Test() {
		GenericMethods.fnStartTestCase("validate_Expense_Creation_With_Expense_Date_Greater_Than_Expense_Vochure_Date_Test");
		log.info("********Validating Expense Vochure Creation********");
		String Expense = "Greater";
		String strExpenseDate = "15-Jun-20";
		String strExpenseVochureDate = "11-Jun-20";
		RefExpensePage.clickNewExpense();
		boolean result = RefExpensePage.validate_Expense_Date_Expense_Vochure(Expense, strExpenseDate,
				strExpenseVochureDate);
		Assert.assertFalse(result);
		log.info("Validated Expense Vochure Creation");
		fnWriteSteps("Pass", "Validated Expense Vochure Creation");
		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void validate_Expense_Vochure_Creation_With_Future_Vochure_Date_Test() {
		GenericMethods.fnStartTestCase("validate_Expense_Vochure_Creation_With_Future_Vochure_Date_Test");
		log.info("*******Validate Expense Vochure Creation With Future Date********8");
		String Expense = "Expense Vochure Date";
		String strExpenseDate = "NULL";
		String strExpenseVochureDate = GenericMethods.getPropertyValue("FutureExpenseVochureDate");
		RefExpensePage.clickNewExpense();
		boolean result = RefExpensePage.validate_Expense_Date_Expense_Vochure(Expense.trim(), strExpenseDate,
				strExpenseVochureDate);
		Assert.assertFalse(result);
		log.info("Validated Expense Vochure Creation");
		fnWriteSteps("Pass", "Validated Expense Vochure Creation");
		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void validate_Expense_Date_Greater_Than_Future_Date_Test() {
		GenericMethods.fnStartTestCase("validate_Expense_Date_Greater_Than_Future_Date_Test");
		log.info("*******Validate Expense Vochure Creation With Future Date********8");
		String Expense = "Expense Date";
		String strExpenseDate = GenericMethods.getPropertyValue("FutureExpenseDate");
		String strExpenseVochureDate = "NULL";
		RefExpensePage.clickNewExpense();
		boolean result = RefExpensePage.validate_Expense_Date_Expense_Vochure(Expense.trim(), strExpenseDate,
				strExpenseVochureDate);
		Assert.assertFalse(result);
		log.info("Validated Expense Vochure Creation");
		fnWriteSteps("Pass", "Validated Expense Vochure Creation");
		GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void validate_Expense_Category_Creation_Without_Expense_Category_For_Modification_Test() {
		GenericMethods.fnStartTestCase("validate_Expense_Category_Creation_Without_Expense_Category_For_Modification_Test");
		log.info("***********Expense Category Creation*******");
		int rowindex = 3;
		boolean result = false;
		String strLedge = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 0);
		String strPaymentTo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 1);
		String Category = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 2);
		String strCategoryValue1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 3);
		String stCategoryValue2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 4);
		String Date = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Operating Expenses",
				rowindex, 5);
		String strExpenseAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 6);
		String document = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 7);
		String strDocument = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 8);
		String strExpenseDetails = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 9);
		String strExpenseDate = "NULL";
		String strTax = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 11);
		String strTax1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 12);
		String strTax2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 13);
		String strTax3 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 14);

		String strExpenseVochureDate = "NULL";
		GenericMethods.fnwait(2);
		RefExpensePage.clickNewExpense();
		GenericMethods.fnwait(2);
		RefExpensePage.create_Expense_Vochure(strLedge, strPaymentTo, Category, strCategoryValue1, stCategoryValue2,
				Date, strExpenseDate, strExpenseVochureDate, strExpenseAmount, document, strDocument, strExpenseDetails,
				strTax, strTax1, strTax2, strTax3);
		String expenseNumber = RefPaymentDisbursement.getExpenseNumber();
		GenericMethods.fnwait(1);
		RefExpensePage.clickCloseButton();

		if (!expenseNumber.equals(null) && !expenseNumber.equals("")) {
			result = true;
		}
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Operating Expenses", rowindex, 10,
				expenseNumber);
		fnWriteSteps("Pass", "Expense has been created successfully");

		GenericMethods.fnEndTestCase();

	}
	// Failed TestCase
   @Test 
	public void validate_Expense_Vochure_Modification_By_Selecting_Sub_Category_Test() {
		GenericMethods.fnStartTestCase("validate_Expense_Vochure_Modification_By_Selecting_Sub_Category_Test");
		log.info("******Validate Expense Vochure Modification*****");
		int rowindex = 7;
		boolean result = false;
		String Vochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", 3, 10);
		String document = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 1);
		String strReferenceDocument = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 2);
		String Category = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 3);
		String strCategoryValue1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 4);
		String stCategoryValue2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 5);
		String taxes = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Operating Expenses",
				rowindex, 6);
		String strTaxValue1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 7);
		String strTaxValue2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 8);
		String strTaxValue3 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 9);
		RefEstimationHistory.serachRecord(Vochure);
		RefExpensePage.clickEditButton();
		RefExpensePage.expense_Vochure_Modification(document, strReferenceDocument, Category, strCategoryValue1,
				stCategoryValue2, taxes, strTaxValue1, strTaxValue2, strTaxValue3);
		GenericMethods.fnwait(2);
		RefExpensePage.clickSaveButton();
		GenericMethods.fnwait(2);
		RefExpensePage.clickCancelButton();
		GenericMethods.fnwait(2);
		RefEstimationHistory.serachRecord(Vochure);
		GenericMethods.fnwait(2);
		RefExpensePage.clickEditButton();
		GenericMethods.fnwait(4);
		String expenseSubCategory = driver.findElement(By.id("lookupSubExpenseCategory")).getAttribute("Name");
		if (expenseSubCategory == null || expenseSubCategory == "") {
			result = true;
		}
		Assert.assertTrue(result,"System should not accept Sub Category without selecting Category,Its a Bug");

		log.info("******Validate Expense Vochure Modification*****");
		fnWriteSteps("Pass", "Expense Vochure Modification Validation");
		GenericMethods.fnEndTestCase();
	}
   @Test 
	public void validate_Expense_Vochure_Creation_With_Payment_Full_Due_Test() {
		GenericMethods.fnStartTestCase("validate_Expense_Vochure_Creation_With_Partial_Payment_Test");
		log.info("****Expense Vochure Creation With Partial Payment******");
		int rowindex = 2;
		boolean result = false;
		String strLedge = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 0);
		String strPaymentTo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 1);
		String Category = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 2);
		String strCategoryValue1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 3);
		String stCategoryValue2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 4);
		String Date = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Operating Expenses",
				rowindex, 5);
		String strExpenseAmount = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 6);
		String document = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 7);
		String strDocument = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 8);
		String strExpenseDetails = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 9);
		String strExpenseDate = "NULL";
		String strTax = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 11);
		String strTax1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 12);
		String strTax2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 13);
		String strTax3 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 14);

		String strExpenseVochureDate = "NULL";
		GenericMethods.fnwait(2);
		RefExpensePage.clickNewExpense();
		GenericMethods.fnwait(2);
		RefExpensePage.create_Expense_Vochure(strLedge, strPaymentTo, Category, strCategoryValue1, stCategoryValue2,
				Date, strExpenseDate, strExpenseVochureDate, strExpenseAmount, document, strDocument, strExpenseDetails,
				strTax, strTax1, strTax2, strTax3);
		String expenseNumber = RefPaymentDisbursement.getExpenseNumber();
		GenericMethods.fnwait(1);
		RefExpensePage.clickCloseButton();

		if (!expenseNumber.equals(null) && !expenseNumber.equals("")) {
			result = true;
		}
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Operating Expenses", rowindex, 10,
				expenseNumber);
		fnWriteSteps("Pass", "Expense has been created successfully");

		GenericMethods.fnEndTestCase();

	}
	
   @Test 
	public void validate_Expense_Vochure_Modification_By_Selecting_Document_Taxes_ExpenseAnd_Sub_Category_Test() {
		GenericMethods.fnStartTestCase(
				"validate_Expense_Vochure_Modification_By_Selecting_Document_Taxes_ExpenseAnd_Sub_Category_Test");
		log.info("******Validate Expense Vochure Modification*****");
		int rowindex = 8;
		boolean result = false;
		String Vochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", 2, 10);
		String document = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 1);
		String strReferenceDocument = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 2);
		String Category = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 3);
		String strCategoryValue1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 4);
		String stCategoryValue2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 5);
		String taxes = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Operating Expenses",
				rowindex, 6);
		String strTaxValue1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 7);
		String strTaxValue2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 8);
		String strTaxValue3 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 9);
		RefEstimationHistory.serachRecord(Vochure);
		RefExpensePage.clickEditButton();
		RefExpensePage.expense_Vochure_Modification(document, strReferenceDocument, Category, strCategoryValue1,
				stCategoryValue2, taxes, strTaxValue1, strTaxValue2, strTaxValue3);
		GenericMethods.fnwait(1);
		RefExpensePage.clickSaveButton();
		GenericMethods.fnwait(1);
		RefExpensePage.clickCancelButton();
		GenericMethods.fnwait(1);
		RefEstimationHistory.serachRecord(Vochure);
		GenericMethods.fnwait(1);
		RefExpensePage.clickEditButton();
		GenericMethods.fnwait(4);
		if (driver.findElement(By.id("txtReferenceDocumentNo")).getAttribute("Name").trim()
				.contains(strReferenceDocument.trim())) {
			result = true;
		}

		Assert.assertTrue(result);
		log.info("******Validate Expense Vochure Modification*****");
		fnWriteSteps("Pass", "Expense Vochure Modifcation");
		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void validate_Expense_Vochure_Modification_By_Modifying_Existing_Document_Test() {
		GenericMethods.fnStartTestCase("validate_Expense_Vochure_Modification_By_Modifying_Existing_Test");
		log.info("******Validate Expense Vochure Modification*****");
		int rowindex = 9;
		boolean result = false;
		String Vochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", 2, 10);
		String document = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 1);
		String strReferenceDocument = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 2);
		String Category = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 3);
		String strCategoryValue1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 4);
		String stCategoryValue2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 5);
		String taxes = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Operating Expenses",
				rowindex, 6);
		String strTaxValue1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 7);
		String strTaxValue2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 8);
		String strTaxValue3 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 9);
		RefEstimationHistory.serachRecord(Vochure);
		RefExpensePage.clickEditButton();
		RefExpensePage.expense_Vochure_Modification(document, strReferenceDocument, Category, strCategoryValue1,
				stCategoryValue2, taxes, strTaxValue1, strTaxValue2, strTaxValue3);
		GenericMethods.fnwait(2);
		RefExpensePage.clickSaveButton();
		GenericMethods.fnwait(2);
		RefExpensePage.clickCancelButton();
		GenericMethods.fnwait(2);
		RefEstimationHistory.serachRecord(Vochure);
		GenericMethods.fnwait(2);
		RefExpensePage.clickEditButton();
		GenericMethods.fnwait(10);
		@SuppressWarnings("unused")
		String expenseCategory = driver.findElement(By.id("lookUpEdit")).getAttribute("Name");
		if (driver.findElement(By.id("txtReferenceDocumentNo")).getAttribute("Name").trim()
				.contains(strReferenceDocument.trim())) {
			System.out.println("Second");
			result = true;
		}

		Assert.assertTrue(result);
		log.info("******Validate Expense Vochure Modification*****");
		fnWriteSteps("Pass", "Expense Vochure Modifcation");
		GenericMethods.fnEndTestCase();
	}
/*	@Test
	public void validate_Expense_Voucher_Modification_By_Selecting_Expense_Category_Test() {
		GenericMethods.fnStartTestCase("validate_Expense_Voucher_Modification_By_Selecting_Expense_Category_Test");
		log.info("********Expense Voucher Modification*****");
		int rowindex = 7;
		boolean result = false;
		String Vochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", 3, 10);
		String document = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 1);
		String strReferenceDocument = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 2);
		String Category = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 3);
		String strCategoryValue1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 4);
		String stCategoryValue2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 5);
		String taxes = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Operating Expenses",
				rowindex, 6);
		String strTaxValue1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 7);
		String strTaxValue2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 8);
		String strTaxValue3 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 9);
		RefEstimationHistory.serachRecord(Vochure);
		RefExpensePage.clickEditButton();
		RefExpensePage.expense_Vochure_Modification(document, strReferenceDocument, Category, strCategoryValue1,
				stCategoryValue2, taxes, strTaxValue1, strTaxValue2, strTaxValue3);
		GenericMethods.fnwait(2);
		RefExpensePage.clickSaveButton();
		GenericMethods.fnwait(2);
		RefExpensePage.clickCancelButton();
		GenericMethods.fnwait(2);
		RefEstimationHistory.serachRecord(Vochure);
		GenericMethods.fnwait(2);
		RefExpensePage.clickEditButton();
		GenericMethods.fnwait(4);
		//if(driver.findElement(By.id("lookupExpenseCategory")).getAttribute(""))
	}
*/
	@Test 
	public void validate_Expense_Vochure_Modification_Expense_Date_Greater_Than_Expense_Vochure_Date_Test() {
		GenericMethods.fnStartTestCase("validate_Expense_Vochure_Expense_Date_Greater_Than_Expense_Vochure_Date_Test");
		log.info("******Validate Expense Vochure Modification*****");
		//int rowindex = 9;
		String Vochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", 2,10);
		String Expense = "Greater";
		String strExpenseDate = "20-Jun-20";
		String strExpenseVochureDate = "11-Jun-20";
		RefEstimationHistory.serachRecord(Vochure);
		RefExpensePage.clickEditButton();
		boolean result = RefExpensePage.validate_Expense_Date_Expense_Vochure(Expense, strExpenseDate,
				strExpenseVochureDate);
		Assert.assertFalse(result);
		log.info("******Validate Expense Vochure Modification*****");
		fnWriteSteps("Pass", "Expense Vochure Modification Validation");
		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void validate_Expense_Vochure_Modification_Expense_Date_As_Future_Date_Test() {
		GenericMethods.fnStartTestCase("validate_Expense_Vochure_Expense_Date_As_Future_Date_Test");
		log.info("******Validate Expense Vochure Modification*****");
		//int rowindex = 9;
		String Vochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", 2, 10);
		String Expense = "Expense Date";
		String strExpenseDate = GenericMethods.getPropertyValue("FutureExpenseDate");
		String strExpenseVochureDate = "NULL";
		RefEstimationHistory.serachRecord(Vochure);
		RefExpensePage.clickEditButton();
		boolean result = RefExpensePage.validate_Expense_Date_Expense_Vochure(Expense, strExpenseDate,
				strExpenseVochureDate);
		Assert.assertFalse(result);
		log.info("******Validate Expense Vochure Modification*****");
		fnWriteSteps("Pass", "Expense Vochure Modification Validation");
		GenericMethods.fnEndTestCase();
	}
	

	/*@Test
	public void validate_Expense_Vochure_Modification_Expense_Vochure_Date_As_Future_Date_Test() {
		GenericMethods.fnStartTestCase("validate_Expense_Vochure_Expense_Vochure_Date_As_Future_Date_Test");
		log.info("******Validate Expense Vochure Modification*****");
		int rowindex = 9;
		String Vochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", rowindex, 0);
		String Expense = "Expense Vochure Date";
		String strExpenseDate = "NULL";
		String strExpenseVochureDate = GenericMethods.getPropertyValue("FutureExpenseVochureDate");
		RefEstimationHistory.serachRecord(Vochure);
		RefExpensePage.clickEditButton();
		boolean result = RefExpensePage.validate_Expense_Date_Expense_Vochure(Expense, strExpenseDate,
				strExpenseVochureDate);
		Assert.assertFalse(result);
		log.info("******Validate Expense Vochure Modification*****");
		fnWriteSteps("Pass", "Expense Vochure Modification Validation");
		GenericMethods.fnEndTestCase();
	}*/

	@Test 
	public void validate_Expense_Vochure_Modification_Fully_Paid_Test() {
		GenericMethods.fnStartTestCase("validate_Expense_Vochure_Modification_Fully_Paid_Test");
		log.info("******Expense Vochure Modification Validation*******");
		String Vochure =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", 1, 10);
		RefEstimationHistory.serachRecord(Vochure);
		GenericMethods.fnwait(10);
		boolean result = RefExpensePage.validate_Modification_Edit_Button();
		Assert.assertTrue(result, "Cannot Modify Fully Paid Expense Vochure");
		log.info("******Expense Vochure Modification Validation*******");
		fnWriteSteps("Fail", "Cannot Modify Fully Paid Expense Vochure");
		GenericMethods.fnEndTestCase();

	}

	@Test 
	public void validate_Expense_Vochure_Deletion_Fully_Paid_Test() {
		GenericMethods.fnStartTestCase("validate_Expense_Vochure_Deletion_Fully_Paid_Test");
		log.info("*******Expense Vochure Deletion Fully Paid********");
		String Vochure =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", 1, 10);
		String remarks = "Fully Paid";
		boolean result = RefExpensePage.delete_Vochure(Vochure, remarks);
		GenericMethods.fnwait(5);
		Assert.assertTrue(result);
		log.info("*******Expense Vochure Deletion Fully Paid********");
		fnWriteSteps("Pass", "Expense Vochure Successfully Deleted");
		GenericMethods.fnEndTestCase();

	}

	@Test 
	public void validate_Expense_Vochure_Deletion_Fully_Due_Test() {
		GenericMethods.fnStartTestCase("validate_Expense_Vochure_Deletion_Fully_Due_Test");
		log.info("*******Expense Vochure Deletion*******");
		String Vochure =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Operating Expenses", 2, 10);
		String remarks = "Fully Due";
		boolean result = RefExpensePage.delete_Vochure(Vochure, remarks);
		GenericMethods.fnwait(5);
		Assert.assertTrue(result);
		log.info("*******Expense Vochure Deletion Fully Paid********");
		fnWriteSteps("Pass", "Expense Vochure Successfully Deleted");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Expense_Vochure_Deletion_Without_Internet_Test() {
		GenericMethods.fnStartTestCase("validate_Expense_Vochure_Deletion_Without_Internet_Test");
		log.info("*******Expnese Vochure Deletion Without Internet*******");
		String Vochure = GenericMethods.getPropertyValue("FullyDueExpenseVochure");
		String remarks = "Without Internet";
		RefExpensePage.delete_Vochure(Vochure, remarks);
		GenericMethods.fnwait(5);
		String txtValidate = "Please check the internet connection";
		boolean result = refOrderPage.validate_Sales_Invoice_Hold(txtValidate);
		RefExpensePage.clickCloseButton();
		Assert.assertTrue(result);
		log.info("*******Expnese Vochure Deletion Without Internet*******");
		fnWriteSteps("Pass", "Validated Expense Vochure Without Internet");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Expense_Vochure_Deletion_Partial_Due_Test() {
		GenericMethods.fnStartTestCase("validate_Expense_Vochure_Deletion_Partial_Due_Test");
		log.info("*******Expense Vochure Deletion*******");
		String Vochure = GenericMethods.getPropertyValue("FullyDueExpenseVochure");
		String remarks = "Partial Due";
		boolean result = RefExpensePage.delete_Vochure(Vochure, remarks);
		GenericMethods.fnwait(5);
		Assert.assertTrue(result);
		log.info("*******Expense Vochure Deletion Fully Paid********");
		fnWriteSteps("Pass", "Expense Vochure Successfully Deleted");
		GenericMethods.fnEndTestCase();
	}

	@AfterMethod
	public void fn_Close_InvoiceScreen_And_Logout() {

		RefExpensePage.clickCloseButton();
		RefDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		RefMessageBoxEffia.ExitApplication_Yes();
		GenericMethods.fnwait(1);
	}

	@AfterClass
	public void fnAfterClass_Close_Application() {

		GenericMethods.fnwait(2);
		RefLogin.ClickCloseButton();
	}

}
