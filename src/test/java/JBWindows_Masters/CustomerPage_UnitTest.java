package JBWindows_Masters;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.xml.DOMConfigurator;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.CRM.CRM_CustomerMaster;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class CustomerPage_UnitTest extends BaseClass {

	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	CRM_CustomerMaster refCustomerMaster;
	MessageBoxEffia refMessageBoxEffia;

	public CustomerPage_UnitTest() {
		super();
	}	
	
	@BeforeMethod
	public void fnBeforeMethod() throws InterruptedException {	
		GenericMethods.fnStartTestCase("fn Login and Open Page");
		DOMConfigurator.configure("log4j.xml");
		
		refLogin = new Login(driver);
		refDashboard = new APP_Dashboard(driver);
		refMenu = new APP_Menu(driver);
		refMessageBoxEffia = new MessageBoxEffia(driver);
		refCustomerMaster = new CRM_CustomerMaster();
		GenericMethods.fnwait(24);
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		refLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(10);
		refDashboard.clickMenuBtn();
		GenericMethods.fnwait(2);
		refMenu.OpenPage("Customers");
		fnWriteSteps("Pass", "Application open Successfully");
		GenericMethods.fnEndTestCase();

	}

	@Test 
	public void fnVerifyFieldVisibility_CustomerType_B2B() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Customer add entry are present or not ");
		
		refCustomerMaster.verifyFieldVisibility(1);	
		
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnVerifyFieldVisibilityCustomerType__B2C() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Customer add entry are present or not ");
		
		refCustomerMaster.verifyFieldVisibility(5);	
		
		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void fnVerifyFieldEnableOrNotCustomerType_B2B() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Customer add entry are enable or not");
		
		refCustomerMaster.verifyFieldEnableOrNot(1);
		
		GenericMethods.fnEndTestCase(); 
	}
	@Test 
	public void fnVerifyFieldEnableOrNotCustomerType_B2C() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Customer add entry are enable or not");
		
		refCustomerMaster.verifyFieldEnableOrNot(5);
		
		GenericMethods.fnEndTestCase(); 
	}
	@Test 
	public void fnActive_CustomerCreation_CustomerType_B2C(){
		GenericMethods.fnStartTestCase("Verify Active_B2C_Customer creation"); 
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Customers";
	    int RowNumber = 5;
	    String CustFirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String CustLastname = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String Customertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String PhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String AltPhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String DOB = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String Anniversary = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String DoorNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String StreetName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		String Pincode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
	    String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
		String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
		String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,14);
		String CreditLimit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,17);
	    String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,18);
	    String VATNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,21);
	    String GSTIN = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,22);
	    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,23);
		refCustomerMaster.createNewCustomer(CustFirstName,CustLastname,Customertype,PhoneNO,AltPhoneNO,Email,DOB,Anniversary,DoorNO,StreetName,Area,Pincode,State,City,Address,CreditDays,CreditLimit,VATNo,GSTIN,Inactive);
		boolean result = refCustomerMaster.Verify_NewCustomerCreation_SaveorNot(PhoneNO);
		Assert.assertTrue(result);
		fnWriteSteps("Pass","the Active_B2C_Customer record has been created & Saved" );
        GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnInActive_CustomerCreation_CustomerType_B2C(){
		GenericMethods.fnStartTestCase("Verify Inactive_B2C_Customer creation"); 
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Customers";
	    int RowNumber = 6;
	    String CustFirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String CustLastname = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String Customertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String PhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String AltPhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String DOB = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String Anniversary = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String DoorNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String StreetName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		String Pincode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
	    String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
		String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
		String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,14);
		String CreditLimit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,17);
	    String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,18);
	    String VATNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,21);
	    String GSTIN = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,22);
	    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,23);
		refCustomerMaster.createNewCustomer(CustFirstName,CustLastname,Customertype,PhoneNO,AltPhoneNO,Email,DOB,Anniversary,DoorNO,StreetName,Area,Pincode,State,City,Address,CreditDays,CreditLimit,VATNo,GSTIN,Inactive);
		boolean result = refCustomerMaster.Verify_NewCustomerCreation_SaveorNot(PhoneNO);
		Assert.assertTrue(result);
		fnWriteSteps("Pass","the Inactive_B2C_Customer record has been created & Saved" );
        GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnCustomerCreation_CustomerType_B2C(){
		GenericMethods.fnStartTestCase("Verify B2C_Customer creation"); 
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Customers";
	    int RowNumber = 7;
	    String CustFirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String CustLastname = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String Customertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String PhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String AltPhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String DOB = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String Anniversary = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String DoorNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String StreetName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		String Pincode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
	    String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
		String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
		String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,14);
		String CreditLimit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,17);
	    String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,18);
	    String VATNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,21);
	    String GSTIN = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,22);
	    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,23);
		refCustomerMaster.createNewCustomer(CustFirstName,CustLastname,Customertype,PhoneNO,AltPhoneNO,Email,DOB,Anniversary,DoorNO,StreetName,Area,Pincode,State,City,Address,CreditDays,CreditLimit,VATNo,GSTIN,Inactive);
		boolean result = refCustomerMaster.Verify_NewCustomerCreation_SaveorNot(PhoneNO);
		Assert.assertTrue(result);
		fnWriteSteps("Pass","the B2C_Customer record has been created & Saved" );
        GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnCustomerEdit_CustomerType_B2C() throws AWTException{
	
		GenericMethods.fnStartTestCase("Verify B2C_Customer Edit ");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Customers";
	    int RowNumber = 8;
	    String CustType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String OldCustPhno = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,19);
	    String CustFirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String CustLastName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String Phno = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
	    String DoorNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
	    String StreetName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
	    String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
	    String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
	    String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
	    String Pincode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
	    String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,14);
	    String DOB = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
	    String Anniversary = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
	    String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,18);
	    String CreditLimit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,17);
	    String VATNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,21);
	    String GSTIN = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,22);
	   refCustomerMaster.verifyEditCustomer(CustType,OldCustPhno,CustFirstName,CustLastName,Phno,Email,DoorNo,StreetName,State,City,Area,Pincode,Address,DOB,Anniversary,CreditDays,CreditLimit,VATNo,GSTIN);
	   boolean result = refCustomerMaster.Verify_EditCustomerCreation_SaveorNot(Phno);
	   Assert.assertTrue(result);
	   fnWriteSteps("Pass","the B2C_Customer records has been Updated & Saved" );
	   GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnCustomerCreation_CustomerType_B2C_For_WithoutInternet(){
		GenericMethods.fnStartTestCase("Verify B2C_Customer creation for withoutInternet"); 
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Customers";
	    int RowNumber = 10;
	    String CustFirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String CustLastname = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String Customertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String PhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String AltPhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String DOB = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String Anniversary = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String DoorNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String StreetName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		String Pincode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
	    String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
		String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
		String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,14);
		String CreditLimit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,17);
	    String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,18);
	    String VATNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,21);
	    String GSTIN = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,22);
	    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,23);
		refCustomerMaster.createNewCustomer(CustFirstName,CustLastname,Customertype,PhoneNO,AltPhoneNO,Email,DOB,Anniversary,DoorNO,StreetName,Area,Pincode,State,City,Address,CreditDays,CreditLimit,VATNo,GSTIN,Inactive);
		boolean result = refCustomerMaster.Verify_NewCustomerCreation_SaveorNot(PhoneNO);
		Assert.assertTrue(result);
		fnWriteSteps("Pass","the B2C_Customer record has been created & Saved" );
        GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void fnActive_CustomerCreation_CustomerType_B2B(){
		GenericMethods.fnStartTestCase("Verify Active_B2B_Customer creation"); 
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Customers";
	    int RowNumber = 1;
	    String CustFirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String CustLastname = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String Customertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String PhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String AltPhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String DOB = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String Anniversary = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
	    String DoorNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String StreetName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
	    String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		String Pincode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
		String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
		String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
		String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,14);
		String CreditLimit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,17);
		String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,18);
		String VATNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,21);
	    String GSTIN = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,22);
	    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,23);
		refCustomerMaster.createNewCustomer(CustFirstName,CustLastname,Customertype,PhoneNO,AltPhoneNO,Email,DOB,Anniversary,DoorNO,StreetName,Area,Pincode,State,City,Address,CreditDays,CreditLimit,VATNo,GSTIN,Inactive);
		boolean result = refCustomerMaster.Verify_NewCustomerCreation_SaveorNot(PhoneNO);
		Assert.assertTrue(result);
		fnWriteSteps("Pass","the Active_B2B_Customer records has been created & Saved" );
         GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnInActive_CustomerCreation_CustomerType_B2B(){
		GenericMethods.fnStartTestCase("Verify Inactive_B2B_Customer creation"); 
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Customers";
	    int RowNumber = 2;
	    String CustFirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String CustLastname = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String Customertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String PhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String AltPhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String DOB = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String Anniversary = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
	    String DoorNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String StreetName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
	    String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		String Pincode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
		String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
		String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
		String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,14);
		String CreditLimit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,17);
		String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,18);
		String VATNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,21);
	    String GSTIN = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,22);
	    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,23);
		refCustomerMaster.createNewCustomer(CustFirstName,CustLastname,Customertype,PhoneNO,AltPhoneNO,Email,DOB,Anniversary,DoorNO,StreetName,Area,Pincode,State,City,Address,CreditDays,CreditLimit,VATNo,GSTIN,Inactive);
		boolean result = refCustomerMaster.Verify_NewCustomerCreation_SaveorNot(PhoneNO);
		Assert.assertTrue(result);
	    fnWriteSteps("Pass","the Inactive_B2B_Customer records has been created & Saved" );
         GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void fnCustomerCreation_CustomerType_B2B(){
		GenericMethods.fnStartTestCase("Verify B2B_Customer creation"); 
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Customers";
	    int RowNumber = 3;
	    String CustFirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String CustLastname = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String Customertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String PhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String AltPhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String DOB = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String Anniversary = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
	    String DoorNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String StreetName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
	    String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		String Pincode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
		String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
		String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
		String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,14);
		String CreditLimit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,17);
		String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,18);
		String VATNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,21);
	    String GSTIN = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,22);
	    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,23);
		refCustomerMaster.createNewCustomer(CustFirstName,CustLastname,Customertype,PhoneNO,AltPhoneNO,Email,DOB,Anniversary,DoorNO,StreetName,Area,Pincode,State,City,Address,CreditDays,CreditLimit,VATNo,GSTIN,Inactive);
		boolean result = refCustomerMaster.Verify_NewCustomerCreation_SaveorNot(PhoneNO);
		Assert.assertTrue(result);
		fnWriteSteps("Pass","the B2B_Customer records has been created & Saved" );
         GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnCustomerEdit_CustomerType_B2B() throws AWTException{
	
		GenericMethods.fnStartTestCase("Verify B2B_Customer Edit ");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Customers";
	    int RowNumber = 4;
	    String CustType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String OldCustPhno = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,19);
	    String CustFirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String CustLastName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String Phno = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
	    String DoorNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
	    String StreetName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
	    String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
	    String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
	    String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
	    String Pincode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
	    String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,14);
	    String DOB = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
	    String Anniversary = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
	    String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,18);
	    String CreditLimit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,17);
	    String VATNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,21);
	    String GSTIN = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,22);
	   refCustomerMaster.verifyEditCustomer(CustType,OldCustPhno,CustFirstName,CustLastName,Phno,Email,DoorNo,StreetName,State,City,Area,Pincode,Address,DOB,Anniversary,CreditDays,CreditLimit,VATNo,GSTIN);
	   boolean result = refCustomerMaster.Verify_EditCustomerCreation_SaveorNot(Phno);
		Assert.assertTrue(result);
	   fnWriteSteps("Pass","the B2B_Customer records has been Updated & Saved" );
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnCustomerCreation_CustomerType_B2B_For_WithoutInternet(){
		GenericMethods.fnStartTestCase("Verify B2B_Customer creation for withoutInternet"); 
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Customers";
	    int RowNumber = 9;
	    String CustFirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String CustLastname = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String Customertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String PhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String AltPhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String DOB = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String Anniversary = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
	    String DoorNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String StreetName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
	    String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		String Pincode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
		String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
		String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
		String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,14);
		String CreditLimit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,17);
		String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,18);
		String VATNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,21);
	    String GSTIN = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,22);
	    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,23);
		refCustomerMaster.createNewCustomer(CustFirstName,CustLastname,Customertype,PhoneNO,AltPhoneNO,Email,DOB,Anniversary,DoorNO,StreetName,Area,Pincode,State,City,Address,CreditDays,CreditLimit,VATNo,GSTIN,Inactive);
		boolean result = refCustomerMaster.Verify_NewCustomerCreation_SaveorNot(PhoneNO);
		Assert.assertTrue(result);
		fnWriteSteps("Pass","the B2B_Customer records has been created & Saved" );
         GenericMethods.fnEndTestCase();
	}
	
	
	@Test 
	public void fnCustomerDelete_CustomerType_B2C() {
		GenericMethods.fnStartTestCase("Verify Delete CustomerType_B2C Feature");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Customers";
        int RowNumber = 8;
        String Customertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
        String PhonNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
        refCustomerMaster.fnVerifyCustomerDelete(PhonNo,Customertype);
        boolean result = refCustomerMaster.Verify_CustomerDelete_SaveorNot(PhonNo);
        Assert.assertTrue(result);
        fnWriteSteps("pass", "B2C_Customer has been Deleted");
    	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnActive_CustomerDelete_CustomerType_B2C() {
		GenericMethods.fnStartTestCase("Verify Delete Active CustomerType_B2C Feature");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Customers";
        int RowNumber = 5;
        String Customertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
        String PhonNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
        refCustomerMaster.fnVerifyCustomerDelete(PhonNo,Customertype);
        boolean result = refCustomerMaster.Verify_CustomerDelete_SaveorNot(PhonNo);
        Assert.assertTrue(result);
        fnWriteSteps("pass", "The Active B2C_Customer has been Deleted");
    	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnInActive_CustomerDelete_CustomerType_B2C() {
		GenericMethods.fnStartTestCase("Verify Delete Inactive CustomerType_B2C Feature");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Customers";
        int RowNumber = 6;
        String Customertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
        String PhonNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
        refCustomerMaster.fnVerifyCustomerDelete(PhonNo,Customertype);
        boolean result = refCustomerMaster.Verify_CustomerDelete_SaveorNot(PhonNo);
        Assert.assertTrue(result);
    	fnWriteSteps("pass", "The InActive B2C_Customer has been Deleted");
    	GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void fnCustomerDelete_CustomerType_B2B() {
		GenericMethods.fnStartTestCase("Verify Delete CustomerType_B2B Feature");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Customers";
        int RowNumber = 4;
        String Customertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
        String PhonNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
        refCustomerMaster.fnVerifyCustomerDelete(PhonNo,Customertype);
        boolean result = refCustomerMaster.Verify_CustomerDelete_SaveorNot(PhonNo);
        Assert.assertTrue(result);
    	fnWriteSteps("pass", "B2B_Customer has been Deleted");
    	GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void fnActive_CustomerDelete_CustomerType_B2B() {
		GenericMethods.fnStartTestCase("Verify Delete Active CustomerType_B2B Feature");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Customers";
        int RowNumber = 1;
        String Customertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
        String PhonNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
        refCustomerMaster.fnVerifyCustomerDelete(PhonNo,Customertype);
        boolean result = refCustomerMaster.Verify_CustomerDelete_SaveorNot(PhonNo);
        Assert.assertTrue(result);
    	fnWriteSteps("pass", "The Active B2B_Customer has been Deleted");
    	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnInActive_CustomerDelete_CustomerType_B2B() {
		GenericMethods.fnStartTestCase("Verify Delete Inactive CustomerType_B2B Feature");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Customers";
        int RowNumber = 2;
        String Customertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
        String PhonNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
        refCustomerMaster.fnVerifyCustomerDelete(PhonNo,Customertype);
        boolean result = refCustomerMaster.Verify_CustomerDelete_SaveorNot(PhonNo);
        Assert.assertTrue(result);
    	fnWriteSteps("pass", "The InActive B2B_Customer has been Deleted");
    	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnDelete_CustomerType_B2C_for_WithoutInternet() {
		GenericMethods.fnStartTestCase("Verify Delete CustomerType_B2C Feature for withoutInternet");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Customers";
        int RowNumber = 10;
        String Customertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
        String PhonNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
        refCustomerMaster.fnVerifyCustomerDelete(PhonNo,Customertype);
        refCustomerMaster.click_On_Yes_Button();
    	fnWriteSteps("pass", "B2C_Customer not Deleted");
    	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnDelete_CustomerType_B2B_for_WithoutInternet() {
		GenericMethods.fnStartTestCase("Verify Delete CustomerType_B2B Feature for withoutInternet");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Customers";
        int RowNumber = 9;
        String Customertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
        String PhonNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
        refCustomerMaster.fnVerifyCustomerDelete(PhonNo,Customertype);
        refCustomerMaster.click_On_Yes_Button();
    	fnWriteSteps("pass", "B2B_Customer not Deleted");
    	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnActive_CustomerCreation_CustomerType_B2C_for_CustomerDiscount(){
		GenericMethods.fnStartTestCase("Verify Active_B2C_Customer creation for CustomerDiscount"); 
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Customers";
	    int RowNumber = 21;
	    String CustFirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String CustLastname = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String Customertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String PhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String AltPhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String DOB = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String Anniversary = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String DoorNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String StreetName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		String Pincode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
	    String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
		String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
		String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,14);
		String CreditLimit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,17);
	    String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,18);
	    String VATNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,21);
	    String GSTIN = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,22);
	    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,23);
		refCustomerMaster.createNewCustomer(CustFirstName,CustLastname,Customertype,PhoneNO,AltPhoneNO,Email,DOB,Anniversary,DoorNO,StreetName,Area,Pincode,State,City,Address,CreditDays,CreditLimit,VATNo,GSTIN,Inactive);
		boolean result = refCustomerMaster.Verify_NewCustomerCreation_SaveorNot(PhoneNO);
		Assert.assertTrue(result);
		fnWriteSteps("Pass","the Active_B2C_Customer record has been created & Saved" );
        GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void fnActive_CustomerCreation_CustomerType_B2B_for_CustomerDiscount(){
		GenericMethods.fnStartTestCase("Verify Active_B2B_Customer creation for CustomerDiscount"); 
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Customers";
	    int RowNumber = 22;
	    String CustFirstName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String CustLastname = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String Customertype = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String PhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String AltPhoneNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String DOB = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String Anniversary = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
	    String DoorNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String StreetName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
	    String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		String Pincode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
		String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
		String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
		String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,14);
		String CreditLimit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,17);
		String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,18);
		String VATNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,21);
	    String GSTIN = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,22);
	    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,23);
		refCustomerMaster.createNewCustomer(CustFirstName,CustLastname,Customertype,PhoneNO,AltPhoneNO,Email,DOB,Anniversary,DoorNO,StreetName,Area,Pincode,State,City,Address,CreditDays,CreditLimit,VATNo,GSTIN,Inactive);
		boolean result = refCustomerMaster.Verify_NewCustomerCreation_SaveorNot(PhoneNO);
		Assert.assertTrue(result);
		fnWriteSteps("Pass","the Active_B2B_Customer records has been created & Saved" );
         GenericMethods.fnEndTestCase();
	}
	@Test 
	public void CustomerConsumer_DiscountType_Product_OnlyDiscountRule_Creation() throws FindFailed {
		GenericMethods.fnStartTestCase("Verify CustomerConsumer DiscountType_Product OnlyDiscountRule Creation");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Customers";
        int RowNumber =14;
        String CustType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
        String CustName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
        String DRS = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
        String Product1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        String DRs = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
        String DRs1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
        String SchemeDR = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
        String SchemeDR1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
        refCustomerMaster.fnVerifyMultiDiscount_Creation(CustType,CustName,DRS,Product1,DRs,DRs1,SchemeDR,SchemeDR1);
        boolean result = refCustomerMaster.Verify_MultiDiscountCreation_SaveorNot(Product1);
        Assert.assertTrue(result);
        refCustomerMaster.clickCloseButton();
        fnWriteSteps("pass", "CustomerConsumer DiscountType Product OnlyDiscountRule record has been Created & Saved");
    	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void CustomerConsumer_DiscountType_Product_Scheme_DiscountRule_Creation() throws FindFailed {
		GenericMethods.fnStartTestCase("Verify CustomerConsumer DiscountType_Product Scheme DiscountRule Creation");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Customers";
        int RowNumber =15;
        String CustType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
        String CustName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
        String DRS = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
        String Product1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        String DRs = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
        String DRs1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
        String SchemeDR = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
        String SchemeDR1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
        refCustomerMaster.fnVerifyMultiDiscount_Creation(CustType,CustName,DRS,Product1,DRs,DRs1,SchemeDR,SchemeDR1);
        boolean result = refCustomerMaster.Verify_MultiDiscountCreation_SaveorNot(Product1);
        Assert.assertTrue(result);
        refCustomerMaster.clickCloseButton();
        fnWriteSteps("pass", "CustomerConsumer DiscountType Product Scheme DiscountRule record has been Created & Saved");
    	GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void CustomerCorporate_DiscountType_Product_OnlyDiscountRule_Creation() throws FindFailed {
		GenericMethods.fnStartTestCase("Verify CustomerCorporate DiscountType_Product OnlyDiscountRule Creation");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Customers";
        int RowNumber =16;
        String CustType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
        String CustName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
        String DRS = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
        String Product1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        String DRs = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
        String DRs1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
        String SchemeDR = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
        String SchemeDR1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
        refCustomerMaster.fnVerifyMultiDiscount_Creation(CustType,CustName,DRS,Product1,DRs,DRs1,SchemeDR,SchemeDR1);
        boolean result = refCustomerMaster.Verify_MultiDiscountCreation_SaveorNot(Product1);
        Assert.assertTrue(result);
        refCustomerMaster.clickCloseButton();
        fnWriteSteps("pass", "CustomerCorporate DiscountType Product OnlyDiscountRule record has been Created & Saved");
    	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void CustomerCorporate_DiscountType_Product_Scheme_DiscountRule_Creation() throws FindFailed {
		GenericMethods.fnStartTestCase("Verify CustomerCorporate DiscountType_Product Scheme DiscountRule Creation");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Customers";
        int RowNumber =17;
        String CustType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
        String CustName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
        String DRS = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
        String Product1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        String DRs = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
        String DRs1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
        String SchemeDR = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
        String SchemeDR1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
        refCustomerMaster.fnVerifyMultiDiscount_Creation(CustType,CustName,DRS,Product1,DRs,DRs1,SchemeDR,SchemeDR1);
        boolean result = refCustomerMaster.Verify_MultiDiscountCreation_SaveorNot(Product1);
        Assert.assertTrue(result);
        refCustomerMaster.clickCloseButton();
        fnWriteSteps("pass", "CustomerCorporate DiscountType Product SchemeDiscountRule record has been Created & Saved");
    	GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void fnCustomerDiscount_Deletion_BeforeAnyTransaction() throws FindFailed {
		GenericMethods.fnStartTestCase("fnCustomerDiscount Deletion BeforeAnyTransaction");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Customers";
        int RowNumber = 17;
        String CustType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
        String CustName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
        String ProductNmae = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        refCustomerMaster.fnVerifyCustomerDiscount_Deletion(CustType,CustName,ProductNmae);
        refCustomerMaster.click_On_Yes_Button();
        boolean result = refCustomerMaster.Verify_CustomerDiscount_Delete_SaveorNot(ProductNmae);
        Assert.assertTrue(result);
        refCustomerMaster.clickCloseButton();
    	fnWriteSteps("pass", "Before Any transaction CustomerDiscount has been Deleted");
    	GenericMethods.fnEndTestCase();
	}
	
	@AfterMethod
	public void fnAfterMethod() {
		GenericMethods.fnStartTestCase("fn Logout");
		refCustomerMaster.clickCloseButton();		
		GenericMethods.fnwait(2);
		refDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		refMessageBoxEffia.ExitApplication_Yes();
		GenericMethods.fnwait(5);
		refLogin.ClickCloseButton();
		fnWriteSteps("Pass", "Application Close Successfully");
		GenericMethods.fnEndTestCase();
}

}
