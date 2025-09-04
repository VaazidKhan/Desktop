package JBWindows_Transactions;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
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
import JBWindows.SAL.SAL_DocumentHistory;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows.Transactions.Trans_Estimation;
import JBWindows.Transactions.Trans_Estimation_History_Page;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;


public class StandardEstimationCreation_Test extends BaseClass{
    Logger log = Logger.getLogger(Trans_Estimation.class);

	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	Trans_Estimation refEstimation;
	MessageBoxEffia RefMessgBox;
	Trans_Estimation_History_Page refEStimationHistory;
	SAL_DocumentHistory RefEstimationHistory;
	
	
	public StandardEstimationCreation_Test() {
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
		refEStimationHistory=new Trans_Estimation_History_Page();
		RefEstimationHistory = new SAL_DocumentHistory();
	}
	@AfterClass
	public void terminatingBrowser() {
		GenericMethods.fnwait(1);		
		RefLogin.ClickCloseButton();
	}
	
	@BeforeMethod
	public void setUp() {
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
public void validate_EStimationCreation_WithoutCustomer() throws AWTException {
	GenericMethods.fnStartTestCase("validate_EStimationCreation_WithoutCustomer");
	log.info("Estimation Creation without Customer");
	int rowINdex=1;
    String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,0);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String field="";
	String strCustomer="NULL";
	String Customertype="NULL";
	String strFirstName="NULL";
	String strPhoneNo="NULL";
	String EstimationVochure=refEstimation.estimation_Creation_Page(strSalesOrderType, strProduct, field,
			strCustomer, Customertype, strFirstName, strPhoneNo);
	boolean actual=refEstimation.validate_Estimation_Creation(EstimationVochure);
	AssertJUnit.assertTrue(actual);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,7,EstimationVochure);	
	log.info("EStimation is created successfully without customer");
	fnWriteSteps("Pass", "Successfully created EStimation with customer");
	GenericMethods.fnEndTestCase();	
}
@Test 
public void validate_Estimation_Creation_Without_Customer_For_Order_Conversion_Test() throws AWTException {
	GenericMethods.fnStartTestCase("validate_Estimation_Creation_Without_Customer_For_Order_Conversion_Test");
	log.info("Estimation Creation without Customer");
	int rowINdex=48;
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
	log.info("EStimation is created successfully without customer");
	fnWriteSteps("Pass", "Successfully created EStimation with customer");
	GenericMethods.fnEndTestCase();	
}
@Test 
public void validate_Estimation_Creation_Without_Custoner_For_Invoice_Conversion_Test() throws AWTException {
	GenericMethods.fnStartTestCase("validate_Estimation_Creation_Without_Custoner_For_Invoice_Conversion_Test");
	log.info("Estimation Creation without Customer");
	int rowINdex=49;
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
	log.info("EStimation is created successfully without customer");
	fnWriteSteps("Pass", "Successfully created EStimation with customer");
}
@Test 
public void validate_EstimationCreation_With_RunTimeCustomer_B2B_Test() throws AWTException {
	GenericMethods.fnStartTestCase("validate_EstimationCreation_With_RunTimeCustomer_B2B_Test");
	log.info("Estimation Creation with Runtime B2B Customer");
	int rowINdex=2;
	String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,0);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String strCustomer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,3);
	String Customertype=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,4);;
	String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,5);;
	String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,6);;
	String EstimationVochure=refEstimation.estimation_Creation_Page(strSalesOrderType, strProduct, field,
			strCustomer, Customertype, strFirstName, strPhoneNo);
	log.info("Estimation is Created Successfully for Runtime B2B Customer");
	boolean result=refEstimation.validate_Estimation_Creation(EstimationVochure);
	AssertJUnit.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,7,EstimationVochure);
	log.info("Estimation is successfully validated to created RunTime B2B Customer");
	fnWriteSteps("Pass","Estimation is Successfully Created for RunTime B2B Customer");
	GenericMethods.fnEndTestCase();
	
	
}
@Test 
public void validate_EstimationCreation_With_RunTimeCustomer_B2C_Test() throws AWTException {
	GenericMethods.fnStartTestCase("validate_EstimationCreation_With_RunTimeCustomer_B2C_Test");
	log.info("Estimation Creation with Runtime B2C Customer");
	int rowINdex=3;
	String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,0);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String strCustomer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,3);
	String Customertype=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,4);;
	String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,5);;
	String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,6);;
	String EstimationVochure=refEstimation.estimation_Creation_Page(strSalesOrderType, strProduct, field,
			strCustomer, Customertype, strFirstName, strPhoneNo);
	log.info("Estimation is Created Successfully for Runtime B2C Customer");
	boolean result=refEstimation.validate_Estimation_Creation(EstimationVochure);
	AssertJUnit.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,7,EstimationVochure);
	log.info("Estimation is successfully validated to created RunTime B2C Customer");
	fnWriteSteps("Pass","Estimation is Successfully Created for RunTime B2C Customer");
}
@Test 
public void validate_EstimationCreation_With_ExistingCustomer_B2B_Test() throws AWTException {
	GenericMethods.fnStartTestCase("validate_EstimationCreation_With_ExistingCustomer_B2B_Test");
	log.info("EstimationCreation_With_ExistingCustomer_B2B Customer");
	int rowINdex=4;
	String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,0);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String strCustomer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,3);
	String Customertype=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,4);;
	String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,5);;
	String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,6);;
	String EstimationVochure=refEstimation.estimation_Creation_Page(strSalesOrderType, strProduct, field,
			strCustomer, Customertype, strFirstName, strPhoneNo);
	log.info("Estimation is Created Successfully forExisting  B2B Customer");
	boolean result=refEstimation.validate_Estimation_Creation(EstimationVochure);
	AssertJUnit.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,7,EstimationVochure);
	log.info("Estimation is successfully validated to created Existing B2B Customer");
	fnWriteSteps("Pass","Estimation is Successfully Created for Existing B2B Customer");
	
}
@Test 
public void validate_EstimationCreatin_With_ExistingCustomer_B2C_Test() throws AWTException {
	GenericMethods.fnStartTestCase("validate_EstimationCreation_With_ExistingCustomer_B2C_Test");
	log.info("EstimationCreation_With_ExistingCustomer_B2C Customer");
	int rowINdex=5;
	String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,0);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String strCustomer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,3);
	String Customertype=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,4);;
	String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,5);;
	String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,6);;
	String EstimationVochure=refEstimation.estimation_Creation_Page(strSalesOrderType, strProduct, field,
			strCustomer, Customertype, strFirstName, strPhoneNo);
	log.info("Estimation is Created Successfully forExisting  B2C Customer");
	boolean result=refEstimation.validate_Estimation_Creation(EstimationVochure);
	AssertJUnit.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,7,EstimationVochure);
	log.info("Estimation is successfully validated to created Existing B2C Customer");
	fnWriteSteps("Pass","Estimation is Successfully Created for Existing B2C Customer");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Estimation_Creation_With_Runtime_B2C_For_Invoice_Test() throws AWTException {
	GenericMethods.fnStartTestCase("validate_Estimation_Creation_With_Runtime_B2B_For_Invoice_Test");
	log.info("Estimation Creation with Runtime B2B Customer");
	int rowINdex=40;
	String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,0);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String strCustomer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,3);
	String Customertype=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,4);;
	String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,5);;
	String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,6);;
	String EstimationVochure=refEstimation.estimation_Creation_Page(strSalesOrderType, strProduct, field,
			strCustomer, Customertype, strFirstName, strPhoneNo);
	log.info("Estimation is Created Successfully for Runtime B2B Customer");
	boolean result=refEstimation.validate_Estimation_Creation(EstimationVochure);
	AssertJUnit.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,7,EstimationVochure);
	log.info("Estimation is successfully validated to created RunTime B2B Customer");
	fnWriteSteps("Pass","Estimation is Successfully Created for RunTime B2B Customer");
	GenericMethods.fnEndTestCase();
	
}
@Test 
public void validate_Estimation_Creation_With_Runtime_B2B_For_Invoice_Test() throws AWTException {
	GenericMethods.fnStartTestCase("validate_Estimation_Creation_With_Runtime_B2C_For_Invoice_Test");
	log.info("Estimation Creation with Runtime B2B Customer");
	int rowINdex=41;
	String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,0);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String strCustomer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,3);
	String Customertype=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,4);;
	String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,5);;
	String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,6);;
	String EstimationVochure=refEstimation.estimation_Creation_Page(strSalesOrderType, strProduct, field,
			strCustomer, Customertype, strFirstName, strPhoneNo);
	log.info("Estimation is Created Successfully for Runtime B2B Customer");
	boolean result=refEstimation.validate_Estimation_Creation(EstimationVochure);
	AssertJUnit.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,7,EstimationVochure);
	log.info("Estimation is successfully validated to created RunTime B2B Customer");
	fnWriteSteps("Pass","Estimation is Successfully Created for RunTime B2B Customer");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Etimation_Creation_With_Existing_B2C_For_Invoice_Test() throws AWTException {
	GenericMethods.fnStartTestCase("validate_Etimation_Creation_With_Existing_B2C_For_Invoice_Test");
	log.info("EstimationCreation_With_ExistingCustomer_B2C Customer");
	int rowINdex=42;
	String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,0);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String strCustomer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,3);
	String Customertype=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,4);;
	String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,5);;
	String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,6);;
	String EstimationVochure=refEstimation.estimation_Creation_Page(strSalesOrderType, strProduct, field,
			strCustomer, Customertype, strFirstName, strPhoneNo);
	log.info("Estimation is Created Successfully forExisting  B2C Customer");
	boolean result=refEstimation.validate_Estimation_Creation(EstimationVochure);
	AssertJUnit.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,7,EstimationVochure);
	log.info("Estimation is successfully validated to created Existing B2C Customer");
	fnWriteSteps("Pass","Estimation is Successfully Created for Existing B2C Customer");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Estimation_Creation_With_Existing_B2B_For_Invoice_Test() throws AWTException {
	GenericMethods.fnStartTestCase("validate_Estimation_Creation_With_Existing_B2B_For_Invoice_Test");
	log.info("EstimationCreation_With_ExistingCustomer_B2C Customer");
	int rowINdex=43;
	String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,0);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String strCustomer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,3);
	String Customertype=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,4);;
	String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,5);;
	String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,6);;
	String EstimationVochure=refEstimation.estimation_Creation_Page(strSalesOrderType, strProduct, field,
			strCustomer, Customertype, strFirstName, strPhoneNo);
	log.info("Estimation is Created Successfully forExisting  B2C Customer");
	boolean result=refEstimation.validate_Estimation_Creation(EstimationVochure);
	AssertJUnit.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,7,EstimationVochure);
	log.info("Estimation is successfully validated to created Existing B2C Customer");
	fnWriteSteps("Pass","Estimation is Successfully Created for Existing B2C Customer");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Estimation_Creation_With_RunTime_B2C_For_Order_Test() throws AWTException {
	GenericMethods.fnStartTestCase("validate_Estimation_Creation_With_RunTime_B2C_For_Deletion_Test");
	log.info("Estimation Creation with Runtime B2B Customer");
	int rowINdex=44;
	String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,0);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String strCustomer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,3);
	String Customertype=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,4);;
	String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,5);;
	String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,6);;
	String EstimationVochure=refEstimation.estimation_Creation_Page(strSalesOrderType, strProduct, field,
			strCustomer, Customertype, strFirstName, strPhoneNo);
	log.info("Estimation is Created Successfully for Runtime B2B Customer");
	boolean result=refEstimation.validate_Estimation_Creation(EstimationVochure);
	AssertJUnit.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,7,EstimationVochure);
	log.info("Estimation is successfully validated to created RunTime B2B Customer");
	fnWriteSteps("Pass","Estimation is Successfully Created for RunTime B2B Customer");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Estimation_Creation_With_Runtime_B2B_For_Order_Test() throws AWTException {
	GenericMethods.fnStartTestCase("validate_Estimation_Creation_With_Runtime_B2B_For_Deletion_Test");
	log.info("Estimation Creation with Runtime B2B Customer");
	int rowINdex=45;
	String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,0);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String strCustomer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,3);
	String Customertype=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,4);;
	String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,5);;
	String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,6);;
	String EstimationVochure=refEstimation.estimation_Creation_Page(strSalesOrderType, strProduct, field,
			strCustomer, Customertype, strFirstName, strPhoneNo);
	log.info("Estimation is Created Successfully for Runtime B2B Customer");
	boolean result=refEstimation.validate_Estimation_Creation(EstimationVochure);
	AssertJUnit.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,7,EstimationVochure);
	log.info("Estimation is successfully validated to created RunTime B2B Customer");
	fnWriteSteps("Pass","Estimation is Successfully Created for RunTime B2B Customer");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Estimation_Creation_With_Existing_B2C_For_Order_Test() throws AWTException {
	GenericMethods.fnStartTestCase("validate_Estimation_Creation_With_Existing_B2C_For_Deletion_Test");
	log.info("EstimationCreation_With_ExistingCustomer_B2C Customer");
	int rowINdex=46;
	String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,0);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String strCustomer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,3);
	String Customertype=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,4);;
	String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,5);;
	String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,6);;
	String EstimationVochure=refEstimation.estimation_Creation_Page(strSalesOrderType, strProduct, field,
			strCustomer, Customertype, strFirstName, strPhoneNo);
	log.info("Estimation is Created Successfully forExisting  B2C Customer");
	boolean result=refEstimation.validate_Estimation_Creation(EstimationVochure);
	AssertJUnit.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,7,EstimationVochure);
	log.info("Estimation is successfully validated to created Existing B2C Customer");
	fnWriteSteps("Pass","Estimation is Successfully Created for Existing B2C Customer");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Estimation_Creation_With_Existing_B2B_For_Order_Test() throws AWTException {
	GenericMethods.fnStartTestCase("validate_Estimation_Creation_With_Existing_B2B_For_Deletion_Test");
	log.info("EstimationCreation_With_ExistingCustomer_B2C Customer");
	int rowINdex=47;
	String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,0);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String strCustomer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,3);
	String Customertype=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,4);;
	String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,5);;
	String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,6);;
	String EstimationVochure=refEstimation.estimation_Creation_Page(strSalesOrderType, strProduct, field,
			strCustomer, Customertype, strFirstName, strPhoneNo);
	log.info("Estimation is Created Successfully forExisting  B2C Customer");
	boolean result=refEstimation.validate_Estimation_Creation(EstimationVochure);
	AssertJUnit.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,7,EstimationVochure);
	log.info("Estimation is successfully validated to created Existing B2C Customer");
	fnWriteSteps("Pass","Estimation is Successfully Created for Existing B2C Customer");
	GenericMethods.fnEndTestCase();
}
/*@Test
public void validate_Estimation_Conversion_Order_B2C_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_Conversion_Order_Test");
	log.info("Create Order from Estimation");
	int rowINdex=10;
	String strEstimationVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,0);
	
	String convertType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	
	String EditType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations",rowINdex ,3);
	String order=refEstimation.estimation_Conversion_Page(strEstimationVochure,HomeDelivery, convertType, strInstructions,EditType);
	log.info("Order is created successfully");
	boolean actual=refEstimation.validate_Estimation_Conversion(strEstimationVochure);
	Assert.assertTrue(actual);
	log.info("Successfully validated Estimation Converted to Order");
	fnWriteSteps("Pass","Order is created successfully");
	GenericMethods.fnEndTestCase();
	
}
@Test
public void validate_Estimation_Conversion_Invoice_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_Conversion_Invoice_Test");
	log.info("Create Invoice from Estimation");
	int rowINdex=11;
	String strEstimationVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,0);
	String convertType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String EditType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations",rowINdex ,3);
	String invoice=refEstimation.estimation_Conversion_Page(strEstimationVochure,HomeDelivery, convertType, strInstructions,EditType);
	log.info("Invoice is created successfully");
	boolean result=refEstimation.validate_Estimation_Conversion(strEstimationVochure);
	AssertJUnit.assertTrue(result);
	log.info("Successfully validated Estimation Converted to Invoice");
	fnWriteSteps("Pass","Invoice is created successfully");
	GenericMethods.fnEndTestCase();
	
 }*/
