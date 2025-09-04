package JBWindows_Transactions;

import java.awt.AWTException;
import org.apache.log4j.xml.DOMConfigurator;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows.Transactions.Trans_Estimation;
import JBWindows.Transactions.Trans_Order_Page;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;
import org.apache.log4j.Logger;


public class BatchNo_Generation_With_Estimation extends BaseClass{
	
    Logger log = Logger.getLogger(BatchNo_Generation_With_Estimation.class);

	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	Trans_Estimation refEstimation;
	MessageBoxEffia RefMessgBox;
    Trans_Order_Page refOrderPage;
	
	
	public BatchNo_Generation_With_Estimation() {
		super();
	}

	@BeforeClass
	public void initializingWindows() {
		DOMConfigurator.configure("log4j.xml");
		RefLogin = new Login(driver);
		RefDashboard = new APP_Dashboard(driver);
		RefMenu = new APP_Menu(driver);
		refEstimation=new Trans_Estimation();
		RefMessgBox=new MessageBoxEffia(driver);
		refOrderPage = new Trans_Order_Page();
	}
	@AfterClass
	public void terminatingBrowser() {
		GenericMethods.fnwait(8);		
		RefLogin.ClickCloseButton();
	}
	
	@BeforeMethod
	public void setUp() {
		GenericMethods.fnwait(30);
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(3);
		RefDashboard.clickMenuBtn();
		RefMenu.OpenPage("estimation");
		
	}

    @AfterMethod
    public void tearDown() {
    refEstimation.click_On_DashBoard();
	GenericMethods.fnwait(2);
	RefDashboard.logoutwithoutmenu();
	GenericMethods.fnwait(1);
	RefMessgBox.ExitApplication_Yes();
	GenericMethods.fnwait(1);
	}
    @Test 
    public void validate_Estimation_Creation_with_a_product_Managed_by_Batch_Number() throws AWTException {
	GenericMethods.fnStartTestCase("validate Estimation Creation with a product Managed by Batch Number");
	log.info("Estimation Creation with a product Managed by Batch Number");
	int rowINdex=64;
	String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,0);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String strCustomer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,3);
	String Customertype=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,4);;
	String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,5);;
	String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,6);;
	String EstimationVochure=refEstimation.estimation_Creation_Page(strSalesOrderType, strProduct, field,
			strCustomer, Customertype, strFirstName, strPhoneNo);
	boolean actual=refEstimation.validate_Estimation_Creation(EstimationVochure);
	AssertJUnit.assertTrue(actual);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,7,EstimationVochure);	
	log.info("EStimation is created successfully with a product Managed by Batch Number");
	fnWriteSteps("Pass", "Successfully created EStimation with a product Managed by Batch Number");
}
    @Test 
    public void Select_BatchNo_while_converting_quotation_to_Invoice_with_a_product_managed_by_BatchNo() throws FindFailed {
    	GenericMethods.fnStartTestCase("Select BatchNo while converting quotation to Invoice with a product managed by BatchNo");
    	log.info("Select BatchNo while converting quotation to Invoice with a product managed by BatchNo");
    	int rowindex=64;
    	String strEstimationVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowindex,7);
    	String Quantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations", rowindex,8);
    	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations", rowindex,9);
    	String ConvertionFor=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations", rowindex,11);
        refEstimation.BatchNo_Selection_while_Estimation_To_Invoice_Convertion(strEstimationVochure,ConvertionFor);
    	refOrderPage.Select_BatchNo();
		refOrderPage.BatchNo_Selection(Quantity);
	    refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_OK_Button();
		refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_Header_Button();
		refOrderPage.send_Instructions(strInstructions);
		refOrderPage.Click_On_Payment_Cash();
		refOrderPage.click_Finish_Button();
		refOrderPage.click_Header_Button();
    	boolean result=refEstimation.validate_Estimation_Conversion(strEstimationVochure);
    	Assert.assertTrue(result);
       log.info("Successfully validated Selected BatchNo while converting quotation to Invoice with a product managed by BatchNo");
    	fnWriteSteps("Pass","Invoice is created successfully");
    	GenericMethods.fnEndTestCase();
    }
    @Test 
    public void validate_Partial_Estimation_Creation_with_a_combination_of_Managed_by_BatchNo_and_Not_Managed_by_BatchNo_products() throws AWTException {
	GenericMethods.fnStartTestCase("validate Partial Estimation Creation with a combination of Managed by BatchNo and Not Managed by BatchNo products");
	log.info("Partial Estimation Creation with a combination of Managed by BatchNo and Not Managed by BatchNo products");
	int rowINdex=65;
	String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,0);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String strCustomer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,3);
	String Customertype=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,4);
	String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,5);
	String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,6);
	String strProduct1=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,10);
	refOrderPage.enter_Product_Details(strProduct1);
	String EstimationVochure=refEstimation.estimation_Creation_Page(strSalesOrderType, strProduct, field,
			strCustomer, Customertype, strFirstName, strPhoneNo);
	boolean actual=refEstimation.validate_Estimation_Creation(EstimationVochure);
	AssertJUnit.assertTrue(actual);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,7,EstimationVochure);	
	log.info("Partial EStimation is created successfully with a combination of Managed by BatchNo and Not Managed by BatchNo products");
	fnWriteSteps("Pass", "Successfully created Partial EStimation with a combination of Managed by BatchNo and Not Managed by BatchNo products");
}
    @Test 
    public void Select_BatchNo_while_partially_converting_quotation_to_Invoice_with_a_product_managed_by_BatchNo() throws FindFailed {
    	GenericMethods.fnStartTestCase("Select BatchNo while partially converting quotation to Invoice with a product managed by BatchNo");
    	log.info("Select BatchNo while partially converting quotation to Invoice with a product managed by BatchNo");
    	int rowindex=65;
    	String strEstimationVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowindex,7);
    	String Quantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations", rowindex,8);
    	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations", rowindex,9);
    	String ConvertionFor=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations", rowindex,11);
        refEstimation.BatchNo_Selection_while_Estimation_To_Invoice_Convertion(strEstimationVochure,ConvertionFor);
    	refOrderPage.Select_BatchNo();
		refOrderPage.BatchNo_Selection(Quantity);
	    refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_OK_Button();
		refOrderPage.click_On_SAVE_Button();
		refOrderPage.click_Header_Button();
		refOrderPage.send_Instructions(strInstructions);
		refOrderPage.Click_On_Payment_Cash();
		refOrderPage.click_Finish_Button();
		refOrderPage.click_Header_Button();
    	boolean result=refEstimation.validate_Estimation_Conversion(strEstimationVochure);
    	Assert.assertTrue(result);
       log.info("Successfully validated Selected BatchNo while partially converting quotation to Invoice with a product managed by BatchNo");
    	fnWriteSteps("Pass","Invoice is created successfully");
    	GenericMethods.fnEndTestCase();
    }
}

