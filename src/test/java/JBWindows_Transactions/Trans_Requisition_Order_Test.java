package JBWindows_Transactions;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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


public class Trans_Requisition_Order_Test extends BaseClass {
    Logger log = Logger.getLogger(Trans_Requisition_Order_Test.class);


	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;	
	MessageBoxEffia RefMessageBoxEffia;
	FRM_OperatingExpenses RefExpensePage;
	FRM_PaymentDisbursement RefPaymentDisbursement;
	FRM_PaymentNotes RefPaymentDenominationWindow;
	SAL_DocumentHistory RefEstimationHistory;
	Trans_Order_Page refOrderPage;
	
	public Trans_Requisition_Order_Test() {
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
		RefEstimationHistory=new SAL_DocumentHistory();
		refOrderPage = new Trans_Order_Page();
	}
	
	@BeforeMethod
	public void fn_Login_and_Open_Page() throws FindFailed{
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(2);
		//RefDashboard.activatePage();
		GenericMethods.fnwait(35);
		RefDashboard.clickMenuBtn();
		GenericMethods.fnwait(2);
	
			   Screen screen=new Screen();
			   Pattern pattern;
			   pattern=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Arrow Down.PNG");
			   screen.click(pattern);
			   GenericMethods.fnwait(1);
			   screen.click(pattern);
			   GenericMethods.fnwait(1);
			   screen.click(pattern);
			   GenericMethods.fnwait(2);
			   screen.click(pattern);
			   GenericMethods.fnwait(2);
			   screen.click(pattern);
			   pattern=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Requisition Order.PNG");
			   screen.click(pattern);
			   GenericMethods.fnwait(2);
			   
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

	
	@Test 
	public void validate_Requisition_Order_Creation_Test() {
		GenericMethods.fnStartTestCase("validate_Requisition_Order_Creation_Test");
		log.info("*******Requisition Order Creation******");
		boolean result=false;
		int rowindex=2;
		String RequestBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Requisition Order", rowindex, 0);
		String Product = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Requisition Order",
				rowindex, 1);
		RefExpensePage.clickNewExpense();
		RefExpensePage.enter_Request_Branch(RequestBranch);
		RefExpensePage.fnSearchExpenseAndCompletePayment(Product);
		String Vochure = refOrderPage.get_Vochure_Page();
		String RequisitionVochure = Vochure.split(" ")[6];
		if(RequisitionVochure!=null && RequisitionVochure!="") {
			result=true;
		}
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Requisition Order", rowindex, 2, RequisitionVochure.trim());
		log.info("*******Requisition Order Creation******");
		fnWriteSteps("Pass", "Requisition Ordre Creation");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
		public void validate_Requisition_Order_Creation_With_Inactive_Product_Test() {
		GenericMethods.fnStartTestCase("validate_Requisstion_Order_Creation_Without_Product_Mapping_Test");
		log.info("*******Validate Requisition Order Creation*******");
		int rowindex=3;
		String RequestBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Requisition Order", rowindex, 0);
		String Product = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Requisition Order",
				rowindex, 1);
		RefExpensePage.clickNewExpense();
		GenericMethods.fnwait(2);
		RefExpensePage.enter_Request_Branch(RequestBranch);
		GenericMethods.fnwait(2);
		RefExpensePage.fnSearchExpenseAndCompletePayment(Product);
		GenericMethods.fnwait(2);
		String txtValidate="No product found.";
		boolean result=refOrderPage.validate_Sales_Invoice_Hold(txtValidate);
		GenericMethods.fnwait(2);
		RefExpensePage.ProductSearchClear();
		driver.findElement(By.id("btnCancel")).click();
		Assert.assertTrue(result,"Cannot Create Requisition Order");
		log.info("*******Validate Requisition Order Creation*******");
		fnWriteSteps("Pass", "Cannot Create requisition Order With Inactive Product");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void validate_Requisition_Order_Creation_Without_Mapping_Product_To_Request_Branch_Test() {
		GenericMethods.fnStartTestCase("validate_Requisition_Order_Creation_Without_Mapping_Product_To_Request_Branch_Test");
		log.info("*******Validate Requisition Order Creation******");
		boolean result=false;
		int rowindex=4;
		String RequestBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Requisition Order", rowindex, 0);
		String Product = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Requisition Order",
				rowindex, 1);
		RefExpensePage.clickNewExpense();
		RefExpensePage.enter_Request_Branch(RequestBranch);
		RefExpensePage.fnSearchExpenseAndCompletePayment(Product);
		String Vochure = refOrderPage.get_Vochure_Page();
		String RequisitionVochure = Vochure.split(" ")[6];
		if(RequisitionVochure!=null && RequisitionVochure!="") {
			result=true;
		}
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Requisition Order", rowindex, 2, RequisitionVochure.trim());
		log.info("*******Validate Requisition Order Creation******");
		fnWriteSteps("Pass", "Cannot Create Requisition Order Without Product Mapping");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Requisition_Order_Deletion_Current_Device_Test() {
		GenericMethods.fnStartTestCase("validate_Requisition_Order_Deletion_Current_Device_Test");
		log.info("*****Requisition Order Deletion****");
		String RequisitionVochure= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Requisition Order",
				2, 2);
		String Remarks="Current Device";
		RefEstimationHistory.serachRecord(RequisitionVochure);
		RefExpensePage.click_Delete_Button();
	    refOrderPage.click_Header_Button();
	    boolean result=	RefExpensePage.send_Remarks(Remarks);
		Assert.assertTrue(result);
		log.info("******Requisition Order Deletion******");
		fnWriteSteps("Pass","Requisition Order Deletion");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void validate_Requisition_Order_Deletion_BackOffice_Test() {
		GenericMethods.fnStartTestCase("validate_Requisition_Order_Deletion_BackOffice_Test");
		log.info("*****Requisition Order Deletion****");
		String RequisitionVochure=GenericMethods.getPropertyValue("RequisitionBackOffice");
		String Remarks="Current Device";
		RefEstimationHistory.serachRecord(RequisitionVochure);
		RefExpensePage.click_Delete_Button();
		refOrderPage.click_Header_Button();
	    boolean result=	RefExpensePage.send_Remarks(Remarks);
		Assert.assertTrue(result);
		log.info("******Requisition Order Deletion******");
		fnWriteSteps("Pass","Requisition Order Deletion");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Requisition_Order_Creation_Quantity_Greater_Test() {
		GenericMethods.fnStartTestCase("validate_Requisition_Order_Creation_Quantity_Greater_Test");
		log.info("******Requisition Order Creation With Greater Quantity ********");
		boolean result=false;
		int rowindex=5;
		String RequestBranch = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Requisition Order", rowindex, 0);
		String Product = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Requisition Order",
				rowindex, 1);
		RefExpensePage.clickNewExpense();
		RefExpensePage.enter_Request_Branch(RequestBranch);
		WebElement Searchbox=driver.findElement(By.id("txtSearch"));
		Searchbox.sendKeys(Product);
		Searchbox.submit();
		RefExpensePage.fnSearchExpenseAndCompletePayment(Product);
		String Vochure = refOrderPage.get_Vochure_Page();
	    String RequisitionVochure = Vochure.split(" ")[6];
		if(RequisitionVochure!=null && RequisitionVochure!="") {
			result=true;
		}
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Requisition Order", rowindex, 2, RequisitionVochure.trim());
		log.info("*******Requisition Order Creation******");
		fnWriteSteps("Pass", "Requisition Ordre Creation");
		GenericMethods.fnEndTestCase();
	}
	
	
}