@Test 
public void validate_Estimation_Modification_IncreasingQuantity_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_Modification_IncreasingQuantity_Test");
	log.info("Modify Estimation by increasing Quantity");
	int rowIndex=15;
	String EstimationVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",1,7);
	String field =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowIndex ,1);
	String strquantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowIndex,2);
	String strProduct="NULL";
	boolean result=refEstimation.validate_Estimation_Modification(EstimationVochure, field, strquantity, strProduct);
	Assert.assertTrue(result);
	log.info("Successfully modified Estimation by increasing quantity");
	fnWriteSteps("Pass","Successfully modified estimation by increasing quantity");
	GenericMethods.fnEndTestCase();
	
}
@Test 
public void validate_Estimation_Modification_DecreasingQuantity_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_Modification_DecreasingQuantity_Test");
	log.info("Modify Estimation by decreasing Quantity");
	int rowIndex=16;
	String EstimationVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",1,7);
	String field =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowIndex ,1);
	String strquantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowIndex,2);
	String strProduct="NULL";
	boolean result=refEstimation.validate_Estimation_Modification(EstimationVochure, field, strquantity, strProduct);
	Assert.assertTrue(result);
	log.info("Successfully modified Estimation by decreasing quantity");
	fnWriteSteps("Pass","Successfully modified estimation by decreasing quantity");
	GenericMethods.fnEndTestCase();	
	
}
@Test 
public void validate_Estimation_Modification_AddingProduct_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_Modification_AddingProduct_Test");
	log.info("Modify Estimation by AddingProduct");
	int rowIndex=17;
	String EstimationVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",4,7);
	String field =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowIndex ,1);
	String strquantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowIndex,2);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowIndex,3);
	boolean result=refEstimation.validate_Estimation_Modification(EstimationVochure, field, strquantity, strProduct);
	Assert.assertTrue(result);
	log.info("Successfully modified Estimation by AddingProduct");
	fnWriteSteps("Pass","Successfully modified estimation by AddingProduct");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Modification_ByClicking_On_DeleteButton_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_Modification_ByClicking_On_DeleteButton_Test");
	log.info("Modify Estimation  By Clicking_On_DeleteButton");
	int rowIndex=18;
	String EstimationVochure = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",4,7);
	String field =ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowIndex ,1);
	String strquantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowIndex,2);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowIndex,3);
	boolean result=refEstimation.validate_Estimation_Modification(EstimationVochure, field, strquantity, strProduct);
	Assert.assertTrue(result);
	log.info("Successfully modified Estimation By Clicking On DeleteButton");
	fnWriteSteps("Pass","Successfully modified estimation By Clicking On DeleteButton");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Estimation_Creation_HomeDelivery_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_Creation_HomeDeleivery_Test");
	log.info("Create and validate Estimation Creation ");
	int rowINdex = 6;
	String strSalesOrderType= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex,0);
	String strProduct= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex,1);
	String Customertype= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex,4);
	String strFirstName= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex,5);
	String strPhoneNo= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex,6);
	String strDoorNo="7-7-7";
	String strStreetName= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex,9);
	String strArea= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex,10);
	String strZipcode= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex,11);
	String estimationVochure=refEstimation.estimation_Craetion_HomeDelievery(strSalesOrderType, strProduct, Customertype, strFirstName, strPhoneNo, strDoorNo,
			strStreetName, strArea, strZipcode);
	log.info("Successfully estimation is created");
	boolean actual=refEstimation.validate_Estimation_Creation(estimationVochure);
	Assert.assertTrue(actual);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,7,estimationVochure);
	log.info("Successfully validated created Estimation");
	fnWriteSteps("Pass","Successfully created and validated estimation");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Estimation_conversion_Order_WithoutCustomer_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_conversion_Order_WithoutCustomer_Test");
	log.info("Create Order from Estimation ");
	int rowINdex=23;
	String strEstimationVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",48 ,7);
	String HomeDelivery=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",11 ,0);
	String convertType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
    String EditType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations",rowINdex ,3);
	String order=refEstimation.estimation_Conversion_Page(strEstimationVochure,HomeDelivery, convertType, strInstructions,EditType);
	log.info("Order is created successfully");
	boolean actual=refEstimation.validate_Estimation_Conversion(strEstimationVochure);
	Assert.assertTrue(actual);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",53 ,1,order);
	log.info("Successfully validated Estimation Converted to Order for WithoutCustomer Customer");
	fnWriteSteps("Pass","Order is created successfully");
	GenericMethods.fnEndTestCase();
	
}
@Test 
public void validate_Estimation_Conversion_Order_RunTime_B2C_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_Conversion_Order_RunTime_B2C_Test");
	log.info("Create Order from Estimation for RunTime B2C Customer");
	int rowINdex=24;
	String strEstimationVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",44 ,7);
	String HomeDelivery=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",11 ,0);
	String convertType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
    String EditType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations",rowINdex ,3);
	String order=refEstimation.estimation_Conversion_Page(strEstimationVochure,HomeDelivery, convertType, strInstructions,EditType);
	log.info("Order is created successfully");
	boolean actual=refEstimation.validate_Estimation_Conversion(strEstimationVochure);
	Assert.assertTrue(actual);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",54 ,1,order);
	log.info("Successfully validated Estimation Converted to Order RunTime B2CCustomer");
	fnWriteSteps("Pass","Order is created successfully");
	GenericMethods.fnEndTestCase();	
}
@Test 
public void validate_Estimation_Conversion_Order_Runtime_B2B_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_Conversion_Order_Runtime_B2B_Test");
	log.info("Create Order from Estimation for RunTime B2B Customer");
	int rowINdex=24;
	String strEstimationVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",45 ,7);
	String HomeDelivery=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",11 ,0);
	String convertType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
    String EditType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations",rowINdex ,3);
	String order=refEstimation.estimation_Conversion_Page(strEstimationVochure,HomeDelivery, convertType, strInstructions,EditType);
	log.info("Order is created successfully");
	System.out.println(order);
	boolean actual=refEstimation.validate_Estimation_Conversion(strEstimationVochure);
	Assert.assertTrue(actual);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",55 ,1,order);
	log.info("Successfully validated Estimation Converted to Order RunTime B2B Customer");
	fnWriteSteps("Pass","Order is created successfully");
	GenericMethods.fnEndTestCase();	
	
}
@Test 
public void validate_Estimation_Conversion_Order_Existing_B2C_Cust_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_Conversion_Order_Existing_B2C_Cust_Test");
	log.info("Create Order from Estimation for Existing B2B Customer");
	int rowINdex=25;
	String strEstimationVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",46 ,7);
	String HomeDelivery=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",11 ,0);
	String convertType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
    String EditType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations",rowINdex ,3);
	String order=refEstimation.estimation_Conversion_Page(strEstimationVochure,HomeDelivery, convertType, strInstructions,EditType);
	log.info("Order is created successfully");
	boolean actual=refEstimation.validate_Estimation_Conversion(strEstimationVochure);
	Assert.assertTrue(actual);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", 56, 1, order);
	log.info("Successfully validated Estimation Converted to Order RunTime B2CCustomer");
	fnWriteSteps("Pass","Order is created successfully");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Estimation_Conversion_Order_Existing_B2B_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_Conversion_Order_Existing_B2B_Test");
	log.info("Create Order from Estimation for Existing B2B Customer");
	int rowINdex=25;
	String strEstimationVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",47 ,7);
	String HomeDelivery=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",11 ,0);
	String convertType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
    String EditType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations",rowINdex ,3);
	String order=refEstimation.estimation_Conversion_Page(strEstimationVochure,HomeDelivery, convertType, strInstructions,EditType);
	log.info("Order is created successfully");
	boolean actual=refEstimation.validate_Estimation_Conversion(strEstimationVochure);
	Assert.assertTrue(actual);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",57 ,1,order);
	log.info("Successfully validated Estimation Converted to Order RunTime B2CCustomer");
	fnWriteSteps("Pass","Order is created successfully");
	GenericMethods.fnEndTestCase();
	
}
@Test 
public void validate_Estimation_Conversion_Order_HomeDelievery_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_Conversion_Order_HomeDelievery_Test");
	log.info("Create Order from Estimation for Home Delievery Customer");
	int rowINdex=26;
	String strEstimationVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",7 ,7);
	String HomeDelivery=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",7 ,0);
	String convertType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
    String EditType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations",rowINdex ,3);
	String order=refEstimation.estimation_Conversion_Page(strEstimationVochure,HomeDelivery, convertType, strInstructions,EditType);
	log.info("Order is created successfully");
	boolean actual=refEstimation.validate_Estimation_Conversion(strEstimationVochure);
	Assert.assertTrue(actual);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",58 ,1,order);
	log.info("Successfully validated Estimation Converted to Order Home delievery Customer");
	fnWriteSteps("Pass","Order is created successfully");
	GenericMethods.fnEndTestCase();	
}
@Test 
public void validate_Estimation_Conversion_Invoice_Without_Customer_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_Conversion_Invoice_Without_Customer_Test");
	log.info("Create Invoice from Estimation");
	int rowINdex=11;
	String strEstimationVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",49 ,7);
	String HomeDelivery=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",11 ,0);
	String convertType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String EditType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations",rowINdex ,3);
	String invoice=refEstimation.estimation_Conversion_Page(strEstimationVochure,HomeDelivery, convertType, strInstructions,EditType);
	log.info("Invoice is created successfully");
	boolean result=refEstimation.validate_Estimation_Conversion(strEstimationVochure);
	Assert.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",53 ,2,invoice);
	log.info("Successfully validated Estimation Converted to Invoice");
	fnWriteSteps("Pass","Invoice is created successfully");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Estimation_Conversion_Invoice_Running_B2C_Cust_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_Conversion_Invoice_Running_B2C_Cust_Test");
	log.info("Create Invoice from Estimation");
	int rowINdex=11;
	String strEstimationVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",40 ,7);
	String HomeDelivery=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",11 ,0);
	String convertType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String EditType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations",rowINdex ,3);
	String invoice=refEstimation.estimation_Conversion_Page(strEstimationVochure,HomeDelivery, convertType, strInstructions,EditType);
	log.info("Invoice is created successfully");
	boolean result=refEstimation.validate_Estimation_Conversion(strEstimationVochure);
	Assert.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",54 ,2,invoice);
	log.info("Successfully validated Estimation Converted to Invoice");
	fnWriteSteps("Pass","Invoice is created successfully");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Estimation_Conversion_Invoice_Running_B2B_Cust_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_Conversion_Invoice_Running_B2B_Cust_Test");
	log.info("Create Invoice from Estimation");
	int rowINdex=11;
	String strEstimationVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",41 ,7);
	String HomeDelivery=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",11 ,0);
	String convertType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String EditType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations",rowINdex ,3);
	String invoice=refEstimation.estimation_Conversion_Page(strEstimationVochure,HomeDelivery, convertType, strInstructions,EditType);
	log.info("Invoice is created successfully");
	boolean result=refEstimation.validate_Estimation_Conversion(strEstimationVochure);
	Assert.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",55 ,2,invoice);
	log.info("Successfully validated Estimation Converted to Invoice");
	fnWriteSteps("Pass","Invoice is created successfully");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Estimation_Conversion_Invoice_Existing_B2C_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_Conversion_Invoice_Existing_B2B_Test");
	log.info("Create Invoice from Estimation");
	int rowINdex=11;
	String strEstimationVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",42 ,7);
	String HomeDelivery=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",11 ,0);
	String convertType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String EditType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations",rowINdex ,3);
	String invoice=refEstimation.estimation_Conversion_Page(strEstimationVochure,HomeDelivery, convertType, strInstructions,EditType);
	log.info("Invoice is created successfully");
	boolean result=refEstimation.validate_Estimation_Conversion(strEstimationVochure);
	Assert.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",56 ,2,invoice);
	log.info("Successfully validated Estimation Converted to Invoice");
	fnWriteSteps("Pass","Invoice is created successfully");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Estimation_Conversion_Invoice_Existing_B2B_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_Conversion_Invoice_Existing_B2B_Test");
	log.info("Create Invoice from Estimation");
	int rowINdex=11;
	String strEstimationVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",43 ,7);
	String HomeDelivery=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",11 ,0);
	String convertType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,1);
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",rowINdex ,2);
	String EditType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations",rowINdex ,3);
	String invoice=refEstimation.estimation_Conversion_Page(strEstimationVochure,HomeDelivery, convertType, strInstructions,EditType);
	log.info("Invoice is created successfully");
	boolean result=refEstimation.validate_Estimation_Conversion(strEstimationVochure);
	Assert.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",57,2,invoice);
	log.info("Successfully validated Estimation Converted to Invoice");
	fnWriteSteps("Pass","Invoice is created successfully");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Estimation_Modification_EstimationHistory_IncreasingQuantity_Test() throws FindFailed {
	GenericMethods.fnStartTestCase("validate_Estimation_Modification_EstimationHistory_IncreasingQuantity_Test");
	log.info("validate estimation modification from Estimation History");
	refEstimation.click_On_DashBoard();
	RefMenu.OpenPage("estimation history");
	int Rowindex=30;
	String strEstimation=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", 3,7);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", Rowindex,1);
	String strquantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", Rowindex,2);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", Rowindex,3);
	RefEstimationHistory.verifyEditFeature(strEstimation);
	boolean result=refEstimation.estimation_Modification_Estimation_History(field, strquantity, strProduct);
	Assert.assertTrue(result);
	refEstimation.click_On_DashBoard();
	driver.findElement(By.id("lblCaption")).click();
	RefEstimationHistory.clickCloseButton();
	RefMenu.OpenPage("estimation");
	log.info("Successfully modified Sales Estimation");
	fnWriteSteps("Pass", "Successfully modified estimation from Estimation History page");
	GenericMethods.fnEndTestCase();
	
	}
