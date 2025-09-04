package JBWindows_Configurations;

import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.Configurations.SalesConfigurations;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class SalesConfiguration_Test extends BaseClass {
	
	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	SalesConfigurations refSalesConfiguration;
	MessageBoxEffia refMessageBoxEffia;

	public SalesConfiguration_Test() {
		super();
	}				

	@BeforeMethod
	public void fn_Login_and_Open_Page() throws InterruptedException, FindFailed {

		refLogin = new Login(driver);
		refDashboard = new APP_Dashboard(driver);
		refMenu = new APP_Menu(driver);
		refSalesConfiguration = new SalesConfigurations();
		refMessageBoxEffia = new MessageBoxEffia(driver);

		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		refLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(10);
		refDashboard.clickMenuBtn();
        GenericMethods.fnwait(3);
       //fnWriteSteps("Pass", "Application Open Successfully" );
		GenericMethods.fnEndTestCase();

      } 
	@Test 
	public void OrderCreation_with_SalesOrdertype_as_HomeDelivery() {
		GenericMethods.fnStartTestCase("OrderCreation with SalesOrdertype as HomeDelivery");
		refMenu.OpenPage("application settings");
	    String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="Sales_Configuration";
	    int RowNumber = 1;
	    String Salesordertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    refSalesConfiguration.fnSalesConfiguration(Salesordertype);
	    refMenu.OpenPage("order");
	    boolean result = refSalesConfiguration.Verify_SalesOrderType_as_HomeDeliveryMode_or_not();
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "OrderCreation with SalesOrdertype as HomeDelivery Valid Successfully");
		GenericMethods.fnEndTestCase();
	}
	
	  @Test 
	   public void EstimationConversion_with_SalesOrdertype_as_HomeDelivery() {
		GenericMethods.fnStartTestCase("EstimationConversion with SalesOrdertype as HomeDelivery");
		String StrExcelPath = ApplicationVariables.JBCONFIGURATIONEXCELPATH;
	    String StrSheetName ="Sales_Configuration";
	    int RowNumber = 1;
	    String SelectedCustomer = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String strProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String Instruction = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    refMenu.OpenPage("estimation");
	    boolean result = refSalesConfiguration.EstimationConversion_with_HomeDeliveryMode(SelectedCustomer,strProduct,Area,Instruction);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "EstimationConversion with SalesOrdertype as HomeDelivery Valid Successfully");
		GenericMethods.fnEndTestCase();
	}
	  
	@AfterMethod
	public void fnAfterMethod() {
		GenericMethods.fnStartTestCase("fnAfterMethod");
		refDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		refMessageBoxEffia.ExitApplication_Yes();
		GenericMethods.fnwait(5);
		refLogin.ClickCloseButton();
		fnWriteSteps("Pass", "Application Close Successfully");
		GenericMethods.fnEndTestCase();
	}

}
