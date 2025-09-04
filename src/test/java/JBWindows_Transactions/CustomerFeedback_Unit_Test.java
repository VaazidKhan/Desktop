package JBWindows_Transactions;
import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows.Transactions.CustomerFeedback_Page;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class CustomerFeedback_Unit_Test extends BaseClass {
	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	CustomerFeedback_Page refCustomerFeedback;
	MessageBoxEffia refMessageBoxEffia;

	public CustomerFeedback_Unit_Test() {
		super();
	}


	@BeforeMethod
	public void fn_Login_and_Open_Page() throws InterruptedException, FindFailed {
		DOMConfigurator.configure("log4j.xml");
		refLogin = new Login(driver);
		refDashboard = new APP_Dashboard(driver);
		refMenu = new APP_Menu(driver);
		refCustomerFeedback = new CustomerFeedback_Page();
		refMessageBoxEffia = new MessageBoxEffia(driver);

		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		refLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(10);
		refDashboard.clickMenuBtn();
        GenericMethods.fnwait(3);
        refMenu.OpenPage("Customer feedback");
		GenericMethods.fnwait(1);
	}
	@Test 
	public void fnVerifyFieldVisibility_FieldEnabledorNot() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of CustomerFeedback add entry are present/Enable or not ");

		refCustomerFeedback.VerifyFieldVisibility_FieldEnabledorNot();
		GenericMethods.fnEndTestCase();
	} 
	@Test 
	public void fnCustomerFeedback() {
		GenericMethods.fnStartTestCase("Customer Feedback");
		String StrExcelPath = ApplicationVariables.JBTRANSACTIONEXCELPATH;
	    String StrSheetName ="Feed Back";
	    int RowNumber =1;
	    String  Customer = ExcelUtils.fnGetExcelCellValue(StrExcelPath.trim(),StrSheetName, RowNumber,0);
	    String  FeedbackDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath.trim(), StrSheetName.trim(), RowNumber,1);
	    String  FeedbackDescription = ExcelUtils.fnGetExcelCellValue(StrExcelPath.trim(), StrSheetName.trim(), RowNumber,2);
	    refCustomerFeedback.CreateCustomerFeedback(Customer,FeedbackDate,FeedbackDescription);
	    boolean result = refCustomerFeedback.Verify_CustomerFeedback_SaveorNot(Customer);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "CustomerFeedback has been Saved");
	    GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnCustomerFeedbackEdit() {
		GenericMethods.fnStartTestCase("Customer Feedback Edit");
		String StrExcelPath = ApplicationVariables.JBTRANSACTIONEXCELPATH;
	    String StrSheetName ="Feed Back";
	    int RowNumber = 2;
	    String  OldCustomer = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String  FeedbackDescription = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    refCustomerFeedback.VerifyCustomerFeedbackEdit(OldCustomer,FeedbackDescription);
	    
	}
		
	@AfterMethod
	public void fnAfterMethod() {

		refCustomerFeedback.clickCloseButton();
		GenericMethods.fnwait(2);
		refDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		refMessageBoxEffia.ExitApplication_Yes();
		GenericMethods.fnwait(5);
		refLogin.ClickCloseButton();
	}

}