@Test 
public void validate_Estimation_Modification_EstimationHistory_DecreasingQuantity_Test() throws FindFailed {
	GenericMethods.fnStartTestCase("validate_Estimation_Modification_EstimationHistory_DecreasingQuantity_Test");
	log.info("validate estimation modification from Estimation History");
	refEstimation.click_On_DashBoard();
	RefMenu.OpenPage("estimation history");
	int Rowindex=31;
	String strEstimation=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", 3,7);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", Rowindex,1);
	String strquantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", Rowindex,2);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", Rowindex,3);
	RefEstimationHistory.verifyEditFeature(strEstimation);
	boolean result=refEstimation.estimation_Modification_Estimation_History(field, strquantity, strProduct);
	Assert.assertTrue(result);
	refEstimation.click_On_DashBoard();
	driver.findElement(By.id("lblCaption")).click();
	RefEstimationHistory.clickCloseButton();
	RefMenu.OpenPage("estimation");
	log.info("Successfully modified Sales Estimation");
	fnWriteSteps("Pass", "Successfully modified estimation from Estimation History page");
	GenericMethods.fnEndTestCase();
	
}
@Test 
public void validate_Estimation_Modification_EstimationHistory_AddProduct_Test() throws FindFailed {
	GenericMethods.fnStartTestCase("validate_Estimation_Modification_EstimationHistory_AddProduct_Test");
	log.info("validate estimation modification from Estimation History");
	refEstimation.click_On_DashBoard();
	RefMenu.OpenPage("estimation history");
	int Rowindex=32;
	String strEstimation=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", 3,7);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", Rowindex,1);
	String strquantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", Rowindex,2);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", Rowindex,3);
	RefEstimationHistory.verifyEditFeature(strEstimation);
	boolean result=refEstimation.estimation_Modification_Estimation_History(field, strquantity, strProduct);
	Assert.assertTrue(result);
	refEstimation.click_On_DashBoard();
	driver.findElement(By.id("lblCaption")).click();
	RefEstimationHistory.clickCloseButton();
	RefMenu.OpenPage("estimation");
	log.info("Successfully modified Sales Estimation");
	fnWriteSteps("Pass", "Successfully modified estimation from Estimation History page");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Estimation_Modification_EstimationHistory_ByRemovingProduct_Test() throws FindFailed {
	GenericMethods.fnStartTestCase("validate_Estimation_Modification_ByRemovingProduct_Test");
	log.info("validate estimation modification from Estimation History");
	refEstimation.click_On_DashBoard();
	RefMenu.OpenPage("estimation history");
	int Rowindex=33;
	String strEstimation=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", 3,7);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", Rowindex,1);
	String strquantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", Rowindex,2);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", Rowindex,3);
	RefEstimationHistory.verifyEditFeature(strEstimation);
	//driver.findElement(By.id("btnOk")).click();
	boolean result=refEstimation.estimation_Modification_Estimation_History(field, strquantity, strProduct);
	Assert.assertTrue(result);
	refEstimation.click_On_DashBoard();
	driver.findElement(By.id("lblCaption")).click();
	RefEstimationHistory.clickCloseButton();
	RefMenu.OpenPage("estimation");
	log.info("Successfully modified Sales Estimation");
	fnWriteSteps("Pass", "Successfully modified estimation from Estimation History page");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Estimation_Modification_EstimationHistory_HomeDelivery() throws FindFailed {
	GenericMethods.fnStartTestCase("validate_Estimation_Modification_EstimationHistory_HomeDelivery");
	log.info("validate estimation modification from Estimation History");
	refEstimation.click_On_DashBoard();
	RefMenu.OpenPage("estimation history");
	int Rowindex=34;
	String strEstimation=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", 6,7);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", Rowindex,1);
	String strquantity=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", Rowindex,2);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "EStimations", Rowindex,3);
	RefEstimationHistory.verifyEditFeature(strEstimation);
	boolean result=refEstimation.estimation_Modification_Estimation_History(field, strquantity, strProduct);
	Assert.assertTrue(result);
	refEstimation.click_On_DashBoard();
	driver.findElement(By.id("lblCaption")).click();
	RefEstimationHistory.clickCloseButton();
	RefMenu.OpenPage("estimation");
	log.info("Successfully modified Sales Estimation");
	fnWriteSteps("Pass", "Successfully modified estimation from Estimation History page");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Estimation_Modification_For_Converted_Order_Test() {
	GenericMethods.fnStartTestCase("validate_Estimation_Modification_For_Converted_Order_Test");
	log.info("********Estimation Vochure Modification*********");
	refEstimation.click_On_DashBoard();
	RefMenu.OpenPage("estimation history");
    String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations", 48,7);
	boolean result=refEStimationHistory.validate_Estimation_Converted_To_Order_Invoice_Modification(vochure);
	Assert.assertTrue(result);
	RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("estimation");
	log.info("********Estimation Vochure Modification*********");
	fnWriteSteps("Pass", "Successfully validated Estimation converted to sales order");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_SalesEstimation_Modification_ConvertedTo_SalesInvoice() {
	GenericMethods.fnStartTestCase("validate_SalesEstimation_Modification_ConvertedTo_SalesInvoice");
	log.info("********Estimation Vochure Modification*********");
	refEstimation.click_On_DashBoard();
	RefMenu.OpenPage("estimation history");
	String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations", 49,7);
	boolean result=refEStimationHistory.validate_Estimation_Converted_To_Order_Invoice_Modification(vochure);
	Assert.assertTrue(result);
	RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("estimation");
	log.info("********Estimation Vochure Modification*********");
	fnWriteSteps("Pass", "Successfully validated Estimation converted to sales order");
	GenericMethods.fnEndTestCase();
	}
@Test 
public void validate_Sales_Estimation_Deletion_Without_Customer_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Estimation_Deletion_Without_Customer");
	log.info("*********Sales Estimation Deletion******");
	refEstimation.click_On_DashBoard();
	RefMenu.OpenPage("estimation history");
	String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations", 1,7);
	String strRemarks=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations", 18,1);
	String internet = "NULL";
	boolean result=RefEstimationHistory.document_History_Deletion(vochure, strRemarks,internet);
	Assert.assertTrue(result);
	RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("estimation");
	log.info("*********Sales Estimation Deletion******");
	fnWriteSteps("Pass", "Sales Estimation Deletion");
	GenericMethods.fnEndTestCase();
	
}
@Test 
public void validate_Sales_Estimation_Deletion_B2C_Customer_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Estimation_Deletion_B2C_Customer_Test");
	log.info("*********Sales Estimation Deletion******");
	refEstimation.click_On_DashBoard();
	RefMenu.OpenPage("estimation history");
	String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations", 5,7);
	String strRemarks=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations", 18,1);
	String internet = "NULL";
	boolean result=RefEstimationHistory.document_History_Deletion(vochure, strRemarks,internet);
	Assert.assertTrue(result);
	RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("estimation");
	log.info("*********Sales Estimation Deletion******");
	fnWriteSteps("Pass", "Sales Estimation Deletion");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Sales_Estimation_Deletion_B2B_Customer_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Estimation_Deletion_B2B_Customer_Test");
	log.info("*********Sales Estimation Deletion******");
	refEstimation.click_On_DashBoard();
	RefMenu.OpenPage("estimation history");
	String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",4,7);
	String strRemarks=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations", 18,1);
	String internet = "NULL";
	boolean result=RefEstimationHistory.document_History_Deletion(vochure, strRemarks,internet);
	Assert.assertTrue(result);
	RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("estimation");
	log.info("*********Sales Estimation Deletion******");
	fnWriteSteps("Pass", "Sales Estimation Deletion");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Sales_Estimation_Deletion_Home_Delivery_Cust_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Estimation_Deletion_Home_Delivery_Cust_Test");
	log.info("*********Sales Estimation Deletion******");
	refEstimation.click_On_DashBoard();
	RefMenu.OpenPage("estimation history");
	String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations", 6,7);
	String strRemarks=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations", 18,1);
	String internet ="NULL";
	boolean result=RefEstimationHistory.document_History_Deletion(vochure, strRemarks,internet);
	Assert.assertTrue(result);
	RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("estimation");
	log.info("*********Sales Estimation Deletion******");
	fnWriteSteps("Pass", "Sales Estimation Deletion");
	GenericMethods.fnEndTestCase();
}
@Test 
public void validate_Sales_Estimation_Deletion_For_Converted_Sales_Order_Test() throws FindFailed {
	GenericMethods.fnStartTestCase("validate_Sales_Estimation_Deletion__For_Converted_Sales_Order_Test");
	log.info("**Sales Estimation Deletion************");
	refEstimation.click_On_DashBoard();
	RefMenu.OpenPage("estimation history");
	String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations", 48,7);
	boolean result=RefEstimationHistory.sales_Estimation_Deletion_Converted_Order_Invoice(vochure);
	Assert.assertTrue(result);
	RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("estimation");
	log.info("**Sales Estimation Deletion************");
	fnWriteSteps("Pass","Sales Estimation Deletion");
	GenericMethods.fnEndTestCase();	
}
@Test 
public void validate_Sales_Estimation_Deletion_For_Converted_Sales_Invoice_Test() throws FindFailed {
	GenericMethods.fnStartTestCase("validate_Sales_Estimation_Deketion_For_Converted_Sales_Invoice_Test");
	log.info("**Sales Estimation Deletion************");
	refEstimation.click_On_DashBoard();
	RefMenu.OpenPage("estimation history");
	String vochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations", 49,7);
	boolean result=RefEstimationHistory.sales_Estimation_Deletion_Converted_Order_Invoice(vochure);
	Assert.assertTrue(result);
	RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("estimation");
	log.info("**Sales Estimation Deletion************");
	fnWriteSteps("Pass","Sales Estimation Deletion");
	GenericMethods.fnEndTestCase();	
}





}
